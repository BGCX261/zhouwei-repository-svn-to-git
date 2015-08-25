<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
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
  <script language="javascript" type="text/javascript"
			src="<%=request.getContextPath()%>/script/eqpEquipmentApi.js">
		</script>
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
 String listBox ="opButton_1#8^/zdhSrapplication.do?method=showInfo@@@800@@@600@@@显示文档@@@auto@@@显示文档@@@opButton_1@@@1,";
 listBox += "opButton_2#8^http://200.200.200.195:8989/eqp/eqpEquipment.do?method=eqpEquipmentframe@@@800@@@600@@@显示设备信息@@@auto@@@显示设备信息@@@opButton_2@@@2";
 %>
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
<%
      //以时间倒排序//
      String url = "/zdhSrapplication.do?method=standGridQuery&extOrder=sys_filltime desc";
     
   %>
<script type="text/javascript">
    function exOperation(grid,colName){
	   var vArguments = new Object();
         vArguments.title = "设备信息";
	     vArguments.viewId = "default";
	     vArguments.showButton = true;
	     vArguments.readOnly = false;
	     vArguments.returnedFields = "FMEMO,FEQPID,FSTORELOCATION,FDEVCLASSNAME,FLEAVEFACNO,FMADECOUNTRY";
	     vArguments.multiSelect = true;
	     //var url = encodeURI("http://200.200.200.233:8888/eqpbay/eqpEquipment.do?method=eqpEquipmentframe");
	     var url = encodeURI("http://200.200.200.195:8989/eqp/eqpEquipment.do?method=eqpEquipmentframe");
         var sReturn = OpenEquipmentModal(vArguments,url);
         if (sReturn == "" || sReturn == null || sReturn == "null" || typeof(sReturn) == 'undefined'){
            return false;
         }
         var xdoc = createDom();
	     xdoc.loadXML(sReturn);	
	     //获得根路径
	     var eqps = xdoc.getElementsByTagName("dataset");
	     for(var i=0;i<eqps.childNodes.length; i++){
	        var  eqp = eqps.childNodes[i]; 
	        var  id = eqp.getElementsByTagName("FEQPID")[0].firstChild;
	        alert(id);
	     }     
	   return true;
	}
    
</script>
</html>
<%-- 创建弹出窗口，并传递参数 --%>
<jhop:grid 	id="mygrid"
      pageId="standGridPage"
      busName="ZdhSrapplicationDto"
      subName="128196983508234952"
      pageItems="30"
      listType="3"
      listKind="101"
      entityName="ZdhSrapplication"
      listBox="<%=listBox %>"
      isDisplaySet="1"
      isQuerySet="1"
      isPageSet="1"
      queryPath="<%=url%>">
</jhop:grid>