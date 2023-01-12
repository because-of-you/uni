package cn.acitrus.uni.datasource.mysql;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import io.micrometer.core.instrument.step.StepRegistryConfig;
import io.micrometer.core.instrument.util.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@Slf4j
public class UniDataSourceMeterRegistry extends StepMeterRegistry {

    public UniDataSourceMeterRegistry() {
        this(UniDataSourceRegistryConfig.DEFAULT, Clock.SYSTEM);
    }

    public UniDataSourceMeterRegistry(StepRegistryConfig config, Clock clock) {
        super(config, clock);
        start(new NamedThreadFactory("uni-datasource-metrics-publisher"));
    }

    @Override
    protected void publish() {
        List<Meter> meters = getMeters().stream().toList();
        log.info("{}", meters);
    }

    @Override
    protected TimeUnit getBaseTimeUnit() {
        return TimeUnit.MILLISECONDS;
    }
}
