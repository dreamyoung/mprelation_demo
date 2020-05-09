package com.github.dreamyoung.mprelation.demo.mapper2;

import java.io.Serializable;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.dreamyoung.mprelation.demo.entity2.bean.Child2;

public interface Child2Mapper extends BaseMapper<Child2> {
	public Child2 selectById1(Long id);
}
