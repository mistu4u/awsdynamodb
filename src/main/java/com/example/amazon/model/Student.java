package com.example.amazon.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.io.Serializable;

@DynamoDBTable(tableName = "student")
public class Student implements Serializable {
    private static final long serialVersionUID= 2L;
    private String studentId;
    private String firstName;
    private String lastName;
    private String age;
    private Address address;

    public Student(String studentId, String firstName, String lastName, String age, Address address) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Student(){

    }

    @DynamoDBHashKey(attributeName = "studentid")
    @DynamoDBAutoGeneratedKey
    public String getStudentId() {
        return studentId;
    }

    @DynamoDBAttribute
    public String getFirstName() {
        return firstName;
    }

    @DynamoDBRangeKey
    public String getLastName() {
        return lastName;
    }

    @DynamoDBAttribute
    public String getAge() {
        return age;
    }

    @DynamoDBAttribute
    public Address getAddress() {
        return address;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
