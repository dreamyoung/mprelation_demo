package com.github.dreamyoung.mprelation.demo.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;

import lombok.Data;

@Data
public class Company {
	@TableId(value = "company_id")
	private Long id;
	private String name;
	
	//一对多
	@TableField(exist = false)
	@OneToMany
	@Lazy()
	@JoinColumn(name="company_id",referencedColumnName = "company_id")
	private List<Man> employees;
}
