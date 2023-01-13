package cn.acitrus.uni.mysql;

import cn.acitrus.uni.entity.Neo4jAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/12
 **/
@Repository
public interface Neo4jAuthenticationRepository extends JpaRepository<Neo4jAuthentication, String> {
}
