package com.techstar.framework.service.messaging.message;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 * 
 * @author yangjun
 *
 */
public class TSSPBody
{

    private Document document;
    private String uri;

    public TSSPBody()
    {
    }

    public TSSPBody(Document document)
    {
        this.document = document;
    }

    public void init(String s1)
    {
    }

    public Document getDocument()
    {
        return document;
    }

    public void setDocument(Document document)
    {
        this.document = document;
    }

    public String getDomAsString()
        throws TransformerConfigurationException, TransformerException, UnsupportedEncodingException
    {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(baos);
        transformer.transform(source, result);
        String ss = new String(baos.toByteArray(), "UTF-8");
        return ss;
    }

    public String getUri()
    {
        return uri;
    }

    public void setUri(String uri)
    {
        this.uri = uri;
    }
}
