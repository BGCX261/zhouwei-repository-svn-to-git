// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   IDdDoutageplanWFService.java

package com.techstar.dmis.service.workflow;

import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import org.springframework.dao.DataAccessException;

public interface IDdDoutageplanWFService
{

    public abstract int start(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanSpecArrange(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanSent(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanFillExec(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanInfocustomer(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanCustomerApprove(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanCoursign(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanSpecKeepon(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;

    public abstract int ddDayPlanEnd(WorkflowHandleDto workflowhandledto)
        throws DataAccessException;
}
