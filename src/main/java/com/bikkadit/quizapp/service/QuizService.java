package com.bikkadit.quizapp.service;

import java.util.List;

import com.bikkadit.quizapp.dto.QuestionMapper;
import com.bikkadit.quizapp.dto.QuizDto;
import com.bikkadit.quizapp.dto.Response;

public interface QuizService {

	QuizDto createQuiz(int num, String category, String title);

	List<QuestionMapper> getQuiz(Long quizId);

	Integer resultOfQuiz(Long quizId, List<Response> responses);

}
