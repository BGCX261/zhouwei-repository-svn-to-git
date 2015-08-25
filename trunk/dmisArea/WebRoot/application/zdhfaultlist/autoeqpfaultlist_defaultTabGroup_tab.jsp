<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--

   	function onClick1(){
   		disableButton("save,cancel,lastRow,nextRow");
   		//disableMenuItem("");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhfaultlist/autoeqpfaultlist_defaultList_grid.jsp";
	}
   
  	function onClick2(src,isNew,isCopy,mainId){
  		
  		disableButton("copy,delete,transition");
  		//disableMenuItem("sendCheck,pigeonhole");
		if(mainId == null 
				|| mainId == "undefined" 
						|| mainId == "" 
								|| mainId == "null"){
  			mainId = dealMainId(isNew);
  		}
  		if(mainId == "undefined"){
  			mainId = "";
  		}
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhFaultlist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick3(src,isNew,isCopy){
  		disableButton("new,copy,delete,save,cancel,transition,lastRow,nextRow");
  		//disableMenuItem("sendCheck,pigeonhole");
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhFaultlist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="自动化设备缺陷浏览,自动化设备缺陷详情,缺陷设备信息" scroll="auto,auto,auto"> </jhop:labelgroup>
