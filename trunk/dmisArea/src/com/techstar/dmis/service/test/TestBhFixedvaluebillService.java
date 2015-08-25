package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.BhFixedvaluebillDto;
import com.techstar.dmis.service.IBhFixedvaluebillService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestBhFixedvaluebillService extends TestCase{
	
	private IBhFixedvaluebillService service ;
	public TestBhFixedvaluebillService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IBhFixedvaluebillService)factory.getBean("iBhFixedvaluebillService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateBhFixedvaluebill(){
	    
	   BhFixedvaluebillDto dto = new BhFixedvaluebillDto();
      if( StringUtils.isEmpty(dto.getFixvaluebillno())){
         dto.setFixvaluebillno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFixvaluedate(null);
  	dto.setFstatus("test");
  	dto.setFapprover("test");
  	dto.setFchecker("test");
  	dto.setFcaculator("test");
  	dto.setFremark("test");
  	dto.setFexcutetime(null);
  	dto.setOndutymember("test");
  	dto.setFixvalueoriginal(null);
  	dto.setFixvalueno("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFchangereason("test");
  		service.saveOrUpdateBhFixedvaluebill(dto);
	}
	
	
	public void _testModifyBhFixedvaluebill(){
		BhFixedvaluebillDto dto = new BhFixedvaluebillDto();
		  	dto.setFixvaluedate(null);
  	dto.setFstatus("test");
  	dto.setFapprover("test");
  	dto.setFchecker("test");
  	dto.setFcaculator("test");
  	dto.setFremark("test");
  	dto.setFexcutetime(null);
  	dto.setOndutymember("test");
  	dto.setFixvalueoriginal(null);
  	dto.setFixvalueno("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFchangereason("test");
  		service.saveOrUpdateBhFixedvaluebill(dto);
	}
	
	
	public void testListBhFixedvaluebill(){
		QueryListObj obj = service.listBhFixedvaluebill();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			BhFixedvaluebillDto dto = (BhFixedvaluebillDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteBhFixedvaluebill(){
	    //parameter param is test data
		service.deleteBhFixedvaluebill("param");
	}
	

	public void _testLoadBhFixedvaluebill(){
	    // parameter 101 is test data
		BhFixedvaluebillDto dto = service.loadBhFixedvaluebill("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
