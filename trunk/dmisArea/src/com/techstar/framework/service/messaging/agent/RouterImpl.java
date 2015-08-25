package com.techstar.framework.service.messaging.agent;

import com.techstar.framework.service.messaging.engine.*;
import com.techstar.framework.service.messaging.message.*;
import javax.xml.soap.SOAPException;

/**
 * 
 * @author yangjun
 *
 */
public class RouterImpl extends Router
{

    public RouterImpl()
    {
    }

    public Endpoint getDestination(TSSPMessage message)
        throws RouterException
    {
        String error = checkMessage(message);
        //System.out.println("error is"+error);
        if(error != null)
        {
            throw new RouterException(error);
        } else
        {
            return ServerEndPoint.getInstance();
        }
    	//return ServerEndPoint.getInstance();
    }

    private String checkMessage(TSSPMessage message)
    {
        try
        {
        	//System.out.println("system enter check message");
        
            TSSPHeader header = message.getHeader();
           // System.out.println("system enter check header");
            if(header == null)
            {
            	//System.out.println("0000000");
                return "\u672A\u8BBE\u7F6E\u6D88\u606F\u5934";
            }
            String contentType = header.getContentType();
            String contentVersion = header.getContentVersion();
            if(!ContentType.support(contentType, contentVersion))
            {
            	//System.out.println("111111");
                return "\u6D88\u606F\u5934\u4E2D\u672A\u652F\u6301\u7684ContentType/ContentVersion " + contentType + "/" + contentVersion;
            }
            String timeStamp = header.getTimestamp();
            if(timeStamp == null)
            {
            	//System.out.println("222222");
                return "\u6D88\u606F\u5934\u4E2D\u672A\u8BBE\u7F6EtimeStamp";
            }
            if(Util.parseTimeStamp(timeStamp) == null)
            {
            	//System.out.println("333333");
                return "\u6D88\u606F\u5934\u4E2D\u9519\u8BEF\u7684TimeStamp\u683C\u5F0F " + timeStamp;
            }
            String title = header.getTitle();
            title = title != null ? title : "";
            if(title.getBytes().length > 100)
            {
            	//System.out.println("444444");
                return "\u6D88\u606F\u5934\u4E2D\u7684Title\u8FC7\u957F(>100) " + title;
            }
            String traceNumber = header.getTraceNumber();
            if(traceNumber == null)
            {
            	//System.out.println("55555");
                return "\u6D88\u606F\u5934\u4E2D\u672A\u8BBE\u7F6ETraceNumber";
            }
            if(traceNumber.getBytes().length > 50)
            {
            	//System.out.println("666666");
                return "\u6D88\u606F\u5934\u4E2D\u7684TraceNumber\u8FC7\u957F(>50), " + traceNumber;
            }
            String from = header.getFrom();
            String to = header.getTo();
            if(from == null)
            {
            	//System.out.println("777777");
                return "\u6D88\u606F\u5934\u4E2D\u672A\u8BBE\u7F6EFrom";
            }
            if(to == null)
            {
            	//System.out.println("88888");
                return "\u6D88\u606F\u5934\u4E2D\u672A\u8BBE\u7F6ETo";
            }
            if(from == to)
            {
            	//System.out.println("999999");
                return "\u6D88\u606F\u5934\u4E2DFrom\u548CTo\u76F8\u540C, " + from + "/" + to;
            }
            if(from.getBytes().length > 50)
            {
            	//System.out.println("aaaaa");
                return "\u6D88\u606F\u5934\u4E2DFrom\u5B57\u6BB5\u8FC7\u957F(>50)";
            }
            if(to.getBytes().length > 50)
            {
            	//System.out.println("bbbbb");
                return "\u6D88\u606F\u5934\u4E2DTo\u5B57\u6BB5\u8FC7\u957F(>50)";
            }
//            if(!Resources.getLocalNode().equals(from))
//            {
//            	System.out.println("ccccc");
//                return "\u6D88\u606F\u5934\u4E2DFrom\u5B57\u6BB5[" + from + "]\u662F\u5FC5\u987B\u662F\u672C\u5730\u8282\u70B9[" + Resources.getLocalNode() + "], ";
//            }
            com.techstar.framework.service.messaging.message.TSSPBody body = null;
            try
            {
            	//System.out.println("dddddd");
                body = message.getBody();
            }
            catch(SOAPException e)
            {
                return "\u672A\u8BBE\u7F6E\u6D88\u606F\u4F53\uFF0C\u6216\u6D88\u606F\u4F53\u683C\u5F0F\u9519" +
"\u8BEF\u3002"
 + e.getMessage();
            }
            if(body == null)
            {
            	//System.out.println("eeeeee");
                return "\u672A\u8BBE\u7F6E\u6D88\u606F\u4F53\uFF0C\u6216\u6D88\u606F\u4F53\u683C\u5F0F\u9519" +
"\u8BEF\u3002"
;
            }
        }
        catch(Exception e)
        {
            return "\u6D88\u606F\u683C\u5F0F\u9519\u8BEF, " + e.getMessage();
        }
        return null;
    }
}

