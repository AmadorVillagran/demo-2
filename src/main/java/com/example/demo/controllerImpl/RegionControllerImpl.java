package com.example.demo.controllerImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.IRegionController;
import com.example.demo.dto.RegionDTO;
import com.example.demo.service.RegionService;

@RestController
public class RegionControllerImpl implements IRegionController {

	@Autowired
	private RegionService regionService;
	
	@Override
	public List<RegionDTO> findAll() {
		return regionService.findAll();
	}

	@Override
	public RegionDTO save(@Valid RegionDTO regionDTO) {
		return regionService.save(regionDTO);
	}

}
