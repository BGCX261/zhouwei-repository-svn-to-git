package com.techstar.framework.service.workflow.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.filter.QueryUserByName;
import com.techstar.framework.service.security.filter.QueryUserByUnit;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelin.User;
import com.techstar.framework.service.security.modelout.RoleGroup;
import com.techstar.framework.service.security.modelout.RoleOut;
import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.service.security.modelout.UserOut;
import com.techstar.framework.service.workflow.bus.dto.TaskRoleDto;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.TreeActionHelp;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.tag.engine.ApplicationResourcesUtil;
import com.techstar.framework.utils.PaginationModel;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.web.SessionContext;
import com.techstar.framework.web.action.BaseDispatchAction;

public class ResourceTreeAction extends BaseDispatchAction {

	// ListTreeService service = new ListTreeService();
	private WFManagerFacade wfmanagerfacade;

	private SysUiGridFacade sysUiGridFacade;

	public SysUiGridFacade getSysUiGridFacade() {
		return sysUiGridFacade;
	}

	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}

	public WFManagerFacade getWfmanagerfacade() {
		return wfmanagerfacade;
	}

	public void setWfmanagerfacade(WFManagerFacade wfmanagerfacade) {
		this.wfmanagerfacade = wfmanagerfacade;
	}

	// 初始化组织机构树
	public ActionForward initOrgTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ISecurityService service = ServiceLocator.getSecurityService();
		// 根据当前登录用户取直属单位

		UserProfile u = ServiceLocator.getUserProfile();
		String userName = u.getUserName();
		UnitOut out = service.queryDirectUnitByUser(userName);
		String unitId = out.getPARENTID();

		String node_id = request.getParameter("taskdef_id");
		String processdefId = request.getParameter("processdef_id");

		// String url
		// =request.getContextPath()+"/resourcetree.do?method=getRoleGroupTree&node_id="+node_id;

		request.setAttribute("taskdef_id", node_id);
		request.setAttribute("processdef_id", processdefId);

		request.setAttribute("unitId", unitId);
		return mapping.findForward("initOrgTree");
	}

	// 初始化角色树
	public ActionForward initRoleTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String node_id = request.getParameter("node_id");
		String processdefId = request.getParameter("processdefId");

		// String url
		// =request.getContextPath()+"/resourcetree.do?method=getRoleGroupTree&node_id="+node_id;

		request.setAttribute("node_id", node_id);
		request.setAttribute("processdefId", processdefId);
		return mapping.findForward("initRoleTree");
	}

	/**
	 * 得到用户直属组织机构树
	 * 
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getOrgTree(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		response.setContentType("text/xml;charset=utf-8");
		// 根据当前登录用户取直属单位

		UserProfile u = ServiceLocator.getUserProfile();
		String userName = u.getUserName();
		UnitOut out = service.queryDirectUnitByUser(userName);
		String unitId = out.getUNITID();
		String processdef_id = request.getParameter("processdef_id");
		String taskdef_id = request.getParameter("taskdef_id");

//		System.out.println("getOrgTree=processdef_id" + processdef_id);
//		System.out.println("getOrgTree=taskdef_id" + taskdef_id);

		request.setAttribute("processdef_id", processdef_id);
		request.setAttribute("taskdef_id", taskdef_id);

		// 取直属单位（二级单位）下所有组织机构信息

		QueryUnit qu = new QueryUnit();
		Unit unit = new Unit();
		unit.setOPER_TYPE("equal");
		unit.setUNITID(unitId);
		unit.setRETURNMODE("2");
		qu.setUNIT(unit);

		List result = service.queryUnit(qu);

		ArrayList list = new ArrayList();
		DhtmlxTreeNode nodep = new DhtmlxTreeNode();
		nodep.setId(out.getPARENTID());
		list.add(nodep);
		for (int i = 0; i < result.size(); i++) {
			UnitOut unitOut = (UnitOut) result.get(i);
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

		System.out.println("xml#####=" + xml);
		response.getWriter().print(xml);

		return null;
	}

	/**
	 * 得到角色树
	 * 
	 * 
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

		String task_id = request.getParameter("node_id");
		String processDef_id = request.getParameter("processdefId");
		System.out.println("task_id=" + task_id);
		try {
			String[] actors = wfmanagerfacade.getTask_roles(Long
					.parseLong(task_id));

			//System.out.println("actors length====" + actors);
			String id = dnode.getId();

			if (id.equals("0")) {// 初始化

				List result = service.queryRoleGroupAll();
				ArrayList list = new ArrayList();
				DhtmlxTreeNode nodep = new DhtmlxTreeNode();
				nodep.setId("0");
				list.add(nodep);
				for (int i = 0; i < result.size(); i++) {
					RoleGroup roleGroup = (RoleGroup) result.get(i);
					DhtmlxTreeNode node = new DhtmlxTreeNode();
					node.setId(roleGroup.getGROUPID());
					node.setText(roleGroup.getGROUPNAME());

					if (setCheckValue(actors, roleGroup.getGROUPNAME())) {
						node.setIsChecked("1");
					} else {
						node.setIsChecked("0");
					}

					node.setChildFlag("1");
					node.setUserData(processDef_id);
					node.setParentId(roleGroup.getGROUPPID());
					list.add(node);
				}
				NodeXMLHelp help = new NodeXMLHelp();
				help.setNodes(list);
				String xml = help.getAllXmlByParentNode(nodep);
				response.getWriter().print(xml);
			} else {// 取角色

				String groupName = dnode.getText();
				List result = service.queryRoleByGroup(groupName);
				ArrayList list = new ArrayList();
				for (int i = 0; i < result.size(); i++) {
					RoleOut role = (RoleOut) result.get(i);
					DhtmlxTreeNode node = new DhtmlxTreeNode();
					node.setId(role.getROLEID());
					node.setUserData(processDef_id);
					node.setText(role.getROLENAME());
					if (setCheckValue(actors, role.getROLENAME())) {
						node.setIsChecked("1");
					} else {
						node.setIsChecked("0");
					}
					node.setParentId(id);
					list.add(node);
				}
				NodeXMLHelp help = new NodeXMLHelp();
				help.setNodes(list);
				String xml = help.getAllXmlByParentNode(dnode);
				//System.out.println("xml$$$$$=" + xml);
				response.getWriter().print(xml);
			}
		} catch (Exception ex) {
			System.out.println("ex get message" + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	public boolean setCheckValue(String[] actors, String name) {
		boolean isCheck = false;
		try {
			if (actors != null && actors.length > 0) {
				for (int j = 0; j < actors.length; j++) {
					if (actors[j].equalsIgnoreCase(name)) {
						isCheck = true;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("检查是否check" + ex.getMessage());
		}
		return isCheck;
	}

	public ActionForward addWFTaskRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WFManagerHelper helper = WFManagerHelper.getInstance();
		String message = "";
		try {

			WFManagerForm theForm = (WFManagerForm) form;
			long taskdef_id = theForm.getNode_id();
			String roles = theForm.getRoles();
			roles = StringUtils.replaceChars(roles, ",", ";");
			long processdef_id = theForm.getProcessdefId();
			
//			System.out.println("processdef_id==="+processdef_id);
//			System.out.println("taskdef_id==="+taskdef_id);
//			System.out.println("roles==="+roles);
             
		
			
			List taskroles = wfmanagerfacade.getTaskRoles(processdef_id,taskdef_id);

			String name = wfmanagerfacade.getTaskDefNameByTaskDefId(
					processdef_id, taskdef_id);
			
			

		TaskRoleDto dto = null;
			if(taskroles.size()==0){
				dto  =new TaskRoleDto();
				long seq = System.currentTimeMillis();
			    dto.setPremission_id(seq);
			}else{
				dto = (TaskRoleDto)taskroles.get(0);
			}
			dto.setProcess_id(processdef_id);
			dto.setTask_id(taskdef_id);
			dto.setNeccesory(0);
			dto.setAgency_role("0");
			dto.setTask_name(name);
			dto.setTask_role(roles);
			wfmanagerfacade.addTaskRoleDto(dto);
			message = ApplicationResourcesUtil.getMessage("wf.endwf._success");

		} catch (Exception ex) {
			System.out.println("" + ex.getMessage());
			message = ApplicationResourcesUtil.getMessage("wf.endwf._false");
		}
		String str = helper.getCloseReturnStr(message);
		request.setAttribute("message", str);

		return mapping.findForward("success");

	}

	public ActionForward getUserList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		response.setContentType("text/xml;charset=utf-8");

		// 页面变量处理
		String unit_id = request.getParameter("unit_id");
		String processdef_id = request.getParameter("processdef_id");
		String taskdef_id = request.getParameter("taskdef_id");

		request.setAttribute("unit_id", unit_id);
		request.setAttribute("processdef_id", processdef_id);
		request.setAttribute("taskdef_id", taskdef_id);

		//
		String gridSign = request.getParameter("gridSign");
		String xmlStr = "";
		if (StringUtils.isNotEmpty(gridSign)) {
			// 根据组织机构查用户
			List users = new ArrayList();
			if (StringUtils.isNotEmpty(unit_id)) {
				QueryUserByUnit q = new QueryUserByUnit();
				List list = new ArrayList();
				Unit unit = new Unit();
				unit.setOPER_TYPE("equal");
				unit.setUNITID(unit_id);
				list.add(unit);
				q.setUNITS(list);
				q.setUNITS_REF("or");
				users = service.queryUserByUnit(q);
			}
			int count = users.size();
			String hqlStr = "";
			String userId = "";
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
					userId);
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();

			// 内存分页
			if (users.size() != 0) {
				PaginationModel page = new PaginationModel(users, pageSize);
				page.goTo(beginPage);
				users = page.getPaginationData();
			}

			xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
					.getGridPersonalInfo(), users, beginPage, pageSize, count,
					new ArrayList());
		}
		return this.printResponseMes(request, response, mapping, "userlist",
				xmlStr);
	}

	public ActionForward initGetUserListByName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String processdef_id = request.getParameter("processdef_id");
		String taskdef_id = request.getParameter("taskdef_id");
		request.setAttribute("username", username);
		request.setAttribute("processdef_id", processdef_id);
		request.setAttribute("taskdef_id", taskdef_id);

		return mapping.findForward("useralllist");
	}

	public ActionForward getUserListByName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ISecurityService service = ServiceLocator.getSecurityService();
		response.setContentType("text/xml;charset=utf-8");

		// 页面变量处理
		String username = request.getParameter("username");
		String processdef_id = request.getParameter("processdef_id");
		String taskdef_id = request.getParameter("taskdef_id");

		request.setAttribute("processdef_id", processdef_id);
		request.setAttribute("taskdef_id", taskdef_id);

		String gridSign = request.getParameter("gridSign");
		String xmlStr = "";
		if (StringUtils.isNotEmpty(gridSign)) {
			List users = new ArrayList();
			if (StringUtils.isEmpty(username)) {
				// 判断session中是否存在全部用户
				users = (List) (request.getSession()
						.getAttribute(SessionContext.WF_USER_ALL_KEY));
				if (users == null) {
					// 根据用户名称模糊查询用户
					QueryUserByName q = new QueryUserByName();
					User user = new User();
					user.setOPER_TYPE("like");
					user.setUSERNAME(username);
					q.setUSER(user);
					users = service.queryUserByName(q);
					request.getSession().setAttribute(
							SessionContext.WF_USER_ALL_KEY, users);
				}
			} else {
				// 根据用户名称模糊查询用户
				QueryUserByName q = new QueryUserByName();
				User user = new User();
				user.setOPER_TYPE("like");
				user.setUSERNAME(username);
				q.setUSER(user);
				users = service.queryUserByName(q);
			}

			int count = users.size();
			String hqlStr = "";
			String userId = "";
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request, hqlStr,
					userId);
			int beginPage = gridInfo.getBeginPage();
			int pageSize = gridInfo.getPageSize();

			// 内存分页
			if (users.size() != 0) {
				PaginationModel page = new PaginationModel(users, pageSize);
				page.goTo(beginPage);
				users = page.getPaginationData();
			}

			xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo
					.getGridPersonalInfo(), users, beginPage, pageSize, count,
					new ArrayList());
		}
		return this.printResponseMes(request, response, mapping, "useralllist",
				xmlStr);
	}

	/**
	 * 用于初始化用户选择页面
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initUserView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		WFManagerForm theForm = (WFManagerForm) form;
		try {
			long node_id = theForm.getNode_id();
			long process_id = theForm.getProcessdefId();

			request.setAttribute("processdef_id", String.valueOf(process_id));
			request.setAttribute("taskdef_id", String.valueOf(node_id));

		} catch (Exception ex) {
			System.out.println("ex get message" + ex.getMessage());
		}
		return mapping.findForward("initUser");
	}

	/**
	 * 系统更新代理用户
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward updateWFTaskRoles(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String argent_role = "yangj";
			String processdef_id = request.getParameter("processdef_id");
			String taskdef_id = request.getParameter("taskdef_id");
			wfmanagerfacade.updateJbpm(argent_role, Long.parseLong(taskdef_id),
					Long.parseLong(processdef_id));

		} catch (Exception ex) {
			System.out.println("" + ex.getMessage());
		}
		return mapping.findForward("success");

	}

}
