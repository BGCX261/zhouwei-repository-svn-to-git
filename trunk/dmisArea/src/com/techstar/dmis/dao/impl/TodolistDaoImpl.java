package com.techstar.dmis.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techstar.dmis.dao.ITodolistDao;
import com.techstar.dmis.dto.WorkflowTodolistDto;

public class TodolistDaoImpl extends HibernateDaoSupport implements ITodolistDao {

	/**
	 * 工作流待办信息
	 */
	public List getWorkflowTodolist(String objName,String actorId) throws DataAccessException{
		List rtnList = new ArrayList();
		Statement stmt = null;
		ResultSet stmtRs = null;
		CallableStatement cstmt = null;
		ResultSet cstmtRs = null;
		
		try{
			
			Connection conn = this.getSession().connection();
			String sqlStr ="";
			stmt = conn.createStatement();
			stmtRs = stmt.executeQuery("select a.sql from DMIS_TODOLIST_CONFIG a where a.obj_type='"+objName+"'");
			System.out.println("select a.sql from DMIS_TODOLIST_CONFIG a where a.obj_type='"+objName+"'");
			while(stmtRs.next()){
				sqlStr = stmtRs.getString("sql");
			}
			stmtRs=null;
			if(sqlStr!=null && !"".equals(sqlStr)){
				stmtRs = stmt.executeQuery("select * from ("+sqlStr+") where bstatus='草稿' or bstatus='驳回' or bstatus='修改'");
				System.out.println("select * from ("+sqlStr+") where bstatus='草稿' or bstatus='驳回' or bstatus='修改'");
			}
			
			while(stmtRs!=null && stmtRs.next()){
				String busid = stmtRs.getString("id");
				String content = stmtRs.getString("content");
				String status = stmtRs.getString("status");
				
				String bstatus = stmtRs.getString("bstatus");	
				WorkflowTodolistDto dto = new WorkflowTodolistDto();
				
				dto.setContent(content);
				dto.setBstatus(bstatus);
				dto.setStatus(status);
				dto.setId(busid);
				
				rtnList.add(dto);				
			}
			
			
			String procedure = "{call pkg_wftodolist.p_wftodolist(?,?,?) }";
			cstmt = conn.prepareCall(procedure);
			cstmt.setString(1, objName);
			cstmt.setString(2, actorId);
			cstmt.registerOutParameter(3,oracle.jdbc.OracleTypes.CURSOR);
			//cstmt.executeQuery();
			cstmt.execute();
			cstmtRs = (ResultSet)cstmt.getObject(3);
			
			while(cstmtRs.next()){
				String busid = cstmtRs.getString("id");
				String content = cstmtRs.getString("content");
				String status = cstmtRs.getString("status");
				String bstatus = cstmtRs.getString("bstatus");	
				long taskInstanceId = cstmtRs.getLong("id_");
				String taskName = cstmtRs.getString("name_");
				Date createTime = cstmtRs.getDate("create_");
				long taskId = cstmtRs.getLong("task_");
				long processdifinition = cstmtRs.getLong("processdefinition_");
				
				WorkflowTodolistDto dto = new WorkflowTodolistDto();
				
				dto.setContent(content);
				dto.setStatus(status);
				dto.setBstatus(bstatus);
				dto.setCreateTime_(createTime);
				dto.setId(busid);
				dto.setProcessdefinition_(processdifinition);
				dto.setTaskId_(taskId);
				dto.setTaskInstanceId_(taskInstanceId);
				dto.setTaskName_(taskName);
				
				rtnList.add(dto);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(cstmtRs!=null) cstmtRs.close();
				if(cstmt!=null) cstmt.close();
			}catch(Exception ex){}
		}
		return rtnList;
	}

}
