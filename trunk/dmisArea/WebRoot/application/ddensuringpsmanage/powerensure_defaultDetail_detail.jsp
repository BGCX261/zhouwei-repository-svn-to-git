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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddensuringpsmanage/powerensure_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddEnsuringpsmanageForm"/>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel37cefd5b236e400dbc6ba1e0376ca60d" title="保电信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel37cefd5b236e400dbc6ba1e0376ca60d">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fcommunication"/><%--来文名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="fcommunication" multiValue="no"></jhop:upload>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fmeasarule"/><%--措施和制度--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:upload name="fmeasarule" multiValue="no"></jhop:upload>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fadditonal"/><%--反事故预案--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <jhop:upload name="fadditonal" multiValue="no"></jhop:upload>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringps"/><%--保电任务--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='DdEnsuringpsmanageDto.fensuringps' name='DdEnsuringpsmanageDto.fensuringps' rows='3' cols='50' >${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringps}</textarea>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_1a088bdd-49b2-4358-bfb3-418eb8a749af"/><%--开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddEnsuringpsmanageDto.fensuringpsstime" endName="DdEnsuringpsmanageDto.fensuringpsetime" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsstime}" dateFormat="yyyy-mm-dd" group="start" ></jhop:dateselect>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_d045b185-edb1-4e88-a140-26e7b01d867e"/><%--结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddEnsuringpsmanageDto.fensuringpsetime" startName="DdEnsuringpsmanageDto.fensuringpsstime" initValue="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsetime}" dateFormat="yyyy-mm-dd" group="end" ></jhop:dateselect>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fno"/><%--保电单编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fno" name="ddEnsuringpsmanageDto.fno" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fensuringpsarea"/><%--保电地点--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fensuringpsarea" name="ddEnsuringpsmanageDto.fensuringpsarea" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fensuringpsarea}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fcommunication"/><%--来文名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fcommunication" name="ddEnsuringpsmanageDto.fcommunication" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fcommunication}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddEnsuringpsmanageDto.fmeasarule"/><%--措施和制度--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddEnsuringpsmanageDto.fmeasarule" name="ddEnsuringpsmanageDto.fmeasarule" type="text" value="${ddEnsuringpsmanageForm.ddEnsuringpsmanageDto.fmeasarule}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
