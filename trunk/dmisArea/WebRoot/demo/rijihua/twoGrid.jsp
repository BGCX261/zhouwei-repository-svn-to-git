<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>双表联动</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SaDtlFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/script/grid/editgrid.js"></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/script/general.js"></script>
<%@ include file="/common/init_date.jsp" %>

<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/demo/rijihua/twoGrid.js"></script>
</head>
<body>
<form name="rijihuaForm" action="" method="post">
<jhop:ctrlgroup ctrlId="table0" title="主表信息">
</jhop:ctrlgroup>
<%--<iframe name="iGrid" frameborder='0' width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initSubEditGrid&refId=salesId^string^1^${rijihuaForm.sheDto.id}^^asc'></iframe>--%>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
<iframe name="iGridUp" frameborder='0' height="200" width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initTwoGrid_grid&mainId=<%=(String)request.getAttribute("mainId")%>'></iframe>
</table>

<jhop:ctrlgroup name="grid" ctrlId="table1" title="子表信息" isEdit="yes">
	<img name='save' src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif" onClick="savegrid();">
	<img name='del' src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif" onClick="deletegrid();">
</jhop:ctrlgroup>
<%--<iframe name="iGrid" frameborder='0' width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initSubEditGrid&refId=salesId^string^1^${rijihuaForm.sheDto.id}^^asc'></iframe>--%>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
<iframe name="iGridDown" frameborder='0' height="200" width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initCardGrid_grid&refId=salesId^string^1^639697^^asc'></iframe>
</table>
</form>
</body>
</html>
