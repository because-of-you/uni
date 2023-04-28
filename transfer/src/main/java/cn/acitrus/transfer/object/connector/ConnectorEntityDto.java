package cn.acitrus.transfer.object.connector;

import cn.acitrus.common.entities.connector.connection.Connection;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link cn.acitrus.common.entities.connector.ConnectorEntity} entity
 */
public record ConnectorEntityDto(UUID id, Integer version, Connection connection) implements Serializable {
}