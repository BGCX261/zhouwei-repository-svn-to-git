<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_grid.jsp" %>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<script type="text/javascript">
	/**
	 * 缺陷送检
	 */
	function sendCheck(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var primaryId  	= "";
		var dataStatus 	= "";
		var rows 		= gridId.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){
				//获取指定行的主键列的列值
				var primaryId  = gridId.getValByRC(rows[row],'ffaultno');
				var dataStatus = gridId.getValByRC(rows[row],'fstatus');
				break;
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!");     
			return false; 	   
		} 
		if (dataStatus == ""){  	      
			dealAlertMessage("没有找到状态值!");	      
			return false; 	   
		} 
		/*
			var dataStr 	= gridId.getSelectedRowsData("3");
			var dataStatus 	= "";
			var primaryId  	= "";
			if(dataStr.indexOf("@@@") != -1){
				var dataArra 	= dataStr.split("@@@");
				for(var x=0; x<dataArra.length; x++){
					if(dataArra[x].indexOf("^") != -1){
						var name  = dataArra[x].split("^")[0];
						var value = dataArra[x].split("^")[1];
						if(name == "fstatus"){
							dataStatus = value;
						} else if(name == "ffaultno"){
							primaryId = value;
						}
					}
				}
			}
		*/
		if(dataStatus){
			if(dataStatus == "<%=ZdhConstants.ZDH_DRAFT %>"){
				var param = new Object();
				var objNum  		= primaryId;
				var objName 		= "自动化缺陷";
				var taskStatus  	= "送检修状态";	
				var sendClew		= "发送提示";
				var message  		= "编号为《"+objNum+"》的《"+objName+"》处于《"+taskStatus+"》，请查阅";
				var messObj = showSendCheck("<%=request.getContextPath()%>",objNum,objName,taskStatus,sendClew,message);
				var sendPerson	= messObj.sendPerson;
				var sendMessage = messObj.sendMessage;
				var sendMobile	= messObj.sendMobile;
				
				var url			= "<%=request.getContextPath()%>/zdhFaultlist.do?method=changeStatus";
				var pars        = "mainId="+primaryId;
					pars	   += "&status=check";
					pars	   += "&sendPerson="+sendPerson;
					pars	   += "&sendMessage="+sendMessage;
					pars	   += "&sendMobile="+sendMobile;
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						if("操作失败" != originalRequest.responseText){
							dealAlertMessage("数据送检成功");
							parent.downFrame.iframe1.createGrid('','0','','','','','','');
						} else {
							dealAlertMessage("数据送检失败");
						}
					}
				}
			} else {
				dealAlertMessage("只有草稿状态可以送检!");
			}
		}
	}
	
	/**
	 * 显示送检页面
	 */
	function showSendCheck(path,objNum,objName,taskStatus,sendClew,message)
	{
		var param = new Object();
		param.objNum  		= objNum;
		param.objName 		= objName;
		param.eventStatus  	= taskStatus;	
		param.sendClew		= sendClew;
		param.message  		= message;
		path = "/application/zdhfaultlist/sendCheck.jsp";
	
		vReturnValue = showModalDialogYY(path,"650","255",param,"缺陷送检","auto");
		return vReturnValue;
	}
	
	/**
	 *  缺陷归档
	 */
	function pigeonhole(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值
				var colValue = gridId.getValByRC(rows[row],'ffaultno');
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
	
		var sign = confirm(" 您确认将该缺陷信息归档,归档后相关内容不允许修改?");
		if(sign){
			if(fstatus){
				var url			= "<%=request.getContextPath()%>/zdhFaultlist.do?method=changeStatus";
				var pars        = "mainId="+primaryId;
					pars	   += "&status=pigeonholed";

				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						if("操作失败" != originalRequest.responseText){
							dealAlertMessage(originalRequest.responseText);
							parent.downFrame.iframe1.createGrid('','0','','','','','','');
						} else {
							dealAlertMessage("数据归档失败!");
						}
					}
				}
			}
		}
	}	
	
	function deleteData(itemId,itemValue){
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值
				var colValue = gridId.getValByRC(rows[row],'ffaultno');
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
			if(statusArra[i] != "<%=ZdhConstants.ZDH_DRAFT %>"){
				dealAlertMessage("只有状态为草稿的可以删除!!!");
				return false;
			}
		}
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "ffaultno="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/zdhFaultlist.do?method=delete";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage("数据删除成功!");	
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}
			}
		}
	}
	
	function workTransition(itemId,itemValue){
		//alert(workTransition);
	}
	
	/**
	 * 上一条操作
	 */
	function preRow(){
		operToolbarRow("iframe1","zdhFaultlist","previous");
	}
	/**
	 * 下一条操作
	 */
	function nextRow(){
		operToolbarRow("iframe1","zdhFaultlist","next");
	}
</script>
<form name="sendStatus" method="post">
	<input type="hidden" name="mainId" value="">
	<input type="hidden" name="status" value="">
</form>