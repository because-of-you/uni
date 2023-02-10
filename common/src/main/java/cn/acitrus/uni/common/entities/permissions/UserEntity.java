package cn.acitrus.uni.common.entities.permissions;

import cn.acitrus.uni.common.entities.base.AbstractUniEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/31
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table
public class UserEntity extends AbstractUniEntity implements UserDetails, CredentialsContainer {
    @Column
    private String password;
    @Column(nullable = false, unique = true, updatable = false, length = 32)
    @JdbcTypeCode(SqlTypes.CHAR)
    private String username;
    @Transient
    private Set<GrantedAuthority> authorities;
    @Column(nullable = false)
    private boolean accountNonExpired = true;
    @Column(nullable = false)
    private boolean accountNonLocked = true;
    @Column(nullable = false)
    private boolean credentialsNonExpired = true;
    @Column(nullable = false)
    private boolean enabled = true;

    @Override
    @SneakyThrows
    public void eraseCredentials() {

    }
}
