package com.example.demo.dto;

import lombok.Data;

@Data
public class ResponseDTO {

	private Object response;
	
	private Error error;
	
	public ResponseDTO() {
		error = new Error();
	}
}
