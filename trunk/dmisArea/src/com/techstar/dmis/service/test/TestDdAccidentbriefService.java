package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.service.IDdAccidentbriefService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdAccidentbriefService extends TestCase{
	
	private IDdAccidentbriefService service ;
	public TestDdAccidentbriefService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdAccidentbriefService)factory.getBean("iDdAccidentbriefService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdAccidentbrief(){
	    
	   DdAccidentbriefDto dto = new DdAccidentbriefDto();
      if( StringUtils.isEmpty(dto.getFaccidentid())){
         dto.setFaccidentid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFaccidentname("test");
  	dto.setFaccidenttime(null);
  	dto.setFdispatcher("test");
  	dto.setFreportedpeople("test");
  	dto.setFreportdate(null);
  	dto.setFreporter("test");
  	dto.setFnotifiedunit("test");
  	dto.setFnotifyoffice("test");
  	dto.setFreportleadership("test");
  	dto.setFrecoverytime(null);
  	dto.setFfaultequipmemt("test");
  	dto.setFdispatchno("test");
  	dto.setFline("test");
  	dto.setFlesspower(0);
  	dto.setFweather("test");
  	dto.setFremark("test");
  	dto.setFtopdispreporttime(null);
  	dto.setFovercurrenttime(0);
  	dto.setFiftimes(0);
  	dto.setFothertimes(0);
  	dto.setFcontrol("test");
  	dto.setFgrounding("test");
  	dto.setFreporthandle("test");
  	dto.setFlineid("test");
  	dto.setAccidentno("test");
  	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setAccidentreason("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	//dto.setFresult("test");
  	dto.setFvoltage("test");
  	dto.setFimpact("test");
  	dto.setFwhethercompleted("test");
  		service.saveOrUpdateDdAccidentbrief(dto);
	}
	
	
	public void _testModifyDdAccidentbrief(){
		DdAccidentbriefDto dto = new DdAccidentbriefDto();
		  	dto.setFaccidentname("test");
  	dto.setFaccidenttime(null);
  	dto.setFdispatcher("test");
  	dto.setFreportedpeople("test");
  	dto.setFreportdate(null);
  	dto.setFreporter("test");
  	dto.setFnotifiedunit("test");
  	dto.setFnotifyoffice("test");
  	dto.setFreportleadership("test");
  	dto.setFrecoverytime(null);
  	dto.setFfaultequipmemt("test");
  	dto.setFdispatchno("test");
  	dto.setFline("test");
  	dto.setFlesspower(0);
  	dto.setFweather("test");
  	dto.setFremark("test");
  	dto.setFtopdispreporttime(null);
  	dto.setFovercurrenttime(0);
  	dto.setFiftimes(0);
  	dto.setFothertimes(0);
  	dto.setFcontrol("test");
  	dto.setFgrounding("test");
  	dto.setFreporthandle("test");
  	dto.setFlineid("test");
  	dto.setAccidentno("test");
  	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setAccidentreason("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	//dto.setFresult("test");
  	dto.setFvoltage("test");
  	dto.setFimpact("test");
  	dto.setFwhethercompleted("test");
  		service.saveOrUpdateDdAccidentbrief(dto);
	}
	
	
	public void testListDdAccidentbrief(){
		QueryListObj obj = service.listDdAccidentbrief();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdAccidentbriefDto dto = (DdAccidentbriefDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdAccidentbrief(){
	    //parameter param is test data
		//service.deleteDdAccidentbrief("param");
	}
	

	public void _testLoadDdAccidentbrief(){
	    // parameter 101 is test data
		DdAccidentbriefDto dto = service.loadDdAccidentbrief("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
