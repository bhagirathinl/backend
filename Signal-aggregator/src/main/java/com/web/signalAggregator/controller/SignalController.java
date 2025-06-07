package com.web.signalAggregator.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.signalAggregator.entities.DeviceAggregate;
import com.web.signalAggregator.model.DeviceEvent;
import com.web.signalAggregator.service.DeviceAggregateService;
import com.web.signalAggregator.service.DeviceEventPublisher;

@RestController
@RequestMapping("/api")
public class SignalController {

    private final DeviceEventPublisher publisher;
    
    private final DeviceAggregateService service;

   
    public SignalController(DeviceEventPublisher publisher,DeviceAggregateService service) {
        this.publisher = publisher;
		this.service = service;
    }

   
    @PostMapping("/device-event")
    public ResponseEntity<String> receiveDeviceEvent(@RequestBody DeviceEvent deviceEvent) {
        System.out.println("Received device event: " + deviceEvent);
        publisher.publish(deviceEvent);
        return ResponseEntity.ok("Device event received and published to Kafka");
    }
    
    @GetMapping
    public List<DeviceAggregate> getAll() {
        return service.getAll();
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<DeviceAggregate> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
