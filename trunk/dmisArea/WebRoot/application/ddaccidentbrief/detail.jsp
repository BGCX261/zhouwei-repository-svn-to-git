<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>故障简报详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddaccidentbrief/detail.js"></script>
</head>
<body>
<html:javascript formName="ddAccidentbriefForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddAccidentbriefForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddAccidentbriefDto.faccidentid" value="${ddAccidentbriefForm.ddAccidentbriefDto.faccidentid}">
<input type="hidden" name="ddAccidentbriefDto.version" value="${ddAccidentbriefForm.ddAccidentbriefDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel84dc5e22dbb04e769a3cca01d0323146" title="故障简报"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel84dc5e22dbb04e769a3cca01d0323146">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.faccidentid"/><%--故障编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.faccidentid" name="ddAccidentbriefDto.faccidentid" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.faccidentid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.faccidentname"/><%--事故名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.faccidentname" name="ddAccidentbriefDto.faccidentname" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.faccidentname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.faccidenttime"/><%--故障发生时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddAccidentbriefDto.faccidenttime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.faccidenttime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fdispatcher"/><%--值班调度员--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fdispatcher" name="ddAccidentbriefDto.fdispatcher" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fdispatcher}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.freportedpeople"/><%--上报人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.freportedpeople" name="ddAccidentbriefDto.freportedpeople" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.freportedpeople}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.freportdate"/><%--上报时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddAccidentbriefDto.freportdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.freportdate}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.freporter"/><%--报知人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.freporter" name="ddAccidentbriefDto.freporter" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.freporter}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fnotifiedunit"/><%--通知有关单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fnotifiedunit" name="ddAccidentbriefDto.fnotifiedunit" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fnotifiedunit}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fnotifyoffice"/><%--通知本单位处室人员--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fnotifyoffice" name="ddAccidentbriefDto.fnotifyoffice" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fnotifyoffice}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.freportleadership"/><%--汇报领导--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.freportleadership" name="ddAccidentbriefDto.freportleadership" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.freportleadership}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.frecoverytime"/><%--故障恢复时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddAccidentbriefDto.frecoverytime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.frecoverytime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.ffaultequipmemt"/><%--故障设备--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.ffaultequipmemt" name="ddAccidentbriefDto.ffaultequipmemt" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.ffaultequipmemt}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fdispatchno"/><%--设备调度号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fdispatchno" name="ddAccidentbriefDto.fdispatchno" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fdispatchno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fline"/><%--线路名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fline" name="ddAccidentbriefDto.fline" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fline}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.flesspower"/><%--少送电度--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.flesspower" name="ddAccidentbriefDto.flesspower" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.flesspower}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fweather"/><%--天气--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fweather" name="ddAccidentbriefDto.fweather" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fweather}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fremark"/><%--备注--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fremark" name="ddAccidentbriefDto.fremark" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fremark}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.ftopdispreporttime"/><%--上级调度确认上报时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddAccidentbriefDto.ftopdispreporttime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.ftopdispreporttime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fovercurrenttime"/><%--过流次数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fovercurrenttime" name="ddAccidentbriefDto.fovercurrenttime" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fovercurrenttime}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fiftimes"/><%--速断次数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fiftimes" name="ddAccidentbriefDto.fiftimes" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fiftimes}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fothertimes"/><%--其他次数--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fothertimes" name="ddAccidentbriefDto.fothertimes" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fothertimes}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fcontrol"/><%--试发情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fcontrol" name="ddAccidentbriefDto.fcontrol" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fcontrol}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fgrounding"/><%--接地情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fgrounding" name="ddAccidentbriefDto.fgrounding" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fgrounding}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.freporthandle"/><%--现场报告及处理情况--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.freporthandle" name="ddAccidentbriefDto.freporthandle" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.freporthandle}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.flineid"/><%--线路名称ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.flineid" name="ddAccidentbriefDto.flineid" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.flineid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.accidentno"/><%--故障票正式编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.accidentno" name="ddAccidentbriefDto.accidentno" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.accidentno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fstationname"/><%--变电站名称--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fstationname" name="ddAccidentbriefDto.fstationname" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fstationid"/><%--变电站编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fstationid" name="ddAccidentbriefDto.fstationid" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fstationid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.accidentreason"/><%--故障原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.accidentreason" name="ddAccidentbriefDto.accidentreason" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.accidentreason}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.sys_fille" name="ddAccidentbriefDto.sys_fille" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.sys_filldept" name="ddAccidentbriefDto.sys_filldept" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddAccidentbriefDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddAccidentbriefForm.ddAccidentbriefDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.sys_isvalid"/><%--是否有效字段--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.sys_isvalid" name="ddAccidentbriefDto.sys_isvalid" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_isvalid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.sys_dataowner"/><%--数据所属单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.sys_dataowner" name="ddAccidentbriefDto.sys_dataowner" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.sys_dataowner}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fresult"/><%--处理结果--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fresult" name="ddAccidentbriefDto.fresult" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fresult}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fvoltage"/><%--故障电压等级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fvoltage" name="ddAccidentbriefDto.fvoltage" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fvoltage}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fimpact"/><%--故障影响--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fimpact" name="ddAccidentbriefDto.fimpact" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fimpact}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddAccidentbriefDto.fwhethercompleted"/><%--故障简报是否填完--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddAccidentbriefDto.fwhethercompleted" name="ddAccidentbriefDto.fwhethercompleted" type="text" value="${ddAccidentbriefForm.ddAccidentbriefDto.fwhethercompleted}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
