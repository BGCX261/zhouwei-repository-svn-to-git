<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.sql.Date" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>工作票详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
   <%@ include file="/common/init_js.jsp" %>
   <%@ include file="/common/init_date.jsp" %>
   <script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhworkbill/zdhworkbill_defaultDetail_detail.js"></script>
</head>
<body>


<html:javascript formName="zdhWorkbillForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhWorkbillForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="zdhWorkbillDto.workbillid" value="${zdhWorkbillForm.zdhWorkbillDto.workbillid}">
<input type="hidden" name="zdhWorkbillDto.version" value="${zdhWorkbillForm.zdhWorkbillDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanele8b788390e454d699821499625e5ba8b" title="工作票申请"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele8b788390e454d699821499625e5ba8b">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.sys_fille}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.sys_filldept}
			   </td>
			  	    		    </tr>
	   <tr>
			     <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.sys_filltime"/><%--填写时间--%></td>
			  	 <td height="23" width="30%" >
			  	 ${zdhWorkbillForm.zdhWorkbillDto.sys_filltime}
				 
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.sys_isvalid}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.sys_dataowner}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.fexcutestatus"/><%--工作票状态--%></td>
			  	 <td height="23" width="30%" >
			     ${zdhWorkbillForm.zdhWorkbillDto.fexcutestatus}
			   </td>
			  	    		    </tr>
	   <tr>
			     <td height="23" class="tab_0" width="20%">
				    <bean:message key="object.zdhWorkbillDto.zzdhworkbill2.ondutyno"/><%--交接班记录编号--%>
				 </td>
			  	 <td height="23" width="30%"  colspan="3"  >
				 ${zdhWorkbillForm.zdhWorkbillDto.zzdhworkbill2.ondutyno}
			     </td>
	   </tr>
	   <tr>
			  <td height="23" class="tab_0" width="20%">			  
				 <bean:message key="object.zdhWorkbillDto.safetyremarks"/><%--注意事项及安全措施--%>
			  </td>
			  <td height="23" width="30%"  colspan="3"  >
			  ${zdhWorkbillForm.zdhWorkbillDto.safetyremarks}</td>
	   </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.applicationunit"/><%--申请单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.applicationunit}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.applicants"/><%--申请人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.applicants}
			   </td>
			  	    		    </tr>
	   <tr>					  			   
			  	 <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.worktime"/><%--工作时间--%></td>
			  	 <td height="23" width="30%" colspan="3">
				 ${zdhWorkbillForm.zdhWorkbillDto.worktime}
			     
			   </td>
	   </tr>
	   <tr>
			<td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.workcontent"/><%--工作内容--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				${zdhWorkbillForm.zdhWorkbillDto.workcontent}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.relativesystem"/><%--相关系统--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.relativesystem}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.relativeequipment"/><%--相关设备--%></td>
			  	    			  			   <td height="23" width="30%" >
				  ${zdhWorkbillForm.zdhWorkbillDto.relativeequipment}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.dangerouspoint"/><%--危险点分析及措施--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				${zdhWorkbillForm.zdhWorkbillDto.dangerouspoint}
			   </td>
	   </tr>
	   <tr>
			<td height="23" class="tab_0" width="20%">
		    <bean:message key="object.zdhWorkbillDto.remarks"/><%--备注--%></td>
			<td height="23" width="30%"  colspan="3" >				 
				  ${zdhWorkbillForm.zdhWorkbillDto.remarks}
			 </td>
	   </tr>
	   <tr>
			<td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.workingbillno"/><%--机房工作票编号--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhWorkbillForm.zdhWorkbillDto.workingbillno}
			   </td>
			  	    		    </tr>
	   <tr>
			     <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.applicantedtime"/><%--申请时间--%></td>
			  	 <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.applicantedtime}
			     </td>
			  	 <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.workingcharge"/><%--工作负责人--%></td>
			  	 <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.workingcharge}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.workingbilltype"/><%--工作票类型--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhWorkbillForm.zdhWorkbillDto.workingbilltype}
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanelfac0e56e3cfc4191afa7a54b2d1e9a75" title="工作票执行"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelfac0e56e3cfc4191afa7a54b2d1e9a75">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.workbegintime"/><%--工作实际完成时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.workbegintime}
			   </td>
			  	    			  			   
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.fapprover"/><%--审核人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.fapprover}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.fallower"/><%--许可人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.fallower}
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanelcb7b015745144e5e89348466b4acb361" title="工作票核查"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelcb7b015745144e5e89348466b4acb361">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.reason"/><%--不合格原因--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhWorkbillForm.zdhWorkbillDto.reason}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.ispassed"/><%--是否合格--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhWorkbillForm.zdhWorkbillDto.ispassed}
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.passchecker"/><%--合格情况核查人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 ${zdhWorkbillForm.zdhWorkbillDto.passchecker}
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhWorkbillDto.passchecktime"/><%--合格核查时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				${zdhWorkbillForm.zdhWorkbillDto.passchecktime}
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>

</body>
</html>
