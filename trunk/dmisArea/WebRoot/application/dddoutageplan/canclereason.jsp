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
		<title>日计划取消</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_defaultDetail_detail.js"></script>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">


	</head>


	<body>
		   <form>
		 
			<input type="hidden" name="stdUnfinishreasonDto.id"
				value="${stdUnfinishreasonDto.id}">
			<input type="hidden" name="stdUnfinishreasonDto.version"
				value="${stdUnfinishreasonDto.version}">
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelebc3d44793cf45c5b0689e7b5a59674f">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
								<tr>
								<td height="23" class="tab_0" width="10%">
									取消原因
									<%--停电范围--%>
									<span class="article_required">*</span>
								</td>
								<td height="23" width="30%" colspan="3">
									<textarea id='stdUnfinishreasonDto.reason2'
										name='reason' rows='3' cols='50'
										type="_moz">${stdUnfinishreasonDto.reason2}</textarea>
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
			</table>
			</form>
			<table>
			<td>
				<div align="right">
					<input type="button" name="button" value="  确 认  "
						onClick="enterData('enter')">
					<input type="button" name="button" value="  取 消  "
						onClick="enterData('cannel')">
				</div>
			</td>
		</table>
	</body>
	<script>

 	  /**
		*  提交数据到父页面,快捷查询时使用

		*  返回数组类型
		*  格式: 英文列名#第一列值,第二列值,第三列值....
		*/
		function enterData(type){
			if(type != "cannel"){
			// var  datas = document.getElementById('reason').value;
	         var  datas = new Object();
	         datas.id = document.getElementById('stdUnfinishreasonDto.id').value;
	         datas.version = document.getElementById('stdUnfinishreasonDto.version').value
	         datas.reason = document.getElementById('stdUnfinishreasonDto.reason2').value
		     window.returnValue = datas;
			}
			window.close();
		}
	</script>
</html>
