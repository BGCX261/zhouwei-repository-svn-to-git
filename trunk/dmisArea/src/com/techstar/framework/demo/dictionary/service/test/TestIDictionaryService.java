package com.techstar.framework.demo.dictionary.service.test;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.dictionary.service.IDictionaryService;
import com.techstar.framework.demo.dictionary.web.facade.DictionaryBaseFacade;
import com.techstar.framework.demo.dto.CompanyDto;
import com.techstar.framework.utils.TestHelper;
/**
 * 
 * @author xcf
 *
 */
public class TestIDictionaryService extends TestCase{
	
	private IDictionaryService service ;
	private DictionaryBaseFacade facade;
	public TestIDictionaryService(String name) {
		super(name);
		
	}
	//预先装载一下xml配置文件
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		service = (IDictionaryService)factory.getBean("iDictionaryService");
		facade = (DictionaryBaseFacade)factory.getBean("dictionaryBaseFacade");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
	
	
	
	public void _testdeleteEntity(){
		boolean isok = service.deleteById("Company","0");
		System.out.println( isok );
	}
	
	public void testSaveOrUpdateEntity(){
		CompanyDto dto = new CompanyDto();
		
		dto.setCompanyName("测试内部序列号");
		facade.addDic("Company", dto);
	}
	
	public void _testLoadEntity(){
		Object obj =service.findById("Company","1");
		if( obj != null ){
			CompanyDto dto = (CompanyDto)obj;
			System.out.println( dto.getId() + " " + dto.getCompanyName() );
		}
	}
	
//	测试得到字典列表
	public void testGetQueryList(){
		QueryListObj obj = service.getQueryList("Company");
		System.out.println("记录总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			CompanyDto dto = (CompanyDto)obj.getElemList().get(i);
			System.out.println( dto.getId() + " " + dto.getCompanyName() );
		
		}
	}
}


