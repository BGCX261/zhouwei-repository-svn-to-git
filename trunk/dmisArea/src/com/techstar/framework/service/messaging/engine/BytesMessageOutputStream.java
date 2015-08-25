package com.techstar.framework.service.messaging.engine;

import java.io.IOException;
import java.io.OutputStream;
import javax.jms.BytesMessage;
import javax.jms.JMSException;

/**
 * 
 * @author yangjun
 *
 */
public class BytesMessageOutputStream extends OutputStream
{

    public BytesMessage msg;

    public BytesMessageOutputStream()
    {
    }

    public void write(int c)
        throws IOException
    {
        byte b = (byte)c;
        try
        {
            msg.writeByte(b);
        }
        catch(JMSException e)
        {
            throw new IOException(e.getMessage());
        }
    }

    public void write(byte buf[], int off, int len)
        throws IOException
    {
        try
        {
            msg.writeBytes(buf, off, len);
        }
        catch(JMSException e)
        {
            throw new IOException(e.getMessage());
        }
    }

    public void write(byte buf[])
        throws IOException
    {
        try
        {
            msg.writeBytes(buf);
        }
        catch(JMSException e)
        {
            throw new IOException(e.getMessage());
        }
    }
}

