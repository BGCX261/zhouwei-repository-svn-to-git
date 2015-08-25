package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhReceptionDto;
import com.techstar.dmis.service.IZdhReceptionService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhReceptionService extends TestCase{
	
	private IZdhReceptionService service ;
	public TestZdhReceptionService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhReceptionService)factory.getBean("iZdhReceptionService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhReception(){
	    
	   ZdhReceptionDto dto = new ZdhReceptionDto();
      if( StringUtils.isEmpty(dto.getFapplicationid())){
         dto.setFapplicationid( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFsystemname("test");
  	dto.setFreceptiondate(null);
  	dto.setFeqpremark("test");
  	dto.setFreceptiongraph(null);
  	dto.setFreceptionreport(null);
  	dto.setFsequence(null);
  	dto.setFtranrec(null);
  	dto.setFremark("test");
  	dto.setFstationid("test");
  	dto.setFreceptionno("test");
  	dto.setFruneqoremark("test");
  	dto.setFapplyrundate(null);
  	dto.setFapproverundate(null);
  	dto.setFrundate(null);
  	dto.setFexcutestatus("test");
  	dto.setFsystemtype("test");
  	dto.setLocalapprover1("test");
  	dto.setCenteropinion1("test");
  	dto.setCenteropinion2("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhReception(dto);
	}
	
	
	public void _testModifyZdhReception(){
		ZdhReceptionDto dto = new ZdhReceptionDto();
		  	dto.setFstationname("test");
  	dto.setFsystemname("test");
  	dto.setFreceptiondate(null);
  	dto.setFeqpremark("test");
  	dto.setFreceptiongraph(null);
  	dto.setFreceptionreport(null);
  	dto.setFsequence(null);
  	dto.setFtranrec(null);
  	dto.setFremark("test");
  	dto.setFstationid("test");
  	dto.setFreceptionno("test");
  	dto.setFruneqoremark("test");
  	dto.setFapplyrundate(null);
  	dto.setFapproverundate(null);
  	dto.setFrundate(null);
  	dto.setFexcutestatus("test");
  	dto.setFsystemtype("test");
  	dto.setLocalapprover1("test");
  	dto.setCenteropinion1("test");
  	dto.setCenteropinion2("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhReception(dto);
	}
	
	
	public void testListZdhReception(){
		QueryListObj obj = service.listZdhReception();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhReceptionDto dto = (ZdhReceptionDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhReception(){
	    //parameter param is test data
		service.deleteZdhReception("param");
	}
	

	public void _testLoadZdhReception(){
	    // parameter 101 is test data
		ZdhReceptionDto dto = service.loadZdhReception("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
