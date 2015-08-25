package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhMachineworklistDto;
import com.techstar.dmis.service.IZdhMachineworklistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhMachineworklistService extends TestCase{
	
	private IZdhMachineworklistService service ;
	public TestZdhMachineworklistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhMachineworklistService)factory.getBean("iZdhMachineworklistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhMachineworklist(){
	    
	   ZdhMachineworklistDto dto = new ZdhMachineworklistDto();
      if( StringUtils.isEmpty(dto.getJobid())){
         dto.setJobid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setWorkingtime(null);
  	dto.setContent("test");
  	dto.setWorkingsources("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setJobcategory("test");
  	dto.setFexcutestatus("test");
  		service.saveOrUpdateZdhMachineworklist(dto);
	}
	
	
	public void _testModifyZdhMachineworklist(){
		ZdhMachineworklistDto dto = new ZdhMachineworklistDto();
		  	dto.setWorkingtime(null);
  	dto.setContent("test");
  	dto.setWorkingsources("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setJobcategory("test");
  	dto.setFexcutestatus("test");
  		service.saveOrUpdateZdhMachineworklist(dto);
	}
	
	
	public void testListZdhMachineworklist(){
		QueryListObj obj = service.listZdhMachineworklist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhMachineworklistDto dto = (ZdhMachineworklistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhMachineworklist(){
	    //parameter param is test data
		service.deleteZdhMachineworklist("param");
	}
	

	public void _testLoadZdhMachineworklist(){
	    // parameter 101 is test data
		ZdhMachineworklistDto dto = service.loadZdhMachineworklist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
