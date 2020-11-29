package com.example.amazon.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.amazon.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DynamoDbRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void insertIntoDynamoDb(Student student){
        dynamoDBMapper.save(student);
    }

    public List<Student> getStudents(){
        return dynamoDBMapper.scan(Student.class,new DynamoDBScanExpression());
    }

    public Student getOneStudent(String studentId,String lastName){
        return dynamoDBMapper.load(Student.class,studentId,lastName);
    }

    public void deleteOneStudent(String studentId,String lastName){
        Student studentToBeDeleted = getOneStudent(studentId,lastName);
        dynamoDBMapper.delete(studentToBeDeleted);
    }

}
