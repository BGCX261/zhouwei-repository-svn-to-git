<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>自投规程详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/bhasregulate/detail.js"></script>
</head>
<body>
<html:javascript formName="bhAsregulateForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="bhAsregulateForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="bhAsregulateDto.asregulateid" value="${bhAsregulateForm.bhAsregulateDto.asregulateid}">
<input type="hidden" name="bhAsregulateDto.version" value="${bhAsregulateForm.bhAsregulateDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelf2096d0a473a428ca1fa72ec50e5ea8a" title="自投规程"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelf2096d0a473a428ca1fa72ec50e5ea8a">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.asregulateid"/><%--id--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.asregulateid" name="bhAsregulateDto.asregulateid" type="text" value="${bhAsregulateForm.bhAsregulateDto.asregulateid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.fstationname"/><%--厂站名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.fstationname" name="bhAsregulateDto.fstationname" type="text" value="${bhAsregulateForm.bhAsregulateDto.fstationname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.fwritedate"/><%--编制日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhAsregulateDto.fwritedate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${bhAsregulateForm.bhAsregulateDto.fwritedate}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.funitname"/><%--单位名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.funitname" name="bhAsregulateDto.funitname" type="text" value="${bhAsregulateForm.bhAsregulateDto.funitname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="bhAsregulateDto.version" name="bhAsregulateDto.version" type="text" value="${bhAsregulateForm.bhAsregulateDto.version}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.dispatchcenteropinion"/><%--调通中心批准意见--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.dispatchcenteropinion" name="bhAsregulateDto.dispatchcenteropinion" type="text" value="${bhAsregulateForm.bhAsregulateDto.dispatchcenteropinion}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.runmodedeptopinion"/><%--方式处批准意见--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.runmodedeptopinion" name="bhAsregulateDto.runmodedeptopinion" type="text" value="${bhAsregulateForm.bhAsregulateDto.runmodedeptopinion}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.protectdeptopinion"/><%--保护处审核意见--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.protectdeptopinion" name="bhAsregulateDto.protectdeptopinion" type="text" value="${bhAsregulateForm.bhAsregulateDto.protectdeptopinion}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.protectresponsor"/><%--保护专责人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.protectresponsor" name="bhAsregulateDto.protectresponsor" type="text" value="${bhAsregulateForm.bhAsregulateDto.protectresponsor}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.excutetime"/><%--执行时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.excutetime" name="bhAsregulateDto.excutetime" type="text" value="${bhAsregulateForm.bhAsregulateDto.excutetime}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.ondutyname"/><%--值班调度员--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.ondutyname" name="bhAsregulateDto.ondutyname" type="text" value="${bhAsregulateForm.bhAsregulateDto.ondutyname}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.asregulateoriginal"/><%--自投规程原件--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="asregulateoriginal" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.runmodedigram"/><%--运行方式图--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="runmodedigram" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.remarks"/><%--备注--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.remarks" name="bhAsregulateDto.remarks" type="text" value="${bhAsregulateForm.bhAsregulateDto.remarks}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.asregulateno"/><%--自投规程编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.asregulateno" name="bhAsregulateDto.asregulateno" type="text" value="${bhAsregulateForm.bhAsregulateDto.asregulateno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.fiscancel"/><%--是否作废--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.fiscancel" name="bhAsregulateDto.fiscancel" type="text" value="${bhAsregulateForm.bhAsregulateDto.fiscancel}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.sys_fille" name="bhAsregulateDto.sys_fille" type="text" value="${bhAsregulateForm.bhAsregulateDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.sys_filldept" name="bhAsregulateDto.sys_filldept" type="text" value="${bhAsregulateForm.bhAsregulateDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="bhAsregulateDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${bhAsregulateForm.bhAsregulateDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.sys_isvalid" name="bhAsregulateDto.sys_isvalid" type="text" value="${bhAsregulateForm.bhAsregulateDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.bhAsregulateDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="bhAsregulateDto.sys_dataowner" name="bhAsregulateDto.sys_dataowner" type="text" value="${bhAsregulateForm.bhAsregulateDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
	    		    </tr>
		
            		
	 	  
		   

	 </tr>
	
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
