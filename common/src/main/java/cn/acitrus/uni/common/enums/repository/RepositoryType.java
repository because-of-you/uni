package cn.acitrus.uni.common.enums.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/29
 * <a href="https://www.baeldung.com/jpa-persisting-enums-in-jpa">枚举类型转换参考链接</a>
 **/
@AllArgsConstructor
@Getter
public enum RepositoryType implements Serializable {
    /**
     * neo4j
     */
    NEO4J("neo4j"),
    /**
     * redis
     */
    REDIS("redis");
    private final String type;
}
