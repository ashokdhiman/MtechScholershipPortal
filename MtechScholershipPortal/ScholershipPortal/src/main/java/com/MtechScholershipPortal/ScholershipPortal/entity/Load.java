package com.MtechScholershipPortal.ScholershipPortal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection  = "load")
public class Load {
    @Id
    private long weekNo;
    int teachingRelatedActivity;
    int researchRelatedActivity;
    String facultyName;
}

