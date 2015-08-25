<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>传动记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhtransrecord/detail.js"></script>
</head>
<body>
<html:javascript formName="zdhTransrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhTransrecordForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="zdhTransrecordDto.transrecordid" value="${zdhTransrecordForm.zdhTransrecordDto.transrecordid}">
<input type="hidden" name="zdhTransrecordDto.version" value="${zdhTransrecordForm.zdhTransrecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel7f7ff923a5c244afb94fbb6a255bc616" title="传动记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel7f7ff923a5c244afb94fbb6a255bc616">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transrecordid"/><%--传动记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.transrecordid" name="zdhTransrecordDto.transrecordid" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.transrecordid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.fstationname"/><%--厂站--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.fstationname" name="zdhTransrecordDto.fstationname" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.fstationname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transreason"/><%--传动原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.transreason" name="zdhTransrecordDto.transreason" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.transreason}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transpeople"/><%--传动人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.transpeople" name="zdhTransrecordDto.transpeople" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.transpeople}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transdate"/><%--传动日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhTransrecordDto.transdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhTransrecordForm.zdhTransrecordDto.transdate}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transunit"/><%--传动单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.transunit" name="zdhTransrecordDto.transunit" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.transunit}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.explanation"/><%--传动内容说明--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.explanation" name="zdhTransrecordDto.explanation" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.explanation}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sourcetaskno"/><%--任务来源编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sourcetaskno" name="zdhTransrecordDto.sourcetaskno" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.sourcetaskno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.annexsequence"/><%--序位表附件--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="annexsequence" multiValue="no"></jhop:upload>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.ondutyno"/><%--交接班记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.ondutyno" name="zdhTransrecordDto.ondutyno" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.ondutyno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transrecordno"/><%--传动记录正式编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.transrecordno" name="zdhTransrecordDto.transrecordno" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.transrecordno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_fille" name="zdhTransrecordDto.sys_fille" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="zdhTransrecordDto.sys_filldept" name="zdhTransrecordDto.sys_filldept" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhTransrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhTransrecordForm.zdhTransrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.tasksource"/><%--任务来源--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="zdhTransrecordDto.tasksource" name="zdhTransrecordDto.tasksource" type="text" value="${zdhTransrecordForm.zdhTransrecordDto.tasksource}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
