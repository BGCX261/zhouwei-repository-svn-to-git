// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanSentApprove.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdMoutageplanDto;
import com.techstar.dmis.service.IDdMoutageplanService;
import com.techstar.dmis.service.ServiceLocator;
import com.techstar.dmis.util.DateUtil;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.service.workflow.IAction;
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

public class DDMonthPlanSentApprove
    implements IAction
{

    public DDMonthPlanSentApprove()
    {
    }

    public void execute(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        sendMessage(arg0, busId);
        String flag = "";
        String SQL = "UPDATE DMIS_DD_MOUTAGEPLAN d SET d.fstatus='" + DispatchConstants.ddMoutageplan_WORKFLOW_STATUS_end + "',d.fexcutestatus='" + DispatchConstants.ddMoutageplan_approveed_approveed_no + "' where d.FMONTHPLANNO='" + busId + "'";
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&" + SQL);
        Connection connection = arg0.getJbpmContext().getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQL);
        statement.close();
        arg0.leaveNode();
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
        controlDto.setMethodName("recBussDataWaiting");
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
    }
}
