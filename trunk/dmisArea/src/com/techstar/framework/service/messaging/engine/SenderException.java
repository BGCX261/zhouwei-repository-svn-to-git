package com.techstar.framework.service.messaging.engine;

/**
 * 
 * @author yangjun
 *
 */
public class SenderException extends Exception
{

    public SenderException()
    {
    }

    public SenderException(String message)
    {
        super(message);
    }

    public SenderException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SenderException(Throwable cause)
    {
        super(cause);
    }
}

