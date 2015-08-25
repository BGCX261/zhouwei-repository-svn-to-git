package com.techstar.dmis.service.workflow.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.jbpm.graph.exe.ExecutionContext;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.common.ZdhConstants;
import com.techstar.framework.service.workflow.IAction;
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
public class DDAccidentBriefIsAllFill implements IDecision {

	// public void execute(ExecutionContext arg0) throws Exception {
	//
	// String busId = (String) arg0.getContextInstance().getVariable(
	// "businessId");
	//
	// String SQL_Not_Pass = "UPDATE dmis_dd_accidentbrief d SET d.fstatus='"
	// + DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_STATUS_MODIFY
	// + "',d.fexcutestatus='"
	// + DispatchConstants.ddAccidentbrief_auditing
	// + "' where d.faccidentid='" + busId + "'";
	//
	// String SQL_Pass = "UPDATE dmis_dd_accidentbrief d SET d.fstatus='"
	// + DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_STATUS_EXE
	// + "',d.fexcutestatus='"
	// + DispatchConstants.ddAccidentbrief_auditing
	// + "' where d.faccidentid='" + busId + "'";
	//
	// String isfill = "";
	//
	// Connection connection = arg0.getJbpmContext().getConnection();
	// Statement statement = connection.createStatement();
	// ResultSet resultSet = statement
	// .executeQuery("select FWhetherCompleted from DMIS_DD_ACCIDENTBRIEF where
	// FACCIDENTID='"
	// + busId + "' ");
	//
	// while (resultSet.next()) {
	// isfill = resultSet.getString("FWhetherCompleted");
	// }
	// resultSet.close();
	//
	// if (isfill == null) {
	//
	// //
	// arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK);
	// statement.executeUpdate(SQL_Not_Pass);
	// statement.close();
	// return;
	// }
	//
	// if (isfill
	// .equals(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_YES)) {//
	// 填写完毕
	//
	// arg0
	// .leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_GO);
	// statement.executeUpdate(SQL_Pass);
	// } else {
	//
	// //
	// arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK);
	// statement.executeUpdate(SQL_Not_Pass);
	// }
	// statement.close();
	//
	// }

	public String decide(ExecutionContext arg0) throws Exception {
		String busId = (String) arg0.getContextInstance().getVariable(
				"businessId");

		String SQL_Not_Pass = "UPDATE dmis_dd_accidentbrief d SET d.fstatus='"
				+ DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_STATUS_MODIFY
				+ "',d.fexcutestatus='"
				+ DispatchConstants.ddAccidentbrief_auditing
				+ "' where d.faccidentid='" + busId + "'";

		String SQL_Pass = "UPDATE dmis_dd_accidentbrief d SET d.fstatus='"
				+ DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_STATUS_EXE
				+ "',d.fexcutestatus='"
				+ DispatchConstants.ddAccidentbrief_auditing
				+ "' where d.faccidentid='" + busId + "'";

		String isfill = "";

		Connection connection = arg0.getJbpmContext().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select FWhetherCompleted from DMIS_DD_ACCIDENTBRIEF where FACCIDENTID='"
						+ busId + "' ");

		while (resultSet.next()) {
			isfill = resultSet.getString("FWhetherCompleted");
		}
		resultSet.close();

		if (isfill == null) {

//			arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK);
			statement.executeUpdate(SQL_Not_Pass);
			statement.close();
			return DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK;
		}

		if (isfill
				.equals(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_YES)) {// 填写完毕
//			arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_GO);
			statement.executeUpdate(SQL_Pass);
			statement.close();

			return DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_GO;
		} else {

			// arg0.leaveNode(DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK);
			statement.executeUpdate(SQL_Not_Pass);
			statement.close();
			return DispatchConstants.ddAccidentbrief_WORKFLOW_CITY_isFull_BACK;
		}

	}

}