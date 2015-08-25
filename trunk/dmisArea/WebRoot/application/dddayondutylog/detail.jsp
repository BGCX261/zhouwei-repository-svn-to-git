<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度日志详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/dddayondutylog/detail.js"></script>
</head>
<body>
<html:javascript formName="ddDayondutylogForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddDayondutylogForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddDayondutylogDto.fondutyid" value="${ddDayondutylogForm.ddDayondutylogDto.fondutyid}">
<input type="hidden" name="ddDayondutylogDto.version" value="${ddDayondutylogForm.ddDayondutylogDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel61f018dc4ce84e3894eed4b60708e758" title="调度日志"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel61f018dc4ce84e3894eed4b60708e758">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.fondutyid"/><%--日志编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddDayondutylogDto.fondutyid" name="ddDayondutylogDto.fondutyid" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.fondutyid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.content"/><%--日志内容--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="content" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.logdate"/><%--日志日期--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDayondutylogDto.logdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDayondutylogForm.ddDayondutylogDto.logdate}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddDayondutylogDto.sys_fille" name="ddDayondutylogDto.sys_fille" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddDayondutylogDto.sys_filldept" name="ddDayondutylogDto.sys_filldept" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDayondutylogDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddDayondutylogForm.ddDayondutylogDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddDayondutylogDto.sys_isvalid" name="ddDayondutylogDto.sys_isvalid" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddDayondutylogDto.sys_dataowner" name="ddDayondutylogDto.sys_dataowner" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDayondutylogDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddDayondutylogDto.version" name="ddDayondutylogDto.version" type="text" value="${ddDayondutylogForm.ddDayondutylogDto.version}" size="10"  />
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
