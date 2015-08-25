package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.service.IDdHloadrecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdHloadrecordService extends TestCase{
	
	private IDdHloadrecordService service ;
	public TestDdHloadrecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdHloadrecordService)factory.getBean("iDdHloadrecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdHloadrecord(){
	    
	   DdHloadrecordDto dto = new DdHloadrecordDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFlogdate(null);
  	dto.setFstationname("test");
  	dto.setFdevclass("test");
  	dto.setFdevname("test");
  	dto.setFlinename("test");
  	dto.setFfixcurrent(0);
  	dto.setFmaxloadcur(0);
  	dto.setFstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFendtime(null);
  	dto.setFkeeptime(0);
  	dto.setFhighestloadrate(0);
  	dto.setFtemperature(0);
  	dto.setFremark("test");
  	dto.setFiswritelog("test");
  	dto.setFiswriteinwglog("test");
  	dto.setFstationid("test");
  	dto.setFlineid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFadopmeasure("test");
  		service.saveOrUpdateDdHloadrecord(dto);
	}
	
	
	public void _testModifyDdHloadrecord(){
		DdHloadrecordDto dto = new DdHloadrecordDto();
		  	dto.setFlogdate(null);
  	dto.setFstationname("test");
  	dto.setFdevclass("test");
  	dto.setFdevname("test");
  	dto.setFlinename("test");
  	dto.setFfixcurrent(0);
  	dto.setFmaxloadcur(0);
  	dto.setFstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFendtime(null);
  	dto.setFkeeptime(0);
  	dto.setFhighestloadrate(0);
  	dto.setFtemperature(0);
  	dto.setFremark("test");
  	dto.setFiswritelog("test");
  	dto.setFiswriteinwglog("test");
  	dto.setFstationid("test");
  	dto.setFlineid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFadopmeasure("test");
  		service.saveOrUpdateDdHloadrecord(dto);
	}
	
	
	public void testListDdHloadrecord(){
		QueryListObj obj = service.listDdHloadrecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdHloadrecordDto dto = (DdHloadrecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdHloadrecord(){
	    //parameter param is test data
		service.deleteDdHloadrecord("param");
	}
	

	public void _testLoadDdHloadrecord(){
	    // parameter 101 is test data
		DdHloadrecordDto dto = service.loadDdHloadrecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
