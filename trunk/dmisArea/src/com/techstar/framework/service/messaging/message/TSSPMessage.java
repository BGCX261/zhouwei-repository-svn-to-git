package com.techstar.framework.service.messaging.message;

import java.util.Iterator;

import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.message.SOAPEnvelope;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * 
 * @author yangjun
 *
 */
public class TSSPMessage extends Message
{

    private TSSPBody body;
    private TSSPHeader header;
    private Element resultRoot;

    protected TSSPMessage(Object initialContents, boolean bodyInStream)
    {
        super(initialContents, bodyInStream);
        resultRoot = null;
    }

    protected TSSPMessage(Object initialContents, boolean bodyInStream, MimeHeaders headers)
    {
        super(initialContents, bodyInStream, headers);
        resultRoot = null;
    }

    protected TSSPMessage(Object initialContents, MimeHeaders headers)
    {
    	//new Message()
    	super(initialContents,true,headers);
    	
        resultRoot = null;
    }

    protected TSSPMessage(Object initialContents, boolean bodyInStream, String contentType, String contentLocation)
    {
        super(initialContents, bodyInStream, contentType, contentLocation);
        resultRoot = null;
    }

    protected TSSPMessage(Object initialContents)
    {
        super(initialContents);
        resultRoot = null;
    }

    public TSSPAttachment createWSSPAttachment()
    {
        return new TSSPAttachment();
    }

    public TSSPHeader createTSSPHeader()
    {
        return new TSSPHeader();
    }

    public TSSPBody createTSSPBody()
    {
        return new TSSPBody();
    }

    public void setHeader(TSSPHeader header)
        throws SOAPException
    {
        this.header = header;
        String prefix = "wssp";
        String headerUri = "http://WSSP/Header";
        SOAPEnvelope envelope = null;
        try
        {
            envelope = getSOAPEnvelope();
        }
        catch(AxisFault ex)
        {
            ex.printStackTrace();
        }
        envelope.getHeader().detachNode();
        org.apache.axis.message.SOAPHeader soapHeader = (org.apache.axis.message.SOAPHeader)envelope.addHeader();
        soapHeader.addChildElement("From", prefix, headerUri).addTextNode(header.getFrom());
        soapHeader.addChildElement("To", prefix, headerUri).addTextNode(header.getTo());
        soapHeader.addChildElement("Title", prefix, headerUri).addTextNode(header.getTitle());
        soapHeader.addChildElement("Timestamp", prefix, headerUri).addTextNode(header.getTimestamp());
        soapHeader.addChildElement("TraceNumber", prefix, headerUri).addTextNode(header.getTraceNumber());
        soapHeader.addChildElement("ContentType", prefix, headerUri).addTextNode(header.getContentType());
        soapHeader.addChildElement("ContentVersion", prefix, headerUri).addTextNode(header.getContentVersion());
        saveChanges();
    }

    public TSSPHeader getHeader()
        throws SOAPException
    {
        TSSPHeader rHeader = new TSSPHeader();
        SOAPEnvelope envelope = null;
        try
        {
            envelope = getSOAPEnvelope();
        }
        catch(AxisFault ex)
        {
            throw new SOAPException("AxisFault" + ex);
        }
        SOAPHeader _header = envelope.getHeader();
        for(Iterator iterator = _header.getChildElements(); iterator.hasNext();)
        {
            SOAPElement _soapElement = (SOAPElement)iterator.next();
            if(_soapElement.getElementName().getLocalName().equals("From"))
            {
                rHeader.setFrom(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("To"))
            {
                rHeader.setTo(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("Title"))
            {
                rHeader.setTitle(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("Timestamp"))
            {
                rHeader.setTimestamp(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("TraceNumber"))
            {
                rHeader.setTraceNumber(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("ContentType"))
            {
                rHeader.setContentType(_soapElement.getValue());
            }
            if(_soapElement.getElementName().getLocalName().equals("ContentVersion"))
            {
                rHeader.setContentVersion(_soapElement.getValue());
            }
        }

        header = rHeader;
        return header;
    }

    public void setBody(TSSPBody body)
        throws SOAPException
    {
        this.body = body;
        Document doc = body.getDocument();
        Element root = doc.getDocumentElement();
        SOAPEnvelope envelope = null;
        try
        {
            envelope = getSOAPEnvelope();
        }
        catch(AxisFault ex)
        {
            throw new SOAPException("AxisFault:" + ex);
        }
        envelope.removeBody();
        javax.xml.soap.SOAPBody soapbody = envelope.addBody();
        Element result = null;
        constructBody(doc, root, resultRoot, true, body.getUri());
        envelope.addBodyElement(new SOAPBodyElement(resultRoot));
    }

    public TSSPBody getBody()
        throws SOAPException
    {
        SOAPEnvelope envelope = null;
        try
        {
            envelope = getSOAPEnvelope();
        }
        catch(AxisFault ex)
        {
            throw new SOAPException("AxisFault:" + ex);
        }
        SOAPBodyElement _soapbodyele = null;
        try
        {
            _soapbodyele = envelope.getFirstBody();
        }
        catch(AxisFault ex1)
        {
            throw new SOAPException("AxisFault:" + ex1);
        }
        try
        {
            body = new TSSPBody(_soapbodyele.getAsDocument());
        }
        catch(Exception ex2)
        {
            throw new SOAPException("AxisFault:" + ex2);
        }
        return body;
    }

    public void addAttachment(TSSPAttachment attachment)
    {
        super.addAttachmentPart(attachment);
    }
    public void addAttachment(javax.xml.soap.AttachmentPart attachment)
    {
        super.addAttachmentPart(attachment);
    }

    private boolean isText(Node node)
    {
        NodeList list = node.getParentNode().getChildNodes();
        return list.getLength() == 1;
    }

    private void constructBody(Document doc, Node oldNode, Node newNode, boolean isRoot, String bodyUri)
        throws SOAPException
    {
        boolean isText = false;
        switch(oldNode.getNodeType())
        {
        case 2: // '\002'
        default:
            break;

        case 1: // '\001'
            if(isRoot)
            {
                resultRoot = doc.createElementNS(bodyUri, oldNode.getNodeName());
                newNode = resultRoot;
            } else
            {
                Element e = doc.createElementNS(bodyUri, oldNode.getNodeName());
                NamedNodeMap attr = oldNode.getAttributes();
                for(int i = 0; i < attr.getLength(); i++)
                {
                    e.setAttribute(attr.item(i).getNodeName(), attr.item(i).getNodeValue());
                }

                newNode.appendChild(e);
                newNode = e;
            }
            NodeList list = oldNode.getChildNodes();
            for(int j = 0; j < list.getLength(); j++)
            {
                Node _ele = list.item(j);
                constructBody(doc, _ele, newNode, false, bodyUri);
            }

            break;

        case 3: // '\003'
            if(!isRoot && isText(oldNode))
            {
                newNode.appendChild(doc.createTextNode(oldNode.getNodeValue()));
            }
            break;
        }
    }
    
    
}

