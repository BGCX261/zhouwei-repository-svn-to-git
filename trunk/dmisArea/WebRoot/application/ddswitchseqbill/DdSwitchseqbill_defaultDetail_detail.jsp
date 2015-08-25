<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
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
			src="<%=request.getContextPath()%>/components/tag/grid/script/validate.js"></script>
		
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_defaultDetail_detail.js"></script>
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

			<input type="hidden" name="ddSwitchseqbillDto.fcomputerno"
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fcomputerno}">
			<input type="hidden" name="ddSwitchseqbillDto.version"
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.version}">
			<input type="hidden" name="ddSwitchseqbillDto.fistypicalbill"
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fistypicalbill}">
			<input type="hidden" name="ddSwitchseqbillDto.sys_fille" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_fille}">	
				
			<input type="hidden" name="ddSwitchseqbillDto.sys_filldept" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_filldept}">
			<input type="hidden" name="ddSwitchseqbillDto.sys_filltime" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_filltime}">
				
			<input type="hidden" name="ddSwitchseqbillDto.sys_isvalid" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_isvalid}">
			<input type="hidden"	name="ddSwitchseqbillDto.sys_dataowner" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.sys_dataowner}">	
			<input type="hidden"	name="ddSwitchseqbillDto.fsrcbillno" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fsrcbillno}">
			<input type="hidden"	name="ddSwitchseqbillDto.fbillsource" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fbillsource}">
			<input type="hidden"	name="ddSwitchseqbillDto.fstatus" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstatus}">	
			<input type="hidden"	name="ddSwitchseqbillDto.fexcutestatus" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fexcutestatus}">	
			<input type="hidden"	name="ddSwitchseqbillDto.fstationname" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstationname}">	
			<input type="hidden"	name="ddSwitchseqbillDto.fvoltage" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fvoltage}">	
			<input type="hidden"	name="ddSwitchseqbillDto.flinename" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.flinename}">	
			<input type="hidden"	name="ddSwitchseqbillDto.fstepcounts" 
				value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fstepcounts}">	
				
				
				
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel7cf708f768c940598d85ccc5b9614bb1"
				title="调度操作票">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel7cf708f768c940598d85ccc5b9614bb1">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.fdate" />
									<%--操作日期--%>
								</td>


								<td height="23" width="30%">
									<jhop:date name="ddSwitchseqbillDto.fdate" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="${ddSwitchseqbillForm.ddSwitchseqbillDto.fdate}"></jhop:date>
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.fmanualno" />
									<%--执行编号--%>
								</td>


								<td height="23" width="30%">
									<input id="ddSwitchseqbillDto.fmanualno"
										name="ddSwitchseqbillDto.fmanualno" type="text"
										value="${ddSwitchseqbillForm.ddSwitchseqbillDto.fmanualno}"
										size="10" />
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.fmission" />
									<%--操作任务--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddSwitchseqbillDto.fmission'
										name='ddSwitchseqbillDto.fmission' rows='3' cols='50' 
										type="_moz">${ddSwitchseqbillForm.ddSwitchseqbillDto.fmission}</textarea>
								</td>

							</tr>
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddSwitchseqbillDto.fremark" />
									<%--备注--%>
								</td>


								<td height="23" width="30%" colspan="3">
									<textarea id='ddSwitchseqbillDto.fremark'
										name='ddSwitchseqbillDto.fremark' rows='3' cols='50'
										type="_moz">${ddSwitchseqbillForm.ddSwitchseqbillDto.fremark}</textarea>
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
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d"
				title="操作步骤" isEdit="yes">

				<img name='add'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
					onClick="iGrid.mygrid.addNewRow()">
				<img name='insert'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
					onClick="iGrid.mygrid.insertRowBefore(0)">
				<img name='save'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
					onClick="var parentid = document.getElementById('ddSwitchseqbillDto.fcomputerno').value;saveDTOS('<%=request.getContextPath()%>/ddSwitchseqbill.do?method=saveSeqbilldetailGrid',iGrid.mygrid,parentid,false,'',true)">

				<img name='del'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
					onClick="deleteDTOS('<%=request.getContextPath()%>/ddSwitchseqbill.do?method=deleteSeqbilldetailGrid',iGrid.mygrid,'foperationstepno','version')">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" height="150"
				cellpadding="0"
				id="UIControlGroupXPanelac9ff0c612e7436ab2da51151b3a499d">
				<tr>
					<td align="center" height="150">
						<iframe name="iGrid" frameborder='0' width="100%" 　scrolling="no"
							height="150"
							src='<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_switchseqbillsteps_grid.jsp?fcomputerno=${ddSwitchseqbillForm.ddSwitchseqbillDto.fcomputerno}'></iframe>

					</td>
				</tr>
			</table>
		</form>
	</body>
</html>