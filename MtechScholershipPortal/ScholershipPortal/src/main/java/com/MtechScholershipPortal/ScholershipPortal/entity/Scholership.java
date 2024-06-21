package com.MtechScholershipPortal.ScholershipPortal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection  = "scholership")
public class Scholership {
    @Id
    private long rollNo;

    private String name;
    private String month;
    private int leaves;

    @DBRef
    List<Load> load=new ArrayList<>();

    private int total_load;

    private LocalDateTime date;

    private String nameOfGuide;

}