package com.techstar.dmis.common;
/**
 * 自动化专业使用常量
 * @author sbt
 *
 */
public class ZdhConstants {    
	//public static String ZDH_SRAPPLICATION_DRAFT="草稿";
	public static String ZDH_DRAFT="草稿";
	public static String ZDH_CONFIRM="批准";
	public static String ZDH_APPROVE="审批";
	
	public static String ZDH_CHECK="检修中";
	public static String ZDH_CHECKED="已检修";
	public static String ZDH_RESUMED="已恢复";
	public static String ZDH_PIGEONHOLED="已归档";
	
	public static String ZDH_DISPOSE="处理中";
	public static String ZDH_EXECUTED="已执行";
	public static String ZDH_MACHINEWORK = "缺陷";
	public static String ZDH_MACHINEWORKFIN = "已完成";
	
	//流程状态[系统图修改]
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_NEW 		= "1";		//新建
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_SIGN 		= "2";		//调度室领导签字
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_ASSIGN 	= "3";		//运维中心任务分配
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_COURSIGN 	= "4";		//图形和数据会签处理
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_APPROVE 	= "5";		//调度审核 
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_EXEC 		= "6";		//盖执行章
	public static String ZdhCharalterrecord_WORKFLOW_CITY_STATUS_OVER 		= "-1";		//结束
	
	//系统图修改
	public static String ZDHCharalterrecord_WORKFLOW_CITY_PROCESSDIFINITION = "ZDH_Systemchartmodify_city";	
	public static String ZDHCharalterrecord_WORKFLOW_CITY_APPROVE_TRANSIT_NO = "审核不通过";
	public static String ZDHCharalterrecord_WORKFLOW_CITY_APPROVE_TRANSIT_YES = "送同步";
	
	/****************************工作票***************************************************/
    //业务状态
	public static String ZdhWorkbill_WORKFLOW_CITY_PROCESSDIFINITION = "zdh_workbill_city";	
	public static String ZdhWorkbill_WORKFLOW_CITY_APPROVE_TRANSIT_NO = "未通过";
	public static String ZdhWorkbill_WORKFLOW_CITY_APPROVE_TRANSIT_YES = "通过";
	public static String ZdhWorkbill_WORKFLOW_CITY_PERMIT_TRANSIT_YES = "通过";
	public static String ZdhWorkbill_WORKFLOW_CITY_PERMIT_TRANSIT_NO = "未通过";
	public static String ZdhWorkbill_WORKFLOW_CITY_PERMIT_TRANSIT_SENDOVER = "送结束";
	
	public static String ZdhWorkbill_BUSINESS_CITY_NEW="草稿";
	public static String ZdhWorkbill_BUSINESS_CITY_APPROVED = "已审核";
	public static String ZdhWorkbill_BUSINESS_CITY_APPROVING = "审核中";
	public static String ZdhWorkbill_BUSINESS_CITY_KEEPONED = "已归档";	
	
    //流程状态
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_NEW = "1";		//新建
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_YWZRINK = "2";	//运维中心主任签发
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_XKRINK = "3";		//许可人签字
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_GZFZRINK = "4";	//工作负责人签字(归档)
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_MODIFY = "5";		//修改
	public static String ZdhWorkbill_WORKFLOW_CITY_STATUS_OVER = "-1";		//结束
    //工作流流转
	
	/*************************停复役********************************************************/
	public static String ZdhSrappl_BUSINESS_WORKSOURCE="停复役";
	
	public static String ZdhSrappl_WORKFLOW_CITY_PROCESSDIFINITION = "ZdhSrapplication_city";	
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGSTmp = "变电公司";
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_BDGS = "GC,SYY,BD,DL,SD";
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_QDTmp = "区调";
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_QD = "CP,CY,CQ,DY,FS,FT,HD,HR,MTG,MY,PG,SJS,SY,TZ,YQ,YZ";
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXCTmp = "自动化运行处";
	public static String ZdhSrappl_WORKFLOW_CITY_IsDpt_ZDHYXC = "DD";
	
	public static String ZdhSrappl_WORKFLOW_CITY_IsWorkType_CHECK = "检修";
	public static String ZdhSrappl_WORKFLOW_CITY_IsWorkType_REBACK = "退运";
	public static String ZdhSrappl_WORKFLOW_CITY_IsArea_CITY = "市调";
	public static String ZdhSrappl_WORKFLOW_CITY_IsArea_AREA = "区调";
	public static String ZdhSrappl_WORKFLOW_CITY_IsArea_SENTAREA = "下发区调";
	
	public static String ZdhSrappl_BUSINESS_CITY_NEW = "草稿";
	public static String ZdhSrappl_BUSINESS_CITY_APPROVING = "审核中";
	public static String ZdhSrappl_BUSINESS_CITY_APPROVED = "已批准";
	public static String ZdhSrappl_BUSINESS_CITY_DATACHECKED = "数据核对完成";
	public static String ZdhSrappl_BUSINESS_CITY_REPSUPERIOR = "已报上级调度";
	public static String ZdhSrappl_BUSINESS_CITY_WAITTRANS = "等待传动记录";
	
	public static String ZdhSrappl_BUSINESS_CITY_EXECUTING = "下发执行";
	public static String ZdhSrappl_BUSINESS_CITY_EXECUTED = "已执行";
	public static String ZdhSrappl_BUSINESS_CITY_CONFORMED = "已归档";
	public static String ZdhSrappl_BUSINESS_CITY_ABATED = "已作废";
	
	public static String ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_YES = "审批通过";
	public static String ZdhSrappl_WORKFLOW_CITY_BdspecApprove_TRANSIT_NO = "审批驳回";
	
	public static String ZdhSrappl_WORKFLOW_CITY_BdheaderApprove_TRANSIT_YES = "变电提交审核";
	public static String ZdhSrappl_WORKFLOW_CITY_BdheaderApprove_TRANSIT_NO = "审批驳回";
    //主任审批	
	public static String ZdhSrappl_WORKFLOW_CITY_DirectorApprove_TRANSIT_NO = "未通过";
	public static String ZdhSrappl_WORKFLOW_CITY_DirectorApprove_TRANSIT_YES = "通过";
	//处长审批
	public static String ZdhSrappl_WORKFLOW_CITY_HeaderApprove_TRANSIT_NO = "未通过";
	public static String ZdhSrappl_WORKFLOW_CITY_HeaderApprove_TRANSIT_YES = "通过";
	//主管主任审批
	public static String ZdhSrappl_WORKFLOW_CITY_MDicrecterApprove_TRANSIT_NO = "未通过";
	public static String ZdhSrappl_WORKFLOW_CITY_MDicrecterApprove_TRANSIT_YES = "批准下发";
	//自动化专工审批

	public static String ZdhSrappl_WORKFLOW_CITY_SpecApprove_TRANSIT_NO = "未通过";
	public static String ZdhSrappl_WORKFLOW_CITY_SpecApprove_TRANSIT_YES = "通过";
	
	//自动化专工下发未批准意见
	public static String ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOBD = "未通过";
	public static String ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOZDHYXC = "送自动化运行处修改";
	public static String ZdhSrappl_WORKFLOW_CITY_SpecSentConceit_TOQD = "下发审批结果";
	
	
	public static String ZdhSrappl_WORKFLOW_CITY_ZdhrunApprove_TRANSIT_NO = "审核驳回";
	public static String ZdhSrappl_WORKFLOW_CITY_ZdhrunApprove_TRANSIT_YES = "自动化运行处提交审核";	
	//发给区调的业务状态
	public static String ZdhSrappl_WORKFLOW_AREA_MidApprove_YES = "中调审批通过";
	public static String ZdhSrappl_WORKFLOW_AREA_MidApprove_NO = "中调审批未通过";
	public static String ZdhSrappl_WORKFLOW_AREA_STATUS_SPECTASKSENT = "6"; //区调的自动化专工任务下发
	public static String ZdhSrappl_WORKFLOW_AREA_STATUS_NEW = "1"; //区调的新建、启动
    //流程状态
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_NEW = "1";		         //新建、启动
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_BDSPECAPPROVE = "2";     //变电公司自动化专工审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_BDRUNMODIFY = "3";       //变电运行单位修改申请
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_BDHEADERAPPROVE = "4";   //变电公司领导审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_ZDHRUNAPPROVE = "5";     //自动化运行处处长审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_ZDHRUNMODIFY = "6";      //自动化运行处修改
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_BDTASKSENT = "7";        //变电自动化专工任务下发
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_RUNEXEC = "8";           //运行单位执行
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_SENTRESULT = "9";        //下发审批任务
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_DIRECTORAPPROVE = "10";  //运维中心主任审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_MDICRECTERAPPROVE = "11";//主管主任审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_SENTCOMMENT = "12";      //将审批意见下发(自动化专工下发未批准意见)

	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_SPECAPPROVE = "13";      //自动化专工审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_SPECKEEPON = "14";       //专工归档
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_HEADERAPPROVE = "15";    //处长审批
	public static String ZdhSrappl_WORKFLOW_CITY_STATUS_OVER = "-1";		     //结束
	//停复役权限常量
	public static String[] ZDHSRAPPLICATION_TABS={"zdhsrapplication_tab*1","zdhsrapplication_tab*2","zdhsrapplication_tab*3","zdhsrapplication_tab*4"};
	public static String[] ZDHSRAPPLICATION_TOOLBUTTONS={"zdhsrapplication_button*find","zdhsrapplication_button*new","zdhsrapplication_button*save","zdhsrapplication_button*delete","zdhsrapplication_button*transition","zdhsrapplication_button*report"};
	public static String[] ZDHSRAPPLICATION_OPTIONS={"zdh_SRexcute","zdh_SRapplicationDistribute","zdh_Sendtocenter","zdh_comfirmApp","zdh_abateApp","zdh_wf_history"};

	public static String ZDHSRAPPLICATION_APPROVE="zdhsrapplication_approve";//停复役申请;
	public static String ZDHSRAPPLICATION_APPROVE_EDIT="zdhsrapplication_approve_edit";//停复役申请可编辑
	public static String ZDHSRAPPLICATION_CONFIRM="zdhsrapplication_confirm";//批准信息
	public static String ZDHSRAPPLICATION_CONFIRM_EDIT="zdhsrapplication_confirm_edit";//批准信息可编辑
	public static String ZDHSRAPPLICATION_ORDER="zdhsrapplication_order";//执行信息
	public static String ZDHSRAPPLICATION_ORDER_EDIT="zdhsrapplication_order_edit";//执行信息可编辑
	
	/*****传动记录***********/
	public static String ZdhTransrecord_DATA_APP="已盖章";
	public static String ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP = "停复役申请";
	/*****传动记录end**********/
	/*****基改建***********/
	public static String projection_WORKFLOW_CITY_PROCESSDIFINITION = "projectrecption_city";	
	
	public static String projection_WORKFLOW_CITY_TRANSIT_END="结束流程";
	public static String projection_WORKFLOW_CITY_Fsystemtype="电量系统";
	public static String projection_WORKFLOW_CITY_Fstationname="变电站";
	
	public static String projection_WORKFLOW_CITY_ROLE_DL="电量专工";
	public static String projection_WORKFLOW_CITY_ROLE_ZZ="子站专工";
	
	public static String projection_WORKFLOW_CITY_SpecApprove_TRANSIT_YES_CITY="去等待传动信息";
	public static String projection_WORKFLOW_CITY_SpecApprove_TRANSIT_YES_AREA="去等待区调资料";
	public static String projection_WORKFLOW_CITY_SpecApprove_TRANSIT_NO_CITY="驳回填报角色";
	public static String projection_WORKFLOW_CITY_SpecApprove_TRANSIT_NO_AREA="驳回区调申请";
	
	public static String projection_WORKFLOW_CITY_RunApprove_TRANSIT_YES_CITY="审核通过(市调)";
	public static String projection_WORKFLOW_CITY_RunApprove_TRANSIT_YES_AREA="审核通过(区调上报)";
	public static String projection_WORKFLOW_CITY_RunApprove_TRANSIT_NO_CITY="投运审核驳回市调";
	public static String projection_WORKFLOW_CITY_RunApprove_TRANSIT_NO_AREA="投运审核驳回区调";
	
	public static String projection_WORKFLOW_CITY_ApproveFill_TRANSIT_YES_CITY="市调资料审核通过";
	public static String projection_WORKFLOW_CITY_ApproveFill_TRANSIT_YES_AREA="区调资料审核通过";
	public static String projection_WORKFLOW_CITY_ApproveFill_TRANSIT_NO_CITY="资料审核驳回专业公司";
	public static String projection_WORKFLOW_CITY_ApproveFill_TRANSIT_NO_AREA="资料审核驳回原区调";	
	//业务状态	public static String ZdhReception_CITY="市调";
	public static String ZdhReception_AREA="区调";
	public static String ZdhReception_WORKSOURCE="基改建";
	public static String ZdhReception_WORKFLOW_CITY_NEW ="草稿";
	public static String ZdhReception_WORKFLOW_CITY_MODIFY_OK ="修改中";
	public static String ZdhReception_WORKFLOW_CITY_AUDITING ="处理中";
	public static String ZdhReception_WORKFLOW_CITY_ACCEPT_YES ="同意验收";
	public static String ZdhReception_WORKFLOW_CITY_ACCEPT_NO ="验收驳回";
	public static String ZdhReception_WORKFLOW_CITY_DATA_APPROVED ="数据核对完成";
	public static String ZdhReception_WORKFLOW_CITY_DATA_NOTICED ="资料已上报";
	public static String ZdhReception_WORKFLOW_CITY_DATA_CHECKED ="资料验收完成";
	public static String ZdhReception_WORKFLOW_CITY_DATA_NO ="资料驳回";	
	public static String ZdhReception_WORKFLOW_CITY_APP ="申请投运";
	public static String ZdhReception_WORKFLOW_CITY_RECPETION_YES ="批准投运";
	public static String ZdhReception_WORKFLOW_CITY_RECPETION_NO ="投运驳回";
	public static String ZdhReception_WORKFLOW_CITY_EXECUTED ="已执行";
	public static String ZdhReception_WORKFLOW_CITY_PIGEONHOLED ="已归档";
	//流程状态
	public static String ZdhReception_WORKFLOW_STATUS_CITY_YES="1C";//市调通过
	public static String ZdhReception_WORKFLOW_STATUS_AREA_YES="1A";//区调通过
	public static String ZdhReception_WORKFLOW_STATUS_CITY_NO="-1C";//市调不通过
	public static String ZdhReception_WORKFLOW_STATUS__AREA_NO="-1A";//区调不通过
	public static String ZdhReception_WORKFLOW_CITY_STATUS_NOTICED="2.1";//等待资料上报
	
	public static String ZdhReception_WORKFLOW_CITY_STATUS_NEW ="1";//填写验收申请
	public static String ZdhReception_WORKFLOW_CITY_STATUS_AUDITING ="2";//市调专工审核 
	public static String ZdhReception_WORKFLOW_CITY_STATUS_ROLE="3";//填报角色上报验收资料
	public static String ZdhReception_WORKFLOW_CITY_STATUS_DATA_APPROVED ="4";//传动完成
	public static String ZdhReception_WORKFLOW_CITY_STATUS_DATA_NOTICED ="5";//发送-资料上报
	public static String ZdhReception_WORKFLOW_CITY_STATUS_DATA_CHECK ="6";//资料审核	
	public static String ZdhReception_WORKFLOW_CITY_STATUS_APP ="7";//申请投运
	public static String ZdhReception_WORKFLOW_CITY_STATUS_RECPETION ="8";//批准投运	
	public static String ZdhReception_WORKFLOW_CITY_STATUS_EXECUTED ="9";//已执行
	public static String ZdhReception_WORKFLOW_CITY_STATUS_PIGEONHOLED ="10";//已归档//	工作票
	public static String ZdhMachinehallist_WORKBILL_SOURCE="工作票";
	

}
