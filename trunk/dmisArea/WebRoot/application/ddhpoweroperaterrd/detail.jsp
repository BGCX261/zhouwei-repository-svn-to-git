<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电厂运行(下令操作)记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddhpoweroperaterrd/detail.js"></script>
</head>
<body>
<html:javascript formName="ddHpoweroperaterrdForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddHpoweroperaterrdForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddHpoweroperaterrdDto.fid" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fid}">
<input type="hidden" name="ddHpoweroperaterrdDto.version" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPaneldad92d29d5b046a2ab4b1f217bdbe075" title="电厂运行(下令操作)记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneldad92d29d5b046a2ab4b1f217bdbe075">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fid"/><%--记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fid" name="ddHpoweroperaterrdDto.fid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fplant"/><%--电厂名--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fplant" name="ddHpoweroperaterrdDto.fplant" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fplant}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmder"/><%--下令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmder" name="ddHpoweroperaterrdDto.fsendcmder" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmder}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmder"/><%--受令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmder" name="ddHpoweroperaterrdDto.freccmder" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmder}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdtime"/><%--下令时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.fsendcmdtime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdtime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdwaterlevel"/><%--下令水位(米)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdwaterlevel" name="ddHpoweroperaterrdDto.fsendcmdwaterlevel" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdwaterlevel}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdgenerating"/><%--下令发电量(W)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdgenerating" name="ddHpoweroperaterrdDto.fsendcmdgenerating" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdgenerating}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdoutflow"/><%--下令放水量(个)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdoutflow" name="ddHpoweroperaterrdDto.fsendcmdoutflow" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdoutflow}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsummiter"/><%--交令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsummiter" name="ddHpoweroperaterrdDto.fsummiter" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsummiter}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmdwaterlevel"/><%--交令水位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmdwaterlevel" name="ddHpoweroperaterrdDto.freccmdwaterlevel" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdwaterlevel}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmdgenerating"/><%--交令发电量(W)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmdgenerating" name="ddHpoweroperaterrdDto.freccmdgenerating" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdgenerating}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmdoutflow"/><%--交令放水量--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmdoutflow" name="ddHpoweroperaterrdDto.freccmdoutflow" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdoutflow}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsummittime"/><%--交令时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.fsummittime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsummittime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fcurlogno"/><%--当前班志编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fcurlogno" name="ddHpoweroperaterrdDto.fcurlogno" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fcurlogno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fwriteinlog"/><%--是否写入日志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fwriteinlog" name="ddHpoweroperaterrdDto.fwriteinlog" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fwriteinlog}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fwriteinwglog"/><%--是否写入班志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fwriteinwglog" name="ddHpoweroperaterrdDto.fwriteinwglog" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fwriteinwglog}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmderid"/><%--下令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmderid" name="ddHpoweroperaterrdDto.fsendcmderid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmderid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmderid"/><%--接令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmderid" name="ddHpoweroperaterrdDto.freccmderid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmderid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsummiterid"/><%--交令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsummiterid" name="ddHpoweroperaterrdDto.fsummiterid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsummiterid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.sys_fille" name="ddHpoweroperaterrdDto.sys_fille" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.sys_filldept" name="ddHpoweroperaterrdDto.sys_filldept" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fordertype"/><%--命令类型--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddHpoweroperaterrdDto.fordertype" name="ddHpoweroperaterrdDto.fordertype" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fordertype}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
