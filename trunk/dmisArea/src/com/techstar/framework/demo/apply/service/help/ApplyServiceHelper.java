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
	 * function :获取当前用户创建的业务申请单和其他用户创建,但需要该用户处理的所有数据列表,该方法为配合现有工作流-demo,暂不考虑效率问题
	 * date : 2006-12-06
	 */	
	public  List getApplyList(List applyList,List taskList ,String actorid) {
		List list = new ArrayList();
//        //循环计数器
//		int circleCount = 0;
//		//判断计数器
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
//		System.out.println("循环计数次数:"+circleCount);
//		System.out.println("判断计数次数:"+judgeCount);
		
		return list;
	} 

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
