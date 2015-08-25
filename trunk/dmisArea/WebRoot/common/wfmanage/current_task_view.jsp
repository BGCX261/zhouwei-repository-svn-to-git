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
dsfsfdsd
<br>
<br>
<div id='mygrid'></div>
<br>
<div id='page'></div>
</body>	

</html>




