package com.github.dreamyoung.mprelation.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dreamyoung.mprelation.AutoMapper;
import com.github.dreamyoung.mprelation.demo.entity.Child;
import com.github.dreamyoung.mprelation.demo.service.IChildService;

@RestController
@RequestMapping(value = "/")
public class ChildController {
	@Autowired
	private AutoMapper autoMapper;

	@Autowired
	private IChildService childService;


	@ResponseBody
	@RequestMapping(value = "child/{id}")
	public Child get(@PathVariable("id") Long id) {
		Child child = childService.getById(id);
		return child;
	}

	@ResponseBody
	@RequestMapping(value = "childs")
	public List<Child> list() {
		List<Child> childs = childService.list();

		return childs;
	}
	

	@ResponseBody
	@RequestMapping(value = "childs2")
	public List<Child> list2() {
		List<Child> childs = childService.list(new QueryWrapper<Child>().gt("child_id", 1));

		return childs;
	}
	
	@ResponseBody
	@RequestMapping(value = "test")
	public String test() {
		List<Child> childs = childService.list();
		System.out.println(childs);
		return "abc";
	}

}
