<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>所有设备公用参数详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/etsequipment/detail.js"></script>
</head>
<body>
<html:javascript formName="etsEquipmentForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="etsEquipmentForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="etsEquipmentDto.feqpid" value="${etsEquipmentForm.etsEquipmentDto.feqpid}">
<input type="hidden" name="etsEquipmentDto.version" value="${etsEquipmentForm.etsEquipmentDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel466ac3bc7af84afe9ed02fccbd9c4d97" title="所有设备公用参数"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel466ac3bc7af84afe9ed02fccbd9c4d97">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.feqpid"/><%--设备ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.feqpid" name="etsEquipmentDto.feqpid" type="text" value="${etsEquipmentForm.etsEquipmentDto.feqpid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fstorelocation"/><%--设备存放地点--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fstorelocation" name="etsEquipmentDto.fstorelocation" type="text" value="${etsEquipmentForm.etsEquipmentDto.fstorelocation}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fstationname"/><%--变电站--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fstationname" name="etsEquipmentDto.fstationname" type="text" value="${etsEquipmentForm.etsEquipmentDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fscheduleno"/><%--调度号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fscheduleno" name="etsEquipmentDto.fscheduleno" type="text" value="${etsEquipmentForm.etsEquipmentDto.fscheduleno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevsequence"/><%--设备编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevsequence" name="etsEquipmentDto.fdevsequence" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevsequence}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevclassname"/><%--设备名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevclassname" name="etsEquipmentDto.fdevclassname" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevclassname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevicetype"/><%--类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevicetype" name="etsEquipmentDto.fdevicetype" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevicetype}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevicemodel"/><%--设备型号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevicemodel" name="etsEquipmentDto.fdevicemodel" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevicemodel}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fschedulerange"/><%--调度范围--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fschedulerange" name="etsEquipmentDto.fschedulerange" type="text" value="${etsEquipmentForm.etsEquipmentDto.fschedulerange}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevfac"/><%--生产厂家--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevfac" name="etsEquipmentDto.fdevfac" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevfac}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fmadecountry"/><%--制造国家--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fmadecountry" name="etsEquipmentDto.fmadecountry" type="text" value="${etsEquipmentForm.etsEquipmentDto.fmadecountry}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fleavefacno"/><%--出厂编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fleavefacno" name="etsEquipmentDto.fleavefacno" type="text" value="${etsEquipmentForm.etsEquipmentDto.fleavefacno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fleavefacdate"/><%--出厂日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.fleavefacdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${etsEquipmentForm.etsEquipmentDto.fleavefacdate}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.finstalldate"/><%--安装日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.finstalldate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${etsEquipmentForm.etsEquipmentDto.finstalldate}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.frunningdate"/><%--投运日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.frunningdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${etsEquipmentForm.etsEquipmentDto.frunningdate}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevicestatus"/><%--设备状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevicestatus" name="etsEquipmentDto.fdevicestatus" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevicestatus}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevicelevel"/><%--定级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevicelevel" name="etsEquipmentDto.fdevicelevel" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevicelevel}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fratedvoltage"/><%--额定电压--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fratedvoltage" name="etsEquipmentDto.fratedvoltage" type="text" value="${etsEquipmentForm.etsEquipmentDto.fratedvoltage}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.foperatingvoltage"/><%--运行电压--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.foperatingvoltage" name="etsEquipmentDto.foperatingvoltage" type="text" value="${etsEquipmentForm.etsEquipmentDto.foperatingvoltage}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fneutralvoltage"/><%--中性点电压--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fneutralvoltage" name="etsEquipmentDto.fneutralvoltage" type="text" value="${etsEquipmentForm.etsEquipmentDto.fneutralvoltage}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.frecycled"/><%--是否报废--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.frecycled" name="etsEquipmentDto.frecycled" type="text" value="${etsEquipmentForm.etsEquipmentDto.frecycled}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fstopdate"/><%--退运日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.fstopdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${etsEquipmentForm.etsEquipmentDto.fstopdate}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.foperatingunit"/><%--运行单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.foperatingunit" name="etsEquipmentDto.foperatingunit" type="text" value="${etsEquipmentForm.etsEquipmentDto.foperatingunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fmaintainunit"/><%--维护单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fmaintainunit" name="etsEquipmentDto.fmaintainunit" type="text" value="${etsEquipmentForm.etsEquipmentDto.fmaintainunit}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fupdatetime"/><%--更新日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.fupdatetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${etsEquipmentForm.etsEquipmentDto.fupdatetime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fisdelete"/><%--是否删除--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fisdelete" name="etsEquipmentDto.fisdelete" type="text" value="${etsEquipmentForm.etsEquipmentDto.fisdelete}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fstationid"/><%--变电站ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fstationid" name="etsEquipmentDto.fstationid" type="text" value="${etsEquipmentForm.etsEquipmentDto.fstationid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fdevbuyfac"/><%--购货厂家--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fdevbuyfac" name="etsEquipmentDto.fdevbuyfac" type="text" value="${etsEquipmentForm.etsEquipmentDto.fdevbuyfac}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.foverhaullife"/><%--大修周期(月)--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.foverhaullife" name="etsEquipmentDto.foverhaullife" type="text" value="${etsEquipmentForm.etsEquipmentDto.foverhaullife}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fminoverhaullife"/><%--小修周期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fminoverhaullife" name="etsEquipmentDto.fminoverhaullife" type="text" value="${etsEquipmentForm.etsEquipmentDto.fminoverhaullife}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.ftmprepairlife"/><%--修试、试验周期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.ftmprepairlife" name="etsEquipmentDto.ftmprepairlife" type="text" value="${etsEquipmentForm.etsEquipmentDto.ftmprepairlife}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fcompareversion"/><%--对比版本号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fcompareversion" name="etsEquipmentDto.fcompareversion" type="text" value="${etsEquipmentForm.etsEquipmentDto.fcompareversion}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fbayname"/><%--所属间隔名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fbayname" name="etsEquipmentDto.fbayname" type="text" value="${etsEquipmentForm.etsEquipmentDto.fbayname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fbelstatype"/><%--所属厂站类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fbelstatype" name="etsEquipmentDto.fbelstatype" type="text" value="${etsEquipmentForm.etsEquipmentDto.fbelstatype}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.sys_fille" name="etsEquipmentDto.sys_fille" type="text" value="${etsEquipmentForm.etsEquipmentDto.sys_fille}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.sys_filldept" name="etsEquipmentDto.sys_filldept" type="text" value="${etsEquipmentForm.etsEquipmentDto.sys_filldept}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="etsEquipmentDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${etsEquipmentForm.etsEquipmentDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.sys_isvalid" name="etsEquipmentDto.sys_isvalid" type="text" value="${etsEquipmentForm.etsEquipmentDto.sys_isvalid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.sys_dataowner" name="etsEquipmentDto.sys_dataowner" type="text" value="${etsEquipmentForm.etsEquipmentDto.sys_dataowner}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.etsEquipmentDto.fvoltagelevel"/><%--电压等级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="etsEquipmentDto.fvoltagelevel" name="etsEquipmentDto.fvoltagelevel" type="text" value="${etsEquipmentForm.etsEquipmentDto.fvoltagelevel}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
