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
	
	 function importcms(){
	 	
	    var setObj = new Object();
	    var url = "/common/wfmanage/importcms.jsp";
	    showModalDialogYY(url,300,150,setObj,"import","yes");
	    
  	 
   }
	
    </script>
	
	
</head>
<body>
<form name="form1" method="post" action="" onsubmit="importcms();"> 
  <label>
  <input type="submit" name="Submit" value="<bean:message key="wf.view.importcms"/>">
  </label>
</form>
<br>
<br>
<div id='mygrid'></div>
<br>
<div id='page'></div>
</body>	

<%
 request.setAttribute("context",request.getContextPath());
%>
</html>

<jhop:grid 	       
  id="mygrid"          
  pageId="page"          
  divHeight="400"
  busName="ProcessDefinedDto"
  subName="general"  
  pageItems="3"
  listType="3"
  listKind="101"  
  filterMode="2"   
  entityName=""  
  isFilterRow="1"
   isTotalRow="1"
  listBox="opButton#8^/wfmanager.do?method=getProcessInstancesView@@@1000@@@700@@@\u5de5\u4f5c\u6d41\u5b9e\u4f8b\u67e5\u770b@@@aotu@@@工作流实例@@@opButton@@@1,opButton_2#8^/wfmanager.do?method=getWFView@@@1000@@@700@@@工作票详情@@@auto@@@工作流定义@@@opButton_2@@@1"
  isOperater="1" 
  isPageSet="1"  
  queryPath="/wfmanager.do?method=listRunningWF">
 </jhop:grid>

