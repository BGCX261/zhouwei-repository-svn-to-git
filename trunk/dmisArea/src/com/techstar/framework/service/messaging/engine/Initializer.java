package com.techstar.framework.service.messaging.engine;

/**
 * 
 * @author yangjun
 *
 */
public abstract class Initializer
{

    public Initializer()
    {
    }

    protected abstract void initialize()
        throws InitializeException;
}