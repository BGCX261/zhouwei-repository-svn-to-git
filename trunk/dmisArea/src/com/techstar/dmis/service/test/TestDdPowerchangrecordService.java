package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.DdPowerchangrecordDto;
import com.techstar.dmis.service.IDdPowerchangrecordService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestDdPowerchangrecordService extends TestCase{
	
	private IDdPowerchangrecordService service ;
	public TestDdPowerchangrecordService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IDdPowerchangrecordService)factory.getBean("iDdPowerchangrecordService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateDdPowerchangrecord(){
	    
	   DdPowerchangrecordDto dto = new DdPowerchangrecordDto();
      if( StringUtils.isEmpty(dto.getFid())){
         dto.setFid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFadjustreason("test");
  	dto.setFadjustcontent("test");
  	dto.setFsendcmdtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFsendcmder("test");
  	dto.setFreccmder("test");
  	dto.setFrestoretime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFressendcmder("test");
  	dto.setFresreccmder("test");
  	dto.setFwriteinlog("test");
  	dto.setFwriteinwglog("test");
  	dto.setFsrcno("test");
  	dto.setFlogtype("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdPowerchangrecord(dto);
	}
	
	
	public void _testModifyDdPowerchangrecord(){
		DdPowerchangrecordDto dto = new DdPowerchangrecordDto();
		  	dto.setFstationname("test");
  	dto.setFadjustreason("test");
  	dto.setFadjustcontent("test");
  	dto.setFsendcmdtime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFsendcmder("test");
  	dto.setFreccmder("test");
  	dto.setFrestoretime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setFressendcmder("test");
  	dto.setFresreccmder("test");
  	dto.setFwriteinlog("test");
  	dto.setFwriteinwglog("test");
  	dto.setFsrcno("test");
  	dto.setFlogtype("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateDdPowerchangrecord(dto);
	}
	
	
	public void testListDdPowerchangrecord(){
		QueryListObj obj = service.listDdPowerchangrecord();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			DdPowerchangrecordDto dto = (DdPowerchangrecordDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteDdPowerchangrecord(){
	    //parameter param is test data
		service.deleteDdPowerchangrecord("param");
	}
	

	public void _testLoadDdPowerchangrecord(){
	    // parameter 101 is test data
		DdPowerchangrecordDto dto = service.loadDdPowerchangrecord("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
