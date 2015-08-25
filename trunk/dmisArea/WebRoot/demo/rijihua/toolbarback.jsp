<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>回控工具栏</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<script>
	function disableNew()
	{
		parent.parent.upFrame.aToolBar2.disableItem("new");
	}
	function enableNew()
	{
		parent.parent.upFrame.aToolBar2.enableItem("new");
	}	
	function disableOperate()
	{
		var arra = new Array();
		arra[0] = "operation2";
		parent.parent.upFrame.disableItem(arra);
	}
	function enableOperate()
	{
		var arra = new Array();
		arra[0] = "operation2";
		parent.parent.upFrame.enableItem(arra);
	}
</script>
</head>
<body>
<form name="rijihuaForm" action="" method="post">
<table class="detailmain" cellspacing="0" cellpadding="0">
	<tr id="table0"><td align="center">
		<table class="detail" width="100%" height="100%" cellspacing="0" >
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>回控工具栏</strong></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0" width="20%">控制按钮</td>
			  <td height="23"><input type="button" class="inputbutton" value="屏蔽新增" onClick="disableNew()">			    <input type="button" class="inputbutton" value="解除屏蔽" onClick="enableNew()"></td>
			  <td height="23" class="tab_0" width="20%">控制操作列表</td>
			  <td height="23" width="30%">
			  	<input type="button" class="inputbutton" value="屏蔽“操作名称2”" onClick="disableOperate()">
			  	<input type="button" class="inputbutton" value="显示“操作名称2”" onClick="enableOperate()">
			  </td>
		    </tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
