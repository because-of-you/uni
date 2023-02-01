package cn.acitrus.uni.bean.auditing;

import lombok.NonNull;

import java.util.Optional;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 **/
public class AuditorAware implements org.springframework.data.domain.AuditorAware<String> {
    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        return Optional.of("uni");
    }
}