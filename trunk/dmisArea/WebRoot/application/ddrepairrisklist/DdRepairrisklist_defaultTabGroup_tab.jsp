<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_date.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/prototype.js"></script>


<script language="javascript">
<!--
    var  preclick="";  

   	function onClick1(){
   	    disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report,transition,save");
   	    disableMenuItem("wf_history");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddrepairrisklist/DdRepairrisklist_defaultList_grid.jsp";
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
        
        disableButton('copy,transition,report');
        disableMenuItem("wf_history");

        if(preclick=="click4"){

            var mygrid = parent.downFrame.iframe4.mygrid;

            var did =mygrid.getValueByName("id");

                  if(did != null && did != "undefined" && did != "null" && did != ""){

                             mainId = did;

                             disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");

                    }

           

         }
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddRepairrisklist.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	    preclick="click2";
	}
   

   
   
  	function onClick3(src,isNew,isCopy){
  	
  	    disableMenuItem("wf_history");
  	    disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report,transition");
  	    var primaryStr = parent.downFrame.iframe1.mygrid.getSelectedRowsData(3);	
		var primaryId   = "";
		if(primaryStr.indexOf("@@@") != -1){
		var dataArra 	= primaryStr.split("@@@");
			for(var x=0; x<dataArra.length; x++){
				if(dataArra[x].indexOf("^") != -1){
					var name = dataArra[x].split("^")[0];
					var value = dataArra[x].split("^")[1];
					if(name == "fid"){
						primaryId = value;
					}
				}
			}
		}		
		var mainId = primaryId;
		if(mainId == null|| mainId == "undefined"|| mainId == ""|| mainId == "null"){
           dealAlertMessage("请选择一条电网风险分析");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
        }
		document.all.iframe3.src = "<%=request.getContextPath()%>/application/ddrepairrisklist/grid.jsp?mainid=" + mainId;
	    preclick="click3";
	}
	
	function onClick4(){
	   enableMenuItem("wf_history");
	   disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report,save");
       document.all.iframe4.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ddrepairrisklist";
       preclick="click4";
    }
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="电网风险提示浏览,电网风险提示详情,预案,我的待办事项"
	scroll="auto,auto,auto,auto">
</jhop:labelgroup>
