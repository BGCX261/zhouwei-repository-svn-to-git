<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/common/init_js.jsp"%>
<%@ include file="/common/init_tag.jsp"%>
<%@ include file="/common/init_grid.jsp"%>
<%@ page language="java" buffer="18kb"%>
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
			queryPath="/ddMoutageplan.do?method=standGridQuery">
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
			    
			   
			   var dataStr = mygrid.getSelectedRowsData(1);
		       if(!dataStr)return false;
               var data =  dataStr.split("###");
               var ids  = "";
               for(var j=0;j<data.length;j++){
                       ids = ids+(data[j].split("\^"))[1]+"\^";
               }
		     window.returnValue 	= ids;
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
		      if (colVal=="已合并"){
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
	         //selectRow(grid);
	    }
            
      
</script>
</html>
