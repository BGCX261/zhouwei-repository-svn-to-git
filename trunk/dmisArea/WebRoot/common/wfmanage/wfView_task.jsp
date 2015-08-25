<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_js.jsp"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_grid.jsp" %>
<html>
<head>
  <title>gridtest</title> 

  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
	
		<script type="text/javascript">
		
	  	  function exOperation(grid,colName){
	  	  var value = grid.getPriColVal(grid.getRowsNum());
  	    var value2 = value.split("^");
  	    var v =value2[2];
  	    
  	    var url="";
  	    
  	   if(colName=="opButton"){
  	    
  	        url = "<%=request.getContextPath()%>/resourcetree.do?method=initRoleTree&node_id="+value2[2]+"&processdefId="+<%=request.getParameter("processdefId")%>
  	   }
  	   if(colName=="opButton_2"){
  	        url = "<%=request.getContextPath()%>/resourcetree.do?method=initUserView&node_id="+value2[2]+"&processdefId="+<%=request.getParameter("processdefId")%>
  	   }
  	   if(colName=="opButton_3"){
  	        url = "<%=request.getContextPath()%>/wfmanager.do?method=initNodeMessage&tasktype=1&type=12&node_id="+value2[2]+"&processdefId="+<%=request.getParameter("processdefId")%>
  	   }
  	   
  	     window.open(url); 
         return true;
    }
  	   
  	
</script>
</head>
<body>
<br>
<br>
<div id='listright'></div>
<br>
<div id='page'></div>
</body>	
</html>

<jhop:grid 	id="listright" 
			pageId="page" 
			divHeight="400" 
			busName="TaskDto" 
			subName="general"
			pageItems="3"   
			listType="3"
			listKind="101" 
			filterMode="2" 
			entityName=""
			isFilterRow="1" 
			isTotalRow="1" 
			 listBox="opButton#8^${role_link}@@@1000@@@700@@@\u914d\u7f6e\u89d2\u8272@@@aotu@@@\u914d\u7f6e\u89d2\u8272@@@opButton@@@2,opButton_2#8^${agent_link}@@@1000@@@700@@@����Ʊ����@@@auto@@@\u914d\u7f6e\u4ee3\u7406@@@opButton_2@@@2,opButton_3#8^/wfmanager.do?method=getWFView_Task&type=12@@@1000@@@700@@@����Ʊ����@@@auto@@@\u901a\u77e5\u914d\u7f6e@@@opButton_3@@@2"
			isOperater="1" 
			queryPath="${para}"> 
</jhop:grid>
