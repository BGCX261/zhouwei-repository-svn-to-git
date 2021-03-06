package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.ZdhRmrecDto;
import com.techstar.dmis.service.IZdhRmrecService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestZdhRmrecService extends TestCase{
	
	private IZdhRmrecService service ;
	public TestZdhRmrecService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IZdhRmrecService)factory.getBean("iZdhRmrecService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateZdhRmrec(){
	    
	   ZdhRmrecDto dto = new ZdhRmrecDto();
      if( StringUtils.isEmpty(dto.getRecordno())){
         dto.setRecordno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFstationname("test");
  	dto.setSwitchno("test");
  	dto.setChangeexplanationo("test");
  	dto.setModificationdatano(0);
  	dto.setModificationreason("test");
  	dto.setModificationdate(null);
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhRmrec(dto);
	}
	
	
	public void _testModifyZdhRmrec(){
		ZdhRmrecDto dto = new ZdhRmrecDto();
		  	dto.setFstationname("test");
  	dto.setSwitchno("test");
  	dto.setChangeexplanationo("test");
  	dto.setModificationdatano(0);
  	dto.setModificationreason("test");
  	dto.setModificationdate(null);
  	dto.setRemarks("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  		service.saveOrUpdateZdhRmrec(dto);
	}
	
	
	public void testListZdhRmrec(){
		QueryListObj obj = service.listZdhRmrec();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ZdhRmrecDto dto = (ZdhRmrecDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteZdhRmrec(){
	    //parameter param is test data
		service.deleteZdhRmrec("param");
	}
	

	public void _testLoadZdhRmrec(){
	    // parameter 101 is test data
		ZdhRmrecDto dto = service.loadZdhRmrec("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
