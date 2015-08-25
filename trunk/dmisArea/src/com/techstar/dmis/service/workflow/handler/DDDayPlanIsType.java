// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDDayPlanIsType.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDDayPlanIsType
    implements IDecision
{

    public DDDayPlanIsType()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = null;
        String SQL = "UPDATE dmis_dd_doutageplan d SET d.fstatus='" + DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_ARRAY + "',d.fexcutestatus='" + DispatchConstants.DdDayPlan_WORKFLOW_AREA_TIDY + "' where d.fdayplanno='" + busId + "'";
        String SQL_ls = "UPDATE dmis_dd_doutageplan d SET d.fstatus='" + DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_EXEC + "',d.fexcutestatus='" + DispatchConstants.AREA_DdDoutageplan_APPROVEED + "' where d.fdayplanno='" + busId + "'";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FPLANCLASS from DMIS_DD_DOUTAGEPLAN where fdayplanno='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FPLANCLASS");

        resultSet.close();
        if(flag.equals(DispatchConstants.DdDayPlan_WORKFLOW_AREA_SentIsType_TRANSIT_LS))
        {
            statement.executeUpdate(SQL_ls);
            statement.close();
            return DispatchConstants.DdDayPlan_WORKFLOW_AREA_SentIsType_TRANSIT_LS_YES;
        } else
        {
            statement.executeUpdate(SQL);
            statement.close();
            return DispatchConstants.DdDayPlan_WORKFLOW_AREA_SentIsType_TRANSIT_LS_NO;
        }
    }
}
