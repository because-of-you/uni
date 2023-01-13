package cn.acitrus.uni.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/12
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "neo4j_config", schema = "uni", catalog = "uni", indexes = {
})
public class Neo4jAuthentication extends Neo4jProperties.Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(unique = false)
    private String username;
    @Column(unique = false)
    private String password;
    @Column(unique = false)
    private String realm;
    @Column
    private String kerberosTicket;
    @Column
    private String uri;
}
