<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>流转历史</title>
		<link href="../../themes/themes1/style.css" rel="stylesheet"
			type="text/css" />
<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">			
</head>
<body>

			<jhop:ctrlgroup
				ctrlId="UIControlGroupXPanelacHistory"
				title="流转历史" isEdit="yes">
			</jhop:ctrlgroup>

			<table class="detailmain" cellspacing="0" height="30%"
				cellpadding="0"
				id="UIControlGroupXPanelacHistory">
				<tr>
					<td align="center" height="150">
						<iframe name="iGrid" frameborder='0' width="100%" 　scrolling="yes"
							height="150"
							src='<%=request.getContextPath()%>/application/todolist/handlehistoryGrid.jsp?busId=<%=request.getParameter("busId")%>'></iframe>

					</td>
				</tr>
			</table>
<table>	
<tr align="left">
<td >		
<font color="red">提示: 如果以下不能正常显示工作流流转图,请先下载并安装插件</font>   <a href="http://www.adobe.com/svg/viewer/install/main.html"> SVG插件</a>	
</td>
</tr>
</table>	
				
			
			
			<table class="detailmain" cellspacing="0" height="1000"
				cellpadding="0"
				id="UIControlGroupXPanelacPicture">
				<tr>
					<td align="center" height="100%">
<EMBED name=test pluginspage=http://www.adobe.com/svg/viewer/install/ 
src="<%=request.getContextPath()%>/todolist.do?method=transitionLog&taskInstanceId=<%=request.getParameter("taskInstanceId")%>" 
width=100% height=100% type=image/svg+xml> 
					</td>
				</tr>
			</table>			
</body>
</html>