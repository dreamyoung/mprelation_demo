package com.github.dreamyoung.mprelation.demo.entity;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.AutoLazy;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.OneToMany;
import com.github.dreamyoung.mprelation.OneToOne;

import lombok.Data;
import lombok.ToString;

/**
 *
 */
@Data
//@AutoLazy
/*
 * @AutoLazy(true)  可开启自动延迟加载(默认为false)，对于多个延迟的属性，会触发多次连接（不是一个事务完成）。
         当@AutoLazy(false)时，如需要，可手动方式调用 initilizeXXX方法来加载@lazy(true)的属性（多个延迟的属性，可以只触发一次连接，在同个事务内未完成）。参见示例中的：t_man_service_001_initialize()
 */
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
	@Lazy(true)
	@JoinColumn(name = "lao_po_id", referencedColumnName = "woman_id")
	private Woman laoPo;

	@TableField("company_id")
	private Long companyId;

	@TableField(exist = false)
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	@Lazy(true)
	private Company company;

	@TableField(exist = false)
	@OneToMany
	@JoinColumn(name = "man_id", referencedColumnName = "lao_han_id")
	@Lazy(true)
	private List<Child> waWa;

	@TableField(exist = false)
	@OneToMany
	@JoinColumn(name = "man_id", referencedColumnName = "man_id")
	//@Lazy(false)
	private Set<Tel> tels;

	
	public String toLazyString() {
		return "Man [id=" + id + ", name=" + name + ", laoPoId=" + laoPoId + ", laoPo=" + laoPo + ", companyId="
				+ companyId + ", company=" + company + "]";
	}
}
