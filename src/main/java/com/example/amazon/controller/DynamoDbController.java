package com.example.amazon.controller;

import com.example.amazon.model.Student;
import com.example.amazon.repository.DynamoDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/dynamoDb")
public class DynamoDbController {
    @Autowired
    private DynamoDbRepository dynamoDbRepository;

    @DeleteMapping(value = "{studentId}/{lastName}")
    public void deleteStudent(@PathVariable("studentId") String studentId, @PathVariable String lastName){
        dynamoDbRepository.deleteOneStudent(studentId,lastName);
    }

    @GetMapping(value="/getOneStudent/{studentId}/{lastName}")
    public ResponseEntity<Student> getOneStudent(@PathVariable String studentId, @PathVariable String lastName){
        Student student = dynamoDbRepository.getOneStudent(studentId,lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return dynamoDbRepository.getStudents();
    }

    @PostMapping
    public String postOneStudent(@RequestBody Student student){
        dynamoDbRepository.insertIntoDynamoDb(student);
        return "Successfully create a new student";
    }
}
