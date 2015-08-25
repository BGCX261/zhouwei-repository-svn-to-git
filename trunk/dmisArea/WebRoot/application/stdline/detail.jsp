<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>线路详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stdline/detail.js"></script>
</head>
<body>
<html:javascript formName="stdLineForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="stdLineForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="stdLineDto.id" value="${stdLineForm.stdLineDto.id}">
<input type="hidden" name="stdLineDto.version" value="${stdLineForm.stdLineDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanele61c19421f36465ba178aaeda639af78" title="线路"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele61c19421f36465ba178aaeda639af78">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.id"/><%--线路编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.id" name="stdLineDto.id" type="text" value="${stdLineForm.stdLineDto.id}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.stationno"/><%--起始变电站编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.stationno" name="stdLineDto.stationno" type="text" value="${stdLineForm.stdLineDto.stationno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.linename"/><%--线路名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.linename" name="stdLineDto.linename" type="text" value="${stdLineForm.stdLineDto.linename}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.manageunit"/><%--管理单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.manageunit" name="stdLineDto.manageunit" type="text" value="${stdLineForm.stdLineDto.manageunit}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.voltagelevel"/><%--电压等级--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.voltagelevel" name="stdLineDto.voltagelevel" type="text" value="${stdLineForm.stdLineDto.voltagelevel}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.stationendno"/><%--结束变电站编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.stationendno" name="stdLineDto.stationendno" type="text" value="${stdLineForm.stdLineDto.stationendno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.switchno"/><%--起始开关号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.switchno" name="stdLineDto.switchno" type="text" value="${stdLineForm.stdLineDto.switchno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.owner"/><%--产权--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.owner" name="stdLineDto.owner" type="text" value="${stdLineForm.stdLineDto.owner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.scheduleunit"/><%--调度单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.scheduleunit" name="stdLineDto.scheduleunit" type="text" value="${stdLineForm.stdLineDto.scheduleunit}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.linetype"/><%--线路类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.linetype" name="stdLineDto.linetype" type="text" value="${stdLineForm.stdLineDto.linetype}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.isconnectline"/><%--是否联络线--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.isconnectline" name="stdLineDto.isconnectline" type="text" value="${stdLineForm.stdLineDto.isconnectline}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.displayno"/><%--显示序号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.displayno" name="stdLineDto.displayno" type="text" value="${stdLineForm.stdLineDto.displayno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.manageunitno"/><%--管理单位编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.manageunitno" name="stdLineDto.manageunitno" type="text" value="${stdLineForm.stdLineDto.manageunitno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdLineDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdLineDto.version" name="stdLineDto.version" type="text" value="${stdLineForm.stdLineDto.version}" size="10"  />
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
