<%@ page contentType="text/html; charset=utf-8" language="java"%>

<%@ include file="/common/init_tag.jsp" %>
<%@ page import="com.techstar.dmis.helper.ResourceHelp" %>
<%@ page import="com.techstar.dmis.common.ZdhConstants" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<%
     String nolabids = ResourceHelp.getNoBuids("ZdhSrapplication","zdhsrapplication_tab",ZdhConstants.ZDHSRAPPLICATION_TABS);
     //System.out.println("fffffffff="+nolabids);
     String nobuttons = ResourceHelp.getNoBuids("ZdhSrapplication","zdhsrapplication_button",ZdhConstants.ZDHSRAPPLICATION_TOOLBUTTONS);
     String nooptions = ResourceHelp.getNoBuids("ZdhSrapplication","zdhsrapplication_option",ZdhConstants.ZDHSRAPPLICATION_OPTIONS);
     nolabids = ResourceHelp.getkeycode(nolabids,"zdhsrapplication_tab");  
     
     System.out.println("nolabids="+nolabids);  
     nobuttons = ResourceHelp.getkeycode(nobuttons,"zdhsrapplication_button");

 %>

<script language="javascript">

	var  preclick = ""; 

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
   	    disableButton('');
   	     disableMenuItem('zdh_wf_history');
   	    disableButton("save,cancel"+",<%=nobuttons%>");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhsrapplication/ZDHSrapplication_defaultList_grid.jsp";
		
		preclick = "click1"; 
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy){
  	    //使删除按钮失效
  	    //disableButton('delete');
  	    disableMenuItem('zdh_wf_history');
         disableButton("new,copy,find"+",<%=nobuttons%>");  
		 var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	     var row=0;
		 if(typeof(rows)!="undefined")//判断是否选择列表中数据了
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
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fapplicationno');			 	 

			}
		//从待办事项来
          if(preclick=="click3"){
			//"click5" 为代办事项的
          	var mygrid = parent.downFrame.iframe4.mygrid;
          	var did =mygrid.getValueByName("id");
          	if(did != null && did != "undefined" && did != "null" && did != ""){
              primaryId = did;
         	}
		}
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhSrapplication.do?method=initDetail&mainId=" + primaryId + "&isCopy="+isCopy;
		preclick = "click2"; 
	}
   
    /*
   	function onClick3(){
   	    //使删除按钮失效

 		disableMenuItem('zdh_wf_history');

  	    disableButton("delete,new,copy,save,cancel"+",<%=nobuttons%>");
		//document.all.iframe3.src = "<%=request.getContextPath()%>/application/zdhsrapplication/ZDHSrapplication_releqplist_grid.jsp";
		document.all.iframe3.src = "http://200.200.200.195:8989/eqp/eqpEquipment.do?method=eqpEquipmentframe";
		
		preclick = "click3"; 
	}
   */
    /**
     * 我的代表事项
     */
   function onClick3(){
    enableMenuItem('zdh_wf_history');
    disableButton('find,new,copy,save,cancel,delete,lastRow,nextRow,report'+',<%=nobuttons%>');
      document.all.iframe3.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ZdhSrapplication"; 
   	
   	preclick = "click3"; 
   } 

</script>

<jhop:labelgroup height="530" labelHead="停复役申请浏览,停复役申请详情,我的待办事项" scroll="auto,auto,auto"> 
</jhop:labelgroup>
<script>
    //var res  = '';
   // alert(res);

	disableTab("<%=nolabids%>","1");
	//var  nooptions='';
	//alert(nooptions);
	//权限 点击coppy权限怎么和


	disableMenuItem('<%=nooptions%>,zdh_SRexcute,zdh_SRapplicationDistribute,zdh_Sendtocenter,zdh_comfirmApp');
	
</script>
