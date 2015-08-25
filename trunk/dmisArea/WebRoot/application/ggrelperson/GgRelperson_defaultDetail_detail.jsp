<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>外部人员详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ggrelperson/GgRelperson_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ggRelpersonForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ggRelpersonForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ggRelpersonDto.id" value="${ggRelpersonForm.ggRelpersonDto.id}">
<input type="hidden" name="ggRelpersonDto.version" value="${ggRelpersonForm.ggRelpersonDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel0ad1e7c7057d486aa5ce5c507dd1fa5f" title="tt"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel0ad1e7c7057d486aa5ce5c507dd1fa5f">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_b8c476f7-f4cd-42b8-aca5-c4a32436f058"/><%--Label--%></td>
			  			  
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
