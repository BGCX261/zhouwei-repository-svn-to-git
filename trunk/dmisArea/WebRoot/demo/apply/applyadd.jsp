<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="../../common/taglibs.jsp"%>
<html>
<head>
<html:base/>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>������Ϣ</title>
<link href="demo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript" src="<%=request.getContextPath()%>/common/js/setday.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/JDate.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/ApplyFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script language="javascript">
<!--
	//-----------���Լ�Date��------------
	function doTestDate(){
		JDate.toString(load);
	}
	function load(data){
		window.alert("��ǰʱ��: "+data);
	}
	
	//-----------����spring����,��facade������ȡ������------------
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
	<div align="center"><strong>������Ϣ</strong></div>
	<table width="540" border="1" align="center">    
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF" >�������</td>
        <td width="414"><input type="text" name="applyDto.applyTitle" size="50" value="<c:out value='${applyForm.applyDto.applyTitle}'/>" ></td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">������</td>
        <td width="414">
          <select name="applyDto.applyer">
          	<option value="auditing">�����Ա</option>
        	<option value="baohu">������Ա</option>
       		<option value="fangshi">��ʽ��Ա</option>
          </select>
        </td>
      </tr>
     <tr>
        <td width="110" height="32" bgcolor="#99CCFF">����ʱ��</td>
        <td width="414"> <input type=text name="applyTime" id="applyTime" size=20   value="<c:out value='${applyForm.applyDto.applyTime}'/>">              ��
		 <button name="ss"  border="0" style="cursor:hand" onClick="setday(this,document.getElementById('applyTime'))" align="middle">ѡ������
		 </button>
		 </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">���벿��</td>
        <td width="414"><select name="department">
        		<option value="��Ʋ�" <c:if test="${applyForm.applyDto.department == '��Ʋ�'}">selected</c:if>>��Ʋ�</option>
        		<option value="������" <c:if test="${applyForm.applyDto.department == '������'}">selected</c:if>>������</option>
        		<option value="���Բ�" <c:if test="${applyForm.applyDto.department == '���Բ�'}">selected</c:if>>���Բ�</option>
        	</select>
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">������</td>
        <td width="414"><select name="warranter">
        		<option value="yangjun">���</option>
        		<option value="yangjb">���</option>
        		<option value="liuaj">������</option>        		      		
        	</select></td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">Ӱ�췶Χ</td>
        <td width="414">
        	<input name="relateScale" value="1" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '1'}">checked</c:if>>����������
  			<input name="relateScale" value="2" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '2'}">checked</c:if>>Ӧ�ÿ�����
			<input name="relateScale" value="3" type="checkbox" <c:if test="${applyForm.applyDto.relateScale == '3'}">checked</c:if>>��Ŀ������
		</td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">���ȼ�</td>
        <td width="414"><input name="proprity" value="0" type="radio" <c:if test="${applyForm.applyDto.proprity == '0'}">checked</c:if>>��
          <input name="proprity" value="1" type="radio" <c:if test="${applyForm.applyDto.proprity == '1'}">checked</c:if>>��
          <input name="proprity" value="2" type="radio" <c:if test="${applyForm.applyDto.proprity == '2'}">checked</c:if>>��
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">��ǰ״̬</td>
        <td width="414">
        	<c:if test="${not empty applyDto}">
        		<select name="status">
	        		<option value="ͬ��">ͬ��</option>        		     		
	        		<option value="����">����</option>
	        	</select>
        	</c:if>
        	<c:if test="${empty applyDto}">
	        	<select name="status">
	        		<option value="0">�½�</option>        		     		
	        	</select>
        	</c:if>
        </td>
      </tr>
      <tr>
        <td width="110" height="32" bgcolor="#99CCFF">˵��</td>
        <td width="414"><textarea name="packageDest" rows="5" cols="50"><c:out value="${applyForm.applyDto.packageDest}"/></textarea></td>
      </tr>
      <tr>
		<td align="right">������</td>
		<td>
		  <input type="file" name="attachment"/>
		</td>
	  </tr>
</table>
	<div align="center">
		<input type="button" value="��ǰ����_DWR" onClick="doTestDate();">&nbsp;
		<input type="button" value="������һ��_DWR" onClick="doList();">&nbsp;
		<input type="button" value="�ύ" onClick="add('<%=request.getContextPath()%>');">	
		<a href="<%=request.getContextPath()%>/apply.do?method=listApply">�������뵥demo </a> 	
	</div>
  </form>
</body>
</html>

