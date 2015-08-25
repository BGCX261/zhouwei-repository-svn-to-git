<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>低频装置负荷数据表的属性清单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fsloaddatalist/detail.js"></script>
</head>
<body>
<html:javascript formName="fsLoaddatalistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsLoaddatalistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsLoaddatalistDto.floaddatano" value="${fsLoaddatalistForm.fsLoaddatalistDto.floaddatano}">
<input type="hidden" name="fsLoaddatalistDto.version" value="${fsLoaddatalistForm.fsLoaddatalistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel65057642b6cc43cdb4c74a5d6b2ac047" title="低频装置负荷数据表的属性清单"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel65057642b6cc43cdb4c74a5d6b2ac047">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.floaddatano"/><%--数据编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.floaddatano" name="fsLoaddatalistDto.floaddatano" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.floaddatano}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.facquisitiondate"/><%--数据采集日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLoaddatalistDto.facquisitiondate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsLoaddatalistForm.fsLoaddatalistDto.facquisitiondate}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.fobservedvalue"/><%--实测--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.fobservedvalue" name="fsLoaddatalistDto.fobservedvalue" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.fobservedvalue}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.factualvalue"/><%--有效--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.factualvalue" name="fsLoaddatalistDto.factualvalue" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.factualvalue}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.fpvalue"/><%--有功--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.fpvalue" name="fsLoaddatalistDto.fpvalue" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.fpvalue}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.fmpvalue"/><%--方案值--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.fmpvalue" name="fsLoaddatalistDto.fmpvalue" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.fmpvalue}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.fstatus"/><%--低频投入状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.fstatus" name="fsLoaddatalistDto.fstatus" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.fstatus}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.froundno"/><%--低频定值轮次--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.froundno" name="fsLoaddatalistDto.froundno" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.froundno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.fmeasure"/><%--测量时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.fmeasure" name="fsLoaddatalistDto.fmeasure" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.fmeasure}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.sys_fille" name="fsLoaddatalistDto.sys_fille" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.sys_filldept" name="fsLoaddatalistDto.sys_filldept" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLoaddatalistDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsLoaddatalistForm.fsLoaddatalistDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.sys_isvalid" name="fsLoaddatalistDto.sys_isvalid" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLoaddatalistDto.sys_dataowner" name="fsLoaddatalistDto.sys_dataowner" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLoaddatalistDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="fsLoaddatalistDto.version" name="fsLoaddatalistDto.version" type="text" value="${fsLoaddatalistForm.fsLoaddatalistDto.version}" size="10"  />
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
