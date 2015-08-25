<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../common/init_tag.jsp"%>
<%@ page import="java.util.*" %>
 <%
	String path = request.getContextPath();
%> 
 <html>
<head>
<html:base/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>列表互相挪动页面</title>
<link href="<%=path %>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
  <%
							     Map startData=new HashMap();
							     startData.put("北京","beijing");
							     startData.put("天津","tianjin");
							     startData.put("上海","shanghai"); 
							     startData.put("重庆","chongqiong");
							     startData.put("武汉","wuhan");
							     startData.put("厦门","xiamen");
							     startData.put("南京","nanjing");
							     startData.put("拉萨","lasa");
							     startData.put("昆明","kunming");
							     startData.put("郑州","zhengzhou");
							     startData.put("大理","dali");
							     Map endData=new HashMap();
                          %>
   <jhop:optiontransfer endData="<%=endData %>"   startData="<%=startData %>" title="列表互动"></jhop:optiontransfer>

</body>
</html>