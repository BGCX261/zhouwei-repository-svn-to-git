<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>日检修计划详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/dddoutageplan/detail.js"></script>
</head>
<body>
<html:javascript formName="ddDoutageplanForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddDoutageplanForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddDoutageplanDto.fdayplanno" value="${ddDoutageplanForm.ddDoutageplanDto.fdayplanno}">
<input type="hidden" name="ddDoutageplanDto.version" value="${ddDoutageplanForm.ddDoutageplanDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel4ae116413fb545569cfe60230ec70b3f" title="日检修计划"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel4ae116413fb545569cfe60230ec70b3f">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fdayplanno"/><%--日计划编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fdayplanno" name="ddDoutageplanDto.fdayplanno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fdayplanno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fmanualno"/><%--手工编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fmanualno" name="ddDoutageplanDto.fmanualno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fmanualno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fstationname"/><%--变电站--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fstationname" name="ddDoutageplanDto.fstationname" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fstationname}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fline"/><%--线路名--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fline" name="ddDoutageplanDto.fline" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fline}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fvoltage"/><%--电压等级--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fvoltage" name="ddDoutageplanDto.fvoltage" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fvoltage}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fworkarea"/><%--工作地点--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fworkarea" name="ddDoutageplanDto.fworkarea" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fworkarea}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.foutagearea"/><%--停电范围--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.foutagearea" name="ddDoutageplanDto.foutagearea" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.foutagearea}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fdispatchrange"/><%--调度范围--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fdispatchrange" name="ddDoutageplanDto.fdispatchrange" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fdispatchrange}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplystime"/><%--申请工作起始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapplystime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapplystime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplyetime"/><%--申请工作结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapplyetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapplyetime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplyoutagetime"/><%--申请停电时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapplyoutagetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapplyoutagetime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplyrestoretime"/><%--申请发电时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapplyrestoretime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapplyrestoretime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplyunit"/><%--申请单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapplyunit" name="ddDoutageplanDto.fapplyunit" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapplyunit}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplicant"/><%--申请人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapplicant" name="ddDoutageplanDto.fapplicant" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapplicant}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplytime"/><%--申请时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapplytime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapplytime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fsuitworkname"/><%--配合工作名--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fsuitworkname" name="ddDoutageplanDto.fsuitworkname" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fsuitworkname}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fremark"/><%--备注--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fremark" name="ddDoutageplanDto.fremark" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fremark}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.faddipicture"/><%--附图--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.faddipicture" name="ddDoutageplanDto.faddipicture" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.faddipicture}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.funmeasureannex"/><%--反措附件--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.funmeasureannex" name="ddDoutageplanDto.funmeasureannex" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.funmeasureannex}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fattention"/><%--注意事项--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fattention" name="ddDoutageplanDto.fattention" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fattention}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fpermitcontent"/><%--许可内容--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fpermitcontent" name="ddDoutageplanDto.fpermitcontent" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fpermitcontent}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapprooutageword"/><%--批准停电字--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapprooutageword" name="ddDoutageplanDto.fapprooutageword" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageword}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapprooutageno"/><%--批准停电号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapprooutageno" name="ddDoutageplanDto.fapprooutageno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapprooutageno}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapproworkstime"/><%--批准工作开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapproworkstime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapproworkstime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapproworketime"/><%--批准工作结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapproworketime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapproworketime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapprostime"/><%--批准停电开始时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapprostime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapprostime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapproetime"/><%--批准停电结束时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fapproetime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fapproetime}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fgenoutageseq"/><%--停发电操作顺序--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fgenoutageseq" name="ddDoutageplanDto.fgenoutageseq" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fgenoutageseq}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fplanappropeople"/><%--中调计划批准人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fplanappropeople" name="ddDoutageplanDto.fplanappropeople" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fplanappropeople}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fcanceltime"/><%--取消时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.fcanceltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.fcanceltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fabolish"/><%--取消人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fabolish" name="ddDoutageplanDto.fabolish" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fabolish}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fabolishreason"/><%--取消原因--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fabolishreason" name="ddDoutageplanDto.fabolishreason" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fabolishreason}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fstatus"/><%--状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fstatus" name="ddDoutageplanDto.fstatus" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fstatus}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fmergeplanno"/><%--合并计划编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fmergeplanno" name="ddDoutageplanDto.fmergeplanno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fmergeplanno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.freportdate"/><%--上报日期--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.freportdate" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.freportdate}" ></jhop:date>
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.frelapplyno"/><%--相关发电批准书编号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.frelapplyno" name="ddDoutageplanDto.frelapplyno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.frelapplyno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fplansourcetype"/><%--计划来源类型--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fplansourcetype" name="ddDoutageplanDto.fplansourcetype" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fplansourcetype}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fplansourceno"/><%--计划来源序号--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fplansourceno" name="ddDoutageplanDto.fplansourceno" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fplansourceno}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.flinenameid"/><%--线路名ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.flinenameid" name="ddDoutageplanDto.flinenameid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.flinenameid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fvoltageid"/><%--电压等级ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fvoltageid" name="ddDoutageplanDto.fvoltageid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fvoltageid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplyunitid"/><%--申请单位ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapplyunitid" name="ddDoutageplanDto.fapplyunitid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapplyunitid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fapplicantid"/><%--申请人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fapplicantid" name="ddDoutageplanDto.fapplicantid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fapplicantid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fplanapproid"/><%--中调计划批准人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fplanapproid" name="ddDoutageplanDto.fplanapproid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fplanapproid}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fabolishid"/><%--取消人ID--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fabolishid" name="ddDoutageplanDto.fabolishid" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fabolishid}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.ffilltype"/><%--是否调度员填写--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.ffilltype" name="ddDoutageplanDto.ffilltype" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.ffilltype}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.sys_fille"/><%--填写人--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.sys_fille" name="ddDoutageplanDto.sys_fille" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.sys_fille}" size="10"  />
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.sys_filldept"/><%--填写单位--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.sys_filldept" name="ddDoutageplanDto.sys_filldept" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.sys_filldept}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.sys_filltime"/><%--填写时间--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <jhop:date name="ddDoutageplanDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd" initValue="${ddDoutageplanForm.ddDoutageplanDto.sys_filltime}" ></jhop:date>
			   </td>
			  	    		    </tr>
	   <tr>
					  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fplanclass"/><%--计划分类--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fplanclass" name="ddDoutageplanDto.fplanclass" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fplanclass}" size="10"  />
			   </td>
			  	    			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddDoutageplanDto.fexcutestatus"/><%--执行状态--%></td>
			  	    			  			   <td height="23" width="30%" >
				 <input id="ddDoutageplanDto.fexcutestatus" name="ddDoutageplanDto.fexcutestatus" type="text" value="${ddDoutageplanForm.ddDoutageplanDto.fexcutestatus}" size="10"  />
			   </td>
			  	    		    </tr>
	</table>
	</td></tr>
</table>
	</form>
</body>
</html>
