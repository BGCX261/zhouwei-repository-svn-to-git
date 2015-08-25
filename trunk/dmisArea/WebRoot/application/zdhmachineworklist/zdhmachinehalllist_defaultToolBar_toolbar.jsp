<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="com.techstar.dmis.common.ZdhConstants"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/zdhmachineworklist/zdhmachineworklist.js"> </script>
<script type="text/javascript">

	/**
	 * 删除记录,工具栏的删除按钮调用
	 */
	function deleteData() {       
	
       //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var primaryId = "";
       var workType="";
       var enableOp = false;
       var version="";
       var versions="";
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
       var jobid="";
       var bEnable="false";
        if(typeof (rows)=="undefined")
	   {
	  
	   		return false;
	   	}
	   	
	   	var isDelete=confirm('您确定要进行删除操作吗?');
	   	if(!isDelete)return false;
	   	
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
         
           workType=parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'jobcategory');
           if(workType=="<%=ZdhConstants.ZDH_MACHINEWORK%>"||workType=="停复役")
          {
          	bEnable=true;
          	break;
          }
          if (fexcutestatus == '归档') {
             continue;             
          } else {
            enableOp = true;
          }
          jobid = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'jobid');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (jobid == "" || jobid == null) { continue;}
          if (primaryId == "") {
             primaryId = jobid;
          } else {
             primaryId += '^'+jobid;
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
	      dealAlertMessage("没有找到主键值!");
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhMachineworklist.do?method=deleteRows";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "jobid=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){
               
               dealAlertMessage('机房工作删除成功！');
                  
              } else {
                dealAlertMessage('机房工作删除失败！');
              }

           }
			 //按照历史的查询条件、过滤条件刷新列表
 			var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 
 			parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
       }
	}
		function showDetail(){ 
		   var primaryId="";
		   var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
		   var colValue="";
		   var row=0;
		   var primaryId="";
		   if(typeof (rows)=="undefined")
		   {
		  
		   		return false;
		   	}
		   	else
		   {
		   	        
			   if(rows.length>1)	         
			   	dealAlertMessage('请选择一行');   
				else
				{		  
					primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'jobid');
		            var url="<%=request.getContextPath()%>/zdhMachineworklist.do?method=showDetail&mainId="+primaryId;
		      		showModalDialogYY(url,600,400,""," ԭ机房详情",1);	  
			    }
		   }
		
		       
	   //parent.downFrame.iframe1.createGrid('','0','','','','','','');
					
	}
		/**

     * 上一条操作

     */

    function preRow(){

       operToolbarRow("iframe1","zdhMachineworklist","previous");

}

/**

     * 下一条操作

     */

    function nextRow(){

       operToolbarRow("iframe1","zdhMachineworklist","next");

}
</script>