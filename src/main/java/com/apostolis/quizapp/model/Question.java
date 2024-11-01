package com.apostolis.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//This class represents a table in our database
//Each Field is a table column
//Each Object is a row of the table
//ORM:Object Relational Mapping

//The table will be mapped to the class so we use @Entity
@Data
@Entity
public class Question {

    @Id //Id is our primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id will be auto generated
    private Integer id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswer;
    private String difficulty_level;
    private String category;
}
