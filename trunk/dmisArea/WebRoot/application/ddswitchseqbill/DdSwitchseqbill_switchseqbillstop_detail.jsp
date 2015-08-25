<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ include file="/common/init_tag.jsp"%>
<html>
	<head>
		<html:base />
		<title>调度操作票详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script type="text/javascript">
	   
	   
		function GetData(type){
			if(type != "cancel"){
			    
				var url = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=DDstopswitchseqbill";
				document.all.ddSwitchseqbillForm.action = url;
				document.all.ddSwitchseqbillForm.submit();
			}
			window.close();
		}
	</script>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_switchseqbillstop_detail.js"></script>
	</head>
	<body>
		<html:javascript formName="ddSwitchseqbillForm" />
		<logic:messagesPresent message="true">
			<html:messages id="message" message="true" header="messages.header"
				footer="messages.footer">
				<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	
			</html:messages>
		</logic:messagesPresent>
		<form name="ddSwitchseqbillForm" action="" method="post">
			<%--hidden--%>
			<input type="hidden" name="fcomputerno">
			<input type="hidden" name="ddSwitchseqbillDto.fcomputerno"
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fcomputerno}">
			<input type="hidden" name="ddSwitchseqbillDto.version"
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.version}">

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanela9835f2bd0e8476895fd878ed3ef4353"
				title="操作票终止">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanela9835f2bd0e8476895fd878ed3ef4353">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.fstopreason" />
									<%--操作终止原因--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddSwitchseqbillDto.fstopreason'
										name='ddSwitchseqbillDto.fstopreason' rows='3' cols='50'
										type="_moz">${ddSwitchseqbillForm.ddSwitchseqbillDto.fstopreason}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									&nbsp;
								</td>

							</tr>





							</tr>

						</table>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>
						<input type="Button" class="inputbutton" name="btnOK" value="确定"
							onClick="GetData('ok');">
					</td>
					<td>
						<input type="Button" class="inputbutton" name="btnCancel"
							value="取消" onClick="GetData('cancel');">
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
		var param=window.dialogArguments;
		document.getElementById("fcomputerno").value = param.id;
	</script>
</html>
