<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>低频减载装置参数的属性清单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fslfparalist/FsLfparalist_LFloaddatalist_detail.js"></script>
</head>
<body>
<html:javascript formName="fsLfparalistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsLfparalistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsLfparalistDto.flinesno" value="${fsLfparalistForm.fsLfparalistDto.flinesno}">
<input type="hidden" name="fsLfparalistDto.version" value="${fsLfparalistForm.fsLfparalistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel7bd40c2ad7ea46979194fafab0a0c94f" title="负荷数据列表"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel7bd40c2ad7ea46979194fafab0a0c94f">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_d2d4fcdd-5dac-4c88-9e0c-9524af998166"/><%--显示当前线路的所有负荷数据按照时间到排序注意:根据标准字典Std_LFmeasuretime的测量点将数据表拉平--%></td>
			  			  
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
