package cn.acitrus.common.nodes.base;

import cn.acitrus.common.generator.UniIdGenerator;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serializable;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/30
 **/
@Node
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class AbstractUniSimpleNode implements Serializable {
    @Id
    @GeneratedValue(generatorClass = UniIdGenerator.class)
    private UUID id;
}
