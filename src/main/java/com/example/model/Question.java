package com.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private int id;
    private String question;
    private List<Option> options;
}
