<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
   		disableButton("new,copy,save,cancel,transition,lastRow,nextRow");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhrsrecord/zdhrsrec_defaultList_grid.jsp";
	}
   
  	function onClick2(src,isNew,isCopy,mainId){
  		disableButton("new,copy,cancel,transition");
		if(mainId == null 
				|| mainId == "undefined" 
						|| mainId == "" 
								|| mainId == "null"){
  			mainId = dealMainId(isNew);
  		}
  		if(mainId == "undefined"){
  			mainId = "";
  		}
		
		if(mainId == null || mainId == "undefined" || mainId == ""){
			dealAlertMessage("只有选中列表记录才可进入详情页");
			var td1    = parent.downFrame.document.all.ID1;
			selectTab(td1, '', 'true','false');
		}
		
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhRsrecord.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
	function dealAlertMessage(message){
		parent.downFrame.message_mask.style.visibility='visible';
		parent.downFrame.message_box.style.visibility='visible'
		parent.downFrame.document.getElementById("mainMessage").innerText = message;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="事故遥信记录,遥信记录详情" scroll="auto,auto"> </jhop:labelgroup>
