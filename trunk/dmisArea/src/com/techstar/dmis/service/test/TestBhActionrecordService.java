package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.BhActionrecordDto;
import com.techstar.dmis.service.IBhActionrecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestBhActionrecordService extends TestCase{
	
	private IBhActionrecordService service ;
	public TestBhActionrecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IBhActionrecordService)factory.getBean("iBhActionrecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateBhActionrecord(){
	    
	   BhActionrecordDto dto = new BhActionrecordDto();
      if( StringUtils.isEmpty(dto.getProtectionrecordid())){
         dto.setProtectionrecordid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setDispatchno("test");
  	dto.setActiontime(null);
  	dto.setActionevaluatetimes(0);
  	dto.setFaultrecordertimes(0);
  	dto.setFaultrecordergoodtimes(0);
  	dto.setFaulteqp("test");
  	dto.setActiondescription(null);
  	dto.setActionkeeptimes(0);
  	dto.setFaultkeeptimes(0);
  	dto.setSwitchmodel("test");
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setActionevaluate("test");
  	dto.setReclosuremode("test");
  	dto.setIsreclosure("test");
  	dto.setLinereclosure("test");
  		service.saveOrUpdateBhActionrecord(dto);
	}
	
	
	public void _testModifyBhActionrecord(){
		BhActionrecordDto dto = new BhActionrecordDto();
		  	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setDispatchno("test");
  	dto.setActiontime(null);
  	dto.setActionevaluatetimes(0);
  	dto.setFaultrecordertimes(0);
  	dto.setFaultrecordergoodtimes(0);
  	dto.setFaulteqp("test");
  	dto.setActiondescription(null);
  	dto.setActionkeeptimes(0);
  	dto.setFaultkeeptimes(0);
  	dto.setSwitchmodel("test");
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setActionevaluate("test");
  	dto.setReclosuremode("test");
  	dto.setIsreclosure("test");
  	dto.setLinereclosure("test");
  		service.saveOrUpdateBhActionrecord(dto);
	}
	
	
	public void testListBhActionrecord(){
		QueryListObj obj = service.listBhActionrecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			BhActionrecordDto dto = (BhActionrecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteBhActionrecord(){
	    //parameter param is test data
		service.deleteBhActionrecord("param");
	}
	

	public void _testLoadBhActionrecord(){
	    // parameter 101 is test data
		BhActionrecordDto dto = service.loadBhActionrecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
