package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdWoutageplanDto;
import com.techstar.dmis.service.IDdWoutageplanService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdWoutageplanService extends TestCase{
	
	private IDdWoutageplanService service ;
	public TestDdWoutageplanService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdWoutageplanService)factory.getBean("iDdWoutageplanService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdWoutageplan(){
	    
	   DdWoutageplanDto dto = new DdWoutageplanDto();
      if( StringUtils.isEmpty(dto.getFwplanno())){
         dto.setFwplanno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFlinename("test");
  	dto.setFvoltage("test");
  	dto.setFworkcontent("test");
  	dto.setFoutagearea("test");
  	dto.setFdispatchrange("test");
  	dto.setFstarttime(null);
  	dto.setFendtime(null);
  	dto.setFapplyunit("test");
  	dto.setFapplicant("test");
  	dto.setFapplytime(null);
  	dto.setFstatus("test");
  	dto.setFplansourcetype("test");
  	dto.setFexcutestatus("test");
  	dto.setFremark("test");
  	dto.setFunfinishreason("test");
  	dto.setFstationid("test");
  	dto.setFlinenameid("test");
  	dto.setFapplyunitid("test");
  	dto.setFunfinishreasonid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdWoutageplan(dto);
	}
	
	
	public void _testModifyDdWoutageplan(){
		DdWoutageplanDto dto = new DdWoutageplanDto();
		  	dto.setFstationname("test");
  	dto.setFlinename("test");
  	dto.setFvoltage("test");
  	dto.setFworkcontent("test");
  	dto.setFoutagearea("test");
  	dto.setFdispatchrange("test");
  	dto.setFstarttime(null);
  	dto.setFendtime(null);
  	dto.setFapplyunit("test");
  	dto.setFapplicant("test");
  	dto.setFapplytime(null);
  	dto.setFstatus("test");
  	dto.setFplansourcetype("test");
  	dto.setFexcutestatus("test");
  	dto.setFremark("test");
  	dto.setFunfinishreason("test");
  	dto.setFstationid("test");
  	dto.setFlinenameid("test");
  	dto.setFapplyunitid("test");
  	dto.setFunfinishreasonid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdWoutageplan(dto);
	}
	
	
	public void testListDdWoutageplan(){
		QueryListObj obj = service.listDdWoutageplan();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdWoutageplanDto dto = (DdWoutageplanDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdWoutageplan(){
	    //parameter param is test data
		service.deleteDdWoutageplan("param");
	}
	

	public void _testLoadDdWoutageplan(){
	    // parameter 101 is test data
		DdWoutageplanDto dto = service.loadDdWoutageplan("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
