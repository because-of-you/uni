package cn.acitrus.uni.repository.nodes;

import cn.acitrus.uni.common.nodes.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
public interface NodeRepository extends Neo4jRepository<Node, UUID> {
}
