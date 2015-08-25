<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<tiles:importAttribute/>
<html>
<head>
<html:base/>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="../themes/themes1/style.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
</head>
<body>
<jsp:include page="/common/message.jsp"/>
<tiles:insert attribute="tab"/>
</body>
</html>