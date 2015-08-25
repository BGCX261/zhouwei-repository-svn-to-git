<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
	
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/eqpEquipmentApi.js"></script>
	
	
<script type="text/javascript">
    //从月计划生成
	function createdddfromddm(itemId,itemValue)
	{
	    var url="/application/dddoutageplan/DDMonthplan_List_grid.jsp";
	    var qq = new Object();
		var vReturnValue=showModalDialogYY(url,600,600,qq,"月计划",1);
		if(vReturnValue){
		  var para ="ids="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=createDdoutplansFromMonth";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
		     function showResponse(originalRequest){
	            var savesucces = originalRequest.responseText;
	            if(Number(savesucces)==1)
	            	dealAlertMessage("生成日计划成功");
	            else
	            	dealAlertMessage("生成日计划失败");
                parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }

        }
		
	}
	
	//删除日计划	
	function deleteData(temId,itemValue){
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
        if(!rows){
 	  	dealAlertMessage("请选择条记录");
 	  	return false;
 	  }

	   var ver ="";
	   var ids = "";

	   var  j=0;
        for (row = 0;row<rows.length;row++){
        	var _status = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
       		if(_status!="草稿"){
       			dealAlertMessage("只有日计划的状态为草稿的时候才可以删除");
       			return  false;
       		}
            if(j!=rows.length-1){
	       		ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version')+"\^";
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno')+"\^";
       		}else{
       	    	ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno');
       	    }
       	    j++;
       }
       
       if(!ids){
       	  dealAlertMessage("没有找到主键值!");
	      return false;
       }
        var para ="ids="+ids+"&version="+ver;
		var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=delete";
		ajaxSendRequest(para,url,'删除成功','删除失败'); 
	}
	 
	 
	 
	 
	  //生成操做票


 	function ddseqbill(itemId,itemValue){
 	  var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
 	  if(!rows){
 	  	dealAlertMessage("请选择一条记录");
 	  	return false;
 	  }
 	  if(rows.length>1){
 	  	dealAlertMessage("只能选择一条记录");
 	  	return false;
 	  }
 	  
	   var ver ="";
	   var ids = "";

	   var  j=0;
        for (row = 0;row<rows.length;row++){
        	var _status = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
       		if(_status!="已下发"){
       			dealAlertMessage("只有日计划的状态为已下发的时候才可以为生成操作票");
       			return  false;
       		}
            if(j!=rows.length-1){
	       		ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version')+"\^";
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno')+"\^";
	       		//alert(ids);
       		}else{
       	    	ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno');
       	    }
       	    j++;
       }
       
       if(!ids){
       	  dealAlertMessage("没有找到主键值!");
	      return false;
       		
       }
        var para ="ids="+ids+"&version="+ver;
		var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=createSeqBill";
		 var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			 function showResponse(originalRequest){
		           if (originalRequest){   
		              // alert(originalRequest.responseText);          
		              if ("1"==originalRequest.responseText){
			                var  doc = parent.document;  
	                    	var  ff = doc.getElementById("upFrame");
	                    	ff.src="<%=request.getContextPath()%>/ddSwitchseqbill.do?method=ddSwitchseqbilltoolbar";    
	                    	var dow = doc.getElementById("downFrame");
	                    	dow.src="<%=request.getContextPath()%>/ddSwitchseqbill.do?method=ddSwitchseqbilltab";
		              } else {
		                  
		              }
		           }
	           }
	
	}
	 
	 
	function showcopprate(itemId,itemValue){
				var url="/application/dddoutageplan/DDdayoutageplan_choosecopperate_main.jsp";
			    var qq = new Object();
				showModalDialogYY(url,600,600,qq,"日计划配合",1);
	}
	 
	 
	 /*
	  *执行日计划


	  */
	function finishData(){
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
        if(!rows){
 	  	dealAlertMessage("请选择一条记录");
 	  	return false;
 	  }
 	  if(rows.length>1){
 	  	dealAlertMessage("只能选择一条记录");
 	  	return false;
 	  }
	   var ver ="";
	   var ids = "";

	   var  j=0;
        for (row = 0;row<rows.length;row++){
        	var _status = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
       		if(_status!="已下令"){
       			dealAlertMessage("只有日计划的状态为已下令的时候才可以为已执行");
       			return  false;
       		}
            if(j!=rows.length-1){
	       		ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version')+"\^";
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno')+"\^";
       		}else{
       	    	ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno');
       	    }
       	    j++;
       }
       
       if(!ids){
       	  dealAlertMessage("没有找到主键值!");
	      return false;
       		
       }
       
        var para ="ids="+ids+"&version="+ver;
		var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=finishdDdoutplans";
		ajaxSendRequest(para,url); 
	
	}
	
	
	/**
	 *取消日计划


	 */
	
	function cancleData(){
		
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	   var ver ="";
	   var ids = "";
	   var  j=0;
        for (row = 0;row<rows.length;row++){
        	var _status = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
       		if(_status!="已下发"&&_status!="已下令"){
       			dealAlertMessage("只有日计划的状态为已下发或已下令的时候才可以取消");
       			return  false;
       		}
            if(j!=rows.length-1){
	       		ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version')+"\^";
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno')+"\^";
       		}else{
       	    	ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno');
       	    }
       	    j++;
       }
       
       if(!ids){
       	  dealAlertMessage("没有找到主键值!");
	      return false;
       		
       }
      		var para ="ids="+ids+"&version="+ver;
			var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=cancleDdoutplans";
			ajaxSendRequest(para,url); 
		
	}
	
	
	/**
	 *归档日计划


	 */
	
	function pigeonholeData(){
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	   var ver ="";
	   var ids = "";

	   var  j=0;
        for (row = 0;row<rows.length;row++){
        	var _status = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
       		if(_status!="已取消"&&_status!="已执行"){
       			dealAlertMessage("只有日计划的状态为已取消或已执行的时候才可以取消");
       			return  false;
       		}
            if(j!=rows.length-1){
	       		ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version')+"\^";
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno')+"\^";
       		}else{
       	    	ver  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
	       		ids  += parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fdayplanno');
       	    }
       	    j++;
       }
       
       if(!ids){
       	  dealAlertMessage("没有找到主键值!");
	      return false;
       }
        var para ="ids="+ids+"&version="+ver;
		var url="<%=request.getContextPath()%>/ddDoutageplan.do?method=pigeonholeDdoutplans";
		ajaxSendRequest(para,url); 
	}
	
	
	function  getEquip(){
	
		var vArguments = new Object();
	   	 vArguments.title = "测试设备台账对话框";
	     vArguments.viewId = "default";
	     vArguments.showButton = true;
	     vArguments.readOnly = true;
	     vArguments.returnedFields = "FMEMO,FEQPID,FSTORELOCATION,FDEVCLASSNAME,FLEAVEFACNO,FMADECOUNTRY";
	     vArguments.multiSelect = true;
	     var sReturn = OpenEquipmentModal(vArguments,"http://200.200.200.199:8888/eqp/eqpEquipment.do?method=eqpEquipmentframe");
	     alert(sReturn);
   
  
	}
	
    /**
      改变状态时调用的ajax
    */
    function  ajaxSendRequest(para, url,succesmess,erromess){
        //alert(para +" "+url);
	    var myAjax = new Ajax.Request(url,{method: 'post', parameters: para,  onComplete: showResponse});
			 function showResponse(originalRequest){
		           if (originalRequest){   
		              // alert(originalRequest.responseText);          
		              if ("1"==originalRequest.responseText){
		                   //var td1    = parent.downFrame.document.all.ID1;
              				//selectTab(td1, '', 'true','false');
              				if(succesmess)
              					dealAlertMessage(succesmess);
              				else
              					dealAlertMessage("修改状态成功!");
		                    parent.downFrame.iframe1.createGrid('','0','','','','','','');
		              } else {
		                  if(erromess)
		                  	dealAlertMessage(erromess);
		                  else
		                  	dealAlertMessage("修改状态失败!");
		                  return false;
		              }
		           }
	           }
    }

  //调度员填写临时停电计划


  function  dispatchtempplan(){
  		parent.downFrame.onClick2("",'','','',"temporary");
  		
  }
  /*
  function workTransition(itemId,itemValue){

       var mygrid = parent.downFrame.iframe5.mygrid;

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

           var url = '/application/dddoutageplan/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;

           //showNotModalDialogYY(url,"600","300");

           var param = new Object();
           vReturnValue = showModalDialogYY(url,600,300,param,"日计划流程图",1);
           parent.downFrame.onClick5();
	       //parent.downFrame.iframe4.createGrid('','0','','','','','','');
       }

    }
    */
    function wf_history(itemId,itemValue){

           var mygrid = parent.downFrame.iframe5.mygrid;

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

   function workTransition(itemId,itemValue){
		var mygrid = parent.downFrame.iframe5.mygrid;
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
					
					var taskName = mygrid.getValueByName("taskName_");
					
					var status = mygrid.getValByRC(rows[row],'status');	
						var taskId = mygrid.getValByRC(rows[row],'taskId_');
						var taskInstanceId = mygrid.getValByRC(rows[row],'taskInstanceId_');
						 var url = '/application/dddoutageplan/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId+'&taskName='+taskName;
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
								var url		= "<%=request.getContextPath()%>/ddDoutageplan.do?method=workflowHandle";
								var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
								function callBackGrid(originalRequest){
									if(originalRequest){
										var td5   = parent.downFrame.document.all.ID5;
										selectTab(td5, '', 'false','false');
									}
								}
						}
				}
			}
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
