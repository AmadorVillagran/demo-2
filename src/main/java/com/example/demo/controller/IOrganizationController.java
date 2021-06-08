package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.OrganizationDTO;

@RequestMapping("/organization")
public interface IOrganizationController {

	@GetMapping("/findAll")
	public List<OrganizationDTO> findAll();
	
	@PostMapping("/")
	public OrganizationDTO save(@RequestBody OrganizationDTO organizationDTO);
}
