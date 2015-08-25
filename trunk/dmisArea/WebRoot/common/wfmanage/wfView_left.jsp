<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/init_tag.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
	<script  src="<%=request.getContextPath()%>/script/dhtmlXCommon.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree_xw.js"></script>
	<script  src="<%=request.getContextPath()%>/script/tag/tree/dhtmlXTree_li.js"></script>	
	<script  src="<%=request.getContextPath()%>/script/tag/tree/jhoptree.js"></script>
	<!--  script  src="<%=request.getContextPath()%>/script/tree/treeutil.js"></script>-->
<title>
</title>
<script type="text/javascript">
  	function choise_node(){
  	    var item_id = getSelectedItemId(jhoptree);
  	    var type = getUserDate(jhoptree,item_id);
  	    var s2=type.replace("#","&");
		    var url_para = "node_id="+item_id+"&type="+s2;
		    alert(url_para);
		    window.open("<%=request.getContextPath()%>/wfmanager.do?method=getWFView_Task&"+url_para,"rightFrame");
		
	}
</script>
</head>
<body>



<table width="180" border="1">
  <tr>
    <td>
<div id="treeboxbox_tree" style="width:300;height:500"></div>
<jhop:tree divid="treeboxbox_tree"
			jhoptree="jhoptree" 
			treeid="zsy" 
			queryPath="/listtree.do?method=getTreeNodes2" 
			treedisname="listtree2" 
			checkboxflag="false"
			dragFlag="false"
			clickHandler = "choise_node"
			datasxml="${wfviewleft}"
		 
/>
</td>
    <td>&nbsp;</td>
  </tr>
  
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</body>
</html>

