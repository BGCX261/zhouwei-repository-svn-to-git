package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhWorkbillDto;
import com.techstar.dmis.service.IZdhWorkbillService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhWorkbillService extends TestCase{
	
	private IZdhWorkbillService service ;
	public TestZdhWorkbillService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhWorkbillService)factory.getBean("iZdhWorkbillService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhWorkbill(){
	    
	   ZdhWorkbillDto dto = new ZdhWorkbillDto();
      if( StringUtils.isEmpty(dto.getWorkbillid())){
         dto.setWorkbillid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setWorkingbillno("test");
  	dto.setApplicationunit("test");
  	dto.setApplicantedtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setApplicants("test");
  	dto.setApplicantsnum(0);
  	dto.setWorkingcharge("test");
  	dto.setWorktime(null);
  	dto.setWorkcontent("test");
  	dto.setRelativesystem("test");
  	dto.setRelativeequipment("test");
  	dto.setDangerouspoint("test");
  	dto.setSafetyremarks(null);
  	dto.setRemarks("test");
  	dto.setWorkingbilltype("test");
  	dto.setWorkingbillreason("test");
  	dto.setWorkingbillresponsdept("test");
  	dto.setAnalysereport(null);
  	dto.setReason("test");
  	dto.setWorkbegintime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setPasschecker("test");
  	dto.setPasschecktime(null);
  	dto.setFapprover("test");
  	dto.setFallower("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFexcutestatus("test");
  	dto.setIspassed("test");
  		service.saveOrUpdateZdhWorkbill(dto);
	}
	
	
	public void _testModifyZdhWorkbill(){
		ZdhWorkbillDto dto = new ZdhWorkbillDto();
		  	dto.setWorkingbillno("test");
  	dto.setApplicationunit("test");
  	dto.setApplicantedtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setApplicants("test");
  	dto.setApplicantsnum(0);
  	dto.setWorkingcharge("test");
  	dto.setWorktime(null);
  	dto.setWorkcontent("test");
  	dto.setRelativesystem("test");
  	dto.setRelativeequipment("test");
  	dto.setDangerouspoint("test");
  	dto.setSafetyremarks(null);
  	dto.setRemarks("test");
  	dto.setWorkingbilltype("test");
  	dto.setWorkingbillreason("test");
  	dto.setWorkingbillresponsdept("test");
  	dto.setAnalysereport(null);
  	dto.setReason("test");
  	dto.setWorkbegintime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setPasschecker("test");
  	dto.setPasschecktime(null);
  	dto.setFapprover("test");
  	dto.setFallower("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFexcutestatus("test");
  	dto.setIspassed("test");
  		service.saveOrUpdateZdhWorkbill(dto);
	}
	
	
	public void testListZdhWorkbill(){
		QueryListObj obj = service.listZdhWorkbill();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhWorkbillDto dto = (ZdhWorkbillDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhWorkbill(){
	    //parameter param is test data
		service.deleteZdhWorkbill("param");
	}
	

	public void _testLoadZdhWorkbill(){
	    // parameter 101 is test data
		ZdhWorkbillDto dto = service.loadZdhWorkbill("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
