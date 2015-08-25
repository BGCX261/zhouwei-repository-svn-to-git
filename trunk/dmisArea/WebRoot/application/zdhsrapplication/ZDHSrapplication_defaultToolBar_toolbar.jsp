<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_grid.jsp" %>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"> </script>
<script type="text/javascript">	
	/**
	 * 改变申请单的状态(归档、作废)
	 */
	function changeStatus(updateFlag){
	   var primaryId = "";	 	  
	   var fexcutestatus ="";
	   var enableOp=false;
	   //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
       var colValue="";
       if (typeof(rows) == 'undefined') { 
          return false;
       }
       for (row = 0;row<rows.length;row++){
          //获取指定行中的执行状态


          fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
          if (updateFlag == 'comfirm'){
             //作废的申请单不可归档
             if (fexcutestatus == '作废') {
                continue;
             } else {
                enableOp = true;
             }
          } else if (updateFlag == 'abate'){
             //归档的申请单不可 作废
             if (fexcutestatus == '归档') {
                continue;
             } else {
                enableOp = true;
             }           
          }
          
          //获取指定行的主键列的列值


          colValue = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fapplicationno');
          
          if (colValue == "" || colValue == null) { continue;}
          if (primaryId == "") {
             primaryId = colValue;
          } else {
             primaryId += '^'+colValue;
          }
       }
       if (enableOp == false) {
       	  dealAlertMessage('选择的申请单的状态不能进行当前的操作!');
         // alert("选择的申请单的状态不能进行当前的操作!");
          return false;
       }
	   if (primaryId == ""){ 
	      dealAlertMessage('没有找到主键值!');
	      //alert("没有找到主键值!");
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhSrapplication.do?method=changeStatus";
	   //避免乱码
	   url = encodeURI(url);
	   
       var pars = "mainId="+primaryId;
       if (updateFlag == 'comfirm'){
          //归档工作票


          pars  += "&updateFlag=归档";
       } else if (updateFlag == 'abate'){
          //作废工作票


          pars  += "&updateFlag=作废";
       }       
	   
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){
                  parent.downFrame.iframe1.createGrid('','0','','','','','','');
                  dealAlertMessage('修改状态完毕!');
                  //alert('修改状态完毕');
              } else {
                  dealAlertMessage('修改状态失败!');
                  //alert("修改状态失败!");
                  return false;
              }
              
           }

       }
					
	}
	/**
	 * 归档申请单


	 */
	function comfirmApp(){
		changeStatus("comfirm");
	}
	/**
	 * 作废申请单


	 */
	function abateApp(){
		changeStatus("abate");
	}
	/**
	 * 删除记录,工具栏的删除按钮调用
	 */
	function deleteData() {       
       //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       	   	       //确定删除
       var isDelete=confirm('您确定要进行删除操作吗?');
       if(!isDelete)return false; 
       var primaryId = "";
       var enableOp = false;
       var version="";
       var versions="";
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
       var fapplicationno="";
       if (typeof(rows) == 'undefined') { 
          return false;
       }
       //如果为详情页只删除当前页的数据


       var tds = parent.downFrame.document.getElementsByTagName("td");
	   var tableNum=0;
       for (var i=0; i<tds.length; i++){

	       	var td = tds[i];
	
	       	var tdName = tds[i].id;
	
	        if (tdName.indexOf('ID') != -1){
	
	            if (td.className == "ooihj"){
		               //如果进入if条件，说明是当前tab页.
	
	                     tableNum=i;//tableNum=当前页+1;i=3是详情页
	    
	                  } 
	
	                }

                  }
       for (row = 0;row<rows.length;row++){
          //获取指定行中的执行状态


          fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
          if (fexcutestatus == '归档') {
             continue;             
          } else {
             enableOp = true;
          }
          fapplicationno = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fapplicationno');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (fapplicationno == "" || fapplicationno == null) { continue;}
          if (primaryId == "") {
             primaryId = fapplicationno;
          } else {
             primaryId += '^'+fapplicationno;
          }
          if (version == '' || version == null) {
             version = '0';
          }
          if (versions == "") {
             versions = version;
          } else {
             versions += '^'+version;
          }
           if(tableNum==3)break;//详情页只删除第一个记录


       }
       
       if (enableOp == false){
       	  dealAlertMessage('当前选择的数据是不允许删除的!');
          //alert('当前选择的数据是不允许删除的!');
          return false;
       }
       if (primaryId == ""){ 
          dealAlertMessage("没有找到主键值!");
	      //alert("没有找到主键值!");
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhSrapplication.do?method=deleteRows";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "fapplicationno=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){
                  //parent.downFrame.iframe1.createGrid('','0','','','','','','');
                  dealAlertMessage('数据删除成功');
              } else {
                  dealAlertMessage('数据删除失败!')
                  //alert("修改状态失败!");
              }

           }
           //按照历史的查询条件、过滤条件刷新列表


           //详情页删除后需要回到列表页
           	var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 	
           parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
       }
       
	}
	
	/**
	 *  工作流流转


	 */
	function workTransition(itemId,itemValue){
	   var mygrid = parent.downFrame.iframe3.mygrid;
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
					//var status = mygrid.getValByRC(rows[row],'status');	
					
					var status = mygrid.getValByRC(rows[row],'status');	
						var taskId = mygrid.getValByRC(rows[row],'taskId_');
						var taskInstanceId = mygrid.getValByRC(rows[row],'taskInstanceId_');
						
						var url = '/application/zdhsrapplication/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;
						var param = new Object();
						vReturnValue = showModalDialogYY(url,"600","350",param,"停复役工作流","auto");
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
								var url		= "<%=request.getContextPath()%>/zdhSrapplication.do?method=workflowHandle";
								var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
								function callBackGrid(originalRequest){
									if(originalRequest){
										var td3   = parent.downFrame.document.all.ID3;
										selectTab(td3, '', 'false','false');
									}
								}
						}
				}
			}
		}
	  
    }
    /**
     * 查看工作流处理历史


     */
	function wf_history(itemId,itemValue){
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
                    var taskInstanceId = mygrid.getValueByName("taskInstanceId_");
                    var url = 'application/todolist/handlehistory.jsp?taskInstanceId='+taskInstanceId+'&busId='+id;
                    window.open(url);
                    //showNotModalDialogYY(url,"600","500");
           }        
    }

	
</script>