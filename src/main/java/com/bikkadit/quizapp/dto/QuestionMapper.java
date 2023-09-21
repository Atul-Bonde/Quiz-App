package com.bikkadit.quizapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionMapper {
	
    private Long id;
	
	private String title;
	
	private String option1;
	
	private String option2;
	
	private String option3;
	
	private String option4;

}
