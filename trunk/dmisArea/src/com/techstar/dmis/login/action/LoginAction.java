package com.techstar.dmis.login.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import sun.misc.BASE64Decoder;
import com.techstar.framework.service.security.modelout.ResourceOut;
import com.techstar.framework.service.dto.UserProfile;
import com.techstar.framework.service.security.SecurityContext;
import com.techstar.framework.ui.entity.Menu;
import com.techstar.framework.ui.entity.MenuItem;
import com.techstar.framework.ui.utils.menu.MenuItemXmlHelp;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.dmis.common.SysConstants;
public class LoginAction extends BaseDispatchAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String name = (String)request.getParameter("username");
		//name = getFromBASE64(name);
		request.getSession().setAttribute("username", name);
		
		//设置全局安装程序路径
		SysConstants.setSystemPath(request.getRealPath("/"));
		
		System.out.println("hhhhhhhhhhhhhhhhhhh"+SysConstants.systemPath);
		
		UserProfile userP = (UserProfile) (request.getSession()
				.getAttribute(SecurityContext.SECURITY_AUTHENTICATION_KEY));
		String sessionUser = (String) request.getSession().getAttribute(
				SecurityContext.SECURITY_USERNAME_SESSION_KEY);
		List ress = userP.getMeun();
	    String parentid = this.getpermId(SysConstants.SYSQPPLICATION_CITYCODE, ress);
		Menu menu  = createMenu(parentid,ress);
		MenuItemXmlHelp help = new MenuItemXmlHelp();
		String xml = help.getMenuXml(menu);
		System.out.println(xml);
		request.getSession().setAttribute("headmenu", xml);
		return mapping.findForward("framework");
	}
	
	public  String getFromBASE64(String s) { 
		  if (s == null) return null; 
		  BASE64Decoder decoder = new BASE64Decoder(); 
		  try { 
			  byte[] b = decoder.decodeBuffer(s); 
			  String decodeS = new String(b);
			  decodeS = decodeS.substring(0,decodeS.length()-17);
			  return decodeS; 
		  } catch (Exception e) { 
			  return null; 
		  } 
	} 
	

	
	private List getSubRes(String parentId,List ress){
		ArrayList sublist = new ArrayList();
		try{
			for(int i=0;i<ress.size();i++){
				ResourceOut dto = (ResourceOut)ress.get(i);
				String[] bak = ((String)dto.getDESC()).split(";");
				if(bak!=null&&bak.length>0){
					String typ = bak[0];
					if(bak[0].equals("menu")&&parentId.equals(dto.getPERMPARENTID())){
						MenuItem item = new MenuItem();
						item.setId(dto.getRESOURCEID());
						item.setText(dto.getRESOURCENAME());
						if(bak.length>1)
							item.setHref(bak[1]);
						//ress.remove(i);
						List children = getSubRes(dto.getPERMID(),ress);
						item.setChildren(children);
						sublist.add(item);
					}
				}
				
					
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return sublist;
	}
	
	
   private Menu createMenu(String parentId ,List res){
	   Menu  menu  = new Menu();
	   List items = getSubRes(parentId, res);
	   menu.setChildItems(items);
	   return menu;
   }
   /**
    * 通过业务Id 取到他的权限资源Id
    * @param resourceId
    * @return
    */
   private String getpermId(String resourceId,List ress){
	   
	   for(int i=0;i<ress.size();i++){
			ResourceOut dto = (ResourceOut)ress.get(i);
			if(resourceId.equals(dto.getRESOURCEID()))
				return  dto.getPERMID();
		}
	  return "";
   }
}
