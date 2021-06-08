package com.example.demo.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.OrganizationDTO;
import com.example.demo.entity.Organization;

@Mapper
public interface IOrganizationMapper {

	IOrganizationMapper INSTANCE = Mappers.getMapper(IOrganizationMapper.class);

	Organization organizationDTOToOrganization(OrganizationDTO organizationDTO);

	OrganizationDTO organizartionToOrganizationDTO(Organization organization);

	List<Organization> organizationDTOListToOrgnizationList(List<OrganizationDTO> organizationDTOList);

	List<OrganizationDTO> organizationListToOrganizationDTOList(List<Organization> organizationList);
}
