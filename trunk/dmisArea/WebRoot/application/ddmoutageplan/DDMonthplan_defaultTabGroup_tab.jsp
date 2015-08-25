<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="com.techstar.dmis.helper.ResourceHelp" %>
<%@ page import="com.techstar.dmis.common.DispatchResConstants" %>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_date.jsp"%>
<%@ include file="/common/init_tag.jsp"%>

<%

     String nolabids = ResourceHelp.getNoBuids(DispatchResConstants.DDMOUTAGEPLANBuid,DispatchResConstants.DDMOUTAGEPLAN_TABDESC,DispatchResConstants.DDMOUTAGEPLAN_TABS);
     String nobuttons = ResourceHelp.getNoBuids(DispatchResConstants.DDMOUTAGEPLANBuid,DispatchResConstants.DDMOUTAGEPLAN_BUTTONDESC,DispatchResConstants.DDMOUTAGEPLAN_TOOLBUTTONS);
     String nooptions = ResourceHelp.getNoBuids(DispatchResConstants.DDMOUTAGEPLANBuid,DispatchResConstants.DDMOUTAGEPLAN_OPTIONDESC,DispatchResConstants.DDMOUTAGEPLAN_OPTION);
     nolabids = ResourceHelp.getkeycode(nolabids,DispatchResConstants.DDMOUTAGEPLAN_TABDESC);
     nobuttons = ResourceHelp.getkeycode(nobuttons,DispatchResConstants.DDMOUTAGEPLAN_BUTTONDESC);


 %>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>

<script language="javascript">
<!--

    var  preclick="";  
    
   	function onClick1(){
   	    disableButton('transition,report,save'+",<%=nobuttons%>");
   	    disableMenuItem("ddm_wf_history,"+'<%=nooptions%>');
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan_defaultList_grid.jsp";
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
        disableButton('copy,transition,report'+",<%=nobuttons%>");
        disableMenuItem("ddm_wf_history,"+'<%=nooptions%>');

        if(preclick=="click4"){

            var mygrid = parent.downFrame.iframe4.mygrid;

            var did =mygrid.getValueByName("id");

                  if(did != null && did != "undefined" && did != "null" && did != ""){

                             mainId = did;

                             disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");

                    }

           

         }

        

		document.all.iframe2.src = "<%=request.getContextPath()%>/ddMoutageplan.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	    
	    preclick="click2";
	
	}




  	function onClick3(src,isNew){
  	    //alert("gggggggg");
  	    disableMenuItem("ddm_wf_history,"+'<%=nooptions%>');
		var mainId = dealMainId(isNew);
		if(mainId == null||mainId == "undefined"|| mainId == ""|| mainId == "null"){
           dealAlertMessage("请选择一条月计划");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
        }
		document.all.iframe3.src = "<%=request.getContextPath()%>/ddMoutageplan.do?method=initRiskanalyse&mainId=" + mainId;
	    preclick="click3";
	}

    function onClick4(){
       disableMenuItem('<%=nooptions%>');
       disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report"+",<%=nobuttons%>");
       document.all.iframe4.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=DdMoutageplan";
       preclick="click4";
    }


//-->
</script>

<jhop:labelgroup height="530" labelHead="月停电计划浏览,月停电计划详情,电网风险分析,我的待办事项"
	scroll="auto,auto,auto,auto">
</jhop:labelgroup>


<script>

	disableTab("<%=nolabids%>","1");

	
</script>