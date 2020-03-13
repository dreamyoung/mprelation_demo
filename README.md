







Test
=====

      public class ResultmapTest {
	@Autowired
	AutoMapper autoMapper;

	@Autowired
	private IManService manService;

	@Resource
	private ChildMapper childMapper;

	@Resource
	private ManMapper manMapper;
	@Resource
	private WomanMapper womanMapper;
	
	@Resource
	private CompanyMapper companyMapper;

	@Test
	public void t_child() {
		Child child = childMapper.selectById(1L);
		System.out.println("child:"+child);

		child = autoMapper.mapperEntity(child);
		
		Man baba = child.getLaoHan();
		Woman mama = child.getLaoMa();
		System.out.println("baba:"+baba);
		System.out.println("mama:"+mama);
		
		Set<Course> courses = child.getCourses();
		System.out.println("courses:"+courses);
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
	public void t_woman() {
		Woman woman = womanMapper.selectById(1L);
		System.out.println(woman.getName());
		
		autoMapper.oneToMany(woman);
		
		List<Child> waWa = woman.getWaWa();
		System.out.println("waWa:" + waWa);
		
		Man man = woman.getLaoGong();
		System.out.println("laoGong:"+man);
	}


	@Test
	public void t_company() {

		Company company = companyMapper.selectById(1L);
		System.out.println("company name:"+company.getName());

		autoMapper.mapperEntity(company);
		
		List<Man> emplyoees = company.getEmployees();
		System.out.println("emplyoees:" + emplyoees);

	}

}






