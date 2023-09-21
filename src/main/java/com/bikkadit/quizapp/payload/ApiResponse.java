package com.bikkadit.quizapp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
	
	private String msg;
	
	private Boolean status;

        public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
     
	@Override
	public String toString() {
		return "ApiResponse [msg=" + msg + ", status=" + status + "]";
	}
	
	
}
