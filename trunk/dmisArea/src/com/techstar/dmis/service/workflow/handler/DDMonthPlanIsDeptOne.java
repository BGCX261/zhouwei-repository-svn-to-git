// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanIsDeptOne.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.helper.SysFileHelper;
import com.techstar.framework.service.workflow.IDecision;
import java.sql.*;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;

public class DDMonthPlanIsDeptOne
    implements IDecision
{

    public DDMonthPlanIsDeptOne()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = "";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select SYS_DATAOWNER from DMIS_DD_MOUTAGEPLAN where FMONTHPLANNO='" + busId + "' ");
        String SQL = "UPDATE DMIS_DD_MOUTAGEPLAN d SET d.fstatus='" + DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_Modify + "',d.fexcutestatus='" + DispatchConstants.ddMoutageplan_approveed_approveed_no + "' where d.FMONTHPLANNO='" + busId + "'";
        while(resultSet.next()) 
            flag = resultSet.getString("SYS_DATAOWNER");
        resultSet.close();
        if(flag.equals(SysFileHelper.getPropertyValue("DATA_OWER")))
        {
            statement.executeUpdate(SQL);
            statement.close();
            return DispatchConstants.ddMoutageplan_WORKFLOW_IsDept_TRANSIT_THIS;
        } else
        {
            statement.close();
            return DispatchConstants.ddMoutageplan_WORKFLOW_IsDept_TRANSIT_OTHER;
        }
    }
}
