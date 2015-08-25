package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.RepRepresultDto;
import com.techstar.dmis.service.IRepRepresultService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestRepRepresultService extends TestCase{
	
	private IRepRepresultService service ;
	public TestRepRepresultService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IRepRepresultService)factory.getBean("iRepRepresultService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateRepRepresult(){
	    
	   RepRepresultDto dto = new RepRepresultDto();
      if( StringUtils.isEmpty(dto.getFrepresultid())){
         dto.setFrepresultid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setTreeid("test");
  	dto.setFname("test");
  	dto.setFtitle("test");
  	dto.setFreportyear(0);
  	dto.setFreportunit("test");
  	dto.setFrawdata("test");
  	dto.setFotherinfo("test");
  	dto.setFdescription("test");
  	dto.setFrepmonth(0);
  	dto.setFrepseason(0);
  	dto.setFrepday(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateRepRepresult(dto);
	}
	
	
	public void _testModifyRepRepresult(){
		RepRepresultDto dto = new RepRepresultDto();
		  	dto.setTreeid("test");
  	dto.setFname("test");
  	dto.setFtitle("test");
  	dto.setFreportyear(0);
  	dto.setFreportunit("test");
  	dto.setFrawdata("test");
  	dto.setFotherinfo("test");
  	dto.setFdescription("test");
  	dto.setFrepmonth(0);
  	dto.setFrepseason(0);
  	dto.setFrepday(null);
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateRepRepresult(dto);
	}
	
	
	public void testListRepRepresult(){
		QueryListObj obj = service.listRepRepresult();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			RepRepresultDto dto = (RepRepresultDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteRepRepresult(){
	    //parameter param is test data
		service.deleteRepRepresult("param");
	}
	

	public void _testLoadRepRepresult(){
	    // parameter 101 is test data
		RepRepresultDto dto = service.loadRepRepresult("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
