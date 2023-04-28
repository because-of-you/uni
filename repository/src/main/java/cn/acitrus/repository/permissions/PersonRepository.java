package cn.acitrus.repository.permissions;

import cn.acitrus.common.nodes.permissions.Person;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/27
 **/
@Repository
public interface PersonRepository extends ReactiveNeo4jRepository<Person, UUID> {
    /**
     * 通过名称找实体
     *
     * @param name 名称
     * @return 实体
     */
    Mono<Person> findFirstByName(String name);
}
