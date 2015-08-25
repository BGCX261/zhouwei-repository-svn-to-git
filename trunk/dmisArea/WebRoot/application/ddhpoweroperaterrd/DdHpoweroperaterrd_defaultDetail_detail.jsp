<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电厂运行(下令操作)记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddhpoweroperaterrd/DdHpoweroperaterrd_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddHpoweroperaterrdForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddHpoweroperaterrdForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddHpoweroperaterrdDto.fid" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fid}">
<input type="hidden" name="ddHpoweroperaterrdDto.version" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.version}">
<input type="hidden" name="ddHpoweroperaterrdDto.sys_fille" 
				value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_fille}">	
				
			<input type="hidden" name="ddHpoweroperaterrdDto.sys_filldept" 
				value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_filldept}">
			<input type="hidden" name="ddHpoweroperaterrdDto.sys_filltime" 
				value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_filltime}">
				
			<input type="hidden" name="ddHpoweroperaterrdDto.sys_isvalid" 
				value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_isvalid}">
			<input type="hidden"	name="ddHpoweroperaterrdDto.sys_dataowner" 
				value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_dataowner}">


<jhop:ctrlgroup ctrlId="UIControlGroupXPanelccbd2e38e74f4a9db114aa2a08d5bc89" title="电厂下令操作记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelccbd2e38e74f4a9db114aa2a08d5bc89">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fplant"/><%--电厂�?--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="ddHpoweroperaterrdDto.fplant" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fplant}"/>
<input type="hidden" name="ddHpoweroperaterrdDto.zddhpoweroperaterrd2.stationno"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdStationSelect('ddHpoweroperaterrdDto.fplant','ddHpoweroperaterrdDto.zddhpoweroperaterrd2.stationno','0');">

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fordertype"/><%--命令类型--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="ddHpoweroperaterrdDto.fordertype" hiddName="" type="fordertype" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fordertype}"> </jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmder"/><%--下令�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="ddHpoweroperaterrdDto.fsendcmder" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmder}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setDdDispatcherSelect('ddHpoweroperaterrdDto.fsendcmder','','0');">

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdtime"/><%--下令时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.fsendcmdtime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdtime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.zddhpoweroperaterrd5.fid"/><%--班志编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddHpoweroperaterrdDto.zddhpoweroperaterrd5.fid" name="ddHpoweroperaterrdDto.zddhpoweroperaterrd5.fid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.zddhpoweroperaterrd5.fid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdwaterlevel"/><%--下令水位(�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdwaterlevel" name="ddHpoweroperaterrdDto.fsendcmdwaterlevel" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdwaterlevel}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdgenerating"/><%--下令发电�?W)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdgenerating" name="ddHpoweroperaterrdDto.fsendcmdgenerating" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdgenerating}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsendcmdoutflow"/><%--下令放水�?�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.fsendcmdoutflow" name="ddHpoweroperaterrdDto.fsendcmdoutflow" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsendcmdoutflow}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmder"/><%--受令�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="ddHpoweroperaterrdDto.freccmder" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmder}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setGgPersonSelect('ddHpoweroperaterrdDto.freccmder','','0');">

			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsummiter"/><%--交令�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="ddHpoweroperaterrdDto.fsummiter" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsummiter}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setGgPersonSelect('ddHpoweroperaterrdDto.fsummiter','','0');">

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fsummittime"/><%--交令时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.fsummittime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.fsummittime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmdwaterlevel"/><%--交令水位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmdwaterlevel" name="ddHpoweroperaterrdDto.freccmdwaterlevel" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdwaterlevel}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.freccmdgenerating"/><%--交令发电�?W)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.freccmdgenerating" name="ddHpoweroperaterrdDto.freccmdgenerating" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdgenerating}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_372440f7-9f14-4861-9086-7d678baee48a"/><%--交令放水�?�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddHpoweroperaterrdDto.freccmdoutflow" name="ddHpoweroperaterrdDto.freccmdoutflow" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.freccmdoutflow}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fwriteinlog"/><%--是否写入日志--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="ddHpoweroperaterrdDto.fwriteinlog" type="text" initValue="是@@@是#否"></jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.fwriteinwglog"/><%--是否写入班志--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 
				 <jhop:select name="ddHpoweroperaterrdDto.fwriteinwglog" type="text" initValue="是@@@是#否"></jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_fille"/><%--填写�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.sys_fille" name="ddHpoweroperaterrdDto.sys_fille" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddHpoweroperaterrdDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.sys_isvalid" name="ddHpoweroperaterrdDto.sys_isvalid" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddHpoweroperaterrdDto.sys_dataowner"/><%--数据所属单�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddHpoweroperaterrdDto.sys_dataowner" name="ddHpoweroperaterrdDto.sys_dataowner" type="text" value="${ddHpoweroperaterrdForm.ddHpoweroperaterrdDto.sys_dataowner}" size="10"  />
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
