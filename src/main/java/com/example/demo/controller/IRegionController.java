package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.RegionDTO;

@RequestMapping("/region")
public interface IRegionController {

	@GetMapping("/findAll")
	public List<RegionDTO> findAll();
	
	@PostMapping
	public RegionDTO save(@RequestBody RegionDTO regionDTO);
}
