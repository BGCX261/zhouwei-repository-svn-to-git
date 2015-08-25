<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript">
	/*
	*核定情况
	*/
	function DDPASSedCheck(itemId,itemValue)
	{
		var myGrid = parent.downFrame.iframe1.mygrid;
		var rows      = myGrid.getSelectedRows();
		var primaryId="";
		if(rows != null && rows != "undefined" && rows != ""){
			if (rows.length ==0){
				alert("请选择记录");
				return false;
			}
			else{

	           for (row = 0;row<rows.length;row++){ 
	              //获取指定行的主键列的列值


	              var colValue = myGrid.getValByRC(rows[row],'fcomputerno');
	              if (colValue == "" || colValue == null) { continue;}
	              if (primaryId == ""){ 
	                  primaryId = colValue;
	              } else {
	                  primaryId += '^'+colValue;
	              }
	              
	           }
		
			}
		}
		
		var sign = confirm(" 您确认将操作票核定合格情况?");
		if (sign){
	 		var param = new Object();
	 		param.id = primaryId;
	 		var isCopy="";
			var url = "/application/ddswitchseqbill/DdSwitchseqbill_switchseqbillcheck_detail.jsp?FComputerNo="+primaryId;
			var a = showModalDialogYY(url,"800","400",param,"合格情况核定","auto");
			
			var td1    = parent.downFrame.document.all.ID1;
            selectTab(td1, '', 'true','false');
            parent.downFrame.iframe1.createGrid('','0','','','','','','');
		}
	
	
	}
	
	//盖执行章
	function DDexcuteseal(itemId,itemValue){
		var myGrid = parent.downFrame.iframe1.mygrid;
		var keyStr 	= myGrid.getSelectedRowsData(3);
		
		var fid ="";
		var version = "";
		var primaryId="";
		var rows      = myGrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			if (rows.length ==0){
				alert("请选择记录");
				return false;
			}
			else{

	           for (row = 0;row<rows.length;row++){ 
	              //获取指定行的主键列的列值


	              var colValue = myGrid.getValByRC(rows[row],'fcomputerno');
	              if (colValue == "" || colValue == null) { continue;}
	              if (primaryId == ""){ 
	                  primaryId = colValue;
	              } else {
	                  primaryId += '^'+colValue;
	              }
	              
	           }
		
			}
		}
		var sign = confirm(" 您确认盖执行章?");
		if (sign){
			if (primaryId !=""){
				var pars        = "fcomputerno="+primaryId;
				var url			= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=DDexcuteseal";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest)
				{
					if(originalRequest)
					{
					   
					 	var td1    = parent.downFrame.document.all.ID1;
              			selectTab(td1, '', 'true','false');
						alert(originalRequest.responseText);
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
					}
				}	
			}
		}
		
			
	}
	//盖作废章
	function DDCancelbill(itemId,itemValue){
		var myGrid = parent.downFrame.iframe1.mygrid;
		var keyStr 	= myGrid.getSelectedRowsData(3);
		
		var fid ="";
		var version = "";
		var rows      = myGrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != ""){
			if (rows.length ==0){
				alert("请选择记录");
			}
			else{

	           for (row = 0;row<rows.length;row++){ 
	              //获取指定行的主键列的列值

	              var colValue = myGrid.getValByRC(rows[row],'fcomputerno');
	              if (colValue == "" || colValue == null) { continue;}
	              if (primaryId == ""){ 
	                  primaryId = colValue;
	              } else {
	                  primaryId += '^'+colValue;
	              }
	              
	           }
		
			}
		}
		if (primaryId !=""){
			var pars        = "fcomputerno="+fid;
			var url			= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=DDCancelbill";
			var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
			function callBackGrid(originalRequest)
			{
				if(originalRequest)
				{
					alert(originalRequest.responseText);
					parent.downFrame.iframe1.createGrid('','0','','','','','','');
				}
			}	
		}
		
			
	}
	
	//终止操作票


	function DDstopswitchseqbill(itemId,itemValue){
		var myGrid = parent.downFrame.iframe1.mygrid;
		var rows      = myGrid.getSelectedRows();
		var primaryId="";
		if(rows != null && rows != "undefined" && rows != ""){
			if (rows.length ==0){
				alert("请选择记录");
			}
			else{

	           for (row = 0;row<rows.length;row++){ 
	              //获取指定行的主键列的列值


	              var colValue = myGrid.getValByRC(rows[row],'fcomputerno');
	              if (colValue == "" || colValue == null) { continue;}
	              if (primaryId == ""){ 
	                  primaryId = colValue;
	              } else {
	                  primaryId += '^'+colValue;
	              }
	              
	           }
		
			}
		}
		var sign = confirm(" 您确认将终止操作票?");
		if (sign){
	 		var param = new Object();
	 		param.id = primaryId;
	 		var isCopy="";
			var url = "/application/ddswitchseqbill/DdSwitchseqbill_switchseqbillstop_detail.jsp?FComputerNo="+primaryId;
			showModalDialogYY(url,"800","400",param,"操作票终止","auto");
			
			var td1    = parent.downFrame.document.all.ID1;
            selectTab(td1, '', 'true','false');
            parent.downFrame.iframe1.createGrid('','0','','','','','','');
		}

	}	
	//转为典型票


	function TransTypicalbill(itemId,itemValue){
		var myGrid = parent.downFrame.iframe1.mygrid;
		var rows      = myGrid.getSelectedRows();
		var primaryId="";
		if(rows != null && rows != "undefined" && rows != ""){
			if (rows.length ==0){
				alert("请选择记录");
			}
			else{

	           for (row = 0;row<rows.length;row++){ 
	              //获取指定行的主键列的列值


	              var colValue = myGrid.getValByRC(rows[row],'fcomputerno');
	              if (colValue == "" || colValue == null) { continue;}
	              if (primaryId == ""){ 
	                  primaryId = colValue;
	              } else {
	                  primaryId += '^'+colValue;
	              }
	              
	           }
		
			}
		}
		var sign = confirm(" 您确认将选中操作票转为典型票?");
		if (sign){
			if (primaryId != "")
				{
					var pars        = "fcomputerno="+primaryId;
					alert(pars);
					var url			= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=TransTypicalbill";
					var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
					function callBackGrid(originalRequest)
					{
						if(originalRequest)
						{
							var td1    = parent.downFrame.document.all.ID1;
	              			selectTab(td1, '', 'true','false');
							alert(originalRequest.responseText);
							parent.downFrame.iframe1.createGrid('','0','','','','','','');
						}
					}	
				}	
			}
		
	}	
	//从典型票生成操作票

	function CreateSwitchbill(itemId,itemValue){
	
	
		var param = new Object();
		var flag="是";
		var oppositeCols="fcomputerno";
		var url = '/application/ddswitchseqbill/DdSwitchseqbill_grid.jsp?flag='+flag;
		var vReturnValue = showModalDialogYY(encodeURI(url),"800","460",param,"典型票","auto");
		var cols = oppositeCols.split("^");
		/**
		 * vReturnValue 格式说明
		 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
		 * 
	
		 */		
		 var pars="";
		if(vReturnValue != null){
			var data = vReturnValue.data;
			for(s=0;s<data.length;s++){
				//alert(data[s]);	
			  if (data[s].split("^")[0] == oppositeCols) {			    
			     //var tCol = document.getElementById(colPer[1]); 			     
			     //tCol.value = data[s].split("^")[1];
			     	var value = data[s].split("^")[1];
			     	//alert(value);
			     	var url			= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=CreateSwitchbill&mainId=" + value;
					var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
					function callBackGrid(originalRequest){
						if (originalRequest){
						
							var savesucces = originalRequest.responseText;
							
							if (savesucces=="1")
				            	alert("生成操作票成功");
				            else
				            	alert("生成操作票失败");
							//转到详情页

							parent.downFrame.fff(value);
							
						}
					
					}
			  }
				
			}
		}
	}
	
	//删除数据	
	function deleteData(itemId,itemValue)
	{
	
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fstatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值



				var colValue = gridId.getValByRC(rows[row],'fcomputerno');
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
				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fstatus == ""){ 
					fstatus = statusVersion;
				} else {
					fstatus += '^'+statusVersion;
				}
			}
		}
		if (primaryId == ""){  	      
			alert("没有找到主键值!"); 	      
			return false; 	   
		} 
		if (version == ""){  	      
			alert("没有找到版本值!"); 	      
			return false; 	   
		} 
		
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			var statusArra = fstatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "草稿"){
					alert("只有状态为草稿的可以删除!!!");
					return false;
				}
			}
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "fcomputerno="+primaryId;
					pars	   += "&version="+version;
				var url			= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=delete";
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
	
	/*
	 function workTransition(itemId,itemValue){

       var mygrid = parent.downFrame.iframe4.mygrid;

       //判断列表对象是否存在

       if (mygrid == "undefined"||!mygrid){          
           return false;
       }  
       var id = mygrid.getValueByName("id");  

       if(id==''||!id){

            //alert("请先选择相应的记录！");

            return false;

       }else{

           var status = mygrid.getValueByName("status"); 

           var taskId = mygrid.getValueByName("taskId_");

           var taskInstanceId = mygrid.getValueByName("taskInstanceId_");
           var dd = new Date();
           var url = '/application/ddswitchseqbill/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId+'&dd='+dd;
           //showNotModalDialogYY(url,"600","300");
           var param = new Object();
           vReturnValue = showModalDialogYY(url,600,300,param,"操作票流程图",1);
           parent.downFrame.onClick4();
	       //parent.downFrame.iframe4.createGrid('','0','','','','','','');
       }

    }*/
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
						var dd = new Date();
						var url = '/application/ddswitchseqbill/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId+'&dd='+dd;
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
								var url		= "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=workflowHandle";
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
    
    function wf_history(itemId,itemValue){

           var mygrid = parent.downFrame.iframe4.mygrid;

           //判断列表对象是否存在
 			if (mygrid == "undefined"||!mygrid){          
           		return false;
       		}  
      		 var id = mygrid.getValueByName("id");  

       		if(id==''||!id){

           		 alert("请先选择相应的记录！");

           		 return false;

           }else{
                    var rows = mygrid.getSelectedRows();
					if(rows != null && rows != "undefined" && rows != ""){
						for (row = 0;row<rows.length;row++){
							status  		= mygrid.getValByRC(rows[row],'status');
							break;
						}
						if (status=='1'){
							return false;
						}
				   }
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
       operToolbarRow("iframe1","ddSwitchseqbill","previous");

}

/**

     * 下一条操作


     */

    function nextRow(){
       operToolbarRow("iframe1","ddSwitchseqbill","next");

}
    
					
</script>
