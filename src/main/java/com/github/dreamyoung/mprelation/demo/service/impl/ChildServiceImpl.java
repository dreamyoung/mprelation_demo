package com.github.dreamyoung.mprelation.demo.service.impl;

import org.springframework.stereotype.Service;

import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity.Child;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.service.IChildService;

@Service
public class ChildServiceImpl extends ServiceImpl<ChildMapper, Child> implements IChildService {

}
