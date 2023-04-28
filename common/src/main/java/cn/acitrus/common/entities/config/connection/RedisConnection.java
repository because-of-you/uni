package cn.acitrus.common.entities.config.connection;

import cn.acitrus.common.enums.permissions.ConnectorType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RedisConnection implements Connection {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private ConnectorType connectorType;
}
