package com.signal.aggregator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class DeviceAggregate {
        public boolean wifiOn;
        public String emulator;
        public String product;
        public boolean debugger;
        public long count;

        public DeviceAggregate() {}

        public DeviceAggregate(boolean isWifiOn, String emulator, String product, boolean debugger, long count) {
            this.wifiOn = isWifiOn;
            this.emulator = emulator;
            this.product = product;
            this.debugger = debugger;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("[WiFi: %s, emulator: %s, Product: %s, debugger: %s] => Count: %d",
                    wifiOn, emulator, product, debugger, count);
        }
        
        public void getStatement(PreparedStatement ps) throws SQLException {
        	ps.setBoolean(1, this.debugger);
            ps.setBoolean(2, this.wifiOn);
            ps.setString(3, this.emulator);
            ps.setString(4, this.product);
            ps.setLong(5, this.count);
        }
    }