package com.techstar.framework.service.messaging.engine;

/**
 * 
 * @author yangjun
 *
 */
public class EngineException extends Exception
{

    public EngineException()
    {
    }

    public EngineException(String message)
    {
        super(message);
    }

    public EngineException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EngineException(Throwable cause)
    {
        super(cause);
    }
}