<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/zdhsequencetable/zdhsequencetable.js"> </script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/excel/excel.js"> </script>
<script type="text/javascript">



function changerow(obj,currRowNum,rowNum)
{

	var newRow=0;
	var nextRow=0;
	while(true){	
	nextRow=Number(currRowNum)+1;
	newRow=Number(nextRow)-1;
		obj.changeRowId(nextRow,newRow);

		currRowNum++;
		if(rowNum==currRowNum){
			break;
		}
	}

}
	/**
	*删除表格中的数据
	*/
function deleteGridData(){

	var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();

	if(typeof(rows)=="undefined"){return false}
	var ifDelete=confirm('你确定要进行删除操作吗?');
	if(!ifDelete)return false;
	var rowNum=0;
	for(row=rows.length-1;row>=0;row--)
	{
		rowNum=parent.downFrame.iframe1.mygrid.getRowsNum();

		parent.downFrame.iframe1.mygrid.deleteRow(rows[row]);

		changerow(parent.downFrame.iframe1.mygrid,rows[row],rowNum);

	}

}

	/**
	 * 删除记录,工具栏的删除按钮调用
	 */
	function deleteData() {       
       //删除导入到列表中的数据

       if(parent.downFrame.iframe1.listOper.value=='importExcel')
       	deleteGridData();
       
       //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var primaryId = "";
       var enableOp = false;
       var version="";
       var versions="";
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
       var fsequenceno="";
       if(typeof (rows)=="undefined"){return false;}
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



          fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fstatus');
          if (fexcutestatus == '归档') {
             continue;             
          } else {
            enableOp = true;
          }
          fsequenceno = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fsequenceno');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (fsequenceno == "" || fsequenceno == null) { continue;}
          if (primaryId == "") {
             primaryId = fsequenceno;
          } else {
             primaryId += '^'+fsequenceno;
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
          return false;
       }
       if (primaryId == ""){ 
          dealAlertMessage('没有找到主键值!');   	      
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhSequencetable.do?method=deleteRows";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "fsequenceno=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("改变状态失败" != originalRequest.responseText){
                  dealAlertMessage('序位删除成功!');  
              } else {
              	  dealAlertMessage('序位删除失败!');  
               
              }

           }
 			//按照历史的查询条件、过滤条件刷新列表

			var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 
 			parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
       }
	}
	/**
	*用于导入excel操作
	*/
	function importExcel(){
		var isOk=confirm('导入Excel时将清空列表中的数据是否确定导入?');
       	if(!isOk)return false;
       //清空列表
       	var strWhere="fsequenceno^string^-1";
       	parent.downFrame.iframe1.createGrid('','0','','','',strWhere,'','');
		var url="<%=request.getContextPath()%>/common/excel/excel_import.jsp";
	    var retExcel=showModalDialogYY(url,300,150,""," ԭ序位信息导入",1);		
		excelToGrid(parent.downFrame.iframe1.mygrid,retExcel);
		parent.downFrame.iframe1.listOper.value='importExcel';
	}
		/**

     * 上一条操作


     */

    function preRow(){

       operToolbarRow("iframe1","zdhSequencetable","previous");

	}

/**

     * 下一条操作


     */

    function nextRow(){

       operToolbarRow("iframe1","zdhSequencetable","next");

	}
</script>
