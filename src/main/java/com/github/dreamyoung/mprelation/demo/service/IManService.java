package com.github.dreamyoung.mprelation.demo.service;

import java.util.List;

import com.github.dreamyoung.mprelation.IService;
import com.github.dreamyoung.mprelation.demo.entity.Man;

public interface IManService extends IService<Man> {
	public List<Man> listMansOneConnectionMoreAutoMapper();

}