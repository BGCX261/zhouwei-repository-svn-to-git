<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
   		var url = "<%=request.getContextPath()%>/application/ddhpoweroperaterrd/DdHpoweroperaterrd_defaultList_grid.jsp";
   		
		document.all.iframe1.src = url;
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);

		document.all.iframe2.src = "<%=request.getContextPath()%>/ddHpoweroperaterrd.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="电厂运行(下令操作)记录浏览,电厂运行(下令操作)记录详情" scroll="auto,auto"> </jhop:labelgroup>
