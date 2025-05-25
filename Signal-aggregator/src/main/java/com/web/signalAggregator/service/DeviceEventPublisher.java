package com.web.signalAggregator.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.web.signalAggregator.model.DeviceEvent;

@Service
public class DeviceEventPublisher {

    private static final String TOPIC = "device_events";

    @Autowired
    private KafkaTemplate<String, DeviceEvent> kafkaTemplate;

    public void publish(DeviceEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Published event to Kafka: " + event);
    }
}