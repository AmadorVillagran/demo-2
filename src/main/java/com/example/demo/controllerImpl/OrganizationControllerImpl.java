package com.example.demo.controllerImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.IOrganizationController;
import com.example.demo.dto.OrganizationDTO;
import com.example.demo.service.OrganizationService;

@RestController
public class OrganizationControllerImpl implements IOrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@Override
	public List<OrganizationDTO> findAll() {
		return organizationService.findAll();
	}

	@Override
	public OrganizationDTO save(@Valid OrganizationDTO organizationDTO) {
		return organizationService.save(organizationDTO);
	}

}
