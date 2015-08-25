<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
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
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	
	
</head>
<body>
<br>
<script type="text/javascript">
//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作
function onSaveForm(contextPath) {
	/*	if (!validateZdhSequencetableForm(document.zdhSequencetableForm)){
		return false;
	}*/
	//判断是否是从详细页中的保存

	var url="<%=request.getContextPath()%>/zdhSequencetable.do?method=saveModechangeGrid";
	var valValue="<%=request.getContextPath()%>/application/zdhsequencetable/sequencetableValidate.xml"
	if(listOper.value=='importExcel')
		saveDTOS(url, mygrid, true,valValue,'validateSequencerec',false);
	

}
</script>
<br>
<div id='mygrid'></div>
<%
 	String url="/zdhSequencetable.do?method=standGridQuery";
 %>

<div id='myOperate'><input type='hidden' name='listOper' value='list'></div>
<br>
<div id='standGridPage'></div>

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
%>
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="ZdhSequencetableDto"
      subName="128201292034241320"
      pageItems="50"
      listType="3"
      listKind="101"
      entityName="ZdhSequencetable"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="<%=url %>">
</jhop:grid>