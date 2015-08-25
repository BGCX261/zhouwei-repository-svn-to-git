// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanIsDeptTwo.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.helper.SysFileHelper;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.service.ServiceLocator;
import com.techstar.dmis.util.DateUtil;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.service.workflow.IDecision;
import com.techstar.framework.utils.SequenceCreator;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;
import org.apache.commons.lang.time.StopWatch;
import org.jbpm.JbpmContext;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.jbpm.taskmgmt.exe.TaskMgmtInstance;

public class DDMonthPlanIsDeptTwo
    implements IDecision
{

    public DDMonthPlanIsDeptTwo()
    {
    }

    public String decide(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String flag = null;
        String SQL = "UPDATE dmis_dd_moutageplan d SET d.fstatus='" + DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_ApproveAndSend + "' where d.fmonthplanno='" + busId + "'";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet;
        for(resultSet = statement.executeQuery("select FDispatchRange from DMIS_DD_MOUTAGEPLAN where FMONTHPLANNO='" + busId + "' "); resultSet.next();)
            flag = resultSet.getString("FDispatchRange");

        resultSet.close();
        if(flag == null)
            new Exception("DDMonthPlanIsDeptTwo flag is null");
        if(flag.equals(SysFileHelper.getPropertyValue("DISPATCHRANGE")))
        {
            statement.executeUpdate(SQL);
            statement.close();
            return DispatchConstants.ddMoutageplan_WORKFLOW_RANGE_TRANSIT_THIS;
        } else
        {
            statement.close();
            sendMessage(arg0, busId);
            return DispatchConstants.ddMoutageplan_WORKFLOW_RANGE_TRANSIT_OTHER;
        }
    }

    private void sendMessage(ExecutionContext arg0, String busid)
        throws Exception
    {
        String provider_url = MessageConfig.getValue("JNDI_PROVIDER_URL");
        String local_node = MessageConfig.getValue("LOCAL_NODE");
        String recv_queues = MessageConfig.getValue("RECV_QUEUE");
        String modules = MessageConfig.getValue("MODULE");
        String transDtoPackage = MessageConfig.getValue("transDtoPackage");
        String bussDtoPackage = MessageConfig.getValue("bussDtoPackage");
        String mappingFileHome = MessageConfig.getValue("mappingFileHome");
        ControlDto controlDto = new ControlDto();
        controlDto.setFrom(local_node);
        controlDto.setBussinessSign("DdMoutageplan");
        Collection taskInstances = arg0.getContextInstance().getProcessInstance().getTaskMgmtInstance().getTaskInstances();
        TaskInstance taskinstance = (TaskInstance)taskInstances.iterator().next();
        controlDto.setNotifyContent("");
        controlDto.setAreaTaskId(Long.toString(taskinstance.getId()));
        controlDto.setType("3");
        controlDto.setContentVersion("");
        controlDto.setIsTrigger("1");
        controlDto.setObjectName("iDdMoutageplanService");
        controlDto.setMethodName("recBussData");
        controlDto.setTraceNumber("");
        Timestamp sendTime = DateUtil.getCurrentTimestamp();
        controlDto.setSendTime(sendTime.toString());
        controlDto.setRecvTime("");
        RecvDto rdto = new RecvDto();
        IexchangeService service = new ExchangeServiceImpl();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        IDdMoutageplanService ddMService = (IDdMoutageplanService)ServiceLocator.getInstance().getService("iDdMoutageplanService");
        DdMoutageplanDto ddMoutageplanDto = ddMService.loadDdMoutageplan(busid);
        rdto.setTo(ddMoutageplanDto.getSys_dataowner());
        List recvDtos = new ArrayList();
        recvDtos.add(rdto);
        controlDto.setRecvDtos(recvDtos);
        service.sendMessage(controlDto, ddMoutageplanDto);
        stopwatch.stop();
        System.out.println("·¢ËÍºÄÊ±: " + stopwatch.getTime());
        saveCtrlWflentityrel(arg0, busid, taskinstance.getId());
    }

    private void saveCtrlWflentityrel(ExecutionContext arg0, String busID, long taskid)
        throws Exception
    {
        String SQL = "insert into dmis_ctrl_wflentityrel (frelid,version,entityname,entityid,taskid) values('" + (new SequenceCreator()).getUID() + "',0,'DdMoutageplan','" + busID + "'," + taskid + ")";
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL);
        statement.close();
    }
}
