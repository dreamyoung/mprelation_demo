package com.github.dreamyoung.mprelation.demo.test;

import java.util.List;
import java.util.Set;

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
import com.github.dreamyoung.mprelation.demo.entity.Course;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.entity.Tel;
import com.github.dreamyoung.mprelation.demo.entity.Woman;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.mapper.CompanyMapper;
import com.github.dreamyoung.mprelation.demo.mapper.ManMapper;
import com.github.dreamyoung.mprelation.demo.mapper.WomanMapper;
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
		Child child = childMapper.selectById(1L);
		System.out.println("child:" + child);

		child = autoMapper.mapperEntity(child);

		Man baba = child.getLaoHan();
		Woman mama = child.getLaoMa();
		System.out.println("baba:" + baba);
		System.out.println("mama:" + mama);

		Set<Course> courses = child.getCourses();
		System.out.println("courses:" + courses);
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

		Set<Tel> tels = man.getTels();
		System.out.println("tels:" + tels);
		System.out.println("------------------");

		Company com = man.getCompany();
		System.out.println("company:" + com);

	}

	@Test
	public void t_man_service() {
		Man man = manService.getById(1);
		System.out.println(man.getName());
		System.out.println(man.getWaWa());
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
