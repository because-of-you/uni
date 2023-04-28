package cn.acitrus.repository.config;

import cn.acitrus.common.entities.config.ConnectorEntity;
import cn.acitrus.transfer.projection.config.ConnectorEntityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConnectorEntityRepository extends JpaRepository<ConnectorEntity, UUID> {
    List<ConnectorEntityInfo> findAllByConnectionIsNotNull();
}