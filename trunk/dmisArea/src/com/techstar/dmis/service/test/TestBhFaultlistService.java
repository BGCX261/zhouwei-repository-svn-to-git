package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.BhFaultlistDto;
import com.techstar.dmis.service.IBhFaultlistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestBhFaultlistService extends TestCase{
	
	private IBhFaultlistService service ;
	public TestBhFaultlistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IBhFaultlistService)factory.getBean("iBhFaultlistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateBhFaultlist(){
	    
	   BhFaultlistDto dto = new BhFaultlistDto();
      if( StringUtils.isEmpty(dto.getFfaultno())){
         dto.setFfaultno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFdispatchname("test");
  	dto.setFhandleresult("test");
  	dto.setFoccurredtime(null);
  	dto.setFrestoretime(null);
  	dto.setFcontinuetime(0);
  	dto.setDataowner("test");
  	dto.setFstates("test");
  	dto.setFstationid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFstaticreason("test");
  	dto.setFfaultgrade("test");
  		service.saveOrUpdateBhFaultlist(dto);
	}
	
	
	public void _testModifyBhFaultlist(){
		BhFaultlistDto dto = new BhFaultlistDto();
		  	dto.setFstationname("test");
  	dto.setFdispatchname("test");
  	dto.setFhandleresult("test");
  	dto.setFoccurredtime(null);
  	dto.setFrestoretime(null);
  	dto.setFcontinuetime(0);
  	dto.setDataowner("test");
  	dto.setFstates("test");
  	dto.setFstationid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFstaticreason("test");
  	dto.setFfaultgrade("test");
  		service.saveOrUpdateBhFaultlist(dto);
	}
	
	
	public void testListBhFaultlist(){
		QueryListObj obj = service.listBhFaultlist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			BhFaultlistDto dto = (BhFaultlistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteBhFaultlist(){
	    //parameter param is test data
		service.deleteBhFaultlist("param");
	}
	

	public void _testLoadBhFaultlist(){
	    // parameter 101 is test data
		BhFaultlistDto dto = service.loadBhFaultlist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
