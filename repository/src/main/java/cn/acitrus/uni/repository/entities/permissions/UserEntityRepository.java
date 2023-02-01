package cn.acitrus.uni.repository.entities.permissions;

import cn.acitrus.uni.common.entities.permissions.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/31
 **/
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
}
