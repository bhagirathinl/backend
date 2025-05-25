package com.don.simulator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.don.model.DeviceEvent;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventSimulator {

	private static final Logger log = LoggerFactory.getLogger(EventSimulator.class);

	public static void main(String[] args) throws InterruptedException {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

		props.put("schema.registry.url", "http://localhost:8081");

		String jsonFilePath = "src/main/resources/DeviceData2.json";

		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			File jsonFile = new File(jsonFilePath);
			List<DeviceEvent> deviceEvents = objectMapper.readValue(new File(jsonFilePath), objectMapper.getTypeFactory().constructCollectionType(List.class, DeviceEvent.class));


			// Try reading as array first
			for (DeviceEvent deviceEvent : deviceEvents) {
				//DeviceEvent message = objectMapper.treeToValue(node, DeviceEvent.class);
				String message = objectMapper.writeValueAsString(deviceEvent);
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("device_events", message);
				producer.send(record);
				System.out.println("Sent: " + message);
				Thread.sleep(2000);
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			producer.flush();
			producer.close();
		}
	}
}

