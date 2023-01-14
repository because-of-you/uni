package cn.acitrus.uni.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
@Table(name = "PERSON", schema = "uni")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    private String name;
}
