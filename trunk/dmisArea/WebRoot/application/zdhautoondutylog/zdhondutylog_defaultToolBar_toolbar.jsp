<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_grid.jsp" %>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"> </script>
<script type="text/javascript">
	/**
	 * 执行交接班操作
	 */
	function carryOn(){	   
       //获取详情页中的主键值(班号)
       var ondutyno=parent.downFrame.iframe2.document.getElementById('zdhAutoondutylogDto.ondutyno').value;      
       alert(ondutyno);
	   if (ondutyno == '' || ondutyno == null || typeof(ondutyno) == 'undefined'){ 
	      dealAlertMessage("没有找到主键值"+"\n"+"或"+"\n"+"请在保存后再进行交接班操作!");  
	      //alert("没有找到主键值"+"\n"+"或"+"\n"+"请在保存后再进行交接班操作!");
	      return false;
	   }
	   var url = "<%=request.getContextPath()%>/zdhAutoondutylog.do?method=carryOn";
	   //避免乱码
	   url = encodeURI(url);	   
       var pars = "ondutyno="+ondutyno;
       
       //利用Ajax发送请求
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           var ret;
           if (originalRequest){   
              ret =  Number(originalRequest.responseText);
              switch (ret) {
                 case 0:
                 	dealAlertMessage('没有遥信记录,不能进行交接班!');
                    //alert('没有遥信记录,不能进行交接班!');
                    break;
                 case 1:
                 	dealAlertMessage('没有遥测记录,不能进行交接班!');
                    //alert('没有遥测记录,不能进行交接班!');
                    break;
                 case 2:          
                 	dealAlertMessage('没有获取当前的班号!');          
                    //alert('没有获取当前的班号!');
                    break;
                 case 3:
                 	dealAlertMessage('没有开始工作核查,不允许进行交接班!');
                    //alert('没有开始工作核查,不允许进行交接班!');
                    break;
                 case 4:
                 	dealAlertMessage('执行交接班完毕。'+'\n^_^\n'+'已经将完成情况核查为空的日计划核查记录拷贝到下一班');
                    //alert('执行交接班完毕。'+'\n^_^\n'+'已经将完成情况核查为空的日计划核查记录拷贝到下一班');
                    break;
                 case 5:
                 	dealAlertMessage('执行交接班完毕。'+'\n^_^\n'+'已经将未完成的机房工作表拷贝到本班');
                    //alert('执行交接班完毕。'+'\n^_^\n'+'已经将未完成的机房工作表拷贝到本班');
                    break;
                 case 45:
                 	dealAlertMessage('执行交接班完毕。'+'\n^_^\n'+'已经将完成情况核查为空的日计划核查记录拷贝到下一班'+'\n'+'同时将未完成的机房工作表拷贝到本班');
                    //alert('执行交接班完毕。'+'\n^_^\n'+'已经将完成情况核查为空的日计划核查记录拷贝到下一班'+'\n'+'同时将未完成的机房工作表拷贝到本班');                    
                    break;
                 case 16:
                 	dealAlertMessage('执行交接班完毕。'+'\n^_^\n'+'但没有生成新的日计划核查记录和机房工作表!');
                    //alert('执行交接班完毕。'+'\n^_^\n'+'但没有生成新的日计划核查记录和机房工作表!');
                    break;
              }
              
           }
       } 
	}
    /**
	 * 删除记录,工具栏的删除按钮调用
	 */
	function deleteData() {       
       //获取选择的行号数组(支持辅助选择框及控件本身的反显)
       var primaryId = "";
       var enableOp = true;
       var version="";
       var versions="";
       var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
       var ondutyno="";
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
	                        alert('页面='+tableNum); 
	
	                  } 
	
	                }

                  }
       for (row = 0;row<rows.length;row++){
          //获取指定行中的执行状态
          /*fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'fexcutestatus');
          if (fexcutestatus == '归档') {
             continue;             
          } else {
             enableOp = true;
          }
          */
          ondutyno = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'ondutyno');
          version = parent.downFrame.iframe1.mygrid.getValByRC(rows[row],'version');
          
          if (ondutyno == "" || ondutyno == null) { continue;}
          if (primaryId == "") {
             primaryId = ondutyno;
          } else {
             primaryId += '^'+ondutyno;
          }
          if (version == '' || version == null) {
             version = '0';
          }
          if (versions == "") {
             versions = version;
          } else {
             versions += '^'+version;
          }
          alert('tableNum='+tableNum);
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
	   var url = "<%=request.getContextPath()%>/zdhAutoondutylog.do?method=deleteRows";
	   //避免乱码
	   url = encodeURI(url);
       var pars = "ondutyno=" + primaryId;       
       pars += "&versions=" + versions;
       var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
       function callBackGrid(originalRequest){
           if(originalRequest){
              //alert(originalRequest.responseText);
              if("删除失败" != originalRequest.responseText){
                  //parent.downFrame.iframe1.createGrid('','0','','','','','','');
                   dealAlertMessage(originalRequest.responseText);
                  //alert(originalRequest.responseText);
              } else {
                  dealAlertMessage("修改状态失败!");
                  //alert("修改状态失败!");
              }

           }
           //按照历史的查询条件、过滤条件刷新列表
            var td2=parent.downFrame.document.all.ID1
			selectTab(td2,'','false','true'); 	
           parent.downFrame.iframe1.mygrid.anewGridAfterDelete();
       }
       
	}
	
</script>