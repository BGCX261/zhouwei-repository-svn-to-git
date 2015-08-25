package com.techstar.framework.service.messaging.agent;

import com.techstar.framework.service.messaging.engine.*;
import java.io.IOException;
import java.io.OutputStream;
import javax.jms.*;

/**
 * 
 * @author yangjun
 *
 */

public class SenderImpl extends Sender
{

    private QueueConnection connection;
    private QueueSession session;
    private QueueSender sender;
    private OutputStream out;
    private byte by[];

    public SenderImpl()
    {
        connection = null;
        session = null;
        sender = null;
        out = null;
        by  = null;
    }

    protected void open()
        throws SenderException
    {
        QueueConnectionFactory factory = Resources.getFactory();
        javax.jms.Queue sendQueue = Resources.getSendQueue();
        try
        {
            connection = factory.createQueueConnection();
            session = connection.createQueueSession(false, 1);
            sender = session.createSender(sendQueue);
        }
        catch(JMSException e)
        {
            throw new SenderException("\u4E0D\u80FD\u521B\u5EFA\u8FDE\u63A5", e);
        }
    }

    protected OutputStream getOutputStream()
        throws SenderException
    {
        javax.jms.BytesMessage msg = null;
        try
        {
            msg = session.createBytesMessage();
        }
        catch(JMSException e)
        {
            throw new SenderException(e);
        }
        BytesMessageOutputStream msgout = new BytesMessageOutputStream();
        msgout.msg = msg;
        out = msgout;
        return out;
    }

    protected void send(Endpoint endpoint)
        throws SenderException
    {
    	
//        try
//        {
//            javax.jms.BytesMessage  message = session.createBytesMessage();
//			message.writeBytes(by);
//            sender.send(message);
//         }catch(JMSException e)
//        {   
//        	e.printStackTrace();
//            throw new SenderException(e);
//        }
    	 try
         {
             out.flush();
         }
         catch(IOException e)
         {
             throw new SenderException(e);
         }
         javax.jms.BytesMessage message=((BytesMessageOutputStream)out).msg;
         
         try
         {
             sender.send(message);
         }
         catch(JMSException e)
         {
             throw new SenderException(e);
         }
    }

    protected void close()
        throws SenderException
    {
        try
        {
            if(sender != null)
            {
                sender.close();
                sender = null;
            }
            if(session != null)
            {
                session.close();
                session = null;
            }
            if(connection != null)
            {
                connection.close();
                connection = null;
            }
        }
        catch(JMSException e)
        {
            throw new SenderException(e);
        }
    }
}
