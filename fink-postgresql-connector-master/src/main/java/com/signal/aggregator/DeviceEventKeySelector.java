package com.signal.aggregator;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple4;
import com.don.model.DeviceEvent;

public class DeviceEventKeySelector implements KeySelector<DeviceEvent, Tuple4<Boolean, String, String, Boolean>> {

    private static final long serialVersionUID = 8060815899937360814L;

	@Override
    public Tuple4<Boolean, String, String, Boolean> getKey(DeviceEvent event) {
        return Tuple4.of(
            event.isWifiOn(),
            event.getEmulator(),      // maps to `emulator`
            event.getProduct(),
            event.isDebugger()
        );
    }
}