package com.techstar.dmis.service.test;
import java.util.Date;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.springframework.beans.factory.BeanFactory;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.test.TestHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dto.FsApprovebookDto;
import com.techstar.dmis.service.IFsApprovebookService;

//please add your business methods start
	// to do it
//add your business method end

 /** 
 * 此类为业务对象服务接口测试类
 * @author 
 * @date
 **/
public class TestFsApprovebookService extends TestCase{
	
	private IFsApprovebookService service ;
	public TestFsApprovebookService(String name) {
		super(name);
		
	}
	//构造测试服务环境
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("dmis");
		//factory.getBean("configurationHelper");
		//factory.getBean("exceptionCacheHelper");
		service = (IFsApprovebookService)factory.getBean("iFsApprovebookService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
 
	//测试基本更新新增方法
	public void _testSaveOrUpdateFsApprovebook(){
	    
	   FsApprovebookDto dto = new FsApprovebookDto();
      if( StringUtils.isEmpty(dto.getFapprovcomputerno())){
         dto.setFapprovcomputerno( new SequenceCreator().getUID() ); //用于得到标准惟一标示

      }
        	dto.setFapprovbookno("test");
  	dto.setFstationname("test");
  	dto.setFprojectname("test");
  	dto.setFgenerationtime(null);
  	dto.setFprojectunit("test");
  	dto.setFsendtounit("test");
  	dto.setFcompletiondate(null);
  	dto.setFproblem("test");
  	dto.setFstatus("test");
  	dto.setFwriterunit("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFvoltage("test");
  	dto.setFexcutestatus("test");
  		service.saveOrUpdateFsApprovebook(dto);
	}
	
	
	public void _testModifyFsApprovebook(){
		FsApprovebookDto dto = new FsApprovebookDto();
		  	dto.setFapprovbookno("test");
  	dto.setFstationname("test");
  	dto.setFprojectname("test");
  	dto.setFgenerationtime(null);
  	dto.setFprojectunit("test");
  	dto.setFsendtounit("test");
  	dto.setFcompletiondate(null);
  	dto.setFproblem("test");
  	dto.setFstatus("test");
  	dto.setFwriterunit("test");
  	dto.setSys_fille("test");
  	dto.setSys_filldept("test");
  	dto.setSys_filltime(new java.sql.Timestamp(System.currentTimeMillis()));
  	dto.setSys_isvalid(0);
  	dto.setSys_dataowner("test");
  	dto.setFvoltage("test");
  	dto.setFexcutestatus("test");
  		service.saveOrUpdateFsApprovebook(dto);
	}
	
	
	public void testListFsApprovebook(){
		QueryListObj obj = service.listFsApprovebook();
		System.out.println("得到对象总数:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			FsApprovebookDto dto = (FsApprovebookDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	
	public void _testDeleteFsApprovebook(){
	    //parameter param is test data
		service.deleteFsApprovebook("param");
	}
	

	public void _testLoadFsApprovebook(){
	    // parameter 101 is test data
		FsApprovebookDto dto = service.loadFsApprovebook("param");
		System.out.println(dto.toString());
	}
	//please add your business methods start
	// to do it
//add your business method end
}
