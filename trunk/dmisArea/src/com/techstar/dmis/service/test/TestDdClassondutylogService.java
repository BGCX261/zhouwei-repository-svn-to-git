package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.service.IDdClassondutylogService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdClassondutylogService extends TestCase{
	
	private IDdClassondutylogService service ;
	public TestDdClassondutylogService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdClassondutylogService)factory.getBean("iDdClassondutylogService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdClassondutylog(){
	    
	   DdClassondutylogDto dto = new DdClassondutylogDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFsuccessiontime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFhandovertime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFminister("test");
  	dto.setFmainattendant("test");
  	dto.setFsecondattendant("test");
  	dto.setFdelresponser("test");
  	dto.setFdelworkgroup("test");
  	dto.setFdelattworkgroup("test");
  	dto.setFforecast("test");
  	dto.setFdelivercnt("test");
  	dto.setContent(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFworkshift("test");
  		service.saveOrUpdateDdClassondutylog(dto);
	}
	
	
	public void _testModifyDdClassondutylog(){
		DdClassondutylogDto dto = new DdClassondutylogDto();
		  	dto.setFsuccessiontime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFhandovertime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFminister("test");
  	dto.setFmainattendant("test");
  	dto.setFsecondattendant("test");
  	dto.setFdelresponser("test");
  	dto.setFdelworkgroup("test");
  	dto.setFdelattworkgroup("test");
  	dto.setFforecast("test");
  	dto.setFdelivercnt("test");
  	dto.setContent(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFworkshift("test");
  		service.saveOrUpdateDdClassondutylog(dto);
	}
	
	
	public void testListDdClassondutylog(){
		QueryListObj obj = service.listDdClassondutylog();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdClassondutylogDto dto = (DdClassondutylogDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdClassondutylog(){
	    //parameter param is test data
		service.deleteDdClassondutylog("param");
	}
	

	public void _testLoadDdClassondutylog(){
	    // parameter 101 is test data
		DdClassondutylogDto dto = service.loadDdClassondutylog("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
