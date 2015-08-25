<%@ page language="java" pageEncoding="utf-8"  buffer="18kb"%>
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

		<jhop:ctrlgroup ctrlId="table0" title="配合关系" isEdit="no">

			<img name='save'
				src="<%=request.getContextPath()%>/themes/themes1/images/main/save.gif"
				onClick="joinCooperate()">

		</jhop:ctrlgroup>
		<table class="detailmain" cellspacing="0" cellpadding="0" id="table0">
			<iframe name="iGridUp" frameborder='0' height="220" width='100%'
				scrolling="yes"
				src='<%=request.getContextPath()%>/application/dddoutageplan/joincopperate_grid.jsp'></iframe>
		</table>

		<jhop:ctrlgroup name="grid" ctrlId="table1" title="日计划" isEdit="no">
		</jhop:ctrlgroup>
		<table class="detailmain" cellspacing="0" cellpadding="0" id="table1">
			<iframe name="iGridDown" frameborder='0' height="220" width='100%'
				scrolling="yes"></iframe>
		</table>
		
	<table>
	<td>
		<div align="right">
			<input type="button" name="button" value="  确 认  "
				onClick="enterData('enter')">
			<input type="button" name="button" value="  取 消  "
				onClick="enterData('cannel')">
		</div>
	</td>
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

		function rowChangedToChild(priColVal,gridKind,data){
            
			var rows =iGridUp.mygrid.getSelectedRows();
			
			if(rows){
    			var fcooperatename = iGridUp.mygrid.getValByRC(rows[0],'fcooperatename');
    			var cooperatedate = iGridUp.mygrid.getValByRC(rows[0],'cooperatedate'); 
    			//把所选的记录的 name 和 date 附给变量
    			cooname = fcooperatename;
    			coodate =cooperatedate;
    			iGridDown.location=encodeURI('<%=request.getContextPath()%>/application/dddoutageplan/joincopperatedayplan_grid.jsp?name='+fcooperatename+'&date='+cooperatedate);
    		}
    		
		}


		function enterData(type){
			if(type != "cannel"){
			   if(cooname==""||cooname.length<1||!cooname){
		          alert("请选择要加人的配合");
		          return;
		        }
				 var  datas = cooname+"^"+coodate;
			     window.returnValue= datas;
			}
			window.close();
		}
	
	</script>
</html>
