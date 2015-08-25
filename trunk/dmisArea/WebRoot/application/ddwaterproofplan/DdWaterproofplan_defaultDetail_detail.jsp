<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>水电运行(计划放水)记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddwaterproofplan/DdWaterproofplan_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddWaterproofplanForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddWaterproofplanForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddWaterproofplanDto.fid" value="${ddWaterproofplanForm.ddWaterproofplanDto.fid}">
<input type="hidden" name="ddWaterproofplanDto.version" value="${ddWaterproofplanForm.ddWaterproofplanDto.version}">
<input type="hidden" name="ddWaterproofplanDto.sys_fille" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.sys_fille}">	
				
			<input type="hidden" name="ddWaterproofplanDto.sys_filldept" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.sys_filldept}">
			<input type="hidden" name="ddWaterproofplanDto.sys_filltime" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.sys_filltime}">
				
			<input type="hidden" name="ddWaterproofplanDto.sys_isvalid" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.sys_isvalid}">
			<input type="hidden"	name="ddWaterproofplanDto.sys_dataowner" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.sys_dataowner}">
			<input type="hidden"	name="ddWaterproofplanDto.zddwaterproofplan2.fid" 
				value="${ddWaterproofplanForm.ddWaterproofplanDto.zddwaterproofplan2.fid}">
				
<jhop:ctrlgroup ctrlId="UIControlGroupXPanelbd3326fb9d4844e1ad8fc3443b8d5ca5" title="计划放水记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelbd3326fb9d4844e1ad8fc3443b8d5ca5">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fapplyuser"/><%--申请人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddWaterproofplanDto.fapplyuser" name="ddWaterproofplanDto.fapplyuser" type="text" value="${ddWaterproofplanForm.ddWaterproofplanDto.fapplyuser}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fapplyunit"/><%--申请单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddWaterproofplanDto.fapplyunit" name="ddWaterproofplanDto.fapplyunit" type="text" value="${ddWaterproofplanForm.ddWaterproofplanDto.fapplyunit}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fapplycnt"/><%--放水时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddWaterproofplanDto.fapplycnt" name="ddWaterproofplanDto.fapplycnt" type="text" value="${ddWaterproofplanForm.ddWaterproofplanDto.fapplycnt}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fwaterquantity"/><%--水量(个)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddWaterproofplanDto.fwaterquantity" name="ddWaterproofplanDto.fwaterquantity" type="text" value="${ddWaterproofplanForm.ddWaterproofplanDto.fwaterquantity}" size="10"  />
			   </td>
			  	    		    </tr>
	  
			  	    		    
		<tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fwriteinlog"/><%--是否写入日志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddWaterproofplanDto.fwriteinlog" hiddName="" type="StdIsornot" initValue="是@@@是#否"> </jhop:select>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddWaterproofplanDto.fwriteinwglog"/><%--是否写入班志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddWaterproofplanDto.fwriteinwglog" hiddName="" type="StdIsornot" initValue="是@@@是#否"> </jhop:select>
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
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
