package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
import com.techstar.dmis.service.IZdhOpexaminelistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhOpexaminelistService extends TestCase{
	
	private IZdhOpexaminelistService service ;
	public TestZdhOpexaminelistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhOpexaminelistService)factory.getBean("iZdhOpexaminelistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhOpexaminelist(){
	    
	   ZdhOpexaminelistDto dto = new ZdhOpexaminelistDto();
      if( StringUtils.isEmpty(dto.getExaminationid())){
         dto.setExaminationid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setBegincheck("test");
  	dto.setFinishcheck("test");
  	dto.setFinishchecker("test");
  	dto.setBeginchecker("test");
  	dto.setBeginchecktime(null);
  	dto.setFinishchecktime(null);
  	dto.setEondutylogno("test");
  	dto.setFapplystime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFworkcontent("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhOpexaminelist(dto);
	}
	
	
	public void _testModifyZdhOpexaminelist(){
		ZdhOpexaminelistDto dto = new ZdhOpexaminelistDto();
		  	dto.setBegincheck("test");
  	dto.setFinishcheck("test");
  	dto.setFinishchecker("test");
  	dto.setBeginchecker("test");
  	dto.setBeginchecktime(null);
  	dto.setFinishchecktime(null);
  	dto.setEondutylogno("test");
  	dto.setFapplystime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFworkcontent("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhOpexaminelist(dto);
	}
	
	
	public void testListZdhOpexaminelist(){
		QueryListObj obj = service.listZdhOpexaminelist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhOpexaminelistDto dto = (ZdhOpexaminelistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhOpexaminelist(){
	    //parameter param is test data
		service.deleteZdhOpexaminelist("param");
	}
	

	public void _testLoadZdhOpexaminelist(){
	    // parameter 101 is test data
		ZdhOpexaminelistDto dto = service.loadZdhOpexaminelist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
