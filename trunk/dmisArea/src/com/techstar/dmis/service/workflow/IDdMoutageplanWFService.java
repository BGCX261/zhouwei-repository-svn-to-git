// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   IDdMoutageplanWFService.java

package com.techstar.dmis.service.workflow;

import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import org.springframework.dao.DataAccessException;

public interface IDdMoutageplanWFService
{

    public abstract int start(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddMonthPlanCleanUp(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddMonthPlanSentResult(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddMonthPlanApproveAndSend(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddMonthPlanModify(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddMonthPlanCleanUpResult(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;
}
