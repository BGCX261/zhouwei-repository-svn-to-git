<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>日前方式分析详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/daymodeanalyse/detail.js"></script>
</head>
<body>
<html:javascript formName="daymodeanalyseForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="daymodeanalyseForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="daymodeanalyseDto.fid" value="${daymodeanalyseForm.daymodeanalyseDto.fid}">
<input type="hidden" name="daymodeanalyseDto.version" value="${daymodeanalyseForm.daymodeanalyseDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelc26de65c942b4052b377b98524c74ad4" title="日前方式分析"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelc26de65c942b4052b377b98524c74ad4">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.fid"/><%--Fid--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.fid" name="daymodeanalyseDto.fid" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.fid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.fdate"/><%--日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="daymodeanalyseDto.fdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${daymodeanalyseForm.daymodeanalyseDto.fdate}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.sys_fille" name="daymodeanalyseDto.sys_fille" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.sys_filldept" name="daymodeanalyseDto.sys_filldept" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="daymodeanalyseDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${daymodeanalyseForm.daymodeanalyseDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.sys_isvalid" name="daymodeanalyseDto.sys_isvalid" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.sys_dataowner" name="daymodeanalyseDto.sys_dataowner" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.daymodeanalyseDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="daymodeanalyseDto.version" name="daymodeanalyseDto.version" type="text" value="${daymodeanalyseForm.daymodeanalyseDto.version}" size="10"  />
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
