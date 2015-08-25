<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度交接班记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddclassondutylog/detail.js"></script>
</head>
<body>
<html:javascript formName="ddClassondutylogForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddClassondutylogForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddClassondutylogDto.fid" value="${ddClassondutylogForm.ddClassondutylogDto.fid}">
<input type="hidden" name="ddClassondutylogDto.version" value="${ddClassondutylogForm.ddClassondutylogDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelc26065efc315471da7343af19c9e1871" title="调度交接班记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelc26065efc315471da7343af19c9e1871">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fid"/><%--班志编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.fid" name="ddClassondutylogDto.fid" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.fid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fsuccessiontime"/><%--值班开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddClassondutylogDto.fsuccessiontime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddClassondutylogForm.ddClassondutylogDto.fsuccessiontime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fhandovertime"/><%--值班结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddClassondutylogDto.fhandovertime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddClassondutylogForm.ddClassondutylogDto.fhandovertime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fforecast"/><%--气象情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.fforecast" name="ddClassondutylogDto.fforecast" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.fforecast}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fdelivercnt"/><%--交接内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.fdelivercnt" name="ddClassondutylogDto.fdelivercnt" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.fdelivercnt}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.content"/><%--班志内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="content" multiValue="no"></jhop:upload>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.sys_fille" name="ddClassondutylogDto.sys_fille" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.sys_filldept" name="ddClassondutylogDto.sys_filldept" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddClassondutylogDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddClassondutylogForm.ddClassondutylogDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fworkshift"/><%--班次--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.fworkshift" name="ddClassondutylogDto.fworkshift" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.fworkshift}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
