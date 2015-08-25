package com.techstar.framework.service.messaging.agent;

import com.techstar.framework.service.messaging.engine.*;
import java.io.InputStream;
import javax.jms.*;

/**
 * 
 * @author yangjun
 *
 */
public class ReceiverImpl extends Receiver
{

    private QueueConnection connection;
    private QueueSession session;
    private QueueReceiver receiver;
    private BytesMessage message;
    private boolean hasAttachment;

    public ReceiverImpl()
    {
        connection = null;
        session = null;
        receiver = null;
        message = null;
        hasAttachment = false;
    }

    public void open()
        throws ReceiverException
    {
        QueueConnectionFactory factory = Resources.getFactory();
        javax.jms.Queue recvQueue = Resources.getRecvQueue();
        try
        {
            connection = factory.createQueueConnection();
            connection.start();
            session = connection.createQueueSession(true, 1);
            receiver = session.createReceiver(recvQueue);
        }
        catch(JMSException e)
        {
            throw new ReceiverException("\u4E0D\u80FD\u521B\u5EFA\u8FDE\u63A5", e);
        }
    }

    public InputStream getInputStream()
        throws ReceiverException
    {
        BytesMessageInputStream result = null;
        if(message == null)
        {
            throw new ReceiverException("No message");
        } else
        {
            result = new BytesMessageInputStream();
            result.msg = message;
            return result;
        }
    }

    public void close()
        throws ReceiverException
    {
        if(receiver != null)
        {
            try
            {
                receiver.close();
                receiver = null;
            }
            catch(JMSException jmsexception) { }
        }
        if(session != null)
        {
            try
            {
                session.close();
                session = null;
            }
            catch(JMSException jmsexception1) { }
        }
        if(connection != null)
        {
            try
            {
                connection.close();
                connection = null;
            }
            catch(JMSException jmsexception2) { }
        }
        message = null;
    }

    public void commit()
        throws ReceiverException
    {
        try
        {
            session.commit();
        }
        catch(JMSException e)
        {
            throw new ReceiverException(e);
        }
    }

    public void rollback()
        throws ReceiverException
    {
        try
        {
            session.rollback();
        }
        catch(JMSException e)
        {
            throw new ReceiverException(e);
        }
    }

    public boolean next()
        throws ReceiverException
    {
        try
        {
            message = (BytesMessage)receiver.receive(Resources.getWaitTime());
            return message != null;
        }
        catch(JMSException e)
        {
            throw new ReceiverException(e);
        }
    }
    
 public InputStream getInputStream(Object message)
    throws ReceiverException
{
	BytesMessage msg = (BytesMessage)message;
    BytesMessageInputStream result = null;
    if(msg == null)
    {
        throw new ReceiverException("No message");
    } else
    {
        result = new BytesMessageInputStream();
        result.msg = msg;
        return result;
    }
}
}

