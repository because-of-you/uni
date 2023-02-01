package cn.acitrus.uni.bean.auditing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 **/
@Configuration
@EnableJpaAuditing
@EnableNeo4jAuditing
public class AuditingConfig {
    @Bean
    public org.springframework.data.domain.AuditorAware<String> auditorProvider() {
        return new AuditorAware();
    }
}
