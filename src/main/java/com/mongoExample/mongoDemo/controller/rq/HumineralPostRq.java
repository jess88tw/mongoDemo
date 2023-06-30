package com.mongoExample.mongoDemo.controller.rq;

import lombok.Data;

@Data
public class HumineralPostRq {

    private String name;

    private String description;

    private String father;

    private String mother;

    private String nationality;

    private int socialCreditScore;
}
