package com.github.dreamyoung.mprelation.demo.service;

import java.util.List;

import com.github.dreamyoung.mprelation.IService;
import com.github.dreamyoung.mprelation.demo.entity2.bean.Child2;

public interface IChild2Service extends IService<Child2> {
	public List<Child2> list2();
}