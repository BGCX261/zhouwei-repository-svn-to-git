<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.techstar.dmis.helper.BusinessDetailHelper" %>
<%@ page import="com.techstar.dmis.helper.dto.BusinessDetailDto" %>
<%@ page import="java.sql.Timestamp"%>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>传动记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrec_defaultDetail_detail.js"></script>
</head>
<body>

<html:javascript formName="zdhTransrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhTransrecordForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6" title="传动记录信息"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
       <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.fstationname"/><%--厂站--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				${zdhTransrecordForm.zdhTransrecordDto.fstationname}

			   </td>
			  			  
	    		
	  		  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.tasksource"/><%--任务来源--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				${zdhTransrecordForm.zdhTransrecordDto.tasksource}
			   </td>
			  			  
	    		    </tr>
	    <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transpeople"/><%--传动人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.transpeople}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transdate"/><%--传动日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.transdate}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transunit"/><%--传动单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.transunit}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.transrecordno"/><%--传动记录正式编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.transrecordno}
			   </td>
			  			  
	    		    </tr>
				<tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.explanation"/><%--传动内容说明--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhTransrecordForm.zdhTransrecordDto.explanation}
			   </td>
			  			  
	    		    </tr>
 	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.annexsequence"/><%--序位表附件--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
		<script>
				function showDetail(){
	 
        var url="/zdhTransrecord.do?method=showImg&mainId=${zdhTransrecordForm.zdhTransrecordDto.transrecordid}";
        
		var vReturnValue=showNotModalDialogYY(url,800,600);	
       
	 
					
	} 
			</script>
				<input type=button onClick="showDetail()" value="附件">
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sys_fille}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sys_filldept}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sys_filltime}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sys_isvalid}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sys_dataowner}
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.sourcetaskno"/><%--任务来源编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 ${zdhTransrecordForm.zdhTransrecordDto.sourcetaskno}
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhTransrecordDto.zzdhtransrecord3.ondutyno"/><%--交接班记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 ${zdhTransrecordForm.zdhTransrecordDto.zzdhtransrecord3.ondutyno}
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
