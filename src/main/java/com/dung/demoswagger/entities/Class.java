package com.dung.demoswagger.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class")
@ToString
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;
}
