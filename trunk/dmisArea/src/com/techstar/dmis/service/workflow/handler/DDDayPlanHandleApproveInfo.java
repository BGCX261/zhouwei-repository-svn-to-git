// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDDayPlanHandleApproveInfo.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.dmis.dto.DdDoutageplanDto;
import com.techstar.dmis.service.ServiceLocator;
import com.techstar.dmis.service.impl.DdDoutageplanServiceImpl;
import com.techstar.dmis.util.DateUtil;
import com.techstar.exchange.dto.control.ControlDto;
import com.techstar.exchange.dto.control.RecvDto;
import com.techstar.exchange.service.IexchangeService;
import com.techstar.exchange.service.impl.ExchangeServiceImpl;
import com.techstar.exchange.transfers.utils.MessageConfig;
import com.techstar.framework.service.workflow.IAction;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.time.StopWatch;
import org.jbpm.context.exe.ContextInstance;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

public class DDDayPlanHandleApproveInfo
    implements IAction
{

    public DDDayPlanHandleApproveInfo()
    {
    }

    public void execute(ExecutionContext executioncontext)
        throws Exception
    {
    }

    private void bak(ExecutionContext arg0)
        throws Exception
    {
        String busId = (String)arg0.getContextInstance().getVariable("businessId");
        String provider_url = MessageConfig.getValue("JNDI_PROVIDER_URL");
        String local_node = MessageConfig.getValue("LOCAL_NODE");
        String recv_queues = MessageConfig.getValue("RECV_QUEUE");
        String modules = MessageConfig.getValue("MODULE");
        String transDtoPackage = MessageConfig.getValue("transDtoPackage");
        String bussDtoPackage = MessageConfig.getValue("bussDtoPackage");
        String mappingFileHome = MessageConfig.getValue("mappingFileHome");
        ControlDto controlDto = new ControlDto();
        controlDto.setFrom(local_node);
        controlDto.setBussinessSign("DdDoutageplan");
        controlDto.setNotifyContent("");
        controlDto.setCenterTaskId(Long.toString(arg0.getTaskInstance().getId()));
        controlDto.setAreaTaskId("");
        controlDto.setType("3");
        controlDto.setContentVersion("");
        controlDto.setIsTrigger("1");
        controlDto.setObjectName("iDdDoutageplanService");
        controlDto.setMethodName("recBussData");
        controlDto.setTraceNumber("");
        Timestamp sendTime = DateUtil.getCurrentTimestamp();
        controlDto.setSendTime(sendTime.toString());
        controlDto.setRecvTime("");
        RecvDto rdto = new RecvDto();
        DdDoutageplanServiceImpl serviceImpl = (DdDoutageplanServiceImpl)ServiceLocator.getInstance().getService("iDdDoutageplanService");
        DdDoutageplanDto ddDoutageplanDto = serviceImpl.loadDdDoutageplan(busId);
        rdto.setTo(ddDoutageplanDto.getSys_dataowner());
        List recvDtos = new ArrayList();
        recvDtos.add(rdto);
        controlDto.setRecvDtos(recvDtos);
        IexchangeService service = new ExchangeServiceImpl();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        service.sendMessage(controlDto, ddDoutageplanDto);
        stopwatch.stop();
        System.out.println("·¢ËÍºÄÊ±: " + stopwatch.getTime());
    }
}
