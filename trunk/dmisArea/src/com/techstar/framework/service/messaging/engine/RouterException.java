package com.techstar.framework.service.messaging.engine;

/**
 * 
 * @author yangjun
 *
 */
public class RouterException extends Exception
{

    public RouterException()
    {
    }

    public RouterException(String message)
    {
        super(message);
    }

    public RouterException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public RouterException(Throwable cause)
    {
        super(cause);
    }
}

