package cn.acitrus.repository;

import cn.acitrus.common.entities.config.RepositoryConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryConfigEntityRepository extends JpaRepository<RepositoryConfigEntity, UUID> {
}