<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
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
	function ddriskanalypublish(itemId,itemValue){
		alert("发布成功");
	}
	function upload(itemId,itemValue){
	   
	    var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           dealAlertMessage("请您选择一条风险");
	           //alert("请您选择一条风险");
	           return false;
	    }
	    if(rows.length>1){    
	       dealAlertMessage("您只能选择一条风险!!!");
	       //alert("您只能选择一条风险!!!");
		   return false; 
	    }
		var primaryStr = parent.downFrame.iframe1.mygrid.getSelectedRowsData(3);
		
		var primaryId   = "";
		if(primaryStr.indexOf("@@@") != -1){
			var dataArra 	= primaryStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fid"){
						primaryId = value;
					}
				}
			}
		}		
		var url="/application/ddrepairrisklist/DdRepairrisklist_main.jsp?primaryId="+primaryId;
		var ob = new Object();
		showModalDialogYY(url,600,200,ob,"",0);
		var td3    = parent.downFrame.document.all.ID3;
        selectTab(td3, '', 'true','false');

	}

    function deleteData(temId,itemValue){
              dealAlertMessage("对不起，电网风险记录没有删除操作");
	          //alert("对不起，电网风险记录没有删除操作");	   
	}

  
	
	
	
    function newByMplan(temId,itemValue){//根据月计划生成风险分析

        
        var num=Math.random();
        var url="/ddRepairrisklist.do?method=newByMplan&num="+num;    
        //alert(url);  
        var ob=new Object();
		var vReturnValue=showModalDialogYY(url,600,600,ob,"风险",1);
		
       	if(vReturnValue){
		  var pars        = "pars="+vReturnValue;
          var url="<%=request.getContextPath()%>/ddRepairrisklist.do?method=doNewByMplan";
		  var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: showResponse});
		     function showResponse(originalRequest){
	                    dealAlertMessage(originalRequest.responseText);
	                    //alert(originalRequest.responseText);
						var td1    = parent.downFrame.document.all.ID1;
						selectTab(td1, '', 'true','false');
						parent.downFrame.iframe1.createGrid('','0','','','','','','');
	         }
        } 
 
	}
	
    function workTransition(itemId,itemValue){//工作流


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

           var url = '/application/ddrepairrisklist/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;

           var param = new Object();

           vReturnValue = showModalDialogYY(url,"600","300",param,"工作流","auto");
       
           if(vReturnValue){
                  var url="<%=request.getContextPath()%>/ddRepairrisklist.do?method=workflowHandle";
	              var myAjax = new Ajax.Request(url,{method: 'post', parameters: vReturnValue.type,  onComplete: showResponse});
	              function showResponse(originalRequest){
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

       operToolbarRow("iframe1","ddRepairrisklist","previous");

    }

     /**
     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","ddRepairrisklist","next");

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
