package com.bikkadit.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.quizapp.dto.QuestionMapper;
import com.bikkadit.quizapp.dto.QuizDto;
import com.bikkadit.quizapp.dto.Response;
import com.bikkadit.quizapp.model.Quiz;
import com.bikkadit.quizapp.service.QuizService;

@RestController
@RequestMapping("/api")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/quiz/num/{num}/title/{title}/category/{category}")
	public ResponseEntity<QuizDto> createQuiz(@PathVariable int num, @PathVariable String title,
			@PathVariable String category) {

		return new ResponseEntity<QuizDto>(this.quizService.createQuiz(num, category, title), HttpStatus.CREATED);
	}

	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<QuestionMapper>> getQuiz(@PathVariable Long quizId) {

		return new ResponseEntity<List<QuestionMapper>>(this.quizService.getQuiz(quizId), HttpStatus.OK);
	}
	@GetMapping("/quiz/{quizId1}")
	public ResponseEntity<List<QuestionMapper>> getQuiz(@PathVariable Long quizId) {

		return new ResponseEntity<List<QuestionMapper>>(this.quizService.getQuiz(quizId), HttpStatus.OK);
	}
	@GetMapping("/quiz/{quizId2}")
	public ResponseEntity<List<QuestionMapper>> getQuiz(@PathVariable Long quizId) {

		return new ResponseEntity<List<QuestionMapper>>(this.quizService.getQuiz(quizId), HttpStatus.OK);
	}

	@GetMapping("/quizresult/{quizId}")
	public ResponseEntity<Integer> resultQuiz(@PathVariable long quizId, @RequestBody List<Response> responses) {

		return new ResponseEntity<Integer>(this.quizService.resultOfQuiz(quizId, responses), HttpStatus.OK);
	}

}
