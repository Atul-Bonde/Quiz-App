package com.bikkadit.quizapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.quizapp.dto.QuestionMapper;
import com.bikkadit.quizapp.dto.QuizDto;
import com.bikkadit.quizapp.dto.Response;
import com.bikkadit.quizapp.exception.ResourceNotFound;
import com.bikkadit.quizapp.model.Question;
import com.bikkadit.quizapp.model.Quiz;
import com.bikkadit.quizapp.repository.QuestionRepository;
import com.bikkadit.quizapp.repository.QuizRepository;
import com.bikkadit.quizapp.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public QuizDto createQuiz(int num, String category, String title) {

		List<Question> questions = this.questionRepository.getRandomQuestion(category, num);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);

		Quiz quiz1 = this.quizRepository.save(quiz);

		QuizDto quizDto = this.modelMapper.map(quiz1, QuizDto.class);

		return quizDto;
	}

	@Override
	public List<QuestionMapper> getQuiz(Long quizId) {

		Quiz quiz = this.quizRepository.findById(quizId)
				.orElseThrow(() -> new ResourceNotFound("Quiz Not Found for Id" + quizId));

		List<Question> questions = quiz.getQuestion();

		List<QuestionMapper> questionMapper = new ArrayList<>();

		for (Question q : questions) {

			QuestionMapper queMap = new QuestionMapper();
			queMap.setId(q.getId());
			queMap.setTitle(q.getTitle());
			queMap.setOption1(q.getOption1());
			queMap.setOption2(q.getOption2());
			queMap.setOption3(q.getOption3());
			queMap.setOption4(q.getOption4());

			questionMapper.add(queMap);
		}

		return questionMapper;
	}

	@Override
	public Integer resultOfQuiz(Long quizId, List<Response> responses) {

		Quiz quiz = this.quizRepository.findById(quizId)
				.orElseThrow(() -> new ResourceNotFound("Quiz Not Found For Id" + quizId));

		List<Question> questions = quiz.getQuestion();

		int right = 0;
		int i = 0;

		for (Response response : responses) {

			if (response.getResponse().equals(questions.get(i).getRightAnswer())) {

				right++;
				i++;
			}

		}

		return right;
	}

}
