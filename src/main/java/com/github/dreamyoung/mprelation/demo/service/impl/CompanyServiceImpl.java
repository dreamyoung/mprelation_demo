package com.github.dreamyoung.mprelation.demo.service.impl;

import org.springframework.stereotype.Service;

import com.github.dreamyoung.mprelation.ServiceImpl;
import com.github.dreamyoung.mprelation.demo.entity.Company;
import com.github.dreamyoung.mprelation.demo.mapper.CompanyMapper;
import com.github.dreamyoung.mprelation.demo.service.ICompanyService;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
