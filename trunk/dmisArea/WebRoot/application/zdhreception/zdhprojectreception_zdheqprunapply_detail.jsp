<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>基改建工程自动化设备验收投运详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhreception/zdhprojectreception_zdheqprunapply_detail.js"></script>
</head>
<body>
<%
	String apployReadony="";
	String isShow=(String)request.getAttribute("isShow");
	System.out.println("isShow="+isShow);
	if(isShow!=null&&isShow.equals("0"))
	 apployReadony="readonly";
 %>
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
<!-- 隐藏字段 -->
 <input  name="zdhReceptionDto.fstationname" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstationname}"/>"  />
 <input name="zdhReceptionDto.fsystemtype" type="hidden" initValue="<c:out value="${zdhReceptionForm.zdhReceptionDto.fsystemtype}"/>"> 
 <input  name="zdhReceptionDto.fsystemname" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fsystemname}"/>"  />
 <input type="hidden" name="zdhReceptionDto.freceptiondate" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.freceptiondate}"/>" >
 <input  name='zdhReceptionDto.fremark' type="hidden"  value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fremark}"/>"/>			  
 <input  name="zdhReceptionDto.sys_fille" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_fille}"/>"  />
 <input  name="zdhReceptionDto.sys_filldept" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>" />
<input  name="zdhReceptionDto.sys_filltime" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_filldept}"/>"  />
 <input name="zdhReceptionDto.sys_isvalid" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_isvalid}"/>" />
 <input  name="zdhReceptionDto.sys_dataowner" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.sys_dataowner}"/>"  />			
 <input  name="zdhReceptionDto.fstationid" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstationid}"/>"  />			 
 <input  name="zdhReceptionDto.fexcutestatus" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fexcutestatus}"/>"  />	
  <input  name="zdhReceptionDto.fstatus" type="hidden" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fstatus}"/>"  />				   
<!-- end -->
<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6691e338057340149f26d6fed9bfd4e0" title="设备投运申请"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6691e338057340149f26d6fed9bfd4e0">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.freceptionno"/><%--申请单编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.freceptionno" name="zdhReceptionDto.freceptionno" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.freceptionno}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fapplyrundate"/><%--申请投运时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
			  			 
<%
	if(apployReadony!=null&&apployReadony.equals("readonly")){
 %>
				 <jhop:date name="zdhReceptionDto.fapplyrundate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhReceptionForm.zdhReceptionDto.fapplyrundate}" ></jhop:date>
<%
	}else{
 %>
 			     <input name="zdhReceptionDto.fapplyrundate" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fapplyrundate}"/>" readonly/>
 <%
 }
  %>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.feqpremark"/><%--设备说明--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='zdhReceptionDto.feqpremark' name='zdhReceptionDto.feqpremark' rows='3' cols='78' <%=apployReadony%> ><c:out value="${zdhReceptionForm.zdhReceptionDto.feqpremark}"/></textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				 <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.runeqpcontent"/><%--投运设备内容--%></td>
			  			   <td height="23" class="tab_0" width="20%" colspan=3>
	  <textarea id='zdhReceptionDto.runeqpcontent' name='runeqpcontent' rows='3' cols='78' <%=apployReadony%> ><c:out value="${zdhReceptionForm.runeqpcontent}"/></textarea></td>
	<!-- <input type=file name='runeqpcontent'> -->
			  			  
	    		    </tr>
	
		
            		
	 	  
		   

	
</table>
	</td></tr>
</table>
<%
	if(isShow!=null&&!isShow.equals("0")){
	
 %>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanelf96e7e51fc734a4ca625334e56cdddfa" title="批准信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelf96e7e51fc734a4ca625334e56cdddfa">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fapproverundate"/><%--批准投运时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >

				 <jhop:date name="zdhReceptionDto.fapproverundate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhReceptionForm.zdhReceptionDto.fapproverundate}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	 <!--  
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.localapprover1"/><%--投运批准人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='zdhReceptionDto.localapprover1' name='zdhReceptionDto.localapprover1' rows='3' cols='50' readonly='true'><c:out value="${zdhReceptionForm.zdhReceptionDto.localapprover1}"/></textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.centeropinion2"/><%--运维中心意见--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='zdhReceptionDto.centeropinion2' name='zdhReceptionDto.centeropinion2' rows='3' cols='50' readonly='true'><c:out value="${zdhReceptionForm.zdhReceptionDto.centeropinion2}"/></textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.centeropinion1"/><%--自动化处意见--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='zdhReceptionDto.centeropinion1' name='zdhReceptionDto.centeropinion1' rows='3' cols='50' readonly='true'><c:out value="${zdhReceptionForm.zdhReceptionDto.centeropinion1}"/></textarea>
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
<%
}
 %>
<%
	if(isShow!=null&&isShow.equals("2")){
 %>
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanel5b9324e17dd84b3f941ee99e1757ae26" title="实际投运信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel5b9324e17dd84b3f941ee99e1757ae26">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.frundate"/><%--实际投运时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >

				 <jhop:date name="zdhReceptionDto.frundate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhReceptionForm.zdhReceptionDto.frundate}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhReceptionDto.fexcutestatus"/><%--执行情况--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhReceptionDto.fexcutestatus" name="zdhReceptionDto.fexcutestatus" type="text" value="<c:out value="${zdhReceptionForm.zdhReceptionDto.fexcutestatus}"/>" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
      	
</table>
	</td></tr>
</table>
<%
}
 %>
	</form>
</body>
</html>
