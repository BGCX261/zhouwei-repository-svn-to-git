// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDDayPlanIsApartPlan.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDDayPlanIsApartPlan
    implements IDecision
{

    public DDDayPlanIsApartPlan()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = "";
        String SQL = "UPDATE dmis_dd_doutageplan d SET d.fstatus='" + DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_EXEC + "',d.fexcutestatus='" + DispatchConstants.AREA_DdDoutageplan_APPROVEED + "' where d.fdayplanno='" + busId + "'";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FPLANCLASS from DMIS_DD_DOUTAGEPLAN where fdayplanno='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FPLANCLASS");

        resultSet.close();
        statement.executeUpdate(SQL);
        statement.close();
        return DispatchConstants.DdDayPlan_WORKFLOW_AREA_SentIsType_TRANSIT_LSorOther_NO;
    }
}
