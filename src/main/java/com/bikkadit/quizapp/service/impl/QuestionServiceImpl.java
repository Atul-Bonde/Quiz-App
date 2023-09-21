package com.bikkadit.quizapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.quizapp.dto.QuestionDto;
import com.bikkadit.quizapp.exception.ResourceNotFound;
import com.bikkadit.quizapp.model.Question;
import com.bikkadit.quizapp.repository.QuestionRepository;
import com.bikkadit.quizapp.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public QuestionDto savequestion(QuestionDto questionDto) {

		Question question = this.modelMapper.map(questionDto, Question.class);

		Question question2 = this.questionRepository.save(question);

		QuestionDto questionDto1 = this.modelMapper.map(question2, QuestionDto.class);

		return questionDto1;
	}

	@Override
	public List<QuestionDto> getAllQuestion() {

		List<Question> question = this.questionRepository.findAll();

		List<QuestionDto> collect = question.stream().map(e -> this.modelMapper.map(e, QuestionDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public List<QuestionDto> getByCategory(String category) {

		List<Question> findByCategory = this.questionRepository.findByCategory(category);

		if (findByCategory.isEmpty()) {

			throw new ResourceNotFound("Resource Not found for Category : " + category);
		}

		List<QuestionDto> collect = findByCategory.stream().map(e -> this.modelMapper.map(e, QuestionDto.class))
				.collect(Collectors.toList());

		return collect;
	}

}
