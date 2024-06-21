package com.MtechScholershipPortal.ScholershipPortal.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String instituteEmail;
    @NonNull
    private String userName;
    @NonNull
    private String password;

    private String userType;
}
