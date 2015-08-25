<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>基改建工程自动化设备验收投运详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhreception/zdhprojectreception_defaultDetail_detail.js"></script>
</head>
<body>

<html:javascript formName="zdhReceptionForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhReceptionForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="zdhReceptionDto.fapplicationid" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fapplicationid}"/>">
<input type="hidden" name="zdhReceptionDto.version" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.version}"/>">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel98d83d4de81d4e3e8f09f7381d3a9e6e" title="基改建工程自动化设备验收申请"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel98d83d4de81d4e3e8f09f7381d3a9e6e">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fstationname"/><%--变电站名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.fstationname}"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fsystemtype"/><%--系统类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.fsystemtype}"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fsystemname"/><%--系统名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.fsystemname}"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.freceptiondate"/><%--验收日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.freceptiondate}"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fremark"/><%--备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.fremark}"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.sys_fille}"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  	<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.sys_isvalid}"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.sys_dataowner}"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fstationid"/><%--变电站ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <c:out value="${zdhReceptionForm.zdhReceptionDto.fstationid}"/>
			   </td>
			  			  
	    		    </tr>
    		
	 	  
		   

	
</table>
	</td></tr>
</table>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPaneld939039bd40d4963a3dfa23472269835" title="工程验收资料"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneld939039bd40d4963a3dfa23472269835">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.freceptiongraph"/><%--竣工图--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
		<!--  		 <jhop:upload name="freceptiongraph" multiValue="no"></jhop:upload>-->
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.freceptionreport"/><%--验收报告--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			<!-- 	 <jhop:upload name="freceptionreport" multiValue="no"></jhop:upload>-->
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fsequence"/><%--序位表--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			<!-- 	 <jhop:upload name="fsequence" multiValue="no"></jhop:upload>-->
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.ftranrec"/><%--传动记录--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				<!--  <jhop:upload name="ftranrec" multiValue="no"></jhop:upload>-->
			   </td>
			  			  
	    		    </tr>

		
            		
	 	  
	
	
</table>
	</td></tr>
</table>
	</form>

</body>
</html>
