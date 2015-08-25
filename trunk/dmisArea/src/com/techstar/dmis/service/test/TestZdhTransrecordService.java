package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.service.IZdhTransrecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhTransrecordService extends TestCase{
	
	private IZdhTransrecordService service ;
	public TestZdhTransrecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhTransrecordService)factory.getBean("iZdhTransrecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhTransrecord(){
	    
	   ZdhTransrecordDto dto = new ZdhTransrecordDto();
      if( StringUtils.isEmpty(dto.getTransrecordid())){
         dto.setTransrecordid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setTransreason("test");
  	dto.setTranspeople("test");
  	dto.setTransdate(null);
  	dto.setTransunit("test");
  	dto.setExplanation("test");
  	dto.setSourcetaskno("test");
  	dto.setAnnexsequence(null);
  	dto.setTransrecordno("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setTasksource("test");
  		service.saveOrUpdateZdhTransrecord(dto);
	}
	
	
	public void _testModifyZdhTransrecord(){
		ZdhTransrecordDto dto = new ZdhTransrecordDto();
		  	dto.setFstationname("test");
  	dto.setTransreason("test");
  	dto.setTranspeople("test");
  	dto.setTransdate(null);
  	dto.setTransunit("test");
  	dto.setExplanation("test");
  	dto.setSourcetaskno("test");
  	dto.setAnnexsequence(null);
  	dto.setTransrecordno("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setTasksource("test");
  		service.saveOrUpdateZdhTransrecord(dto);
	}
	
	
	public void testListZdhTransrecord(){
		QueryListObj obj = service.listZdhTransrecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhTransrecordDto dto = (ZdhTransrecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhTransrecord(){
	    //parameter param is test data
		service.deleteZdhTransrecord("param");
	}
	

	public void _testLoadZdhTransrecord(){
	    // parameter 101 is test data
		ZdhTransrecordDto dto = service.loadZdhTransrecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
