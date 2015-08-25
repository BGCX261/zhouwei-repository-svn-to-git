package com.techstar.framework.service.messaging.message;

/**
 * 
 * @author yangjun
 *
 */
public class TSSPHeader
{

    private String from;
    private String to;
    private String title;
    private String timestamp;
    private String traceNumber;
    private String contentType;
    private String contentVersion;

    public TSSPHeader()
    {
    }

    public TSSPHeader(String from, String to, String title, String timestamp, String traceNumber, String contentType, String contentVersion)
    {
        this.from = from;
        this.to = to;
        this.title = title;
        this.timestamp = timestamp;
        this.traceNumber = traceNumber;
        this.contentType = contentType;
        this.contentVersion = contentVersion;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTraceNumber()
    {
        return traceNumber;
    }

    public void setTraceNumber(String traceNumber)
    {
        this.traceNumber = traceNumber;
    }

    public String getContentType()
    {
        return contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public String getContentVersion()
    {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion)
    {
        this.contentVersion = contentVersion;
    }
}
