// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi
// Source File Name:   DdMoutageplanWFServiceImpl.java

package com.techstar.dmis.service.workflow.impl;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;
import com.techstar.dmis.service.workflow.IDdMoutageplanWFService;
import com.techstar.dmis.service.workflow.impl.exception.WorkflowException;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import org.springframework.dao.DataAccessException;

public class DdMoutageplanWFServiceImpl
    implements IDdMoutageplanWFService
{

    private IWorkflowDao workFlowDao;
    IHandleHistoryDao handleHistoryDao;

    public DdMoutageplanWFServiceImpl()
    {
    }

    public void setWorkFlowDao(IWorkflowDao workFlowDao)
    {
        this.workFlowDao = workFlowDao;
    }

    public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao)
    {
        this.handleHistoryDao = handleHistoryDao;
    }


    /*
     * 生技专工任务批准分发
     *
     */
    public int ddMonthPlanApproveAndSend(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            String transitionflag = dto.getTransitionFlag();
            if("1".equals(transitionflag))
                workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_TRANSIT_YES, dto.getUserId(), dto.getNextTaskRoles());
            else
            if("-1".equals(transitionflag))
                workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_NO, dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }

    /*
     * 生技专工整理
     *
     *
     */
    public int ddMonthPlanCleanUp(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            String transitionflag = dto.getTransitionFlag();
            if("1".equals(transitionflag))
                workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_YES, dto.getUserId(), dto.getNextTaskRoles());
            else
            if("-1".equals(transitionflag))
                workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), DispatchConstants.ddMoutageplan_WORKFLOW_APPROVE_NO, dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }

    /*
     * 停电计划专工整理完成情况
     */
    public int ddMonthPlanCleanUpResult(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }

    /*
     * 申请人修改计划
     */

    public int ddMonthPlanModify(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }

    /*
     *
     * 停电计划专工分发
     *
     *
     */
    public int ddMonthPlanSentResult(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            workFlowDao.endTask(Long.parseLong(dto.getTaskInstanceId()), dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }

    /*
     * 启动
     *
     */
    public int start(WorkflowHandleDto dto)
        throws DataAccessException
    {
        try
        {
            workFlowDao.start(DispatchConstants.ddMoutageplan_WORKFLOW_PROCESSDIFINITION, dto.getBusId(), dto.getUserId(), dto.getNextTaskRoles());
            handleHistoryDao.saveOrUpdate(dto);
        }
        catch(Exception ex)
        {
            throw new WorkflowException();
        }
        return 1;
    }
}
