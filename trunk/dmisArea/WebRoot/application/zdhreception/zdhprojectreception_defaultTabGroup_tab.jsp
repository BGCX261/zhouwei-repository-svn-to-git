<%@ page contentType="text/html; charset=utf-8" language="java"%>

<%@ include file="/common/init_tag.jsp" %>
<%@ page import="com.techstar.dmis.common.ZdhConstants" %>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/script/tabs/tab.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/application/zdhreception/zdhreception.js"> </script>

<script language="javascript">
<!--
var  preclick="";

   	function onClick1(){
   		disableMenuItem('wf_history');
		disableButton("save,cancel")
		document.all.iframe1.src = "<%=request.getContextPath()%>/application/zdhreception/zdhprojectreception_defaultList_grid.jsp";
		preclick = "onClick1";
	}
   
   
  

   
   
  	function onClick2(src,isNew,isCopy,mainId){
		if(mainId == null  || mainId == "undefined" || mainId == "" || mainId == "null"){

           mainId = dealMainId(isNew);

        }

        if(mainId == "undefined"){

           mainId = "";

        }
		disableMenuItem('wf_history');
		disableButton("new,copy,find");
		  		/**
  		 * 读取代办事项列表主键值

  		 */
  		if(preclick=="onClick5"){
  			var mygrid 	= parent.downFrame.iframe5.mygrid;
            var did 	= mygrid.getValueByName("id");
            if(did != null && did != "undefined" && did != "null" && did != ""){
            	primaryId = did;
            }	
  		}
  		else
  		{
		var gridId=parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fexcutestatus    = "";
		var status="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_PIGEONHOLED%>";
		if(rows != null && rows != "undefined" && rows != "")
		 {
		
		       if(rows.length>1)//判断是否选择多行
			   {
			   
			   	   var isOk=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isOk)//判断是否同意默认第一行，是选择第一行，否退出


			       {
			       		var td2=parent.downFrame.document.all.ID1;
				      	selectTab(td2,'','false','true');
			       		return false;
				      	
				      	
			       }
			 	}
			 	if(mainId==null||mainId==""||typeof(mainId)=="undefined")
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fapplicationid');	
			 	else
			 		primaryId	=mainId; 
			 	 //primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fapplicationid');
			 	 fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fexcutestatus');
				 if(fexcutestatus==status){
					dealAlertMessage('归档后的记录不能修改!'); 
					var td1   = parent.downFrame.document.all.ID1;
					selectTab(td1, '', 'false','true');
					return false;
				}
				
			}
			}
			document.all.iframe2.src = "<%=request.getContextPath()%>/zdhReception.do?method=initDetail&mainId=" + primaryId + "&isCopy="+isCopy;
			  preclick="click2";
		}
		
		
		

   

   
   
  	function onClick3(src,isNew,isCopy){
		var mainId = dealMainId(isNew);
		disableMenuItem('wf_history');
		disableButton("new,copy,delete,find");
		var gridId=parent.downFrame.iframe1.mygrid;
		var rows 		= gridId.getSelectedRows();
		var primaryId = "";
		var version   = ""; 
		var fexcutestatus    = "";
		var status="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_PIGEONHOLED%>";//已归档
		preclick = "onClick3";		

		var status1="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_DATA_CHECKED%>";//资料验收完成
		var status2="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_APP%>";//申请投运
		var status3="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_YES%>";//批准投运
		var status4="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_RECPETION_NO%>";//投运驳回
		var status5="<%=ZdhConstants.ZdhReception_WORKFLOW_CITY_EXECUTED%>";//已执行


		if(rows != null && rows != "undefined" && rows != "")
		 {
		
		       if(rows.length>1)//判断是否选择多行
			   {
			   
			   	   var isOk=confirm('您选择多行值班数据是否默认第一行!');
			       if(!isOk)//判断是否同意默认第一行，是选择第一行，否退出


			       {
			       		var td2=parent.downFrame.document.all.ID1
				      	selectTab(td2,'','false','true');
				      	preclick = "onClick2";
			       		return false;
				      	
				      	
			       }
			 	}
			 	 primaryId = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fapplicationid');
			 	 fexcutestatus = parent.downFrame.iframe1.mygrid.getValByRC(rows[0],'fexcutestatus');
				 if(fexcutestatus==status){
					dealAlertMessage('归档后的记录不能修改!'); 
					var td1   = parent.downFrame.document.all.ID1;
					selectTab(td1, '', 'false','true');
					return false;
				}
				
				
			}

		if(fexcutestatus==status1||fexcutestatus==status2||fexcutestatus==status3||fexcutestatus==status4||fexcutestatus==status5)
		{
			document.all.iframe3.src = "<%=request.getContextPath()%>/zdhReception.do?method=initDetail1&mainId=" + mainId + "&isCopy="+isCopy;
		}
		else
		{
					dealAlertMessage('资料验收完成后才能进行投运申请!'); 
					var td1   = parent.downFrame.document.all.ID1;
					selectTab(td1, '', 'false','true');
					return false;
		}
	}
   

   	function onClick4(){
   	disableMenuItem('wf_history');
    disableButton("new,copy,delete,find,save");
    preclick = "onClick4";
		document.all.iframe4.src = "<%=request.getContextPath()%>/application/zdhreception/zdhprojectreception_eqplist_grid.jsp";
	}
   
       function onClick5(){
		enableMenuItem('wf_history');
       document.all.iframe5.src ="<%=request.getContextPath()%>/application/todolist/wfTodolistGrid.jsp?objName=ZdhReception";
		preclick = "onClick5";
    }
   
  
//-->
</script>

<jhop:labelgroup height="530" labelHead="基改建工程自动化设备验收,基改建工程自动化设备验收详情,新设备投运信息,投运设备清单,我的待办事项" scroll="auto,auto,auto,auto,auto"> </jhop:labelgroup>
