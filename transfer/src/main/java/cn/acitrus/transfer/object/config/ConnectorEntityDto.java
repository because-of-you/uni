package cn.acitrus.transfer.object.config;

import cn.acitrus.common.entities.config.connection.Connection;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link cn.acitrus.common.entities.config.ConnectorEntity} entity
 */
public record ConnectorEntityDto(UUID id, Integer version, Connection connection) implements Serializable {
}