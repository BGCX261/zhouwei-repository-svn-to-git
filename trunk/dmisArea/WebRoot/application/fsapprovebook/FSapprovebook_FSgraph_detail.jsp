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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_FSgraph_detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6cc9e4117df146e8920d67970c0e09cc" title="停电图"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6cc9e4117df146e8920d67970c0e09cc">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_85300a98-ca77-480a-b851-fe862a1b3483"/><%--显示打开后的停电图信息--%></td>
			  			  
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
