package com.bikkadit.quizapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="DIFFICULTY_LEVEL")
	private String difficultylevel;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="OPTION_1")
	private String option1;
	
	@Column(name="OPTION_2")
	private String option2;
	
	@Column(name="OPTION_3")
	private String option3;
	
	@Column(name="OPTION_4")
	private String option4;
	
	@Column(name="RIGHT_ANSWER")
	private String rightAnswer;

}
