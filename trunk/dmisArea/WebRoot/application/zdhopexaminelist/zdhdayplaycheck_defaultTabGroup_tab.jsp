<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhopexaminelist/zdhdayplaycheck_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhOpexaminelist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   	function onClick3(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhopexaminelist/zdhdayplaycheck_zdhdayplan_grid.jsp";
	}
   
   
  
//-->
</script>

<jhop:labelgroup height="530" labelHead="日计划核查表浏览,日计划核查表详情,本日计划列表" scroll="auto,auto,auto"> </jhop:labelgroup>
