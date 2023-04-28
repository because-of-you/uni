package cn.acitrus.repository.connectors.neo4j;

import cn.acitrus.common.entities.config.ConnectorEntity;
import cn.acitrus.common.entities.config.connection.Neo4jConnection;
import cn.acitrus.common.enums.permissions.ConnectorType;
import cn.acitrus.repository.config.ConnectorEntityRepository;
import cn.acitrus.repository.connectors.Connector;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.Duration;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
@Component
@RequiredArgsConstructor
public class Neo4jConnector implements Connector {
    private final ConnectorEntityRepository repository;

    @Bean
    @Primary
    @Nonnull
    @SneakyThrows
    public Neo4jProperties neo4jProperties() {

        Example<ConnectorEntity> example = Example.of(ConnectorEntity.builder().connectorType(ConnectorType.NEO4J).build());
        ConnectorEntity connector = repository.findOne(example).orElse(new ConnectorEntity());

        Neo4jProperties neo4jProperties = new Neo4jProperties();

        if (null == connector.getConnection()) {
            return neo4jProperties;
        }

        if (connector.getConnection() instanceof Neo4jConnection neo4jConnection) {
            neo4jProperties.getPool().setMetricsEnabled(false);
            neo4jProperties.getPool().setIdleTimeBeforeConnectionTest(Duration.ofMinutes(30));

            neo4jProperties.setUri(URI.create("""
                    %s""".stripIndent().formatted(neo4jConnection.getHost())));
            neo4jProperties.getAuthentication().setPassword(neo4jConnection.getPassword());
            neo4jProperties.getAuthentication().setUsername(neo4jConnection.getUsername());
        }

        return neo4jProperties;
    }


}
