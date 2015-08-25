<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>旬停电计划详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddwoutageplan/detail.js"></script>
</head>
<body>
<html:javascript formName="ddWoutageplanForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddWoutageplanForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddWoutageplanDto.fwplanno" value="${ddWoutageplanForm.ddWoutageplanDto.fwplanno}">
<input type="hidden" name="ddWoutageplanDto.version" value="${ddWoutageplanForm.ddWoutageplanDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel23ca3b7b8897420788716dc2b8447e0e" title="旬停电计划"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel23ca3b7b8897420788716dc2b8447e0e">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fwplanno"/><%--旬计划编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fwplanno" name="ddWoutageplanDto.fwplanno" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fwplanno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fstationname"/><%--变电站--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fstationname" name="ddWoutageplanDto.fstationname" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fstationname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.flinename"/><%--线路名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.flinename" name="ddWoutageplanDto.flinename" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.flinename}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fvoltage"/><%--电压等级--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fvoltage" name="ddWoutageplanDto.fvoltage" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fvoltage}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.funfinishreasonid"/><%--未完成id--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.funfinishreasonid" name="ddWoutageplanDto.funfinishreasonid" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.funfinishreasonid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.sys_fille" name="ddWoutageplanDto.sys_fille" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.sys_filldept" name="ddWoutageplanDto.sys_filldept" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddWoutageplanDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddWoutageplanForm.ddWoutageplanDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.sys_isvalid" name="ddWoutageplanDto.sys_isvalid" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.sys_dataowner" name="ddWoutageplanDto.sys_dataowner" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddWoutageplanDto.version" name="ddWoutageplanDto.version" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.version}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fworkcontent"/><%--工作内容--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fworkcontent" name="ddWoutageplanDto.fworkcontent" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fworkcontent}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.foutagearea"/><%--停电范围--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.foutagearea" name="ddWoutageplanDto.foutagearea" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.foutagearea}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fdispatchrange"/><%--调度范围--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fdispatchrange" name="ddWoutageplanDto.fdispatchrange" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fdispatchrange}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fstarttime"/><%--预计工作起始时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddWoutageplanDto.fstarttime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddWoutageplanForm.ddWoutageplanDto.fstarttime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fendtime"/><%--预计工作结束时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddWoutageplanDto.fendtime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddWoutageplanForm.ddWoutageplanDto.fendtime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fapplyunit"/><%--申请单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fapplyunit" name="ddWoutageplanDto.fapplyunit" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fapplyunit}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fapplicant"/><%--申请人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fapplicant" name="ddWoutageplanDto.fapplicant" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fapplicant}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fapplytime"/><%--申请时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddWoutageplanDto.fapplytime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddWoutageplanForm.ddWoutageplanDto.fapplytime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fstatus"/><%--计划状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fstatus" name="ddWoutageplanDto.fstatus" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fstatus}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fplansourcetype"/><%--计划来源类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fplansourcetype" name="ddWoutageplanDto.fplansourcetype" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fplansourcetype}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fexcutestatus"/><%--执行状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fexcutestatus" name="ddWoutageplanDto.fexcutestatus" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fexcutestatus}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fremark"/><%--备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fremark" name="ddWoutageplanDto.fremark" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fremark}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.funfinishreason"/><%--未完成原因--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.funfinishreason" name="ddWoutageplanDto.funfinishreason" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.funfinishreason}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fstationid"/><%--变电站ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fstationid" name="ddWoutageplanDto.fstationid" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fstationid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.flinenameid"/><%--线路名ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.flinenameid" name="ddWoutageplanDto.flinenameid" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.flinenameid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWoutageplanDto.fapplyunitid"/><%--申请单位ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddWoutageplanDto.fapplyunitid" name="ddWoutageplanDto.fapplyunitid" type="text" value="${ddWoutageplanForm.ddWoutageplanDto.fapplyunitid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
