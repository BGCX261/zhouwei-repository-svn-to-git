<%@ page contentType="text/html; charset=utf-8" language="java" buffer="18kb"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ page import="com.techstar.dmis.helper.ResourceHelp" %>
<%@ page import="com.techstar.dmis.common.DispatchResConstants" %>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<% 
   //事故简报生成日计划用


    String ddatodayplanid = (String)session.getAttribute("ddadddid");
    if(ddatodayplanid==null){
     	ddatodayplanid="";
    }
	session.removeAttribute("ddadddid");
%>

<% 
    //(String parentbuid,String desc,String[] allbuids)
    //String nolabids="";
     String nolabids = ResourceHelp.getNoBuids("dddoutageplan","dddoutageplan_tab",DispatchResConstants.DDDOUTAGEPLAN_TABS);
     String nobuttons = ResourceHelp.getNoBuids("dddoutageplan","dddoutageplan_button",DispatchResConstants.DDDOUTAGEPLAN_TOOLBUTTONS);
     String nooptions = ResourceHelp.getNoBuids("dddoutageplan","dddoutageplan_option",DispatchResConstants.DDDOUTAGEPLAN_OPTION);
     nolabids = ResourceHelp.getkeycode(nolabids,"dddoutageplan_tab");
    
     nobuttons = ResourceHelp.getkeycode(nobuttons,"dddoutageplan_button");

%>

<script language="javascript">
<!--

    var ddid = '<%=ddatodayplanid%>';
    var  preclick="";
   	function onClick1(){
   	    disableMenuItem("ddd_wf_history,"+'<%=nooptions%>');
   	    if(ddid!=""){
   	        //disableButton('find,new,copy,delete,cancel,lastRow,nextRow,report');
   	     	document.all.iframe1.src = "<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_defaultList_grid.jsp";
   	     	var td2    = parent.downFrame.document.all.ID2;
			selectTab(td2, '', 'true','false');
			disableButton('find,new,copy,delete,cancel,report,transition'+',<%=nobuttons%>');
   	        document.all.iframe2.src = "<%=request.getContextPath()%>/ddDoutageplan.do?method=initDetail&op=detail&mainId=" + ddid; 
   	        ddid="";
   	     }else{
   	       disableButton('save,lastRow,nextRow,cancel,transition,'+"<%=nobuttons%>");
   	       document.all.iframe1.src = "<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_defaultList_grid.jsp";
   	     }
   	   preclick="click1";  
	}
	
	
  	function onClick2(src,isNew,isCopy,mainId,op){
  	    disableMenuItem("ddd_wf_history,"+'<%=nooptions%>');
  	    
		if(mainId == null 

              || mainId == "undefined" 

                     || mainId == "" 

                            || mainId == "null"){

           mainId = dealMainId(isNew);

        }

        if(mainId == "undefined"){

           mainId = "";

        }
        
        
        disableButton('find,copy,transition,report');
		if(op=='temporary'){
		 var td2    = parent.downFrame.document.all.ID2;
		  selectTab(td2, '', 'true','false');
		  disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report,transition"+',<%=nobuttons%>');
		}else{
			disableButton('find,copy,transition,report'+',<%=nobuttons%>');
		}
		//从待办事项来
		if(preclick=="click5"){
		   //"click5" 为代办事项的
           var mygrid = parent.downFrame.iframe5.mygrid;
        	var did =mygrid.getValueByName("id");
        	if(did != null && did != "undefined" && did != "null" && did != ""){
        		mainId = did;
        		disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report"+',<%=nobuttons%>');
        	}
        	
        }
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddDoutageplan.do?method=initDetail&op="+op+"&mainId=" + mainId + "&isCopy="+isCopy;
		preclick="click2";
	}
   

  /*
    

              *****************标识名***************

              查找按钮:    find

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
  function onClick3(src,isNew,isCopy){
        disableMenuItem("ddd_wf_history,"+'<%=nooptions%>');
  
        disableButton('find,new,copy,save,cancel,lastRow,nextRow,report,transition'+',<%=nobuttons%>');
   		var mainId = dealMainId(isNew);
   		if(!mainId){
   			alert("请选择一条记录");
   			var td1    = parent.downFrame.document.all.ID1;
			selectTab(td1, '', 'true','false');
   			return false;
   		}
		document.all.iframe3.src = "<%=request.getContextPath()%>/ddDoutageplan.do?method=initExecute&mainId="+mainId;
		//document.all.iframe7.src = "<%=request.getContextPath()%>/application/dddoutageplan/DDdayoutageplan_execute_detail.jsp";
		preclick="click3";
	}
	
  function onClick4(src,isNew,isCopy){
        disableMenuItem("ddd_wf_history,"+'<%=nooptions%>');
        var mainId = dealMainId(isNew);
        if(!mainId){
   			alert("请选择一条记录");
   			var td1    = parent.downFrame.document.all.ID1;
			selectTab(td1, '', 'true','false');
   			return false;
   		}
  		disableButton('find,new,copy,save,cancel,delete,lastRow,nextRow,report,transition,'+'<%=nobuttons%>');
       
		document.all.iframe4.src = "<%=request.getContextPath()%>/ddDoutageplan.do?method=showImg&mainId="+mainId;
		preclick="click4";
	}
 function onClick5(){
       disableMenuItem('<%=nooptions%>');
	   disableButton('find,new,copy,save,cancel,delete,lastRow,nextRow,report'+',<%=nobuttons%>');
       document.all.iframe5.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=Dddoutplan";
       preclick="click5";

    }

 

 //disableTab("3","1");

//-->
</script>

<jhop:labelgroup height="480" labelHead="日停电计划浏览,日停电计划详情,日计划执行,停电计划图,待办事项" scroll="auto,auto,auto,auto,auto"> </jhop:labelgroup>

<script>
    //var res  = '';
   // alert(res);
	disableTab("<%=nolabids%>","1");
	//var  nooptions='';
	//alert(nooptions);
	//权限 点击coppy权限怎么和

	disableMenuItem('<%=nooptions%>');
	
</script>




