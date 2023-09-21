package com.bikkadit.quizapp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String msg;
	
	private Boolean status;

	@Override
	public String toString() {
		return "ApiResponse [msg=" + msg + ", status=" + status + "]";
	}
	
	

}
