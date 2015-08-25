<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电网预案详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddpremethod/detail.js"></script>
</head>
<body>
<html:javascript formName="ddPremethodForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddPremethodForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddPremethodDto.fpremethodid" value="${ddPremethodForm.ddPremethodDto.fpremethodid}">
<input type="hidden" name="ddPremethodDto.version" value="${ddPremethodForm.ddPremethodDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPaneleeb109b3eed443efa0bd9b5d85e49224" title="电网预案"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneleeb109b3eed443efa0bd9b5d85e49224">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.fpremethodid"/><%--预案编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.fpremethodid" name="ddPremethodDto.fpremethodid" type="text" value="${ddPremethodForm.ddPremethodDto.fpremethodid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.fpremethodcontent"/><%--预案内容--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="fpremethodcontent" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.src"/><%--预案来源--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.src" name="ddPremethodDto.src" type="text" value="${ddPremethodForm.ddPremethodDto.src}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.premethodtype"/><%--预案类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.premethodtype" name="ddPremethodDto.premethodtype" type="text" value="${ddPremethodForm.ddPremethodDto.premethodtype}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.premethodname"/><%--预案名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.premethodname" name="ddPremethodDto.premethodname" type="text" value="${ddPremethodForm.ddPremethodDto.premethodname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.content1"/><%--内容1--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.content1" name="ddPremethodDto.content1" type="text" value="${ddPremethodForm.ddPremethodDto.content1}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.content2"/><%--内容2--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.content2" name="ddPremethodDto.content2" type="text" value="${ddPremethodForm.ddPremethodDto.content2}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.content3"/><%--内容3--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.content3" name="ddPremethodDto.content3" type="text" value="${ddPremethodForm.ddPremethodDto.content3}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.fstatus"/><%--状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.fstatus" name="ddPremethodDto.fstatus" type="text" value="${ddPremethodForm.ddPremethodDto.fstatus}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.sys_fille" name="ddPremethodDto.sys_fille" type="text" value="${ddPremethodForm.ddPremethodDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.sys_filldept" name="ddPremethodDto.sys_filldept" type="text" value="${ddPremethodForm.ddPremethodDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddPremethodDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddPremethodForm.ddPremethodDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.sys_isvalid" name="ddPremethodDto.sys_isvalid" type="text" value="${ddPremethodForm.ddPremethodDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPremethodDto.sys_dataowner" name="ddPremethodDto.sys_dataowner" type="text" value="${ddPremethodForm.ddPremethodDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPremethodDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddPremethodDto.version" name="ddPremethodDto.version" type="text" value="${ddPremethodForm.ddPremethodDto.version}" size="10"  />
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
