<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>

<%
	//故障简报，日计划等调操作票
	String callbill = (String)session.getAttribute("ddadddid");
	if (callbill ==null){
		callbill="";
	}
	session.removeAttribute("ddadddid");
	
 %>

<script language="javascript">
<!--
   var preclick="";
   var bill = '<%=callbill%>';
   	function onClick1(){
   	   
   		disableButton("");
   	//详情页的跳转
	   	if (bill !=""){
	   	    document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_defaultList_grid.jsp";
	   		var td2    = parent.downFrame.document.all.ID2;
			selectTab(td2, '', 'true','false');
	   		document.all.iframe2.src = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=initDetail&mainId=" + bill ;
	   		bill="";
		}
		else{
			document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_defaultList_grid.jsp";
		}
		 preclick="click1";
	}
   
   
  

   
  	function onClick2(src,isNew,isCopy,mainId){
  	    if(mainId == null 

              || mainId == "undefined" 

                     || mainId == "" 

                            || mainId == "null"){

           mainId = dealMainId(isNew);

        }

        if(mainId == "undefined"){

           mainId = "";

        }
		var mainId = dealMainId(isNew);
		disableButton('find,copy,transition,report');
		//从待办事项来
		if(preclick=="click4"){
          var mygrid = parent.downFrame.iframe4.mygrid;
        	var did =mygrid.getValueByName("id");
        	if(did != null && did != "undefined" && did != "null" && did != ""){
        		mainId = did;
        		disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");
        	}
        	
        }

		document.all.iframe2.src = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
		preclick="click2";
	}
	
	function fff(mainId){
	//alert("test");
		//var mainId = dealMainId(isNew);
		//disableButton("");
		var isCopy="";
		
			//document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddswitchseqbill/DdSwitchseqbill_defaultList_grid.jsp";
	   		var td2    = parent.downFrame.document.all.ID2;
			selectTab(td2, '', 'true','false');
			//disableButton("");
	   		document.all.iframe2.src = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=initDetail&mainId=" + mainId ;
		
		//;document.all.iframe2.src = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}
   

	
	function onClick3(src,isNew,isCopy){
		var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           alert("请选择一条操作票记录");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       alert("您只能选择一条操作记录!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
		var mainId = dealMainId(isNew);
		disableButton("new,copy,save,cancel,delete");
		document.all.iframe3.src = "<%=request.getContextPath()%>/ddSwitchseqbill.do?method=initDetailexe&mainId=" + mainId + "&isCopy="+isCopy;
		 preclick="click3";
	}
   
   
  function onClick4(src,isNew,isCopy){
       document.all.iframe4.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=Switchseqbill";
	    preclick="click4";
}

//-->
</script>

<jhop:labelgroup height="530" labelHead="调度操作票浏览,调度操作票详情,操作票执行,待办事项" scroll="auto,auto,auto,auto"> </jhop:labelgroup>
