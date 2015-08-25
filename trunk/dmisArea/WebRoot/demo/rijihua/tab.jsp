<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<script language="javascript">
<!--
	function onClick1(src){
		if (typeof(src) == "undefined"){
			document.all.iframe1.src = "<%=request.getContextPath()%>/rijihua.do?method=initGrid";
		}else{
			document.all.iframe1.src = "<%=request.getContextPath()%>" + src;
		}	
	}
	function onClick2(src,isNew,isCopy,mainId){ 
		if(typeof(mainId) == "undefined" || mainId == ""){
			mainId = dealMainId(isNew);
		}
		if (typeof(src) == "undefined" || src == ""){
			document.all.iframe2.src = "<%=request.getContextPath()%>/rijihua.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
		}else{
			document.all.iframe2.src = "<%=request.getContextPath()%>" + src + "&mainId=" + mainId + "&isCopy="+isCopy;
		}	
	}
	function onClick3(src){
        var mainId = dealMainId();
		//if(mainId == ""){
		//	alert("请首先选中浏览页列表记录!");
		//	return;
		//}
		if (typeof(src) == "undefined"){
			document.all.iframe3.src = "<%=request.getContextPath()%>/rijihua.do?method=initCardGrid&mainId=" + mainId;
		}else{
			document.all.iframe3.src = "<%=request.getContextPath()%>" + src + "&mainId=" + mainId;
		}	
	}
	function onClick4(src){
	    var mainId = dealMainId();
		if (typeof(src) == "undefined"){
			document.all.iframe4.src = "<%=request.getContextPath()%>/rijihua.do?method=initGridCard&mainId=" + mainId;
		}else{
			document.all.iframe4.src = "<%=request.getContextPath()%>" + src + "&mainId=" + mainId;
		}
	}	
	function onClick5(src){
        var mainId = dealMainId();
		//if(mainId == ""){
		//	alert("请首先选中浏览页列表记录!");
		//	return;
		//}
		if (typeof(src) == "undefined"){
			document.all.iframe5.src = "<%=request.getContextPath()%>/rijihua.do?method=initTwoGrid&mainId=" + mainId;
		}else{
			document.all.iframe5.src = "<%=request.getContextPath()%>" + src + "&mainId=" + mainId;
		}		
	}
	function onClick6(src){
		if (typeof(src) == "undefined"){
			document.all.iframe6.src = "<%=request.getContextPath()%>/rijihua.do?method=initToolbarBack";
		}else{
			document.all.iframe6.src = "<%=request.getContextPath()%>" + src;
		}		
	}	
	function onClick7(src){
		if (typeof(src) == "undefined"){
			document.all.iframe7.src = "<%=request.getContextPath()%>/rijihua.do?method=initXmlToGrid";
		}else{
			document.all.iframe7.src = "<%=request.getContextPath()%>" + src;
		}		
	}	

//-->
</script>
<jhop:labelgroup height="530" labelHead="日计划浏览,日计划详情,主卡片子表,主表子卡片,双表联动,回控工具栏,XML生成列表" scroll="no,auto,auto,yes,auto,auto,auto"></jhop:labelgroup>
