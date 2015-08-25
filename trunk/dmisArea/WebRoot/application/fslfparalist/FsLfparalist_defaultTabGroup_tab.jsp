<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/fslfparalist/FsLfparalist_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsLfparalist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick3(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsLfparalist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="低频减载装置参数的属性清单浏览,低频减载装置参数的属性清单详情,负荷数据" scroll="auto,auto,auto"> </jhop:labelgroup>
