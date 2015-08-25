<%@ page language="java" pageEncoding="utf-8"%>
<%@ page language="java" buffer="18kb"%>
<script>
    /** 
     * 使用activeX控件,将数据保存到Excel文件
     * @author sbt 2007-01-02
     */
</script>
<%
   //获取服务端查询的导出到excel数据
   /*String excelStr = (String)request.getAttribute("excelStr");   
   if (excelStr == null){
      excelStr = "";
   }
   */
   
%>
<script>
    //获取标准列表jsp模板中传递的参数	
	
	var param = window.dialogArguments;
	var selectColNames = "rowno^integer,selCheckBox^integer,cre_date^timestamp,id^string,custom_id^string,custom_name^string,sale_mode^string,tranpriority^string,total^integer,memo^string,check_begin_date^timestamp,check_end_date^timestamp,version^integer,opButton^string,rowStatus^integer";//列名及其数据类型,服务端按此顺序进行查询


	var wheres         = "";        //查询条件
	
    var otherparams    = "listType^3@@@listKind^101@@@isOperater^1@@@isTotalRow^1@@@cre_date^0,id^0,custom_id^0,custom_name^0,sale_mode^0,tranpriority^0,total^1,memo^0,check_begin_date^0,check_end_date^0,version^0";   //综合参数(列表的类型、是否统计、是否有操作列、各列是否统计...)
	var pageStr        = "1^10";       //分页信息
	var domainName     = "SaleBill";    //持久化类名


	var xls            = "日计划浏览^/×××.do?method=exportExcel^日计划浏览";           //Excel文件名称及导出时的请求路径、工作表名称
	var xlsname        = (xls.split("^"))[0]; //Excel文件名称
	var expExcelPath   = (xls.split("^"))[1]; //导出时的请求路径
	var sheetName      = (xls.split("^"))[2]; //工作表名称


	var colwidth       = "80,50,80,50,50,50,60,70,30,50,60";      //各列的宽度(不含特殊列)
    
    colCount = selectColNames.split(",");
    colwidthPer = colwidth.split(",");
</script>
<html>
<head>
<title>导出数据到Excel</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
   <script language="JavaScript" src="<%=request.getContextPath()%>/script/other/tab.js"></script>
   
   <script type="text/javascript">
      /**
       * 向服务器发出请求,获取导出到的Excel文件的数据
       */
       function getExcelData(){ 
          this.parseXML();
       }
      /*function getExcelData(){         
         if (document.all.expArea[0].checked){
            this.location.href = "<%=request.getContextPath()%>"+expExcelPath+"&queryType=2"+"&selectColNames="+selectColNames+"&pageStr="+pageStr+"&InitNum=1"+"&filterParams=&wheres=" + wheres +"&domainName="+domainName+"&otherparams="+otherparams;
         } else {
            this.location.href = "<%=request.getContextPath()%>"+expExcelPath+"&queryType=2"+"&selectColNames="+selectColNames+"&pageStr="+pageStr+"&InitNum=1"+"&filterParams=&wheres=&domainName="+domainName+"&otherparams="+otherparams;
         }
        
      }*/
      //cre_date^0,id^0,custom_id^0,custom_name^0,sale_mode^0,tranpriority^0,total^1,memo^0,check_begin_date^0,check_end_date^0,version^0
      /**
       * 关闭模态对话框
       */
      function cancelExp(){
         window.close();
      }
   </script>
</head>
<body>  
  <table class="noborder" cellspacing="0" cellpadding="0">
  <tr class="p1">
    <th colspan="3" class="pt" align="left" height="30">&nbsp;&nbsp;&nbsp;&nbsp;请选择导出的范围:</th>
  </tr>
  <tr>
  	<td></td>
  </tr>
  
  <tr>
    <td align="center">
		<table>
			<tr align="center">
				<td>
					<input type="radio" name="expArea" value="part" checked="checked"><font color="#000066">按查询条件导出</font>
	  				<input type="radio" name="expArea" value="all"><font color="#000066">导出全部数据</font>
				</td>
			</tr>
			<tr>
  				<td></td>
  			</tr>
			<tr align="center">
				<td>
					<input type="button" name="exp" value="导出" class="inputbutton" onclick="getExcelData()">
					<input type="button" name="cancel" value="取消" class="inputbutton" onclick="cancelExp()">	
				</td>
			</tr>
    	</table>
    </td>
  </tr>
   <tr>
  	<td></td>
  </tr>
  <tr class="p1">
    <th colspan="3" class="pt" align="left" height="30">&nbsp;&nbsp;&nbsp;&nbsp;</th>
  </tr>
</table>
</body>
<script type="text/javascript">   
   function parseXML(){
      var colIndex = 0;
      var xmlData = '<rows>	<row id="0">		<cell>0</cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="1">		<cell>1^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-17</cell>		<cell>1</cell>		<cell>1asdfasdf</cell>		<cell>eee</cell>		<cell>s</cell>		<cell>t</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>8</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="2">		<cell>2^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-17</cell>		<cell>3</cell>		<cell>1111www</cell>		<cell>ccc</cell>		<cell>sss</cell>		<cell>ttt</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>2</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="3">		<cell>3^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-03</cell>		<cell>2</cell>		<cell>cccc</cell>		<cell>aaaa</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-02-14</cell>		<cell>2007-03-12</cell>		<cell>1</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="4">		<cell>4^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-17</cell>		<cell>B60642ADFFFC44EFC4F9E6B31BA7E5</cell>		<cell>1111</cell>		<cell>2</cell>		<cell>sa</cell>		<cell>t</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-02-13</cell>		<cell>2007-03-12</cell>		<cell>1</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="5">		<cell>5^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-17</cell>		<cell>B9A4F694FFFC44EF127D4D97AAD34E7</cell>		<cell>qqq1sss</cell>		<cell>wwww</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-02-12</cell>		<cell>2007-03-12</cell>		<cell>4</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="6">		<cell>6^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-03</cell>		<cell>B9A5FF59FFFC44EF253BF87FEE0120</cell>		<cell>custom_id1111</cell>		<cell>custom_name</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>1</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="7">		<cell>7^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BBE12769FFFC44EF15E6B72E05C36F1</cell>		<cell>111</cell>		<cell>222</cell>		<cell>333</cell>		<cell>444</cell>		<cell>0</cell>		<cell>555</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="8">		<cell>8^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BE296B65FFFC44E8688AEB3BABF0FC</cell>		<cell>1233</cell>		<cell>翠花</cell>		<cell>220V</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-02-12</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="9">		<cell>9^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BA34F493FFFC44EF175BEEF5D844DB5</cell>		<cell>000</cell>		<cell>翠花</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="10">		<cell>10^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BEAC4B09FFFC44EF1FED8B463EC07C0</cell>		<cell>tt</cell>		<cell>tt</cell>		<cell>tt</cell>		<cell>tt</cell>		<cell>1</cell>		<cell>t</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="11">		<cell>11^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell></cell>		<cell>72FF00DBFFFC4400D2821B2BDA8254</cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell>0</cell>		<cell></cell>		<cell></cell>		<cell></cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="12">		<cell>12^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BE075B96FFFC44EF18EF33EEFB69C27</cell>		<cell>1</cell>		<cell>翠花</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="13">		<cell>13^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BE079B10FFFC44EFC22E8E8474FBA8</cell>		<cell>2</cell>		<cell>翠花</cell>		<cell>110</cell>		<cell>晶晶</cell>		<cell>0</cell>		<cell>备注</cell>		<cell>2007-03-17</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row>	<row id="14">		<cell>14^javascript:callLink();^_self</cell>		<cell>0</cell>		<cell>2007-03-05</cell>		<cell>BDD80FBCFFFC44EF5D8A8B1847AE43</cell>		<cell>id</cell>		<cell>name</cell>		<cell>10KV</cell>		<cell>五线</cell>		<cell>0</cell>		<cell>七线</cell>		<cell>2007-02-22</cell>		<cell>2007-03-12</cell>		<cell>0</cell>		<cell></cell>		<cell>1</cell>	</row></rows>';
      if (xmlData == "" || xmlData == null){
         return false;
      }
      var xmlDoc =new ActiveXObject("Microsoft.XMLDOM");
      xmlDoc.async = false;
      var xmlval = xmlDoc.loadXML(xmlData);
      //alert(xmlval);
      if (xmlDoc.parseError.length > 0) {          
          var myErr = xmlDoc.parseError;          
          alert("装载XML数据失败: " + myErr.reason);
      } else {                  
         var rowList = xmlDoc.getElementsByTagName("row");
         //alert(rowList.item(0).xml); 
         try {      
	         //使用ActiveX 控件创建Excel
	         var xls = new ActiveXObject("Excel.Application");
	         //设置excel为可见         
	         xls.Visible = true;    
	         // 
	         var newBook = xls.Workbooks.Add;
			 newBook.Worksheets.Add; 
			 newBook.Worksheets(1).Activate; 
			 //设置MCI控件中按钮的排列方向
			 xls.ActiveWorkBook.ActiveSheet.PageSetup.Orientation = 2; 			 
			 xls.ActiveWorkBook.ActiveSheet.PageSetup.PaperSize = 5; 
			 //根据列表中定义的列宽计算Excel文件中的列宽,目前最多支持39列
			 for (i=0;i<colCount.length;i++){
			    switch (i){
		            case 0:
		               //自动调整宽度，会使生成的xsl文件中的内容显示混乱,隐藏不使用自动调整宽度
		               //newBook.Worksheets(1).Columns("A").AutoFit(); 
		               //设置列宽
		               newBook.Worksheets(1).Columns("A").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               //允许折行
		               newBook.Worksheets(1).Columns("A").WrapText = true;
		               break;
		            case 1:
		               newBook.Worksheets(1).Columns("B").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("B").WrapText = true;
		               break;
		            case 2:		              
		               newBook.Worksheets(1).Columns("C").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("C").WrapText = true;
		               break;
		            case 3:   
		               newBook.Worksheets(1).Columns("D").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("D").WrapText = true;
		               break;
		            case 4:
		               newBook.Worksheets(1).Columns("E").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("E").WrapText = true;
		               break;
		            case 5:   
		               newBook.Worksheets(1).Columns("F").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("F").WrapText = true;
		               break;
		            case 6:
		               //newBook.Worksheets(1).Columns("G").AutoFit(); 
		               newBook.Worksheets(1).Columns("G").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("G").WrapText = true;
		               break;
		            case 7:   
		               newBook.Worksheets(1).Columns("H").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("H").WrapText = true;
		               break;
		            case 8:
		               newBook.Worksheets(1).Columns("I").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("I").WrapText = true;
		               break;
		            case 9:   
		               newBook.Worksheets(1).Columns("J").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("J").WrapText = true;
		               break;
		            case 10:
		               newBook.Worksheets(1).Columns("K").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("K").WrapText = true;
		               break;
		            case 11:   
		               newBook.Worksheets(1).Columns("L").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("L").WrapText = true;
		               break;
		            case 12:
		               newBook.Worksheets(1).Columns("M").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("M").WrapText = true;
		               break;
		            case 13:   
		               newBook.Worksheets(1).Columns("N").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("N").WrapText = true;
		               break;
		            case 14:
		               newBook.Worksheets(1).Columns("O").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("O").WrapText = true;
		               break;
		            case 15:   
		               newBook.Worksheets(1).Columns("P").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("P").WrapText = true;
		               break;
		            case 16:
		               newBook.Worksheets(1).Columns("Q").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("Q").WrapText = true;
		               break;
		            case 17:   
		               newBook.Worksheets(1).Columns("R").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("R").WrapText = true;
		               break;
		            case 18:
		               newBook.Worksheets(1).Columns("S").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("S").WrapText = true;
		               break;
		            case 19:   
		               newBook.Worksheets(1).Columns("T").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("T").WrapText = true;
		               break;
		            case 20:
		               newBook.Worksheets(1).Columns("U").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("U").WrapText = true;
		               break;
		            case 21:   
		               newBook.Worksheets(1).Columns("V").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("V").WrapText = true;	               
		               break;
		            case 22:
		               newBook.Worksheets(1).Columns("W").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("W").WrapText = true;	               
		               break;
		            case 23:
		               newBook.Worksheets(1).Columns("X").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("X").WrapText = true;	               
		               break;
		            case 24:
		               newBook.Worksheets(1).Columns("Y").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("Y").WrapText = true;
		               break;
		            case 25:   
		               newBook.Worksheets(1).Columns("Z").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("Z").WrapText = true;
		               break;
		            case 26:
		               newBook.Worksheets(1).Columns("AA").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AA").WrapText = true;
		               break;
		            case 27:
		               newBook.Worksheets(1).Columns("AB").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AB").WrapText = true;
		               break;
		            case 28:
		               newBook.Worksheets(1).Columns("AC").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AC").WrapText = true;
		               break;
		            case 29:   
		               newBook.Worksheets(1).Columns("AD").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AD").WrapText = true;
		               break;
		            case 30:
		               newBook.Worksheets(1).Columns("AE").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AE").WrapText = true;
		               break;
		            case 31:   
		               newBook.Worksheets(1).Columns("AF").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AF").WrapText = true;
		               break;
		            case 32:   
		               newBook.Worksheets(1).Columns("AG").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AG").WrapText = true;
		               break;
		            case 33:
		               newBook.Worksheets(1).Columns("AH").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AH").WrapText = true;
		               break;
		            case 34:   
		               newBook.Worksheets(1).Columns("AI").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AI").WrapText = true;
		               break;
		            case 35:
		               newBook.Worksheets(1).Columns("AJ").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AJ").WrapText = true;
		               break;
		            case 36:
		               newBook.Worksheets(1).Columns("AK").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AK").WrapText = true;
		               break;
		            case 37:
		               newBook.Worksheets(1).Columns("AL").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AL").WrapText = true;
		               break;
		            case 38:
		               newBook.Worksheets(1).Columns("AM").columnwidth = Math.round(Number(colwidthPer[i + 1])/4); 
		               newBook.Worksheets(1).Columns("AM").WrapText = true;
		               break;
		        }
			 }
			 //设置第一行、第一列的背景色为蓝色
		     //newBook.Worksheets(1).Cells(1,1).Interior.ColorIndex=5;	
	         //扫描各行的数据
	         //alert("rowList.length:"+rowList.length);
	         for (row=0;row<rowList.length;row++){
	            var rowPer = rowList[row];
	            var id = rowPer.getAttribute("id");
	            
	            //不导入过滤行
	            if (id == 0 ){
	               
	               continue;
	            }
	            if (id == 1 ){
	               //设置底色为蓝色
	               //newBook.Worksheets(1).Rows(1).Interior.ColorIndex = 5;
	               //设置标题行的字体
	               newBook.Worksheets(1).Rows(1).Font.Name="黑体";
	               //设置字体色
	               newBook.Worksheets(1).Rows(1).Font.ColorIndex=5;
	            }
	            //获取当前行中个子节点
	            var childNode = rowList.item(row).childNodes;
	            //扫描当前行中每列的值(从1开始，不包含行号列)	            
	            for (col=0;col<childNode.length;col++){
	               var colVal = childNode[col].text;
	               var colName = selectColNames.split(",")[col].split("^")[0];
	               if (colName == 'rowno' || colName == 'selCheckBox' || colName == 'opButton' || colName == 'rowStatus'){
	                  continue;
	               }	
	               //设置列标题的显示风格及内容               
	               if (id == 1){
	                  //居中
	                  newBook.Worksheets(1).Range( newBook.Worksheets(1).Cells(1,1),newBook.Worksheets(1).Cells(1,colIndex + 1)).HorizontalAlignment =-4108;
                      newBook.Worksheets(1).Range( newBook.Worksheets(1).Cells(1,1),newBook.Worksheets(1).Cells(1,colIndex + 1)).VerticalAlignment = -4108;
	                  //列标题
	                  newBook.Worksheets(1).Cells(1,colIndex + 1).value = '标题';
	               }
	               
	               newBook.Worksheets(1).Cells(row + 1,colIndex + 1).value = colVal;
	               colIndex ++;
	            }
	            colIndex = 0;
	            
	        }
	     
	        //设置工作表的名称
		    newBook.Worksheets(1).Name=sheetName; 
		    xls.UserControl = true;  //很重要,不能省略,不然会出问题 意思是excel交由用户控制
		    xls = null;
		    newBook = null;
	      } catch (e){
	        alert( "必须安装Excel电子表格软件，同时浏览器的安全属性中必须启用“ActiveX 控件”"+"\n"+e);
            return false;	
	      }
      }
      
     
   }
   
</script>
</html>