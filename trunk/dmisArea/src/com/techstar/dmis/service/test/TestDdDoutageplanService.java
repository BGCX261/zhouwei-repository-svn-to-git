package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.service.IDdDoutageplanService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdDoutageplanService extends TestCase{
	
	private IDdDoutageplanService service ;
	public TestDdDoutageplanService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdDoutageplanService)factory.getBean("iDdDoutageplanService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdDoutageplan(){
	    
	   DdDoutageplanDto dto = new DdDoutageplanDto();
      if( StringUtils.isEmpty(dto.getFdayplanno())){
         dto.setFdayplanno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFmanualno("test");
  	dto.setFstationname("test");
  	dto.setFline("test");
  	dto.setFworkarea("test");
  	dto.setFoutagearea("test");
  	dto.setFdispatchrange("test");
  	dto.setFapplystime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyoutagetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyrestoretime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyunit("test");
  	dto.setFapplicant("test");
  	dto.setFapplytime(null);
  	dto.setFremark("test");
  	dto.setFaddipicture(null);
  	dto.setFunmeasureannex(null);
  	dto.setFattention("test");
  	dto.setFpermitcontent("test");
  	dto.setFapprooutageword("test");
  	dto.setFapprooutageno("test");
  	dto.setFapproworkstime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapproworketime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprostime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapproetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFgenoutageseq("test");
  	dto.setFplanappropeople("test");
  	dto.setFcanceltime(null);
  	dto.setFabolish("test");
  	dto.setFstatus("test");
  	dto.setFexcutestatus("test");
  	dto.setFmergeplanno(0);
  	dto.setFreportdate(null);
  	dto.setFplansourcetype("test");
  	dto.setFplansourceno("test");
  	dto.setFstationid("test");
  	dto.setFlinenameid("test");
  	dto.setFapplyunitid("test");
  	dto.setFfilltype("test");
  	dto.setWorkcontent("test");
  	dto.setIspassed("test");
  	dto.setFchecker("test");
  	dto.setReason("test");
  	dto.setFchecktime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFplanclass("test");
  	dto.setFvoltage("test");
  		service.saveOrUpdateDdDoutageplan(dto);
	}
	
	
	public void _testModifyDdDoutageplan(){
		DdDoutageplanDto dto = new DdDoutageplanDto();
		  	dto.setFmanualno("test");
  	dto.setFstationname("test");
  	dto.setFline("test");
  	dto.setFworkarea("test");
  	dto.setFoutagearea("test");
  	dto.setFdispatchrange("test");
  	dto.setFapplystime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyoutagetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyrestoretime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapplyunit("test");
  	dto.setFapplicant("test");
  	dto.setFapplytime(null);
  	dto.setFremark("test");
  	dto.setFaddipicture(null);
  	dto.setFunmeasureannex(null);
  	dto.setFattention("test");
  	dto.setFpermitcontent("test");
  	dto.setFapprooutageword("test");
  	dto.setFapprooutageno("test");
  	dto.setFapproworkstime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapproworketime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapprostime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFapproetime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFgenoutageseq("test");
  	dto.setFplanappropeople("test");
  	dto.setFcanceltime(null);
  	dto.setFabolish("test");
  	dto.setFstatus("test");
  	dto.setFexcutestatus("test");
  	dto.setFmergeplanno(0);
  	dto.setFreportdate(null);
  	dto.setFplansourcetype("test");
  	dto.setFplansourceno("test");
  	dto.setFstationid("test");
  	dto.setFlinenameid("test");
  	dto.setFapplyunitid("test");
  	dto.setFfilltype("test");
  	dto.setWorkcontent("test");
  	dto.setIspassed("test");
  	dto.setFchecker("test");
  	dto.setReason("test");
  	dto.setFchecktime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFplanclass("test");
  	dto.setFvoltage("test");
  		service.saveOrUpdateDdDoutageplan(dto);
	}
	
	
	public void testListDdDoutageplan(){
		QueryListObj obj = service.listDdDoutageplan();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdDoutageplanDto dto = (DdDoutageplanDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdDoutageplan(){
	    //parameter param is test data
		service.deleteDdDoutageplan("param");
	}
	

	public void _testLoadDdDoutageplan(){
	    // parameter 101 is test data
		DdDoutageplanDto dto = service.loadDdDoutageplan("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
