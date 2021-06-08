package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.IRegionMapper;
import com.example.demo.dto.RegionDTO;
import com.example.demo.entity.Region;
import com.example.demo.repository.IRegionRepository;

@Service
public class RegionService {

	@Autowired
	private IRegionRepository regionRepository;

	public List<RegionDTO> findAll() {
		return IRegionMapper.INSTANCE.regionListToRegionDTOList(regionRepository.findAll());
	}

	public RegionDTO save(RegionDTO regionDTO) {
		Region region = IRegionMapper.INSTANCE.regionDTOToRegion(regionDTO);
		return IRegionMapper.INSTANCE.regionToRegionDTO(regionRepository.save(region));
	}

}
