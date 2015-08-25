package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.EtsEquipmentDto;
import com.techstar.dmis.service.IEtsEquipmentService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestEtsEquipmentService extends TestCase{
	
	private IEtsEquipmentService service ;
	public TestEtsEquipmentService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IEtsEquipmentService)factory.getBean("iEtsEquipmentService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateEtsEquipment(){
	    
	   EtsEquipmentDto dto = new EtsEquipmentDto();
      if( StringUtils.isEmpty(dto.getFeqpid())){
         dto.setFeqpid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstorelocation("test");
  	dto.setFstationname("test");
  	dto.setFscheduleno("test");
  	dto.setFdevsequence("test");
  	dto.setFdevclassname("test");
  	dto.setFdevicetype("test");
  	dto.setFdevicemodel("test");
  	dto.setFschedulerange("test");
  	dto.setFdevfac("test");
  	dto.setFmadecountry("test");
  	dto.setFleavefacno("test");
  	dto.setFleavefacdate(null);
  	dto.setFinstalldate(null);
  	dto.setFrunningdate(null);
  	dto.setFdevicestatus("test");
  	dto.setFdevicelevel("test");
  	dto.setFratedvoltage("test");
  	dto.setFoperatingvoltage("test");
  	dto.setFneutralvoltage("test");
  	dto.setFrecycled("test");
  	dto.setFstopdate(null);
  	dto.setFoperatingunit("test");
  	dto.setFmaintainunit("test");
  	dto.setFupdatetime(null);
  	dto.setFisdelete("test");
  	dto.setFstationid("test");
  	dto.setFdevbuyfac("test");
  	dto.setFoverhaullife(0);
  	dto.setFminoverhaullife(0);
  	dto.setFtmprepairlife(0);
  	dto.setFcompareversion(0);
  	dto.setFbayname("test");
  	dto.setFbelstatype("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFvoltagelevel("test");
  		service.saveOrUpdateEtsEquipment(dto);
	}
	
	
	public void _testModifyEtsEquipment(){
		EtsEquipmentDto dto = new EtsEquipmentDto();
		  	dto.setFstorelocation("test");
  	dto.setFstationname("test");
  	dto.setFscheduleno("test");
  	dto.setFdevsequence("test");
  	dto.setFdevclassname("test");
  	dto.setFdevicetype("test");
  	dto.setFdevicemodel("test");
  	dto.setFschedulerange("test");
  	dto.setFdevfac("test");
  	dto.setFmadecountry("test");
  	dto.setFleavefacno("test");
  	dto.setFleavefacdate(null);
  	dto.setFinstalldate(null);
  	dto.setFrunningdate(null);
  	dto.setFdevicestatus("test");
  	dto.setFdevicelevel("test");
  	dto.setFratedvoltage("test");
  	dto.setFoperatingvoltage("test");
  	dto.setFneutralvoltage("test");
  	dto.setFrecycled("test");
  	dto.setFstopdate(null);
  	dto.setFoperatingunit("test");
  	dto.setFmaintainunit("test");
  	dto.setFupdatetime(null);
  	dto.setFisdelete("test");
  	dto.setFstationid("test");
  	dto.setFdevbuyfac("test");
  	dto.setFoverhaullife(0);
  	dto.setFminoverhaullife(0);
  	dto.setFtmprepairlife(0);
  	dto.setFcompareversion(0);
  	dto.setFbayname("test");
  	dto.setFbelstatype("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFvoltagelevel("test");
  		service.saveOrUpdateEtsEquipment(dto);
	}
	
	
	public void testListEtsEquipment(){
		QueryListObj obj = service.listEtsEquipment();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			EtsEquipmentDto dto = (EtsEquipmentDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteEtsEquipment(){
	    //parameter param is test data
		service.deleteEtsEquipment("param");
	}
	

	public void _testLoadEtsEquipment(){
	    // parameter 101 is test data
		EtsEquipmentDto dto = service.loadEtsEquipment("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
