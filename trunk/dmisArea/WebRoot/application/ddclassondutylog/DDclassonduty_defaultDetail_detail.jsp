<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>调度交接班记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddClassondutylogForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddClassondutylogForm" action="" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="ddClassondutylogDto.fid" value="${ddClassondutylogForm.ddClassondutylogDto.fid}">
<input type="hidden" name="ddClassondutylogDto.version" value="${ddClassondutylogForm.ddClassondutylogDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel68d85c7ed1f54cd8a6e66abafeb3f7b7" title="调度值班班志"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel68d85c7ed1f54cd8a6e66abafeb3f7b7">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
     			<td height="23" width="30%" >
				 <bean:message key="object.ddClassondutylogDto.sys_filltime"/><%--填写时间--%>
					  			   <td height="23" class="tab_0" width="20%">
				 <jhop:date name="ddClassondutylogDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddClassondutylogForm.ddClassondutylogDto.sys_filltime}" ></jhop:date></td>
			  	    			  			   
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.sys_dataowner" name="ddClassondutylogDto.sys_dataowner" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fworkshift"/><%--班次--%></td>
			  	    			  			   <td height="23" width="30%" >
			  	  <jhop:select name="ddClassondutylogDto.fworkshift" initValue="${ddClassondutylogForm.ddClassondutylogDto.fworkshift}" type="fworkshift"></jhop:select>

			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fforecast"/><%--气象情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.fforecast" name="ddClassondutylogDto.fforecast" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.fforecast}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_afbe2fcf-2b19-45bc-8ce6-2044aa8d3cfe"/><%--值班值长--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <input type="text" name="ddClassondutylogDto.fdelresponser" value="${ddClassondutylogForm.ddClassondutylogDto.fdelresponser}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fdelresponser');">
</td>
			  	    			  			   <td height="23" width="30%" >
				 <bean:message key="define.uILabel_a65382df-a136-45c3-a27e-92047eb95d10"/><%--值班正值--%><span class="article_required">*</span>
			   </td>
			  	    			  			   <td height="23" width="30%" >
				 <input type="text" name="ddClassondutylogDto.fdelworkgroup" value="${ddClassondutylogForm.ddClassondutylogDto.fdelworkgroup}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fdelworkgroup');">

			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="define.uILabel_76c57847-1720-42ce-9c2c-a49fbe461c94"/><%--值班副值--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input type="text" name="ddClassondutylogDto.fdelattworkgroup" value="${ddClassondutylogForm.ddClassondutylogDto.fdelattworkgroup}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fdelattworkgroup');">

			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.sys_fille" name="ddClassondutylogDto.sys_fille" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddClassondutylogDto.sys_filldept" name="ddClassondutylogDto.sys_filldept" type="text" value="${ddClassondutylogForm.ddClassondutylogDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fminister"/><%--接班值长--%><span class="article_required">*</span></td>
			  	    			  			   
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <input type="text" name="ddClassondutylogDto.fminister" value="${ddClassondutylogForm.ddClassondutylogDto.fminister}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fminister');">
</td>
<td height="23" width="30%" >
				 <bean:message key="object.ddClassondutylogDto.fmainattendant"/><%--接班正值--%><span class="article_required">*</span>
			   </td>
			  	    			  			   <td height="23" width="30%" >
				 <input type="text" name="ddClassondutylogDto.fmainattendant" value="${ddClassondutylogForm.ddClassondutylogDto.fmainattendant}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fmainattendant');">

			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fsecondattendant"/><%--接班副值--%></td>
			  	    			  			   <td height="23" width="30%"  colspan="3"  >
				 <input type="text" name="ddClassondutylogDto.fsecondattendant" value="${ddClassondutylogForm.ddClassondutylogDto.fsecondattendant}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setfpersonSelect('ddClassondutylogDto.fsecondattendant');">

			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fsuccessiontime"/><%--值班开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddClassondutylogDto.fsuccessiontime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddClassondutylogForm.ddClassondutylogDto.fsuccessiontime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddClassondutylogDto.fhandovertime"/><%--值班结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddClassondutylogDto.fhandovertime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddClassondutylogForm.ddClassondutylogDto.fhandovertime}" ></jhop:date>
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
