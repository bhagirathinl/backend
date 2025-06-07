package com.web.signalAggregator.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.signalAggregator.entities.DeviceAggregate;

@Repository
public interface DeviceAggregateRepository extends JpaRepository<DeviceAggregate, Integer> {
    // Add custom queries if needed
}