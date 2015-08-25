<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.sql.Date"%>
<%@ include file="/common/init_tag.jsp" %>

<html>
<head>
<html:base/>
<title>序位表详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhsequencetable/zdhsequencerec_defaultDetail_detail.js"></script>
</head>
<body>
   <%     
    BusinessDetailDto bdt = BusinessDetailHelper.getBusDetailInfo(request);
    //用户登录名


    String loginName = bdt.getLoginName();  			
    //用户ID
	String userId = bdt.getUserId();  		
	//用户名称	
	String userName = bdt.getUserName();		
	//当前时间	
	Timestamp currentTime = bdt.getCurrentTime();	
    Date currentDate = bdt.getCurrentDate();
	//用户部门ID
	String userDeptId = bdt.getUserDeptId();	
	//用户部门CODE		
	String userDeptCode = bdt.getUserDeptCode();
    //用户部门名称
	String userDeptName = bdt.getUserDeptName();
	//数据所属单位ID
	String dataOwnerId = bdt.getDataOwnerId();			
	//数据所属单位名称


	String dataOwnerName = bdt.getDataOwnerName();			 
 %> 

<html:javascript formName="zdhSequencetableForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhSequencetableForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhSequencetableDto.fsequenceno" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.fsequenceno}"/>">
<input type="hidden" name="zdhSequencetableDto.version" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.version}"/>">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel9dedc08336a54801b5890a47eddab2a5" title="序位信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel9dedc08336a54801b5890a47eddab2a5">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fstationname"/><%--厂站名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fstationname" name="zdhSequencetableDto.fstationname" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.fstationname}"/>" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fserialno"/><%--序号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fserialno" name="zdhSequencetableDto.fserialno" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.fserialno}"/>" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fname"/><%--标识--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fname" name="zdhSequencetableDto.fname" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.fname}"/>" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.fstatus"/><%--状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.fstatus" name="zdhSequencetableDto.fstatus" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.fstatus}"/>" size="10"  />
			   </td>
			  			  
	    		    </tr>
	    		    <%--数据所属单位--%>
	    		    <input  name="zdhSequencetableDto.sys_dataowner" type="hidden" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_dataowner}"/>"  />
	    		     <%--是否有效字段--%>
	    		     <input  name="zdhSequencetableDto.sys_isvalid" type="hidden" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_isvalid}"/>"  />
	    		     <%--填写人--%>
	    		     <input  name="zdhSequencetableDto.sys_fille" type="hidden" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_fille}"/>"   />
	    		     <%--填写时间--%>
	    		     <input  name="zdhSequencetableDto.sys_filltime" type="hidden" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_filltime}"/>"  />
	    		     <%--填写单位--%>
	    		     <input  name="zdhSequencetableDto.sys_filldept" type="hidden" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_filldept}"/>"  />
	    		    <!--  
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.sys_dataowner" name="zdhSequencetableDto.sys_dataowner" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_dataowner}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.sys_isvalid" name="zdhSequencetableDto.sys_isvalid" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_isvalid}"/>" size="10"  readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhSequencetableDto.sys_fille" name="zdhSequencetableDto.sys_fille" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_fille}"/>" size="10" readonly="true"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  	 <input id="zdhSequencetableDto.sys_filltime" name="zdhSequencetableDto.sys_filltime" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_filltime}"/>" size="10" readonly="true"  />

			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhSequencetableDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="zdhSequencetableDto.sys_filldept" name="zdhSequencetableDto.sys_filldept" type="text" value="<c:out value="${zdhSequencetableForm.zdhSequencetableDto.sys_filldept}"/>" size="10"  readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>

	-->
</table>
	</td></tr>
</table>
	</form>
	<script>
    var id = document.getElementById('zdhSequencetableDto.fsequenceno').value;
    
    //进行初始化动作


    if (id == '' || id == null){
       //初始化填单人
       document.getElementById('zdhSequencetableDto.sys_fille').value = '<%= userName %>';
       //初始化填写单位       
       document.getElementById('zdhSequencetableDto.sys_filldept').value = '<%= userDeptName %>';
       //初始化填写时间


       document.getElementById('zdhSequencetableDto.sys_filltime').value = '<%= currentTime %>';
       //数据所属单位


       document.getElementById('zdhSequencetableDto.sys_dataowner').value = '<%= dataOwnerName %>';
      
    }
    
</script>
	
</body>
</html>
