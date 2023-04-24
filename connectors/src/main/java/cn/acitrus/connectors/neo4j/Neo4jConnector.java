package cn.acitrus.connectors.neo4j;

import cn.acitrus.connectors.Connector;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * {@code @author:} wfy <br/>
 * {@code @date:} 2023/4/24
 **/
@Configuration
@RequiredArgsConstructor
public class Neo4jConnector implements Connector {
    private final DataSource dataSource;
}
