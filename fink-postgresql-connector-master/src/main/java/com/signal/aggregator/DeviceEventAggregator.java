package com.signal.aggregator;

import java.time.Duration;
import java.util.Properties;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.connector.jdbc.JdbcStatementBuilder;
import org.apache.flink.connector.jdbc.sink.JdbcSink;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.model.DeviceEvent;

public class DeviceEventAggregator {
    private static final Logger log = LoggerFactory.getLogger(DeviceEventAggregator.class);
	
	  private static final String KAFKA_BROKERS_URL = "localhost:9092",
	            POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/mydatabase",
	            POSTGRESQL_USER = "myuser",
	            POSTGRESQL_PASSWORD = "mypassword",
	            TOPIC = "device_events",
	            INSERT_SQL = "INSERT INTO device_aggregates (debugger, wifi_on, emulator, product, count) VALUES ( ?, ?, ?, ?, ?)";
	            
	      public  static void main(String[] args) throws Exception {
			 StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
	         env.setParallelism(1);
	         
	         Properties props = new Properties();
	         props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS_URL);
	         props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "flink-device-consumer");
	         props.setProperty("auto.offset.reset", "earliest");
	    
	         
	         KafkaSource<DeviceEvent> kafkaSource = KafkaSource
	                 .<DeviceEvent>builder()
	                 .setTopics(TOPIC)  // Kafka topic name
	                 .setGroupId("flink-device-consumer1")
	                 .setProperties(props)
	                 .setStartingOffsets(OffsetsInitializer.earliest()) // Starting from the earliest
	                 .setDeserializer(new DeviceEventDeserializer())
	               .build();
	
	        DataStreamSource<DeviceEvent> deviceStream = env.fromSource(kafkaSource,  WatermarkStrategy.noWatermarks(), "Kafka Source");

	  
	
	        DataStream<DeviceAggregate> aggregated = deviceStream.keyBy(new DeviceEventKeySelector())
	                .map(event -> new DeviceAggregate(event.isWifiOn(), event.getEmulator(), event.getProduct(), event.isDebugger(), 1L))
	                .returns(DeviceAggregate.class)
	                .windowAll(TumblingProcessingTimeWindows.of(Duration.ofMinutes(1)))  // Proper windowing function for Flink 1.20
	                .reduce(new AggregateCount())
	                .name("Aggregate counts");
	
	       JdbcStatementBuilder<DeviceAggregate> stmtBuilder = (ps, event) -> {
	            event.getStatement(ps);
	        };
	    	  final var pgConnection = new JdbcConnectionOptions.JdbcConnectionOptionsBuilder().withDriverName("org.postgresql.Driver")
	                  .withUrl(POSTGRESQL_URL)
	                  .withUsername(POSTGRESQL_USER)
	                  .withPassword(POSTGRESQL_PASSWORD)
	                  .build();
	    	final var pgExecutionOptions = JdbcExecutionOptions.builder()
	                .withBatchSize(1000)
	                .withBatchIntervalMs(200)
	                .withMaxRetries(3)
	                .build();	
	        
	        JdbcSink<DeviceAggregate> sink = JdbcSink.<DeviceAggregate>builder()
	        		.withQueryStatement(
	        	    INSERT_SQL,
	        	    stmtBuilder). withExecutionOptions(pgExecutionOptions).buildAtLeastOnce(pgConnection);
	      
	        aggregated.sinkTo(sink);
	        
	        aggregated.print();
	       
	
	        env.execute("Flink 1.20 - Device Count Aggregator");
	    }
	  
	
	
}

