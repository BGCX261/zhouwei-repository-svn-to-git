<%@ page language="java" pageEncoding="utf-8"%>

<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page import="com.techstar.dmis.common.ZdhConstants" %>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrecord.js"> </script>
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
	
	
</head>
<body>
<br>
<%
	String url = "/zdhMachineworklist.do?method=standGridQuery&extOrder=workingtime desc";
	String listBox ="opButton_1#8^$/zdhMachineworklist.do?method=showDetail@@@600@@@500@@@来源记录详情@@@auto@@@单击浏览@@@opButton_1@@@2";
	
	
 %>
		<script type="text/javascript">
		
	  	  function exOperation(grid,colName){
	  	  
	  	  var workType=grid.getValByRC(grid.getSelectedRows(),'jobcategory');
	  	  var workId=grid.getValByRC(grid.getSelectedRows(),'workingsources');
	
  	    
  	    var url="";
  	    
  	   if(workType=="<%=ZdhConstants.ZdhMachinehallist_WORKBILL_SOURCE%>"){
  	    
  	        url = "<%=request.getContextPath()%>/zdhWorkbill.do?method=showWorkbilldetail&mainId="+workId;
  	        showModalDialogYY(url,600,600,""," ԭ工作来源",1);
            return true;
  	   }else  if(workType=="<%=ZdhConstants.ZDH_MACHINEWORK%>"){
  	        url = "<%=request.getContextPath()%>/zdhFaultlist.do?method=showFaultlistdetail&mainId="+workId;
  	        showModalDialogYY(url,600,500,""," ԭ工作来源",1);
  	   }
		else
		{
		dealMessage('没有工作来源！');
		return false;
		
		}
    }
  	   
  	
</script>
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
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="ZdhMachineworklistDto"
      subName="128201284399267904"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="ZdhMachineworklist"
      listBox="<%=listBox %>"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      isOutputSet="1"
      queryPath="<%=url %>">
</jhop:grid>