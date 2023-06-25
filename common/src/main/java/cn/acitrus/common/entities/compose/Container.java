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
@Table(name = "compose_container")
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Container extends AbstractUniEntity {
    /**
     * 容器名
     */
    @Column(unique = true)
    private String name;
    /**
     * 所属网络id
     */
    @Column
    private String networkId;

    // todo 所属服务id

    /**
     * 容器的状态
     */
    @Column
    private String status;

}
