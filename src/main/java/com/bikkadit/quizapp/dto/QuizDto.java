package com.bikkadit.quizapp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuizDto {
	
	
	private Long id;
	
	
	private String title;
	
	
	private List<QuestionDto> Question;

}
