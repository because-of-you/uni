package cn.acitrus.common.edges.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import java.util.Date;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/30
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@RelationshipProperties
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class AbstractUniEdge extends AbstractUniSimpleEdge{
    @CreatedDate
    @Property
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date createdDate;

    @CreatedBy
    @Property
    public String createBy;

    @LastModifiedDate
    @Property
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date lastModifiedDate;

    @Property
    @LastModifiedBy
    public String lastModifiedBy;

    @Version
    @Property
    public Integer version;
}
