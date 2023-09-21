package com.bikkadit.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikkadit.quizapp.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
