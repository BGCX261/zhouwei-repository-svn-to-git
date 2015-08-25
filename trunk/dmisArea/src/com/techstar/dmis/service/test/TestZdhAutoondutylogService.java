package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.service.IZdhAutoondutylogService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhAutoondutylogService extends TestCase{
	
	private IZdhAutoondutylogService service ;
	public TestZdhAutoondutylogService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhAutoondutylogService)factory.getBean("iZdhAutoondutylogService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhAutoondutylog(){
	    
	   ZdhAutoondutylogDto dto = new ZdhAutoondutylogDto();
      if( StringUtils.isEmpty(dto.getOndutyno())){
         dto.setOndutyno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setLogdate(null);
  	dto.setSuccessiontime(null);
  	dto.setHandovertime(null);
  	dto.setAttendant2("test");
  	dto.setSuccessor2("test");
  	dto.setUpstemperature(0);
  	dto.setMachinehalltemperature(0);
  	dto.setMachinehallhealth("test");
  	dto.setMorningreportsystem("test");
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhAutoondutylog(dto);
	}
	
	
	public void _testModifyZdhAutoondutylog(){
		ZdhAutoondutylogDto dto = new ZdhAutoondutylogDto();
		  	dto.setLogdate(null);
  	dto.setSuccessiontime(null);
  	dto.setHandovertime(null);
  	dto.setAttendant2("test");
  	dto.setSuccessor2("test");
  	dto.setUpstemperature(0);
  	dto.setMachinehalltemperature(0);
  	dto.setMachinehallhealth("test");
  	dto.setMorningreportsystem("test");
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhAutoondutylog(dto);
	}
	
	
	public void testListZdhAutoondutylog(){
		QueryListObj obj = service.listZdhAutoondutylog();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhAutoondutylogDto dto = (ZdhAutoondutylogDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhAutoondutylog(){
	    //parameter param is test data
		service.deleteZdhAutoondutylog("param");
	}
	

	public void _testLoadZdhAutoondutylog(){
	    // parameter 101 is test data
		ZdhAutoondutylogDto dto = service.loadZdhAutoondutylog("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
