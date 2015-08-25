package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.BhAsregulateDto;
import com.techstar.dmis.service.IBhAsregulateService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestBhAsregulateService extends TestCase{
	
	private IBhAsregulateService service ;
	public TestBhAsregulateService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IBhAsregulateService)factory.getBean("iBhAsregulateService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateBhAsregulate(){
	    
	   BhAsregulateDto dto = new BhAsregulateDto();
      if( StringUtils.isEmpty(dto.getAsregulateid())){
         dto.setAsregulateid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFwritedate(null);
  	dto.setFunitname("test");
  	dto.setDispatchcenteropinion("test");
  	dto.setRunmodedeptopinion("test");
  	dto.setProtectdeptopinion("test");
  	dto.setProtectresponsor("test");
  	dto.setExcutetime("test");
  	dto.setOndutyname("test");
  	dto.setAsregulateoriginal(null);
  	dto.setRunmodedigram(null);
  	dto.setRemarks("test");
  	dto.setAsregulateno("test");
  	dto.setFiscancel("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateBhAsregulate(dto);
	}
	
	
	public void _testModifyBhAsregulate(){
		BhAsregulateDto dto = new BhAsregulateDto();
		  	dto.setFstationname("test");
  	dto.setFwritedate(null);
  	dto.setFunitname("test");
  	dto.setDispatchcenteropinion("test");
  	dto.setRunmodedeptopinion("test");
  	dto.setProtectdeptopinion("test");
  	dto.setProtectresponsor("test");
  	dto.setExcutetime("test");
  	dto.setOndutyname("test");
  	dto.setAsregulateoriginal(null);
  	dto.setRunmodedigram(null);
  	dto.setRemarks("test");
  	dto.setAsregulateno("test");
  	dto.setFiscancel("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateBhAsregulate(dto);
	}
	
	
	public void testListBhAsregulate(){
		QueryListObj obj = service.listBhAsregulate();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			BhAsregulateDto dto = (BhAsregulateDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteBhAsregulate(){
	    //parameter param is test data
		service.deleteBhAsregulate("param");
	}
	

	public void _testLoadBhAsregulate(){
	    // parameter 101 is test data
		BhAsregulateDto dto = service.loadBhAsregulate("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
