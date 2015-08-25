package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhRsrecordDto;
import com.techstar.dmis.service.IZdhRsrecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhRsrecordService extends TestCase{
	
	private IZdhRsrecordService service ;
	public TestZdhRsrecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhRsrecordService)factory.getBean("iZdhRsrecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhRsrecord(){
	    
	   ZdhRsrecordDto dto = new ZdhRsrecordDto();
      if( StringUtils.isEmpty(dto.getRecordid())){
         dto.setRecordid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setRighttimes(0);
  	dto.setCorrecttimes(0);
  	dto.setActionnote("test");
  	dto.setAccidenttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setAccidentname("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhRsrecord(dto);
	}
	
	
	public void _testModifyZdhRsrecord(){
		ZdhRsrecordDto dto = new ZdhRsrecordDto();
		  	dto.setRighttimes(0);
  	dto.setCorrecttimes(0);
  	dto.setActionnote("test");
  	dto.setAccidenttime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setAccidentname("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhRsrecord(dto);
	}
	
	
	public void testListZdhRsrecord(){
		QueryListObj obj = service.listZdhRsrecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhRsrecordDto dto = (ZdhRsrecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhRsrecord(){
	    //parameter param is test data
		service.deleteZdhRsrecord("param");
	}
	

	public void _testLoadZdhRsrecord(){
	    // parameter 101 is test data
		ZdhRsrecordDto dto = service.loadZdhRsrecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
