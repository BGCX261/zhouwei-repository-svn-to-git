<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>厂家详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stdmanufacturer/detail.js"></script>
</head>
<body>
<html:javascript formName="stdManufacturerForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="stdManufacturerForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="stdManufacturerDto.id" value="${stdManufacturerForm.stdManufacturerDto.id}">
<input type="hidden" name="stdManufacturerDto.version" value="${stdManufacturerForm.stdManufacturerDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel2adc710e19614aa3be45da454d0dbf18" title="厂家"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel2adc710e19614aa3be45da454d0dbf18">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.id"/><%--厂家编码--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.id" name="stdManufacturerDto.id" type="text" value="${stdManufacturerForm.stdManufacturerDto.id}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.fname"/><%--厂家名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.fname" name="stdManufacturerDto.fname" type="text" value="${stdManufacturerForm.stdManufacturerDto.fname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.fshortname"/><%--厂家简称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.fshortname" name="stdManufacturerDto.fshortname" type="text" value="${stdManufacturerForm.stdManufacturerDto.fshortname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.fusedname"/><%--厂家曾用名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.fusedname" name="stdManufacturerDto.fusedname" type="text" value="${stdManufacturerForm.stdManufacturerDto.fusedname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.ftype"/><%--厂家类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.ftype" name="stdManufacturerDto.ftype" type="text" value="${stdManufacturerForm.stdManufacturerDto.ftype}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.fremark"/><%--备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdManufacturerDto.fremark" name="stdManufacturerDto.fremark" type="text" value="${stdManufacturerForm.stdManufacturerDto.fremark}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdManufacturerDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="stdManufacturerDto.version" name="stdManufacturerDto.version" type="text" value="${stdManufacturerForm.stdManufacturerDto.version}" size="10"  />
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
