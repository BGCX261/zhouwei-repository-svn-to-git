// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi
// Source File Name:   DDDayPlanCoursign.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.service.workflow.impl.helper.DimsWorkflowHelper;
import com.techstar.framework.service.workflow.IAssignment;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.Task;
import org.jbpm.taskmgmt.exe.Assignable;
import org.jbpm.taskmgmt.exe.TaskInstance;

public class DDDayPlanCoursign implements IAssignment {

	public DDDayPlanCoursign() {
	}

	public void assign(Assignable arg0, ExecutionContext arg1) throws Exception {
		arg1.getTaskInstance().setBussId(
				(String) arg1.getContextInstance().getVariable("businessId"));
		String actors[] = (String[]) arg1.getContextInstance().getVariable(
				"currentUserIds");
		String strActors = "";
		for (int i = 0; i < actors.length; i++)
			if (i == 0)
				strActors = actors[i];
			else
				strActors = strActors + ";" + actors[i];

		long taskId = arg1.getTaskInstance().getTask().getId();
		String taskRoles = "";
		String agencyRoles = "";
		Connection connection = arg1.getJbpmContext().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet;
		for (resultSet = statement
				.executeQuery("select TASK_ROLE,AGENCY_ROLE from JBPM_EXT_PERMISSION where task_id='"
						+ taskId + "' "); resultSet.next();) {
			taskRoles = resultSet.getString("TASK_ROLE");
			agencyRoles = resultSet.getString("AGENCY_ROLE");
		}

		resultSet.close();
		statement.close();
		String currentUserIds[] = DimsWorkflowHelper.getCurrentUsers(taskRoles,
				agencyRoles);
		arg0.setPooledActors(currentUserIds);
		arg1.getContextInstance().setVariable("init", strActors);
	}
}
