package cn.acitrus.common.entities.compose;

import cn.acitrus.common.entities.base.AbstractUniEntity;
import cn.acitrus.common.enums.compose.NetworkDriver;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
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
@Table(name = "compose_network")
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Network extends AbstractUniEntity {
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.ORDINAL)
    private NetworkDriver driver;
    @Column
    private String scope;
}
