package cn.acitrus.common;

import cn.acitrus.common.entities.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}