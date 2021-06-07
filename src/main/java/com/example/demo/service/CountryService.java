package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.ICountryMapper;
import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.Country;
import com.example.demo.repository.ICountryRepository;

@Service
public class CountryService {

	@Autowired
	private ICountryRepository countryRepository;

	public List<CountryDTO> findAll() {
		return ICountryMapper.INSTANCE.countryListToCountryDTOList(countryRepository.findAll());
	}

	public CountryDTO save(CountryDTO countryDTO) {
		Country country = ICountryMapper.INSTANCE.countryDTOToCountry(countryDTO);
		return ICountryMapper.INSTANCE.countryToCountryDTO(countryRepository.save(country));
	}
}
