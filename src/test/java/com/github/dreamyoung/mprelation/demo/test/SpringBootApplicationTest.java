package com.github.dreamyoung.mprelation.demo.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.dreamyoung.mprelation.AutoMapper;
import com.github.dreamyoung.mprelation.demo.entity.Child;
import com.github.dreamyoung.mprelation.demo.entity.Company;
import com.github.dreamyoung.mprelation.demo.entity.Man;
import com.github.dreamyoung.mprelation.demo.entity.Teacher;
import com.github.dreamyoung.mprelation.demo.entity.Tel;
import com.github.dreamyoung.mprelation.demo.entity.Woman;
import com.github.dreamyoung.mprelation.demo.entity2.bean.Child2;
import com.github.dreamyoung.mprelation.demo.mapper.ChildMapper;
import com.github.dreamyoung.mprelation.demo.mapper.CompanyMapper;
import com.github.dreamyoung.mprelation.demo.mapper.ManMapper;
import com.github.dreamyoung.mprelation.demo.mapper.WomanMapper;
import com.github.dreamyoung.mprelation.demo.service.IChild2Service;
import com.github.dreamyoung.mprelation.demo.service.IChildService;
import com.github.dreamyoung.mprelation.demo.service.ICompanyService;
import com.github.dreamyoung.mprelation.demo.service.IManService;
import com.github.dreamyoung.mprelation.demo.service.IWomanService;
import com.github.dreamyoung.mprelation.demo.service.impl.CompanyServiceImpl;

import lombok.extern.slf4j.Slf4j;


//整合springboot+junit来测试时，程序会先预先读取执行主程序:ResultmapApplication（所以一些通用的配置及扫描都在主程序设置）
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootApplicationTest {
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
	@Autowired
	private IChild2Service child2Service;
	@Autowired
	private ICompanyService companyService;

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

	@Test
	public void t_child() {
		List<Child> childs = childService.list();

		// autoMapper.manyToMany(childs, null, false);

		System.out.println(childs.get(0).getName());
		System.out.print(childs.get(0).getCourses());
		System.out.print(childs);
	}

	@Test
	public void t_child2() {
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

		System.out.println(childs.get(0).getName());
	}

	@Test
	public void t_All() {
		System.out.println(manService.list());
		System.out.println(womanService.list());
		List<Child> childs = childService.list();
		for (int i = 0; i < childs.size(); i++) {
			Child c = childs.get(i);
			System.out.println(c.getName());
			Set<Teacher> teachers = c.getTeachers();
			System.out.println(teachers);
		}
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
	public void t_man_service2() {
		List<Man> mans = manService.listMansOneConnectionMoreAutoMapper();
		// System.out.println(mans);
	}

	@Test
	public void t_man_service_lazy() {
		List<Man> mans = manService.list();
		for (Man man : mans) {
			System.out.println(man.toLazyString());
		}
	}

	@Test
	public void t_child_service() {
		List<Child> childList = childService.list();
		System.out.println(childList);
	}
	


	@Test
	public void t_child2_service() {
		List<Child2> childList = child2Service.list2();
		System.out.println(childList);
	}
	
	@Test
	public void t_child_serviceWithInitialize() {
		List<Child> childList = childService.listByInitialize();
		System.out.println(childList);
	}
	

	@Test
	public void t_child_serviceWithInitialize2() {
		List<Child> childList = childService.listByInitialize2();
		System.out.println(childList);
	}
	

	@Test
	public void t_child_serviceWithInitialize3() {
		List<Child> childList = childService.listByInitialize3();
		System.out.println(childList);
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
	public void t_one2one() {
		Man man = manMapper.selectById(1L);
		autoMapper.oneToOne(man);

		Woman woman = man.getLaoPo();
		System.out.println(woman == null);
		System.out.println(woman);
	}

	@Test
	public void t_manNullWoman() {
		Man man = new Man();
		System.out.println(man);
	}

	@Test
	public void t_company() {

		Company company = companyMapper.selectById(1L);
		System.out.println("company name:" + company.getName());

		autoMapper.mapperEntity(company);

		List<Man> emplyoees = company.getEmployees();
		System.out.println("emplyoees:" + emplyoees);

	}

	@Test
	public void t_company_service() {

		Company company = companyService.getById(1);
		System.out.println("company name:" + company.getName());

		autoMapper.mapperEntity(company, "employees");

		List<Man> emplyoees = company.getEmployees();
		System.out.println("emplyoees:" + emplyoees);

	}

	@Test
	public void t_man_service_000() {

		Man man = manService.getById(1);
		System.out.println("man name:" + man.getName());
		System.out.println("-----------------");

		Woman woman = man.getLaoPo();
		woman = man.getLaoPo();
		woman = man.getLaoPo();
		woman = man.getLaoPo();
		System.out.println("woman:" + woman);
		Company company = man.getCompany();
		System.out.println("company:" + company);
		List<Child> waWa = man.getWaWa();
		System.out.println("waWa:" + waWa);

	}

	@Test
	public void t_man_service_001() {

		Man man = manService.getById(1);
		System.out.println("man name:" + man.getName());
		System.out.println("-----------------");

		autoMapper.mapperEntity(man, "laoPo");
		autoMapper.mapperEntity(man, "company");
		autoMapper.mapperEntity(man, "waWa");

		Woman woman = man.getLaoPo();
		System.out.println("woman:" + woman);
		Company company = man.getCompany();
		System.out.println("company:" + company);
		List<Child> waWa = man.getWaWa();
		System.out.println("waWa:" + waWa);

	}

	@Test
	public void t_man_service_001_initialize() {

		Man man = manService.getById(1);
		System.out.println("man name:" + man.getName());
		System.out.println("-----------------");

		manService.initializeEntity(man, "laoPo", "company", "waWa");

		Woman woman = man.getLaoPo();
		System.out.println("woman:" + woman);
		Company company = man.getCompany();
		System.out.println("company:" + company);
		List<Child> waWa = man.getWaWa();
		System.out.println("waWa:" + waWa);

	}

	@Test
	public void t_manlist_service_000() {

		List<Man> mans = manService.list();
		System.out.println("man size:" + mans.size());
		System.out.println("-----------------");

		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_manlist_service_001() {

		List<Man> mans = manService.list();
		System.out.println("man size:" + mans.size());
		System.out.println("-----------------");

		autoMapper.mapperEntityList(mans, "laoPo");
		autoMapper.mapperEntityList(mans, "company");
		autoMapper.mapperEntityList(mans, "waWa");

		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_manlist_service_001_initialize() {

		List<Man> mans = manService.list();
		System.out.println("man size:" + mans.size());
		System.out.println("-----------------");

		manService.initializeList(mans, "laoPo", "company", "waWa");

		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_manpage_service_001() {

		Page<Man> manspage = manService.page(new Page<Man>(1, 2));
		System.out.println("man total:" + manspage.getTotal());
		System.out.println("-----------------");

		autoMapper.mapperEntityPage(manspage, "laoPo");
		autoMapper.mapperEntityPage(manspage, "company");
		autoMapper.mapperEntityPage(manspage, "waWa");

		List<Man> mans = manspage.getRecords();
		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_manpage_service_001_initialize() {

		Page<Man> manspage = manService.page(new Page<Man>(2, 2));
		System.out.println("man total:" + manspage.getTotal());
		System.out.println("-----------------");

		manService.initializePage(manspage, "laoPo", "company", "waWa");

		List<Man> mans = manspage.getRecords();
		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_automapper_method_mapper() {
		List<Man> mans = manMapper.selectList(Wrappers.emptyWrapper());
		autoMapper.mapper(mans, true);

		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_automapper_method_initialize() {
		List<Man> mans = manMapper.selectList(Wrappers.emptyWrapper());
		autoMapper.initialize(mans, "laoPo", "company", "waWa");

		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

	@Test
	public void t_automapper_method_mapper2() {

		Page<Man> manspage = manService.page(new Page<Man>(1, 2));
		System.out.println("man total:" + manspage.getTotal());
		System.out.println("-----------------");

		autoMapper.mapper(manspage, "laoPo");
		autoMapper.mapper(manspage, "company");
		autoMapper.mapper(manspage, "waWa");

		List<Man> mans = manspage.getRecords();
		for (Man man : mans) {
			Woman woman = man.getLaoPo();
			System.out.println("woman:" + woman);
			Company company = man.getCompany();
			System.out.println("company:" + company);
			List<Child> waWa = man.getWaWa();
			System.out.println("waWa:" + waWa);
		}

	}

}
