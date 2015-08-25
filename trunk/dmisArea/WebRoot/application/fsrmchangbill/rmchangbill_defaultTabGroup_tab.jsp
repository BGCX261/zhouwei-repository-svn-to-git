<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/fsrmchangbill/rmchangbill_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsRmchangbill.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   	function onClick3(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/fsrmchangbill/rmchangbill_rmchangdetail_grid.jsp";
	}
   
   
  

   
   
  	function onClick4(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsRmchangbill.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick5(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsRmchangbill.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="方式变更单浏览,方式变更单详情,本页为详情页的子表,方式变更执行,恢复情况" scroll="auto,auto,auto,auto,auto"> </jhop:labelgroup>
