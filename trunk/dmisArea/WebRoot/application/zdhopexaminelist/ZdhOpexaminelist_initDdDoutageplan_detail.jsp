<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page language="java" buffer="18kb"%>
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/components/tag/grid/twoGridDemo.js"></script>
	
</head>
<body>
<br>

<br>
<div id='mygrid'></div>
<br>
<div id='standGridPage'></div>
<!--<jhop:page currPage="1" pageSize="15" totalCount="30" urlStr="" ></jhop:page>--> 
<script>
		
		function saveData(type){
			if(type != "cannel"){
				 var url = "<%=request.getContextPath()%>/zdhOpexaminelist.do?method=initDdDoutageplan";
       			var pars = "";
              	var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       			function callBackGrid(originalRequest){
     
           		if(originalRequest){
            
	              if("改变状态失败" != originalRequest.responseText){
		              var paramObj = new Object();
					  window.returnValue  = paramObj;
					  window.close();
           			}
					 else {
                  		alert("修改状态失败!");
              			}

           			}

       			}
                
			}
			else
			{
				var paramObj = new Object();
			    window.returnValue  = paramObj;
			    window.close();
			}
			
		}
</script>
<table>
			<tr>
				<td align="right">
					<div align="right">
						<input type="button" class="inputbutton" name="button" value="  确 认  " onClick="saveData('enter')">
						<input type="button" class="inputbutton" name="button" value="  取 消  " onClick="saveData('cannel')">
					</div>
				</td>
			</tr>
		 </table>
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


</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="DdDoutageplanDto"
      subName="128197051371530608"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="DdDoutageplan"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="/zdhOpexaminelist.do?method=standGridQuery1">
</jhop:grid>
