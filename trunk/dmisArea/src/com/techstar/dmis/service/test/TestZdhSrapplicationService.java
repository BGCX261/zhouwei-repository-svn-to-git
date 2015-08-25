package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhSrapplicationDto;
import com.techstar.dmis.service.IZdhSrapplicationService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhSrapplicationService extends TestCase{
	
	private IZdhSrapplicationService service ;
	public TestZdhSrapplicationService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhSrapplicationService)factory.getBean("iZdhSrapplicationService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhSrapplication(){
	    
	   ZdhSrapplicationDto dto = new ZdhSrapplicationDto();
      if( StringUtils.isEmpty(dto.getFapplicationno())){
         dto.setFapplicationno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationid("test");
  	dto.setFstationname("test");
  	dto.setFeqpclasstype("test");
  	dto.setFeqpclassname("test");
  	dto.setFmaintenancerange("test");
  	dto.setFapplicationstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplicationendime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprovalstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprovalendtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrealstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrealendtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFremarks("test");
  	dto.setFapplicationtype("test");
  	dto.setFannexexplanation(null);
  	dto.setFexcutestatus("test");
  	dto.setFstatus("test");
  	dto.setFkeeptime(0);
  	dto.setFapplicationono("test");
  	dto.setFlocalopinion("test");
  	dto.setFcenteropinion2("test");
  	dto.setFlocalopinion2("test");
  	dto.setFcenteropinion1("test");
  	dto.setFcenteropinion3("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFattribute("test");
  	dto.setFisstop("test");
  		service.saveOrUpdateZdhSrapplication(dto);
	}
	
	
	public void _testModifyZdhSrapplication(){
		ZdhSrapplicationDto dto = new ZdhSrapplicationDto();
		  	dto.setFstationid("test");
  	dto.setFstationname("test");
  	dto.setFeqpclasstype("test");
  	dto.setFeqpclassname("test");
  	dto.setFmaintenancerange("test");
  	dto.setFapplicationstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplicationendime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprovalstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprovalendtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrealstarttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrealendtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFremarks("test");
  	dto.setFapplicationtype("test");
  	dto.setFannexexplanation(null);
  	dto.setFexcutestatus("test");
  	dto.setFstatus("test");
  	dto.setFkeeptime(0);
  	dto.setFapplicationono("test");
  	dto.setFlocalopinion("test");
  	dto.setFcenteropinion2("test");
  	dto.setFlocalopinion2("test");
  	dto.setFcenteropinion1("test");
  	dto.setFcenteropinion3("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFattribute("test");
  	dto.setFisstop("test");
  		service.saveOrUpdateZdhSrapplication(dto);
	}
	
	/*
	public void testListZdhSrapplication(){
		QueryListObj obj = service.listZdhSrapplication();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhSrapplicationDto dto = (ZdhSrapplicationDto)obj.getElemList().get(i);
			System.out.println(dto.getFapplicationno());
		}
	}
	
	*/
	public void testDeleteZdhSrappeqprel(){
	    //parameter param is test data
		ZdhSrapplicationDto dto = new ZdhSrapplicationDto();
		dto.setFapplicationno("3F8C384FFFC441130B6A49257B16C");
		dto.setVersion(0);
		List dtos = new ArrayList();
		dtos.add(dto);
		service.deleteZdhSrappeqprel(dtos);
	}
	

	public void _testLoadZdhSrapplication(){
	    // parameter 101 is test data
		ZdhSrapplicationDto dto = service.loadZdhSrapplication("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
