package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdCutofflistDto;
import com.techstar.dmis.service.IDdCutofflistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdCutofflistService extends TestCase{
	
	private IDdCutofflistService service ;
	public TestDdCutofflistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdCutofflistService)factory.getBean("iDdCutofflistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdCutofflist(){
	    
	   DdCutofflistDto dto = new DdCutofflistDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFsuspdate(null);
  	dto.setFsusptime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFgiveorderunit("test");
  	dto.setFgiver("test");
  	dto.setFgiveordertime(null);
  	dto.setFloadunit("test");
  	dto.setFaccepter("test");
  	dto.setFsummitter("test");
  	dto.setFsummitordertime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFload(0);
  	dto.setFregionloadbefore(0);
  	dto.setFregionloadafter(0);
  	dto.setFrealload(0);
  	dto.setFrealno(0);
  	dto.setFrecoverytime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrecoveryload(0);
  	dto.setFrecoverygiver("test");
  	dto.setFgiverecoverytime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFaccepterrecorery("test");
  	dto.setFsummiterrecorery("test");
  	dto.setFsummiterecorerytime(null);
  	dto.setFloadunitid("test");
  	dto.setFfatherid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFordertype("test");
  		service.saveOrUpdateDdCutofflist(dto);
	}
	
	
	public void _testModifyDdCutofflist(){
		DdCutofflistDto dto = new DdCutofflistDto();
		  	dto.setFsuspdate(null);
  	dto.setFsusptime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFgiveorderunit("test");
  	dto.setFgiver("test");
  	dto.setFgiveordertime(null);
  	dto.setFloadunit("test");
  	dto.setFaccepter("test");
  	dto.setFsummitter("test");
  	dto.setFsummitordertime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFload(0);
  	dto.setFregionloadbefore(0);
  	dto.setFregionloadafter(0);
  	dto.setFrealload(0);
  	dto.setFrealno(0);
  	dto.setFrecoverytime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFrecoveryload(0);
  	dto.setFrecoverygiver("test");
  	dto.setFgiverecoverytime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFaccepterrecorery("test");
  	dto.setFsummiterrecorery("test");
  	dto.setFsummiterecorerytime(null);
  	dto.setFloadunitid("test");
  	dto.setFfatherid("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFordertype("test");
  		service.saveOrUpdateDdCutofflist(dto);
	}
	
	
	public void testListDdCutofflist(){
		QueryListObj obj = service.listDdCutofflist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdCutofflistDto dto = (DdCutofflistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdCutofflist(){
	    //parameter param is test data
		service.deleteDdCutofflist("param");
	}
	

	public void _testLoadDdCutofflist(){
	    // parameter 101 is test data
		DdCutofflistDto dto = service.loadDdCutofflist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
