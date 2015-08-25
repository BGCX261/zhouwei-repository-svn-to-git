<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddclassondutylog/grid.jsp";
	}
   
   
  

   
   
  	function onClick2(isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddClassondutylog.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="调度交接班记录浏览,调度交接班记录详情" scroll="auto,auto"> </jhop:labelgroup>
