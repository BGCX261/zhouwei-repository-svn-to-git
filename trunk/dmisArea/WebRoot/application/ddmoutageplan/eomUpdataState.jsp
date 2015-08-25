<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>

<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
	<head>
		<title></title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
	</head>
	<body>

		<form name="ddMoutageplanForm">

			<td height="23" class="tab_0" width="20%">
				<bean:message key="object.ddMoutageplanDto.funfinishreason" />
				<%--月计划编号--%>
			</td>
			<td height="23" width="30%">
				<input id="ddMoutageplanDto.funfinishreason"
					name="ddMoutageplanDto.funfinishreason" type="text"
					value="${ddMoutageplanForm.ddMoutageplanDto.fmonthplanno}"
					size="30" />
			</td>


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
		<br>
	</body>
	<script>

    function enterData(type){
		
	    if(type != "cannel"){		
			 var  getValue=document.getElementById('ddMoutageplanDto.funfinishreason').value;	
		     window.returnValue 	= getValue;
		     window.close();
			}
			else window.close();
     }

</script>
</html>
