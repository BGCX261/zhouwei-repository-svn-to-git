<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电网风险提示详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddrepairrisklist/detail.js"></script>
</head>
<body>
<html:javascript formName="ddRepairrisklistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddRepairrisklistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddRepairrisklistDto.fid" value="${ddRepairrisklistForm.ddRepairrisklistDto.fid}">
<input type="hidden" name="ddRepairrisklistDto.version" value="${ddRepairrisklistForm.ddRepairrisklistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanele30635c0f0ce4fa28c062967b8cba770" title="电网风险提示"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele30635c0f0ce4fa28c062967b8cba770">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.fid"/><%--风险提示编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.fid" name="ddRepairrisklistDto.fid" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.fid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.ftransformer"/><%--变压器--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.ftransformer" name="ddRepairrisklistDto.ftransformer" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.ftransformer}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.fline"/><%--线路--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.fline" name="ddRepairrisklistDto.fline" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.fline}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.fworkcontent"/><%--工作内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.fworkcontent" name="ddRepairrisklistDto.fworkcontent" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.fworkcontent}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.foutagestime"/><%--检修开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddRepairrisklistDto.foutagestime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddRepairrisklistForm.ddRepairrisklistDto.foutagestime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.foutageetime"/><%--检修结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddRepairrisklistDto.foutageetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddRepairrisklistForm.ddRepairrisklistDto.foutageetime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.friskprompt"/><%--风险提示--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.friskprompt" name="ddRepairrisklistDto.friskprompt" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.friskprompt}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.fforecast"/><%--天气预报--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.fforecast" name="ddRepairrisklistDto.fforecast" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.fforecast}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.friskunit"/><%--风险相关单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.friskunit" name="ddRepairrisklistDto.friskunit" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.friskunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.sys_fille" name="ddRepairrisklistDto.sys_fille" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.sys_filldept" name="ddRepairrisklistDto.sys_filldept" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddRepairrisklistDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddRepairrisklistForm.ddRepairrisklistDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.sys_isvalid" name="ddRepairrisklistDto.sys_isvalid" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_isvalid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddRepairrisklistDto.sys_dataowner" name="ddRepairrisklistDto.sys_dataowner" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddRepairrisklistDto.fdangerreason"/><%--风险原因--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddRepairrisklistDto.fdangerreason" name="ddRepairrisklistDto.fdangerreason" type="text" value="${ddRepairrisklistForm.ddRepairrisklistDto.fdangerreason}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
