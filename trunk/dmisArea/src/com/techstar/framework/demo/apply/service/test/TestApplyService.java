package com.techstar.framework.demo.apply.service.test;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.demo.apply.service.IApplyService;
import com.techstar.framework.service.workflow.bus.IWorkflowService;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.utils.TestHelper;
/**
 * 
 * @author xcf
 *
 */
public class TestApplyService extends TestCase{
	
	private IApplyService service ;
	public TestApplyService(String name) {
		super(name);
		
	}
	//Ԥ��װ��һ��xml�����ļ�
	protected void setUp() throws Exception {
		super.setUp();
		BeanFactory factory = TestHelper.createBeanFactory("demo");
		factory.getBean("configurationHelper");
		factory.getBean("exceptionCacheHelper");
		service = (IApplyService)factory.getBean("iApplyService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();	
		service = null;
	}
	
	//������������¼
	public void testSaveOrUpdateApply(){
		ApplyDto dto = new ApplyDto();
		if( StringUtils.isEmpty(dto.getApplyId())){
			dto.setApplyId( new SequenceCreator().getUID() ); //生成内部序列号
		}
		dto.setApplyer("xcfzzzz");
		dto.setApplyTime(new Date());
		dto.setApplyTitle("title");
		dto.setDepartment("zzzzz");
		service.saveOrUpdateApply(dto);
	}
	
	//�����޸������¼
	public void _testModifyApply(){
		ApplyDto dto = new ApplyDto();
		dto.setApplyId("101");
		dto.setApplyer("xcf_1001");
		dto.setApplyTime(new Date());
		dto.setApplyTitle("title");
		dto.setDepartment("������");
		service.saveOrUpdateApply(dto);
	}
	
	//���Եõ������б�
	public void _testListApply(){
		QueryListObj obj = service.listApply();
		System.out.println("��¼����:" + obj.getCount());
		
		for (int i = 0; i < obj.getElemList().size(); i++) {
			ApplyDto dto = (ApplyDto)obj.getElemList().get(i);
			System.out.println(dto.toString());
		}
	}
	
	//����ɾ�������¼
	public void _testDeleteApply(){
		service.deleteApply("100");
	}
	
	//���Զ�ȡ�����¼��ϸ��Ϣ
	public void _testLoadApply(){
		ApplyDto dto = service.loadApply("101");
		System.out.println(dto.toString());
	}
    
	//workflow���
	public void _testFindLogsByProcessInstance() {
		fail("Not yet implemented");
	}

	public void _testFindPooledTaskInstances() {
		fail("Not yet implemented");
	}

	public void _testStart() {
		
		String processDefinition="websale";
		service.start(processDefinition);
		//fail("Not yet implemented");
	}

	public void _testSuspend() {
		fail("Not yet implemented");
	}	
	
}
