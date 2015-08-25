<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>机房工作详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhmachineworklist/zdhmachinehalllist_defaultDetail_detail.js"></script>
</head>
<body>
<%
	BusinessDetailDto bdt=BusinessDetailHelper.getBusDetailInfo(request);
	String loginName=bdt.getLoginName();
	String userId=bdt.getUserId();
	String userName=bdt.getUserName();
	Timestamp currentTime=bdt.getCurrentTime();
	String userDeptId=bdt.getUserDeptId();
	String userDeptCode=bdt.getUserDeptCode();
	String userDeptName=bdt.getUserDeptName();
	String dataOwnerName=bdt.getDataOwnerName();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
	String strCurrentTime=sdf.format(currentTime);
 %>
  <%
 //班号
	String ondutyno = (String)request.getAttribute("ondutyno");
	String currno   = (String)request.getAttribute("currno");
	String readonly = "";
	System.out.println("ondutyno="+ondutyno);
	System.out.println("currno="+currno);
	if(!currno.equalsIgnoreCase("") && !currno.equalsIgnoreCase(ondutyno)){
		readonly = " readonly ";
	}

%>
<html:javascript formName="zdhMachineworklistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhMachineworklistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhMachineworklistDto.jobid" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.jobid}"/>">
<input type="hidden" name="zdhMachineworklistDto.version" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.version}"/>">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel895a9a0bf32544daaf50211358c6342b" title="机房工作"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel895a9a0bf32544daaf50211358c6342b">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.content"/><%--纪事内容--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >

				 <textarea id='zdhMachineworklistDto.content' name='zdhMachineworklistDto.content' rows='3' cols='50' <%=readonly%> ><c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.content}"/></textarea>
				 
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingtime"/><%--工作时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  			   
			  			
			  			    
<% 
	if(readonly.equalsIgnoreCase("")){
%>
				 <jhop:date name="zdhMachineworklistDto.workingtime" genText="yes" dateFormat="yyyy-mm-dd hh:mm" showSecond="true" initValue="${zdhMachineworklistForm.zdhMachineworklistDto.workingtime}" ></jhop:date>
<% 
	}else{
%>
				<input type="text" name="zdhMachineworklistDto.workingtime"  value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.workingtime}"/>" readonly />
<% 
	}
%>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.jobcategory"/><%--工作类型--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  			   
			  			   
<% 
	if(readonly.equalsIgnoreCase("")){
%>
				 <jhop:select name="zdhMachineworklistDto.jobcategory" hiddName="" type="jobcategory" initValue="${zdhMachineworklistForm.zdhMachineworklistDto.jobcategory}"> </jhop:select>
<% 
	}else{
%>
				<input type="text" name="zdhMachineworklistDto.jobcategory" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.jobcategory}"/>" readonly />
<% 
	}
%>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.fexcutestatus"/><%--完成状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  			   
<% 
	if(readonly.equalsIgnoreCase("")){
%>
				 <jhop:select name="zdhMachineworklistDto.fexcutestatus" hiddName="" type="fexcutestatus" initValue="${zdhMachineworklistForm.zdhMachineworklistDto.fexcutestatus}"> </jhop:select>
<% 
	}else{
%>
			<input type="text" name="zdhMachineworklistDto.fexcutestatus" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.fexcutestatus}"/>" readonly />
<% 
	}
%>
			   </td>
			  <td height="23" class="tab_0" width="20%">
			  </td>
			  <td height="23" width="30%" >
			  </td>
			  </tr>
			  <%--填写人--%>
			  <input  name="zdhMachineworklistDto.sys_fille" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_fille}"/>" />
			  <%--交接班记录编号--%>
			  <input  name="zdhMachineworklistDto.zzdhmachineworklist1.ondutyno" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.zzdhmachineworklist1.ondutyno}"/>" />
			  <%--工作来源--%>
			  <input  name="zdhMachineworklistDto.workingsources" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.workingsources}"/>"  />
			  <%--填写单位--%>
			  <input  name="zdhMachineworklistDto.sys_filldept" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filldept}"/>" />
			  <%--填写时间--%>
			  <input name="zdhMachineworklistDto.sys_filltime" type="hidden"  value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filltime}"/>" />
			  <%--是否有效字段--%>
			  <input  name="zdhMachineworklistDto.sys_isvalid" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_isvalid}"/>" />
			  <%--数据所属单位--%>
			  <input  name="zdhMachineworklistDto.sys_dataowner" type="hidden" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_dataowner}"/>"  />
			  
			  <!--  		  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_fille" name="zdhMachineworklistDto.sys_fille" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_fille}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.zzdhmachineworklist1.ondutyno"/><%--交接班记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.zzdhmachineworklist1.ondutyno" name="zdhMachineworklistDto.zzdhmachineworklist1.ondutyno" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.zzdhmachineworklist1.ondutyno}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.workingsources"/><%--工作来源--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.workingsources" name="zdhMachineworklistDto.workingsources" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.workingsources}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_filldept" name="zdhMachineworklistDto.sys_filldept" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filldept}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input name="zdhMachineworklistDto.sys_filltime" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_filltime}"/>" readonly="true"/>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_isvalid" name="zdhMachineworklistDto.sys_isvalid" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_isvalid}"/>" size="10"  readonly="true"/>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhMachineworklistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhMachineworklistDto.sys_dataowner" name="zdhMachineworklistDto.sys_dataowner" type="text" value="<c:out value="${zdhMachineworklistForm.zdhMachineworklistDto.sys_dataowner}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>

		
    -->	        		
	 	  
		   

</table>
	</td></tr>
</table>
	</form>
	   <script>

    var id = document.getElementById('zdhMachineworklistDto.jobid').value;

    

    //进行初始化动作




    if (id == '' || id == null){

       //初始化填单人

       document.getElementById('zdhMachineworklistDto.sys_fille').value = '<%= userName %>';

       //初始化填写单位       

       document.getElementById('zdhMachineworklistDto.sys_filldept').value = '<%= userDeptName %>';

       //初始化填写时间




       document.getElementById('zdhMachineworklistDto.sys_filltime').value = '<%= currentTime %>';

       //数据所属单位




       document.getElementById('zdhMachineworklistDto.sys_dataowner').value = '<%= dataOwnerName %>';

       //申请时间

       document.getElementById('zdhMachineworklistDto.workingtime').value = '<%= strCurrentTime%>';

    }

    

</script>
</body>
</html>
