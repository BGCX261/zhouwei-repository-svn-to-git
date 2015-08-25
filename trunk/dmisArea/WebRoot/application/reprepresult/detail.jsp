<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>报表结果详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/reprepresult/detail.js"></script>
</head>
<body>
<html:javascript formName="repRepresultForm"/>
<logic:messagesPresent message="true">
	<html:messages id="message" message="true" header="messages.header" footer="messages.footer">
		<script language="javascript">
			dealMessage('<bean:write name="message" ignore="true" />');
		</script>
	</html:messages> 
</logic:messagesPresent>
 <form name="repRepresultForm" action="" method="post" >
<%--hidden--%>

<input type="hidden" name="repRepresultDto.frepresultid" value="${repRepresultForm.repRepresultDto.frepresultid}">
<input type="hidden" name="repRepresultDto.version" value="${repRepresultForm.repRepresultDto.version}">

<jhop:ctrlgroup ctrlId="UIControlGroupXPanelfccffe5a13454ee092fc7e5b8588fb3d" title="报表结果"> </jhop:ctrlgroup>

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanelfccffe5a13454ee092fc7e5b8588fb3d">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
     <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.frepresultid"/><%--报表结果ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.frepresultid" name="repRepresultDto.frepresultid" type="text" value="${repRepresultForm.repRepresultDto.frepresultid}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.treeid"/><%--分类ID--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.treeid" name="repRepresultDto.treeid" type="text" value="${repRepresultForm.repRepresultDto.treeid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.fname"/><%--名称--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.fname" name="repRepresultDto.fname" type="text" value="${repRepresultForm.repRepresultDto.fname}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.ftitle"/><%--报表标题--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.ftitle" name="repRepresultDto.ftitle" type="text" value="${repRepresultForm.repRepresultDto.ftitle}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.freportyear"/><%--报表年度--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.freportyear" name="repRepresultDto.freportyear" type="text" value="${repRepresultForm.repRepresultDto.freportyear}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.freportunit"/><%--填报单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.freportunit" name="repRepresultDto.freportunit" type="text" value="${repRepresultForm.repRepresultDto.freportunit}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.frawdata"/><%--原始报表结果数据--%><span class="article_required">*</span></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.frawdata" name="repRepresultDto.frawdata" type="text" value="${repRepresultForm.repRepresultDto.frawdata}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.fotherinfo"/><%--其他信息--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.fotherinfo" name="repRepresultDto.fotherinfo" type="text" value="${repRepresultForm.repRepresultDto.fotherinfo}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.fdescription"/><%--描述--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.fdescription" name="repRepresultDto.fdescription" type="text" value="${repRepresultForm.repRepresultDto.fdescription}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.frepmonth"/><%--报表月份--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.frepmonth" name="repRepresultDto.frepmonth" type="text" value="${repRepresultForm.repRepresultDto.frepmonth}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.frepseason"/><%--报表季度--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.frepseason" name="repRepresultDto.frepseason" type="text" value="${repRepresultForm.repRepresultDto.frepseason}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.frepday"/><%--报表日期--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="repRepresultDto.frepday" genText="yes" dateFormat="yyyy-mm-dd" initValue="${repRepresultForm.repRepresultDto.frepday}" ></jhop:date>
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.sys_fille"/><%--填写人--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.sys_fille" name="repRepresultDto.sys_fille" type="text" value="${repRepresultForm.repRepresultDto.sys_fille}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.sys_filldept"/><%--填写单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.sys_filldept" name="repRepresultDto.sys_filldept" type="text" value="${repRepresultForm.repRepresultDto.sys_filldept}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.sys_filltime"/><%--填写时间--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <jhop:date name="repRepresultDto.sys_filltime" genText="yes" dateFormat="yyyy-mm-dd hh:mm:ss" initValue="${repRepresultForm.repRepresultDto.sys_filltime}" ></jhop:date>
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.sys_isvalid"/><%--是否有效字段--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.sys_isvalid" name="repRepresultDto.sys_isvalid" type="text" value="${repRepresultForm.repRepresultDto.sys_isvalid}" size="10"  />
			   </td>
			  			  
	    		    </tr>
	   <tr>
				
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.sys_dataowner"/><%--数据所属单位--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.sys_dataowner" name="repRepresultDto.sys_dataowner" type="text" value="${repRepresultForm.repRepresultDto.sys_dataowner}" size="10"  />
			   </td>
			  			  
	    		
			  			   <td height="23" class="tab_0" width="20%">
				 <bean:message key="object.repRepresultDto.version"/><%--数据库版本控制--%></td>
			  			  
	    		
			  			   <td height="23" width="30%" >
				 <input id="repRepresultDto.version" name="repRepresultDto.version" type="text" value="${repRepresultForm.repRepresultDto.version}" size="10"  />
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
