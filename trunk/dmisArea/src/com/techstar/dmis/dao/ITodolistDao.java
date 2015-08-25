package com.techstar.dmis.dao;

import java.util.List;

public interface ITodolistDao {

	//工作流待办事项
	
	public List getWorkflowTodolist(String objName ,String actorId);
	//状态待办事项
}
