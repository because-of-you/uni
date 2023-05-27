package cn.acitrus.common.entities.connector;

import cn.acitrus.common.entities.base.AbstractUniEntity;
import cn.acitrus.common.entities.connector.connection.Connection;
import cn.acitrus.common.entities.connector.connection.ConnectionConverter;
import cn.acitrus.common.enums.permissions.ConnectorType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/25
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "connector")
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ConnectorEntity extends AbstractUniEntity {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private ConnectorType connectorType;

    @Column
    @Convert(converter = ConnectionConverter.class)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private Connection connection;
}
