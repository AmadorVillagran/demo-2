package com.example.demo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationDTO {

	private Integer id;
	
	@NotNull
	@NotBlank
	private String code;
	
	@NotNull
	@NotBlank
	private String description;
	
	@NotNull
	@NotEmpty
	private List<CountryDTO> countries;
}
