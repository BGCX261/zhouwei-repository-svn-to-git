package com.techstar.framework.service.messaging.client;

import com.techstar.framework.service.messaging.engine.Engine;
import com.techstar.framework.service.messaging.engine.EngineException;
import com.techstar.framework.service.messaging.message.TSSPMessage;
import com.techstar.framework.service.messaging.message.TSSPMessageFactory;
import javax.xml.messaging.*;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


/**
 * 
 * @author yangjun
 *
 */
public class ConnectionImpl
    implements ProviderConnection
{

    private static final MetaDataImpl META_DATE = new MetaDataImpl();
    private Engine engine;

    protected ConnectionImpl(Engine engine)
    {
        this.engine = null;
        this.engine = engine;
    }

    public Engine getEngine()
    {
        return engine;
    }

    public ProviderMetaData getMetaData()
        throws JAXMException
    {
        return META_DATE;
    }

    public void close()
        throws JAXMException
    {
    }

    public MessageFactory createMessageFactory(String profile)
        throws JAXMException
    {
        return new TSSPMessageFactory();
    }

    public void send(SOAPMessage message)
        throws JAXMException
    {
        if(message instanceof TSSPMessage)
        {
            try
            {
                engine.send((TSSPMessage)message);
               
            }
            catch(EngineException e)
            {
                throw new JAXMException(e);
            }
        } else
        {
            throw new RuntimeException(getClass().getName() + ".send(SOAPMessage message) \u53C2\u6570\u5FC5\u987B\u662FWSSPMessage");
        }
    }

}
