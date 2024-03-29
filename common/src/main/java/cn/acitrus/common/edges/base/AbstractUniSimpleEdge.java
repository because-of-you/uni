package cn.acitrus.common.edges.base;

import cn.acitrus.common.generator.UniIdGenerator;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.io.Serializable;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/30
 **/
@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@RelationshipProperties
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class AbstractUniSimpleEdge implements Serializable {
    @RelationshipId
    @GeneratedValue(generatorClass = UniIdGenerator.class)
    private UUID id;
}
