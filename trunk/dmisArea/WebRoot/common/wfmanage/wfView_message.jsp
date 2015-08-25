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
	
	 function message_submit(){
	 
	    var url ="<%=request.getContextPath()%>/wfmanager.do?method=addWFTaskMessages";
	    alert(url);
	    this.form1.action = url;
	    this.form1.submit();
  	 
   }
   
   
   	 function choiseuser(){
	     //alert("####");
	     var url = "<%=request.getContextPath()%>/resourcetree.do?method=initGetUserListByName&taskdef_id=<%=request.getParameter("node_id")%>&processdef_id=<%=request.getParameter("processdefId")%>";
  	   alert(url);
  	    window.open(url); 
   }
	
    </script>
	
</head>
<body bgcolor="#ffffff">

<table class="detailmain" cellspacing="0" cellpadding="0">
  <tr>
    <th colspan="3" class="pt" align="left" height="20">&nbsp;&nbsp;
     <bean:message key="wf.view.modelinfo"/>
    </th>
  </tr>
  <tr id="table0">
    <td align="center">
    
   
    <% 
      String content = (String)request.getAttribute("cont");
      String receiver = (String)request.getAttribute("rece");
    
    %>
   
     <form action="/wfmanager.do" method="post"  name="form1" onSubmit="message_submit();">
      <TABLE class="detail" width="100%" height="100%" cellspacing="0">
        <TBODY>
          <TR>
            <TD width="13%" bgcolor="#f6f6f6">&nbsp;<bean:message key="wf.view.modeltype"/></TD>
            <TD width="87%">
              <label>
              <input name="message_type" type="radio" value="0" size="60" checked>
              <bean:message key="wf.view.notice"/></label>
            </TD>
          </TR>
          <TR>
            <TD width=13% bgcolor="#f6f6f6" align="right">&nbsp;<bean:message key="wf.view.messagecontent"/></TD>
            <TD width="87%">
              <input type="textarea" name="content" cols="110" rows="4" value="<%=content%>">
            </TD>
          </TR>
          <TR>
            <TD width="13%" bgcolor="#f6f6f6">&nbsp;<bean:message key="wf.view.messagelist"/></TD>
            <TD width="20%">
              	<input type="text" name="receive"  size="60" value="<%=receiver%>">
      			<img src="<%=request.getContextPath()%>/themes/themes1/images/main/mag.gif" alt="<bean:message key="wf.view.rolechoise"/>" onclick="choiseuser()">   
            </TD>
          </TR>
            <TR>
            <TD width="13%" bgcolor="#f6f6f6">&nbsp;</TD>
            <TD width="20%">
              	<input type="submit" size="60" name="insentlist" value="<bean:message key="wf.view.submit"/>"/>  
            </TD>
          </TR>
          <tr>
             <td>
             <%
                 String tasktype= request.getParameter("tasktype");
                 if(tasktype==null){tasktype="0";}
             %>
             
               <input type="hidden" name="method" value="addWFTaskMessages"/>
               <input type="hidden" name="tasktype" value="<%=tasktype%>"/>
               <input type="hidden" name="task_id" value="<%=request.getParameter("node_id")%>" />
               <input type="hidden" name="processdefId" value="<%=request.getParameter("processdefId")%>" />
             </td>
          </tr>
        </TBODY>
      </TABLE>
     </form>
    </td>
  </tr>
</table>


</body>
</html>
