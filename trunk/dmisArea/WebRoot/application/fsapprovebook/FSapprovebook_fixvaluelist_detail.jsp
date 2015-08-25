<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>发电批准书详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_fixvaluelist_detail.js"></script>
</head>
<body>
<html:javascript formName="fsApprovebookForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsApprovebookForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="fsApprovebookDto.fapprovcomputerno" value="${fsApprovebookForm.fsApprovebookDto.fapprovcomputerno}">
<input type="hidden" name="fsApprovebookDto.version" value="${fsApprovebookForm.fsApprovebookDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel74c61331ae3149a58248f0dbc9c2f51b" title="定值单列表"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel74c61331ae3149a58248f0dbc9c2f51b">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_c31af744-8d50-4ba9-ac39-f2628aabf1d7"/><%--显示相关定值单列表,显示方式同其他定值单--%></td>
			  			  
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
