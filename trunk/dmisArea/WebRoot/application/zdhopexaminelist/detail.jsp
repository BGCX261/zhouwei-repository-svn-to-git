<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>日计划核查表详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhopexaminelist/detail.js"></script>
</head>
<body>
<html:javascript formName="zdhOpexaminelistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhOpexaminelistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhOpexaminelistDto.examinationid" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.examinationid}">
<input type="hidden" name="zdhOpexaminelistDto.version" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel530c4258d64f4a0b95ca774aa4c1cfe7" title="日计划核查表"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel530c4258d64f4a0b95ca774aa4c1cfe7">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.examinationid"/><%--核查记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.examinationid" name="zdhOpexaminelistDto.examinationid" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.examinationid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.begincheck"/><%--开始工作核查--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.begincheck" name="zdhOpexaminelistDto.begincheck" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.begincheck}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.finishcheck"/><%--完成情况核查--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.finishcheck" name="zdhOpexaminelistDto.finishcheck" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishcheck}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.finishchecker"/><%--完成核查人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.finishchecker" name="zdhOpexaminelistDto.finishchecker" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishchecker}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.beginchecker"/><%--开始核查人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.beginchecker" name="zdhOpexaminelistDto.beginchecker" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.beginchecker}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.beginchecktime"/><%--开始工作核查时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhOpexaminelistDto.beginchecktime" genText="yes" dateFormat="yyyy-MM-dd" initValue="${zdhOpexaminelistForm.zdhOpexaminelistDto.beginchecktime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.finishchecktime"/><%--完成核查时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhOpexaminelistDto.finishchecktime" genText="yes" dateFormat="yyyy-MM-dd" initValue="${zdhOpexaminelistForm.zdhOpexaminelistDto.finishchecktime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.eondutylogno"/><%--结束核查日志号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.eondutylogno" name="zdhOpexaminelistDto.eondutylogno" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.eondutylogno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.sys_fille" name="zdhOpexaminelistDto.sys_fille" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.sys_filldept" name="zdhOpexaminelistDto.sys_filldept" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhOpexaminelistDto.sys_filltime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhOpexaminelistDto.sys_isvalid" name="zdhOpexaminelistDto.sys_isvalid" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_isvalid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhOpexaminelistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="zdhOpexaminelistDto.sys_dataowner" name="zdhOpexaminelistDto.sys_dataowner" type="text" value="${zdhOpexaminelistForm.zdhOpexaminelistDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
