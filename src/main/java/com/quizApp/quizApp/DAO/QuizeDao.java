package com.quizApp.quizApp.DAO;

import com.quizApp.quizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizeDao extends JpaRepository<Quiz,Integer> {
}
