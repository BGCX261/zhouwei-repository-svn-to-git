<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--
	var  preclick="";

   	function onClick1(){
   		//disableButton("save,cancel,transition,lastRow,nextRow");
   		//屏蔽交接班操作
   		//disableMenuItem('rmdatamodify,queryapprovebook');
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhcharalterrecord/ZdhCharalterrecord_defaultList_grid.jsp";
		preclick = "onClick1";
	}
   
  	function onClick2(src,isNew,isCopy,mainId){
  		//enableMenuItem('rmdatamodify,queryapprovebook');
  		disableButton("copy,delete,transition");
  		if(mainId == null 
				|| mainId == "undefined" 
						|| mainId == "" 
								|| mainId == "null"){
  			mainId = dealMainId(isNew);
  		}
  		if(mainId == "undefined"){
  			mainId = "";
  		}
  		
  		/**
  		 * 读取代办事项列表主键值
  		 */
  		if(preclick=="onClick4"){
  			var mygrid 	= parent.downFrame.iframe4.mygrid;
            var did 	= mygrid.getValueByName("id");
            if(did != null && did != "undefined" && did != "null" && did != ""){
            	mainId = did;
            }	
  		}
		
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhCharalterrecord.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
		preclick = "onClick2";
	}
	
	function onClick3(src,isNew,isCopy){
		disableButton("new,copy,delete,transition,lastRow,nextRow");
		var mainId = dealMainId(isNew);
		if(!mainId){
			alert("请选中浏览页列表数据!");
			var td1    = parent.downFrame.document.all.ID1;
			selectTab(td1, '', 'true','false');
			return false;
		}
		document.all.iframe3.src = "<%=request.getContextPath()%>/zdhRmrec.do?method=initDetail&mainId=&isCopy="+isCopy+"&charRecord="+mainId;
		preclick = "onClick3";
	}
	
	function onClick4(src,isNew,isCopy){
		disableButton("copy,lastRow,nextRow");
		//document.all.iframe4.src = "<%=request.getContextPath()%>/application/zdhcharalterrecord/ZdhCharalterrecord_defaultList_grid.jsp";
		document.all.iframe4.src = "<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ZdhCharalterrecord";
		preclick = "onClick4";
	}
	
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="系统图修改记录浏览,系统图修改记录详情,遥测数据修改记录,我的代办事项" scroll="auto,auto,auto,auto"> </jhop:labelgroup>
