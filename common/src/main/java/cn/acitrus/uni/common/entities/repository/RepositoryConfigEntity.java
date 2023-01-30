package cn.acitrus.uni.common.entities.repository;

import cn.acitrus.uni.common.entities.base.AbstractUniEntity;
import cn.acitrus.uni.common.enums.repository.RepositoryType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/29
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RepositoryConfigEntity extends AbstractUniEntity {
    @Column
    private String host;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private RepositoryType repositoryType;
}
