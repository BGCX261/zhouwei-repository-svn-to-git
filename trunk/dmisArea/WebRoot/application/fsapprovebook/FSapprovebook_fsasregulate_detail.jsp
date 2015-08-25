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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_fsasregulate_detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel54ecaf237bf04508aa17d92f52dce93f" title="自投规程信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel54ecaf237bf04508aa17d92f52dce93f">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_a6e3f2a9-0a5c-43f9-858e-3ae2b951c4d3"/><%--显示自投规程的详细内容--%></td>
			  			  
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
