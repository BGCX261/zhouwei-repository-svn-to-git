package com.techstar.dmis.service.workflow;

import org.springframework.dao.DataAccessException;

import com.techstar.dmis.helper.dto.WorkflowHandleDto;

public interface IDdEnsuringpsmanageWFService {
   	 
	 //please add your business methods start
	 // to do it

	public int appReback(WorkflowHandleDto dto) throws DataAccessException ;

	public int approve(WorkflowHandleDto dto) throws DataAccessException; 

	public int countersign(WorkflowHandleDto dto) throws DataAccessException; 

	public int execute(WorkflowHandleDto dto) throws DataAccessException; 

	public int keepon(WorkflowHandleDto dto) throws DataAccessException; 

	public int modify(WorkflowHandleDto dto) throws DataAccessException; 

	public int sent(WorkflowHandleDto dto) throws DataAccessException; 

	public int start(WorkflowHandleDto dto) throws DataAccessException;
	
	
	//add your business method end
	
}
