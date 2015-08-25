// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanIsYes.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDMonthPlanIsYes
    implements IDecision
{

    public DDMonthPlanIsYes()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = "";
        String SQL = "UPDATE DMIS_DD_MOUTAGEPLAN d SET d.fstatus='" + DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_CleanUp + "',d.fexcutestatus='" + DispatchConstants.ddMoutageplan_CleanUp + "' where d.FMONTHPLANNO='" + busId + "'";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FEXCUTESTATUS from DMIS_DD_MOUTAGEPLAN where FMONTHPLANNO='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FEXCUTESTATUS");

        resultSet.close();
        if(flag.equals(DispatchConstants.ddMoutageplan_approveed))
        {
            statement.close();
            return DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_YES;
        } else
        {
            statement.executeUpdate(SQL);
            statement.close();
            return DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_NO;
        }
    }
}
