package com.dung.demoswagger.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String address;

    @ManyToOne
    @JoinColumn(name = "a_class_id", nullable = false)
    private Class aClass;
}
