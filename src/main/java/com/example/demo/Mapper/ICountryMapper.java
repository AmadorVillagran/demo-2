package com.example.demo.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.CountryDTO;
import com.example.demo.entity.Country;

@Mapper
public interface ICountryMapper {

	ICountryMapper INSTANCE = Mappers.getMapper(ICountryMapper.class);

	public Country countryDTOToCountry(CountryDTO countryDTO);

	public CountryDTO countryToCountryDTO(Country country);

	public List<Country> countryDTOListToCountryList(List<CountryDTO> countryDTOList);

	public List<CountryDTO> countryListToCountryDTOList(List<Country> countryList);
}
