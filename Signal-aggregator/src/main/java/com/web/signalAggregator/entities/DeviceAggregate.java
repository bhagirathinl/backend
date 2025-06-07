package com.web.signalAggregator.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device_aggregates")
public class DeviceAggregate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "wifi_on", nullable = false)
    private boolean wifiOn;

    @Column(length = 255)
    private String emulator;

    @Column(length = 255, nullable = false)
    private String product;

    @Column(nullable = false)
    private long count;

    @Column
    private Boolean debugger;
    
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public DeviceAggregate() {}

    public DeviceAggregate(boolean wifiOn, String emulator, String product, long count, Boolean debugger) {
        this.wifiOn = wifiOn;
        this.emulator = emulator;
        this.product = product;
        this.count = count;
        this.debugger = debugger;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isWifiOn() {
        return wifiOn;
    }

    public void setWifiOn(boolean wifiOn) {
        this.wifiOn = wifiOn;
    }

    public String getEmulator() {
        return emulator;
    }

    public void setEmulator(String emulator) {
        this.emulator = emulator;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Boolean getDebugger() {
        return debugger;
    }

    public void setDebugger(Boolean debugger) {
        this.debugger = debugger;
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
}
