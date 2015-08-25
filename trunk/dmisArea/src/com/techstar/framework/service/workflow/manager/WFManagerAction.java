package com.techstar.framework.service.workflow.manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.io.IOUtils;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.service.ServiceLocator;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.ISecurityService;
import com.techstar.framework.service.security.filter.QueryUnit;
import com.techstar.framework.service.security.modelin.Unit;
import com.techstar.framework.service.security.modelout.RoleGroup;
import com.techstar.framework.service.security.modelout.RoleOut;
import com.techstar.framework.service.security.modelout.UnitOut;
import com.techstar.framework.service.workflow.manager.WFManagerFacade;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.utils.tree.NodeXMLHelp;
import com.techstar.framework.ui.utils.tree.TreeActionHelp;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.framework.ui.web.tag.engine.BaseGridObj;
import com.techstar.framework.utils.AppHelper;
import com.techstar.framework.utils.PaginationModel;
import com.techstar.framework.service.workflow.bus.dto.TaskDto;
import com.techstar.framework.service.workflow.bus.dto.JbpmCmsDto;
import com.techstar.framework.service.workflow.bus.dto.NodeDto;
import com.techstar.framework.service.workflow.bus.dto.TaskRoleDto;
import com.techstar.framework.service.workflow.bus.dto.TaskDto;
import com.techstar.framework.service.workflow.bus.dto.ProcessDefinedDto;
import com.techstar.framework.service.workflow.bus.dto.TaskMessageDto;
import com.techstar.framework.service.workflow.bus.dto.ProcessInstanceDto;
import com.techstar.framework.service.workflow.manager.WFManagerHelper;
import com.techstar.framework.ui.web.tag.engine.ApplicationResourcesUtil;
//import com.techstar.treedemo.service.ListTreeService;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;
import org.apache.commons.io.FileUtils;




public class WFManagerAction extends  BaseDispatchAction{
	private WFManagerFacade wfmanagerfacade;
	private SysUiGridFacade sysUiGridFacade;
	
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	public void setWorkflowFacade(WFManagerFacade wfmanagerfacade) {
		this.wfmanagerfacade = wfmanagerfacade;
	}
	public ActionForward initFrame(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("initWFFrame");
	}
	public ActionForward initToolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		StringBuffer xmlData = new StringBuffer();
		xmlData.append("<Toobar>");
		xmlData.append("	<Business>");
		xmlData.append("		<id>commonQuery</id>");
		xmlData.append("		<name>业务名称</name>");
		xmlData.append("	</Business>");
		xmlData.append("	<ReportUrl>http://localhost:8888/framework/</ReportUrl>");
		xmlData.append("	<OperItem Text='操作名称1' ");
		xmlData.append("			  id='operation1' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述1'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称2' ");
		xmlData.append("			  id='operation2' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述2'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称3' ");
		xmlData.append("			  id='operation3' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述3'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("	<OperItem Text='操作名称4' ");
		xmlData.append("			  id='operation4' ");
		xmlData.append("			  href='' ");
		xmlData.append("			  title='功能描述4'");
		xmlData.append("	>");
		xmlData.append("	</OperItem>");
		xmlData.append("</Toobar>");

		request.setAttribute("xmlData", xmlData.toString());
		// TODO 增加业务方法列表
		return mapping.findForward("initWFToolbar");
	}
	
	/**
	 * 初始化Tab页


	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward initTab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("initWFTab");
	}
	/**
	 * 此ACTION用于得到系统中所有正在运行的工作流实例
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward listRunningWF(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		//由业务自行定义的
		String hqlStr = ""; 	//业务HQL
		String userId = "user"; //用户ID

		//取到表格的信息
		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
		
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		if(pageSize<=0){pageSize=20;}
		List runningwf = wfmanagerfacade.getRunningWF();
		List runningwf_page = new ArrayList();
		
		// 内存分页
		if (runningwf.size() != 0) {
			PaginationModel page = new PaginationModel(runningwf, pageSize);
			page.goTo(beginPage);
			runningwf_page = page.getPaginationData();
		}
		
		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), runningwf_page, gridInfo.getBeginPage(), gridInfo.getPageSize(), runningwf.size(), new ArrayList());
		return this.printResponseMes(request,response,mapping,"listRunningWF",xmlStr);
		
	}
	
	/**
	 * 此ACTION用于得到某个运行态工作流对应的所有节点
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getWFNodes(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//WFManagerForm theForm = (WFManagerForm)form;
		   FileUtils futils = new FileUtils(); 
			 
		   
		try{
		
			//String _wfName="UnderFlow";
			
			 List runningwf = wfmanagerfacade.getRunningWF();
			 HSSFWorkbook wb = new HSSFWorkbook();
			 
		
		
	        for (int j=0;j<runningwf.size();j++){
				ProcessDefinedDto dto = (ProcessDefinedDto)runningwf.get(j);
			    HSSFSheet sheet1 = wb.createSheet("workflow");
		        HSSFRow row = sheet1.createRow( (short) 0);
		        row.createCell( (short) 0).setCellValue("wf_name:");
		        row.createCell( (short) 1).setCellValue("node_name:");
		        row.createCell( (short) 2).setCellValue("task_name:");
		        List nodes = wfmanagerfacade.getWFNodes(dto.getProcessDefinedName());
		        List tasknodes = new ArrayList();
		        List tasks = wfmanagerfacade.getWFALLTask(dto.getProcessDefinedName());
		        
		        for (int p=0;p<nodes.size();p++){
		        	NodeDto node = (NodeDto)nodes.get(p);
		        	if (node.getNodeType()==NodeDto.NODE_TASKNODE){
		        		tasknodes.add(node);
		        		//System.out.println(" get task size is"+node.getTasks().size());
		        	}
		        	
		        }
		        
		        row.setRowNum((short) (1));
		        row.createCell( (short) 0).setCellValue(String.valueOf(dto.getProcessDefinedName()));
		      
		        for (int i=0;i<tasknodes.size();i++){
		        	 NodeDto node = (NodeDto)nodes.get(i);
		        	 int m = 2+i;
		        	 row.setRowNum((short) (m));
		        	 HSSFCell cell = row.createCell( (short) (1));
			         cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			         cell.setCellValue(String.valueOf(node.getNode_name()));
		         }
		        
		       
		        
		        for (int q=0;q<tasks.size();q++){
		        	TaskDto task = (TaskDto)tasks.get(q);
		        	 int m = 3+q;
		        	 row.setRowNum((short) (m));
		        	 HSSFCell cell = row.createCell( (short) (2));
			         cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			         cell.setCellValue(String.valueOf(task.getTaskName()));
		         }
			}
		
	       // System.out.println("path+fileName"+path+fileName);
	        FileOutputStream fileOut = new FileOutputStream("d:\\temp\\workflows_Area.xls");
	        wb.write(fileOut);
	        fileOut.close();
			
			
		
			
			
		
		}catch(Exception ex){
			System.out.println("系统得到当前工作流节点发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		
		return mapping.findForward("getWFNodes");
	}
	
	
	
	
	/**
	 * 用于测试
	 *
	 */
	public ActionForward startWF(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String _wfName="ProtectFlow-city";
		boolean isok = wfmanagerfacade.startWF(_wfName);
		return mapping.findForward("startWF");
		
	}
	
	public ActionForward listActorTasks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//String _wfName="UnderFlow";
		String actorId="yangj";
		List tasks = wfmanagerfacade.getTaskByActorId(actorId);
		for (int i=0;i<tasks.size();i++){
			TaskDto taskdto = (TaskDto)tasks.get(i);
			System.out.println("get yangj task is"+taskdto.getTaskName());
		}
		return mapping.findForward("listtask");
		
	}
	
	public ActionForward finishTasks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//String _wfName="UnderFlow";
		String actorId="yangj";
		
		List tasks = wfmanagerfacade.getTaskByActorId(actorId);
		for (int i=0;i<tasks.size();i++){
			TaskDto taskdto = (TaskDto)tasks.get(i);
			wfmanagerfacade.finishTaskById(Long.parseLong(taskdto.getTaskId()));
		}
		
		return mapping.findForward("listtask");
		
	}
	
	public ActionForward getWFTaskRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			long process_id=345;
			long task_id=360;
			List roles = wfmanagerfacade.getTaskRoles(process_id, task_id);
		    System.out.println("int action roles"+roles.size());
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		return mapping.findForward("taskroles");
		
	}
	
	public ActionForward getWFCurrentTaskRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			long process_id=345;
			long task_id=360;
			String[] actors = wfmanagerfacade.getCurrentWFActors(process_id, task_id);
//		   for(int i=0;i<actors.length;i++){
//			System.out.println("int action actors"+i+"="+actors[i]);
//		   }
			
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		return mapping.findForward("taskroles");
		
	}
	
	public ActionForward addWFTaskRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			
			WFManagerForm theForm = (WFManagerForm)form;
			long taskdef_id = theForm.getNode_id();
			
			TaskRoleDto dto = new TaskRoleDto();
			String task_role="yangj";
			dto.setProcess_id(345);
			dto.setTask_id(360);
			dto.setNeccesory(0);
			dto.setAgency_role("0");
			dto.setTask_name("处理申请单");
			dto.setTask_role(task_role);
			wfmanagerfacade.addTaskRoleDto(dto);
			
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		return mapping.findForward("addtaskroles");
		
	}
    /**
     * 用于设置工作流角色和代理
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public ActionForward updateWFTaskRoles(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		   String message="";
		try{
			
			String processdef_id = request.getParameter("processdef_id");
			String taskdef_id = request.getParameter("taskdef_id");
			String argent_role = request.getParameter("argent_role");
			argent_role = argent_role.replaceAll(",", ";");
			
			
			List taskroles = wfmanagerfacade.getTaskRoles(Long.parseLong(processdef_id),Long.parseLong(taskdef_id));
			if(taskroles.size()>0){
				
				TaskRoleDto dto = (TaskRoleDto)taskroles.get(0);
				dto.setAgency_role(argent_role);
				wfmanagerfacade.updateTaskRoleDto(dto);
				message = ApplicationResourcesUtil.getMessage("wf.agency._success");
			}else{
				message = ApplicationResourcesUtil.getMessage("wf.agency.role._false");
			}
			
		}catch(Exception ex){
			   message = ApplicationResourcesUtil.getMessage("wf.agency._false");
			System.out.println(""+ex.getMessage());
		}
		WFManagerHelper helper = WFManagerHelper.getInstance();
		String str = helper.getCloseReturnStr(message);
		request.setAttribute("message", str);
		return mapping.findForward("success");
		
	}
	
	public ActionForward addWFTaskMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		WFManagerForm theForm = (WFManagerForm)form;
		
		String  processdefId=request.getParameter("processdefId");
		String  task_id=request.getParameter("task_id");
		String  task_type=request.getParameter("tasktype");
		
		int message_id=0;
		String  message_type=request.getParameter("message_type");
		String receive=request.getParameter("receive");
		String content=request.getParameter("content");
		WFManagerHelper helper = WFManagerHelper.getInstance();
		String message ="";
		try{
			
			String message_bus_name=wfmanagerfacade.getDtoNameByWfId(processdefId);
			
			java.util.Collection a = wfmanagerfacade.getTaskMessages(Long
					.parseLong(processdefId), Long.parseLong(task_id), Integer
					.parseInt(task_type));
			
			//System.out.println("a size is"+a.size());
			
		 if(a==null||a.size()==0){
			wfmanagerfacade.setMessage(message_id,
					Long.parseLong(processdefId), Long.parseLong(task_id),
					Integer.parseInt(message_type), content, message_bus_name,
					receive, Integer.parseInt(task_type));
			}else{
				
				wfmanagerfacade.updateMessage(Long.parseLong(processdefId),
						Long.parseLong(task_id),
						Integer.parseInt(message_type), content,
						message_bus_name, receive, Integer.parseInt(task_type));
			}
			
		    message = ApplicationResourcesUtil.getMessage("wf.view.message_success");
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
			message = ApplicationResourcesUtil.getMessage("wf.view.message_false");
		}
		String str = helper.getCloseReturnStr(message);
		request.setAttribute("message", str);
		return mapping.findForward("success");
		
	}
	
	public ActionForward getWFTaskMessages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			long process_id=345;
			long task_id=360;
			List messages = wfmanagerfacade.getTaskMessages(process_id, task_id);
		    System.out.println("int action messages"+messages.size());
		}catch(Exception ex){
			System.out.println(""+ex.getMessage());
		}
		return mapping.findForward("messages");
		
	}
	
    
	/**
	 * 用于显示工作流frame
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getWFView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			WFManagerForm theForm = (WFManagerForm)form;
			
			long wf_id=theForm.getProcessIdByPara();
			request.setAttribute("wf_id", String.valueOf(wf_id));
		
			
		}catch(Exception ex){
			System.out.println("******"+ex.getMessage());
		}
		return mapping.findForward("wfview");
		
	}
	
	
	
	/**
	 * 用于得到当前工作流显示
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getWFView_left(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			
			 
			 WFManagerForm theForm = (WFManagerForm)form;
			 long wf_id=theForm.getProcessdefId();
		     String wf_name = wfmanagerfacade.getWFNameByProcessId(wf_id);
			 List nodes = wfmanagerfacade.getWFNodes(wf_id);
			 DhtmlxTreeNode root =  new DhtmlxTreeNode();
			 root.setId("zsy");
			 
			 DhtmlxTreeNode nodewf =  new DhtmlxTreeNode();
			 nodewf.setId("1");
			 nodewf.setText(wf_name);
			 nodewf.setIsChecked("1");
			 nodewf.setParentId("zsy");
			 nodewf.setIsOpen("1");
			 nodewf.setUserData(String.valueOf(NodeDto.WF_SELF)+"#processdefId="+wf_id);
			 
			
			 WFManagerHelper helper = WFManagerHelper.getInstance();
			 List views = helper.getWFViewNodes(nodewf,root, nodes, String.valueOf(wf_id));
			
			 NodeXMLHelp help = new NodeXMLHelp();
			 help.setNodes(views);
			 String xml = help.getAllXmlByParentNode(root);
			 request.setAttribute("wfviewleft", xml);
			
			
		}catch(Exception ex){
			System.out.println("******"+ex.getMessage());
		}
		return mapping.findForward("wfviewleft");
		
	}
	
	/**
	 * 用于得到工作流图形
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getWFView_right(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 WFManagerForm theForm = (WFManagerForm)form;
		 
		 long wf_id= theForm.getProcessdefId();
		 String svg_p = wfmanagerfacade.getWfGraphic(wf_id);
		
		 response.setContentType("image/svg+xml;charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.print(svg_p);
		return mapping.findForward("wfviewright");
	}

	
	
	public ActionForward getWFView_Task(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String xmlStr="";
		  
		try{
			
			 WFManagerForm theForm = (WFManagerForm)form;
			 int isinit = theForm.getIsinit();
			 long node_id = theForm.getNode_id();
			 long wf_id= theForm.getProcessdefId();
			 long type = Long.parseLong(theForm.getType());
			 
			 
			
		    if(type==NodeDto.NODE_TASKNODE||type==NodeDto.NODE_STARTSTATE||type==NodeDto.NODE_ENDSTATE){
			   if (isinit==0){
						String str="/wfmanager.do?method=getWFView_Task"; 
						request.setAttribute("para", str+"&node_id="+node_id+"&processdefId="+wf_id+"&isinit=1&type="+theForm.getType()); 
					     
						String role_link = "/resourcetree.do?method=initRoleTree&node_id="+node_id+"&processdefId="+wf_id;
						String agent_link = "/resourcetree.do?method=initOrgTree&node_id="+node_id+"&processdefId="+wf_id;
						
						request.setAttribute("role_link",role_link);
						request.setAttribute("agent_link", agent_link);
						
						
						return mapping.findForward("getWFView_Task");
				}
				 String hqlStr="";
				 String userId="user";
			     List nodes = wfmanagerfacade.getWFNodes(wf_id);
			     List l = new ArrayList();
			     
			     for (int i=0;i<nodes.size();i++){
			    	  NodeDto nodedto = (NodeDto)nodes.get(i);
			    	if (nodedto.getNodeId()==node_id){
			    	 l = nodedto.getTasks();
			    	 GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			         xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), l, gridInfo.getBeginPage(), gridInfo.getPageSize(), 0, new ArrayList());
			    	return this.printResponseMes(request,response,mapping,"getWFView_Task",xmlStr);		
			    }
			  
			 }
		    }  
			if(type==NodeDto.NODE_STATE){
//				String task_type = request.getParameter("tasktype");
//				String task_id="";
//			
//				if(task_type==null){
//					task_type = "0";
//					task_id = String.valueOf(node_id);
//				}
//				else if(task_type.equalsIgnoreCase("1")){
//                	task_id = request.getParameter("node_id");
//				}
//				
//                java.util.Collection a = wfmanagerfacade.getTaskMessages(wf_id, Long.parseLong(task_id), Integer
//						.parseInt(task_type));
//                if (a!=null&&a.size()>0){
//                	TaskMessageDto dto = (TaskMessageDto)a.toArray()[0];
//                	request.setAttribute("cont", dto.getContent());
//                	request.setAttribute("rece", dto.getReceive());
//                }
				  
//				 request.setAttribute("node_id", String.valueOf("node_id"));
//				 request.setAttribute("wf_id", String.valueOf("wf_id"));
				
				
				
//				String tasktype = request.getParameter("tasktype");
//				String node_id  = request.getParameter("node_id");
//				String processdefId = request.getParameter("processdefId");
				
				String res= request.getContextPath()+"/wfmanager.do?method=initNodeMessage&processdefId="
				+wf_id+"&node_id="+node_id+"&tasktype=0";
				 
				 //response.sendRedirect(arg0)
				//System.out.println("res=="+res);
				response.sendRedirect(res);
		     }
			
			if (type==NodeDto.WF_SELF){
				request.setAttribute("wf_id", String.valueOf(wf_id));
				String res= request.getContextPath()+"/wfmanager.do?method=getWFView_right&processdefId="+wf_id;
				//System.out.println("res is"+res);
				response.sendRedirect(res);
			}
		  
		}catch(Exception ex){
			System.out.println("ex get message"+ex.getMessage());
			ex.printStackTrace();
		}
		  
		   return mapping.findForward("getWFView_Detail");
	}
	
	/**
	 * 系统通过工作流定义得到工作流实例列表
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getInstancesByProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WFManagerForm theForm = (WFManagerForm)form;
		try{
			int isinit = theForm.getIsinit();
			long wf_id =  theForm.getProcessdefId();
			
			 if (isinit==0){
					String str="/wfmanager.do?method=getInstancesByProcess&processdefId="+wf_id; 
					request.setAttribute("para", str+"&isinit=1"); 
					return mapping.findForward("getProcessInstance");
			}
			
			
			String hqlStr="";
			String userId="user";
            List instances = wfmanagerfacade.getProcessInstancesByProcess(wf_id);
            List instances_pages = new ArrayList();
            //System.out.println("instances="+instances.size());
            GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
            int beginPage = gridInfo.getBeginPage();
    		int pageSize = gridInfo.getPageSize();
    		if(pageSize<=0){pageSize=20;}
    		
    		if (instances.size() != 0) {
				PaginationModel page = new PaginationModel(instances, pageSize);
				page.goTo(beginPage);
				instances_pages = page.getPaginationData();
			}
    		
            String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), instances_pages, gridInfo.getBeginPage(), gridInfo.getPageSize(), instances.size(), new ArrayList());
            request.setAttribute("processdefId", String.valueOf(wf_id));
            return this.printResponseMes(request,response,mapping,"getProcessInstance",xmlStr);
			
			
		}catch(Exception ex){
			System.out.println("getprocessInstance 发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		
		return mapping.findForward("getProcessInstance");
	}
	/**
	 * 用于得到工作流实例的log
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getInstancesByProcessLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WFManagerForm theForm = (WFManagerForm)form;
		try{
			long id =theForm.getProcessInstanceId();
			List logs = new ArrayList();
			
           if(id!=0){
            logs = wfmanagerfacade.getLogsByProcessId(id);
            request.setAttribute("code", "\u7f16\u53f7");
            request.setAttribute("audit", "\u5de5\u4f5c\u6d41\u65e5\u5fd7");
			request.setAttribute("logs", logs);
            }
            
		}catch(Exception ex){
			System.out.println("getprocessInstance 发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		
		return mapping.findForward("getProcessInstancesByProcessLog");
	}
	
	/**
	 * 工作流实例查看初始化方法
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getProcessInstancesView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		WFManagerForm theForm = (WFManagerForm)form;
		try{
			String str = theForm.getPrimaryInfo();
			String[] strs = StringUtils.split(str, "^");
			long wf_id=Long.parseLong(strs[strs.length-1]);
            request.setAttribute("wf_id", String.valueOf(wf_id));
		}catch(Exception ex){
			System.out.println("getprocessInstance 发生异常"+ex.getMessage());
			ex.printStackTrace();
		}
		
		return mapping.findForward("ProcessInstancesview");
	}
	
	/**
	 * 输入CMS信息
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward importcmsinfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		WFManagerForm theForm = (WFManagerForm)form;
		org.apache.struts.upload.FormFile cmsfile = theForm.getWf_cmsfile();
		
		if (cmsfile!=null&&theForm.getSubmit().length()>0){
			String message="";
			WFManagerHelper helper = WFManagerHelper.getInstance();
		try{
			String file_content = new String(cmsfile.getFileData(),"UTF-8");
			file_content= file_content.substring(1, file_content.length());
		
			
			List workflows = helper.getWorkFlowBeans(file_content);
			wfmanagerfacade.setWFDto(workflows);
			message = ApplicationResourcesUtil.getMessage("wf.view.import_success");
			
			
		}catch(Exception ex){
			System.out.println("输入工作流发生异常"+ex.getMessage());
			ex.printStackTrace();
			message = ApplicationResourcesUtil.getMessage("wf.view.import_false");
		}
		    String str = helper.getCloseReturnStr(message);
		    request.setAttribute("message", str);
//		    response.setContentType("image/svg+xml");
//			response.setCharacterEncoding("utf-8");
//			PrintWriter out = response.getWriter(); 
//			out.print(str);
		    
		    return mapping.findForward("success");
		}
		  return mapping.findForward("importcmsinfo");
	}
	
	/**
	 * 用于得到当前工作流当前任务
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getCurrentWFTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			
			String hqlStr="";
			String userId="userId";
			WFManagerForm theForm = (WFManagerForm)form;
			long processId = theForm.getProcessInstanceId();
			
			List tasks  = new ArrayList();
			if(processId!=0){
				request.setAttribute("processInstanceId", String.valueOf(processId));
				tasks = wfmanagerfacade.getTasksByProcessId(processId);
			}
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
            String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), tasks, gridInfo.getBeginPage(), gridInfo.getPageSize(), 0, new ArrayList());
            return this.printResponseMes(request,response,mapping,"currenttask",xmlStr);
		}catch(Exception ex){
			System.out.println("******"+ex.getMessage());
		}
		return mapping.findForward("currenttask");
		
	}
	
	/**
	 * 用于得到当前任务的svg图形
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward getTaskView_right(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 WFManagerForm theForm = (WFManagerForm)form;
		 
		long task_instance_id = theForm.getTaskinstanceId();
		long process_id = theForm.getProcessInstanceId();
		long wf_id = theForm.getProcessdefId();
		
		String svg_p ="";
		
		if(task_instance_id!=0){
		  svg_p = wfmanagerfacade.getTaskSvg(task_instance_id);
		}
		

		if (process_id!=0&&task_instance_id==0){
			//System.out.println("######@@@@");
			svg_p = wfmanagerfacade.getWfGraphicByProcess(process_id);
			//System.out.println("svg_p==="+svg_p);
			
		}
		
		if (wf_id!=0&&task_instance_id==0){
			svg_p = wfmanagerfacade.getWfGraphic(wf_id);
		}
		
		response.setContentType("image/svg+xml;charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.print(svg_p);
		return mapping.findForward("wfviewright");
	}
	
	/**
	 * 系统用于结束工作流
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward endProcess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 WFManagerForm theForm = (WFManagerForm)form;
		 WFManagerHelper helper = WFManagerHelper.getInstance();
		long process_id = theForm.getProcessInstanceId();
		String message="";
		String str="";
		try{
		wfmanagerfacade.endProcess(process_id);
		message=ApplicationResourcesUtil.getMessage("wf.role._success");
		}catch(Exception ex){
			message=ApplicationResourcesUtil.getMessage("wf.role._false");
		}
		str = helper.getCloseReturnStr(message);
		request.setAttribute("message", str);
		return mapping.findForward("success");
	}
	
	
	public ActionForward initNodeMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 WFManagerForm theForm = (WFManagerForm)form;
		 WFManagerHelper helper = WFManagerHelper.getInstance();
		long process_id = theForm.getProcessInstanceId();
		String message="";
		String str="";
		try{
			String tasktype = request.getParameter("tasktype");
			String node_id  = request.getParameter("node_id");
			String processdefId = request.getParameter("processdefId");
			
			String receiver = request.getParameter("receiver");
			
			
			request.setAttribute("tasktype", tasktype);
			request.setAttribute("node_id", node_id);
			request.setAttribute("processdefId", processdefId);
			request.setAttribute("receiver", receiver);
		
		}catch(Exception ex){
			System.out.println("system get exception is"+ex.getMessage());
			
		}
		
		return mapping.findForward("noteview");
	}
	
	
	
	
	public ActionForward getWFView_Message(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		try{
			String node_id = request.getParameter("node_id");
			String task_type = request.getParameter("tasktype");
			String wf_id     = request.getParameter("processdefId");
			String receiver  =request.getParameter("receiver");
			String task_id="";
			task_id = node_id;
            java.util.Collection a = wfmanagerfacade.getTaskMessages(Long.parseLong(wf_id), Long.parseLong(task_id), Integer
					.parseInt(task_type));
            
            if (a!=null&&a.size()>0){
            	TaskMessageDto dto = (TaskMessageDto)a.toArray()[0];
            	request.setAttribute("cont", dto.getContent());
            	
            	System.out.println("receiver=="+receiver);
            	if (receiver==null||StringUtils.isEmpty(receiver)||receiver.equalsIgnoreCase("null")){
            		//System.out.println("$$$$$$$$$$$$$$$$%%%%%%");
            		request.setAttribute("rece", dto.getReceive());
            	}else{
            		request.setAttribute("rece", receiver);
            		//System.out.println("%%%%%%%%%%%%%%%%$$$$$$");
            	}
            	
            	
//            	if(receiver==null){
//            	   System.out.println("init *******"+dto.getReceive()); 
//            	}else{
//            	   System.out.println("second ******"+receiver);
//            	   request.setAttribute("rece", receiver);
//            	}
            	  
            	  
            	  
            }
		}catch(Exception ex){
			System.out.println("get wfview message exception "+ex.getMessage());
		}
		 return mapping.findForward("getWFView_Message");	
		
	}
	
	
	
	
	
	

	
	

}
