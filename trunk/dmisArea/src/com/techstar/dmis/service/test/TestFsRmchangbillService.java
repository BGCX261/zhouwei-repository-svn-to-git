package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.FsRmchangbillDto;
import com.techstar.dmis.service.IFsRmchangbillService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestFsRmchangbillService extends TestCase{
	
	private IFsRmchangbillService service ;
	public TestFsRmchangbillService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IFsRmchangbillService)factory.getBean("iFsRmchangbillService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateFsRmchangbill(){
	    
	   FsRmchangbillDto dto = new FsRmchangbillDto();
      if( StringUtils.isEmpty(dto.getFchangno())){
         dto.setFchangno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setFchangetype("test");
  	dto.setFchangename("test");
  	dto.setFchangetime(null);
  	dto.setFpotentialhazard("test");
  	dto.setFrnormaltime(null);
  	dto.setFkeeptime(0);
  	dto.setFremark("test");
  	dto.setFrelchangebillno("test");
  	dto.setFattribute("test");
  	dto.setFstatus("test");
  	dto.setRmchangbillno("test");
  	dto.setFvoltage("test");
  	dto.setFchangereason("test");
  	dto.setFchangeperformance("test");
  	dto.setFisrenormal("test");
  		service.saveOrUpdateFsRmchangbill(dto);
	}
	
	
	public void _testModifyFsRmchangbill(){
		FsRmchangbillDto dto = new FsRmchangbillDto();
		  	dto.setFstationname("test");
  	dto.setFstationid("test");
  	dto.setFchangetype("test");
  	dto.setFchangename("test");
  	dto.setFchangetime(null);
  	dto.setFpotentialhazard("test");
  	dto.setFrnormaltime(null);
  	dto.setFkeeptime(0);
  	dto.setFremark("test");
  	dto.setFrelchangebillno("test");
  	dto.setFattribute("test");
  	dto.setFstatus("test");
  	dto.setRmchangbillno("test");
  	dto.setFvoltage("test");
  	dto.setFchangereason("test");
  	dto.setFchangeperformance("test");
  	dto.setFisrenormal("test");
  		service.saveOrUpdateFsRmchangbill(dto);
	}
	
	
	public void testListFsRmchangbill(){
		QueryListObj obj = service.listFsRmchangbill();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			FsRmchangbillDto dto = (FsRmchangbillDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteFsRmchangbill(){
	    //parameter param is test data
		service.deleteFsRmchangbill("param");
	}
	

	public void _testLoadFsRmchangbill(){
	    // parameter 101 is test data
		FsRmchangbillDto dto = service.loadFsRmchangbill("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
