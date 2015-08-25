package com.techstar.dmis.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.jbpm.logging.log.ProcessHisLog;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.dao.DataAccessException;
import org.xml.sax.InputSource;

import com.techstar.dmis.dao.IHandleHistoryDao;
import com.techstar.dmis.dao.ITodolistDao;
import com.techstar.dmis.entity.DdMoutageplan;
import com.techstar.dmis.entity.HandleHistory;
import com.techstar.dmis.service.ITodolistService;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.service.workflow.dao.IWorkflowDao;
import com.techstar.framework.utils.BeanHelper;

public class TodolistServiceImpl implements ITodolistService {

	private IWorkflowDao workFlowDao;

	public void setWorkFlowDao(IWorkflowDao workFlowDao) {
		this.workFlowDao = workFlowDao;
	}
	
	ITodolistDao todolistDao;
	public void setTodolistDao(ITodolistDao todolistDao) {
		this.todolistDao = todolistDao;
	}
	
	IHandleHistoryDao handleHistoryDao;
	public void setHandleHistoryDao(IHandleHistoryDao handleHistoryDao) {
		this.handleHistoryDao = handleHistoryDao;
	}

	public List getWorkflowTodolist(String objName,String actorId) {
		return this.todolistDao.getWorkflowTodolist(objName,actorId);
	}
	
	public void saveOrUpdate(HandleHistory handleHistory) {
		this.handleHistoryDao.saveOrUpdate(handleHistory);
	}

	public QueryListObj listHandleHistorys(String businessId) {
		String hql = "from HandleHistory a where a.bus_id='"+businessId+"' order by a.handle_time desc";
		QueryListObj obj = handleHistoryDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(HandleHistory.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;		
	}

	public String retrieveByteArraysOfGpd(long taskInstanceId) throws DataAccessException {
	       String xml = "";
	       try {
	           List logs = this.workFlowDao.findTransitionLogs(taskInstanceId);
	           List nodelist = new ArrayList();
	           if(logs.size()>0){
	           for (int i = 0; i < logs.size(); i++) {
	              ProcessHisLog log = (ProcessHisLog) logs.get(i);
	              System.out.println("log.getName()===="+log.getName());
	              if(!nodelist.contains(log.getName()))
	                  nodelist.add(log.getName());
	              System.out.println(log.getName());
	           }
	           }

	           xml = this.workFlowDao.retrieveByteArraysOfGpd(taskInstanceId);
	           SAXBuilder sb = new SAXBuilder(); 
	           Document doc = null;
	           try{
	        	 StringReader sr = new StringReader(xml);
	             InputSource is = new InputSource(sr);
	             is.setEncoding("UTF-8");
	            doc = sb.build(is);
	           }catch(Exception e){
	        	   System.out.println("e===="+doc);
	           }
	           
	           Element root = doc.getRootElement();
	           List g = root.getChildren("g");
	           for (int i = 0; i < g.size(); i++) {
	              Element rect = ((Element) g.get(i)).getChild("rect");
	              String id = rect.getAttributeValue("id");
	              if (nodelist.contains(id))
	                  rect.setAttribute("stroke", "red");
	           }

	          
	           Writer writer = new StringWriter();
	           XMLOutputter xo = new XMLOutputter(Format.getPrettyFormat()
	                  .setEncoding("UTF-8"));
	           xo.output(doc, writer);
               xml = writer.toString();
	         
	       } catch (Exception ex) {
	    	   System.out.println("ex==="+ex.getMessage());
	           ex.printStackTrace();
	       }
	       return xml;
	}
	
    public  void output(String filePath, String fileName, StringWriter w) {
        try {
            FileWriter fw = new FileWriter(filePath + fileName);
           // System.out.println(fw.getEncoding());
            fw.write(w.getBuffer().toString());
            fw.flush();
            fw.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
	
}
