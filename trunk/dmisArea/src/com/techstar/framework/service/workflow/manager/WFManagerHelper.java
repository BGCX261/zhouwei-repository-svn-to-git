package com.techstar.framework.service.workflow.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;



import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.NodesListPool;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.service.workflow.bus.dto.NodeDto;
import com.techstar.framework.service.workflow.bus.dto.JbpmCmsDto;

import org.dom4j.DocumentHelper;


public class WFManagerHelper {
	
	
	private static WFManagerHelper Instance = new WFManagerHelper();
	public  static int ALL_DELETE = 0;
	public  static int MERGE_DELETE =1;
	private WFManagerHelper(){}
	public static WFManagerHelper getInstance(){
		return Instance;
	}
	
	
	/**
	 * 此方法用于得到节点显示树结构
	 * @param wfnodes
	 * @return
	 */
	public List getWFViewNodes(DhtmlxTreeNode nodewf,DhtmlxTreeNode root,List wfnodes,String wfId){
		List viewnodes = new ArrayList();
		viewnodes.add(root);
		viewnodes.add(nodewf);
		try{
			for (int i=0;i<wfnodes.size();i++){
			   NodeDto node = (NodeDto)wfnodes.get(i);
			   DhtmlxTreeNode node1 =  new DhtmlxTreeNode();
			   node1.setId(String.valueOf(node.getNodeId()));
			   node1.setText(node.getNode_name());
			   node1.setIsChecked("1");
			   node1.setParentId("1");
			   node1.setUserData(String.valueOf(node.getNodeType()+"#processdefId="+wfId));
			   viewnodes.add(node1);
			}
		}catch(Exception ex){
			System.out.println("用于得到树型显示");
		}
		return viewnodes;
	}
	
	
	/**
	 * 用于将CMS数据倒入到数据库
	 * @param path
	 */
	public  java.util.List getWorkFlowBeans(String xmlText)  {
		//		 获取第一层元素集合 root下

		List result = new ArrayList();
		try {
			System.out.println("$$$$$$");
			Document doc = DocumentHelper.parseText(xmlText);
			System.out.println("######");
			org.dom4j.Element root = doc.getRootElement();
			List wfs = root.elements("workflow");
			if (wfs == null || wfs.size() == 0)
				return result;

			for (int i = 0; i < wfs.size(); i++) {
				JbpmCmsDto wfBean = new JbpmCmsDto();
				Element workFlow = (Element) wfs.get(i);
				Element name = workFlow.element("name");
				Element enname = name.element("enName");
				
				
				wfBean.setId(new SequenceCreator().getUID());
				wfBean.setProcess_name(enname.getText());
				wfBean.setBus_name(parseDtos(workFlow));
				result.add(wfBean);
			}
			return result;
		} catch (Exception ce) {
			System.out.println("parse exception is"+ce.getMessage());
		}
		 return result;
	}
		
	private String parseDtos(Element workFlow) {
			// TODO Auto-generated method stub
			Element ename = workFlow.element("dto");
			if( ename !=null){			
				String name = ename.element("enName").getText();
				return name;
			}else {
				return "";
			}
			
		}
	
    
	public static void main(String[] args){
	
    WFManagerHelper helper =WFManagerHelper.getInstance();
    String str="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+"<wfdefine>" +
    		"<workflow name=\"DdEnsuringpsmanage_city\">"
           +"<!--工作流描述--><name>"
          +" <cnName>DD-政治保电流程-市调</cnName>"
          +"<enName>DdEnsuringpsmanage_city</enName>"
          +"<desc />"
    +"</name> <!--实体描述-->"
    +"<dto><cnName>政治保电管理</cnName>"
    +"<enName>DdEnsuringpsmanage</enName>"
    +"</dto><!--工作流操作类描述-->"
    +"<!--implType:1-IAction 2-IAssignment 3-IDecision 4-ITaskController-->"
    +"<handler>"
    +"<cnName>会签政治保电源单</cnName>"
    +"<className>DDEnsuringPSCountersign</className>"
    +"<implType>2</implType><desc />"
    +"</handler><handler>"
    +"<cnName>调度处长审批</cnName>"
    +"<className>DDEnsuringPSApprove</className>"
    +"<implType>2</implType>"
    +"<desc />"
    +"</handler>"
    +"<handler>"
    +"<cnName>下发政治保电</cnName>"
    +"<className>DDEnsuringPSSent</className>"
    +"<implType>2</implType>"
     +"<desc />"
     +"</handler>"
    +"<handler>"
    +"<cnName>撤回审批</cnName>"
    +"<className>DDEnsuringPSCancelApprove</className>"
    +"<implType>2</implType>"
    +"<desc /></handler>"
    +"<handler>"
    +"<cnName>执行政治保电</cnName>"
    +"<className>DDEnsuringPSExecute</className>"
    +"<implType>2</implType>"
    +"<desc /></handler>"
    +"<handler>"
    +"<cnName>归档</cnName>"
    +"<className>DDEnsuringPSKeepon</className>"
    +"<implType>2</implType>"
    +"<desc /></handler>"
    +"<handler><cnName>填写</cnName>"
    +"<className>DDEnsuringPSModify</className>"
    +"<implType>2</implType>"
    +"<desc /></handler></workflow>" +
    "</wfdefine>";
    
    helper.getWorkFlowBeans(str);

		
		
	}
    
	  public String getCloseReturnStr(String mess) {
		  String returnStr = "";

		  try{
		    returnStr ="<script language=\"javascript\">"
		              +"alert(\""+mess+",点击关闭窗口~~！！\");"
		              +"window.close()"
		              +"</script>";
		  }catch(Exception ex){
		    System.out.println(" 得到发布成功字符发生异常"+ex.getMessage());
		  }
		  return returnStr;

		 }
	
	

}
