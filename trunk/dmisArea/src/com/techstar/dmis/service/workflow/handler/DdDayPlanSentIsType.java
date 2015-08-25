// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DdDayPlanSentIsType.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DdDayPlanSentIsType
    implements IDecision
{

    public DdDayPlanSentIsType()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String FPlanClass = "";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FPlanClass from DMIS_DD_DOUTAGEPLAN where FDAYPLANNO='" + busId + "' "); resultSet.next();)
            FPlanClass = resultSet.getString("FPlanClass");

        resultSet.close();
        statement.close();
        if(FPlanClass != null && FPlanClass.equals(DispatchConstants.DdDayPlan_WORKFLOW_CITY_SentIsType_TRANSIT_LS))
            return DispatchConstants.DdDayPlan_WORKFLOW_CITY_SentIsType_TRANSIT_LS;
        else
            return DispatchConstants.DdDayPlan_WORKFLOW_CITY_SentIsType_TRANSIT_LS_NO;
    }
}
