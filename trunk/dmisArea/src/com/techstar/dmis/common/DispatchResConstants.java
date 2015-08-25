package com.techstar.dmis.common;

public class DispatchResConstants {
	  /*
    

     *****************标识名***************

     查找按钮:    find

     新增按钮:    new 

     复制按钮:     copy

     保存按钮:    save

     删除按钮:    delete

     取消按钮:    cancel

     工作流扭转按钮: transition

     上一条按钮: lastRow

     下一条按钮: nextRow

     查看报表按钮:  report
*/  
	public static String dddouageplanbuid = "dddoutageplan";//日计划的业务Id
	public static String DDDOUTAGEPLAN_TABDESC="dddoutageplan_tab";//tab 描述
	public static String DDDOUTAGEPLAN_BUTTONDESC = "dddoutageplan_button";//toolbutton描述
	public static String DDDOUTAGEPLAN_OPTIONDESC="dddoutageplan_option"; //option 描述
	public static String[] DDDOUTAGEPLAN_TABS={"dddoutageplan_tab*1","dddoutageplan_tab*2","dddoutageplan_tab*3","dddoutageplan_tab*4","dddoutageplan_tab*5"};//所有tab页的业务ID
	public static String[] DDDOUTAGEPLAN_TOOLBUTTONS={"dddoutageplan_button*find","dddoutageplan_button*new","dddoutageplan_button*save","dddoutageplan_button*delete","dddoutageplan_button*transition","dddoutageplan_button*report"};//所有toolbutton的业务ID
	public static String[] DDDOUTAGEPLAN_OPTION={"ddd_createdayplan","ddd_copprate","ddd_switchbill","ddd_hangbrand","ddd_selectbayeqp2","ddd_dayplanexcute","ddd_wf_history"};//所有操作的业务ID
	
	
	
	public static String DDDOUTAGEPLAN_APPROVE="dddoutageplan_group_approve";//日计划申请
	public static String DDDOUTAGEPLAN_APPROVE_EDIT="dddoutageplan_group_approve_edit";//日计划申请可编辑
	
	
	
	public static String DDDOUTAGEPLAN_MODECHANGE="dddoutageplan_group_modechange";//方式变更
	public static String DDDOUTAGEPLAN_MODECHANGE_EDIT="dddoutageplan_group_modechange_edit";//方式变更可编辑
	public static String DDDOUTAGEPLAN_MODECHANGE_DELETE="dddoutageplan_group_modechange_delete";//方式变更删除
	
	public static String DDDOUTAGEPLAN_CONFIRM="dddoutageplan_group_confirm";//日计划批准情况
	public static String DDDOUTAGEPLAN_CONFIRM_EDIT="dddoutageplan_group_confirm_edit";//日计划批准情况可编辑
	
	
	public static String DDDOUTAGEPLAN_CHECK="dddoutageplan_group_check";//日计划核查
	public static String DDDOUTAGEPLAN_CHECK_EDIT="dddoutageplan_group_check_edit";//日计划核查可编辑
	
	
	
	public static String DDDOUTAGEPLAN_STAMP ="dddoutageplan_group_stamp";//电子章
	public static String DDDOUTAGEPLAN_STAMP_EDIT ="dddoutageplan_group_stamp_edit";//电子章可编辑
	
	
	
	public static String DDDOUTAGEPLAN_ORDER ="dddoutageplan_group_order";//日计划执行下令收令情况
	public static String DDDOUTAGEPLAN_ORDER_EDIT1 ="dddoutageplan_group_order_edit";//日计划执行下令收令情况可编辑
	public static String DDDOUTAGEPLAN_ORDER_DELETE ="dddoutageplan_group_order_delete";//日计划执行下令收令情况可删除
	public static String DDDOUTAGEPLAN_ORDER_CANCLEREASON_EDIT ="dddoutageplan_group_canclereason_edit";//取消原因可编辑
	
	public static String DDDOUTAGEPLAN_REPORT="dddoutageplan_group_report";//中调命令
	public static String DDDOUTAGEPLAN_REPORT_EDIT="dddoutageplan_group_report_edit";//中调命令可编辑
	
	public static String DDDOUTAGEPLAN_DELAY="dddoutageplan_group_delay";//日计划延期
	public static String DDDOUTAGEPLAN_DELAY_EDIT="dddoutageplan_group_delay_edit";//日计划延期可编辑
	public static String DDDOUTAGEPLAN_DELAY_DELETE="dddoutageplan_group_delay_delete";//日计划延期可删除
	
	
	
	
	
	/*************************************************月计划***********************************************************/
	
	 
	public static String DDMOUTAGEPLANBuid = "DdMoutageplan";//月计划的业务Id
	public static String DDMOUTAGEPLAN_TABDESC="ddmoutageplan_tab";//tab 描述
	public static String DDMOUTAGEPLAN_BUTTONDESC = "ddmoutageplan_button";//toolbutton描述
	public static String DDMOUTAGEPLAN_OPTIONDESC="ddmoutageplan_option"; //option 描述
	public static String[] DDMOUTAGEPLAN_TABS={"ddmoutageplan_tab*1","ddmoutageplan_tab*2","ddmoutageplan_tab*3","ddmoutageplan_tab*4"};//所有tab页的业务ID
	public static String[] DDMOUTAGEPLAN_TOOLBUTTONS={"ddmoutageplan_button*find","ddmoutageplan_button*new","ddmoutageplan_button*save","ddmoutageplan_button*delete","ddmoutageplan_button*transition","ddmoutageplan_button*report"};//所有toolbutton的业务ID
	public static String[] DDMOUTAGEPLAN_OPTION={"ddm_pigeonhole","ddm_dayPlan","ddm_newPlanFromNot","ddm_uniteByContent","ddm_uniteByObject","ddm_eomUpdataState","ddm_dd_selectbayeqp","ddm_wf_history"};//所有操作的业务ID

	public static String DDMOUTAGEPLAN_APPROVE="ddmoutageplan_group_approve";//月计划申请
	public static String DDMOUTAGEPLAN_APPROVE_EDIT="ddmoutageplan_group_approve_edit";//月计划申请可编辑
	
	
	
	public static String DDMOUTAGEPLAN_EXE="ddmoutageplan_group_modechange";//月计划执行
	public static String DDMOUTAGEPLAN_EXT_EDIT="ddmoutageplan_group_modechange_edit";//月计划执行可编辑
	
	
	
}
