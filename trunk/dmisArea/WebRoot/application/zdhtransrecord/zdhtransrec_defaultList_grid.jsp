<%@ page language="java" pageEncoding="utf-8"%>

<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
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
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
	</head>
	<body>
		<%
		String url = "/zdhTransrecord.do?method=standGridQuery&extOrder=transdate desc";
	    String listBox ="opButton_1#8^/zdhTransrecord.do?method=showDetail@@@600@@@500@@@来源记录详情@@@auto@@@显示工作来源@@@opButton_1@@@2,opButton_2#8^$/zdhTransrecord.do?method=showImg@@@600@@@500@@@显示图片@@@auto@@@显示图片@@@opButton_2@@@2";
	 
		%>

		<script type="text/javascript">
		
	   function exOperation(grid,colName){

			var mainId=mygrid.getValByRC(grid.getSelectedRows(),'transrecordid');

  	  	  	var workType=grid.getValByRC(grid.getSelectedRows(),'tasksource');	  		
	  		var workId=grid.getValByRC(grid.getSelectedRows(),'sourcetaskno');  	   
	  	    var url="";
	  
	  	   if(colName=="opButton_1"&&workType=="<%=ZdhConstants.ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP%>"){
	  	    
	  	        url = "<%=request.getContextPath()%>/zdhSrapplication.do?method=showSrapplicationdetail&mainId="+workId;
	  	         showModalDialogYY(url,600,500,""," ԭ工作来源",1);
	  	         return true;
	  	   }else  if(colName=="opButton_1"&&workType=="<%=ZdhConstants.ZdhReception_WORKSOURCE%>"){
	  	        url = "<%=request.getContextPath()%>/zdhReception.do?method=showReceptiondetail&mainId="+workId;
	  	         showModalDialogYY(url,600,500,""," ԭ工作来源",1);
	  	         return true;
	  	   }else  if(colName=="opButton_2"&&mainId!=null&&mainId!=""){
	  	   		url = "<%=request.getContextPath()%>/zdhTransrecord.do?method=showImg&mainId="+mainId;
	  	   		 showModalDialogYY(url,600,500,""," 图片",1);
	  	   		 return true;
	  	   }else  if(mainId==null||mainId==""){
	  	   	dealMessage('没有选中行！');
			return false;
	  	   }
   			else
			{
			dealMessage('没有工作来源！');
			return false;
			
			}
		
    }
  	   
  	
</script>
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
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid id="mygrid" pageId="standGridPage"
	busName="ZdhTransrecordDto" 
	subName="128201286727115184" 
	pageItems="30"
	listType="3" 
	listKind="101" 
	entityName="ZdhTransrecord"
	listBox="<%=listBox %>"
	isDisplaySet="1" 
	isQuerySet="1" 
	isPageSet="1" 
	isOutputSet="1"
	queryPath="<%=url %>">
</jhop:grid>
