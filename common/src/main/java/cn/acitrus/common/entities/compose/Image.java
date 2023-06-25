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
@Table(name = "compose_image")
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Image extends AbstractUniEntity {
    @Column
    private String repository;
    @Column
    private String tag;
    @Column
    private String size;
}
