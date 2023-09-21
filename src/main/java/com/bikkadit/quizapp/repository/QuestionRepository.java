package com.bikkadit.quizapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bikkadit.quizapp.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	
	
	public List<Question> findByCategory(String category);
	
	
	@Query(value="select * from question where category=:category order by rand() limit :num" ,nativeQuery = true)
	public List<Question> getRandomQuestion(String category,int num);
	
	
}
