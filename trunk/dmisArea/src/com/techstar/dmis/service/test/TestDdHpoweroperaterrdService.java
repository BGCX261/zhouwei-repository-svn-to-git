package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.service.IDdHpoweroperaterrdService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdHpoweroperaterrdService extends TestCase{
	
	private IDdHpoweroperaterrdService service ;
	public TestDdHpoweroperaterrdService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdHpoweroperaterrdService)factory.getBean("iDdHpoweroperaterrdService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdHpoweroperaterrd(){
	    
	   DdHpoweroperaterrdDto dto = new DdHpoweroperaterrdDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFplant("test");
  	dto.setFsendcmder("test");
  	dto.setFreccmder("test");
  	dto.setFsendcmdtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFsendcmdwaterlevel(0);
  	dto.setFsendcmdgenerating(0);
  	dto.setFsendcmdoutflow(0);
  	dto.setFsummiter("test");
  	dto.setFreccmdwaterlevel(0);
  	dto.setFreccmdgenerating(0);
  	dto.setFreccmdoutflow(0);
  	dto.setFsummittime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFwriteinlog("test");
  	dto.setFwriteinwglog("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFordertype("test");
  		service.saveOrUpdateDdHpoweroperaterrd(dto);
	}
	
	
	public void _testModifyDdHpoweroperaterrd(){
		DdHpoweroperaterrdDto dto = new DdHpoweroperaterrdDto();
		  	dto.setFplant("test");
  	dto.setFsendcmder("test");
  	dto.setFreccmder("test");
  	dto.setFsendcmdtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFsendcmdwaterlevel(0);
  	dto.setFsendcmdgenerating(0);
  	dto.setFsendcmdoutflow(0);
  	dto.setFsummiter("test");
  	dto.setFreccmdwaterlevel(0);
  	dto.setFreccmdgenerating(0);
  	dto.setFreccmdoutflow(0);
  	dto.setFsummittime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFwriteinlog("test");
  	dto.setFwriteinwglog("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFordertype("test");
  		service.saveOrUpdateDdHpoweroperaterrd(dto);
	}
	
	
	public void testListDdHpoweroperaterrd(){
		QueryListObj obj = service.listDdHpoweroperaterrd();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdHpoweroperaterrdDto dto = (DdHpoweroperaterrdDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdHpoweroperaterrd(){
	    //parameter param is test data
		service.deleteDdHpoweroperaterrd("param");
	}
	

	public void _testLoadDdHpoweroperaterrd(){
	    // parameter 101 is test data
		DdHpoweroperaterrdDto dto = service.loadDdHpoweroperaterrd("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
