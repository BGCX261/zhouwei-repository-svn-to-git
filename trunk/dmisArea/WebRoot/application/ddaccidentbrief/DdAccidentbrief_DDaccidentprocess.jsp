<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<html>
	<head>
		<html:base />
		<title>拉路序位信息详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddcutofftitle/DdCutofftitle_defaultDetail_detail.js"></script>
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
			ctrlId="UIControlGroupXPaneled6010c25f3341fcb3e1e3aef6dab5b3"
			title="序位表明细" isEdit="yes">

			<img name='add'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
				onClick="iGrid.mygrid.addNewRow()">
			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="saveDTOS('<%=request.getContextPath()%>/ddAccidentbrief.do?method=saveModechangeGrid',iGrid.mygrid,false,'<%=request.getContextPath()%>/application/dddoutageplan/modechangevalidate.xml','modechange',false)">

			<img name='del'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="deleteDTOS('<%=request.getContextPath()%>/ddAccidentbrief.do?method=deleteModechangeGrid',iGrid.mygrid,'fstepid','version')">



		</jhop:ctrlgroup>
		
		<%
		 String parentid = (String) request.getParameter("mainId"); 
		 request.setAttribute("parentid",parentid); 
		%>

		<table class="detailmain" cellspacing="0" cellpadding="0">
			<tr id="UIControlGroupXPaneled6010c25f3341fcb3e1e3aef6dab5b3">
				<td align="center">
					<table class="detail" width="100%" height="100%" cellspacing="0">
						<tr>
							<td align="center" height="150">
								<iframe name="iGrid" frameborder='0' width="100%"
									　scrolling="no" height="300"
									src='<%=request.getContextPath()%>/application/ddaccidentbrief/DdAccidentbrief_DDaccidentprocess_grid.jsp?parentid=${parentid}'></iframe>
							</td>
						</tr>

					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
