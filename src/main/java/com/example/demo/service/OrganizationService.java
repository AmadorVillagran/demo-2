package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.IOrganizationMapper;
import com.example.demo.dto.OrganizationDTO;
import com.example.demo.entity.Organization;
import com.example.demo.repository.IOrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private IOrganizationRepository organizationRepository;

	public List<OrganizationDTO> findAll() {
		return IOrganizationMapper.INSTANCE.organizationListToOrganizationDTOList(organizationRepository.findAll());
	}

	public OrganizationDTO save(OrganizationDTO organizationDTO) {
		Organization organization = IOrganizationMapper.INSTANCE.organizationDTOToOrganization(organizationDTO);
		return IOrganizationMapper.INSTANCE.organizartionToOrganizationDTO(organizationRepository.save(organization));
	}
}
