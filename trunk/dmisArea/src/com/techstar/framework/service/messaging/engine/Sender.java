package com.techstar.framework.service.messaging.engine;

import com.techstar.framework.service.messaging.message.TSSPMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.soap.SOAPException;

/**
 * 
 * @author yangjun
 *
 */
public abstract class Sender
{
    private byte[] by;
    public Sender()
    {
    }

    public void send(TSSPMessage message, Endpoint endpoint)
        throws SenderException
    {
        try
        {
            open();
            OutputStream out = getOutputStream();
        	//ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try
            {
                message.writeTo(out);
                //by = out.toByteArray();
                
            }
            catch(SOAPException e)
            {
                throw new RuntimeException(e);
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
            
             send(endpoint);
        }
        catch(SenderException e)
        {
            throw e;
        }
        finally
        {
            try
            {
                close();
            }
            catch(SenderException e) { }
        }
        return;
    }

    protected abstract void open()
        throws SenderException;

    protected abstract OutputStream getOutputStream()
        throws SenderException;

    protected abstract void send(Endpoint endpoint)
        throws SenderException;

    protected abstract void close()
        throws SenderException;
}

