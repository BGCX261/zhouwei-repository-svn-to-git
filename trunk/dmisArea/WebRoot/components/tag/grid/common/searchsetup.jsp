<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="/common/init_js.jsp" %>
<%@ include file="/common/init_date.jsp" %>
<% 
						/*********************************************/
						//           通用查询模板-高级查询页               //
						//         @author MaJian 2006-12-20         //
						/*********************************************/
%>
<script>
	
   /**
	*  接收通用查询模板页参数
	*  接收方式:模态对话框传值
	*/
	var param = window.dialogArguments;
	
	var queryPath 		= param.queryPath;
	var colName   		= param.colName;
	var displayName 	= param.displayName;
	var displayFormat 	= param.displayFormat;
	var colType        	= param.colType;
	var listBox			= param.listBox;
	var listBoxSrc		= param.listBoxSrc;
	
	var user 	= param.userSign;
	var busName = param.busName;
	var subName = param.subName;
   /**
	*  把参数值含,格式的转为数组
	*/
	var colNameArra       = colName.split(",");
	var displayNameArra   = displayName.split(",");
	var displayFormatArra = displayFormat.split("#");
	//var editTypeArra      = editType.split(",");
	//var isQueryArra       = isQuery.split(",");
	//var sortTypeArra      = sortType.split(",");
	var colTypeArra       = colType.split(",");
	//var widthArra         = width.split(",");
	//var colAlignArra      = colAlign.split(",");
	var listBoxArra		  = listBox.split(",");
	var listBoxSrcArra	  = listBoxSrc.split(",");
	/**
	 * 获得DOM对象
	 */
	function createDom(){
		var signatures = new Array("Microsoft.XMLDOM","Msxm12.DOMDocument.5.0","Msxm12.DOMDocument.4.0","Msxm12.DOMDocument.3.0","Msxm12.DOMDocument");
		var xmldoc ;
		for(var i =0;i<signatures.length;i++){
			try{
				xmldoc = new ActiveXObject(signatures[i]);
				xmldoc.async = false;
				return xmldoc;
			}catch(e){
				//忽略错误，继续循环取下一格版本；
			}
		}
		if(xmldoc==null){
			alert("没有取到Dom对象");
		}  
	}
</script>

<html>
<head>
<title>高级查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SysUiGridFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script language="JavaScript">
   /**
	*  改变查询行显示状态
	*  例: 选择介于时会显示两组输入元素
	*/
	function changeSpan(obj,type,colNameS)
	{
		var value = obj.value;
		document.getElementById(colNameS+"_startInput").style.display="none";
		document.getElementById(colNameS+"_endInput").style.display="none";
		document.getElementById(colNameS+"_middleStr").style.display="none";
		document.getElementById(colNameS+"_startImage").style.display="none";
		document.getElementById(colNameS+"_endImage").style.display="none";
		document.getElementById(colNameS+"_startDate").style.display="none";
		document.getElementById(colNameS+"_endDate").style.display="none";
		
		if(type == "integer")
		{
			if(value == "2")
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_endInput").style.display="block";
				document.getElementById(colNameS+"_middleStr").style.display="block";
				document.getElementById(colNameS+"_startImage").style.display="block";
				document.getElementById(colNameS+"_endImage").style.display="block";
			}
			else 
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_startImage").style.display="block";
			}
		}
		else if(type == "float" || type == "double")
		{
			if(value == "2")
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_endInput").style.display="block";
				document.getElementById(colNameS+"_middleStr").style.display="block";
				document.getElementById(colNameS+"_startImage").style.display="block";
				document.getElementById(colNameS+"_endImage").style.display="block";
			}
			else 
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_startImage").style.display="block";
			}
		}
		else if(type == "string" || type == "blob")
		{
			document.getElementById(colNameS+"_startInput").style.display="block";
			document.getElementById(colNameS+"_startImage").style.display="block";
		}
		else if(type == "timestamp" || type == "date")
		{
			if(value == "2")
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_endInput").style.display="block";
				document.getElementById(colNameS+"_middleStr").style.display="block";
				document.getElementById(colNameS+"_startDate").style.display="block";
				document.getElementById(colNameS+"_endDate").style.display="block";
			}
			else 
			{
				document.getElementById(colNameS+"_startInput").style.display="block";
				document.getElementById(colNameS+"_startDate").style.display="block";
			}
		}
	}
   /**
	*  加载用户个性化设置信息
	*  利用UserData-load()方法加载
	*/
	function loadUserData(cName,colNameString)
	{		
			SysUiGridFacade.getAdvanceQueryXml(user,busName,subName,callBackHunter);
			function callBackHunter(data){
				var innerContent  = "";
				innerContent += "<table width='100%' cellpadding='0' cellspacing='0'>";
				innerContent += "	<tr>";
				innerContent += "		<th width='15%'>显示顺序</th>";
				innerContent += "		<th width='55%'>查询条件名称</th>";
				innerContent += "		<th width='15%'>是否默认</th>";
				innerContent += "		<th width='15%'>删除</th>";
				innerContent += "	</tr>";
			
				var xmlString = data;
				if(xmlString != null && xmlString != ""){
					var xdoc = createDom();	
					xdoc.loadXML(xmlString);
					if(xdoc != null){
						var rootElem 	= xdoc.getElementsByTagName("advancequery")[0];
						if(rootElem != null){
							var childElem	= rootElem.childNodes;
							if(childElem != null){
								var currName 	= "";	
								var currSeque 	= "";
								for(var i=0;i<childElem.length;i++)
								{	
									var child = childElem[i];
									var name  = child.getAttribute("name");
									var flag  = child.getAttribute("defaultflag");
										
									var checked = " ";
									if(cName == ""){
										if(flag == "y" || flag == "Y"){
											checked = " checked ";
											defaultName = name;
											currSeque   = i;
										} else if(currSeque == ""){
											if(currSeque != "0"){
												if(i == (childElem.length-1)){
													defaultName = name;
													checked = " checked ";
													currSeque = i;
												}
											}
										}
									} else {
										if(cName == name){
											currName  	= name;
											currSeque 	= i;
											checked = " checked ";
										}
									}
							
									innerContent += "<tr class=gridStyle-tr-data>";
									innerContent += "	<TD align='center'>"+(i+1)+"</TD>";
									innerContent += "	<TD>"+name+"</TD>";
									innerContent += "	<TD align='center'>";
									innerContent += "		<input type='radio' name='defaultName' value='"+name+"' "+checked+" onClick=loadUserData('"+name+"','"+colName+"')>";
									innerContent += "	</TD>";
									innerContent += "	<td align='center'>";
									innerContent += "		<img width='17' height='13' src='<%=request.getContextPath()%>/themes/themes1/images/main/lj.gif' onClick=deleteUserData('"+name+"','')>";
									innerContent += "	</td>";
									innerContent += "</tr>";
								}
								
								var column = xdoc.getElementsByTagName("condition")[currSeque].childNodes;
							
								var colNameArray = colNameString.split(",");
						
								for(var x=0;x<colNameArray.length;x++)
								{		
									var columnName  = column[x].getAttribute("name");
									var logicSelect = column[x].getAttribute("logicSelect");
									var startValue 	= column[x].getAttribute("startValue");
									var startImage 	= column[x].getAttribute("startImage");
									var startDate 	= column[x].getAttribute("startDate");
									var middleSign 	= column[x].getAttribute("middleSign");
									var endImage 	= column[x].getAttribute("endImage");
									var endDate 	= column[x].getAttribute("endDate");
									var endInput 	= column[x].getAttribute("endInput");
									var endValue 	= column[x].getAttribute("endValue");
									var sortLevel 	= column[x].getAttribute("sortLevel");
									var sortSelect 	= column[x].getAttribute("sortSelect");
									
									var select = document.getElementById(columnName+"_select");
									var start  = document.getElementById(columnName+"_start");
									var end    = document.getElementById(columnName+"_end");
									var order  = document.getElementById(columnName+"_order");
									var sort   = document.getElementById(columnName+"_sort");
									
									var sInput  = document.getElementById(columnName+"_startInput");
									var eInput    = document.getElementById(columnName+"_endInput");
									var sImage  = document.getElementById(columnName+"_startImage");
									var middleStr   = document.getElementById(columnName+"_middleStr");
									var eImage    = document.getElementById(columnName+"_endImage");
									var sDate   = document.getElementById(columnName+"_startDate");
									var eDate     = document.getElementById(columnName+"_endDate");
									
									//alert(columnName+":#:"+logicSelect+"#"+startValue+"#"+startImage+"#"+startDate+"#"+middleSign+"#"+endImage+"#"+endDate+"#"+endInput+"#"+endValue+"#"+sortLevel+"#"+sortSelect);
									
									if(logicSelect != null)
										select.value = logicSelect;
									if(startValue != null)
										start.value  = startValue;
									if(endValue != null)
										end.value    = endValue;
									if(sortLevel != null){
										if(sortLevel){
											order.value  = sortLevel;
										}else{
											order.value  = "not_sort";
										}
									}
									if(sortSelect != null){
										if(sortSelect){
											sort.value  = sortSelect;
										}else{
											sort.value  = "not_sort";
										}
									}
									if("startInput" != null)
										sInput.style.display = "block";
									if(endInput != null)
										eInput.style.display 	 = endInput;
									if(startImage != null)	
										sImage.style.display = startImage;
									if(middleSign != null)	
										middleStr.style.display  = middleSign;
									if(endImage != null)	
										eImage.style.display   	= endImage;
									if(startDate != null)
										sDate.style.display  	= startDate;
									if(endDate != null)
										eDate.style.display    	= endDate;	
								}
							}
						}
					}
				}
				innerContent += "</table>";
				dataList.innerHTML = innerContent;
			}
			if(cName != null && cName != ""){
				SysUiGridFacade.updateDefaultQuery(user,busName,subName,cName,defaultQuery);
				function defaultQuery(){
				
				}
			}
			
	}
	
	/**
	*  存储用户个性化设置
	*
	*  1. 利用userData-save()方法存储信息
	*  2. 生成查询字串，并按字串查询
	*/
	function operData(type,colNameStri)
	{
		var obj 		= document.all.docuData;
		var objList 	= document.all.docuList;
		var lineStr 	= "";
		var sequeStr    = "";
		var sequeArra   = new Array();
		var returnType 	= "enter";
		var colNameArra = colNameStri.split(",");
		var hiddenData  = document.getElementById("paramStr").value;
		
		var xmlAddStr   = "";
		for(var i=0;i<colNameArra.length;i++)
		{
			var select = document.getElementById(colNameArra[i]+"_select");
			var start  = document.getElementById(colNameArra[i]+"_start");
			var end    = document.getElementById(colNameArra[i]+"_end");
			var order  = document.getElementById(colNameArra[i]+"_order");
			var sort   = document.getElementById(colNameArra[i]+"_sort");
			
			var startInput  = document.getElementById(colNameArra[i]+"_startInput");
			var endInput    = document.getElementById(colNameArra[i]+"_endInput");
			var startImage  = document.getElementById(colNameArra[i]+"_startImage");
			var middleStr   = document.getElementById(colNameArra[i]+"_middleStr");
			var endImage    = document.getElementById(colNameArra[i]+"_endImage");
			var startDate   = document.getElementById(colNameArra[i]+"_startDate");
			var endDate     = document.getElementById(colNameArra[i]+"_endDate");
			
			if(start != null){
				var colTypeLower = colTypeArra[i].toLowerCase();
				if(start.value != ""){
					if(lineStr == ""){
						lineStr += colNameArra[i]+"^"+colTypeLower+"^"+select.value+"^"+start.value+"^"+end.value+"^"+sort.value;
					}else{
						lineStr += "@@@"+colNameArra[i]+"^"+colTypeLower+"^"+select.value+"^"+start.value+"^"+end.value+"^"+sort.value;
					}
					
					if(sort.value != "not_sort"){
						if(order.value != "not_sort"){
							sequeArra[order.value] = colNameArra[i]+" "+sort.value;
						}
					}
				}
				xmlAddStr 	+= "<column name='"+colNameArra[i]+"' logicSelect='"+select.value+"' startValue='"+start.value+"' startImage='"+startImage.style.display+"' startDate='"+startDate.style.display+"' middleSign='"+middleStr.style.display+"' endImage='"+endImage.style.display+"' endDate='"+endDate.style.display+"' endInput='"+endInput.style.display+"' endValue='"+end.value+"' sortLevel='"+order.value+"' sortSelect='"+sort.value+"'></column>";
				xmlAddStr	+= "\n";
			}
		}
		for(var y=0;y<sequeArra.length;y++){
			if(sequeArra[y] != null && sequeArra[y] != "" && sequeArra[y] != "undefined"){
				if(sequeStr == ""){
					sequeStr += sequeArra[y];
				} else {
					sequeStr += ","+sequeArra[y];
				}
			}
		}
		
		var queryFin = lineStr+"###"+sequeStr;
		var xmlStr	 = "";
			xmlStr	+= "<condition name='' value='"+queryFin+"' defaultflag=''>";
			xmlStr	+= xmlAddStr;
			xmlStr	+= "</condition>";
		
	   /**
		*  传递参数到通用查询模块页
		*/
		var paramObj = new Object();
			paramObj.title      = "search";
			paramObj.type		= returnType;
			paramObj.queryStr   = queryFin;
			paramObj.childStr	= xmlStr;
		window.returnValue  = paramObj;
		window.close();
	}
	
	/**
	 *  设置用户默认设置
	 */
	 function setDefaultValue(){
	 	var defaultName = document.getElementById("defaultName").value;
	 }
	 //window.attachEvent("onunload",setDefaultValue);
	
   /**
	*  删除用户个性化设置
	*  key:存储的用户字串
	*  sid:存储的用户userData名称
	*/
	function  deleteUserData(key,sid)
	{
	  	if(key != null && key != ""){
	  		var queryName = key;
	  		SysUiGridFacade.deleteAdvanceQueryData(user,busName,subName,queryName,deleteData);
	  		function deleteData(data){
	  			alert("数据删除成功");
	  			loadUserData("",colName);
	  		}
	  	}
	} 
	
	
</script>
</head>
<body bgcolor="#ffffff">

<div id="docuData" class=userData></div>
<div id="docuList" class=userData></div>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="20" bgcolor="#f3f3f3">&nbsp;</td>
    <td height="30" bgcolor="#f3f3f3"><b>请设置以下查询条件：</b></td>
    <td width="30" bgcolor="#f3f3f3"><!--<img src="<%=request.getContextPath()%>/themes/themes1/images/main/close.gif" width="16" height="16">--></td>
  </tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="15">
  <tr>
    <td>
      <table class="datasheet"  width="100%" align="center" cellpadding="0" cellspacing="0" >
        <tr>
          <td>
              <div id="dataList" name="dataList">
	            	请稍等......
             </div>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<form name="query" method="post">
	<input type="hidden" name="paramStr" value="">
</form>

<table width="100%" height="40" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  		<tr>
		    		<td width="20" bgcolor="#f3f3f3">&nbsp;</td>
		    		<td height="30" bgcolor="#f3f3f3"><b>请设定查询条件</b></td>
		    		<td width="30" bgcolor="#f3f3f3"><!--<img src="<%=request.getContextPath()%>/themes/themes1/images/main/close.gif" width="16" height="16">--></td>
		  		</tr>
			</table>
			<table width="100%" border="0" cellspacing="0" cellpadding="15">
		  		<tr>
		    		<td>
		    			<form name="222">
						<table class="datasheet"  width="100%" align="center" cellpadding="0" cellspacing="0" >
		        			<tr>
		          				<td>
		          					<div id="tableDiv" name="tableDiv">
										
						      		</div>
		      					<td>
		      				</tr>
		      			</table>
		      			</form>
					</td>
		  		</tr>
			</table>
 		</td>
  	</tr>
</table>

</body>
</html>

<script>

	/**
	*  当点击<执行并保存>按钮时=
	*  会隐藏<执行并保存>按钮  =
	*  显示<保存>按钮         =
	*/
	function echoData()
	{
		document.all.saveExecText.style.display 	= "block";
		document.all.saveExecButton.style.display 	= "none";
		document.all.saveButton.style.display 		= "block";
	}
	
   /**
	*  创建查询列表
	*  去除列号及操作列
	*/
	function createTable()
	{	
		var tableHTML  = '';
			tableHTML += '<table width="100%" cellpadding="0" cellspacing="0">';
			tableHTML += '	<tr>';
			tableHTML += '		<th width="112">字段名称</th>';
			tableHTML += '		<th width="163">逻辑符选择</th>';
			tableHTML += '		<th>条件值设定</th>';
			tableHTML += '		<th>排序列</th>';
			tableHTML += '		<th>排序方式</th>';
			tableHTML += '	</tr>';
			
			for(var i=0;i<colNameArra.length;i++)
		    {     
		        if((colNameArra[i] == "rowno") 
		        		|| colNameArra[i].indexOf("operater_") != -1 
		        				|| colNameArra[i].indexOf("opButton_") != -1){
					continue;
				}
				var onClickStart = "";
				var onClickEnd = "";
				
				if(listBoxArra[i] != null){
					if(listBoxArra[i] == 1){
						if(listBoxSrcArra[i] != null){
							if(listBoxSrcArra[i].indexOf("@@@") != -1){
								var listBoxArray = listBoxSrcArra[i].split("@@@");
								var typeId   = listBoxArray[0].split("type=")[1];
								var parentId = listBoxArray[1].split("parentId=")[1];
								if(parentId == null){
									parentId = "";
								}
								onClickStart = ' onClick=displaySysSelect("'+typeId+'","'+parentId+'","'+colNameArra[i]+'_start","'+colNameArra[i]+'_start","","","1"); ';
								onClickEnd   = ' onClick=displaySysSelect("'+typeId+'","'+parentId+'","'+colNameArra[i]+'_end","'+colNameArra[i]+'_end","","","1"); ';
							}
						}
					}
					else if(listBoxArra[i] == 2){
						if(listBoxSrcArra[i] != null){
							var src = listBoxSrcArra[i];
							onClickStart = ' onClick=displayBusSelect("'+colNameArra[i]+'_start","'+colNameArra[i]+'_start","","'+src+'","1"); ';
							onClickEnd   = ' onClick=displayBusSelect("'+colNameArra[i]+'_end","'+colNameArra[i]+'_end","","'+src+'","1"); ';
						}
					}
				}	
				
		        var tempColType = colTypeArra[i].toLowerCase();
					tableHTML += '	<tr>';
					tableHTML += '		<TD align="left" bgcolor="#FFFFFF" >'+displayNameArra[i]+'</TD>';
					tableHTML += '		<TD>';
					tableHTML += '			<SELECT id="'+colNameArra[i]+'_select" style="WIDTH: 160px" onchange=changeSpan(this,"'+tempColType+'","'+colNameArra[i]+'"); name="'+colNameArra[i]+'_select">';
					
				if(tempColType == "timestamp" || tempColType == "date"){
					tableHTML += '				<option value="3" selected>大于</option>';
					tableHTML += '				<option value="4">大于等于</option>';
					tableHTML += '				<option value="5">小于</option>';
					tableHTML += '				<option value="6">小于等于</option>';
					//tableHTML += '				<option value="9">不等于</option>';
					tableHTML += '				<option value="2">介于</option>';
					//tableHTML += '				<option value="0">包含字符串</option>';
				}else if(tempColType == "integer" || tempColType == "boolean"){
					tableHTML += '				<option value="1" selected>等于</option>';
					tableHTML += '				<option value="3">大于</option>';
					tableHTML += '				<option value="4">大于等于</option>';
					tableHTML += '				<option value="5">小于</option>';
					tableHTML += '				<option value="6">小于等于</option>';
					//tableHTML += '				<option value="9">不等于</option>';
					tableHTML += '				<option value="2">介于</option>';
					tableHTML += '				<option value="11">等于任一值</option>';
				}else if(tempColType == "float" || tempColType == "double"){
					tableHTML += '				<option value="1" selected>等于</option>';
					tableHTML += '				<option value="3">大于</option>';
					tableHTML += '				<option value="4">大于等于</option>';
					tableHTML += '				<option value="5">小于</option>';
					tableHTML += '				<option value="6">小于等于</option>';
					//tableHTML += '				<option value="9">不等于</option>';
					tableHTML += '				<option value="2">介于</option>';
					//tableHTML += '				<option value="11">等于任一值</option>';
				}else if(tempColType == "string" || tempColType == "blob"){
					tableHTML += '				<option value="1" selected>等于</option>';
					//tableHTML += '				<option value="0">包含字符串</option>';
				 	tableHTML += '				<option value="7">以字符串开头(字符串%)</option>'; 	
				 	tableHTML += '				<option value="8">以字符串结束(%字符串)</option>';
				 	tableHTML += '				<option value="9">包含字符串(%字符串%)</option>';
				 	tableHTML += '				<option value="11">等于任一值</option>';
				}
					
					tableHTML += '			</SELECT>';
					tableHTML += '		</TD>';
					tableHTML += '		<TD align="left">';
					tableHTML += '			<table border="0" borderColor="FFFFFF">';
					tableHTML += '				<tr>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_startInput" style="display:block">';
					tableHTML += '							<input name="'+colNameArra[i]+'_start" id="'+colNameArra[i]+'_start" style="WIDTH: 160px" ';
													if(tempColType == "timestamp")
					tableHTML += '						readonly >';
													else
					tableHTML += '							>';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_startImage" ';
													if(tempColType == "timestamp" || tempColType == "date")
					tableHTML += '							style="display:none" >';
													else
					tableHTML += '							style="display:block" >';										
					tableHTML += '							<img   class="hand" ';
					tableHTML += '								   border="0" ';
					tableHTML += '								   name="'+colNameArra[i]+'_sFind" ';
					tableHTML += '								   src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" ';
					tableHTML += '								   style="border-top:none; border-right:none" ';
					tableHTML += '								   '+onClickStart+' ';
					tableHTML += '							>';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_startDate" ';
													if(tempColType == "timestamp" || tempColType == "date")
					tableHTML += '							style="display:block" >';
													else
					tableHTML += '							style="display:none" >';										
					tableHTML += '							<img class="hand" border="0" id="'+colNameArra[i]+'_sDate" name="'+colNameArra[i]+'_sDate" src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" style="border-top:none; border-right:none" ';
					tableHTML += ' onClick="return showBeginCalendar(' +'\'';
					tableHTML +=  colNameArra[i]+'_start'+ '\','; 
					tableHTML += '\'';
					tableHTML += colNameArra[i]+'_end'+'\',';
					tableHTML += '\'yyyy-mm-dd hh:mm:ss\')" ';
					//tableHTML += '\''+displayFormatArra[i]+'\')" ';
					tableHTML += '>';	
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_middleStr" style="display:none">';
					tableHTML += '							至';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_endInput" style="display:none">';
					tableHTML += '							<input name="'+colNameArra[i]+'_end" id="'+colNameArra[i]+'_end" style="WIDTH: 160px" ';
													if(tempColType == "timestamp" || tempColType == "date")
					tableHTML += '						readonly >';
													else
					tableHTML += '							>';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_endImage" style="display:none" >';									
					tableHTML += '							<img  ';
					tableHTML += '								   border="0" ';
					tableHTML += '								   name="'+colNameArra[i]+'_eFind" ';
					tableHTML += '								   src="<%=request.getContextPath()%>/themes/themes1/images/main/find.gif" ';
					tableHTML += '								   style="border-top:none; border-right:none" ';
					tableHTML += '								   '+onClickEnd+' ';
					tableHTML += '							>';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '					<td style="border-top:none; border-right:none">';
					tableHTML += '						<span id="'+colNameArra[i]+'_endDate" style="display:none" >';										
					tableHTML += '							<img border="0" name="'+colNameArra[i]+'_eDate" src="<%=request.getContextPath()%>/themes/themes1/images/main/data.gif" style="border-top:none; border-right:none"';
					tableHTML += ' onClick="return showEndCalendar(' +'\'';
					tableHTML +=  colNameArra[i]+'_start'+ '\','; 
					tableHTML += '\'';
					tableHTML += colNameArra[i]+'_end'+'\',';
					tableHTML += '\'yyyy-mm-dd hh:mm:ss\')" ';
					//tableHTML += '\''+displayFormatArra[i]+'\')" ';
					tableHTML += '>';
					tableHTML += '						</span>';
					tableHTML += '					</td>';
					tableHTML += '				</tr>';
					tableHTML += '			</table>';
					tableHTML += '		</td>';
					tableHTML += '		<td>';
					tableHTML += '			<select name="'+colNameArra[i]+'_order">';
					tableHTML += '			<option value="not_sort">不排序</option>';
					for(var y=1;y<=colNameArra.length;y++){
					tableHTML += '			<option value="'+y+'">第'+y+'排序</option>';
					}					
					tableHTML += '			</select>';
					tableHTML += '		</td>';
					tableHTML += '		<td>';
					tableHTML += '			<SELECT id="'+colNameArra[i]+'_sort" name="'+colNameArra[i]+'_sort">';
					tableHTML += '				<option value="not_sort">不排序</option>';
					tableHTML += '				<option value="asc">升序</option>';
					tableHTML += '				<option value="desc">降序</option>';
					tableHTML += '			</SELECT>';
					tableHTML += '		</td>';
					tableHTML += '	</tr>';
			}	
			
					tableHTML += '</table>';
			
			
					tableHTML += '<table width="100%" height="40" border="0" cellpadding="0" cellspacing="0">';
					tableHTML += '	<tr>';
					tableHTML += '		<td style="border-right:none">&nbsp;</td>';
					tableHTML += '		<td width="60" style="border-right:none">';
					tableHTML += '			<div align="right">';
					tableHTML += '				<input name="Submit" type="button" class="inputbutton" value=" 执行查询"  onClick=operData("excute",colName)>';
					tableHTML += '			</div>';
					tableHTML += '		</td>';
					//tableHTML += '		<td width="40" style="border-right:none">&nbsp;</td>';
					tableHTML += '		<td id="saveExecText" width="90" style="border-right:none;display:none">';
					tableHTML += '			<div align="right">';
					tableHTML += '				<input name="saveName" type="text" size="10">';
					tableHTML += '			</div>';
					tableHTML += '		</td>';
					//tableHTML += '		<td id="saveExecButton" width="60" style="border-right:none">';
					//tableHTML += '			<div align="right">';
					//tableHTML += '				<input name="echoText" type="button" style="border-right:none;display:none" class="inputbutton" value=" 执行并保存"  onClick=echoData()>';
					//tableHTML += '			</div>';
					//tableHTML += '		</td>';
					tableHTML += '		<td id="saveButton" width="40" style="border-right:none;display:none">';
					tableHTML += '			<div align="right">';
					tableHTML += '				<input name="saveData" type="button" class="inputbutton" value=" 保存"  onClick=operData("save",colName)>';
					tableHTML += '			</div>';
					tableHTML += '		</td>';
					tableHTML += '		<td width="55" style="border-right:none">';
					tableHTML += '			<div align="right">';
					tableHTML += '				<input name="Submit2" type="reset" class="inputbutton" value=" 清空 " >';
					tableHTML += '			</div>';
					tableHTML += '		</td>';
					tableHTML += '		<td width="55" style="border-right:none">';
					tableHTML += '			<div align="right">';
					tableHTML += '				<input name="Submit2" type="button" class="inputbutton" value=" 取消 "  onClick="JavaScript:window.close()">';
					tableHTML += '			</div>';
					tableHTML += '		</td>';
					tableHTML += '	</tr>';
					tableHTML += '</table>';
    		
		var tableDiv = document.getElementById("tableDiv");
		tableDiv.innerHTML = tableHTML;	                								
	}
	createTable();
</script>
<script>
	loadUserData("",colName);
</script>


