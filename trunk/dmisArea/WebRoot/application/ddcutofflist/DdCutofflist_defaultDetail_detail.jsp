<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>拉路限电记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddcutofflist/DdCutofflist_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddCutofflistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddCutofflistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddCutofflistDto.fid" value="${ddCutofflistForm.ddCutofflistDto.fid}">
<input type="hidden" name="ddCutofflistDto.version" value="${ddCutofflistForm.ddCutofflistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelc67080d542af4c7d8c8b6beb03a5baf8" title="拉下命令信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelc67080d542af4c7d8c8b6beb03a5baf8">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fordertype"/><%--拉路性质--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <jhop:select name="ddCutofflistDto.fordertype" hiddName="" type="StdDdcutpowreason" initValue="${ddCutofflistForm.ddCutofflistDto.fordertype}"> </jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fsusptime"/><%--拉路时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddCutofflistDto.fsusptime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${ddCutofflistForm.ddCutofflistDto.fsusptime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fgiveorderunit"/><%--下令单位--%></td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fgiver"/><%--下令人姓名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.fgiver" name="ddCutofflistDto.fgiver" type="text" value="${ddCutofflistForm.ddCutofflistDto.fgiver}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fgiveordertime"/><%--下令时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddCutofflistDto.fgiveordertime" genText="yes" dateFormat="yyyy-MM-dd" initValue="${ddCutofflistForm.ddCutofflistDto.fgiveordertime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.floadunit"/><%--接令单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.floadunit" name="ddCutofflistDto.floadunit" type="text" value="${ddCutofflistForm.ddCutofflistDto.floadunit}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.faccepter"/><%--接令人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.faccepter" name="ddCutofflistDto.faccepter" type="text" value="${ddCutofflistForm.ddCutofflistDto.faccepter}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fsummitter"/><%--交令人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.fsummitter" name="ddCutofflistDto.fsummitter" type="text" value="${ddCutofflistForm.ddCutofflistDto.fsummitter}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fsummitordertime"/><%--交令时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddCutofflistDto.fsummitordertime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${ddCutofflistForm.ddCutofflistDto.fsummitordertime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fload"/><%--限电负荷( MW)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.fload" name="ddCutofflistDto.fload" type="text" value="${ddCutofflistForm.ddCutofflistDto.fload}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.fregionloadbefore"/><%--拉路前地区负荷(MW)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.fregionloadbefore" name="ddCutofflistDto.fregionloadbefore" type="text" value="${ddCutofflistForm.ddCutofflistDto.fregionloadbefore}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.sys_fille" name="ddCutofflistDto.sys_fille" type="text" value="${ddCutofflistForm.ddCutofflistDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.sys_filldept" name="ddCutofflistDto.sys_filldept" type="text" value="${ddCutofflistForm.ddCutofflistDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddCutofflistDto.sys_filltime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${ddCutofflistForm.ddCutofflistDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddCutofflistDto.sys_isvalid" name="ddCutofflistDto.sys_isvalid" type="text" value="${ddCutofflistForm.ddCutofflistDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddCutofflistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddCutofflistDto.sys_dataowner" name="ddCutofflistDto.sys_dataowner" type="text" value="${ddCutofflistForm.ddCutofflistDto.sys_dataowner}" size="10"  />
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
