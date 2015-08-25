package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdRepairrisklistDto;
import com.techstar.dmis.service.IDdRepairrisklistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdRepairrisklistService extends TestCase{
	
	private IDdRepairrisklistService service ;
	public TestDdRepairrisklistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdRepairrisklistService)factory.getBean("iDdRepairrisklistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdRepairrisklist(){
	    
	   DdRepairrisklistDto dto = new DdRepairrisklistDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFtransformer("test");
  	dto.setFline("test");
  	dto.setFworkcontent("test");
  	dto.setFoutagestime(null);
  	dto.setFoutageetime(null);
  	dto.setFriskprompt("test");
  	dto.setFforecast("test");
  	dto.setFriskunit("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFdangerreason("test");
  		service.saveOrUpdateDdRepairrisklist(dto);
	}
	
	
	public void _testModifyDdRepairrisklist(){
		DdRepairrisklistDto dto = new DdRepairrisklistDto();
		  	dto.setFtransformer("test");
  	dto.setFline("test");
  	dto.setFworkcontent("test");
  	dto.setFoutagestime(null);
  	dto.setFoutageetime(null);
  	dto.setFriskprompt("test");
  	dto.setFforecast("test");
  	dto.setFriskunit("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFdangerreason("test");
  		service.saveOrUpdateDdRepairrisklist(dto);
	}
	
	
	public void testListDdRepairrisklist(){
		QueryListObj obj = service.listDdRepairrisklist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdRepairrisklistDto dto = (DdRepairrisklistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdRepairrisklist(){
	    //parameter param is test data
		service.deleteDdRepairrisklist("param");
	}
	

	public void _testLoadDdRepairrisklist(){
	    // parameter 101 is test data
		DdRepairrisklistDto dto = service.loadDdRepairrisklist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
