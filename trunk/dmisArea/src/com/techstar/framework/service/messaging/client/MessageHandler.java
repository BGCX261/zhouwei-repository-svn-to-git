package com.techstar.framework.service.messaging.client;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.JMSException;
import javax.jms.BytesMessage;
import javax.xml.messaging.JAXMException;
import javax.xml.messaging.ProviderConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import org.apache.commons.io.FileUtils;

import com.techstar.framework.service.messaging.message.TSSPMessage;
import com.techstar.framework.service.messaging.client.Receiver;


public class MessageHandler implements MessageListener {

    public void onMessage(Message message) {
    	 if (message instanceof BytesMessage) {
    		 String path = "c:\\temp\\";
    		 FileOutputStream fout = null;
          try {
        	  BytesMessage msg = (BytesMessage)message;
        	  TSSPMessage tssmsg = (TSSPMessage)Receiver.createReceiver().getSoapMessage(msg);
        		File file = new File(path, Long.toString(new Date().getTime()));
				fout = new FileOutputStream(file);
				System.out.println("received message, saved to :" + file.getAbsolutePath());
				tssmsg.writeTo(fout);
        	  
            } catch (Exception exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
        
    
   }
}