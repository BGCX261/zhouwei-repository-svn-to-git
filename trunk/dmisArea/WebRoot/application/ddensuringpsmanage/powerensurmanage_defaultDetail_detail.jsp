<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>政治保电管理详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddensuringpsmanage/powerensurmanage_defaultDetail_detail.js"></script>
</head>
<body>
<!-- 
<html:javascript formName="ddEnsuringpsmanageForm"/>
-->
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddEnsuringpsmanageForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddEnsuringpsmanageDto.fid" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fid}">
<input type="hidden" name="ddEnsuringpsmanageDto.version" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6080ddb7d6514e26b72d0660aca19195" title="保电源单"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6080ddb7d6514e26b72d0660aca19195">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fno"/><%--保电单编号--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddEnsuringpsmanageDto.fno" name="ddEnsuringpsmanageDto.fno" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddEnsuringpsmanageDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.sys_dataowner" name="ddEnsuringpsmanageDto.sys_dataowner" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fexcutestatus"/><%--执行情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:select name="ddEnsuringpsmanageDto.fexcutestatus" hiddName="" type="fexcutestatus" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fexcutestatus}"> </jhop:select>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fstatus"/><%--流转状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fstatus" name="ddEnsuringpsmanageDto.fstatus" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fstatus}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringpsstime"/><%--保电开始时间--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddEnsuringpsmanageDto.fensuringpsstime" endName="ddEnsuringpsmanageDto.fensuringpsetime" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsstime}" dateFormat="yyyy-mm-dd hh:mm:ss" group="start" ></jhop:dateselect>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringpsetime"/><%--保电结束时间--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddEnsuringpsmanageDto.fensuringpsetime" startName="ddEnsuringpsmanageDto.fensuringpsstime" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsetime}" dateFormat="yyyy-mm-dd hh:mm:ss" group="end" ></jhop:dateselect>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.ftransmissionunit"/><%--发送单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.ftransmissionunit" name="ddEnsuringpsmanageDto.ftransmissionunit" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.ftransmissionunit}" size="10"  />
			   </td>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fcommunication"/><%--来文名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="fcommunication" multiValue="no"></jhop:upload>
			   </td>
			   
			  	    		    </tr>
	   <tr>

			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fmeasarule"/><%--措施和制度--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="fmeasarule" multiValue="no"></jhop:upload>
			   </td>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fadditonal"/><%--反事故预案--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <jhop:upload name="fadditonal" multiValue="no"></jhop:upload>
			   </td>			   
			  	    		    </tr>


	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.sys_fille" name="ddEnsuringpsmanageDto.sys_fille" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.sys_filldept" name="ddEnsuringpsmanageDto.sys_filldept" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringps"/><%--保电任务--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='ddEnsuringpsmanageDto.fensuringps' name='ddEnsuringpsmanageDto.fensuringps' rows='3' cols='50' type="_moz">${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringps}</textarea>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringpsarea"/><%--保电地点--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fensuringpsarea" name="ddEnsuringpsmanageDto.fensuringpsarea" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsarea}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fstationname"/><%--保电变电站--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fstationname" name="ddEnsuringpsmanageDto.fstationname" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fstationname}" size="10"  />
			   </td>
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
