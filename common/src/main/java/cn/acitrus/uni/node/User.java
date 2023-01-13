//package cn.acitrus.uni.node;
//
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.data.neo4j.core.schema.Property;
//
//import java.util.Date;
//import java.util.UUID;
//
///**
// * {@code @author:} wfy
// * {@code @date:} 2023/1/10
// **/
//@Data
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
//@Node(value = "User", primaryLabel = "User", labels = {"User"})
//public class User {
//    @Id
//    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
//    private UUID id;
//    @Property
//    private String name;
//    @CreatedDate
//    private Date date;
//}
