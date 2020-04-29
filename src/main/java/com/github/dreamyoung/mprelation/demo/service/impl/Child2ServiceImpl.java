package com.github.dreamyoung.mprelation.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity2.bean.Child2;
import com.github.dreamyoung.mprelation.demo.mapper2.Child2Mapper;
import com.github.dreamyoung.mprelation.demo.service.IChild2Service;

@Service
public class Child2ServiceImpl extends ServiceImpl<Child2Mapper, Child2> implements IChild2Service {
	@Transactional
	public List<Child2> list2() {
			List<Child2> list = this.list();
			this.autoMapper.initialize(list, "courses");
			return list;
	}

}
