package cn.acitrus.common.nodes.permissions;

import cn.acitrus.common.nodes.base.AbstractUniNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/27
 **/
@Node
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Person extends AbstractUniNode {
    @Property
    private String name;
    @Property
    private Integer age;
}
