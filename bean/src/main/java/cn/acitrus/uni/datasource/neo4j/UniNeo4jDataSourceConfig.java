//package cn.acitrus.uni.datasource.neo4j;
//
//import lombok.*;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
//
//import java.io.File;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.time.Duration;
//
///**
// * {@code @author:} wfy
// * {@code @date:} 2023/1/12
// **/
//@Data
//@EqualsAndHashCode(callSuper = true)
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Generated
//public class UniNeo4jDataSourceConfig extends Neo4jProperties {
//    /**
//     * URI used by the driver.
//     */
//    private URI uri;
//
//    {
//        try {
//            uri = new URI("neo4j+s://8b0b1ed3.databases.neo4j.io");
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * Timeout for borrowing connections from the pool.
//     */
//    private Duration connectionTimeout = Duration.ofSeconds(30);
//
//    /**
//     * Maximum time transactions are allowed to retry.
//     */
//    private Duration maxTransactionRetryTime = Duration.ofSeconds(30);
//
//    private UniNeo4jDataSourceConfig.Authentication authentication = new UniNeo4jDataSourceConfig.Authentication();
//
//    private final UniNeo4jDataSourceConfig.Pool pool = new UniNeo4jDataSourceConfig.Pool();
//
//    private final UniNeo4jDataSourceConfig.Security security = new UniNeo4jDataSourceConfig.Security();
//
//}
