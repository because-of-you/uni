package cn.acitrus.common.nodes;

import cn.acitrus.common.nodes.base.AbstractUniNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@org.springframework.data.neo4j.core.schema.Node
@Data
@EqualsAndHashCode(callSuper = true)
public class Node extends AbstractUniNode {
    @Property
    private String name;
}
