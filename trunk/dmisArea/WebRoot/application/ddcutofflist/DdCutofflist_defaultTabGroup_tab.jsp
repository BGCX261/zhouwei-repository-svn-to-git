<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddcutofflist/DdCutofflist_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddCutofflist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   	function onClick3(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddcutofflist/DdCutofflist_cutoffdistribute_grid.jsp";
	}
   
   
  

   	function onClick4(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddcutofflist/DdCutofflist_ddcutoffdetail_grid.jsp";
	}
   
   
  
//-->
</script>

<jhop:labelgroup height="530" labelHead="拉路限电记录浏览,拉路限电记录详情,拉路限电任务下发,拉路限电执行明细" scroll="auto,auto,auto,auto"> </jhop:labelgroup>
