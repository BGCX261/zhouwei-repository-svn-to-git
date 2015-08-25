<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度操作票详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddswitchseqbill/detail.js"></script>
</head>
<body>
<html:javascript formName="ddSwitchseqbillForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddSwitchseqbillForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddSwitchseqbillDto.fcomputerno" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fcomputerno}">
<input type="hidden" name="ddSwitchseqbillDto.version" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPaneld7bfb00d675243338fcd877226abf0d5" title="调度操作票"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneld7bfb00d675243338fcd877226abf0d5">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fcomputerno"/><%--操作票计算机编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fcomputerno" name="ddSwitchseqbillDto.fcomputerno" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fcomputerno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fmanualno"/><%--执行编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fmanualno" name="ddSwitchseqbillDto.fmanualno" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fmanualno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fdate"/><%--操作日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddSwitchseqbillDto.fdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddSwitchseqbillForm.ddSwitchseqbillDto.fdate}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fmission"/><%--操作任务--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fmission" name="ddSwitchseqbillDto.fmission" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fmission}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fremark"/><%--备注--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fremark" name="ddSwitchseqbillDto.fremark" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fremark}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fexcutestatus"/><%--执行情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fexcutestatus" name="ddSwitchseqbillDto.fexcutestatus" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fexcutestatus}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fistypicalbill"/><%--是否典型票--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fistypicalbill" name="ddSwitchseqbillDto.fistypicalbill" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fistypicalbill}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fbillsource"/><%--操作票任务来源类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fbillsource" name="ddSwitchseqbillDto.fbillsource" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fbillsource}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fsrcbillno"/><%--来源记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fsrcbillno" name="ddSwitchseqbillDto.fsrcbillno" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fsrcbillno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fstatus"/><%--流转状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fstatus" name="ddSwitchseqbillDto.fstatus" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstatus}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fstationname"/><%--变电站名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fstationname" name="ddSwitchseqbillDto.fstationname" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fvoltage"/><%--电压等级--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fvoltage" name="ddSwitchseqbillDto.fvoltage" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fvoltage}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.flinename"/><%--线路名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.flinename" name="ddSwitchseqbillDto.flinename" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.flinename}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.ftaskname"/><%--任务名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.ftaskname" name="ddSwitchseqbillDto.ftaskname" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.ftaskname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.ispassed"/><%--是否合格--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.ispassed" name="ddSwitchseqbillDto.ispassed" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.ispassed}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.reason"/><%--不合格原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.reason" name="ddSwitchseqbillDto.reason" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.reason}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.passedchecker"/><%--合格情况检查人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.passedchecker" name="ddSwitchseqbillDto.passedchecker" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.passedchecker}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.passchecktime"/><%--合格情况检查时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddSwitchseqbillDto.passchecktime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddSwitchseqbillForm.ddSwitchseqbillDto.passchecktime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fstepcounts"/><%--操作步骤数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fstepcounts" name="ddSwitchseqbillDto.fstepcounts" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstepcounts}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.fstopreason"/><%--操作终止原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.fstopreason" name="ddSwitchseqbillDto.fstopreason" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstopreason}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.sys_fille" name="ddSwitchseqbillDto.sys_fille" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.sys_filldept" name="ddSwitchseqbillDto.sys_filldept" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddSwitchseqbillDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.sys_isvalid" name="ddSwitchseqbillDto.sys_isvalid" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_isvalid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.sys_dataowner" name="ddSwitchseqbillDto.sys_dataowner" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_dataowner}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSwitchseqbillDto.foperate"/><%--操作名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSwitchseqbillDto.foperate" name="ddSwitchseqbillDto.foperate" type="text" value="${ddSwitchseqbillForm.ddSwitchseqbillDto.foperate}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
