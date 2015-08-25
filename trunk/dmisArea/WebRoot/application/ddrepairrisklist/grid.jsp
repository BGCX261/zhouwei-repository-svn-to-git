<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<%
	request.setAttribute("mainid", request.getParameter("mainid"));
%>
<html>
	<head>
		<title>gridtest</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">

	</head>
	<body>
		<jhop:ctrlgroup ctrlId="table0" title="预案列表" isEdit="yes">
			<img name='del'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick=reiGridDown()>
		</jhop:ctrlgroup>
		<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
			<iframe name="iGridUp" frameborder='0' height="220" width='100%'
				scrolling="yes"
				src='<%=request.getContextPath()%>/application/ddrepairrisklist/Top_Grid.jsp?&mainid=${mainid}'></iframe>
		</table>

		<jhop:ctrlgroup name="grid" ctrlId="table1" title="预案内容">
		</jhop:ctrlgroup>
		<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
			<iframe name="iGridDown" frameborder='0' height="220" width='100%'
				scrolling="yes"></iframe>
		</table>


		<script>			
	    
	    //改变子表信息与主表连动


		function rowChangedToChild(priColVal,gridKind,data){
		    var cooname="";
			var rows =iGridUp.mygrid.getSelectedRows();
		    var dataStr = iGridUp.mygrid.getSelectedRowsData(3);
			if(rows){		 
    			var fpremethodid = iGridUp.mygrid.getValByRC(rows[0],'fpremethodid');
    			//把所选的记录的 name 和 date 附给变量    			      
    			iGridDown.location=encodeURI('<%=request.getContextPath()%>/ddPremethod.do?method=showContent&fpremethodid='+fpremethodid);
    		};
    		
		}
		function reiGridDown(){
		        deleteDTOS('<%=request.getContextPath()%>/ddPremethod.do?method=deleteModechangeGrid',iGridUp.mygrid,'fpremethodid','version');
		        iGridDown.location=encodeURI('<%=request.getContextPath()%>/ddPremethod.do?method=showContent');
		}
		
		
</script>
	</body>
</html>
