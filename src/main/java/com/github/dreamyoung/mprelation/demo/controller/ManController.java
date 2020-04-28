package com.github.dreamyoung.mprelation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.dreamyoung.mprelation.AutoMapper;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.service.IManService;

@RestController
@RequestMapping(value = "/")
public class ManController {

	@Autowired
	private IManService manService;
	


	@Autowired
	private AutoMapper autoMapper;

	@ResponseBody
	@RequestMapping(value = "man/{id}")
	public Man getMan(@PathVariable("id") Long id) {
		Man man = manService.getById(id);
		return man;
	}

	
	@ResponseBody
	@RequestMapping(value = "mans")
	public List<Man> listMans() {
		List<Man> list = manService.list();

		System.out.println("list lazy will start after @ResponseBody...");
		
		autoMapper.mapperEntityList(list,"waWa");
		autoMapper.mapperEntityList(list,"tels");
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "mans2")
	public List<Man> listMansLazySomeProperty() {
		List<Man> list = manService.listMansOneConnectionMoreAutoMapper();
		return list;
	}
	

}
