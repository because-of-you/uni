package cn.acitrus.common.nodes.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.neo4j.cypherdsl.core.Neo4jVersion;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.DateString;

import java.util.Date;

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
public abstract class AbstractUniNode extends AbstractUniSimpleNode {
    @CreatedDate
    @Property
    @DateString(format = "yyyy-MM-dd HH:mm:ss", zoneId = "Asia/Shanghai")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    public Date createdDate;

    @CreatedBy
    @Property
    public String createBy;

    @LastModifiedDate
    @Property
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @DateString(format = "yyyy-MM-dd HH:mm:ss", zoneId = "Asia/Shanghai")
    public Date lastModifiedDate;

    @Property
    @LastModifiedBy
    public String lastModifiedBy;

    @Property
    @Version
    public Integer version;
}
