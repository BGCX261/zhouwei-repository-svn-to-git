<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>

<% 
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
<head>
  <title>gridtest</title> 
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
    <link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/default.css">

	
</head>
<body>
<br>

<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage'></div>
<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>--> 
</body>	
<%--处理消息--%>
<%
	/*
	if (message != null && !message.equals("") && !message.equals("null")){
%>
		<script language="javascript">
			dealMessage('<%=message%>');
		</script>
<% 
	 }
	 */
%>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="StdStationDto"
      subName="128209034753246248"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="StdStation"
      isDisplaySet="0"
      isQuerySet="0"
      isPageSet="0"
      isOutputSet="0"
      isCheckBox="0" 
      queryPath="/stdStation.do?method=standGridQuery">
</jhop:grid>


	<table>
			<td>
				<div align="right">
					<input type="button" name="button" value="  确 认  "
						onClick="enterData('enter')">
					<input type="button" name="button" value="  取 消  "
						onClick="enterData('cannel')">
				</div>
			</td>
		</table>
		<br>
	</body>
	<script>

 	  /**
		*  提交数据到父页面,快捷查询时使用


		*  返回数组类型
		*  格式: 英文列名#第一列值,第二列值,第三列值....
		*/

			function enterData(type){
		    
			if(type != "cannel"){
			    var  datas = mygrid.getSelectedRowsData(3);
				//var  colNamesArra = "pm^药 品###dw^中国医药###pg^20*3###cd^北 京";
				//对话框取得参数

				window.returnValue 	= datas;
			}
			window.close();
		}
		
</script>
</html>
