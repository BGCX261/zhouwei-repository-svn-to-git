<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>日计划详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%--<html:javascript formName="rijihuaForm"/>--%>
<table class="detailmain" cellspacing="0" cellpadding="0">
<form name="rijihuaForm" action="" method="post">
	<tr id="table0"><td align="center">
		<table class="detail" width="100%" height="100%" cellspacing="0" >
			<tr>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.equipment"/><%--设备名称--%><span class="article_required">*</span></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.equipment" value="<c:out value='${rijihuaForm.sheDto.equipment}'/>"></td>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.voltage_level"/><%--电压等级--%></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.voltage_level" value="<c:out value='${rijihuaForm.sheDto.voltage_level}'/>"></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.line"/><%--线路--%></td>
			  <td height="23"><input type="text" name="sheDto.line" value="<c:out value='${rijihuaForm.sheDto.line}'/>"></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_date"/><%--申请日期--%></td>
			  <td height="23"><input type="text" name="sheDto.apply_date" value="<c:out value='${rijihuaForm.sheDto.apply_date}'/>"></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.job_content"/><%--工作内容--%></td>
			  <td height="23" colspan="3"><textarea name="sheDto.job_content" cols="80" rows="4"><c:out value='${rijihuaForm.sheDto.job_content}'/></textarea></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_begin_date"/><%--申请工作起始时间--%></td>
			  <td height="23"><input type="text" name="sheDto.apply_begin_date" value="<c:out value='${rijihuaForm.sheDto.apply_begin_date}'/>"></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_end_date"/><%--申请工作终止时间--%></td>
			  <td height="23"><input type="text" name="sheDto.apply_end_date" value="<c:out value='${rijihuaForm.sheDto.apply_end_date}'/>"></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.status"/><%--状态--%></td>
			  <td height="23"><input type="text" name="sheDto.status" value="<c:out value='${rijihuaForm.sheDto.status}'/>"></td>
			  <td height="23" class="tab_0">&nbsp;</td>
			  <td height="23"></td>
		    </tr>
		</table>
	</td></tr>
	</form>
</table>

</body>
<script language="javascript">
	function callHunter(){
		var data;
		data = {
			 "type":"zzmm",
			 "fatherId":""
		};
		SystemDicHunter.hunter(data,callBackHunter);
	}
	function callBackHunter(data){
			for (var i=0; i< data.length; i++){
				var bean = data[i];	
				var select = document.getElementById("select111");
				select.options[i]=new  Option(bean.NAME, bean.CODE); 			
			}
	}
	
</script>
</html>
