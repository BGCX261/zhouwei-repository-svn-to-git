// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   DDMonthPlanSentNo.java

package com.techstar.dmis.service.workflow.handler;

import com.techstar.framework.service.workflow.IAction;
import java.io.PrintStream;
import org.jbpm.graph.exe.ExecutionContext;

public class DDMonthPlanSentNo
    implements IAction
{

    public DDMonthPlanSentNo()
    {
    }

    public void execute(ExecutionContext arg0)
        throws Exception
    {
        System.out.println("发送审核结果完毕");
    }
}
