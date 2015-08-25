<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<html>
	<head>
		<html:base />
		<title>运行记事详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		
	</head>
	<body>
		<html:javascript formName="ddCutofftitleForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
			</html:messages>
		</logic:messagesPresent>

		<jhop:ctrlgroup
			ctrlId="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d"
			title="操作步骤" isEdit="yes">

			<img name='add'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
				onClick="mygrid.addNewRow()">
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="saveDTOS('<%=request.getContextPath()%>/ddClassondutylog.do?method=saveddOperationnotebookGrid',iGrid.mygrid,'',false,'',true)">

			<img name='del'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="deleteDTOS('<%=request.getContextPath()%>/ddClassondutylog.do?method=deleteddOperationnotebookGrid',iGrid.mygrid,'fid','version')">
		</jhop:ctrlgroup>
		
		<%
		 String fid = (String) request.getParameter("fid"); 
		 request.setAttribute("fid",fid); 
		 String canadd = (String) request.getParameter("canadd"); 
		 request.setAttribute("canadd",canadd); 
		 
		%>

		<table class="detailmain" cellspacing="0" cellpadding="0">
			<tr id="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d">
				<td align="center">
					<table class="detail" width="100%" height="100%" cellspacing="0">
						<tr>
							<td align="center" height="150">
								<iframe name="iGrid" frameborder='0' width="100%"
									　scrolling="no" height="300"
									src='<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_ddRunrecord_grid.jsp?canadd=${canadd}&fid=&{fid}'></iframe>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		
	//控制图片		
	
		if("<%=canadd%>" =="false"){
	   		document.getElementById("add").style.visibility="hidden";	
	   		document.getElementById("save").style.visibility="hidden";	
	   		document.getElementById("del").style.visibility="hidden";	
   		}
   		else{
   			document.getElementById("add").style.visibility="visible";	
	   		document.getElementById("save").style.visibility="visible";	
	   		document.getElementById("del").style.visibility="visible";	
   		}
   
		</script>
	</body>
	
</html>
