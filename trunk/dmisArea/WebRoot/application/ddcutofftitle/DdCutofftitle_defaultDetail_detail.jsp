<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper"%>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto"%>

<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>

<%
	BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
	String dataOwnerName = bdt.getDataOwnerName();
%>



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
		<form name="ddCutofftitleForm" action="" method="post">
			<%--hidden--%>

			<input type="hidden" name="ddCutofftitleDto.fid"
				value="${ddCutofftitleForm.ddCutofftitleDto.fid}">
			<input type="hidden" name="ddCutofftitleDto.version"
				value="${ddCutofftitleForm.ddCutofftitleDto.version}">
			<input type="hidden" name="ddCutofftitleDto.cutoffname"
				value="${ddCutofftitleForm.ddCutofftitleDto.cutoffname}">
			<input type="hidden" name="ddCutofftitleDto.fstatus"
				value="${ddCutofftitleForm.ddCutofftitleDto.fstatus}">
		    <input type="hidden" name="ddCutofftitleDto.fstatus"
				value="${ddCutofftitleForm.ddCutofftitleDto.fstatus}">
		    <input type="hidden" name="ddCutofftitleDto.sys_fille"
				value="${ddCutofftitleForm.ddCutofftitleDto.sys_fille}">
		    <input type="hidden" name="ddCutofftitleDto.sys_filldept"
				value="${ddCutofftitleForm.ddCutofftitleDto.sys_filldept}">
			<input type="hidden" name="ddCutofftitleDto.sys_filltime"
				value="${ddCutofftitleForm.ddCutofftitleDto.sys_filltime}">
			<input type="hidden" name="ddCutofftitleDto.sys_isvalid"
				value="${ddCutofftitleForm.ddCutofftitleDto.sys_isvalid}">
			<input type="hidden" name="ddCutofftitleDto.iscollect"
				value="${ddCutofftitleForm.ddCutofftitleDto.iscollect}">
			<input type="hidden" name="ddCutofftitleDto.fexcutestatus"
				value="${ddCutofftitleForm.ddCutofftitleDto.fexcutestatus}">					

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanel27016a011a96499ba7549a64f5ed3c31"
				title="序位表信息">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanel27016a011a96499ba7549a64f5ed3c31">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>

								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofftitleDto.fyear" />
									<%--年度--%>
								</td>


								<td height="23" width="30%">
									<input id="ddCutofftitleDto.fyear"
										name="ddCutofftitleDto.fyear" type="text"
										value="${ddCutofftitleForm.ddCutofftitleDto.fyear}" size="10" />
								</td>


								<td height="23" class="tab_0" width="20%">
									<bean:message key="object.ddCutofftitleDto.sys_dataowner" />
									<%--数据所属单位--%>
								</td>


								<td height="23" width="30%">
									<input id="ddCutofftitleDto.sys_dataowner"
										name="ddCutofftitleDto.sys_dataowner" type="text"
										value="${ddCutofftitleForm.ddCutofftitleDto.sys_dataowner}"
										size="10" />
								</td>

							</tr>

						</table>
					</td>
				</tr>
			</table>
			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPaneled6010c25f3341fcb3e1e3aef6dab5b3"
				title="序位表明细" isEdit="yes">

				<img name='add'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
					onClick="iGrid.mygrid.addNewRow()">
				<img name='save'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
					onClick="saveDTOS('<%=request.getContextPath()%>/ddCutofftitle.do?method=saveModechangeGrid',iGrid.mygrid,false,'<%=request.getContextPath()%>/application/dddoutageplan/modechangevalidate.xml','modechange',false)">

				<img name='del'
					src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
					onClick="deleteDTOS('<%=request.getContextPath()%>/ddCutofftitle.do?method=deleteModechangeGrid',iGrid.mygrid,'fid','version')">



			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPaneled6010c25f3341fcb3e1e3aef6dab5b3">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td align="center" height="150">
									<iframe name="iGrid" frameborder='0' width="100%"
										　scrolling="no" height="300"
										src='<%=request.getContextPath()%>/application/ddcutofftitle/DdCutofftitle_sequencedetail_grid.jsp?parentid=${ddCutofftitleForm.ddCutofftitleDto.fid}'></iframe>
								</td>
							</tr>

						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<script>

    var id = document.getElementById('ddCutofftitleDto.fid').value;
    //进行初始化动作


    if (id == '' || id == null){
       //数据所属单位

       document.getElementById('ddCutofftitleDto.sys_dataowner').value = '<%=dataOwnerName%>';
    }
</script>
