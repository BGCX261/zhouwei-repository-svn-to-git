<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>日计划详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/demo/rijihua/detail.js"></script>
</head>
<body>
<html:javascript formName="rijihuaForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
<form name="rijihuaForm" action="" method="post">
<%--hidden--%>
<input type="hidden" name="sheDto.id" value="<c:out value='${rijihuaForm.sheDto.id}'/>">
<input type="hidden" name="sheDto.version" value="<c:out value='${rijihuaForm.sheDto.version}'/>">

<jhop:ctrlgroup ctrlId="table0" title="基本信息">
</jhop:ctrlgroup>
<table class="detailmain" cellspacing="0" cellpadding="0">
	<tr id="table0"><td align="center">
		<table class="detail" width="100%" height="100%" cellspacing="0" >
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>普通TEXT框</strong></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.equipment"/><%--设备名称--%><span class="article_required">*</span></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.equipment" value="${rijihuaForm.sheDto.equipment}"></td>
			  <td height="23" class="tab_0" width="20%"><bean:message key="dayPlan.status"/><%--状态--%></td>
			  <td height="23" width="30%"><input type="text" name="sheDto.status" value="${rijihuaForm.sheDto.status}"></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>日期控件</strong>（不带时间和带时间，通过设置dataFormat）</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_date"/><%--申请日期--%></td>
			  <td height="23"><jhop:date name="apply_date" genText="yes" dateFormat="yyyy-mm-dd" initValue=""></jhop:date></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_date"/><%--申请日期--%></td>
			  <td height="23"><jhop:date name="sheDto.apply_date" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${rijihuaForm.sheDto.apply_date}"></jhop:date></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>时间段选择控件</strong>（同一组控件需要设置group属性，同样允许设置dataFormat）</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_begin_date"/><%--申请工作起始时间--%></td>
			  <td height="23"><jhop:dateselect name="sheDto.apply_begin_date" endName="sheDto.apply_end_date" initValue="${rijihuaForm.sheDto.apply_begin_date}" dateFormat="yyyy-mm-dd" group="start"></jhop:dateselect></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.apply_end_date"/><%--申请工作终止时间--%></td>
			  <td height="23"><jhop:dateselect name="sheDto.apply_end_date" startName="sheDto.apply_begin_date" initValue="${rijihuaForm.sheDto.apply_end_date}" dateFormat="yyyy-mm-dd" group="end"></jhop:dateselect></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>系统数据字典</strong>（通过设置type属性值取得字典数据）</td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_3" align="center">普通不级联：不带滚动条和带滚动条，通过所列数据条数自动判定</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.voltage_level"/><%--电压等级--%></td>
			  <td height="23"><jhop:select name="sheDto.voltage_level" hiddName="" type="voltage_level" initValue="${rijihuaForm.sheDto.voltage_level}"></jhop:select></td>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.line"/><%--线路--%></td>
			  <td height="23"><jhop:select name="sheDto.line" hiddName="" type="line" initValue="${rijihuaForm.sheDto.line}"></jhop:select></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_3" align="center">级联下拉：需要设置parentId</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0">省</td>
			  <td height="23">
			  	<input type="hidden" name="shengcode" />
			  	<jhop:select name="sheng" hiddName="shengcode" type="s" initValue=""></jhop:select>			  
			  </td>
			  <td height="23" class="tab_0">市</td>
			  <td height="23">
			    <jhop:select name="shi" hiddName="" type="ss" parentId="shengcode" initValue=""></jhop:select>
			  </td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>业务数据字典</strong>（通过调用displayBusSelect实现，需要设置src，可以级联）</td>
		     </tr>
		    <tr>
			  <td height="23" class="tab_0" width="20%">申请单位<%--申请单位--%><span class="article_required">*</span></td>
			  <td height="23" width="30%">
			    <input type="hidden" name="sqdwcode" value="">
			  	<input type="text" name="sqdw">
			  	<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setSqdwSelect();">			  </td>
			  <td height="23" class="tab_0" width="20%">申请人<%--申请人--%></td>
			  <td height="23" width="30%">
			  	<input type="text" name="sqr">
			  	<img id="img2" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setSqrSelect();">			  </td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>多选下拉框</strong></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0">申请单位<%--申请单位--%><span class="article_required">*</span></td>
			  <td height="23">
			    <input type="text" name="sqdwMul">
			  	<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setSqdwMulSelect();">			  </td>
			  <td height="23" class="tab_0"></td>
			  <td height="23"></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>弹出表格选择框</strong>（调用简单查询，返回选中行记录，数组形式）</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0">设备</td>
			  <td height="23">
			  	<input type="text" name="shebei" value="">
			  	<img id="img2" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setSbSelect();">			  
			  </td>
			  <td height="23" class="tab_0"></td>
			  <td height="23"></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>弹出树形选择框</strong>（调用树控件，返回选中的节点ID）</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0">资源</td>
			  <td height="23">
			  	<input type="text" name="ziyuan" value="">
			  	<img id="img2" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setResourceSelect();">			  
			  </td>
			  <td height="23" class="tab_0"></td>
			  <td height="23"></td>
		    </tr>			
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>弹出popup嵌套iframe选择框</strong>（未完待续....）</td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0">设备</td>
			  <td height="23">
			  	<input type="text" name="sb1" value="">
			  	<img id="img2" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="displayIframeSelect('sb1','sb1','','<%=request.getContextPath()%>/demo/index.jsp')">			  </td>
			  <td height="23" class="tab_0"></td>
			  <td height="23"></td>
		    </tr>
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>上传文件控件</strong>（通过multiValue属性设置是否多文件上传）</td>
		    </tr>  
		    <tr>
			 <td height="23" class="tab_0"> 附图:</td>
			  <td colspan="3"> 
			   <jhop:upload name="fileup" multiValue="yes"></jhop:upload>
			  </td>
		    </tr>	
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>选项组控件</strong></td>
		    </tr>  
		    <tr>
			 <td height="23" class="tab_0"> 选项组:</td>
			  <td colspan="3"> 
			   <img id="img2" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setTransOptions();">
			  </td>
		    </tr>								
			<tr>
			  <td height="23" colspan="4" class="tab_1" align="left"><strong>MEMO框</strong></td>
		    </tr>
			<tr>
			  <td height="23" class="tab_0"><bean:message key="dayPlan.job_content"/><%--工作内容--%></td>
			  <td height="23" colspan="3"><textarea name="sheDto.job_content" cols="80" rows="2">${rijihuaForm.sheDto.job_content}</textarea></td>
		    </tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
