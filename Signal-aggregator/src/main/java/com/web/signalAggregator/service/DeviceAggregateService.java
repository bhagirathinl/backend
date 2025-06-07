package com.web.signalAggregator.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.web.signalAggregator.entities.DeviceAggregate;
import com.web.signalAggregator.repository.DeviceAggregateRepository;

@Service
public class DeviceAggregateService {

    private final DeviceAggregateRepository repository;

    public DeviceAggregateService(DeviceAggregateRepository repository) {
        this.repository = repository;
    }

    public List<DeviceAggregate> getAll() {
        return repository.findAll();
    }

    public Optional<DeviceAggregate> getById(Integer id) {
        return repository.findById(id);
    }

    public DeviceAggregate create(DeviceAggregate deviceAggregate) {
        return repository.save(deviceAggregate);
    }

    public DeviceAggregate update(Integer id, DeviceAggregate updatedData) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setWifiOn(updatedData.isWifiOn());
                    existing.setEmulator(updatedData.getEmulator());
                    existing.setProduct(updatedData.getProduct());
                    existing.setCount(updatedData.getCount());
                    existing.setDebugger(updatedData.getDebugger());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("DeviceAggregate not found with id: " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
