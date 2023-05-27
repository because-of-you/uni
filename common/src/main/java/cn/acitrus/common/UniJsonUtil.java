package cn.acitrus.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import lombok.SneakyThrows;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/25
 **/
public class UniJsonUtil {
    @SneakyThrows
    public static String toJson(Object target) {
        return getObjectMapperInstance().writeValueAsString(target);
    }

    @SneakyThrows
    public static <T> T convert(String json, Class<T> type) {
        return getObjectMapperInstance().readValue(json, type);
    }

    @Nonnull
    private static ObjectMapper getObjectMapperInstance() {
        return new ObjectMapper();
    }
}
