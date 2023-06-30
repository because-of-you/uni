package cn.acitrus.web.config;

import jakarta.annotation.Nonnull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/28
 **/
@Configuration
public class AuditorAwareConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new UniAuditorAware();
    }

    public static class UniAuditorAware implements AuditorAware<String> {
        @Nonnull
        @Override
        public Optional<String> getCurrentAuditor() {
            return Optional.of("uni");
        }
    }
}
