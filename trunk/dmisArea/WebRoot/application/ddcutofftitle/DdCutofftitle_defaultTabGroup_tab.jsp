<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp"%>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--

    var  preclick="";  
    
   	function onClick1(){
   	    disableButton('copy,transition,report,save,delete');
   	    disableMenuItem("wf_history");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddcutofftitle/DdCutofftitle_defaultList_grid.jsp";
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
        
        disableButton('copy,transition,report,delete');
        disableMenuItem("wf_history");

        if(preclick=="click3"){

            var mygrid = parent.downFrame.iframe3.mygrid;

            var did =mygrid.getValueByName("id");

                  if(did != null && did != "undefined" && did != "null" && did != ""){

                             mainId = did;

                             disableButton("find,new,copy,delete,cancel,lastRow,nextRow,report");

                    }

           

         }
		document.all.iframe2.src = "<%=request.getContextPath()%>/ddCutofftitle.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	    preclick="click2";
	}
	
	
    function onClick3(){
       disableButton('copy,transition,report,delete,save');
       enableMenuItem("wf_history");
       document.all.iframe3.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ddcutofftitle";
       preclick="click3";
    }

   	
   
   
  
//-->
</script>

<jhop:labelgroup height="530" labelHead="拉路序位信息浏览,拉路序位信息详情,我的待办事项"
	scroll="auto,auto,auto">
</jhop:labelgroup>
