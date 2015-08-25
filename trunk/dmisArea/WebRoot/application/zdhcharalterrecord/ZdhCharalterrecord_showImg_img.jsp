<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.*" %>
<%@ page import="com.techstar.dmis.dto.*" %>

<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>停电图</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrec_defaultDetail_detail.js"></script>
</head>
<body>

 <form name="zdhTransrecordForm" action="" method="post"   >
<%--hidden--%>

<input type="hidden" name="zdhTransrecordDto.transrecordid" value="${zdhTransrecordForm.zdhTransrecordDto.transrecordid}">
<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6">
		<td align="center">	ervervfer
		</td>
		</tr>
		</table>
		
		

<table class="detailmain" cellspacing="0" cellpadding="0">
	  <tr id="UIControlGroupXPanel8b3f1ce63abd427083da3a8fcf86fec6">
		<td align="center">	
		 <table class="detail" width="100%" height="100%" cellspacing="0" >
          <tr>
          <td height="23" class="tab_0" width="20%">
        
          </td>
			   <td height="23" class="tab_0" width="20%">

				<% 
					ZdhCharalterrecordDto zdhCharalterrecordDto = (ZdhCharalterrecordDto)request.getAttribute("zdhCharalterrecordDto");
					OutputStream os =response.getOutputStream();
					if(zdhCharalterrecordDto.getMdiagram().length>0)
						os.write(zdhCharalterrecordDto.getMdiagram());
					else
					{
						String message = "没有系统图附件，请上传";
						os.write(message.getBytes());
						//os.write(message.getBytes("GBK"));
						//os.write(message.getBytes("utf-8"));
					
					}
						os.flush();
						os.close();
						os=null;
						response.flushBuffer();
						out.clear();
						out = pageContext.pushBody();
				%>
			   </td>  
	      </tr>
	    </table>
	</td></tr>
</table>
	</form>
</body>
</html>
