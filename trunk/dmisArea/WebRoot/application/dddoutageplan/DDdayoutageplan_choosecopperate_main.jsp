<%@ page language="java" pageEncoding="utf-8" buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
	<head>
		<title>gridtest</title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
	</head>

	<body>
		
			<jhop:ctrlgroup ctrlId="table0" title="配合主表" isEdit="yes">
			<img name='add' id="add"  alt="新建/修改"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/new.gif"
				onClick="showDetail()">
				<img name='save' style="display:none" id="saveimg" alt="保存"
					src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
					onClick="saveform()">
			<img name='goback' style="display:none" id="gobackimg" alt="回退"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/arrowright3_1.gif"
				onClick="back()">
			</jhop:ctrlgroup>
			<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
				<iframe name="iGridUp" frameborder='0' height="220" width='100%'
					scrolling="yes"
					src='<%=request.getContextPath()%>/application/dddoutageplan/copperate_grid.jsp'></iframe>
			</table>

			<jhop:ctrlgroup name="grid" ctrlId="table1" title="日计划" isEdit="yes">
				<img name='exit'    alt="退出日计划配合" id="exitimg"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/delete.gif"
				onClick="exitCooperate()">
			   <img name='showdispatch' alt="查询已下发日计划" id="showdisimg"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/search3.gif"
				onClick="showdipatchdayplain()"> 
				<img name='join'   alt="加入日计划配合"  style="display:none" id="joinimg"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="joinCooperate()">
				<img name='dispatchgoback' alt="回退"  style="display:none" id="disgobakimg"
				src="<%=request.getContextPath()%>/themes/themes1/images/main/arrowright3_1.gif"
				onClick="dispatchback()">
			</jhop:ctrlgroup>
			<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
				<iframe name="iGridDown" frameborder='0' height="220" width='100%'
					scrolling="yes"  ></iframe>
			</table>
	</body>
	<%--处理消息--%>

	<%
		 /*
		 if (message != null && !message.equals("") && !message.equals("null"))
		 {
	%>
	<script language="javascript">
			dealMessage('<%=message%>');
		</script>
	<%
		 }
		 */
	%>
	
	<script>
	    var cooname="";
	    var coodate="";
	    //改变子表信息与主表连动
        var addimg = document.getElementById("add");
        var saveimg = document.getElementById("saveimg");
        var gobackimg = document.getElementById("gobackimg");
        
         var showdisimg = document.getElementById("showdisimg");
         var joinimg = document.getElementById("joinimg");
         var exitimg = document.getElementById("exitimg");
         var disgobakimg = document.getElementById("disgobakimg"); 
         
        //连动方法
		function rowChangedToChild(priColVal,gridKind,data){

		    if(gridKind=="101")
		     return false;
			var rows =iGridUp.mygrid.getSelectedRows();
			
			if(rows){
    			var fcooperatename = iGridUp.mygrid.getValByRC(rows[0],'fcooperatename');
    			var cooperatedate = iGridUp.mygrid.getValByRC(rows[0],'cooperatedate'); 
    			//把所选的记录的 name 和 date 附给变量
    			cooname = fcooperatename;
    			coodate =cooperatedate;
    			iGridDown.location=encodeURI('<%=request.getContextPath()%>/application/dddoutageplan/copperate_dayplan_grid.jsp?name='+fcooperatename+'&date='+cooperatedate);
    		}
    		
    		 exitimg.style.display="block";
         	joinimg.style.display="none";
         	disgobakimg.style.display="none";
    		
		}
		
		//显示配合的主表详细信息

		function showDetail(){
			var hh = iGridUp.mygrid.selectedRows.length;
		    if(Number(hh)!=0){
		   	    var rows =iGridUp.mygrid.getSelectedRows();
		    	var fcooperatename = iGridUp.mygrid.getValByRC(rows[0],'fcooperatename');
    			var cooperatedate = iGridUp.mygrid.getValByRC(rows[0],'cooperatedate'); 
				iGridUp.location=encodeURI('<%=request.getContextPath()%>/ddDoutageplan.do?method=showCopperateDetail&name='+fcooperatename+'&date='+cooperatedate+'&dd='+new Date()+'&opp=update');
			}else{
				iGridUp.location='<%=request.getContextPath()%>/ddDoutageplan.do?method=showCopperateDetail&opp=add';
			}
			
			
			addimg.style.display="none";
			saveimg.style.display="block";
			goback.style.display="block";
		}
		//回退到主表页
		function back(){
			iGridUp.location='<%=request.getContextPath()%>/application/dddoutageplan/copperate_grid.jsp';
			
			addimg.style.display="block";
			saveimg.style.display="none";
			goback.style.display="none";
		}
		
		function saveform(){
			url ="<%=request.getContextPath()%>/ddDoutageplan.do?method=saveCopperate";
			var dn = iGridUp.document.getElementById('coppetatename');
			
			var dd = iGridUp.document.getElementById('eventdate');
			if(!isNotNull(dn.value)){
			  alert("配合名称不能为空");
			  return false;
			 }
			if(!isNotNull(dd.value)){
			  alert("配合日期不能为空");
			  return false;
			 }
			 if( !isDate(dd.value,'yyyy-MM-dd')){
			 	 alert("配合日期格式不对应该为　例：2004-09-09");
			  		return false;
			 }
			iGridUp.document.all.coppratedetailForm.action = url;
			iGridUp.document.all.coppratedetailForm.submit();
			
		}
		
	
	//子表显示已下发的日计划

	function showdipatchdayplain(){
		iGridDown.location='<%=request.getContextPath()%>/application/dddoutageplan/copperate_dispatchdayplain_grid.jsp';
		 
         exitimg.style.display="none";
         joinimg.style.display="block";
         disgobakimg.style.display="block";
	}
	//子表显示和主表关联的信息
	function dispatchback(){
		iGridDown.location='<%=request.getContextPath()%>/application/dddoutageplan/copperate_dayplan_grid.jsp?name='+cooname+'&date='+coodate+'&dd='+new Date();
         exitimg.style.display="block";
         joinimg.style.display="none";
         disgobakimg.style.display="none";
		
	}
	//日计划加入配合

	function joinCooperate(){
	    var rows = iGridDown.mygrid.getSelectedRows();
	    if(!rows){
	    	alert("请选择日计划");
	        return false;
	    }
	    
	    if(cooname==""||cooname.length<1||!cooname){
	    
	       alert("请选择要加人的配合");
	       return;
	    }
	    
		var rows = iGridDown.mygrid.getSelectedRows();
		var ids='';
		var j=0;
		for (row = 0;row<rows.length;row++){
			if(j!=rows.length-1)
	    		ids += iGridDown.mygrid.getValByRC(rows[row],'fdayplanno')+"###";
	    	else
	    		ids += iGridDown.mygrid.getValByRC(rows[row],'fdayplanno');
	    	j++;
		}
		
		iGridDown.document.all.dispatchform.action="<%=request.getContextPath()%>/ddDoutageplan.do?method=joinCopperate";
		(iGridDown.document.getElementById("name")).value=cooname;
		(iGridDown.document.getElementById("date")).value=coodate;
		(iGridDown.document.getElementById("ids")).value=ids;
		iGridDown.document.all.dispatchform.submit();

       }
       
       //日计划配合退出

       function exitCooperate(){
       	if(cooname==""||cooname.length<1||!cooname){
	    
	       alert("请选择要加人的配合");
	       return;
	    }
		var rows = iGridDown.mygrid.getSelectedRows();
		var ids='';
		var j=0;
		for (row = 0;row<rows.length;row++){
			if(j!=rows.length-1)
	    		ids += iGridDown.mygrid.getValByRC(rows[row],'fdayplanno')+"###";
	    	else
	    		ids += iGridDown.mygrid.getValByRC(rows[row],'fdayplanno');
	    	j++;
		}
		
		iGridDown.document.all.copperatedayplainform.action="<%=request.getContextPath()%>/ddDoutageplan.do?method=exitCooperate";
		(iGridDown.document.getElementById("name")).value=cooname;
		(iGridDown.document.getElementById("date")).value=coodate;
		(iGridDown.document.getElementById("ids")).value=ids;
		iGridDown.document.all.copperatedayplainform.submit();
       }
       
	
	</script>
</html>
