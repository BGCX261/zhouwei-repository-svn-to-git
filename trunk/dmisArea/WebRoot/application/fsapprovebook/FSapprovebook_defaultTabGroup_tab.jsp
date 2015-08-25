<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   	function onClick3(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/fsapprovebook/FSapprovebook_excutlist_grid.jsp";
	}
   
   
  

   
   
  	function onClick4(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick5(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick6(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick7(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

   
   
  	function onClick8(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		document.all.iframe2.src = "<%=request.getContextPath()%>/fsApprovebook.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="发电批准书浏览,发电批准书详情,批准书执行过程,停电图查看,资料信息查看,关联定值单列表,关联自投规程,发电批准书预览" scroll="auto,auto,auto,auto,auto,auto,auto,auto"> </jhop:labelgroup>
