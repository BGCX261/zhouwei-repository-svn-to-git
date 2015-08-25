package com.techstar.treedemo.web.action;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.techstar.framework.ui.entity.DhtmlxTreeNode;
import com.techstar.framework.ui.utils.tree.*;
import com.techstar.framework.ui.service.IDhtmlxTreeService;
import com.techstar.framework.web.action.BaseDispatchAction;


public class Tree1Action extends BaseDispatchAction{
	private IDhtmlxTreeService service ;
	public void setService(IDhtmlxTreeService service){
		this.service = service;
	}
	public ActionForward getTreeNodes(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		try{
			response.setContentType("text/xml;charset=utf-8");
			/*String id  = request.getParameter("id");
			String text = request.getParameter("text");
			String info  =  request.getParameter("info");
			
			
			System.out.println(info);
			//String tranproduce = new String(produce.getBytes("ISO-8859-1"),"GBK");
			
			if(info!=null&&!info.equals(""))//分割userdate
			{
				String[] infos =  info.split(";;;");
				for(int i=0;i<infos.length;i++)
				{
					if(infos[i]!=null&&!infos[i].equals(""))
					{
						switch (i)
						{
							case 0:
								node.setTreeName(infos[i]);
								break;
							case 1:
								node.setNodeDisName(infos[i]);
								break;
							case 2:
								node.setUserData(infos[i]);
								break;
						}
					}
				}
			}
			node.setId(id);
			node.setText(text);*/
			DhtmlxTreeNode node = TreeActionHelp.getTreeNodeByRequest(request);
			//ITreeFacade treeFacade= (ITreeFacade)treeFacades.get(node.getTreeName());
			HashMap parammap = new HashMap();
			parammap.put("resourcesql", "and res_parent_id!='op'");
			long sta = System.currentTimeMillis();
			String xml = service.getTreexmlByParentNode(node,null);
			System.out.println("all::::::::"+(System.currentTimeMillis()-sta));
			System.out.println(xml);
			response.getWriter().print(xml);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	
}


