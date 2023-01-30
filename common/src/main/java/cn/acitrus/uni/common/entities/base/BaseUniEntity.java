package cn.acitrus.uni.common.entities.base;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/16
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseUniEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uni_uuid_generator")
    @GenericGenerator(name = "uni_uuid_generator", strategy = "cn.acitrus.uni.common.entities.base.UniIdGenerator")
    @Column(name = "id", nullable = false, updatable = false, length = 16)
    @Comment("主键id")
    @JdbcTypeCode(SqlTypes.BINARY)
    private UUID id;
}
