package com.web.signalAggregator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.signalAggregator.model.DeviceEvent;
import com.web.signalAggregator.service.DeviceEventPublisher;

@RestController
@RequestMapping("/api")
public class SignalController {

    private final DeviceEventPublisher publisher;

   
    public SignalController(DeviceEventPublisher publisher) {
        this.publisher = publisher;
    }

   
    @PostMapping("/device-event")
    public ResponseEntity<String> receiveDeviceEvent(@RequestBody DeviceEvent deviceEvent) {
        System.out.println("Received device event: " + deviceEvent);
        publisher.publish(deviceEvent);
        return ResponseEntity.ok("Device event received and published to Kafka");
    }
}
