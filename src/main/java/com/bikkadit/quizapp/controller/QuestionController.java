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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadit.quizapp.dto.QuestionDto;
import com.bikkadit.quizapp.service.QuestionService;

@RestController
@RequestMapping("/api")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/questions")
	public ResponseEntity<QuestionDto> saveQuestion(@RequestBody QuestionDto questionDto){
		
		return new ResponseEntity<QuestionDto>(questionService.savequestion(questionDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/questions")
	public ResponseEntity<List<QuestionDto>> getAllQuestion(){
		
		return new ResponseEntity<List<QuestionDto>>(questionService.getAllQuestion(),HttpStatus.OK);
	}
	
	@GetMapping("/questions/{category}")
	public ResponseEntity<List<QuestionDto>> getQuestionByCategory(@PathVariable String category){
		
		return new ResponseEntity<List<QuestionDto>>(questionService.getByCategory(category),HttpStatus.OK);
	}

}
