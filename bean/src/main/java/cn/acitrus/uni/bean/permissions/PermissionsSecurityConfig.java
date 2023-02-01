package cn.acitrus.uni.bean.permissions;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/31
 **/
@Configuration
@EnableMethodSecurity
public class PermissionsSecurityConfig {
    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @SneakyThrows()
    SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity
    ) {
        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests().anyRequest().authenticated().and().build();
    }
}
