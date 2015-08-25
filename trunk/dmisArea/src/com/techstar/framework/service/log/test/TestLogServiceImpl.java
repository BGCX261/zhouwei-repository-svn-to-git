package com.techstar.framework.service.log.test;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;

import junit.framework.TestCase;

import com.techstar.framework.exception.BaseException;
import com.techstar.framework.service.dto.LogInfoDTO;
import com.techstar.framework.service.log.ILogService;
import com.techstar.framework.utils.TestHelper;
/**
 *单元测试类
 * Sep 11, 2006
 * @author xcf
 */
public class TestLogServiceImpl extends TestCase {
	
	private ILogService service ;
	public TestLogServiceImpl(String name) {
		super(name);
		
	}
//	预先装载一下xml配置文件
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		service = (ILogService)factory.getBean("logservice");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
	
//	测试获取所有log信息
	public void _testBackUpLogInfo(){
		try {
			service.backupLogInfo();
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	测试保存日志信息
	public void _testSaveLogInfo(){
		LogInfoDTO dto = new LogInfoDTO();
		dto.setContent("测试保存日志操作");
		dto.setOperateDate(new java.sql.Timestamp(System.currentTimeMillis()));
		dto.setOperator("xcf");
		try {
			service.saveLogToDb(dto);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	测试查询日志信息
	public void testQueryLogInfo(){
		LogInfoDTO dto = new LogInfoDTO();		
//		dto.setOperator("xcf");
		dto.setOperateStartDate("2006-09-05");
		dto.setOperateEndDate("2006-09-07");
		try {
			List dtos = service.queryLogInfo(dto);
			for (int i = 0; i < dtos.size(); i++) {
				System.out.println(((LogInfoDTO)dtos.get(i)).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
