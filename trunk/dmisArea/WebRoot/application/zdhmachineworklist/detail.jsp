<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>机房工作详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhmachineworklist/detail.js"></script>
</head>
<body>
<html:javascript formName="zdhMachineworklistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhMachineworklistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhMachineworklistDto.jobid" value="${zdhMachineworklistForm.zdhMachineworklistDto.jobid}">
<input type="hidden" name="zdhMachineworklistDto.version" value="${zdhMachineworklistForm.zdhMachineworklistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel61d1d51a461b4df6b410158582384780" title="机房工作"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel61d1d51a461b4df6b410158582384780">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.jobid"/><%--工作编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.jobid" name="zdhMachineworklistDto.jobid" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.jobid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingtime"/><%--工作时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhMachineworklistDto.workingtime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhMachineworklistForm.zdhMachineworklistDto.workingtime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.content"/><%--纪事内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.content" name="zdhMachineworklistDto.content" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.content}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingsources"/><%--工作来源--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.workingsources" name="zdhMachineworklistDto.workingsources" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.workingsources}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_fille" name="zdhMachineworklistDto.sys_fille" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_filldept" name="zdhMachineworklistDto.sys_filldept" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhMachineworklistDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.jobcategory"/><%--工作类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.jobcategory" name="zdhMachineworklistDto.jobcategory" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.jobcategory}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.fexcutestatus"/><%--完成状态--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="zdhMachineworklistDto.fexcutestatus" name="zdhMachineworklistDto.fexcutestatus" type="text" value="${zdhMachineworklistForm.zdhMachineworklistDto.fexcutestatus}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
