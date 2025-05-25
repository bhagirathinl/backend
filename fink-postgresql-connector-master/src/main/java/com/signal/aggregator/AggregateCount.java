package com.signal.aggregator;

import org.apache.flink.api.common.functions.ReduceFunction;

public class AggregateCount implements ReduceFunction<DeviceAggregate> {
        private static final long serialVersionUID = 4329982998307011138L;

		@Override
        public DeviceAggregate reduce(DeviceAggregate a, DeviceAggregate b) {
            a.count += b.count;
            return a;
        }
    }
