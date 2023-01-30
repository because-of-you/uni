package cn.acitrus.uni.common.entities;

import cn.acitrus.uni.common.entities.base.UniEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/14
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "person", schema = "uni")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Person extends UniEntity {
    @Column
    private String name = "";
}
