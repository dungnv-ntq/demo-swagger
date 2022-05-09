package com.dung.demoswagger.controllers;

import com.dung.demoswagger.entities.Class;
import com.dung.demoswagger.entities.Student;
import com.dung.demoswagger.entities.Student_;
import com.dung.demoswagger.repositories.ClassRepository;
import com.dung.demoswagger.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ClassRepository classRepository;

    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/students")
    public ResponseEntity getAll(Pageable pageable) {
        return ResponseEntity.ok(repository.findAll(pageable));
    }

    @PostMapping("/students")
    public ResponseEntity createStudent(Student student) {
        return ResponseEntity.ok(repository.save(student));
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(required = false) String name) {
        Specification specification = Specification.where(nameLike(name));
        return ResponseEntity.ok(repository.findAll(specification));
    }

    private Specification<Student> nameLike(String name)
    {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get(Student_.NAME), "%"+name+"%");
    }

    @GetMapping("/classes")
    public ResponseEntity getAllClass() {
        return ResponseEntity.ok(classRepository.findAll());
    }

    @PostMapping("/classes")
    public ResponseEntity createClass(@RequestBody Class aClass) {
        System.out.println(aClass);
        return ResponseEntity.ok(classRepository.save(aClass));
    }
}
