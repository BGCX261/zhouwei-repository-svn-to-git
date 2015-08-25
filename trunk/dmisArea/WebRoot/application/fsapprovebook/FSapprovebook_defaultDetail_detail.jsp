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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_defaultDetail_detail.js"></script>
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
 <form name="fsApprovebookForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="fsApprovebookDto.fapprovcomputerno" value="${fsApprovebookForm.fsApprovebookDto.fapprovcomputerno}">
<input type="hidden" name="fsApprovebookDto.version" value="${fsApprovebookForm.fsApprovebookDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel0b58f2cb6eaf445f992289f19a4ed8b6" title="启动信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel0b58f2cb6eaf445f992289f19a4ed8b6">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fstationname"/><%--厂站名--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="fsApprovebookDto.fstationname" value="${fsApprovebookForm.fsApprovebookDto.fstationname}"/>
<input type="hidden" name="fsApprovebookDto.fstationid"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdStationSelect('fsApprovebookDto.fstationname','fsApprovebookDto.fstationid','0');">

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
				 <input type="text" name="fsApprovebookDto.fprojectunit" value="${fsApprovebookForm.fsApprovebookDto.fprojectunit}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdUnitSelect('fsApprovebookDto.fprojectunit','','0');">

			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_10e8c9a7-5017-45ce-addc-8f5462b02ee5"/><%--其他资料--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <jhop:upload name="uIUpload_a5195df6-e04a-4011-ac1d-61b42f03c2e6" multiValue="yes"></jhop:upload>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_fille" name="fsApprovebookDto.sys_fille" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.sys_filldept" name="fsApprovebookDto.sys_filldept" type="text" value="${fsApprovebookForm.fsApprovebookDto.sys_filldept}" size="10"  />
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
				 <bean:message key="object.fsApprovebookDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsApprovebookDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsApprovebookForm.fsApprovebookDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fstationid"/><%--厂站编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fstationid" name="fsApprovebookDto.fstationid" type="text" value="${fsApprovebookForm.fsApprovebookDto.fstationid}" size="10"  />
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
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanelc5ec6396ea154a7b849d592645a10e11" title="批准书编制"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelc5ec6396ea154a7b849d592645a10e11">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fapprovbookno"/><%--正式编号--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fapprovbookno" name="fsApprovebookDto.fapprovbookno" type="text" value="${fsApprovebookForm.fsApprovebookDto.fapprovbookno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fwriterunit"/><%--批准书编制单位--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsApprovebookDto.fwriterunit" name="fsApprovebookDto.fwriterunit" type="text" value="${fsApprovebookForm.fsApprovebookDto.fwriterunit}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fvoltage"/><%--电压等级--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsApprovebookDto.fvoltage" hiddName="" type="StdVoltage" initValue="${fsApprovebookForm.fsApprovebookDto.fvoltage}"> </jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fsendtounit"/><%--抄送单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="fsApprovebookDto.fsendtounit" value="${fsApprovebookForm.fsApprovebookDto.fsendtounit}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdUnitSelect('fsApprovebookDto.fsendtounit','','1');">

			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_ac7c7f07-5f15-4500-bba5-a69dcf34b004"/><%--批准书附件--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="uIUpload_92bca998-859a-492d-b71f-e26cf08c4e50" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_34ed9b0e-fcfb-474b-a913-752272d38a39"/><%--停电图--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="uIUpload_3ada3df6-49f4-46d1-825c-b4fd86e67b46" multiValue="no"></jhop:upload>
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
	<jhop:ctrlgroup ctrlId="UIControlGroupXPanele81ca8427607410cbdfeabf648b753d0" title="执行情况"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanele81ca8427607410cbdfeabf648b753d0">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fproblem"/><%--执行过程说明--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='fsApprovebookDto.fproblem' name='fsApprovebookDto.fproblem' rows='3' cols='50' >${fsApprovebookForm.fsApprovebookDto.fproblem}</textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fcompletiondate"/><%--完成时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsApprovebookDto.fcompletiondate" genText="yes" dateFormat="yyyy-MM-dd" initValue="${fsApprovebookForm.fsApprovebookDto.fcompletiondate}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsApprovebookDto.fexcutestatus"/><%--执行状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsApprovebookDto.fexcutestatus" hiddName="" type="StdFinishstatus" initValue="${fsApprovebookForm.fsApprovebookDto.fexcutestatus}"> </jhop:select>
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
