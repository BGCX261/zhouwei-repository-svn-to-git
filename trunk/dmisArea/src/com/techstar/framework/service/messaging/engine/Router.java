package com.techstar.framework.service.messaging.engine;

import com.techstar.framework.service.messaging.message.*;

/**
 * 
 * @author yangjun
 *
 */
public abstract class Router
{

    public Router()
    {
    }

    public abstract Endpoint getDestination(TSSPMessage tsspmessage)
        throws RouterException;
}