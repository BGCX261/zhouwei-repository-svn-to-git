<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="../../common/taglibs.jsp"%>
<html>
<head>
<html:base/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>公司信息</title>
<link href="../apply/demo.css" rel="stylesheet" type="text/css">
</head>
<br>
<script>
	function add(contextPath){
		if (!validateDictionaryBaseForm(document.all.dictionaryBaseForm)){
			return false;
		}
		document.all.dictionaryBaseForm.action = contextPath + "/dictionary.do?method=add&poName=Company";
		document.all.dictionaryBaseForm.submit();
	}
</script>
<html:javascript formName="dictionaryBaseForm"/>
<body>
   <form name="dictionaryBaseForm" action="" method="post">
   	<input type="hidden" name="companyDto.id" value="<c:out value='${dictionaryBaseForm.companyDto.id}'/>"/>
	<div align="center"><strong>公司信息</strong></div>
	<table width="540" border="1" align="center"><%--     
	  <tr>
        <td width="110" height="32" bgcolor="#99CCFF" >公司编号</td>
        <td width="414"><input type="text" name="companyDto.id" size="50" value="<c:out value='${dictionaryBaseForm.companyDto.id}'/>" ></td>
      </tr> 
      --%><tr>
        <td width="110" height="32" bgcolor="#99CCFF" >公司名称</td>
        <td width="414"><input type="text" name="companyDto.companyName" size="50" value="<c:out value='${dictionaryBaseForm.companyDto.companyName}'/>" ></td>
      </tr>
	</table>
	<div align="center">		
		<input type="button" value="提交" onClick="add('<%=request.getContextPath()%>');">		
	</div>
  </form>
</body>
</html>

