<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>机房工作详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhmachineworklist/zdhmachinehalllist_defaultDetail_detail.js"></script>
</head>
<body>

<html:javascript formName="zdhMachineworklistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhMachineworklistForm" action="" method="post" >
<%--hidden--%>


<jhop:ctrlgroup ctrlId="UIControlGroupXPanel895a9a0bf32544daaf50211358c6342b" title="机房工作"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel895a9a0bf32544daaf50211358c6342b">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.content"/><%--纪事内容--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.content}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingtime"/><%--工作时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.workingtime}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.jobcategory"/><%--工作类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.jobcategory}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.fexcutestatus"/><%--完成状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.fexcutestatus}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.sys_fille}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.zzdhmachineworklist1.ondutyno"/><%--交接班记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.zzdhmachineworklist1.ondutyno}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingsources"/><%--工作来源--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				${zdhMachineworklistForm.zdhMachineworklistDto.workingsources}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.sys_filldept}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhMachineworklistForm.zdhMachineworklistDto.sys_filltime}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				${zdhMachineworklistForm.zdhMachineworklistDto.sys_isvalid}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				${zdhMachineworklistForm.zdhMachineworklistDto.sys_dataowner}
			   </td>
			  			  
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
