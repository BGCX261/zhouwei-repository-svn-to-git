<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_js.jsp"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_grid.jsp" %>
<%@ page import="com.techstar.framework.ui.web.tag.engine.BaseGridObj"%>
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
  <meta name="KEYWORDS" content="dhtmlxgrid, dhtml grid, javascript grid, javascript, DHTML, grid, grid control, dynamical scrolling, xml, AJAX, API, cross-browser, checkbox, XHTML, compatible, gridview, navigation, script, javascript navigation, web-site, dynamic, javascript grid, dhtml grid, dynamic grid, item, row, cell, asp, .net, jsp, cold fusion, custom tag, loading, widget, checkbox, drag, drop, drag and drop, component, html, scand">
  <meta name="DESCRIPTION" content="Cross-browser DHTML grid with XML support and powerful API. This DHTML JavaScript grid can load its content dynamically from server using AJAX technology.">

    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>

</head>
<script>
		function onSaveForm(contextPath){
			url = contextPath + "/ui.do?method=saveChildCard";
			document.all.saleBillForm.action = url;
			document.all.saleBillForm.submit();
		}
//���������������������onResetForm������������������������������������������������
		function onResetForm(contextPath){
			document.all.saleBillForm.reset();
		}
		
		function rowChangedToChild(priColVal,gridKind,data){
			if(data != null && data != "undefined" && data != ""){
				if(data.indexOf("@@@") != -1){
					var dataArra = data.split("@@@");
					for(var i=0;i<dataArra.length;i++){
						if(dataArra[i].indexOf("^") != -1){
							var innerArra = dataArra[i].split("^");
							var name 	= innerArra[0];
							var value 	= innerArra[1];
							if(document.getElementById("saleBillDto."+name)){
								document.getElementById("saleBillDto."+name).value = value;
							}
						}
					}
				}
			}
		}
	</script>
<body>    
<br>
<form name="saleBillForm" action="" method="post">
<jhop:ctrlgroup ctrlId="table0" title="主表信息">
</jhop:ctrlgroup>
<%--<iframe name="iGrid" frameborder='0' width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initSubEditGrid&refId=salesId^string^1^${rijihuaForm.sheDto.id}^^asc'></iframe>--%>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
<iframe name="iGridUp" frameborder='0' height="220" width='100%' scrolling="no" src='<%=request.getContextPath()%>/components/tag/grid/mainGridDemo.jsp'></iframe>
</table>
<input type="hidden" name="saleBillDto.id" value="<c:out value='${saleBillForm.saleBillDto.id}'/>">
<input type="hidden" name="saleBillDto.version" value="<c:out value='${saleBillForm.saleBillDto.version}'/>">
<jhop:ctrlgroup name="card" ctrlId="table1" title="子卡片信息" isEdit="no">
	<img name='new' src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif" onClick="addCard('<%=request.getContextPath()%>');">
	<img name='save' src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif" onClick="saveCard('<%=request.getContextPath()%>');">
	<img name='cancel' src="<%=request.getContextPath()%>/themes/themes1/images/main/cancel.gif" onClick="resetCard('<%=request.getContextPath()%>');">
</jhop:ctrlgroup>
<table class="detailmain" cellspacing="0" cellpadding="0">
	<tr id="table0"><td align="center">
		<table class="detail" width="100%" height="100%" cellspacing="0" >
			<tr>
			  <td height="23" class="tab_0" width="20%"><bean:message key="saleBillDto.custom_id"/><%--设备名称--%><span class="article_required">*</span></td>
			  <td height="23" width="30%"><input type="text" name="saleBillDto.custom_id" value="${saleBillForm.saleBillDto.custom_id}"></td>
			  <td height="23" class="tab_0" width="20%"><bean:message key="saleBillDto.custom_name"/><%--状态--%></td>
			  <td height="23" width="30%"><input type="text" name="saleBillDto.custom_name" value="${saleBillForm.saleBillDto.custom_name}"></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="saleBillDto.sale_mode"/><%--电压等级--%></td>
			  <td height="23"><jhop:select name="saleBillDto.sale_mode" hiddName="" type="voltage_level" initValue="${saleBillForm.saleBillDto.sale_mode}"></jhop:select></td>
			  <td height="23" class="tab_0"><bean:message key="saleBillDto.tranpriority"/><%--线路--%></td>
			  <td height="23"><jhop:select name="saleBillDto.tranpriority" hiddName="" type="line" initValue="${saleBillForm.saleBillDto.tranpriority}"></jhop:select></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="saleBillDto.check_begin_date"/><%--申请工作起始时间--%></td>
			  <td height="23"><jhop:dateselect name="saleBillDto.check_begin_date" endName="saleBillDto.check_end_date" initValue="${saleBillForm.saleBillDto.check_begin_date}" dateFormat="yyyy-mm-dd" group="start"></jhop:dateselect></td>
			  <td height="23" class="tab_0"><bean:message key="saleBillDto.check_end_date"/><%--申请工作终止时间--%></td>
			  <td height="23"><jhop:dateselect name="saleBillDto.check_end_date" startName="saleBillDto.check_end_date" initValue="${saleBillForm.saleBillDto.check_end_date}" dateFormat="yyyy-mm-dd" group="end"></jhop:dateselect></td>
		    </tr>
		    <!--<tr>
			 <td height="23" class="tab_0"> 附图:</td>
			  <td colspan="3"> 
			   <jhop:upload name="fileup" multiValue="yes"></jhop:upload>
			  </td>
		    </tr>	 
		    -->								
			<tr>
			  <td height="23" class="tab_0"><bean:message key="saleBillDto.sale_doc"/><%--工作内容--%></td>
			  <td height="23" colspan="3"><textarea name="saleBillDto.sale_doc" cols="80" rows="2">${saleBillForm.saleBillDto.sale_doc}</textarea></td>
		    </tr>
		</table>
	</td></tr>
</table>
</form>
</body>	
<%--处理消息--%>

<%
	/*
	if (message != null && !message.equals("") && !message.equals("null"))
	{
%>
		<script language="javascript">
			dealMessage('<%=message%>');
		</script>
<% 
	 }
	 */
%>
</html>	