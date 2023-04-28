package cn.acitrus.common.enums.permissions;

import cn.acitrus.common.entities.connector.connection.Connection;
import cn.acitrus.common.entities.connector.connection.DefaultConnection;
import cn.acitrus.common.entities.connector.connection.Neo4jConnection;
import cn.acitrus.common.entities.connector.connection.RedisConnection;
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
public enum ConnectorType implements Serializable {
    /**
     * neo4j
     */
    NEO4J("neo4j", Neo4jConnection.class),
    DEFAULT("default", DefaultConnection.class),
    /**
     * redis
     */
    REDIS("redis", RedisConnection.class);
    private final String name;
    private final Class<? extends Connection> type;
}
