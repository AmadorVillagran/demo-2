package com.example.demo.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.RegionDTO;
import com.example.demo.entity.Region;

@Mapper
public interface IRegionMapper {

	IRegionMapper INSTANCE = Mappers.getMapper(IRegionMapper.class);
	
	Region regionDTOToRegion(RegionDTO regionDTO);
	
	RegionDTO regionToRegionDTO(Region region);
	
	List<Region> regionDTOListToRegionList(List<RegionDTO> regionDTOList);
	
	List<RegionDTO> regionListToRegionDTOList(List<Region> regionList);
}
