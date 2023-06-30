package com.mongoExample.mongoDemo.controller.rs;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(value = "humineral")
public class Humineral {

    @Id
    private String id;

    private String name;

    private String description;

    private String father;

    private String mother;

    private String nationality;

    private int socialCreditScore;

    private Date bornAt;

    private Date lastUpdatedAt;
}
