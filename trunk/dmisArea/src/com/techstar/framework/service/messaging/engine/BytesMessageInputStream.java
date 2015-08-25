package com.techstar.framework.service.messaging.engine;

import java.io.IOException;
import java.io.InputStream;
import javax.jms.BytesMessage;
import javax.jms.JMSException;

/**
 * 
 * @author yangjun
 *
 */
public class BytesMessageInputStream extends InputStream
{

    public BytesMessage msg;

    public BytesMessageInputStream()
    {
    }

    public BytesMessageInputStream(BytesMessage message)
    {
        msg = message;
    }

    public int read()
        throws IOException
    {
        try
        {
            return msg.readByte() & 0xff;
        }
        catch(JMSException e)
        {
            return -1;
        }
    }
}
