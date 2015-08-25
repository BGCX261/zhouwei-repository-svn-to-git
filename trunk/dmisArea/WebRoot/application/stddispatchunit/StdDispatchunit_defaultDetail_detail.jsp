<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度机构详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stddispatchunit/StdDispatchunit_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="stdDispatchunitForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="stdDispatchunitForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="stdDispatchunitDto.id" value="${stdDispatchunitForm.stdDispatchunitDto.id}">
<input type="hidden" name="stdDispatchunitDto.version" value="${stdDispatchunitForm.stdDispatchunitDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel7392479820b1456cb4c88727f38ec714" title="调度机构"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel7392479820b1456cb4c88727f38ec714">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdDispatchunitDto.unitname"/><%--调度机构名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdDispatchunitDto.unitname" name="stdDispatchunitDto.unitname" type="text" value="${stdDispatchunitForm.stdDispatchunitDto.unitname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdDispatchunitDto.unitarea"/><%--城近郊--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdDispatchunitDto.unitarea" name="stdDispatchunitDto.unitarea" type="text" value="${stdDispatchunitForm.stdDispatchunitDto.unitarea}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdDispatchunitDto.unitshortname"/><%--调度简称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdDispatchunitDto.unitshortname" name="stdDispatchunitDto.unitshortname" type="text" value="${stdDispatchunitForm.stdDispatchunitDto.unitshortname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdDispatchunitDto.scheduleunit"/><%--调度类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdDispatchunitDto.scheduleunit" name="stdDispatchunitDto.scheduleunit" type="text" value="${stdDispatchunitForm.stdDispatchunitDto.scheduleunit}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdDispatchunitDto.eshirtname"/><%--英文简称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="stdDispatchunitDto.eshirtname" name="stdDispatchunitDto.eshirtname" type="text" value="${stdDispatchunitForm.stdDispatchunitDto.eshirtname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	
	
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
