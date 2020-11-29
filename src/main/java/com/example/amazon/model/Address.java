package com.example.amazon.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@DynamoDBDocument
public class Address {
    private String address1;
    private String address2;

    @DynamoDBAttribute
    public String getAddress1() {
        return address1;
    }

    @DynamoDBAttribute
    public String getAddress2() {
        return address2;
    }
}
