package com.apostolis.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apostolis.quizapp.model.Question;
import com.apostolis.quizapp.service.QuestionService;

//We will use many layers: USER -> Controller Layer -> Service Layer -> DAO -> Database
//Controller will get the input from USER and send it to Service(Logic)

//This is a question controller
@RestController //accepts the requests
@RequestMapping("question") //This is the 1st part of what is written on the URL
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions") //This is the 2nd part of what is written on the URL
    public ResponseEntity<List<Question>> getAllQuestions(){ //Return *many* questions so: List
        //Will need a service class to have this function
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}
