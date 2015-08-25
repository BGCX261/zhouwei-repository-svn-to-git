<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--

   	function onClick1(){
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/ddensuringpsmanage/powerensurmanage_defaultList_grid.jsp";
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

		document.all.iframe2.src = "<%=request.getContextPath()%>/ddEnsuringpsmanage.do?method=initDetail&mainId=" + mainId + "&isCopy="+isCopy;
	}

  	function onClick3(){
		document.all.iframe3.src = "<%=request.getContextPath()%>/todolist.do?method=workflowTodolistGrid&objName=test";
	}	
	   
//-->
</script>

<jhop:labelgroup height="530" labelHead="政治保电管理浏览,政治保电管理详情,我的待办事项" scroll="auto,auto,auto"> </jhop:labelgroup>
