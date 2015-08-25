package com.techstar.framework.service.messaging.agent;

import com.techstar.framework.service.messaging.engine.Endpoint;

/**
 * 
 * @author yangjun
 *
 */
public class ServerEndPoint extends Endpoint
{

    private static ServerEndPoint instance = new ServerEndPoint();

    public static ServerEndPoint getInstance()
    {
        return instance;
    }

    private ServerEndPoint()
    {
        setProtocol("JMS");
        setUrl("http://DTZX");
    }

}