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
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
	
	<script type="text/javascript">
	
  	function rowChangedToChild(priColVal,gridKind,rowData){
  	
  	    alert(priColVal);
  	     var value=  priColVal.replace("^","="); 
  	     var value2 = value.replace("id","taskinstanceId");
  	    
  	    
  	    var b ="wfmanager.do?method=getTaskView_right&"+value2;
  	    window.open(b,"rightFrame");
  	}
</script>
</head>
<body>
<div id='page'>
<div id='mygrid'></div>

 <jhop:grid 	       
  id="mygrid"          
  pageId="page"          
  divHeight="400"
  busName="TaskInstanceDto"
  subName="general"  
  pageItems="3"
  listType="3"
  listKind="101"  
  filterMode="2"   
  entityName=""  
  isFilterRow="1"
  isTotalRow="1"
  listBox=""
  isCheckBox="0"
  isOperater="1" 
  queryPath="/wfmanager.do?method=getCurrentWFTask&processInstanceId=${processInstanceId}">
 </jhop:grid>  
</div>
</body>	
</html>
  
