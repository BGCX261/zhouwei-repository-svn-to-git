package com.techstar.dmis.web.action;

import java.util.List;
import java.util.Map;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.techstar.framework.utils.SequenceCreator;

import org.apache.struts.upload.FormFile;
import com.techstar.framework.web.action.BaseDispatchAction;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.ui.entity.GridInfoObj;
import com.techstar.framework.ui.web.facade.SysUiGridFacade;
import com.techstar.dmis.web.facade.DdClassondutylogFacade;
import com.techstar.dmis.web.facade.DdSwitchseqbillFacade;

import com.techstar.dmis.web.facade.DdSasusprecordFacade;
import com.techstar.dmis.web.form.DdSasusprecordForm;
import com.techstar.dmis.common.DispatchConstants;
import com.techstar.dmis.dto.DdAccidentbriefDto;
import com.techstar.dmis.dto.DdClassondutylogDto;
import com.techstar.dmis.dto.DdHloadrecordDto;
import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
import com.techstar.dmis.dto.DdSasusprecordDto;
import com.techstar.dmis.dto.DdSwitchseqbillDto;
//please add your business methods start
	// to do it
//add your business method end
import com.techstar.dmis.helper.BusinessDetailHelper;
import com.techstar.dmis.helper.dto.BusinessDetailDto;


/**
 * @author
 * @date
 */
public class DdSasusprecordAction
              extends BaseDispatchAction {
	private DdSasusprecordFacade ddSasusprecordFacade;
    private SysUiGridFacade sysUiGridFacade;
    private DdClassondutylogFacade ddClassdutylogfacade;
    private DdSwitchseqbillFacade ddSwitchseqbillFacade;
	public DdSasusprecordAction() {
	}
	//初始化默认值
	public void iniDefaultValue(HttpServletRequest request,DdSasusprecordDto dto){

		long nCurrentTime = System.currentTimeMillis();
			java.sql.Timestamp fCurTime = new java.sql.Timestamp(
					nCurrentTime);
			BusinessDetailHelper ss = new BusinessDetailHelper();
			BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
			dto.setSys_filldept(defaultdto.getUserDeptName());
			dto.setSys_filltime(fCurTime);
			dto.setSys_dataowner(defaultdto.getDataOwnerName());
			dto.setSys_fille(defaultdto.getUserName());
	}

	public void SetLogno(DdSasusprecordDto dto){
//		增加班志编号
        DdClassondutylogDto ddc = this.ddClassdutylogfacade.getLogNo();
        dto.setZddsasusprecord3(ddc);
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
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//  查询列表
		List list = ddSasusprecordFacade.listDdSasusprecord();
		request.getSession().setAttribute("DdSasusprecordList", list);

		// 记录操作日志
		//saveLog("DdSasusprecorder", "查询列表");
		return mapping.findForward("list");
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
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdSasusprecordForm ddSasusprecordForm = (DdSasusprecordForm) form;
		DdSasusprecordDto dto = ddSasusprecordForm.getDdSasusprecordDto();

		//附件处理
				//如果主键为空，则生成主键

		if( StringUtils.isEmpty(dto.getFid())){
             dto.setFid( new SequenceCreator().getUID() ); //生成内部序列号
         //缺省值处理
         iniDefaultValue(request,dto);
         SetLogno(dto);

        }
			ddSasusprecordFacade.addDdSasusprecord(dto);


		//saveLog("DdSasusprecorder", "增加记录");
		return mapping.findForward("data");
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
	public ActionForward initModify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DdSasusprecordForm ddSasusprecordForm = (DdSasusprecordForm) form;
		String fid= request.getParameter("fid");
		if (StringUtils.isNotEmpty(fid)) {
			DdSasusprecordDto dto = ddSasusprecordFacade.getDdSasusprecordById(fid);
			ddSasusprecordForm.setDdSasusprecordDto(dto);
		}

		//saveLog("DdSasusprecorder", "初始化记录操作");
		return mapping.findForward("data");
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
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String fidStr   = request.getParameter("fid");
		String versionStr    = request.getParameter("version");
		String[] primArra    = fidStr.split("\\^");
		String[] versionArra = versionStr.split("\\^");
		for(int i=0; i<primArra.length; i++){
			String fid = primArra[i];
			int version     = Integer.parseInt(versionArra[i]);
			if (StringUtils.isNotEmpty(fid)) {
				List list = ddSasusprecordFacade.deleteDdSasusprecordobj(fid,version);
				request.getSession().setAttribute("DdSasusprecordList", list);
			}
		}

		//saveLog("DdSasusprecorder", "删除记录操作");
		return this.printResponseMes(request,response,mapping,"null","删除成功");
	}

	public void setDdSasusprecordFacade(DdSasusprecordFacade ddSasusprecordFacade) {
		this.ddSasusprecordFacade = ddSasusprecordFacade;
	}






	//noEditGrid editGrid tab toolbar detail


			//初始化表格
	  public ActionForward standGridQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//由业务自行定义的
		String hqlStr = ""; 	//业务HQL
		String userId = "user"; //用户ID

		//取到表格的信息

		GridInfoObj gridInfo = sysUiGridFacade.getGridInfo(request,hqlStr,userId);

		String hqlSql = gridInfo.getHqlSql();
		int beginPage = gridInfo.getBeginPage();
		int pageSize = gridInfo.getPageSize();
		String sumSql = gridInfo.getSumSql();
		Map params = gridInfo.getGridPersonalInfo();

		/*
		List dtolist = new ArrayList();
		DdSasusprecordFacadeDto ddSasusprecordDto = new DdSasusprecordDto();
					//ddSasusprecordDto.setCustom_id("custom_id");
					//ddSasusprecordDto.setCustom_name("Custom_name");
		for(int i=0;i<50;i++){
			dtolist.add(ddSasusprecordDto);
		}
		int count = dtolist.size();
		List sumInfo = new ArrayList();
		*/

		/**
		 *  表格控件基础对象
		 */
//		BaseGridObj gridObj = new BaseGridObj();
//		gridObj.setId("mygrid");
//		gridObj.setPageId("page");
//		gridObj.setDivHeight("400");
//		gridObj.setBusName("DdSasusprecordDto");
//		gridObj.setSubName("general");
//		gridObj.setPageItems("4");
//		gridObj.setListType("3");
//		gridObj.setListKind("101");
//		gridObj.setFilterMode("2");
//		gridObj.setEntityName("DdSasusprecord");
//		gridObj.setIsFilterRow("1");
//		gridObj.setIsTotalRow("1");
//		gridObj.setColumnMove("custom_id,custom_name");
//		gridObj.setIsTotal("total");
//		gridObj.setListBox("cre_date#7^,custom_id#1^type=zzmm@@@parentId=,custom_name#2^src=SQDW,sale_mode#2^src=SQDW");
//		gridObj.setQueryPath("/ui.do?method=query");
//		gridObj.setIsDisplaySet("1");
//		gridObj.setIsQuerySet("1");
//		gridObj.setIsOutputSet("1");
//		gridObj.setIsStatSet("1");
//		gridObj.setIsPageSet("1");
//		request.setAttribute("gridObj",gridObj);

		int count = 0;
		List dtolist = new ArrayList();
		List sumInfo = new ArrayList();
		if(!StringUtils.isEmpty(hqlSql)){
			QueryListObj queryObj = ddSasusprecordFacade.getDdSasusprecordByHql(hqlSql, beginPage, pageSize, sumSql);
			dtolist = queryObj.getElemList();
			count   = queryObj.getCount();
			sumInfo = queryObj.getPropertySum();
		}

		String xmlStr = sysUiGridFacade.parseParamToGridStr(request, gridInfo.getGridPersonalInfo(), dtolist, gridInfo.getBeginPage(), gridInfo.getPageSize(), count, sumInfo);
		return this.printResponseMes(request,response,mapping,"ddSasusprecordgrid",xmlStr);
	}











		   		 //初始化toolbar
	     public ActionForward ddSasusprecordtoolbar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			String method =  "<Toolbar>   <Business>      <id>DdSasusprecord</id>      <name>自投停用记录</name>   </Business>   <ReportUrl>/report.do</ReportUrl>   <OperItem Text='拟定操作票' id='DD_switchseqbilleditor4' href='ddSwitchbill' title=''></OperItem></Toolbar>";

		    request.setAttribute("xmlData",method);
		    return mapping.findForward("ddSasusprecordtoolbar");
	    }









			    //初始化tab页
			public ActionForward ddSasusprecordtab(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddSasusprecordtab");
	     }






		public ActionForward ddSasusprecordframe(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("ddSasusprecordframe");
	}













  	//处理DETAIL页面

	    public ActionForward initDetail(ActionMapping mapping, ActionForm form,
		 HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdSasusprecordForm ddSasusprecordForm = (DdSasusprecordForm) form;
		String mainId = (String) request.getParameter("mainId");
		String isCopy = (String) request.getParameter("isCopy");
		DdSasusprecordDto ddSasusprecordDto = null;
		if (StringUtils.isNotEmpty(isCopy) && isCopy.equalsIgnoreCase("true")) {//复制
			if (StringUtils.isNotEmpty(mainId)) {
				ddSasusprecordDto = ddSasusprecordFacade.getDdSasusprecordById(mainId);
				ddSasusprecordDto.setVersion(0);
				ddSasusprecordDto.setFid(null);
			}
		} else {
			if (StringUtils.isNotEmpty(mainId)) {// 修改
				ddSasusprecordDto = ddSasusprecordFacade.getDdSasusprecordById(mainId);
			} else {// 新增
				ddSasusprecordDto = new DdSasusprecordDto();
//				缺省值处理
		         iniDefaultValue(request,ddSasusprecordDto);
		         SetLogno(ddSasusprecordDto);
			}
		}
		ddSasusprecordForm.setDdSasusprecordDto(ddSasusprecordDto);
		   return mapping.findForward("ddSasusprecorddetail");
		   }

	  public ActionForward saveDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 DdSasusprecordForm  ddSasusprecordForm = ( DdSasusprecordForm) form;
		 DdSasusprecordDto  ddSasusprecordDto = ddSasusprecordForm.getDdSasusprecordDto();
		 //设备的先不做
		 ddSasusprecordDto.setZddsasusprecord2(null);
		ddSasusprecordFacade.addDdSasusprecord(ddSasusprecordDto);
		ddSasusprecordDto = ddSasusprecordFacade.getDdSasusprecordById(ddSasusprecordDto.getFid());
		ddSasusprecordForm.setDdSasusprecordDto(ddSasusprecordDto);
		saveMessages(request, "message.save.success", new String[] { "自投停用记录Dto" });
		return mapping.findForward("ddSasusprecorddetail");
	}










  	//处理DETAIL页面
			public ActionForward initDetail1(ActionMapping mapping, ActionForm form,

	     HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		    return mapping.findForward("ddSasusprecorddetail1");
	}
	     public ActionForward saveDetail1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		 return mapping.findForward("ddSasusprecorddetail1");
	}




	public void setSysUiGridFacade(SysUiGridFacade sysUiGridFacade) {
		this.sysUiGridFacade = sysUiGridFacade;
	}
	public void setDdClassdutylogfacade(DdClassondutylogFacade ddClassdutylogfacade) {
		this.ddClassdutylogfacade = ddClassdutylogfacade;
	}




  /**
    * @business method list
	 	* @从SCADA获得自投数据
	 	* @拟定操作票
	  */
	//please add your business methods start
	// to do it
    //add your business method end
	public ActionForward ddSwitchbill(ActionMapping mapping, ActionForm form,

		     HttpServletRequest request, HttpServletResponse response)
				throws Exception {

		//
		request.setCharacterEncoding("utf-8");
		String fidStr = request.getParameter("fid");
		String[] primArra = fidStr.split("\\^");
		for (int i = 0; i < primArra.length; i++) {
			String fid = primArra[i];
			if (StringUtils.isNotEmpty(fid)) {
				DdSasusprecordDto ddSasusprecordDto = ddSasusprecordFacade
						.getDdSasusprecordById(fid);
				DdSwitchseqbillDto ddSwitchseqbillDto = new DdSwitchseqbillDto();

				BusinessDetailHelper ss = new BusinessDetailHelper();
				BusinessDetailDto defaultdto = ss.getBusDetailInfo(request);
				ddSwitchseqbillDto
						.setSys_filldept(defaultdto.getUserDeptName());
				ddSwitchseqbillDto.setSys_filltime(defaultdto.getCurrentTime());
				ddSwitchseqbillDto.setSys_dataowner(defaultdto
						.getDataOwnerName());
				ddSwitchseqbillDto.setSys_fille(defaultdto.getUserName());
				// 操作日期
				ddSwitchseqbillDto.setFdate(defaultdto.getCurrentDate());

				// 默认状态

				ddSwitchseqbillDto
						.setFstatus(DispatchConstants.ddSwitchSeqbill_NEW);
				// 执行编号
				ddSwitchseqbillDto.setFmanualno(ddSwitchseqbillFacade
						.getMaxfmanualno());
				// 操作任务
				ddSwitchseqbillDto.setFmission(ddSasusprecordDto
						.getFstationname()+"   "+ddSasusprecordDto.getFsuspreason());
				//
				ddSwitchseqbillDto
						.setFbillsource(DispatchConstants.ddAccidentbrief_Switchseqbill_billsource);
				ddSwitchseqbillDto.setFsrcbillno(ddSasusprecordDto
						.getFid());

				ddSwitchseqbillFacade.addDdSwitchseqbill(ddSwitchseqbillDto);

				request.getSession().setAttribute("ddadddid",
						ddSwitchseqbillDto.getFcomputerno());

				return new ActionForward(
						"/ddSwitchseqbill.do?method=ddSwitchseqbillframe&ddadddid="
								+ ddSwitchseqbillDto.getFcomputerno());
			}
		}
		return this.printResponseMes(request, response, mapping, "null",
				"拟定操作票成功");

	}

public void setDdSwitchseqbillFacade(DdSwitchseqbillFacade ddSwitchseqbillFacade) {
	this.ddSwitchseqbillFacade = ddSwitchseqbillFacade;
}


}
