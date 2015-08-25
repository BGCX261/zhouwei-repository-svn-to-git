<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"> </script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">

    /**
     * 查找按钮:    find
        新增按钮:    new 
         复制按钮:     copy
              保存按钮:    save
              删除按钮:    delete
              取消按钮:    cancel
             工作流扭转按钮: transition
              上一条按钮: lastRow
              下一条按钮: nextRow
              查看报表按钮:  report
     
     */

   	function onClick1(){   	     
   	    disableMenuItem('carryOn');
   	    disableButton('save,cancel');
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_defaultList_grid.jsp";
	  
	    //屏蔽交接班操作


   	    //var arrDisable = new Array('carryOn');  
        //parent.upFrame.disableItem(arrDisable);
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
  	    enableMenuItem('carryOn');  
  	    disableButton('find,new,copy,transition');	    
		//var mainId = dealMainId(isNew);
		var primaryId="";
		var colValue="";
		var row=0;
		
		var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
		
		if (typeof(rows) != 'undefined')
		 {
		
		       if(rows.length>1)//判断是否选择多行
			   {
			   
			   	   var isOk=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isOk)//判断是否同意默认第一行，是选择第一行，否退出
			       {
			       		var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
			       		return false;
				      	
				      	
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	

			}		
			
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhAutoondutylog.do?method=initDetail&mainId=" + primaryId + "&isCopy="+isCopy;
	}
   

   	function onClick3(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出			       
			       {    
			            //取消所有行的选择状态
			            parent.downFrame.iframe1.mygrid.clearSelection();
			            //选择第一个选择的行
			            parent.downFrame.iframe1.mygrid.setSelectedRow(rows[0]);
			            //如果存在辅助选择框，要将其置为选择状态			            
			            if (parent.downFrame.iframe1.mygrid.colIsVisible[1] == 1) {
			               parent.downFrame.iframe1.mygrid.cells(rows[0],1).setValue(1);
			            }
			            
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 document.all.iframe3.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_machinehalllist_grid.jsp?mainId="+primaryId;

			}
	}
   
      	function onClick4(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
				 document.all.iframe4.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhworkbill_grid.jsp?mainId="+primaryId;
			}
	}
  
      	function onClick5(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
				 document.all.iframe5.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhdayplancheck_grid.jsp?mainId="+primaryId;
			}
	}

     	function onClick6(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');

			 	  document.all.iframe6.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhrsrec_grid.jsp?mainId="+primaryId;

			}
	}
  
   	function onClick7(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 
				document.all.iframe7.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhfaultlist_grid.jsp?mainId="+primaryId;
			}
	}

   	function onClick8(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 
				document.all.iframe8.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhsystemchartalter_grid.jsp?mainId="+primaryId;
			}
	}   
   
  

      	function onClick9(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 
				 document.all.iframe9.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhrmdataalter_grid.jsp?mainId="+primaryId;
			}
	}
   
      	function onClick10(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 
				 document.all.iframe10.src = "<%=request.getContextPath()%>/zdhEligiblermrate.do?method=extInitDetail&mainId=" + primaryId ;
			}
	}
   
      	function onClick11(){
   	   //屏蔽交接班操作

   		 disableMenuItem('carryOn');
   		 disableButton("new,copy,save,cancel,find,delete,transition");
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)=="undefined")//判断是否选择列表中数据了
		 {
		 	dealAlertMessage('请选择自动化值班数据!');  
		 	var td2=parent.downFrame.document.all.ID1;
		 	selectTab(td2,'','false','true'); 
		 	return false;
		 }
		 else
		 {
		       if(rows.length>1)//判断是否选择多行
			   {
			   	   var isDelete=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isDelete)//判断是否同意默认第一行，是选择第一行，否退出
			       {
				      	var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	return false;
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'ondutyno');
			 	 
				 document.all.iframe11.src = "<%=request.getContextPath()%>/application/zdhautoondutylog/zdhondutylog_zdhtransrec_grid.jsp?mainId="+primaryId;
			}
	}
  

</script>

<jhop:labelgroup height="530"
	labelHead="自动化值班日志浏览,自动化值班日志详情,机房工作,工作票,日计划核查,遥信记录,自动化缺陷,系统图修改记录,遥测数据修改,遥测合格率,传动记录"
	scroll="auto,auto,auto,auto,auto,auto,auto,auto,auto,auto,auto">
</jhop:labelgroup>
