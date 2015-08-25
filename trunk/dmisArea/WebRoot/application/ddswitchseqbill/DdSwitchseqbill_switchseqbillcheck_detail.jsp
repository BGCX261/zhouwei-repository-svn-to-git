<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<jsp:directive.page import="com.techstar.dmis.helper.BusinessDetailHelper;"/>
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
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_switchseqbillcheck_detail.js"></script>
		<%
		
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
			String cur_date = formatter.format(currentTime); //将日期时间格式化
			
			String parentid = request.getParameter("FComputerNo");
			
			String curuser = new BusinessDetailHelper().getBusDetailInfo(request).getUserName();
			
			request.setAttribute("fcomputerno", parentid);
			//request.setAttribute("curuser",curuser);
		%>
		<script type="text/javascript">
	   
	   
		function GetData(type){
			if(type != "cancel"){
			    
				var url = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=SaveSeqbillCheck";
				document.all.ddSwitchseqbillForm.action = url;
				document.all.ddSwitchseqbillForm.submit();
			}
			window.close();
		}
	</script>
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
				ctrlId="UIControlGroupXPanelbb7ca626ff6d4dfdaf0877aa5ce9339c"
				title="操作票合格情况核定">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelbb7ca626ff6d4dfdaf0877aa5ce9339c">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.ispassed" />
									<%--是否合格--%>
								</td>


								<td height="23" width="35%">
									<jhop:select name="ddSwitchseqbillDto.ispassed" type="text"
										initValue="是@@@是#否"></jhop:select>

								</td>


								<td height="23" class="tab_0" width="15%">
									<bean:message key="object.ddSwitchseqbillDto.reason" />
									<%--不合格原因--%>
								</td>


								<td height="23" width="30%">
									<textarea id='ddSwitchseqbillDto.reason'
										name='ddSwitchseqbillDto.reason' rows='3' cols='50'
										type="_moz">${ddSwitchseqbillForm.ddSwitchseqbillDto.reason}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.passedchecker" />
									<%--合格情况检查人--%>
								</td>


								<td height="23" width="30%">
									<input id="ddSwitchseqbillDto.passedchecker"
										name="ddSwitchseqbillDto.passedchecker" type="text"
										value="${ddSwitchseqbillForm.ddSwitchseqbillDto.passedchecker}"
										size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.passchecktime" />
									<%--合格情况检查时间--%>
								</td>


								<td height="23" width="30%">
									<jhop:date name="ddSwitchseqbillDto.passchecktime"
										genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss"
										initValue="${ddSwitchseqbillForm.ddSwitchseqbillDto.passchecktime}"></jhop:date>
								</td>

							</tr>
							</tr>

						</table>
					</td>
				</tr>
				<tr></tr>
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
	   //审核人

	   document.getElementById("ddSwitchseqbillDto.passedchecker").value = '<%=curuser%>';
	   //系统时间
	   var curdate = new Date();
	   
	   document.getElementById('ddSwitchseqbillDto.passchecktime').value = '<%=cur_date%>';
	</script>
</html>
