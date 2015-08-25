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
	
	  function exOperation(grid){
  	      alert("#####");
  	      var value = grid.getPriColVal(grid.getRowsNum());
  	      alert(value);
  	      var argent_role = value.split("^");
  	      alert(argent_role);
          var a = "wfmanager.do?method=updateWFTaskRoles&processdef_id=<%=request.getParameter("processdef_id")%>&taskdef_id=<%=request.getParameter("taskdef_id")%>&argent_role="+argent_role;
          //alert(a);
        return true;
      }
	  
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
			 var a = "wfmanager.do?method=updateWFTaskRoles&processdef_id=<%=request.getParameter("processdef_id")%>&taskdef_id=<%=request.getParameter("taskdef_id")%>&argent_role="+users;
			 alert(a);
			 window.open("<%=request.getContextPath()%>/"+a,"rightFrame");
		}
  	   
	</script>
</head>
<body>
<br>
<br>
<div id='mygrid'></div>
<br>
<div id='pageArea'></div>
<input name="test" type="button" value="选 择" onClick="getSelectedUsers()">
</body>	

</html>

<%
  String processdef_id = request.getParameter("processdef_id");
  String taskdef_id = request.getParameter("taskdef_id");
  String unit_id = request.getParameter("unit_id");
  request.setAttribute("processdef_id",processdef_id);
  request.setAttribute("taskdef_id",taskdef_id);
  request.setAttribute("unit_id",unit_id);
  
%>
 <jhop:grid 	id="mygrid" 
			pageId="pageArea" 
			divHeight="300" 
			busName="UserOut" 
			subName="general"
			pageItems="5"   
			listType="3"
			listKind="101" 
			filterMode="2" 
			entityName=""
			isFilterRow="1" 
			isTotalRow="1" 
			listBox="opButton#8^${role_link}@@@1000@@@700@@@\u914d\u7f6e\u89d2\u8272@@@aotu@@@\u914d\u7f6e\u89d2\u8272@@@opButton"
			isOperater="1"
			isPageSet="1"  
			queryPath="/resourcetree.do?method=getUserList&processdef_id=${processdef_id}&taskdef_id=${taskdef_id}&unit_id=${unit_id}"> 
</jhop:grid>

