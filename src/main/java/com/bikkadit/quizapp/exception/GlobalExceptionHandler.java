package com.bikkadit.quizapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bikkadit.quizapp.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> apiResponseEntity(ResourceNotFound resourceNotFound){
		
		ApiResponse api=new ApiResponse();
		api.setMsg(resourceNotFound.getMessage());
		api.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		
	}

}
