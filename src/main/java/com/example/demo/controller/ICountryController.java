package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.CountryDTO;

@RequestMapping("/country")
public interface ICountryController {

	@GetMapping("/findAll")
	public List<CountryDTO> findAll();
	
	@PostMapping("/")
	public CountryDTO save(@RequestBody CountryDTO countryDTO);
	
}
