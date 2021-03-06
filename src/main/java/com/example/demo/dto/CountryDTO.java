package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDTO {

	private Integer id;
	
	@NotNull
	@NotBlank
	private String code;
	
	@NotNull
	@NotBlank
	private String description;
}
