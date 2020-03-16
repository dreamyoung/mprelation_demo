package com.github.dreamyoung.mprelation.demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dreamyoung.mprelation.AutoMapper;
import com.github.dreamyoung.mprelation.demo.entity.Child;
import com.github.dreamyoung.mprelation.demo.entity.Company;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.entity.Tel;
import com.github.dreamyoung.mprelation.demo.entity.Woman;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.mapper.CompanyMapper;
import com.github.dreamyoung.mprelation.demo.mapper.ManMapper;
import com.github.dreamyoung.mprelation.demo.mapper.WomanMapper;
import com.github.dreamyoung.mprelation.demo.service.IChildService;
import com.github.dreamyoung.mprelation.demo.service.IManService;
import com.github.dreamyoung.mprelation.demo.service.IWomanService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = { "com.github.dreamyoung.mprelation.demo.config",
		"com.github.dreamyoung.mprelation.demo.service.impl" })
@Slf4j
public class ResultmapTest {
	{
		log.info("Mybatis-Plus one2one/one2many/many2many");
	}

	@Autowired
	AutoMapper autoMapper;
	@Autowired
	private IManService manService;
	@Autowired
	private IWomanService womanService;
	@Autowired
	private IChildService childService;

	@Resource
	private ChildMapper childMapper;

	@Resource
	private ManMapper manMapper;
	@Resource
	private WomanMapper womanMapper;

	@Resource
	private CompanyMapper companyMapper;

	@Autowired
	ObjectFactory<SqlSession> factory;

	@SuppressWarnings("static-access")
	@Test
	public void t_enableAutoMapperInService() {

	}

	@Test
	public void t_child() {
		List<Child> childs = new ArrayList<Child>();
		Child c1 = new Child();
		c1.setId(1L);
		c1.setName("c1");

		Child c2 = new Child();
		c2.setId(2L);
		c2.setName("c2");

		childs.add(c1);
		childs.add(c2);

		autoMapper.manyToMany(childs, null, false);

		System.out.println(childs.get(0).getTeachers());
		System.out.println(childs.get(1).getTeachers());

		System.out.println(childs.get(0));
		System.out.println(childs.get(1));
	}

	@Test
	public void t_man_Lazy() {
		Man man = manMapper.selectById(1L);
		System.out.println("man.getName:" + man.getName());

		autoMapper.mapperEntity(man);
		System.out.println("------------------");

		Woman laoPo = man.getLaoPo();
		System.out.println("laoPo" + laoPo);
		System.out.println("------------------");

		List<Child> waWa = man.getWaWa();
		System.out.println("waWa:" + waWa);
		System.out.println("------------------");

		Collection<Tel> tels = man.getTels();
		System.out.println("tels:" + tels);
		System.out.println("------------------");

		Company com = man.getCompany();
		System.out.println("company:" + com);

	}

	@Test
	public void t_man_service() {
		List<Man> mans = manService.list();
		System.out.println(mans);
	}
	

	@Test
	public void t_child_service() {
		List<Child> cs = childService.list();
		System.out.println(cs);
	}

	@Test
	public void t_mans() {
		// List<Man> mans = manService.list();

		Man man = new Man(1L, "man1");
		man.setLaoPoId(1L);
		man.setCompanyId(1L);
		Man man2 = new Man(2L, "man2");
		man2.setLaoPoId(2L);
		man2.setCompanyId(2L);
		Man man3 = new Man(3L, "man3");
		man3.setLaoPoId(3L);
		man3.setCompanyId(3L);
		List<Man> mans = new ArrayList<Man>();
		mans.add(man);
		// mans.add(man2);
		// mans.add(man3);

		autoMapper.oneToMany(mans, null, false);
		autoMapper.oneToOne(mans, null, false);
		autoMapper.manyToOne(mans, null, false);

		for (int i = 0; i < mans.size(); i++) {
			Man manx = mans.get(i);
			System.out.println(manx);
			// System.out.println(manx.getId() + "--->" + manx.getTels().size());
		}

	}

	@Test
	public void t_woman_service_disabledAutoMapper() {
		Woman woman = womanService.getById(1);
		System.out.println(woman.getName());
		System.out.println(woman.getLaoGong());
	}

	@Test
	public void t_woman() throws NoSuchMethodException, SecurityException {
		Woman woman = womanMapper.selectById(1L);
		System.out.println(woman.getName());

		autoMapper.oneToMany(woman);

		List<Child> waWa = woman.getWaWa();
		System.out.println("waWa:" + waWa);

		Man man = woman.getLaoGong();
		System.out.println("laoGong:" + man);
	}

	@Test
	public void t_company() {

		Company company = companyMapper.selectById(1L);
		System.out.println("company name:" + company.getName());

		autoMapper.mapperEntity(company);

		List<Man> emplyoees = company.getEmployees();
		System.out.println("emplyoees:" + emplyoees);

	}

}
