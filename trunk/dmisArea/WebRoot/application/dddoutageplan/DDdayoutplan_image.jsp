<%@ page contentType="text/html; charset=GBK" language="java" buffer="18kb"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.*" %>
<%@ page import="com.techstar.dmis.dto.*" %>

<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<html:base/>
<title>传动记录详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../../themes/themes1/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrec_defaultDetail_detail.js"></script>
</head>
<body>

 <form name="ddDoutageplanForm" action="" method="post"   >
<%--hidden--%>

<input type="hidden" name="ddDoutageplanDto.fdayplanno"
				value="${ddDoutageplanForm.ddDoutageplanDto.fdayplanno}">
			<input type="hidden" name="ddDoutageplanDto.version"
				value="${ddDoutageplanForm.ddDoutageplanDto.version}">
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
					DdDoutageplanDto dto=(DdDoutageplanDto)request.getAttribute("dddto");
					OutputStream os =response.getOutputStream();
					if(dto!=null){
					System.out.println("aaa");
						System.out.println("dto.getFaddipicture="+dto.getFaddipicture());
						if(dto.getFaddipicture()!=null&&dto.getFaddipicture().length>0)
							os.write(dto.getFaddipicture());
						else
						{
						String message = "没有附件，请上传";
						os.write(message.getBytes());
						
						}
					}else{
						String message = "请选择记录";
						os.write(message.getBytes());
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
