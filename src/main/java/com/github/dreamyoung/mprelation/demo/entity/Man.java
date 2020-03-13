package com.github.dreamyoung.mprelation.demo.entity;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.OneToMany;
import com.github.dreamyoung.mprelation.OneToOne;

import lombok.Data;

@Data
public class Man {
	public Man() {
		super();
	}

	public Man(Long id) {
		this.id = id;
	}

	public Man(String name) {
		this.name = name;
	}

	public Man(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@TableId(value = "man_id")
	private Long id;

	private String name;

	private Long laoPoId;

	@TableField(exist = false)
	@OneToOne
	@JoinColumn(name = "lao_po_id", referencedColumnName = "woman_id")
	private Woman laoPo;

	// 多对一
	@TableField("company_id")
	private Long companyId;

	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@Lazy
	private Company company;

	@TableField(exist = false)
	@OneToMany
	@JoinColumn(name = "man_id", referencedColumnName = "lao_han_id")
	private List<Child> waWa;

	@TableField(exist = false)
	@OneToMany
	@JoinColumn(name = "man_id", referencedColumnName = "man_id")
	@Lazy(false)
	private Set<Tel> tels;

}
