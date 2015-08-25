<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<%@ include file="/common/init_grid.jsp" %>
<script type="text/javascript">
	function deleteData(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值
				var colValue = gridId.getValByRC(rows[row],'recordsno');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}
				var colVersion = gridId.getValByRC(rows[row],'version');
				if (colVersion == "" || colVersion == null) { continue;}
				if (version == ""){ 
					version = colVersion;
				} else {
					version += '^'+colVersion;
				}
				var statusVersion = gridId.getValByRC(rows[row],'fstatus');
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fstatus == ""){ 
					fstatus = statusVersion;
				} else {
					fstatus += '^'+statusVersion;
				}
			}
		}
		if (primaryId == ""){	  
			dealAlertMessage("没有找到主键值!");    
			return false; 	   
		} 
		if (version == ""){  	      	  
			dealAlertMessage("没有找到版本值!");    
			return false; 	   
		}
		var statusArra = fstatus.split("^");
		for(var i=0; i<statusArra.length; i++){
			if(statusArra[i] != "1"){
				dealAlertMessage("只有状态为草稿的可以删除!!!"); 
				return false;
			}
		}
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "recordsno="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/zdhCharalterrecord.do?method=delete";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}
	}
	
	function syschartsysn(itemId,itemValue){
		var mygrid = parent.downFrame.iframe4.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return true;
		} 
		var rows 		= mygrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){
				var id = mygrid.getValByRC(rows[row],'id');	
				if(id == null || id == "undefined" || id == "null" || id == ""){
					 dealAlertMessage("请先选择相应的记录！");
					 return true;
				}else{
					var status = mygrid.getValByRC(rows[row],'status');
					if(status == "6"){
						var status = mygrid.getValByRC(rows[row],'status');	
						var taskId = mygrid.getValByRC(rows[row],'taskId_');
						var taskInstanceId = mygrid.getValByRC(rows[row],'taskInstanceId_');
						var url = '/application/zdhcharalterrecord/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;
						var param = new Object();
						vReturnValue = showModalDialogYY(url,"600","300",param,"系统图工作流","auto");
						if(vReturnValue != null){
					     	var wf_busId    		= vReturnValue.wf_busId;
							var wf_status   		= vReturnValue.wf_status;
							var wf_taskId   		= vReturnValue.wf_taskId;
							var wf_taskInstanceId 	= vReturnValue.wf_taskInstanceId;
							var transitionFlag      = vReturnValue.transitionFlag;
							var notice				= vReturnValue.notice;
							var nextTaskRoles		= vReturnValue.nextTaskRoles;
							var message				= vReturnValue.message;
							var sentPersons			= vReturnValue.sentPersons;
							var isSms				= vReturnValue.isSms;
							var pars        = "wf_busId="+wf_busId;
								pars	   += "&wf_status="+wf_status;
								pars	   += "&wf_taskId="+wf_taskId;
								pars	   += "&wf_taskInstanceId="+wf_taskInstanceId;
								pars	   += "&transitionFlag="+transitionFlag;
								pars	   += "&notice="+notice;
								pars	   += "&nextTaskRoles="+nextTaskRoles;
								pars	   += "&message="+message;
								pars	   += "&sentPersons="+sentPersons;
								pars	   += "&isSms="+isSms;
								var url		= "<%=request.getContextPath()%>/zdhCharalterrecord.do?method=workflowHandle";
								var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
								function callBackGrid(originalRequest){
									if(originalRequest){
										var td4   = parent.downFrame.document.all.ID4;
										selectTab(td4, '', 'false','false');
									}
								}
						}
					} else {
						dealAlertMessage("只有高级岗审核完成才能系统图同步！");
					}
					
				}
			}
		}
	}
	
	//遥测数据修改
	function rmdatamodify(itemId,itemValue){
		var td3   = parent.downFrame.document.all.ID3;
		selectTab(td3, '', 'false','false');
	}
	
	function queryapprovebook(itemId,itemValue){
		alert("queryapprovebook");
	}
	
	function workTransition(itemId,itemValue){
		var mygrid = parent.downFrame.iframe4.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return false;
		}  
		var rows 		= mygrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){
				var id = mygrid.getValueByName("id");
				if(id == null || id == "undefined" || id == "null" || id == ""){
					 dealAlertMessage("请先选择相应的记录！");
					 return false;
				}else{
					var status = mygrid.getValByRC(rows[row],'status');	
					if(status == "6"){
						dealAlertMessage("系统图同步在选择操作下拉框中,此处无法操作！");
						return false;
					}
					var status = mygrid.getValByRC(rows[row],'status');	
						var taskId = mygrid.getValByRC(rows[row],'taskId_');
						var taskInstanceId = mygrid.getValByRC(rows[row],'taskInstanceId_');
						var url = '/application/zdhcharalterrecord/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;
						var param = new Object();
						vReturnValue = showModalDialogYY(url,"600","300",param,"系统图工作流","auto");
						if(vReturnValue != null){
					     	var wf_busId    		= vReturnValue.wf_busId;
							var wf_status   		= vReturnValue.wf_status;
							var wf_taskId   		= vReturnValue.wf_taskId;
							var wf_taskInstanceId 	= vReturnValue.wf_taskInstanceId;
							var transitionFlag      = vReturnValue.transitionFlag;
							var notice				= vReturnValue.notice;
							var nextTaskRoles		= vReturnValue.nextTaskRoles;
							var message				= vReturnValue.message;
							var sentPersons			= vReturnValue.sentPersons;
							var isSms				= vReturnValue.isSms;
							var pars        = "wf_busId="+wf_busId;
								pars	   += "&wf_status="+wf_status;
								pars	   += "&wf_taskId="+wf_taskId;
								pars	   += "&wf_taskInstanceId="+wf_taskInstanceId;
								pars	   += "&transitionFlag="+transitionFlag;
								pars	   += "&notice="+notice;
								pars	   += "&nextTaskRoles="+nextTaskRoles;
								pars	   += "&message="+message;
								pars	   += "&sentPersons="+sentPersons;
								pars	   += "&isSms="+isSms;
								var url		= "<%=request.getContextPath()%>/zdhCharalterrecord.do?method=workflowHandle";
								var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
								function callBackGrid(originalRequest){
									if(originalRequest){
										var td4   = parent.downFrame.document.all.ID4;
										selectTab(td4, '', 'false','false');
									}
								}
						}
				}
			}
		}
	}
	
	/**
	 *  工作流历史
	 */
	function wf_history(itemId,itemValue){
		var mygrid = parent.downFrame.iframe4.mygrid;
		//判断列表对象是否存在
		if (mygrid == "undefined"){          
		    return true;
		}  
		var id 				= "";
		var status 			= "";
		var taskInstanceId 	= "";
		var rows = mygrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){
				id 				= mygrid.getValByRC(rows[row],'id');
				status  		= mygrid.getValByRC(rows[row],'status');
				taskInstanceId 	= mygrid.getValByRC(rows[row],'taskInstanceId_');
				break;
			}
		}
		if(status != "1"){
			if(id==''){
				 //dealAlertMessage("请先选择相应的记录！");
				 return false;
			}else{
				var url = 'application/todolist/handlehistory.jsp?taskInstanceId='+taskInstanceId+'&busId='+id;
				window.open(url);
				//showNotModalDialogYY(url,"600","500");
			}	
		} else {
			 dealAlertMessage("草稿状态没有可查看历史！");
		}
	}
	
	/**
	 * 上一条操作
	 */
	function preRow(){
		operToolbarRow("iframe1","zdhCharalterrecord","previous");
	}
	/**
	 * 下一条操作
	 */
	function nextRow(){
		operToolbarRow("iframe1","zdhCharalterrecord","next");
	}

</script>