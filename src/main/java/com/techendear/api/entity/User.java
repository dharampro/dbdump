package com.techendear.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "user")
public class User {

    @Id
    private String id;
    private String firstName;
    private String lasteName;
    private String email;
    private String contactNumber;
}
