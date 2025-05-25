package com.signal.aggregator;
import java.io.IOException;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.connector.kafka.source.reader.deserializer.KafkaRecordDeserializationSchema;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.don.model.DeviceEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeviceEventDeserializer implements KafkaRecordDeserializationSchema<DeviceEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

   

    @Override
    public TypeInformation<DeviceEvent> getProducedType() {
        return TypeInformation.of(DeviceEvent.class);  // Return the type information for DeviceEvent
    }

	@Override
	public void deserialize(ConsumerRecord<byte[], byte[]> record, Collector<DeviceEvent> out) throws IOException {
		
		 try {
	            // Convert the Kafka message (byte[]) to a String
	            String json = new String(record.value());
	            //System.out.println(json);

	            // Deserialize JSON into a DeviceEvent object
	            DeviceEvent deviceEvent = objectMapper.readValue(json, DeviceEvent.class);

	            // Emit the deserialized object to the downstream operators
	            out.collect(deviceEvent);
	        } catch (Exception e) {
	            // Log or handle the exception, depending on your error-handling strategy
	            e.printStackTrace();
	        }
		
	}
}