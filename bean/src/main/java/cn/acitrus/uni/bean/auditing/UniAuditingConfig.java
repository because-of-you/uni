package cn.acitrus.uni.bean.auditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 **/
@Configuration
@EnableJpaAuditing
public class UniAuditingConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new UniAuditorAware();
    }
}
