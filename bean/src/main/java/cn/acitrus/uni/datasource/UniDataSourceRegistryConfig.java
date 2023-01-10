package cn.acitrus.uni.datasource;

import io.micrometer.core.instrument.step.StepRegistryConfig;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
public interface UniDataSourceRegistryConfig extends StepRegistryConfig {
    UniDataSourceRegistryConfig DEFAULT = k -> null;

    /**
     * 前缀
     *
     * @return 字符串
     */
    @Override
    default String prefix() {
        return "uni";
    }

}
