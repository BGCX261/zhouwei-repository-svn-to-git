<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>厂站详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stdstation/detail.js"></script>
</head>
<body>
<html:javascript formName="stdStationForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="stdStationForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="stdStationDto.stationno" value="${stdStationForm.stdStationDto.stationno}">
<input type="hidden" name="stdStationDto.version" value="${stdStationForm.stdStationDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel8a5cc33a96364e2491abdf5e3c31b7ff" title="厂站"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel8a5cc33a96364e2491abdf5e3c31b7ff">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.stationno"/><%--变电站编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.stationno" name="stdStationDto.stationno" type="text" value="${stdStationForm.stdStationDto.stationno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.stationname"/><%--变电站名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.stationname" name="stdStationDto.stationname" type="text" value="${stdStationForm.stdStationDto.stationname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.manageunit"/><%--管理单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.manageunit" name="stdStationDto.manageunit" type="text" value="${stdStationForm.stdStationDto.manageunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.issubstation"/><%--变电站/开闭站/刀闸室/电厂/主站--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.issubstation" name="stdStationDto.issubstation" type="text" value="${stdStationForm.stdStationDto.issubstation}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.stationowner"/><%--产权--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.stationowner" name="stdStationDto.stationowner" type="text" value="${stdStationForm.stdStationDto.stationowner}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.schedulerange"/><%--调度权限--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.schedulerange" name="stdStationDto.schedulerange" type="text" value="${stdStationForm.stdStationDto.schedulerange}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.scheduledispartch"/><%--调度划分--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.scheduledispartch" name="stdStationDto.scheduledispartch" type="text" value="${stdStationForm.stdStationDto.scheduledispartch}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.displayno"/><%--显示序号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.displayno" name="stdStationDto.displayno" type="text" value="${stdStationForm.stdStationDto.displayno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.manageunitno"/><%--管理单位编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.manageunitno" name="stdStationDto.manageunitno" type="text" value="${stdStationForm.stdStationDto.manageunitno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.maintenanceunitname"/><%--运行维护班组--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.maintenanceunitname" name="stdStationDto.maintenanceunitname" type="text" value="${stdStationForm.stdStationDto.maintenanceunitname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.maintenanceunitid"/><%--权限组织机构ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.maintenanceunitid" name="stdStationDto.maintenanceunitid" type="text" value="${stdStationForm.stdStationDto.maintenanceunitid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.fstationcode"/><%--厂站编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="stdStationDto.fstationcode" name="stdStationDto.fstationcode" type="text" value="${stdStationForm.stdStationDto.fstationcode}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdStationDto.voltagelevel"/><%--电压等级--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="stdStationDto.voltagelevel" name="stdStationDto.voltagelevel" type="text" value="${stdStationForm.stdStationDto.voltagelevel}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
