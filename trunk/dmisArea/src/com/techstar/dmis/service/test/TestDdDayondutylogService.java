package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdDayondutylogDto;
import com.techstar.dmis.service.IDdDayondutylogService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdDayondutylogService extends TestCase{
	
	private IDdDayondutylogService service ;
	public TestDdDayondutylogService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdDayondutylogService)factory.getBean("iDdDayondutylogService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdDayondutylog(){
	    
	   DdDayondutylogDto dto = new DdDayondutylogDto();
      if( StringUtils.isEmpty(dto.getFondutyid())){
         dto.setFondutyid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setContent(null);
  	dto.setLogdate(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdDayondutylog(dto);
	}
	
	
	public void _testModifyDdDayondutylog(){
		DdDayondutylogDto dto = new DdDayondutylogDto();
		  	dto.setContent(null);
  	dto.setLogdate(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdDayondutylog(dto);
	}
	
	
	public void testListDdDayondutylog(){
		QueryListObj obj = service.listDdDayondutylog();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdDayondutylogDto dto = (DdDayondutylogDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdDayondutylog(){
	    //parameter param is test data
		service.deleteDdDayondutylog("param");
	}
	

	public void _testLoadDdDayondutylog(){
	    // parameter 101 is test data
		DdDayondutylogDto dto = service.loadDdDayondutylog("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}