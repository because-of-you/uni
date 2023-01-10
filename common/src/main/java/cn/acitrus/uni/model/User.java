package cn.acitrus.uni.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/10
 **/
@Data
@JsonNaming(value =  PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    @Id
    private String id;
    private String name;
}
