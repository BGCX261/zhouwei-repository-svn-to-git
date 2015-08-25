<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--
	//设置按钮状态

	function btnState(){
		disableButton("new,copy,save,cancel,delete");
		
	}

//交接班列表   
   	function onClick1(){
   		disableButton("new,copy,save,cancel,delete,lastRow,nextRow");
//   		disableMenuItem("turnOver");
   		enableMenuItem("turnOver");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_defaultList_grid.jsp";
	}
   
   
  

   
 	//交接班详情  
  	function onClick2(src,isNew,isCopy){
  		var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		enableMenuItem("turnOver");
  		disableButton("new,copy,save,cancel,delete,lastRow,nextRow");
   		
		//var mainId = dealMainId(isNew);
		var myGrid = parent.downFrame.iframe1.mygrid;
		
		var mainId ="";
		mainId = myGrid.getValueByName("fid");
		
		var endtime = myGrid.getValueByName("fhandovertime");//值班结束时间
		//如果值班结束时间为空，则该条记录是可修改的

		if (endtime ==null || endtime==""){
			disableButton("new,copy,delete,lastRow,nextRow");
		}
		
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddClassondutylog.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//设备重载
   	function onClick3(){
	   	var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		
	   	disableMenuItem("turnOver");
	   	btnState();
   		var myGrid = parent.downFrame.iframe1.mygrid;
		var fid ="";
		fid = myGrid.getValueByName("fid");
		
		
		document.all.iframe3.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_DDHeavyload_grid.jsp?fid="+fid;
	}
   
   
  
//自投停用
   	function onClick4(){
	   	var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		disableMenuItem("turnOver");
	   	btnState();
   		
   		var myGrid = parent.downFrame.iframe1.mygrid;
   		var fid ="";
		fid = myGrid.getValueByName("fid");
		
		document.all.iframe4.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_DDswitchautostop_grid.jsp?fid="+fid;
	}
   
   
  
//运行纪事
   	function onClick5(){
 	   	var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		
 	   	disableMenuItem("turnOver");
 	   	btnState();
   		var myGrid = parent.downFrame.iframe1.mygrid;
   		var fid ="";
		fid = myGrid.getValueByName("fid");
		var endtime = myGrid.getValueByName("fhandovertime");//值班结束时间
		//如果值班结束时间为空，可以增加运行记事，否则不能增加记录
		var canadd="true";
		if (endtime ==null || endtime==""){
			canadd="true";
		}
		else
		{
			canadd = "false";
		}
		document.all.iframe5.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_ddRunRecord_detail.jsp?fid="+fid+"&canadd="+canadd;
	}
   
   
  

   	function onClick6(){
 	   	var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		disableMenuItem("turnOver");
 	   	btnState();
 	   	var myGrid = parent.downFrame.iframe1.mygrid;
   		var fid =myGrid.getValueByName("fid");
   		
		document.all.iframe6.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_powerplantschedule_grid.jsp?fid="+fid;
	}
   
   
  

   	function onClick7(){
 	   	var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		disableMenuItem("turnOver");
 	   	btnState();
 	   	var myGrid = parent.downFrame.iframe1.mygrid;
   		var fid =myGrid.getValueByName("fid");
   		
		document.all.iframe7.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_plantschedule_grid.jsp?fid="+fid;
	}
   
   
  

   	function onClick8(){
		   var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		disableMenuItem("turnOver");
		   	btnState();
		   	var myGrid = parent.downFrame.iframe1.mygrid;
	   	var fid =myGrid.getValueByName("fid");
	   	
		document.all.iframe8.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_DDwaterheight_grid.jsp?fid="+fid;
	}
   
   
  

   	function onClick9(){
		var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条交接班记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条交接班记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
  		disableMenuItem("turnOver");
		btnState();
		var myGrid = parent.downFrame.iframe1.mygrid;
	   	var fid =myGrid.getValueByName("fid");
	   	
		document.all.iframe9.src = "<%=request.getContextPath()%>/application/ddclassondutylog/DDclassonduty_Planwater_grid.jsp?fid="+fid;
	}
   
   
  

   
   
  	function onClick10(src,isNew,isCopy){
  	var myGrid = parent.downFrame.iframe1.mygrid;
		var mainId = myGrid.getValueByName("fid");
		document.all.iframe10.src = "<%=request.getContextPath()%>/ddClassondutylog.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="调度日志浏览,调度交接班记录详情,重载记录,自投停用记录,运行记事,电网方式调整运行,电厂调度记录,水位记录,计划放水,日负荷曲线" scroll="auto,auto,auto,auto,auto,auto,auto,auto,auto,auto"> </jhop:labelgroup>
