<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="java.util.Map"%>
<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>

<%@ page import="com.techstar.dmis.dto.DayplancoopraterelDto" %>

<%
    DayplancoopraterelDto dto = (DayplancoopraterelDto)  request.getAttribute("dayplancoopraterelDto");
    java.sql.Date cooperatedate = dto.getCooperatedate();
    String copname = dto.getFcooperatename();
    String op = (String)request.getAttribute("op");
    if(op==null)
    	op="";
    if(copname==null)
       copname="";

 %>
<html>
	<head>
		<html:base />
		<title>日停电计划配合详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
		<%@ include file="/common/init_js.jsp"%>
		<%@ include file="/common/init_date.jsp"%>
		<script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_defaultDetail_detail.js"></script>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">


	</head>

	<body>
		<form id="coppratedetailForm" name="coppratedetailForm" method="post" action="">
		    <input type="hidden" name="opp" value='<%=op %>'>
		  	<input type="hidden" name="oldname" value='<%=copname %>'>
		   
		   <%if(cooperatedate==null){ %>
		    <input type="hidden" name="olddate" value=''>
		   <%}else{ %>
		   	 <input type="hidden" name="olddate" value='<%=cooperatedate %>'>
		   <%} %>
		  
			<table class="detailmain" cellspacing="0" cellpadding="0">
				<tr id="UIControlGroupXPanelebc3d44793cf45c5b0689e7b5a59674f">
					<td align="center">
						<table class="detail" width="100%" height="100%" cellspacing="0">
							<tr>
								<td height="23" class="tab_0" width="10%">
									配合工作名称
									<%--配合工作名称--%>
								</td>
								<td height="23" width="15%">
									<input id="coppetatename"
										name="name" type="text"
										value="<%=copname %>" size="10" />
									
								</td>

							</tr>
							<tr>
								<td height="23" class="tab_0" width="10%">
									配合工作日期
									<%--配合工作日期--%>
								</td>
								
								<td height="23" width="30%">
								   <%if(cooperatedate==null){ %>
									<jhop:date name="date" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue=""></jhop:date>
									<%}else{ %>
									
									<jhop:date name="date" genText="yes"
										dateFormat="yyyy-mm-dd"
										initValue="<%=cooperatedate.toString() %>"></jhop:date>
									<%} %>
								</td>
								
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script>
		var si=setInterval(initValue,1000) ;
		    function initValue(){
		       //document.all.coppratedetailForm.date.id="coppetatedate";
		       var name=(document.getElementById("coppetatename")).value;
		       var dat=(document.getElementById("eventdate")).value;
		       if(name&&dat){
		    		parent.cooname=name;
	                parent.coodate=dat;
		    		clearInterval(si);
		    	}
		    }
	</script>
</html>
