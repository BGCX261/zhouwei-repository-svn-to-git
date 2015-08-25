<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp" %>
<%@ include file="/common/init_tag.jsp" %>
<%
	BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
	//用户登录名
    String loginName 		= bdt.getLoginName();            
    //用户ID
    String userId 			= bdt.getUserId();       
    //用户名称  
    String userName 		= bdt.getUserName();      
    //当前时间  
    Timestamp currentTime 	= bdt.getCurrentTime(); 
    //用户部门ID
    String userDeptId 		= bdt.getUserDeptId();  
    //用户部门CODE     
    String userDeptCode 	= bdt.getUserDeptCode();
    //用户部门名称
    String userDeptName 	= bdt.getUserDeptName();
    //数据所属单位ID
    String dataOwnerId 		= bdt.getDataOwnerId();           
    //数据所属单位名称
    String dataOwnerName 	= bdt.getDataOwnerName();
%>
<%
	String ondutyno = (String)request.getAttribute("ondutyno");
	String currno   = (String)request.getAttribute("currno");
	String readonly = "";
	if(!currno.equalsIgnoreCase("") && !currno.equalsIgnoreCase(ondutyno)){
		readonly = " readonly ";
	}
	//out.println("############"+ondutyno+"################"+currno);
	//out.println("#############"+readonly);
%>
<html>
<head>
<html:base/>
<title>遥信记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhrsrecord/zdhrsrec_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="zdhRsrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhRsrecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhRsrecordDto.recordid" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.recordid}"/>">
<input type="hidden" name="zdhRsrecordDto.version" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.version}"/>">
<%--交接班记录编号--%>
<input type="hidden" name="zdhRsrecordDto.zzdhrsrecord2.ondutyno" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.zzdhrsrecord2.ondutyno}"/>">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel121b65d523c440bc827a45b9b30c1fdf" title="事故遥信动作记录"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel121b65d523c440bc827a45b9b30c1fdf">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.accidentname"/><%--故障名称--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="35%"  colspan="3"  >
				 <textarea id='zdhRsrecordDto.accidentname' name='zdhRsrecordDto.accidentname' rows='3' cols='71' <%=readonly%> ><c:out value="${zdhRsrecordForm.zdhRsrecordDto.accidentname}"/></textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.accidenttime"/><%--故障时间--%></td>
			  			  
	    		
			  			   <td height="23" width="35%"  colspan="3" >
				 
			  <% 
			 	if(readonly.equalsIgnoreCase("")){
			 %>
			 	    <jhop:date name="zdhRsrecordDto.accidenttime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${zdhRsrecordForm.zdhRsrecordDto.accidenttime}" ></jhop:date>
			 <%
			 	
			 	} else {
			 %>
			 		<input id="zdhRsrecordDto.accidenttime" name="zdhRsrecordDto.accidenttime" type="text" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.accidenttime}"/>" size="20"  readonly/>
			 <%
			 	}
			 %>
			   </td>
			  		
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.righttimes"/><%--应动作次数--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="35%" >
				 <input id="zdhRsrecordDto.righttimes" name="zdhRsrecordDto.righttimes" type="text" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.righttimes}"/>" size="10" <%=readonly%> />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.correcttimes"/><%--正确动作次数--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="35%" >
				 <input id="zdhRsrecordDto.correcttimes" name="zdhRsrecordDto.correcttimes" type="text" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.correcttimes}"/>" size="10" <%=readonly%> />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.actionnote"/><%--动作说明--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="35%"  colspan="3"  >
				 <textarea id='zdhRsrecordDto.actionnote' name='zdhRsrecordDto.actionnote' rows='3' cols='71' <%=readonly%>><c:out value="${zdhRsrecordForm.zdhRsrecordDto.actionnote}"/></textarea>
			   </td>
			  			  
	    		    </tr>
	   						<%--填写人--%>
							<input type="hidden" name="zdhRsrecordDto.sys_fille"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_fille}"/>">
							<%--填写单位--%>
							<input type="hidden" name="zdhRsrecordDto.sys_filldept"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_filldept}"/>">
							<%--填写时间--%>
							<input type="hidden" name="zdhRsrecordDto.sys_filltime"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_filltime}"/>">
							<%--是否有效字段--%>
							<!--input type="hidden" name="zdhRsrecordDto.sys_isvalid"
				value="${zdhRsrecordForm.zdhRsrecordDto.sys_isvalid}"-->
							<%--数据所属单位--%>
							<input type="hidden" name="zdhRsrecordDto.sys_dataowner"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_dataowner}"/>">
							<%--是否有效字段--%>
							<input type="hidden" name="zdhRsrecordDto.sys_isvalid"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_isvalid}"/>">
							<%--故障编号--%>
							<input type="hidden" name="zdhRsrecordDto.zzdhrsrecord1.faccidentid"
				value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.zzdhrsrecord1.faccidentid}"/>">
	   <!--tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			   	<input id="zdhRsrecordDto.sys_filltime" name="zdhRsrecordDto.sys_filltime" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_filltime}" size="20"  readonly/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.sys_fille" name="zdhRsrecordDto.sys_fille" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_fille}" size="10"  readonly/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.sys_filldept" name="zdhRsrecordDto.sys_filldept" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_filldept}" size="10"  readonly/>
			   </td>
			  			  
	    	<td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhRsrecordDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhRsrecordDto.sys_dataowner" name="zdhRsrecordDto.sys_dataowner" type="text" value="${zdhRsrecordForm.zdhRsrecordDto.sys_dataowner}" size="10"  readonly/>
			   </td>	  
	   </tr-->
	   <!--tr>
				<td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			   <td height="23" width="35%" >
				 <input id="zdhRsrecordDto.sys_isvalid" name="zdhRsrecordDto.sys_isvalid" type="text" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.sys_isvalid}"/>" size="10" <%=readonly%> />
			   </td>
			  			   <td height="23" class="tab_0" width="15%">
				 <bean:message key="object.zdhRsrecordDto.zzdhrsrecord1.faccidentid"/><%--故障编号--%></td>
			  			   <td height="23" width="35%" >
				 <input id="zdhRsrecordDto.zzdhrsrecord1.faccidentid" name="zdhRsrecordDto.zzdhrsrecord1.faccidentid" type="text" value="<c:out value="${zdhRsrecordForm.zdhRsrecordDto.zzdhrsrecord1.faccidentid}"/>" size="10" readonly />
			   </td>	  
	   </tr-->
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
<script>
	var id = document.getElementById('zdhRsrecordDto.recordid').value;
	//进行初始化动作
    if (id == null || id == '' || id == 'undefined'){
		//初始化填单人
       document.getElementById('zdhRsrecordDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhRsrecordDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间
       document.getElementById('zdhRsrecordDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位
       document.getElementById('zdhRsrecordDto.sys_dataowner').value = '<%= dataOwnerName %>';
       //申请时间							
       //document.getElementById('zdhRsrecordDto.applicantedtime').value = '<%= currentTime%>';	
	}
</script>
