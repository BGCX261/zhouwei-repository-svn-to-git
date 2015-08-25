<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>发电批准书详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/detail.js"></script>
</head>
<body>
<html:javascript formName="fsApprovebookForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsApprovebookForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsApprovebookDto.fapprovcomputerno" value="${fsApprovebookForm.fsApprovebookDto.fapprovcomputerno}">
<input type="hidden" name="fsApprovebookDto.version" value="${fsApprovebookForm.fsApprovebookDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanela1fd2d1315d64048b57e6264937232c1" title="发电批准书"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanela1fd2d1315d64048b57e6264937232c1">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fapprovcomputerno"/><%--批准书内部编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fapprovcomputerno" name="fsApprovebookDto.fapprovcomputerno" type="text" value="${fsApprovebookForm.fsApprovebookDto.fapprovcomputerno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fapprovbookno"/><%--正式编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fapprovbookno" name="fsApprovebookDto.fapprovbookno" type="text" value="${fsApprovebookForm.fsApprovebookDto.fapprovbookno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fstationname"/><%--厂站名--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fstationname" name="fsApprovebookDto.fstationname" type="text" value="${fsApprovebookForm.fsApprovebookDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fprojectname"/><%--工程名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fprojectname" name="fsApprovebookDto.fprojectname" type="text" value="${fsApprovebookForm.fsApprovebookDto.fprojectname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fgenerationtime"/><%--发电日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsApprovebookDto.fgenerationtime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsApprovebookForm.fsApprovebookDto.fgenerationtime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fprojectunit"/><%--工程单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fprojectunit" name="fsApprovebookDto.fprojectunit" type="text" value="${fsApprovebookForm.fsApprovebookDto.fprojectunit}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fsendtounit"/><%--抄送单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fsendtounit" name="fsApprovebookDto.fsendtounit" type="text" value="${fsApprovebookForm.fsApprovebookDto.fsendtounit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fcompletiondate"/><%--完成时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsApprovebookDto.fcompletiondate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsApprovebookForm.fsApprovebookDto.fcompletiondate}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fproblem"/><%--执行过程说明--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fproblem" name="fsApprovebookDto.fproblem" type="text" value="${fsApprovebookForm.fsApprovebookDto.fproblem}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fstatus"/><%--流转状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fstatus" name="fsApprovebookDto.fstatus" type="text" value="${fsApprovebookForm.fsApprovebookDto.fstatus}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fwriterunit"/><%--批准书编制单位--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fwriterunit" name="fsApprovebookDto.fwriterunit" type="text" value="${fsApprovebookForm.fsApprovebookDto.fwriterunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_fille" name="fsApprovebookDto.sys_fille" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_filldept" name="fsApprovebookDto.sys_filldept" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsApprovebookDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsApprovebookForm.fsApprovebookDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_isvalid" name="fsApprovebookDto.sys_isvalid" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_isvalid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_dataowner" name="fsApprovebookDto.sys_dataowner" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fvoltage"/><%--电压等级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fvoltage" name="fsApprovebookDto.fvoltage" type="text" value="${fsApprovebookForm.fsApprovebookDto.fvoltage}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fexcutestatus"/><%--执行状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fexcutestatus" name="fsApprovebookDto.fexcutestatus" type="text" value="${fsApprovebookForm.fsApprovebookDto.fexcutestatus}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
