<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>方式变更单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsrmchangbill/rmchangbill_rmchangexcute_detail.js"></script>
</head>
<body>
<html:javascript formName="fsRmchangbillForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsRmchangbillForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsRmchangbillDto.fchangno" value="${fsRmchangbillForm.fsRmchangbillDto.fchangno}">
<input type="hidden" name="fsRmchangbillDto.version" value="${fsRmchangbillForm.fsRmchangbillDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelb2f3d149b5384cd4a771868611c2ff9b" title="方式变更执行"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelb2f3d149b5384cd4a771868611c2ff9b">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_7c1f1967-0397-4ba4-96a5-48cc588249f6"/><%--列表显示电网方式调整纪录中来源为当前方式变更单的纪录,可以编辑--%></td>
			  			  
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
