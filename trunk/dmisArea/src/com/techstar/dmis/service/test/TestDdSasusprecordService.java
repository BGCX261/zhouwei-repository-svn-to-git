package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdSasusprecordDto;
import com.techstar.dmis.service.IDdSasusprecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdSasusprecordService extends TestCase{
	
	private IDdSasusprecordService service ;
	public TestDdSasusprecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdSasusprecordService)factory.getBean("iDdSasusprecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdSasusprecord(){
	    
	   DdSasusprecordDto dto = new DdSasusprecordDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFsuspswitchno("test");
  	dto.setFratedcurrent(0);
  	dto.setFncurrent(0);
  	dto.setFnloadrate(0);
  	dto.setFsusptime(null);
  	dto.setFrestoretime(null);
  	dto.setFkeeptime(0);
  	dto.setFstationid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFsuspreason("test");
  	dto.setFiswritelog("test");
  	dto.setFiswriteinwglog("test");
  		service.saveOrUpdateDdSasusprecord(dto);
	}
	
	
	public void _testModifyDdSasusprecord(){
		DdSasusprecordDto dto = new DdSasusprecordDto();
		  	dto.setFstationname("test");
  	dto.setFsuspswitchno("test");
  	dto.setFratedcurrent(0);
  	dto.setFncurrent(0);
  	dto.setFnloadrate(0);
  	dto.setFsusptime(null);
  	dto.setFrestoretime(null);
  	dto.setFkeeptime(0);
  	dto.setFstationid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFsuspreason("test");
  	dto.setFiswritelog("test");
  	dto.setFiswriteinwglog("test");
  		service.saveOrUpdateDdSasusprecord(dto);
	}
	
	
	public void testListDdSasusprecord(){
		QueryListObj obj = service.listDdSasusprecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdSasusprecordDto dto = (DdSasusprecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdSasusprecord(){
	    //parameter param is test data
		service.deleteDdSasusprecord("param");
	}
	

	public void _testLoadDdSasusprecord(){
	    // parameter 101 is test data
		DdSasusprecordDto dto = service.loadDdSasusprecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
