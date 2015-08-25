package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
import com.techstar.dmis.service.IDdSwitchseqbillService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdSwitchseqbillService extends TestCase{
	
	private IDdSwitchseqbillService service ;
	public TestDdSwitchseqbillService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdSwitchseqbillService)factory.getBean("iDdSwitchseqbillService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdSwitchseqbill(){
	    
	   DdSwitchseqbillDto dto = new DdSwitchseqbillDto();
      if( StringUtils.isEmpty(dto.getFcomputerno())){
         dto.setFcomputerno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFmanualno("test");
  	dto.setFdate(null);
  	dto.setFmission("test");
  	dto.setFremark("test");
  	dto.setFexcutestatus("test");
  	dto.setFistypicalbill("test");
  	dto.setFbillsource("test");
  	dto.setFsrcbillno("test");
  	dto.setFstatus("test");
  	dto.setFstationname("test");
  	dto.setFvoltage(0);
  	dto.setFlinename("test");
  	dto.setFtaskname("test");
  	dto.setIspassed("test");
  	dto.setReason("test");
  	dto.setPassedchecker("test");
  	dto.setPasschecktime(null);
  	dto.setFstepcounts(0);
  	dto.setFstopreason("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFoperate("test");
  		service.saveOrUpdateDdSwitchseqbill(dto);
	}
	
	
	public void _testModifyDdSwitchseqbill(){
		DdSwitchseqbillDto dto = new DdSwitchseqbillDto();
		  	dto.setFmanualno("test");
  	dto.setFdate(null);
  	dto.setFmission("test");
  	dto.setFremark("test");
  	dto.setFexcutestatus("test");
  	dto.setFistypicalbill("test");
  	dto.setFbillsource("test");
  	dto.setFsrcbillno("test");
  	dto.setFstatus("test");
  	dto.setFstationname("test");
  	dto.setFvoltage(0);
  	dto.setFlinename("test");
  	dto.setFtaskname("test");
  	dto.setIspassed("test");
  	dto.setReason("test");
  	dto.setPassedchecker("test");
  	dto.setPasschecktime(null);
  	dto.setFstepcounts(0);
  	dto.setFstopreason("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFoperate("test");
  		service.saveOrUpdateDdSwitchseqbill(dto);
	}
	
	
	public void testListDdSwitchseqbill(){
		QueryListObj obj = service.listDdSwitchseqbill();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdSwitchseqbillDto dto = (DdSwitchseqbillDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdSwitchseqbill(){
	    //parameter param is test data
		service.deleteDdSwitchseqbill("param");
	}
	

	public void _testLoadDdSwitchseqbill(){
	    // parameter 101 is test data
		DdSwitchseqbillDto dto = service.loadDdSwitchseqbill("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
