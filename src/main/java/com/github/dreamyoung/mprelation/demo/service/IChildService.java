package com.github.dreamyoung.mprelation.demo.service;

import java.util.List;

import com.github.dreamyoung.mprelation.IService;
import com.github.dreamyoung.mprelation.demo.entity.Child;

public interface IChildService extends IService<Child> {
	public List<Child> listByInitialize();
	public List<Child> listByInitialize2();
	public List<Child> listByInitialize3();
}