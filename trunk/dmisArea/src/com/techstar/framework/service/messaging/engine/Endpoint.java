package com.techstar.framework.service.messaging.engine;

import java.io.Serializable;

/**
 * 
 * @author yangjun
 *
 */
public class Endpoint
    implements Serializable
{

    public static final String PROTOCOL_TSSP = "TSSP";
    private String url;
    private String protocol;

    public Endpoint()
    {
    }

    public String getProtocol()
    {
        return protocol;
    }

    public String getUrl()
    {
        return url;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
