<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电子章详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/stdelectricstamp/StdElectricstamp_defaultDetail_detail.js"></script>
</head>
<body>

 <form name="stdElectricstampForm" action="<%=request.getContextPath()%>/stdElectricstamp.do?method=saveDetail" method="post"  enctype="multipart/form-data" >
<%--hidden--%>

<input type="hidden" name="stdElectricstampDto.id" value="${stdElectricstampForm.stdElectricstampDto.id}">
<input type="hidden" name="stdElectricstampDto.version" value="${stdElectricstampForm.stdElectricstampDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPaneld9d2292bb62c402f8a9eeb81f0e709bb" title="电子章数据维护"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPaneld9d2292bb62c402f8a9eeb81f0e709bb">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdElectricstampDto.fstampname"/><%--名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="stdElectricstampDto.fstampname" name="stdElectricstampDto.fstampname" type="text" value="${stdElectricstampForm.stdElectricstampDto.fstampname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdElectricstampDto.fgraph"/><%--图形--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:upload name="fgraph" multiValue="no"></jhop:upload>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.stdElectricstampDto.ftype"/><%--分类--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="stdElectricstampDto.ftype" name="stdElectricstampDto.ftype" type="text" value="${stdElectricstampForm.stdElectricstampDto.ftype}" size="10"  />
			   </td>
			  			  
	    		    </tr>
		
                       				 <input id="stdElectricstampDto.version" name="stdElectricstampDto.version" type="hidden" value="${stdElectricstampForm.stdElectricstampDto.version}"  />
		   		      		
	 	  
		   

	 </tr>
	<input type="submit" name ="submit">
</table>
	</td></tr>
</table>
	</form>
</body>
</html>
