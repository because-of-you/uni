package cn.acitrus.uni.neo4j;

import cn.acitrus.uni.node.User;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
// , CypherdslStatementExecutor<User>
public interface UserRepository extends ReactiveNeo4jRepository<User, UUID> {
    /**
     * 通过name查找user
     *
     * @param name 用户名字
     * @return 用户实体
     */
    Mono<User> findByName(String name);

}