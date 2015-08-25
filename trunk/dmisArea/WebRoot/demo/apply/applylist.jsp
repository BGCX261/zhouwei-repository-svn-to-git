<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="../../common/taglibs.jsp"%>
<c:if test="${sessionScope.applyList != null}">
	<c:set var="applyList_req" value="${sessionScope.applyList}" scope="request"/>
</c:if>
<%
String ctx = request.getContextPath();
System.out.println(request.getAttribute("taskList"));

%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<link href="<%=ctx%>/common/css/screen.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
table {
	border:#9CB2DE solid;border-width:1px 0px 0px 1px
}
table td{
	font-size:9pt;
	line-height:1.2;
	padding:5px;
	border:#9CB2DE solid;border-width:0px 1px 1px 0px;	
	
}
-->
</style>

  <head>
    <html:base />
    <title>applylist.jsp</title>    
    <script language="javascript">
    	function add(){
    		window.location.href="<%=ctx%>/apply.do?method=add";
    	}
    	
    	function del(str){
    		window.location.href="<%=ctx%>/apply.do?method=delete&applyId="+str;
    	}
		function onModify(str){
			window.location.href="<%=ctx%>/apply.do?method=initModify&applyId="+str;
		}
		
		function startTask(applyid,applyer) {		    
		    window.location.href="<%=ctx%>/apply.do?method=start&applyId="+applyid+"&actorid="+applyer;
		}

    	function excuteTask(taskId,applyId){
    		window.location.href="<%=ctx%>/apply.do?method=endTask&taskId="+taskId+"&applyId="+applyId+"&actorid=<c:out value="${actorid}" />";
    	}		
    	
    	function searchApply() {    		
	 		document.forms[0].submit();
    	}
    	
		
    </script>
  </head>
  
  <body>
      <div align="center"><font color="red"> <c:out value="${msg}"></c:out></font></div>
      <div align="center"><html:button property="add" onclick="return add();">����������</html:button>
     <html:form  method="POST" action="/apply?method=listApply">
		<html:select property="actorid">
   		    <html:option value="auditing">�����Ա</html:option>
			<html:option value="fangshi">��ʽ��Ա</html:option>
			<html:option value="baohu">������Ա</html:option>			
	    </html:select>
	    <html:submit property="search" onclick="searchApply()">��Ա�����ѯ</html:submit>
	 
	  <br>	 
	 </html:form>
	 </div>
	<table border=1 cellPadding=0 cellSpacing=0 width="80%" align="center">	  
	  <tr>
	    <td bgColor=#ffffff width="100%">
	    <display:table  name="applyList_req" id="applyInfo" defaultsort="1"  pagesize="10" width="100%" >						
				<display:column  property="applyId"  title="�������"  sortable="true" height="30" />							
				<display:column  title="����ʱ��" sortable="true"  >
					<fmt:formatDate value="${applyInfo.applyTime}" pattern="yyyy��MM��dd��"  />
				</display:column>
				<display:column  property="applyer" title="������" sortable="true"  />
				<display:column  property="warranter" title="������" sortable="true" />
				<display:column  property="applyTitle" title="����" sortable="true" />
				<display:column  property="status" title="����״̬" sortable="true"  />
				<display:column  title="��������" sortable="true"  >
					<a href='<%=ctx%>/apply.do?method=download&applyId=<c:out value="${applyInfo.applyId}"/>' ><c:out value="${applyInfo.attachmentName}"/></a>
				</display:column>	
				<display:column  title="����" sortable="false" align="center" >
					<!--<input type="button" name="modify" value="�޸�" onClick="onModify(<c:out value="${applyInfo.applyId}"/>);" />-->		   	
		   			<c:if test="${applyInfo.status == null || applyInfo.status == 0}"> 
  		   			   <input type="button" name="delete" value="ɾ��" onClick="del('<c:out value="${applyInfo.applyId}"/>');" />
		   			   <input type="button" name="start" value="��������" onClick="startTask('<c:out value="${applyInfo.applyId}" />','<c:out value="${applyInfo.applyer}" />');" />
		   			</c:if>	
		   			<c:if test="${(applyInfo.status ==2 || applyInfo.status ==3 || applyInfo.status ==4) && applyInfo.taskId != null }"> 	
                         <input type="button" name="start" value="��ת" onClick="excuteTask('<c:out value="${applyInfo.taskId}" />','<c:out value="${applyInfo.applyId}" />');" />
		   			</c:if>
		   			
		   			<c:if test="${(applyInfo.status ==2 || applyInfo.status ==3 || applyInfo.status ==4) && applyInfo.taskId == null }"> 	
                          �����ڴ�����    
		   			</c:if>	
		   			
		   			<c:if test="${applyInfo.status == 5 && applyInfo.taskId == null}"> 	
                          ���̴������    
		   			</c:if>			   					   					   				   			
				</display:column>					
		</display:table>
	 	</td>
	  </tr>
	  <tr cols="7">
	    <td><a href="<%=ctx%>/demo/workflow/index.jsp">���̲�ѯ</a></td>
	  </tr>
	</table>
  </body>

