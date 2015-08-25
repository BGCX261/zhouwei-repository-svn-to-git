package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhSequencetableDto;
import com.techstar.dmis.service.IZdhSequencetableService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhSequencetableService extends TestCase{
	
	private IZdhSequencetableService service ;
	public TestZdhSequencetableService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhSequencetableService)factory.getBean("iZdhSequencetableService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhSequencetable(){
	    
	   ZdhSequencetableDto dto = new ZdhSequencetableDto();
      if( StringUtils.isEmpty(dto.getFsequenceno())){
         dto.setFsequenceno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationid("test");
  	dto.setFstationname("test");
  	dto.setFserialno(0);
  	dto.setFname("test");
  	dto.setFstatus("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhSequencetable(dto);
	}
	
	
	public void _testModifyZdhSequencetable(){
		ZdhSequencetableDto dto = new ZdhSequencetableDto();
		  	dto.setFstationid("test");
  	dto.setFstationname("test");
  	dto.setFserialno(0);
  	dto.setFname("test");
  	dto.setFstatus("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhSequencetable(dto);
	}
	
	
	public void testListZdhSequencetable(){
		QueryListObj obj = service.listZdhSequencetable();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhSequencetableDto dto = (ZdhSequencetableDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhSequencetable(){
	    //parameter param is test data
		service.deleteZdhSequencetable("param");
	}
	

	public void _testLoadZdhSequencetable(){
	    // parameter 101 is test data
		ZdhSequencetableDto dto = service.loadZdhSequencetable("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
