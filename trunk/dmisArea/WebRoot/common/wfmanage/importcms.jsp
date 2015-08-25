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

</head>
<body>
	<script type="text/javascript">
	
	 function importcms_submit(){
	 
	    var url ="<%=request.getContextPath()%>/wfmanager.do?method=importcmsinfo&submit=1";
	    alert(url);
	    this.form1.action = url;
	    this.form1.submit();
  	 
   }
	
    </script>


<form action="" method="post" enctype="multipart/form-data" name="form1" onsubmit="importcms_submit();">
 <table>
    <tr><td><bean:message key="wf.view.importcms_file"/></td>
    </tr>
 <tr>
 <td>
  <label>
     <input type="file" name="wf_cmsfile">
  </label> </td>
<td>
   <input type="submit" name="uploadcms" value="<bean:message key="wf.view.submit"/>">
   </td></tr>
   </table>
</form>

<br>
<br>
<div id='mygrid'></div>
<br>
<div id='page'></div>
</body>	

</html>



