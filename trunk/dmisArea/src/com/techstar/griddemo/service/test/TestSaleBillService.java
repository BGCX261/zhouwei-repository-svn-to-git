package com.techstar.griddemo.service.test;
import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.utils.TestHelper;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.service.ISaleBillService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestSaleBillService extends TestCase{
	
	private ISaleBillService service ;
	public TestSaleBillService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("griddemo");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (ISaleBillService)factory.getBean("iSaleBillService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateSaleBill(){
	    
	   SaleBillDto dto = new SaleBillDto();
      if( StringUtils.isEmpty(dto.getId())){
         dto.setId( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setCre_date(null);
  	dto.setCustom_id("test");
  	dto.setCustom_name("test");
  	dto.setSale_mode("test");
  	dto.setTranpriority("test");
  	dto.setTotal(0);
  	dto.setMemo("test");
  	dto.setCheck_begin_date(null);
  	dto.setCheck_end_date(null);
  	dto.setSale_doc(null);
  		service.saveOrUpdateSaleBill(dto);
	}
	
	
	public void _testModifySaleBill(){
		SaleBillDto dto = new SaleBillDto();
		  	dto.setCre_date(null);
  	dto.setCustom_id("test");
  	dto.setCustom_name("test");
  	dto.setSale_mode("test");
  	dto.setTranpriority("test");
  	dto.setTotal(0);
  	dto.setMemo("test");
  	dto.setCheck_begin_date(null);
  	dto.setCheck_end_date(null);
  	dto.setSale_doc(null);
  		service.saveOrUpdateSaleBill(dto);
	}
	
	
	public void testListSaleBill(){
		QueryListObj obj = service.listSaleBill();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			SaleBillDto dto = (SaleBillDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteSaleBill(){
	    //parameter param is test data
		service.deleteSaleBill("param");
	}
	

	public void _testLoadSaleBill(){
	    // parameter 101 is test data
		SaleBillDto dto = service.loadSaleBill("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
