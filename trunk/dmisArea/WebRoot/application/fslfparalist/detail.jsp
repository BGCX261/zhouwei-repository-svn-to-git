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
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/fslfparalist/detail.js"></script>
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

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel5e9f659b3abd49dcbfdc5bb84c5f4b71" title="低频减载装置参数的属性清单"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel5e9f659b3abd49dcbfdc5bb84c5f4b71">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinesno"/><%--低周线路资料编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.flinesno" name="fsLfparalistDto.flinesno" type="text" value="${fsLfparalistForm.fsLfparalistDto.flinesno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fstationname"/><%--厂站名--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fstationname" name="fsLfparalistDto.fstationname" type="text" value="${fsLfparalistForm.fsLfparalistDto.fstationname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fstationid"/><%--厂站编号--%><span class="article_required">*</span></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fstationid" name="fsLfparalistDto.fstationid" type="text" value="${fsLfparalistForm.fsLfparalistDto.fstationid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fvoltage"/><%--厂站电压等级--%></td>
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
				 <bean:message key="object.fsLfparalistDto.fpowerowner"/><%--低频线路电源所属--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fpowerowner" name="fsLfparalistDto.fpowerowner" type="text" value="${fsLfparalistForm.fsLfparalistDto.fpowerowner}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fsmallarea"/><%--所属小地区--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fsmallarea" name="fsLfparalistDto.fsmallarea" type="text" value="${fsLfparalistForm.fsLfparalistDto.fsmallarea}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fownedunit"/><%--低频所辖单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fownedunit" name="fsLfparalistDto.fownedunit" type="text" value="${fsLfparalistForm.fsLfparalistDto.fownedunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.ffrequency"/><%--动作频率--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.ffrequency" name="fsLfparalistDto.ffrequency" type="text" value="${fsLfparalistForm.fsLfparalistDto.ffrequency}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.factiontime"/><%--动作时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.factiontime" name="fsLfparalistDto.factiontime" type="text" value="${fsLfparalistForm.fsLfparalistDto.factiontime}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fruntime"/><%--投入日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLfparalistDto.fruntime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsLfparalistForm.fsLfparalistDto.fruntime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flockoutvalue"/><%--电流闭锁值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.flockoutvalue" name="fsLfparalistDto.flockoutvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.flockoutvalue}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinegenerationdate"/><%--线路发电日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="fsLfparalistDto.flinegenerationdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${fsLfparalistForm.fsLfparalistDto.flinegenerationdate}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.flinevoltage"/><%--线路电压等级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.flinevoltage" name="fsLfparalistDto.flinevoltage" type="text" value="${fsLfparalistForm.fsLfparalistDto.flinevoltage}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fcoefficient"/><%--系数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fcoefficient" name="fsLfparalistDto.fcoefficient" type="text" value="${fsLfparalistForm.fsLfparalistDto.fcoefficient}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f4cvalue"/><%--4点电流值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f4cvalue" name="fsLfparalistDto.f4cvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f4cvalue}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f4pvalue"/><%--4点有功值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f4pvalue" name="fsLfparalistDto.f4pvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f4pvalue}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f10cvalue"/><%--10点电流值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f10cvalue" name="fsLfparalistDto.f10cvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f10cvalue}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f10pvalue"/><%--10点有功值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f10pvalue" name="fsLfparalistDto.f10pvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f10pvalue}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f0cvalue"/><%--前夜电流值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f0cvalue" name="fsLfparalistDto.f0cvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f0cvalue}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.f0pvalue"/><%--前夜有功值--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.f0pvalue" name="fsLfparalistDto.f0pvalue" type="text" value="${fsLfparalistForm.fsLfparalistDto.f0pvalue}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.fremark"/><%--备注--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.fremark" name="fsLfparalistDto.fremark" type="text" value="${fsLfparalistForm.fsLfparalistDto.fremark}" size="10"  />
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
				 <jhop:date name="fsLfparalistDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${fsLfparalistForm.fsLfparalistDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_isvalid" name="fsLfparalistDto.sys_isvalid" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_isvalid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.sys_dataowner" name="fsLfparalistDto.sys_dataowner" type="text" value="${fsLfparalistForm.fsLfparalistDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.froundno"/><%--低频定值轮次--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.froundno" name="fsLfparalistDto.froundno" type="text" value="${fsLfparalistForm.fsLfparalistDto.froundno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.fsLfparalistDto.frunstatus"/><%--低频投入状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="fsLfparalistDto.frunstatus" name="fsLfparalistDto.frunstatus" type="text" value="${fsLfparalistForm.fsLfparalistDto.frunstatus}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
