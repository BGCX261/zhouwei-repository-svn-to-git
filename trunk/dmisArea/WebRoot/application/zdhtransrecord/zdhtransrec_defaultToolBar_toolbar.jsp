<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/zdhtransrecord/zdhtransrecord.js"> </script>
<script type="text/javascript">


	
	
	function showDetail(){ 
	   var primaryId="";
	   var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	   var colValue="";
	   var row=0;
	   var transrecordid="";
	  	
	   if(typeof (rows)=="undefined")
	   {
	  
	   		return false;
	   	}
	   	else
	   {
	   	      
		   if(rows.length>1)
		   {
		    dealAlertMessage('请选择一行!');        
		  
		   	return false;   
		   	}
			else
			{	
			 	  
				transrecordid = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'transrecordid');
	            var url="<%=request.getContextPath()%>/zdhTransrecord.do?method=showDetail&mainId="+transrecordid;
	      		showModalDialogYY(url,600,400,""," ԭ传动记录详情",1);	  
		    }
	   }

					
	}
/**
	 * 删除记录,工具栏的删除按钮调用
	 */
	function deleteData() {       

       //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var primaryId = "";
       var enableOp = false;
       var version="";
       var versions="";
    	 var workType="";
    	 var bEnable=false;
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
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

       
       var transrecordid="";
       if(typeof (rows)=="undefined")
	   {
	  
	   		return false;
	   	}
	   	       //确定删除
       var isDelete=confirm('您确定要进行删除操作吗?');
       if(!isDelete)return false; 
       
       for (row = 0;row<rows.length;row++){
          //获取指定行中的执行状态


          fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
          workType=parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'tasksource');
          if(workType=="<%=ZdhConstants.ZdhReception_WORKSOURCE%>"||workType=="<%=ZdhConstants.ZdhTransrecord_BUSINESS_REASON_ZDHSRAPP%>")
          {
          	bEnable=true;
          	break;
          }
          if (fexcutestatus == '归档') {
             continue;             
          } else {
            enableOp = true;
          }
          transrecordid = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'transrecordid');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (transrecordid == "" || transrecordid == null) { continue;}
          if (primaryId == "") {
             primaryId = transrecordid;
          } else {
             primaryId += '^'+transrecordid;
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
       if(bEnable==true)
       {
         dealAlertMessage('工作来源来自其他，不能删除!');
          
          return false;
       }
       if (enableOp == false){
       	  dealAlertMessage('当前选择的数据是不允许删除的!');
          
          return false;
       }
       if (primaryId == ""){ 
          dealAlertMessage('没有找到主键值!');
	     
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhTransrecord.do?method=deleteRows";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "transrecordid=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
    
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){              
              	dealAlertMessage('删除传动记录成功!');                 
              } else {
                dealAlertMessage('删除传动记录失败!');
              }

           }
 			//按照历史的查询条件、过滤条件刷新列表
 			var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 
           parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
           
       }
	}
	//盖章
	function changeStatus(){
	   //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var primaryId = "";
       var enableOp = false;
       var version="";
       var versions="";     
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
           var transrecordid="";
       if(typeof (rows)=="undefined")
	   {
	  
	   		return false;
	   	}
	   	
       var isDelete=confirm('您确定要进行盖传动章操作吗?');
       if(!isDelete)return false; 
       
       for (row = 0;row<rows.length;row++){
          //获取指定行中的执行状态


          fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
          transrecordid = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'transrecordid');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (transrecordid == "" || transrecordid == null) { continue;}
          if (primaryId == "") {
             primaryId = transrecordid;
          } else {
             primaryId += '^'+transrecordid;
          }
          if (version == '' || version == null) {
             version = '0';
          }
          if (versions == "") {
             versions = version;
          } else {
             versions += '^'+version;
          }
         
       }
       

       if (primaryId == ""){ 
          dealAlertMessage('没有找到主键值!');
	     
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhTransrecord.do?method=changeStatus";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "transrecordid=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
    
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){              
              	dealAlertMessage('盖传动章成功!');                 
              } else {
                dealAlertMessage('删除盖传动章失败!');
              }

           }
 			//按照历史的查询条件、过滤条件刷新列表
 			var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 
           parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
       
	}
	}
	
	/**

     * 上一条操作

     */

    function preRow(){

       operToolbarRow("iframe1","zdhTransrecord","previous");

}

/**

     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","zdhTransrecord","next");

}

 
	
</script>
