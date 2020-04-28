package com.github.dreamyoung.mprelation.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.mapper.ManMapper;
import com.github.dreamyoung.mprelation.demo.service.IManService;

@Service
public class ManServiceImpl extends ServiceImpl<ManMapper, Man> implements IManService {
	@Transactional
	public List<Man> listMansOneConnectionMoreAutoMapper() {
			List<Man> list = this.list();
			return list;
	}
}
