package com.techstar.framework.demo.apply.service.help;

import java.util.ArrayList;
import java.util.List;

import com.techstar.framework.demo.apply.service.IApplyService;
import com.techstar.framework.demo.dto.ApplyDto;
import com.techstar.framework.service.workflow.bus.dto.TaskDto;
import com.techstar.framework.dao.model.CommonQueryObj;
import com.techstar.framework.dao.model.QueryDetailPair;

public class ApplyServiceHelper {

	
	/**
	 * function :��ȡ��ǰ�û�������ҵ�����뵥�������û�����,����Ҫ���û���������������б�,�÷���Ϊ������й�����-demo,�ݲ�����Ч������
	 * date : 2006-12-06
	 */	
	public  List getApplyList(List applyList,List taskList ,String actorid) {
		List list = new ArrayList();
//        //ѭ��������
//		int circleCount = 0;
//		//�жϼ�����
//		int judgeCount = 0;
		
		for(int i = 0 ;i < applyList.size(); i++) {
			ApplyDto appDto = (ApplyDto)applyList.get(i);
			if(appDto.getApplyer().equalsIgnoreCase(actorid)) {							
			    for(int j = 0 ; j < taskList.size();j ++) {
			    	TaskDto taskDto = (TaskDto)taskList.get(j);
			    	if(appDto.getApplyId().toString().equalsIgnoreCase(taskDto.getBusinessId())) {
			    		appDto.setTaskId(taskDto.getTaskId());
			    		appDto.setTaskName(taskDto.getTaskName());
			    		//judgeCount++;
			    		break;
				    }
			    	//circleCount++;
			    }
			    list.add(appDto);
			}
			else {
			    for(int j = 0 ; j < taskList.size();j ++) {
			    	TaskDto taskDto = (TaskDto)taskList.get(j);
			    	if(appDto.getApplyId().toString().equalsIgnoreCase(taskDto.getBusinessId())) {
			    		appDto.setTaskId(taskDto.getTaskId());
			    		appDto.setTaskName(taskDto.getTaskName());
			    		list.add(appDto);
			    		//judgeCount++;
			    		break;
				    }			
			    	//circleCount++;
			    }
			}
		}	
//		System.out.println("ѭ����������:"+circleCount);
//		System.out.println("�жϼ�������:"+judgeCount);
		
		return list;
	} 

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
