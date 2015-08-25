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
   	    disableButton("copy");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddaccidentbrief/DdAccidentbrief_defaultList_grid.jsp";
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

        if(preclick=="click4"){

            var mygrid = parent.downFrame.iframe4.mygrid;

            var did =mygrid.getValueByName("id");

                  if(did != null && did != "undefined" && did != "null" && did != ""){

                             mainId = did;

                             disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");

                    }

           

         }
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddAccidentbrief.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	    preclick="click2";
	}
   

   	function onClick3(src,isNew,isCopy){
   	    var rows = parent.downFrame.iframe1.mygrid.getSelectedRows();
	    if(!rows){	           
	           dealAlertMessage("请选择一条故障简报信息");
	           var td1    = parent.downFrame.document.all.ID1;
			   selectTab(td1, '', 'true','false');
			   parent.downFrame.iframe1.createGrid('','0','','','','','','');
	           return false;
	    }
	    if(rows.length>1){    
	       dealAlertMessage("您只能选择一条故障简报信息!!!");
	       var td1    = parent.downFrame.document.all.ID1;
		   selectTab(td1, '', 'true','false');
		   parent.downFrame.iframe1.createGrid('','0','','','','','','');
		   return false; 
	    }
   	
   	
   	    var mainId = dealMainId(isNew);
		document.all.iframe3.src = "<%=request.getContextPath()%>/application/ddaccidentbrief/DdAccidentbrief_DDaccidentprocess.jsp?mainId=" + mainId;
	    preclick="click3";
	}
	
	function onClick4(){
	   disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");
       document.all.iframe4.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=accidentbrief";
       preclick="click4";
    }
   
   
  
//-->
</script>

<jhop:labelgroup height="530" labelHead="故障简报浏览,故障简报详情,故障处理过程,我的待办事项" scroll="auto,auto,auto,auto"> </jhop:labelgroup>
