<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
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

		<div id='mygrid'></div>

		<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>-->
	</body>
	<%--处理消息--%>
	<%
		 /*
		 if (message != null && !message.equals("") && !message.equals("null")){
	%>
	<script language="javascript">
			dealMessage('<%=message%>');
		</script>
	<%
		 }
		 */
		 String parentid = (String) request.getParameter("parentid");
		 request.setAttribute("parentid", parentid);
		 String refColVal="zddcutoffsequence5.fid^"+parentid;
		 String url="/ddCutofftitle.do?method=standGridQuery1&parentid="+parentid;
	%>
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid id="mygrid" pageId="standGridPage1"
	busName="DdCutofftitleDto1" subName="128208434031255332" pageItems="20"
	listType="2" listKind="104" isCheckBox="0" isTotalRow="0"
	divHeight="300" entityName="DdCutoffsequence"
	refColVal="<%=refColVal%>"
	queryPath="<%=url%>">
</jhop:grid>
<
<script type="text/javascript">
  function afterLoadForUser(grid){}
  
  function setParentId(){
        var si = setInterval(setParentId,500) ;
        if(mygrid){
			mygrid.setRefColVal('zddcutoffsequence5.fid^<%=parentid%>');
			clearInterval(si);
		}
   }  
</script>


