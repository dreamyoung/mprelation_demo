package com.github.dreamyoung.mprelation.demo.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.EntityMapper;
import com.github.dreamyoung.mprelation.FetchType;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.OneToMany;
import com.github.dreamyoung.mprelation.OneToOne;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.mapper.ManMapper;

import lombok.Data;

@Data
public class Woman {
	@TableId(value = "woman_id")
	private Long id;

	private String name;

	@TableField("lao_gong_id")
	private Long laoGongId;

	@TableField(exist = false)
	@OneToOne
	@JoinColumn(name = "lao_gong_id", referencedColumnName = "man_id")
	@EntityMapper(targetMapper = ManMapper.class)
	private Man laoGong;

	@TableField(exist = false)
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "woman_id", referencedColumnName = "lao_ma_id")
	@EntityMapper(targetMapper = ChildMapper.class)
	private List<Child> waWa;
}
