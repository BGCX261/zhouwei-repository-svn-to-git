<%@ page language="java" pageEncoding="utf-8"  buffer="18kb"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>

<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/script/public.js"></script>
<%
	/*********************************************/
	//             通用查询列表模板                    //
	//         @author MaJian 2006-12-20         //
	/*********************************************/
%>
<html>
	<head>
		<title></title>
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/style.css">
		<link rel="STYLESHEET" type="text/css"
			href="<%=request.getContextPath()%>/themes/themes1/default.css">
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/application/ddmoutageplan/DDMonthplan.js"> </script>
	</head>
	<body>



		<br>
		<div id='mygrid'></div>
		<br>
		<div id='standGridPage'></div>




		<jhop:grid id="mygrid" pageId="standGridPage"
			busName="DdMoutageplanDto" subName="128190324748579096"
			pageItems="10" listType="3" listKind="101" entityName="DdMoutageplan"
			isDisplaySet="0" isQuerySet="0" isPageSet="1" isOutputSet="0"
			queryPath="/ddMoutageplan.do?method=customGridQuery">
		</jhop:grid>

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
		<br>
	</body>
	<script>

 	  /**
		*  提交数据到父页面,快捷查询时使用



		*  返回数组类型
		*  格式: 英文列名#第一列值,第二列值,第三列值....
		*/
		function enterData(type){
			if(type != "cannel"){			
			    var  mselect = mygrid.getSelectedRows();
			    if(!mselect){		    
			        //dealAlertMessage("请您选择一条月计划");
			        alert("请您选择一条月计划");
			        return false;
			    }
			    if(mselect.length>1){
			       alert("您只能选择一条月计划目标");
			       return;
			    }
			   
			    var dataStr = mygrid.getSelectedRowsData(3);
		        //alert(dataStr);
		        var dataStatus = "";
		        var primaryId  = "";
		        if(dataStr.indexOf("@@@") != -1){
			              var dataArra 	= dataStr.split("@@@");
			              for(var x=0; x<dataArra.length; x++){
				                if(dataArra[x].indexOf("^") != -1){
					                var name  = dataArra[x].split("^")[0];
					                var value = dataArra[x].split("^")[1];
					                       if(name == "fstatus"){
						                       dataStatus = value;
					                       } else if(name == "fmonthplanno"){
						                       primaryId = value;
					                       }
				                 }
			              }
			     }
		     window.returnValue 	= primaryId;
		     window.close();
			}
			else window.close();
		}
		/**
		 *
		 */
		function selectRow(grid){
		   var colVal;
		   var colIndexid=0;
		   //获取列表中的记录行数
		   var rows = grid.getRowsNum();
		   if (rows <= 0){
		      return false;
		   }
		   for (row=0;row<rows;row++){	       
		       
		       if (row > 0) {
		          grid.cells(row,1).setValue(0);
		       }
		       
		      //获得指定行 指定列名的列值


		      colVal = grid.getValByRC(row,'ismerge');
		      if (colVal=="Y"){
		          for (rowi=0;rowi<rows;rowi++){
		                   grid.lockRow(rowi, true);
		          }
		       
		         grid.cells(row,1).setValue(1);
		      }
		   }
		}
		/**
		 * 列表内部调用该方法


		 */
	    function afterLoadForUser(grid){
	         selectRow(grid);
	    }
            
      
</script>
</html>
