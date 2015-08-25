package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhFaultlistDto;
import com.techstar.dmis.service.IZdhFaultlistService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhFaultlistService extends TestCase{
	
	private IZdhFaultlistService service ;
	public TestZdhFaultlistService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhFaultlistService)factory.getBean("iZdhFaultlistService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhFaultlist(){
	    
	   ZdhFaultlistDto dto = new ZdhFaultlistDto();
      if( StringUtils.isEmpty(dto.getFfaultno())){
         dto.setFfaultno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFsystemname("test");
  	dto.setFunitname("test");
  	dto.setFsysclass("test");
  	dto.setFequipclass("test");
  	dto.setFfaulttypeid2("test");
  	dto.setFfaultcontent("test");
  	dto.setFcontinuetime(0);
  	dto.setFreason("test");
  	dto.setFdiscover("test");
  	dto.setFoccurredtime(null);
  	dto.setFrestoretime(null);
  	dto.setFrepairunit("test");
  	dto.setFeqpfaultpart("test");
  	dto.setFstaticreason("test");
  	dto.setFremarks("test");
  	dto.setRfiller("test");
  	dto.setRfilltime(null);
  	dto.setFstatus("test");
  	dto.setStationno("test");
  	dto.setFfaulttypeid1("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFfaultgrade("test");
  	dto.setFfaulttypename1("test");
  	dto.setFfaulttypename2("test");
  		service.saveOrUpdateZdhFaultlist(dto);
	}
	
	
	public void _testModifyZdhFaultlist(){
		ZdhFaultlistDto dto = new ZdhFaultlistDto();
		  	dto.setFsystemname("test");
  	dto.setFunitname("test");
  	dto.setFsysclass("test");
  	dto.setFequipclass("test");
  	dto.setFfaulttypeid2("test");
  	dto.setFfaultcontent("test");
  	dto.setFcontinuetime(0);
  	dto.setFreason("test");
  	dto.setFdiscover("test");
  	dto.setFoccurredtime(null);
  	dto.setFrestoretime(null);
  	dto.setFrepairunit("test");
  	dto.setFeqpfaultpart("test");
  	dto.setFstaticreason("test");
  	dto.setFremarks("test");
  	dto.setRfiller("test");
  	dto.setRfilltime(null);
  	dto.setFstatus("test");
  	dto.setStationno("test");
  	dto.setFfaulttypeid1("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFfaultgrade("test");
  	dto.setFfaulttypename1("test");
  	dto.setFfaulttypename2("test");
  		service.saveOrUpdateZdhFaultlist(dto);
	}
	
	
	public void testListZdhFaultlist(){
		QueryListObj obj = service.listZdhFaultlist();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhFaultlistDto dto = (ZdhFaultlistDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhFaultlist(){
	    //parameter param is test data
		service.deleteZdhFaultlist("param");
	}
	

	public void _testLoadZdhFaultlist(){
	    // parameter 101 is test data
		ZdhFaultlistDto dto = service.loadZdhFaultlist("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
