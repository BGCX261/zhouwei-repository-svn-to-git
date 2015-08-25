package com.techstar.treedemo.web.action;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.techstar.treedemo.service.ListTreeService;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.TreeActionHelp;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.ui.entity.TreeTagProperty;

public class ListTreeTestAction extends BaseDispatchAction{
	
	
	ListTreeService service = new ListTreeService();
	public ActionForward getTreeNodes(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			response.setContentType("text/xml;charset=utf-8");
			DhtmlxTreeNode node = TreeActionHelp.getTreeNodeByRequest(request);
			String xml = service.getTreeXml(node);
			response.getWriter().print(xml);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getTreeNodes2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			response.setContentType("text/xml;charset=utf-8");
			DhtmlxTreeNode node = TreeActionHelp.getTreeNodeByRequest(request);
			String xml = service.getTreeXml2(node);
			response.getWriter().print(xml);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ActionForward getTreeNodes3(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			response.setContentType("text/xml;charset=utf-8");
			DhtmlxTreeNode node = TreeActionHelp.getTreeNodeByRequest(request);
			String param = node.getUserData();
			System.out.println("param="+param);
			String xml = service.getTreeXml3(node);
			response.getWriter().print(xml);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 把tag的属性存到TreeTagProperty 的对象中传到页面
	 */
	public ActionForward testTag(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			/**
			 * divid="treeboxbox_tree" 
			jhoptree=""
			treeid="zsy" 
			queryPath="/listtree.do?method=getTreeNodes" 
			treedisname="listtree" 
			checkboxflag="true"
			clickHandler = "oncl"
			dragFlag="true"
			dropHandler = "changeParent"
			 */
			TreeTagProperty pro = new TreeTagProperty();
			pro.setJhoptree("jhoptree");
			pro.setDivid("treeboxbox_tree");
			pro.setTreeid("zsy");
			pro.setCheckboxflag("1");
			pro.setClickHandler("oncl");
			pro.setDragFlag("true");
			DhtmlxTreeNode node =new DhtmlxTreeNode();
			node.setId("zsy");
			String xml = service.getTreeXml(node);
			pro.setDatasxml(xml);
			request.setAttribute("pro", pro);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward("listtree");
	}
	
	
	
	/**
	 * 把tag的属性存到TreeTagProperty 的对象中传到页面
	 */
	public ActionForward testTag2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			/**
			 * divid="treeboxbox_tree" 
			jhoptree=""
			treeid="zsy" 
			queryPath="/listtree.do?method=getTreeNodes" 
			treedisname="listtree" 
			checkboxflag="true"
			clickHandler = "oncl"
			dragFlag="true"
			dropHandler = "changeParent"
			 */
			TreeTagProperty pro = new TreeTagProperty();
			pro.setJhoptree("jhoptree");
			pro.setDivid("treeboxbox_tree");
			pro.setTreeid("zsy");
			pro.setCheckboxflag("1");
			pro.setClickHandler("oncl");
			pro.setDragFlag("true");
			DhtmlxTreeNode node =new DhtmlxTreeNode();
			node.setId("zsy");
			//String xml = service.getTreeXml(node);
		
			
			
			DhtmlxTreeNode noderoot =  new DhtmlxTreeNode();
			noderoot.setId("zsy");
			DhtmlxTreeNode node1 = new DhtmlxTreeNode();
			node1.setId("-1");
			node1.setText("资源");
			node1.setTreeName("tree1");
			node1.setNodeDisName("resource");
			node1.setParentId("zsy");
			//node1.setIsOpen("1");
			node1.setChildFlag("1");
			node1.setUserData("-1|-1|-1");
			
			
			DhtmlxTreeNode node2 = new DhtmlxTreeNode();
			node2.setId("-2");
			node2.setText("资源2");
			node2.setTreeName("tree1");
			node2.setNodeDisName("resource");
			node2.setParentId("zsy");
			node2.setIsOpen("1");
			node2.setUserData("-2|-1|-1");
			ArrayList list = new ArrayList();
			list.add(noderoot);
			list.add(node1);
			list.add(node2);
			
			
			NodeXMLHelp help = new NodeXMLHelp();
			help.setNodes(list);
			String xml = help.getAllXmlByParentNode(noderoot);
			pro.setDatasxml(xml);
			request.setAttribute("pro", pro);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mapping.findForward("ziyuan");
	}
	

}
