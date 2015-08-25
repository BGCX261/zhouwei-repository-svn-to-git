package com.techstar.framework.service.messaging.engine;

import com.techstar.framework.service.messaging.message.TSSPMessage;
import java.io.InputStream;
import org.apache.axis.message.MimeHeaders;

/**
 * 
 * @author yangjun
 *
 */
public class Engine
{

    private EngineContext context;

    protected Engine(EngineContext context)
    {
        this.context = null;
        this.context = context;
    }

    public void send(TSSPMessage message)
        throws EngineException
    {
        Sender sender = context.createSender();
        Router router = context.createRouter();
        Endpoint dest;
        try
        {
            dest = router.getDestination(message);
        }
        catch(RouterException e)
        {
            throw new EngineException("路由发生错误", e);
        }
        try
        {
            sender.send(message, dest);
        }
        catch(SenderException e)
        {
            throw new EngineException("发送错误", e);
        }
    }

    public Receiver getReceiver()
    {
        Receiver receiver = context.createReceiver();
        if(receiver == null)
        {
            throw new RuntimeException("运行发生错误");
        } else
        {
            return receiver;
        }
    }

    private TSSPMessage covertToMessage(MimeHeaders mimeHeaders, InputStream data)
    {
        return null;
    }
}

