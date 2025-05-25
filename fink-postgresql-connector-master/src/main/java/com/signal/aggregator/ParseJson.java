package com.signal.aggregator;

import org.apache.flink.api.common.functions.MapFunction;

import com.don.model.DeviceEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJson implements MapFunction<String, DeviceEvent> {
        private static final long serialVersionUID = 925588488043049482L;
		private final ObjectMapper mapper = new ObjectMapper();

        @Override
        public DeviceEvent map(String value) throws Exception {
            return mapper.readValue(value, DeviceEvent.class);
        }
    }

    