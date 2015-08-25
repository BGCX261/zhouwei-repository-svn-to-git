<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>低频减载装置参数的属性清单详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fslfparalist/FsLfparalist_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="fsLfparalistForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="fsLfparalistForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="fsLfparalistDto.flinesno" value="${fsLfparalistForm.fsLfparalistDto.flinesno}">
<input type="hidden" name="fsLfparalistDto.version" value="${fsLfparalistForm.fsLfparalistDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel6403b903d93f4ddcaf84e546788d6479" title="低周线路资料"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel6403b903d93f4ddcaf84e546788d6479">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fstationname"/><%--厂站名--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="fsLfparalistDto.fstationname" value="${fsLfparalistForm.fsLfparalistDto.fstationname}"/>
<input type="hidden" name="fsLfparalistDto.fstationid"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdStationSelect('fsLfparalistDto.fstationname','fsLfparalistDto.fstationid','0');">

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fvoltage"/><%--厂站电压等级--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fvoltage" name="fsLfparalistDto.fvoltage" type="text" value="${fsLfparalistForm.fsLfparalistDto.fvoltage}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.ftransformerno"/><%--变压器--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.ftransformerno" name="fsLfparalistDto.ftransformerno" type="text" value="${fsLfparalistForm.fsLfparalistDto.ftransformerno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fbusno"/><%--母线号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fbusno" name="fsLfparalistDto.fbusno" type="text" value="${fsLfparalistForm.fsLfparalistDto.fbusno}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_dataowner" name="fsLfparalistDto.sys_dataowner" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_isvalid" name="fsLfparalistDto.sys_isvalid" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fswitchno"/><%--开关号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fswitchno" name="fsLfparalistDto.fswitchno" type="text" value="${fsLfparalistForm.fsLfparalistDto.fswitchno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinename"/><%--线路名称--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.flinename" name="fsLfparalistDto.flinename" type="text" value="${fsLfparalistForm.fsLfparalistDto.flinename}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fdevfac"/><%--厂家--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fdevfac" name="fsLfparalistDto.fdevfac" type="text" value="${fsLfparalistForm.fsLfparalistDto.fdevfac}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fmodel"/><%--型号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fmodel" name="fsLfparalistDto.fmodel" type="text" value="${fsLfparalistForm.fsLfparalistDto.fmodel}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fmodeltype"/><%--型式--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fmodeltype" name="fsLfparalistDto.fmodeltype" type="text" value="${fsLfparalistForm.fsLfparalistDto.fmodeltype}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fownedunit"/><%--低频所辖单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="fsLfparalistDto.fownedunit" value="${fsLfparalistForm.fsLfparalistDto.fownedunit}"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdDispatchunitSelect('fsLfparalistDto.fownedunit','','0');">

			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fpowerowner"/><%--低频线路电源所属--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fpowerowner" name="fsLfparalistDto.fpowerowner" type="text" value="${fsLfparalistForm.fsLfparalistDto.fpowerowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fuowner"/><%--线路所属用户--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fuowner" name="fsLfparalistDto.fuowner" type="text" value="${fsLfparalistForm.fsLfparalistDto.fuowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fsmallarea"/><%--所属小地区--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsLfparalistDto.fsmallarea" hiddName="" type="StdSmallarea" initValue="${fsLfparalistForm.fsLfparalistDto.fsmallarea}"> </jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.frunstatus"/><%--低频投入状态--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsLfparalistDto.frunstatus" hiddName="" type="StdFslfrunmode" initValue="${fsLfparalistForm.fsLfparalistDto.frunstatus}"> </jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinevoltage"/><%--线路电压等级(kV)--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="fsLfparalistDto.flinevoltage" hiddName="" type="StdVoltage" initValue="${fsLfparalistForm.fsLfparalistDto.flinevoltage}"> </jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinegenerationdate"/><%--线路发电日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLfparalistDto.flinegenerationdate" genText="yes" dateFormat="yyyy-MM-dd" initValue="${fsLfparalistForm.fsLfparalistDto.flinegenerationdate}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.eqpid"/><%--对应保护装置ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.eqpid" name="fsLfparalistDto.eqpid" type="text" value="${fsLfparalistForm.fsLfparalistDto.eqpid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_fille" name="fsLfparalistDto.sys_fille" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_filldept" name="fsLfparalistDto.sys_filldept" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLfparalistDto.sys_filltime" genText="yes" dateFormat="yyyy-MM-dd hh:mm:ss" initValue="${fsLfparalistForm.fsLfparalistDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 &nbsp;</td>
			  			  
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
