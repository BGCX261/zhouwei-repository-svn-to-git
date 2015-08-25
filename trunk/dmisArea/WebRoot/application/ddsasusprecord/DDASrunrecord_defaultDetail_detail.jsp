<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>自投停用记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddsasusprecord/DDASrunrecord_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddSasusprecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddSasusprecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddSasusprecordDto.fid" value="${ddSasusprecordForm.ddSasusprecordDto.fid}">
<input type="hidden" name="ddSasusprecordDto.version" value="${ddSasusprecordForm.ddSasusprecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel8ce8d9bffed0475a9b5e3b7c69795383" title="自投停用记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel8ce8d9bffed0475a9b5e3b7c69795383">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fncurrent"/><%--N-2后电流(A)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <bean:message key="object.ddSasusprecordDto.fsusptime"/><%--停用时间--%>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <jhop:date name="ddSasusprecordDto.fsusptime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddSasusprecordForm.ddSasusprecordDto.fsusptime}" ></jhop:date></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSasusprecordDto.fncurrent" name="ddSasusprecordDto.fncurrent" type="text" value="${ddSasusprecordForm.ddSasusprecordDto.fncurrent}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fstationname"/><%--设备所在的变电站(开闭站)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSasusprecordDto.fstationname" name="ddSasusprecordDto.fstationname" type="text" value="${ddSasusprecordForm.ddSasusprecordDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fsuspswitchno"/><%--停自投开关号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSasusprecordDto.fsuspswitchno" name="ddSasusprecordDto.fsuspswitchno" type="text" value="${ddSasusprecordForm.ddSasusprecordDto.fsuspswitchno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fratedcurrent"/><%--额定电流(A)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSasusprecordDto.fratedcurrent" name="ddSasusprecordDto.fratedcurrent" type="text" value="${ddSasusprecordForm.ddSasusprecordDto.fratedcurrent}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fsuspreason"/><%--停自投原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddSasusprecordDto.fsuspreason" hiddName="" type="fsuspreason" initValue="${ddSasusprecordForm.ddSasusprecordDto.fsuspreason}"> </jhop:select>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.frestoretime"/><%--恢复时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddSasusprecordDto.frestoretime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddSasusprecordForm.ddSasusprecordDto.frestoretime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fkeeptime"/><%--时长--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddSasusprecordDto.fkeeptime" name="ddSasusprecordDto.fkeeptime" type="text" value="${ddSasusprecordForm.ddSasusprecordDto.fkeeptime}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fiswritelog"/><%--是否写入日志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddSasusprecordDto.fiswritelog" hiddName="" type="fiswritelog" initValue="${ddSasusprecordForm.ddSasusprecordDto.fiswritelog}"> </jhop:select>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddSasusprecordDto.fiswriteinwglog"/><%--是否写入班志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddSasusprecordDto.fiswriteinwglog" hiddName="" type="fiswriteinwglog" initValue="${ddSasusprecordForm.ddSasusprecordDto.fiswriteinwglog}"> </jhop:select>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
