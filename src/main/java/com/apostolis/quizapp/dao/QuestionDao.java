package com.apostolis.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apostolis.quizapp.model.Question;

import java.util.List;


@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> { //Repository asks for table name and primary key type(Question,Int)

    List<Question> findByCategory(String category);

    @Query(value ="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
