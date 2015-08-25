 <%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_js.jsp"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_grid.jsp" %>
<%@ page import="com.techstar.framework.ui.web.tag.engine.BaseGridObj"%>
<%@ page language="java" buffer="18kb"%>

<html>
<head>
  <title>gridtest</title> 

  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
  <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
	
	<script type="text/javascript">
	
  	function rowChangedToChild(priColVal,gridKind,rowData){
  	 
  	    var value=  priColVal.replace("^","="); 
  	    var value2 = value.replace("id","processInstanceId");
  	    var a ="<%=request.getContextPath()%>/wfmanager.do?method=getCurrentWFTask&"+value2;
  	    var b ="wfmanager.do?method=getTaskView_right&"+value2;
  	    
  	    //alert(b);
  	    if(rowData.length>0){
  	        window.open(a,"downFrame");
  	        window.open(b,"rightFrame");
  	    }
  	}
  	
  	  function exOperation(grid){
  	  
  	      var value = grid.getPriColVal(grid.getRowsNum());
  	      alert(value);
  	      var value2 = value.split("^");
          var a = "wfmanager.do?method=endProcess&processInstanceId="+value2[2];
           window.open(a,"leftFrame");
        return true;
    }
  	   
  	
</script>
</head>
<body>
<br>
<br>
<div id='mygrid'></div>
<br>
<div id='page'></div>
</body>	
<%--������Ϣ--%>
<%
 request.setAttribute("context",request.getContextPath());

%>
</html>

<%-- ��������ڣ������ݲ��� --%>


<jhop:grid 	id="mygrid" 
			pageId="page" 
			divHeight="400" 
			busName="ProcessInstanceDto" 
			subName="general"
			pageItems="3"   
			listType="1" 
			listKind="108" 
			filterMode="2" 
			entityName=""
			isFilterRow="1" 
			isCheckBox="0"
			isTotalRow="1" 
			isOperater="1" 
			isPageSet="1"  
		  listBox="opButton#8^/wfmanager.do?method=endProcess@@@1000@@@700@@@\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u67e5\u770b@@@aotu@@@\u7ed3\u675f\u5de5\u4f5c\u6d41@@@opButton@@@2"
			queryPath="/${para}"> 
</jhop:grid>

