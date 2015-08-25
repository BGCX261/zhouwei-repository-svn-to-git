<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>电网运行方式调整记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/ddpowerchangrecord/DDpowerchangrecord_defaultDetail_detail.js"></script>
</head>
<body>
<html:javascript formName="ddPowerchangrecordForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="ddPowerchangrecordForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="ddPowerchangrecordDto.fid" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fid}">
<input type="hidden" name="ddPowerchangrecordDto.version" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanel4bb89a3e7a6940b4b6d6d60cb55eadf3" title="电网运行方式调整"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel4bb89a3e7a6940b4b6d6d60cb55eadf3">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fstationname"/><%--厂站--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input type="text" name="ddPowerchangrecordDto.fstationname" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fstationname}"/>
<input type="hidden" name="ddPowerchangrecordDto.zddpowerchangrecord6.stationno"/>
<img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setStdStationSelect();">

			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fadjustreason"/><%--调整原因--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fadjustreason" name="ddPowerchangrecordDto.fadjustreason" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fadjustreason}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fadjustcontent"/><%--调整内容--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddPowerchangrecordDto.fadjustcontent" name="ddPowerchangrecordDto.fadjustcontent" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fadjustcontent}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="ddPowerchangrecordDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.zddpowerchangrecord4.fid"/><%--班志编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.zddpowerchangrecord4.fid" name="ddPowerchangrecordDto.zddpowerchangrecord4.fid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.zddpowerchangrecord4.fid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsendcmdtime"/><%--下令时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddPowerchangrecordDto.fsendcmdtime" endName="ddPowerchangrecordDto.frestoretime" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsendcmdtime}" dateFormat="yyyy-mm-dd hh:mm:ss" group="start" ></jhop:dateselect>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsendcmder"/> <%--下令人--%>				</td>
				 
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fsendcmder" name="ddPowerchangrecordDto.fsendcmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsendcmder}" size="10"  />
				 <img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setsendSelect('ddPowerchangrecordDto.fsendcmder');">
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.freccmder"/><%--受令人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddPowerchangrecordDto.freccmder" name="ddPowerchangrecordDto.freccmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.freccmder}" size="10"  />
				 <img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setacceptSelect('ddPowerchangrecordDto.freccmder');">
			   </td>
			   
			  
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.frestoretime"/><%--恢复时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:dateselect name="ddPowerchangrecordDto.frestoretime" startName="ddPowerchangrecordDto.fsendcmdtime" initValue="${ddPowerchangrecordForm.ddPowerchangrecordDto.frestoretime}" dateFormat="yyyy-mm-dd hh:mm:ss" group="end" ></jhop:dateselect>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fressendcmder"/><%--恢复下令人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fressendcmder" name="ddPowerchangrecordDto.fressendcmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fressendcmder}" size="10"  />
				 <img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setsendSelect('ddPowerchangrecordDto.fressendcmder');">
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fresreccmder"/><%--恢复受令人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%"  colspan="3"  >
				 <input id="ddPowerchangrecordDto.fresreccmder" name="ddPowerchangrecordDto.fresreccmder" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fresreccmder}" size="10"  />
				 <img id="img1" src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" onClick="setacceptSelect('ddPowerchangrecordDto.fresreccmder');">
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fwriteinlog"/><%--是否写入日志--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:select name="ddPowerchangrecordDto.fwriteinlog" type="text" initValue="是@@@是#否"></jhop:select>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fwriteinwglog"/><%--是否写入班志--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 
				 <jhop:select name="ddPowerchangrecordDto.fwriteinwglog" type="text" initValue="是@@@是#否"></jhop:select>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.fsrcno"/><%--来源记录编号--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.fsrcno" name="ddPowerchangrecordDto.fsrcno" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.fsrcno}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.flogtype"/><%--分类--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.flogtype" name="ddPowerchangrecordDto.flogtype" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.flogtype}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_isvalid" name="ddPowerchangrecordDto.sys_isvalid" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_dataowner"/><%--数据所属单�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_dataowner" name="ddPowerchangrecordDto.sys_dataowner" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_fille"/><%--填写�?--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_fille" name="ddPowerchangrecordDto.sys_fille" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.ddPowerchangrecordDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="ddPowerchangrecordDto.sys_filldept" name="ddPowerchangrecordDto.sys_filldept" type="text" value="${ddPowerchangrecordForm.ddPowerchangrecordDto.sys_filldept}" size="10"  />
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
