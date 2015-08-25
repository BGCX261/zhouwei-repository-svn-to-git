package com.techstar.treedemo.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelout.RoleGroup;
import com.techstar.framework.service.security.modelout.RoleOut;
import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.TreeActionHelp;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.treedemo.service.ListTreeService;

public class ResourceTreeAction extends BaseDispatchAction {

	ListTreeService service = new ListTreeService();

	// 初始化组织机构树
	public ActionForward initOrgTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		//根据当前登录用户取直属单位
		UserProfile u = ServiceLocator.getUserProfile();
		String userName = u.getUserName();
		UnitOut out = service.queryDirectUnitByUser(userName);
		String unitId = out.getPARENTID();
		request.setAttribute("unitId",unitId);
		return mapping.findForward("initOrgTree");
	}

	// 初始化角色树
	public ActionForward initRoleTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("initRoleTree");
	}

	/**
	 * 得到用户直属组织机构树
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getOrgTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		response.setContentType("text/xml;charset=utf-8");
		
		//根据当前登录用户取直属单位
		UserProfile u = ServiceLocator.getUserProfile();
		String userName = u.getUserName();
		UnitOut out = service.queryDirectUnitByUser(userName);
		String unitId = out.getUNITID();
		
		//取直属单位（二级单位）下所有组织机构信息
		QueryUnit qu = new QueryUnit();
		Unit unit = new Unit();
		unit.setOPER_TYPE("equal");
		unit.setUNITID(unitId);
		unit.setRETURNMODE("2");
		qu.setUNIT(unit);
		
		List result = service.queryUnit(qu);

		ArrayList list = new ArrayList();
	    DhtmlxTreeNode nodep =  new DhtmlxTreeNode();
	    nodep.setId(out.getPARENTID());
		list.add(nodep);			
		for (int i = 0; i < result.size(); i++) {
			UnitOut unitOut = (UnitOut)result.get(i);
			DhtmlxTreeNode node = new DhtmlxTreeNode();
			node.setId(unitOut.getUNITID());
			node.setText(unitOut.getUNITNAME());
			node.setIsChecked("0");
			node.setParentId(unitOut.getPARENTID());
			list.add(node);
		}
		NodeXMLHelp help = new NodeXMLHelp();
		help.setNodes(list);
		String xml = help.getAllXmlByParentNode(nodep);
		response.getWriter().print(xml);

		return null;
	}	
	
	
	/**
	 * 得到角色树
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getRoleGroupTree(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		response.setContentType("text/xml;charset=utf-8");
		DhtmlxTreeNode dnode = TreeActionHelp.getTreeNodeByRequest(request);
		String id = dnode.getId();
		if (id.equals("0")){//初始化
			List result = service.queryRoleGroupAll();
			ArrayList list = new ArrayList();
		    DhtmlxTreeNode nodep =  new DhtmlxTreeNode();
		    nodep.setId("0");
			list.add(nodep);			
			for (int i = 0; i < result.size(); i++) {
				RoleGroup roleGroup = (RoleGroup)result.get(i);
				DhtmlxTreeNode node = new DhtmlxTreeNode();
				node.setId(roleGroup.getGROUPID());
				node.setText(roleGroup.getGROUPNAME());
				node.setIsChecked("0");
				node.setChildFlag("1");
				node.setParentId(roleGroup.getGROUPPID());
				list.add(node);
			}
			NodeXMLHelp help = new NodeXMLHelp();
			help.setNodes(list);
			String xml = help.getAllXmlByParentNode(nodep);
			response.getWriter().print(xml);
		}else{//取角色
			String groupName = dnode.getText();
			List result = service.queryRoleByGroup(groupName);
			ArrayList list = new ArrayList();
			for (int i = 0; i < result.size(); i++) {
				RoleOut role = (RoleOut)result.get(i);
				DhtmlxTreeNode node = new DhtmlxTreeNode();
				node.setId(role.getROLEID());
				node.setText(role.getROLENAME());
				node.setIsChecked("0");
				node.setParentId(id);
				list.add(node);
			}
			NodeXMLHelp help = new NodeXMLHelp();
			help.setNodes(list);
			String xml = help.getAllXmlByParentNode(dnode);
			response.getWriter().print(xml);			
		}
		return null;
	}
}
