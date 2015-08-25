// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDDayPlanIsAllYes.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDDayPlanIsAllYes
    implements IDecision
{

    public DDDayPlanIsAllYes()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = null;
        int count = 0;
        String SQL = "select count(*) as count from dmis_dd_planuserrel ddp where ddp.fsrc10dayplanno='" + busId + "' and ddp.fnoticestatus='֪ͨ'";
        String SQL_UP_PASS = "UPDATE dmis_dd_doutageplan d SET d.fstatus='" + DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_EXEC + "',d.fexcutestatus='" + DispatchConstants.AREA_DdDoutageplan_APPROVEED + "' where d.fdayplanno='" + busId + "'";
        String SQL_UP = "UPDATE dmis_dd_moutageplan d SET d.fstatus='" + DispatchConstants.DdDoutageplan_WORKFLOW_STATUS_ARRAY + "',d.fexcutestatus='" + DispatchConstants.AREA_DdDoutageplan_AUDITING + "' where d.fdayplanno='" + busId + "'";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FEXCUTESTATUS from DMIS_DD_DOUTAGEPLAN where fdayplanno='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FEXCUTESTATUS");

        resultSet.close();
        for(resultSet = statement.executeQuery(SQL); resultSet.next();)
            count = resultSet.getInt("count");

        if(flag.equals(DispatchConstants.AREA_DdDoutageplan_APPROVEED) && count > 0)
        {
            statement.executeUpdate(SQL_UP_PASS);
            statement.close();
            return DispatchConstants.DdDayPlan_WORKFLOW_AREA_ISALLOVER_TRANSIT_YES;
        } else
        {
            statement.executeUpdate(SQL_UP);
            statement.close();
            return DispatchConstants.DdDayPlan_WORKFLOW_AREA_ISALLOVER_TRANSIT_NO;
        }
    }
}
