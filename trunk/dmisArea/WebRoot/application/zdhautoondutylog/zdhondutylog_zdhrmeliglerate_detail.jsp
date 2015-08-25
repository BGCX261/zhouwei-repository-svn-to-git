<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>自动化值班日志详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhrmeliglerate_detail.js"></script>
</head>
<body>
<html:javascript formName="zdhAutoondutylogForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="zdhAutoondutylogForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="zdhAutoondutylogDto.ondutyno" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.ondutyno}">
<input type="hidden" name="zdhAutoondutylogDto.version" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6546abd922ed4fa285e20f44e1fcc674" title="遥测合格率"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6546abd922ed4fa285e20f44e1fcc674">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.fzdheligiblermrate1.reportsdate"/><%--报表日期--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhAutoondutylogDto.fzdheligiblermrate1.reportsdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.reportsdate}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.fzdheligiblermrate1.remotemeasureamount"/><%--遥测数据总数--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhAutoondutylogDto.fzdheligiblermrate1.remotemeasureamount" name="zdhAutoondutylogDto.fzdheligiblermrate1.remotemeasureamount" type="text" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.remotemeasureamount}" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.fzdheligiblermrate1.failuredatanoamount"/><%--不合格数据个数--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhAutoondutylogDto.fzdheligiblermrate1.failuredatanoamount" name="zdhAutoondutylogDto.fzdheligiblermrate1.failuredatanoamount" type="text" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.failuredatanoamount}" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.fzdheligiblermrate1.eligiblerate"/><%--遥测数据合格率(%)--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhAutoondutylogDto.fzdheligiblermrate1.eligiblerate" name="zdhAutoondutylogDto.fzdheligiblermrate1.eligiblerate" type="text" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.eligiblerate}" size="10" readonly="true" />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.remarks"/><%--备注--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <textarea id='zdhAutoondutylogDto.fzdheligiblermrate1.remarks' name='zdhAutoondutylogDto.fzdheligiblermrate1.remarks' rows='3' cols='50' readonly='true'>${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.remarks}</textarea>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="zdhAutoondutylogDto.fzdheligiblermrate1.sys_fille" name="zdhAutoondutylogDto.fzdheligiblermrate1.sys_fille" type="text" value="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.sys_fille}" size="10" readonly="true" />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.zdhAutoondutylogDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="zdhAutoondutylogDto.fzdheligiblermrate1.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${zdhAutoondutylogForm.zdhAutoondutylogDto.fzdheligiblermrate1.sys_filltime}" ></jhop:date>
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
