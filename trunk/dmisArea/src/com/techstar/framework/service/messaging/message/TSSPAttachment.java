package com.techstar.framework.service.messaging.message;

import org.apache.axis.attachments.AttachmentPart;

/**
 * 
 * @author yangjun
 *
 */
public class TSSPAttachment extends AttachmentPart
{

    private String attachmenetName;
    private String cid;

    protected TSSPAttachment()
    {
    }

    public String getAttachmenetName()
    {
        return attachmenetName;
    }

    public void setAttachmenetName(String attachmenetName)
    {
        this.attachmenetName = attachmenetName;
    }

    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        setContentId(cid);
        this.cid = cid;
    }
}

