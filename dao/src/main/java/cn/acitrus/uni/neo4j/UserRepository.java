package cn.acitrus.uni.neo4j;

import cn.acitrus.uni.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.support.CypherdslStatementExecutor;

import java.util.List;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
public interface UserRepository extends Neo4jRepository<User, UUID>, CypherdslStatementExecutor<User> {
    User findByName(String name);

}