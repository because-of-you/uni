package cn.acitrus.repository.connectors;

import cn.acitrus.common.entities.connector.ConnectorEntity;
import cn.acitrus.transfer.projection.connector.ConnectorEntityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConnectorEntityRepository extends JpaRepository<ConnectorEntity, UUID> {
    List<ConnectorEntityInfo> findAllByConnectionIsNotNull();
}