<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
   	  	enableMenuItem('comfirmWorkbill','abateWorkbill');
   		disableButton("save,cancel");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhworkbill/zdhworkbill_defaultList_grid.jsp";
	} 
    
  	function onClick2(src,isNew,isCopy){
  	    //在详情页状态时，屏蔽归档、作废操作,数组元素是各操作的id，在action中可以找到
  	    //var arrDisable = new Array('comfirmWorkbill','abateWorkbill');  	    
  	    //parent.upFrame.disableItem(arrDisable);
  	    disableMenuItem('comfirmWorkbill','abateWorkbill');
   		disableButton("new,copy,find,transition");
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
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'workbillid');			 	 

			}
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhWorkbill.do?method=initDetail&mainId=" + primaryId + "&isCopy="+isCopy;
	}
	//我的代办事项
	function onClick3(){
	   disableMenuItem('comfirmWorkbill','abateWorkbill');
	   disableButton("new,copy,find");
	   document.all.iframe3.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ZdhWorkbill";
       
    }
	
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="工作票浏览,工作票详情,我的待办事项" scroll="auto,auto,auto"> </jhop:labelgroup>
