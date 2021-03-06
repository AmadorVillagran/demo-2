package com.example.demo.controllerImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.ICountryController;
import com.example.demo.dto.CountryDTO;
import com.example.demo.service.CountryService;

@RestController
public class CountryControllerImpl extends HandleErrorControllerImpl implements ICountryController {

	@Autowired
	private CountryService countryService;
	
	@Override
	public List<CountryDTO> findAll() {
		return countryService.findAll();
	}

	@Override
	public CountryDTO save(@Valid CountryDTO countryDTO) {
		return countryService.save(countryDTO);
	}

}
