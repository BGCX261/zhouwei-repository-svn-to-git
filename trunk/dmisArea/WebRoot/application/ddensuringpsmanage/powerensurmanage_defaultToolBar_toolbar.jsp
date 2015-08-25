<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_grid.jsp" %>
<script type="text/javascript">
	function operation1(itemId,itemValue)
	{
		alert("operation1");
	}
	function operation2(itemId,itemValue){
		alert("operation2");
	}	
	function operation3(itemId,itemValue){
		alert("operation3");
	}	
	function operation4(itemId,itemValue){
		alert("operation4");
	}	
	
	
	function deleteData(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var primaryStr 	= gridId.getSelectedRowsData(3);
		var primaryId   = "";
		var version 	= "";
		var fstatus = "";
		if(primaryStr.indexOf("@@@") != -1){
			var dataArra 	= primaryStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fid"){
						primaryId = value;
					} 
					if(name == "version"){
						version   = value;
					}
					if(name=="fstatus"){
						fstatus = value;
					}
				}
			}
			if(fstatus!="草稿"){
				alert("当前记录状态非草稿状态，系统不允许删除！");
			}else if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "fid="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/ddEnsuringpsmanage.do?method=delete";
				
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}
	}	
	
	function wf_start(itemId,itemValue){
		var mygrid = parent.downFrame.iframe1.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return true;
		}  
		var id = mygrid.getValueByName("fid");	
		
		if(id==''){
			 alert("请先选择相应的记录！");
			 return true;
		}else{
		
			var status = mygrid.getValueByName("fstatus");	
			var taskId = '';
			var taskInstanceId = '';
			var url = '/application/ddensuringpsmanage/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;
			showNotModalDialogYY(url,"600","300");	
		}
	}

	function wf_goto(itemId,itemValue){
		var mygrid = parent.downFrame.iframe3.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return true;
		}  
		
		var id = mygrid.getValueByName("id");	
		if(id==''){
			 alert("请先选择相应的记录！");
			 return true;
		}else{
			
			var status = mygrid.getValueByName("status");	
			var taskId = mygrid.getValueByName("taskId_");
			var taskInstanceId = mygrid.getValueByName("taskInstanceId_");
			var url = '/application/ddensuringpsmanage/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;
			showNotModalDialogYY(url,"600","300");
		}
		//toTab(1,"/daySchedule.do?method=startDaySchedule");
	}	
	
	function wf_history(itemId,itemValue){
		var mygrid = parent.downFrame.iframe3.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return true;
		}  
		
		var id = mygrid.getValueByName("id");	
		var bstatus = mygrid.getValueByName("bstatus");	
		if(id==''){
		
			 alert("请先选择相应的记录！");
			 return true;
		}else if(bstatus=='草稿' || bstatus=='修改' || bstatus=='驳回'){
			 alert("无流转历史！");
			 return true;			
		}else{
			var taskInstanceId = mygrid.getValueByName("taskInstanceId_");
			var url = 'application/todolist/handlehistory.jsp?taskInstanceId='+taskInstanceId+'&busId='+id;
			window.open(url);
			//showNotModalDialogYY(url,"600","500");
		}	
	}
	
		/**

     * 上一条操作

     */

    function preRow(){

       operToolbarRow("iframe1","ddDoutageplan","previous");

}

/**

     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","ddDoutageplan","next");

}	
	
	
	
</script>