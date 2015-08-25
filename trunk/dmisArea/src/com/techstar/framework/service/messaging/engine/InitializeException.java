package com.techstar.framework.service.messaging.engine;

/**
 * 
 * @author yangjun
 *
 */
public class InitializeException extends Exception
{

    public InitializeException()
    {
    }

    public InitializeException(String message)
    {
        super(message);
    }

    public InitializeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InitializeException(Throwable cause)
    {
        super(cause);
    }
}
