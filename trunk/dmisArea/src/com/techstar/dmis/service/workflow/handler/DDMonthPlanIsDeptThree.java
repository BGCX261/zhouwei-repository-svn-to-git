// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanIsDeptThree.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.helper.SysFileHelper;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDMonthPlanIsDeptThree
    implements IDecision
{

    public DDMonthPlanIsDeptThree()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = null;
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FDispatchRange from DMIS_DD_MOUTAGEPLAN where FMONTHPLANNO='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FDispatchRange");

        resultSet.close();
        statement.close();
        if(flag == null)
            new Exception("DDMonthPlanIsDeptThree flag is null");
        if(flag.equals(SysFileHelper.getPropertyValue("DISPATCHRANGE")))
            return DispatchConstants.ddMoutageplan_WORKFLOW_IsDept2_TRANSIT_THIS;
        else
            return DispatchConstants.ddMoutageplan_WORKFLOW_IsDept2_TRANSIT_OTHER;
    }
}
