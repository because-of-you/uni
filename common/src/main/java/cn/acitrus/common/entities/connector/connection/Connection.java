package cn.acitrus.common.entities.connector.connection;

import cn.acitrus.common.enums.permissions.ConnectorType;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/25
 **/
public interface Connection {
    /**
     * 获取连接器类型
     *
     * @return 返回具体的连接器类型
     */
    ConnectorType getConnectorType();
}
