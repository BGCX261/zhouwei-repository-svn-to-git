<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<tiles:importAttribute/>
<bean:define id="Title1" name="title1" type="String"/>
<bean:define id="Title2" name="title2" type="String"/>
<html>
<head>
<html:base/>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="../themes/themes1/style.css" rel="stylesheet" type="text/css">
<%@ include file="/common/init_js.jsp" %>
<tiles:insert attribute="subtable"/>
<!-- <%@ include file="../demo/rijihua/zhuzibiao.jsp" %> -->

</head>

<body onLoad="adjustIFrameSize('grid');">
<jhop:ctrlgroup ctrlId="detailDiv" title="<%=Title1%>"></jhop:ctrlgroup>
<div id="detailDiv">
<tiles:insert attribute="content1"/>
</div>


<table class="detailmain" cellspacing="0" cellpadding="0" width="100%">
<tr bgcolor="#E3E3E3"> 
	<td width="80%"><strong><%=Title2%></strong></td>
	<td  align="right"><input type="button" class="inputbutton" name="save" value="保存" onClick="saveorupdaterows()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="inputbutton" name="save" value="删除" onClick="deleterows()"/>&nbsp;&nbsp;&nbsp;&nbsp;
</tr>
<tr>
	<td colspan="2">
	<iframe id="grid" name="grid" frameborder='0' width='100%' scrolling="no" src='<%=request.getContextPath()%><tiles:getAsString name="content2"/>&refId=<%=request.getAttribute("refId")%>'></iframe>
	</td>
</tr>
</table>

</body>
</html>