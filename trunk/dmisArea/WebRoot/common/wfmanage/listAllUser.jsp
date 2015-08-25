 <%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_js.jsp"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_grid.jsp" %>
<%@ page language="java" buffer="18kb"%>

<html>
<head>
  <title>gridtest</title> 

  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	
	<script type="text/javascript">

	  function getSelectedUsers(){
			var rows = mygrid.getSelectedRows();
			var users="";
			for (row = 0;row<rows.length;row++){
				var colValue = mygrid.getValByRC(rows[row],'USERNAME');
				if (row == 0){
					users = colValue;
				}else{
					users += "," + colValue;
				}
			}
			alert(users);		
		
			var url = "<%=request.getContextPath()%>/wfmanager.do?method=getWFView_Message&"+
	"tasktype="+<%=request.getParameter("tasktype")%>+"&node_id="+
	<%=request.getParameter("taskdef_id")%>+"&processdefId="+
	<%=(String)request.getAttribute("processdef_id")%>+
	"&receiver="+users;
			   //alert("url="+url);  
			    window.open(url,"upFrame");
		}
  	   function onQuery(){
	   		var username = document.getElementById("username").value;
	   		var url = "<%=request.getContextPath()%>/resourcetree.do?method=initGetUserListByName"+
			"&taskdef_id=<%=(String)request.getAttribute("taskdef_id")%>"+
			"&processdef_id=<%=(String)request.getAttribute("processdef_id")%>&username="+encodeURI(username);
			this.location.href = url;
	   }
	</script>
</head>
<body>
用户名：
<input type="text" name="username">
<input type="button" name="query" value="查询" onClick="onQuery();">
<br>
<br>
<div id='mygrid'></div>
<br>
<div id='pageArea'></div>
<input name="test" type="button" value="选 择" onClick="getSelectedUsers()">
</body>	

</html>

 <jhop:grid 	id="mygrid" 
			pageId="pageArea" 
			divHeight="300" 
			busName="UserOut" 
			subName="general"
			pageItems="10"   
			listType="3"
			listKind="101" 
			filterMode="2" 
			entityName=""
			isFilterRow="1"
			isTotalRow="1" 
			listBox=""
			isOperater="1"
			isPageSet="1"  
			queryPath="/resourcetree.do?method=getUserListByName&processdef_id=${processdef_id}&taskdef_id=${taskdef_id}&username=${username}"> 
</jhop:grid>

