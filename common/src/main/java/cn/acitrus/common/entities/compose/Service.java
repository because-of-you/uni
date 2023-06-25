package cn.acitrus.common.entities.compose;

import cn.acitrus.common.entities.base.AbstractUniEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/6/25
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "compose_service")
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Service extends AbstractUniEntity {
    /**
     * project 项目
     */
    @Column
    private String project;
    /**
     * 项目下面所属的service name
     */
    @Column
    private String name;
    /**
     * 服务镜像
     */
    @Column
    private String image;
    /**
     * 副本数
     */
    @Column
    private Integer replicas;
}
