<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../../common/init_tag.jsp"%>
<%@ include file="../../../common/init_js.jsp" %>
<%@ include file="../../../common/init_date.jsp" %>

<%@ page language="java" buffer="18kb"%>
<% 
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<%-- 接收XML模块数据 --%>
<%--@ include file="parseXmlParam.jsp"--%>

<html>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
<head>
  <title>gridtest</title> 
  <meta name="KEYWORDS" content="dhtmlxgrid, dhtml grid, javascript grid, javascript, DHTML, grid, grid control, dynamical scrolling, xml, AJAX, API, cross-browser, checkbox, XHTML, compatible, gridview, navigation, script, javascript navigation, web-site, dynamic, javascript grid, dhtml grid, dynamic grid, item, row, cell, asp, .net, jsp, cold fusion, custom tag, loading, widget, checkbox, drag, drop, drag and drop, component, html, scand">
  <meta name="DESCRIPTION" content="Cross-browser DHTML grid with XML support and powerful API. This DHTML JavaScript grid can load its content dynamically from server using AJAX technology.">
<style>
	body {font-size:12px}
	.{font-family:arial;font-size:12px}
	h1 {cursor:hand;font-size:16px;margin-left:10px;line-height:10px}
	xmp {color:green;font-size:12px;margin:0px;font-family:courier;background-color:#e6e6fa;padding:2px}
	div.hdr{
		background-color:lightgrey;
		margin-bottom:10px;
		padding-left:10px;
	}
    .grid_hover {
        background-color:#7FFFD4;
        font-size:20px;
    }
</style>
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/script/tag/gridcss/dhtmlXGrid.css">
    <style>
		div.gridbox div.ftr td{
			text-align:right;
		}
	</style>
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">
    <script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXCommon.js"></script>
    <script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGrid.js"></script>    
    <script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGridCell.js"></script>
    <script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGrid_excell_link.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGrid_splt.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGrid_mcol.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/grid/dhtmlXGrid_exProject.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/grid/importDatas.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/grid/validate.js"></script>
	<script src="<%=request.getContextPath()%>/script/prototype.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/script/public.js"> </script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"> </script>
<script>
	function onSaveForm(contextPath){
	url = contextPath + "/ui.do?method=saveMainCard";
	document.all.saleBillForm.action = url;
	document.all.saleBillForm.submit();
}

//���������������������onResetForm������������������������������������������������
function onResetForm(contextPath){
	document.all.saleBillForm.reset();
}
</script>
</head>
<body>    
    


<%-- 创建弹出窗口，并传递参数 --%>
<%@ include file="/components/tag/grid/common/parseCreateModal.jsp"%>

<%-- 构建Grid表格附加函数 --%>
<%@ include file="/components/tag/grid/common/parseCreateGrid.jsp"%>

<form name="saleBillForm" action="" method="post">
<%--hidden--%>
<input type="hidden" name="saleBillDto.id" value="<c:out value='${saleBillForm.saleBillDto.id}'/>">
<input type="hidden" name="saleBillDto.version" value="<c:out value='${saleBillForm.saleBillDto.version}'/>">

<jhop:ctrlgroup ctrlId="table0" title="基本信息">
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
<jhop:ctrlgroup name="grid" ctrlId="table1" title="子表信息" isEdit="yes">
	<img name='del' src="<%=request.getContextPath()%>/themes/themes1/images/main/down.gif" onClick="setSbSelect()">
	<img name='save' src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif" onClick="saveDTOS('<%=request.getContextPath()%>/ui.do?method=saveChildGrid',iGrid.mygrid,true,'<%=request.getContextPath()%>/components/tag/grid/testrule.xml','test')">
	<img name='del' src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif" onClick="deleteDTOS('<%=request.getContextPath()%>/ui.do?method=deleteChildGrid',iGrid.mygrid)">

</jhop:ctrlgroup>
<%--<iframe name="iGrid" frameborder='0' width='100%' scrolling="no" src='<%=request.getContextPath()%>/rijihua.do?method=initSubEditGrid&refId=salesId^string^1^${rijihuaForm.sheDto.id}^^asc'></iframe>--%>
<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
<iframe name="iGrid" frameborder='0' height="500" width='100%' scrolling="no" src='<%=request.getContextPath()%>/components/tag/grid/childGridDemo.jsp?parentid=${saleBillForm.saleBillDto.id}'></iframe>
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

<script>
	function setSbSelect(){
		var  impo = new importDatasObj('/components/tag/grid/import.jsp',{'print_no':'print_no','custom_id':'custom_id','custom_name':'custom_name','print_time':'print_time','goodsqty':'goodsqty','begin_date':'begin_date','end_date':'end_date','saleBillDto':'saleBillDto'},'iGrid.mygrid');  
		impo.height = 200;
		impo.width = 800;
		impo.showImportDatas();
	}
	
	function reloadgrid(){
	    //alert("fff");
		iGrid.location='<%=request.getContextPath()%>/components/tag/grid/childGridDemo.jsp?parentid=${saleBillForm.saleBillDto.id}';
	}
</script>

</html>	