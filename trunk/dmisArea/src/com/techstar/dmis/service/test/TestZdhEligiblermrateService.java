package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhEligiblermrateDto;
import com.techstar.dmis.service.IZdhEligiblermrateService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhEligiblermrateService extends TestCase{
	
	private IZdhEligiblermrateService service ;
	public TestZdhEligiblermrateService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhEligiblermrateService)factory.getBean("iZdhEligiblermrateService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhEligiblermrate(){
	    
	   ZdhEligiblermrateDto dto = new ZdhEligiblermrateDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setReportsdate(null);
  	dto.setRemotemeasureamount(0);
  	dto.setFailuredatanoamount(0);
  	dto.setEligiblerate(0);
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhEligiblermrate(dto);
	}
	
	
	public void _testModifyZdhEligiblermrate(){
		ZdhEligiblermrateDto dto = new ZdhEligiblermrateDto();
		  	dto.setReportsdate(null);
  	dto.setRemotemeasureamount(0);
  	dto.setFailuredatanoamount(0);
  	dto.setEligiblerate(0);
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhEligiblermrate(dto);
	}
	
	
	public void testListZdhEligiblermrate(){
		QueryListObj obj = service.listZdhEligiblermrate();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhEligiblermrateDto dto = (ZdhEligiblermrateDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhEligiblermrate(){
	    //parameter param is test data
		service.deleteZdhEligiblermrate("param");
	}
	

	public void _testLoadZdhEligiblermrate(){
	    // parameter 101 is test data
		ZdhEligiblermrateDto dto = service.loadZdhEligiblermrate("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
