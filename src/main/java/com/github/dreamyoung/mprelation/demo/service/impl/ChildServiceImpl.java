package com.github.dreamyoung.mprelation.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity.Child;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.service.IChildService;

@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements IChildService {
	@Transactional
	public List<Child> listByInitialize() {
			List<Child> list = this.list();
			this.autoMapper.initialize(list, "laoHan","laoMa","courses","teachers");
			return list;
	}
	
	@Transactional
	public List<Child> listByInitialize2() {
			List<Child> list = this.list();
			this.initialize(list, "laoHan","laoMa","courses","teachers");
			return list;
	}
	

	@Transactional
	public List<Child> listByInitialize3() {
			List<Child> list = this.list();
			this.initialize(list, "laoHan","laoMa","courses");
			return list;
	}
}
