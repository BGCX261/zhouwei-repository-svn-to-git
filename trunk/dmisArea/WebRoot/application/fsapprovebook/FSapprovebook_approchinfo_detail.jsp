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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_approchinfo_detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel5e9213eec0f74a52bfcc23a8b01c41d1" title="附件列表"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel5e9213eec0f74a52bfcc23a8b01c41d1">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_318ea990-4bb3-4763-b76e-1e15bf0b2b00"/><%--显示和发电批准书相关的所有附件列表--%></td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanelb98065c8d6f24e75a622b92113ee01b8" title="附件内容"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelb98065c8d6f24e75a622b92113ee01b8">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_5279f769-63ec-47b3-bd6b-33902ac4b93d"/><%--打开选中附件的详细信息--%></td>
			  			  
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
