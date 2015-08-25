<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="../../common/taglibs.jsp"%>
<c:if test="${sessionScope.list != null}">
	<c:set var="list_req" value="${sessionScope.list}" scope="request"/>
</c:if>
<%
String ctx = request.getContextPath();
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="<%=ctx%>/common/css/screen.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
table {
	border:#9CB2DE solid;border-width:1px 0px 0px 1px
}
table td{
	font-size:9pt;
	line-height:1.2;
	padding:5px;
	border:#9CB2DE solid;border-width:0px 1px 1px 0px;	
	
}
-->
</style>

  <head>
    <html:base />
    <title>applylist.jsp</title>    
    <script language="javascript">
    	function add(){
    		window.location.href="<%=ctx%>/dictionary.do?method=initAdd&poName=Company";
    	}
    	
    	function del(str){
    		vbcon=confirm("确定要删除该条记录吗？",1);
   			if ( vbcon ){
    			window.location.href="<%=ctx%>/dictionary.do?method=delete&poName=Company&id="+str;
    		}
    	}
		function onModify(str){
			window.location.href="<%=ctx%>/dictionary.do?method=initModify&poName=Company&id="+str;
		}
    </script>
  </head>
  
  <body>
  	 <div align="center"><font color="red"> <c:out value="${msg}"></c:out></font></div>
	  <div align="center"><html:button property="add" onclick="return add();">增加新公司</html:button></div>
	  <br>
	<table border=1 cellPadding=0 cellSpacing=0 width="80%" align="center">
	  
	  <tr>
	    <td bgColor=#ffffff width="100%">
	    <display:table  name="list_req" id="companyInfo" defaultsort="1"  pagesize="10" width="100%" >						
				<display:column  property="id"  title="内部序号"  sortable="true" height="30" />							
				<display:column  property="companyName"  title="公司名称"  sortable="true" height="30" />
				<display:column  title="操作" sortable="false" align="center" >
					<input type="button" name="modify" value="修改" onClick="onModify('<c:out value="${companyInfo.id}"/>');" />
		   			<input type="button" name="delete" value="删除" onClick="return del('<c:out value="${companyInfo.id}"/>');" />
				</display:column>
		</display:table>
	 	</td>
	  </tr>
	  
	</table>
  </body>

