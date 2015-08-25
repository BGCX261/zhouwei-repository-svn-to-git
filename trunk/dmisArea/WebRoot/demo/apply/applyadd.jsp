<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="../../common/taglibs.jsp"%>
<html>
<head>
<html:base/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>申请信息</title>
<link href="demo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript" src="<%=request.getContextPath()%>/common/js/setday.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/JDate.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ApplyFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script language="javascript">
<!--
	//-----------测试简单Date类------------
	function doTestDate(){
		JDate.toString(load);
	}
	function load(data){
		window.alert("当前时间: "+data);
	}
	
	//-----------测试spring集成,从facade方法中取得数据------------
	function doList(){
		ApplyFacade.listApply4dwr(copy);
	}
	
	function copy(data){
		document.getElementById("applyDto.applyId").value = data[1].applyId;
		document.getElementById("applyDto.applyTitle").value = data[1].applyTitle;
		document.getElementById("applyDto.applyer").value = data[1].applyer;		
	}


	function add(contextPath){
		if (!validateApplyForm(document.all.applyForm)){
			return false;
		}
		document.all.applyForm.action = contextPath + "/apply.do?method=add";
		document.all.applyForm.submit();
	}
//-->
</script>


</head>
<br>
<html:javascript formName="applyForm"/>
<body>
   <form name="applyForm" action="" method="post" enctype="multipart/form-data">
	<div align="center"><strong>申请信息</strong></div>
	<table width="540" border="1" align="center">    
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF" >申请标题</td>
        <td width="414"><input type="text" name="applyDto.applyTitle" size="50" value="<c:out value='${applyForm.applyDto.applyTitle}'/>" ></td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">申请人</td>
        <td width="414">
          <select name="applyDto.applyer">
          	<option value="auditing">审核人员</option>
        	<option value="baohu">保护人员</option>
       		<option value="fangshi">方式人员</option>
          </select>
        </td>
      </tr>
     <tr>
        <td width="110" height="32" bgcolor="#99CCFF">申请时间</td>
        <td width="414"> <input type=text name="applyTime" id="applyTime" size=20   value="<c:out value='${applyForm.applyDto.applyTime}'/>">              　
		 <button name="ss"  border="0" style="cursor:hand" onClick="setday(this,document.getElementById('applyTime'))" align="middle">选择日期
		 </button>
		 </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">申请部门</td>
        <td width="414"><select name="department">
        		<option value="设计部" <c:if test="${applyForm.applyDto.department == '设计部'}">selected</c:if>>设计部</option>
        		<option value="开发部" <c:if test="${applyForm.applyDto.department == '开发部'}">selected</c:if>>开发部</option>
        		<option value="测试部" <c:if test="${applyForm.applyDto.department == '测试部'}">selected</c:if>>测试部</option>
        	</select>
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">审批人</td>
        <td width="414"><select name="warranter">
        		<option value="yangjun">杨军</option>
        		<option value="yangjb">杨建宝</option>
        		<option value="liuaj">刘爱军</option>        		      		
        	</select></td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">影响范围</td>
        <td width="414">
        	<input name="relateScale" value="1" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '1'}">checked</c:if>>基础开发包
  			<input name="relateScale" value="2" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '2'}">checked</c:if>>应用开发包
			<input name="relateScale" value="3" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '3'}">checked</c:if>>项目开发包
		</td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">优先级</td>
        <td width="414"><input name="proprity" value="0" type="radio" <c:if test="${applyForm.applyDto.proprity == '0'}">checked</c:if>>高
          <input name="proprity" value="1" type="radio" <c:if test="${applyForm.applyDto.proprity == '1'}">checked</c:if>>中
          <input name="proprity" value="2" type="radio" <c:if test="${applyForm.applyDto.proprity == '2'}">checked</c:if>>低
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">当前状态</td>
        <td width="414">
        	<c:if test="${not empty applyDto}">
        		<select name="status">
	        		<option value="同意">同意</option>        		     		
	        		<option value="驳回">驳回</option>
	        	</select>
        	</c:if>
        	<c:if test="${empty applyDto}">
	        	<select name="status">
	        		<option value="0">新建</option>        		     		
	        	</select>
        	</c:if>
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">说明</td>
        <td width="414"><textarea name="packageDest" rows="5" cols="50"><c:out value="${applyForm.applyDto.packageDest}"/></textarea></td>
      </tr>
      <tr>
		<td align="right">附件：</td>
		<td>
		  <input type="file" name="attachment"/>
		</td>
	  </tr>
</table>
	<div align="center">
		<input type="button" value="当前日期_DWR" onClick="doTestDate();">&nbsp;
		<input type="button" value="复制上一条_DWR" onClick="doList();">&nbsp;
		<input type="button" value="提交" onClick="add('<%=request.getContextPath()%>');">	
		<a href="<%=request.getContextPath()%>/apply.do?method=listApply">返回申请单demo </a> 	
	</div>
  </form>
</body>
</html>

