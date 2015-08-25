<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/excel/excel.js"> </script>
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
	
    function workTransition(itemId,itemValue){//工作流


       var mygrid = parent.downFrame.iframe3.mygrid;
       
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

           var url = '/application/ddcutofftitle/wfpopup.jsp?id='+id+'&status='+status+'&taskInstanceId='+taskInstanceId+'&taskId='+taskId;

           var param = new Object();

           vReturnValue = showModalDialogYY(url,"600","300",param,"工作流","auto");
       
           if(vReturnValue){
                  var url="<%=request.getContextPath()%>/ddCutofftitle.do?method=workflowHandle";
	              var myAjax = new Ajax.Request(url,{method: 'post', parameters: vReturnValue.type,  onComplete: showResponse});
	              function showResponse(originalRequest){
                        if(vReturnValue.title=="simple"){
                           var td3    = parent.downFrame.document.all.ID3;
						   selectTab(td3, '', 'true','false');
						   parent.downFrame.iframe3.createGrid('','0','','','','','','');
                        }
	                    
	              }
           }       

    }	
    
    /**
     * 上一条操作

     */
	
	 function preRow(){

       operToolbarRow("iframe1","ddCutofftitle","previous");

    }

     /**
     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","ddCutofftitle","next");

    }
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

	/**
	*用于导入excel操作
	*/
	function importExcel(){
		var isOk=confirm('导入Excel时将清空列表中的数据是否确定导入?');
       	if(!isOk)return false;
        //清空列表
       	var strWhere="fid^string^-1";
       	parent.downFrame.iframe1.createGrid('','0','','','',strWhere,'','');
		var url="/common/excel/excel_import.jsp";
		//alert(url);
		var QQ = new Object();
		var  retExcel=showModalDialogYY(url,600,150,QQ,"序位信息导入",1);
		excelToGrid(parent.downFrame.iframe1.mygrid,retExcel);
		parent.downFrame.iframe1.listOper.value='importExcel';
	}
    
	
	
	
</script>