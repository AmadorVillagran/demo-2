package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDTO {

	private Integer id;
	
	private String code;
	
	private String description;
}
