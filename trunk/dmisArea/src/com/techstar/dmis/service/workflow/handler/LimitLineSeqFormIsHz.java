package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jbpm.graph.exe.ExecutionContext;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;

//please add your business methods start
// to do it
//add your business method end

/**
 * 工作流操作类
 * 
 * @author
 * @date
 */
public class LimitLineSeqFormIsHz implements IDecision {

	public String decide(ExecutionContext arg0) throws Exception {
		String busId = (String) arg0.getContextInstance().getVariable(
				"businessId");

		String SQL_NOT_FULL = "UPDATE dmis_dd_cutofftitle d SET d.fstatus='"+DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE_FH+"',d.fexcutestatus='"+DispatchConstants.ddCutofftitle_approve+"' where d.fid='"+busId+"'";

		String SQL_FULL = "UPDATE dmis_dd_cutofftitle d SET d.fstatus='"+DispatchConstants.ddCutofftitle_WORKFLOW_STATUS_APPROVE+"',d.fexcutestatus='"+DispatchConstants.ddCutofftitle_approve+"' where d.fid='"+busId+"'";

		String flag = "";

		Connection connection = arg0.getJbpmContext().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select ISCOLLECT from DMIS_DD_CUTOFFTITLE where FID='"
						+ busId + "' ");

		while (resultSet.next()) {
			flag = resultSet.getString("ISCOLLECT");
		}
		resultSet.close();

		if (flag == null) {
			statement.executeUpdate(SQL_NOT_FULL);
			statement.close();
			return DispatchConstants.ddCutofftitle_WORKFLOW_CITY_ISFULL_NO;
		}

		if (flag.equals(DispatchConstants.ddCutofftitle_WORKFLOW_CITY_ISFULL)) {// 是否汇总表
			// arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_GO);
			statement.executeUpdate(SQL_FULL);
			statement.close();
			return DispatchConstants.ddCutofftitle_WORKFLOW_CITY_ISFULL_YES;
		} else {
			// arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK);
			statement.executeUpdate(SQL_NOT_FULL);
			statement.close();
			return DispatchConstants.ddCutofftitle_WORKFLOW_CITY_ISFULL_NO;
		}
	}

}