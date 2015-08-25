<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>保护设备缺陷详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/bhfaultlist/detail.js"></script>
</head>
<body>
<html:javascript formName="bhFaultlistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="bhFaultlistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="bhFaultlistDto.ffaultno" value="${bhFaultlistForm.bhFaultlistDto.ffaultno}">
<input type="hidden" name="bhFaultlistDto.version" value="${bhFaultlistForm.bhFaultlistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanela218a566686d4a9ba3b1b82017d1ac1d" title="保护设备缺陷"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanela218a566686d4a9ba3b1b82017d1ac1d">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.ffaultno"/><%--缺陷记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.ffaultno" name="bhFaultlistDto.ffaultno" type="text" value="${bhFaultlistForm.bhFaultlistDto.ffaultno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fstationname"/><%--厂站名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fstationname" name="bhFaultlistDto.fstationname" type="text" value="${bhFaultlistForm.bhFaultlistDto.fstationname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fdispatchname"/><%--调度命名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fdispatchname" name="bhFaultlistDto.fdispatchname" type="text" value="${bhFaultlistForm.bhFaultlistDto.fdispatchname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fhandleresult"/><%--处理情况--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fhandleresult" name="bhFaultlistDto.fhandleresult" type="text" value="${bhFaultlistForm.bhFaultlistDto.fhandleresult}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.foccurredtime"/><%--缺陷发生时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFaultlistDto.foccurredtime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhFaultlistForm.bhFaultlistDto.foccurredtime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.frestoretime"/><%--缺陷消除时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFaultlistDto.frestoretime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhFaultlistForm.bhFaultlistDto.frestoretime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fcontinuetime"/><%--缺陷累计时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fcontinuetime" name="bhFaultlistDto.fcontinuetime" type="text" value="${bhFaultlistForm.bhFaultlistDto.fcontinuetime}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.feqpid"/><%--关联设备编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.feqpid" name="bhFaultlistDto.feqpid" type="text" value="${bhFaultlistForm.bhFaultlistDto.feqpid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.dataowner"/><%--数据归属--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.dataowner" name="bhFaultlistDto.dataowner" type="text" value="${bhFaultlistForm.bhFaultlistDto.dataowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fstates"/><%--缺陷状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fstates" name="bhFaultlistDto.fstates" type="text" value="${bhFaultlistForm.bhFaultlistDto.fstates}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fstationid"/><%--厂站ID--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fstationid" name="bhFaultlistDto.fstationid" type="text" value="${bhFaultlistForm.bhFaultlistDto.fstationid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.sys_fille" name="bhFaultlistDto.sys_fille" type="text" value="${bhFaultlistForm.bhFaultlistDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.sys_filldept" name="bhFaultlistDto.sys_filldept" type="text" value="${bhFaultlistForm.bhFaultlistDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhFaultlistDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${bhFaultlistForm.bhFaultlistDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.sys_isvalid" name="bhFaultlistDto.sys_isvalid" type="text" value="${bhFaultlistForm.bhFaultlistDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.sys_dataowner" name="bhFaultlistDto.sys_dataowner" type="text" value="${bhFaultlistForm.bhFaultlistDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.version" name="bhFaultlistDto.version" type="text" value="${bhFaultlistForm.bhFaultlistDto.version}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.fstaticreason"/><%--缺陷原因--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhFaultlistDto.fstaticreason" name="bhFaultlistDto.fstaticreason" type="text" value="${bhFaultlistForm.bhFaultlistDto.fstaticreason}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhFaultlistDto.ffaultgrade"/><%--性质--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="bhFaultlistDto.ffaultgrade" name="bhFaultlistDto.ffaultgrade" type="text" value="${bhFaultlistForm.bhFaultlistDto.ffaultgrade}" size="10"  />
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
