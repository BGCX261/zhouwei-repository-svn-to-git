<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电网运行方式调整记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddpowerchangrecord/detail.js"></script>
</head>
<body>
<html:javascript formName="ddPowerchangrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddPowerchangrecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddPowerchangrecordDto.fid" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fid}">
<input type="hidden" name="ddPowerchangrecordDto.version" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel86d5d39276be4886a255e3548cfd7ed0" title="电网运行方式调整记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel86d5d39276be4886a255e3548cfd7ed0">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fid"/><%--方式变更执行记录编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fid" name="ddPowerchangrecordDto.fid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fstationname"/><%--厂站--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fstationname" name="ddPowerchangrecordDto.fstationname" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fstationname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fadjustreason"/><%--调整原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fadjustreason" name="ddPowerchangrecordDto.fadjustreason" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fadjustreason}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fadjustcontent"/><%--调整内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fadjustcontent" name="ddPowerchangrecordDto.fadjustcontent" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fadjustcontent}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsendcmdtime"/><%--下令时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddPowerchangrecordDto.fsendcmdtime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsendcmdtime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsendcmder"/><%--下令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fsendcmder" name="ddPowerchangrecordDto.fsendcmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsendcmder}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.freccmder"/><%--受令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.freccmder" name="ddPowerchangrecordDto.freccmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.freccmder}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.frestoretime"/><%--恢复时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddPowerchangrecordDto.frestoretime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.frestoretime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fressendcmder"/><%--恢复下令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fressendcmder" name="ddPowerchangrecordDto.fressendcmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fressendcmder}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fresreccmder"/><%--恢复受令人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fresreccmder" name="ddPowerchangrecordDto.fresreccmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fresreccmder}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fcurlogno"/><%--当前日志编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fcurlogno" name="ddPowerchangrecordDto.fcurlogno" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fcurlogno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fwriteinlog"/><%--是否写入日志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fwriteinlog" name="ddPowerchangrecordDto.fwriteinlog" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fwriteinlog}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fwriteinwglog"/><%--是否写入班志--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fwriteinwglog" name="ddPowerchangrecordDto.fwriteinwglog" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fwriteinwglog}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.flogtype"/><%--分类--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.flogtype" name="ddPowerchangrecordDto.flogtype" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.flogtype}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsendcmderid"/><%--下令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fsendcmderid" name="ddPowerchangrecordDto.fsendcmderid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsendcmderid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.freccmderid"/><%--接令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.freccmderid" name="ddPowerchangrecordDto.freccmderid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.freccmderid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fressendcmderid"/><%--恢复下令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fressendcmderid" name="ddPowerchangrecordDto.fressendcmderid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fressendcmderid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fresreccmderid"/><%--恢复接令人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fresreccmderid" name="ddPowerchangrecordDto.fresreccmderid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fresreccmderid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fstation"/><%--厂站ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fstation" name="ddPowerchangrecordDto.fstation" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fstation}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_fille" name="ddPowerchangrecordDto.sys_fille" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_filldept" name="ddPowerchangrecordDto.sys_filldept" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddPowerchangrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
