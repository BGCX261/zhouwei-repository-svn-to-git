<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>型号详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stdmodel/detail.js"></script>
</head>
<body>
<html:javascript formName="stdModelForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="stdModelForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="stdModelDto.id" value="${stdModelForm.stdModelDto.id}">
<input type="hidden" name="stdModelDto.version" value="${stdModelForm.stdModelDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanele333b84f18c14a11a40253becc847d29" title="型号"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele333b84f18c14a11a40253becc847d29">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdModelDto.id"/><%--型号编码--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdModelDto.id" name="stdModelDto.id" type="text" value="${stdModelForm.stdModelDto.id}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdModelDto.modelname"/><%--型号名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdModelDto.modelname" name="stdModelDto.modelname" type="text" value="${stdModelForm.stdModelDto.modelname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdModelDto.devclassid"/><%--设备类型编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdModelDto.devclassid" name="stdModelDto.devclassid" type="text" value="${stdModelForm.stdModelDto.devclassid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdModelDto.fmanufactureno"/><%--厂家编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdModelDto.fmanufactureno" name="stdModelDto.fmanufactureno" type="text" value="${stdModelForm.stdModelDto.fmanufactureno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdModelDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="stdModelDto.version" name="stdModelDto.version" type="text" value="${stdModelForm.stdModelDto.version}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
