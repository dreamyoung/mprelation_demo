package com.github.dreamyoung.mprelation.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToOne;

import lombok.Data;

@Data
public class Tel {
	private Long id;
	private String tel;
	
	@TableField("man_id")
	private Long manId;

	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "man_id", referencedColumnName = "man_id")
	@Lazy
	private Man laoHan;
	
}
