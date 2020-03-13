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
	private AutoMapper autoMapper;

	@Autowired
	private IManService manService;

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

		// only load wawas
		autoMapper.mapperEntityList(list, "waWa");

		// init wawas's courses
		for (int i = 0; i < list.size(); i++) {
			autoMapper.mapperEntityList(list.get(i).getWaWa(), "courses");
		}

		autoMapper.mapperEntityList(list, "tels");

		return list;
	}

}
