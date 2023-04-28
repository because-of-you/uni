package cn.acitrus.transfer.projection.connector;

import cn.acitrus.common.entities.connector.connection.Connection;

import java.util.UUID;

/**
 * A Projection for the {@link cn.acitrus.common.entities.connector.ConnectorEntity} entity
 */
public interface ConnectorEntityInfo {
    UUID getId();

    Integer getVersion();

    Connection getConnection();
}