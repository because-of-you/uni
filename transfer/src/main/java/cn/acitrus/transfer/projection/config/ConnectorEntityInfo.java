package cn.acitrus.transfer.projection.config;

import cn.acitrus.common.entities.config.connection.Connection;

import java.util.UUID;

/**
 * A Projection for the {@link ConnectorEntity} entity
 */
public interface ConnectorEntityInfo {
    UUID getId();

    Integer getVersion();

    Connection getConnection();
}