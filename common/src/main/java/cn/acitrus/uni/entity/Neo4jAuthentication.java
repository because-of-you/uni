package cn.acitrus.uni.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;

/**
 * {@code @author:} wfy
 * {@code @date:} 2023/1/12
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "neo4j_config", catalog = "uni", schema = "uni")
public class Neo4jAuthentication extends Neo4jProperties.Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String realm;
    @Column
    private String kerberosTicket;
    @Column
    private String uri;
}
