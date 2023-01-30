package cn.acitrus.uni.common.nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@org.springframework.data.neo4j.core.schema.Node
public class Node {
    @Id
    @GeneratedValue
    private Long id;
    @Property
    private String name;
}
