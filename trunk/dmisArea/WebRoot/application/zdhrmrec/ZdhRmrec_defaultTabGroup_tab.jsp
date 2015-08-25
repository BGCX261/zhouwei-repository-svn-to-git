<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
   		disableButton("save,cancel,transition,lastRow,nextRow");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhrmrec/ZdhRmrec_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy,mainId){
  		disableButton("find,copy,delete,transition");
		if(mainId == null 
				|| mainId == "undefined" 
						|| mainId == "" 
								|| mainId == "null"){
  			mainId = dealMainId(isNew);
  		}
  		if(mainId == "undefined"){
  			mainId = "";
  		}
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhRmrec.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="遥测数据修改记录浏览,遥测数据修改记录详情" scroll="auto,auto"> </jhop:labelgroup>
