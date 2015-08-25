package com.techstar.dmis.web.action;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.dmis.web.facade.SystemdicFacade;

import com.techstar.dmis.dto.SystemdicDto;;
public class SystemdicAction  extends BaseDispatchAction {
	  private SysUiGridFacade sysUiGridFacade;
	  private SystemdicFacade systemdicfacade;
	  public ActionForward getSystemdic(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			String userId = "user"; //用户ID
            String hqlStr="";
			//取到表格的信息
			GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);
			String typeId = request.getParameter("typeId");
			int count = 0;
			//通过日计划ID来查询方式变更
			
			String hql = "select t from Systemdic t where t.typeid = '"+typeId+"'";
			
			List dtolist = new ArrayList();
			List sumInfo = new ArrayList();
			QueryListObj queryObj = systemdicfacade.listSystemticByHql(hql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
			String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
			System.out.println(xmlStr);
			return this.printResponseMes(request,response,mapping,"",xmlStr);
	  }
	public void setSystemdicfacade(SystemdicFacade systemdicfacade) {
		this.systemdicfacade = systemdicfacade;
	}
	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
}
