<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<script type="text/javascript">

	function operation1(itemId,itemValue)
	{
		dealAlertMessage("operation1");
	}
	function operation2(itemId,itemValue){
		dealAlertMessage("operation2");
	}
	function operation3(itemId,itemValue){
		dealAlertMessage("operation3");
	}
	function operation4(itemId,itemValue){
		dealAlertMessage("operation4");
	}


    function deleteData(temId,itemValue){
        
	    var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要删除的故障简报");
		    return false;
		}
		var primaryId = "";
		var version   = ""; 
		var fexcutestatus    = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'faccidentid');
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
				if(statusVersion!="草稿"){
                  dealAlertMessage("您选择的第"+(rows[row])+"条故障简报不是草稿状态,请检查!!!");
                  return;
                }
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
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
		//dealAlertMessage("#######:"+primaryId+":#######:"+version+":#######:"+fexcutestatus);
		var sign = confirm(" 您确认将删除选中数据?");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "草稿"){
					dealAlertMessage("只有状态为草稿的可以删除!!!");
					return false;
				}
			}
			if(version != null && version != "" && primaryId != null && primaryId != ""){
				var pars        = "faccidentid="+primaryId;
					pars	   += "&version="+version;
				var url="<%=request.getContextPath()%>/ddAccidentbrief.do?method=delete";
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
	  
	
	function resume(temId,itemValue){//盖执行章
	 
	 	var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要盖执行章的故障简报");
		    return false;
		}
		var primaryId = "";
		var fexcutestatus = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'faccidentid');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}
				
				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if(statusVersion!="处理中"){
                  dealAlertMessage("您选择的第"+(rows[row])+"条故障简报不是处理中状态,请检查!!!");
                  return;
                }
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
				}
				
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!"); 	      
			return false; 	   
		} 
		var sign = confirm(" 您确认将盖选中数据的执行章?请注意，执行后所有信息将不允许修改");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "处理中"){
					dealAlertMessage("只有状态为处理中的可以盖执行章!!!");
					return false;
				}
			}
			if(primaryId != null && primaryId != ""){
				var pars        = "faccidentid="+primaryId;
				var url="<%=request.getContextPath()%>/ddAccidentbrief.do?method=resume";
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
	
	function saveSwitchseqbill(temId,itemValue){//拟定操作票

	
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要拟定操作票的故障简报");
		    return false;
		}
		if(rows.length>1){
		    dealAlertMessage("您只能选择一条故障简报");
		    return false;
		}
		var primaryId = "";
		var fexcutestatus = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'faccidentid');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}
				
				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if(statusVersion!="处理中"){
                  dealAlertMessage("您选择的第"+(rows[row])+"条故障简报不是处理中状态,请检查!!!");
                  return;
                }
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
				}
				
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!"); 	      
			return false; 	   
		} 
		var sign = confirm(" 您确认为选中的故障简报拟定操作票?");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "处理中"){
					dealAlertMessage("只有状态为处理中的可以拟定操作票!!!");
					return false;
				}
			}
			if(primaryId != null && primaryId != ""){
				var pars        = "faccidentid="+primaryId;
				var url="<%=request.getContextPath()%>/ddAccidentbrief.do?method=saveSwitchseqbill";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage(originalRequest.responseText);
						//var td1    = parent.downFrame.document.all.ID1;
						//selectTab(td1, '', 'true','false');
						//parent.downFrame.iframe1.createGrid('','0','','','','','','');
						var  doc = parent.document;  
	                    var  ff = doc.getElementById("upFrame");
	                    ff.src="<%=request.getContextPath()%>/ddSwitchseqbill.do?method=ddSwitchseqbilltoolbar";    
	                    var dow = doc.getElementById("downFrame");
	                    dow.src="<%=request.getContextPath()%>/ddSwitchseqbill.do?method=ddSwitchseqbilltab";
					}
				}
			}
		}	
	
	}
	
	function saveDayPlan(temId,itemValue){//转日计划
			    
		var gridId 		= parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		if(!rows){
		    dealAlertMessage("请选择需要转日计划的故障简报");
		    return false;
		}
		if(rows.length>1){
		    dealAlertMessage("您只能选择一条故障简报");
		    return false;
		}
		var primaryId = "";
		var fexcutestatus = "";
		if(rows != null && rows != "undefined" && rows != ""){
			for (row = 0;row<rows.length;row++){ 
				//获取指定行的主键列的列值


				var colValue = gridId.getValByRC(rows[row],'faccidentid');
				if (colValue == "" || colValue == null) { continue;}
				if (primaryId == ""){ 
					primaryId = colValue;
				} else {
					primaryId += '^'+colValue;
				}
				
				var statusVersion = gridId.getValByRC(rows[row],'fexcutestatus');
				if(statusVersion!="处理中"){
                  dealAlertMessage("您选择的第"+(rows[row])+"条故障简报不是处理中状态,请检查!!!");
                  return;
                }
				if (statusVersion == "" || statusVersion == null) { continue;}
				if (fexcutestatus == ""){ 
					fexcutestatus = statusVersion;
				} else {
					fexcutestatus += '^'+statusVersion;
				}
				
			}
		}
		if (primaryId == ""){  	      
			dealAlertMessage("没有找到主键值!"); 	      
			return false; 	   
		} 
		var sign = confirm(" 您确认为选中的故障简报转日计划?");
		if(sign){
			var statusArra = fexcutestatus.split("^");
			for(var i=0; i<statusArra.length; i++){
				if(statusArra[i] != "处理中"){
					dealAlertMessage("只有状态为处理中的可以转日计划!!!");
					return false;
				}
			}
			if(primaryId != null && primaryId != ""){
				var pars        = "faccidentid="+primaryId;
				var url="<%=request.getContextPath()%>/ddAccidentbrief.do?method=saveDayPlan";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						dealAlertMessage(originalRequest.responseText);
						//var td1    = parent.downFrame.document.all.ID1;
						//selectTab(td1, '', 'true','false');
						//parent.downFrame.iframe1.createGrid('','0','','','','','','');
						var  doc = parent.document;  
	                    var  ff = doc.getElementById("upFrame");
	                    ff.src="<%=request.getContextPath()%>/ddDoutageplan.do?method=ddDoutageplantoolbar";    
	                    var dow = doc.getElementById("downFrame");
	                    dow.src="<%=request.getContextPath()%>/ddDoutageplan.do?method=ddDoutageplantab";
					}
				}
			}
		}	
	
	}
	
	
	function workTransition(itemId,itemValue){

       var mygrid = parent.downFrame.iframe4.mygrid;
       
       var rows 		= mygrid.getSelectedRows();
	   if(!rows){
		    dealAlertMessage("请先选择相应的记录！");
		    return false;
	   }
	   if(rows.length>1){
	       dealAlertMessage("您只选择了一条记录");
		   return false;    
	   }		
		   var id = mygrid.getValueByName("id");  
		   
		   if(id==undefined)return false;
       
           var status = mygrid.getValueByName("status"); 

           var taskId = mygrid.getValueByName("taskId_");

           var taskInstanceId = mygrid.getValueByName("taskInstanceId_");

           var url = '/application/ddaccidentbrief/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;

           var param = new Object();

           vReturnValue = showModalDialogYY(url,"600","300",param,"系统图工作流","auto");
           
           //alert(vReturnValue);
           if(vReturnValue){
            
                  var url="<%=request.getContextPath()%>/ddAccidentbrief.do?method=workflowHandle";
	              var myAjax = new Ajax.Request(url,{method: 'post', parameters: vReturnValue.type,  onComplete: showResponse});
	              function showResponse(originalRequest){
	              
	                    if(vReturnValue.title=="dayplan"){
                           var  doc = parent.document;  
	                       var  ff = doc.getElementById("upFrame");
	                       ff.src="<%=request.getContextPath()%>/ddDoutageplan.do?method=ddDoutageplantoolbar";    
	                       var dow = doc.getElementById("downFrame");
	                       dow.src="<%=request.getContextPath()%>/ddDoutageplan.do?method=ddDoutageplantab";
                        }
                        if(vReturnValue.title=="simple"){
                           var td4    = parent.downFrame.document.all.ID4;
						   selectTab(td4, '', 'true','false');
						   parent.downFrame.iframe4.createGrid('','0','','','','','','');
                        }
	                    
	              }
            }
    }
    
    /**
     * 上一条操作

     */
	
	 function preRow(){

       operToolbarRow("iframe1","ddAccidentbrief","previous");

    }

     /**
     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","ddAccidentbrief","next");

    }
    
    function wf_history(itemId,itemValue){

           var mygrid = parent.downFrame.iframe4.mygrid;

           //判断列表对象是否存在

           if (mygrid == "undefined"){          

               return true;

           }  

           

           var id = mygrid.getValueByName("id");      

           if(id==''){

                     alert("请先选择相应的记录！");

                     return true;

           }else{

                    var taskInstanceId = mygrid.getValueByName("taskInstanceId_");

                    var url = 'application/todolist/handlehistory.jsp?taskInstanceId='+taskInstanceId+'&busId='+id;

                    window.open(url);

                    //showNotModalDialogYY(url,"600","500");

           }        
     }

    
	


</script>
