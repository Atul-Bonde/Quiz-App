package com.bikkadit.quizapp.service;

import java.util.List;

import com.bikkadit.quizapp.dto.QuestionDto;

public interface QuestionService {
	
	public QuestionDto savequestion(QuestionDto questionDto);
	
	public List<QuestionDto> getAllQuestion();
	
	public List<QuestionDto> getByCategory(String category);
	

}
