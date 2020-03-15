package com.github.dreamyoung.mprelation.demo.service.impl;

import org.springframework.stereotype.Service;

import com.github.dreamyoung.mprelation.DisableAutoMapper;
import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity.Woman;
import com.github.dreamyoung.mprelation.demo.mapper.WomanMapper;
import com.github.dreamyoung.mprelation.demo.service.IWomanService;

@Service
@DisableAutoMapper
public class WomanServiceImpl extends ServiceImpl<WomanMapper, Woman> implements IWomanService {

}
