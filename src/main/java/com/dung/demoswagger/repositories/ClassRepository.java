package com.dung.demoswagger.repositories;

import com.dung.demoswagger.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {
}
