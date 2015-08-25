<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/init_tag.jsp" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>


<script language="javascript">
<!--


   	function onClick1(){
   		enableMenuItem('FExcelin');
		disableButton("cancel");
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhsequencetable/zdhsequencerec_defaultList_grid.jsp";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy,mainId){
	  	if(isCopy=="true"&&(mainId == null  || mainId == "undefined" || mainId == "" || mainId == "null"))
  	{
  		dealAlertMessage('请选择数据!');
  		var td2=parent.downFrame.document.all.ID1
		selectTab(td2,'','false','true');
		return false;
  	}
	if(mainId == null  || mainId == "undefined" || mainId == "" || mainId == "null"){

           mainId = dealMainId(isNew);

        }

        if(mainId == "undefined"){

           mainId = "";

        }
		disableMenuItem('FExcelin');
		disableButton("new,copy,find");
		var primaryId="";
	     var rows=parent.downFrame.iframe1.mygrid.getSelectedRows();
	     var colValue="";
	   
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
			 	 if(mainId==null||mainId==""||typeof(mainId)=="undefined")
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fsequenceno');	
			 	else
			 		primaryId	=mainId; 
			 			 	 

			}
		document.all.iframe2.src = "<%=request.getContextPath()%>/zdhSequencetable.do?method=initDetail&mainId=" + primaryId + "&isCopy="+isCopy;
	}
   
//-->
</script>

<jhop:labelgroup height="530" labelHead="序位表浏览,序位表详情" scroll="auto,auto"> </jhop:labelgroup>
