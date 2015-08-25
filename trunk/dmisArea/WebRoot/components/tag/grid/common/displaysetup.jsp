<%@ page contentType="text/html; charset=UTF-8" %>
<% 
						/*********************************************/
						//           通用查询模板-显示设置页               //
						//         @author MaJian 2006-12-15         //
						/*********************************************/
%>
<html>
<head>
<title>显示设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="Content-Language" content="zh-CN" />
<link href="<%=request.getContextPath()%>/themes/themes1/style.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SysUiGridFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<STYLE>
   .userData {behavior:url(#default#userdata);}
</STYLE>
<!--drag table-->
<style>
*{font-size:12px}
.dragTable{
 font-size:12px;
}
td{vertical-align:top;}
.dragTR{
 cursor:move;
}
#parentTable{
}
</style>


<!--end-->
<script>
	
	/**
	*  接收通用查询模板页参数

	*  接收方式:模态对话框传值

	*/
	var param = window.dialogArguments;
	
	var queryPath 		= param.queryPath;
	var colName   		= param.colName;
	var displayName 	= param.displayName;
	var visible			= param.visible;
	var width 			= param.width;
	var isPrimary		= param.isPrimary;
	
	var foldMode		= param.foldMode;
	var multipMode		= param.multipMode;
	var changeColor		= param.changeColor;
	var selectMode		= param.selectMode;
	var lockColumn		= param.lockColumn;
	var pageSelect		= param.pageSelect;
	
	var user 	= param.userSign;
	var busName = param.busName;
	var subName = param.subName;
	
	/**
	*  把参数值含,格式的转为数组

	*/
	var colNameArray       = colName.split(",");
	var displayNameArray   = displayName.split(",");
	var widthArray         = width.split(",");
	var visibleArray		= visible.split(",");
	var isPrimaryArray 	   = isPrimary.split(",");

</script>

<script language="JavaScript">
	/**
	*  设置列宽选项增大或减小
	
	*  点击上下箭头实现列宽增大减小
	*  @type:    up    增大
	*		     down  减小
	*  @cloName: 要改变列值的相关列名
	*/
	function changeValue(type,colName)
	{
		var colText = document.getElementById(colName+"_width");
		if(type == "up")
		{
			if(parseInt(colText.value-1)>=1)
				colText.value = parseInt(colText.value)-1;
		}
		else if(type == "down")
		{
			colText.value = parseInt(colText.value)+1;
		}
	}
	/**
	*  实现上下移动行的效果
	*  type:  up   上移
	*   	  down 下移
	*/
	function moveTR(type)
	{
		var currTable = event.srcElement.parentElement.parentElement.parentElement;
		var currTR  = event.srcElement.parentElement.parentElement;	
		
		if(type == "up")
		{
			var frontTR = currTR.previousSibling;
			if(frontTR.id != "title" && frontTR.id != "rowno")
				currTable.insertBefore(currTR,frontTR);
		}
		else if(type == "down")
		{
			var nextTR  = currTR.nextSibling;
			if(nextTR != null && nextTR.id.indexOf("operater_") == -1)
				currTable.insertBefore(currTR,nextTR.nextSibling);
		}
	}
	
   /**
	*  存储用户个性化数据
	*  利用客户端存储UserData实现
	*  利用UserData的save()方法
	*/
	function saveUserData()
	{
		var table = document.all.outerTable;
		
		var pageSelect 	= document.getElementById("pageSelect").value;
		var selectMode 	= document.getElementById("selectMode").value;
		var lockColumn 	= document.getElementById("lockColumn").value;  
		var multipMode 	= document.getElementById("multipMode").checked ?"1":"0";
		var foldMode 	= document.getElementById("foldMode").checked ?"1":"0";
		var changeColor = document.getElementById("changeColor").checked ?"true":"false";
		//alert(pageSelect+"#"+selectMode+"#"+lockColumn);
		//alert(multipMode+"#"+foldMode+"#"+changeColor);
		var colNameHidd = "";
		var widthHidd 	= "";
		var visibleHidd = "";
		for(var i=1;i<table.rows.length;i++){
			var colNameValue    = table.rows[i].cells[1].innerHTML;
			var widthValue  	= document.getElementById(colNameValue+"_width").value;
			var checkValue  	= document.getElementById(colNameValue+"_check").checked;
			if(checkValue == true){
				checkValue = "1";
			} else {
				checkValue = "0";
			}
			//alert(colNameValue+"###"+widthValue+"###"+checkValue);
			if(i == 1){
				colNameHidd += colNameValue;
				widthHidd	+= widthValue;
				visibleHidd += checkValue;
			} else {
				colNameHidd += ","+colNameValue;
				widthHidd	+= ","+widthValue;
				visibleHidd += ","+checkValue;
			}
		}
		var obj = new Object();
			obj.value = pageSelect;
		if(!isInteger(obj)){
			alert("请输入正确的页数");
			return false;
		} else if(obj.value == 0){
			alert("页数不能为零");
			return false;
		}
		
		var  	xmlStr  = "<grid>";
				xmlStr += "		<sequence>"+colNameHidd+"</sequence>";
				xmlStr += "		<visable>"+visibleHidd+"</visable>";
				xmlStr += "		<width>"+widthHidd+"</width>";
				xmlStr += "		<multipMode>"+multipMode+"</multipMode>";
				xmlStr += "		<foldMode>"+foldMode+"</foldMode>";
				xmlStr += "		<changeColor>"+changeColor+"</changeColor>";
				xmlStr += "		<selectMode>"+selectMode+"</selectMode>";
				xmlStr += "		<lockColumn>"+lockColumn+"</lockColumn>";
				xmlStr += "		<pageSelect>"+pageSelect+"</pageSelect>";
				xmlStr += "</grid>";
		/**
		*  存储用户个性化设置UserData
		*/
		
		SysUiGridFacade.updateCustomData(user,busName,subName,xmlStr,saveCustom);
		function saveCustom(data){
			/**
			*  回传参数到通用查询页
			*/
			var paramObj = new Object();
			
			paramObj.title    		= "display";
			paramObj.type			= "enter";
			
			window.returnValue = paramObj;
			window.close();
		}
	}
	
	/**
	*  加载用户个性化设置
	*  利用UserData的load()方法
	*/
	function loadUserData()
	{	
		var obj 	 = document.all.docuData;
		var divTable = document.all.divTable;	

		var colNameStr 			= colName;
		var displayNameStr 		= displayName;
		var widthStr 			= width;
		var visibleStr			= visible;
		var isPrimaryStr    	= isPrimary;
		
		/**
		*  生成表头
		*/
		var tableHTML = "";
		
			tableHTML += "<table id='parentTable'><tr><td>";
			tableHTML += "<table class='dragTable' id='outerTable' width='100%' cellpadding='0' cellspacing='0'>";
			tableHTML += "	<tr id='title' height='25'>";
			tableHTML += "		<th width='100'>是否显示</th>";
			tableHTML += "		<th width='100' style='display:none'>显示顺序</th>";
			tableHTML += "		<th>字段名称</th>";
			tableHTML += "		<th>列宽</th>";
			tableHTML += "		<th>调整顺序</th>";
			tableHTML += "	</tr>";
		
		/**
		*  加载用户个性化设置
		*/
		var displayNameArra 	= displayNameStr.split(",");
		var widthArra 			= widthStr.split(",");
		var colNameArra 		= colNameStr.split(",");
		var visibleArra			= visibleStr.split(",");
		var isPrimaryArra 		= isPrimaryStr.split(",");
		
		for(var i=0;i<colNameArra.length;i++)
		{
			var displayTR = "";
			var displayId = colNameArra[i];
			if((colNameArra[i] == "rowno") || colNameArra[i].indexOf("operater_") != -1)
			{
				displayTR = "style='display:none'";
			}
			
			var widthValue = widthArra[i];
			var checkStr = "";
			if(visibleArra[i] == "1" || visibleArra[i] == "y" || visibleArra[i] == "Y")
			{
				checkStr = " checked ";
			}
			var disabledStr = "";
			if(isPrimaryArra[i] == "1" ||isPrimaryArra[i] == "y" || isPrimaryArra[i] == "Y")
			{
				disabledStr = " disabled ";
			}
			
			/**
			*  生成表的内容
			*/
			tableHTML += "	<tr id='"+colNameArra[i]+"' "+displayTR+" onmouseover='mouseOver()' onmouseout='mouseOut()'>";
			tableHTML += "		<td align='center'>";
			tableHTML += "			<input type='checkbox' name='"+colNameArra[i]+"_check' "+checkStr+" "+disabledStr+" />";
			tableHTML += "		</td>";
			tableHTML += "		<td width='55' align='center' style='display:none'>"+colNameArra[i]+"</td>";
			tableHTML += "		<td width='200'>"+displayNameArra[i]+"</td>";
			tableHTML += "		<td width='107'>";
			tableHTML += "			<table id='innerTable_"+i+"' cellpadding='0' cellspacing='0'>";
			tableHTML += "				<tr id='innerTR_"+i+"'>";
			tableHTML += "					<td style='border-top:none; border-right:none' valign='middle'>";
			tableHTML += "						<input type='text' name='"+colNameArra[i]+"_width' value='"+widthValue+"' size='1' style='height:18; width:25'>";
			tableHTML += "					</td>";
			tableHTML += "					<td style='border-top:none; border-right:none; '>&nbsp;</td>";
			tableHTML += "					<td style='border-top:none; border-right:none;' valign='middle'>";
			//tableHTML += "						<img src='<%=request.getContextPath()%>/themes/themes1/images/main/top.gif' class='hand' alt='s' width='15' height='8' style='vertical-align:top;' onClick=changeValue('up','"+colNameArra[i]+"')><br>";
			//tableHTML += "						<img src='<%=request.getContextPath()%>/themes/themes1/images/main/bottom.gif' class='hand' alt='x' width='15' height='9' style='vertical-align:text-top;' onClick=changeValue('down','"+colNameArra[i]+"')>";
			tableHTML += "							<img src='<%=request.getContextPath()%>/themes/themes1/images/main/micdz.gif' class='hand' alt='x' width='15' height='18' usemap='#Map"+i+"' style='vertical-align:text-top;' >";
			tableHTML += "							<map name='Map"+i+"' id='Map"+i+"'>";
			tableHTML += "							<area shape='rect' coords='0,0,15,9' onClick=changeValue('up','"+colNameArra[i]+"') style='cursor:hand'/>";
			tableHTML += " 							<area shape='rect' coords='0,9,15,18' onClick=changeValue('down','"+colNameArra[i]+"') style='cursor:hand' />";
			tableHTML += "							</map>";
			tableHTML += "					</td>";
			tableHTML += "				</tr>";
			tableHTML += "			</table>";
			tableHTML += "		</td>";
			tableHTML += "		<td width='150' align='center'>";
			tableHTML += "			<a class='hand' onClick=moveTR('up')>上移</a>";
			tableHTML += "			<a class='hand' onClick=moveTR('down')>下移</a>";
			tableHTML += "		</td>";
			tableHTML += "	</tr>";
		}
			tableHTML += "</table>";
			tableHTML += "</td></tr></table>";
			divTable.innerHTML = tableHTML;
	}
	
	/**
	*  鼠标导航
	*/
	function mouseOver()
	{
		var tr = event.srcElement.parentElement;
		tr.bgColor = "#eeeeee";
	}
	function mouseOut()
	{
		var tr = event.srcElement.parentElement;
		tr.bgColor = "#ffffff";
	}
</script>
</head>
<body>
<div id="docuData" class=userData></div>
<br>
<table class="noborder" cellspacing="0" cellpadding="0">
  <tr class="p1">
    <th colspan="3" class="pt" align="left" height="30">&nbsp;&nbsp;&nbsp;&nbsp;请设置查询显示字段：</th>
  <tr>
    <td align="center">
    
    	<table width="100%" border="0" cellspacing="0" cellpadding="15" class="dragTable">
		  	<tr>
		    <td>
		      	<table class="datasheet"  width="100%" align="center" cellpadding="0" cellspacing="0" >
		        	<tr>
		          		<td>
		            		<div id="divTable">	
		            			
		            		
		            		</div>
      					</td>
      				</tr>
      			</table>
      		</td>
      		</tr>
      	</table>
     
      <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      	<tr>
        	<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;</td>
          	<td style="display:none">
          	   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;折行模式：<input type="checkbox" name="foldMode" id="RadioGroup" value="多选">
          	</td>
          	<td>
          	每页显示行数：
          	<!--select name="pageSelect">
              <option value="10" checked>10</option>
              <option value="15">15</option>
              <option value="20">20</option>
            </select-->
            <input type="text" name="pageSelect" value="15" size="3"/> 
          </td>
          	<td>
          		&nbsp;&nbsp;&nbsp;隔行显示：<input type="checkbox" name="changeColor" id="RadioGroup" value="隔行">
          	</td>
        </tr>
        <tr>
          
          <td style="display:none">
          		&nbsp;&nbsp;&nbsp;多选模式：<input type="checkbox" name="multipMode" id="RadioGroup" value="多选">
          	</td>
          <td style="display:none">
          	选择模式：

          	<select name="selectMode">
              <option value="shift" checked>Shift键</option>
              <option value="checkbox">checkbox框</option>
            </select>
          </td>
          <td style="display:none">
          	锁定列数：

          	<select name="lockColumn">
              <option value="无锁定" checked>无</option>
              <option value="15">15</option>
              <option value="20">20</option>
            </select>
          </td>
        </tr>
        
        <tr>
        	<td></td>
        </tr>
        <tr>
          	<td colspan="5" align="right">
          		<input name="" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/ok.gif" value="确认" onclick="saveUserData()">
            	&nbsp;&nbsp;&nbsp;&nbsp;
            	<input name="" type="image" src="<%=request.getContextPath()%>/themes/themes1/images/main/reset.gif" value="取消" onclick="JavaScript:window.close()">
          		&nbsp;&nbsp;&nbsp;&nbsp;
          	</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<script>
	/**
	*  为用户个性化设置选则值

	*/
	if(foldMode != null && foldMode != "" && foldMode == 1) {
		document.all.foldMode.checked = true;
	}
	if(multipMode != null && multipMode != "" && multipMode == 1) {
		document.all.multipMode.checked = true;
	}
	if(changeColor != null && changeColor != "" && (changeColor == 1 || changeColor == 'true')) {
		document.all.changeColor.checked = true;
	}
	if(selectMode != null && selectMode != "") {
		document.all.selectMode.value = selectMode;
	}
	if(lockColumn != null && lockColumn != "") {
		document.all.lockColumn.value = lockColumn;
	}
	if(pageSelect != null && pageSelect != "") {
		document.all.pageSelect.value = pageSelect;
	}
	
	/**
	 *
	 */
	function isInteger(obj)
	{		
	    if((obj.value==null)||(obj.value=="")) return true; //默认为0
		if(isNaN(obj.value) || (obj.value.indexOf('.') !=-1) || (obj.value.lastIndexOf('-') !=-1))
		{   		
			return false;
		}else{
			return true;
		}
	}//end function
	 
	
	/**
	*  初始化加载用户数据

	*  根据数据构造页面

	*/
	loadUserData();
</script>
<script defer>
 var Drag={  dragged:false,
			 ao:null,
  			 tdiv:null,
			 dragStart:function(){
							Drag.ao=event.srcElement;
	 						if((Drag.ao.tagName=="TD")||(Drag.ao.tagName=="TR")){
	 							if(Drag.ao.tagName=="TD"){
	 								Drag.ao=Drag.ao.parentElement;
	 							}
  								Drag.ao.style.zIndex=100;
 							}else{
								return;
							}
							Drag.dragged=true;
 							Drag.tdiv=document.createElement("div");
 							Drag.tdiv.innerHTML="<table>"+Drag.ao.innerHTML+"</table>";
 							//Drag.ao.style.border="5px dashed red";
 							Drag.ao.style.background="#CCCCCC";
 							Drag.tdiv.style.display="block";
 							Drag.tdiv.style.position="absolute";
 							Drag.tdiv.style.filter="alpha(opacity=70)";
 							Drag.tdiv.style.cursor="move";
 							Drag.tdiv.style.border="1px solid blue";
 							Drag.tdiv.style.width=Drag.ao.offsetWidth;
 							Drag.tdiv.style.height=Drag.ao.offsetHeight;
 							Drag.tdiv.style.top=Drag.getInfo(Drag.ao).top;
 							Drag.tdiv.style.left=Drag.getInfo(Drag.ao).left;
 							document.body.appendChild(Drag.tdiv);
 							Drag.lastX=event.clientX;
 							Drag.lastY=event.clientY;
 							Drag.lastLeft=Drag.tdiv.style.left;
 							Drag.lastTop=Drag.tdiv.style.top;
			},
 			draging:function(){//重要:判断MOUSE的位置

							if(!Drag.dragged||Drag.ao==null){
								return;
							}
	 						var tX=event.clientX;
	 						var tY=event.clientY;
	 						Drag.tdiv.style.left=parseInt(Drag.lastLeft)+tX-Drag.lastX;
	 						Drag.tdiv.style.top=parseInt(Drag.lastTop)+tY-Drag.lastY;
							for(var i=0;i<parentTable.cells.length;i++){
								var parentCell=Drag.getInfo(parentTable.cells[i]);
								
								if(tX>=parentCell.left
											&&tX<=parentCell.right
													&&tY>=parentCell.top
															&&tY<=parentCell.bottom){
									var subTables=parentTable.cells[i].getElementsByTagName("table");
									
									
									if(subTables.length==0){
										if(tX>=parentCell.left
												&&tX<=parentCell.right
														&&tY>=parentCell.top
																&&tY<=parentCell.bottom){
											parentTable.cells[i].appendChild(Drag.ao);
										}
										break;
									}
									
									for(var j=0;j<subTables.length;j++){
										var subTable=Drag.getInfo(subTables[j]);
										if(subTables[j].id == 'outerTable'){
											var subTr = subTables[j].rows;
											for(m=0; m<subTr.length; m++){
												if(subTr[m].id.indexOf("innerTR_") == -1 && subTr[m].id != "title"){
													var subTR = Drag.getInfo(subTr[m]);
													if(tX>=subTR.left
															&&tX<=subTR.right
																	&&tY>=subTR.top
																			&&tY<=subTR.bottom){
														subTables[j].tBodies[0].insertBefore(Drag.ao,subTr[m]);
														break;
													}else{
														if(tY<subTR.top){
															subTables[j].tBodies[0].insertBefore(Drag.ao,subTr[1]);
															break;		
														}else{
															subTables[j].tBodies[0].appendChild(Drag.ao);
														}
														
													}
												}
											}
										}

									}
								}
							 }
			},
 			dragEnd:function(){
 							 if(!Drag.dragged){return;}
							 Drag.dragged=false;
							 Drag.mm=Drag.repos(150,15);
							 Drag.ao.style.borderWidth="0px";
							 Drag.ao.style.background="#ffffff";
							 Drag.ao.style.borderTop="1px solid #3366cc";
							 Drag.tdiv.style.borderWidth="0px";
							 Drag.ao.style.zIndex=1;
			},
			getInfo:function(o){//取得坐标
 					 		 var to=new Object();
 							 to.left=to.right=to.top=to.bottom=0;
							 var twidth=o.offsetWidth;
							 var theight=o.offsetHeight;
							 while(o!=document.body){
								to.left+=o.offsetLeft;
								to.top+=o.offsetTop;
								o=o.offsetParent;
							 }
  							 to.right=to.left+twidth;
  							 to.bottom=to.top+theight;
 							 return to;
			},
			repos:function(aa,ab){
							 var f=Drag.tdiv.filters.alpha.opacity;
							 var tl=parseInt(Drag.getInfo(Drag.tdiv).left);
							 var tt=parseInt(Drag.getInfo(Drag.tdiv).top);
							 var kl=(tl-Drag.getInfo(Drag.ao).left)/ab;
							 var kt=(tt-Drag.getInfo(Drag.ao).top)/ab;
							 var kf=f/ab;
 							 return setInterval(
							 					function(){
															if(ab<1){
																clearInterval(Drag.mm);
																Drag.tdiv.removeNode(true);
																Drag.ao=null;
																return;
     														}
															ab--;
															tl-=kl;
															tt-=kt;
															f-=kf;
															Drag.tdiv.style.left=parseInt(tl)+"px";
															Drag.tdiv.style.top=parseInt(tt)+"px";
															Drag.tdiv.filters.alpha.opacity=f;
    						 					}
												,aa/ab)

			},
 			inint:function(){//初始化

	 						for(var i=0;i<parentTable.cells.length;i++){
  								var subTables=parentTable.cells[i].getElementsByTagName("table");
							  	for(var j=0;j<subTables.length;j++){
							   		if(subTables[j].className!="dragTable"){break;}
									for(var m=0;m<subTables[j].rows.length;m++){
										if(subTables[j].rows[m].id == 'title'){continue;}
										subTables[j].rows[m].className="dragTR";
							   			subTables[j].rows[m].attachEvent("onmousedown",Drag.dragStart);
									}
							  	}
 							}
 							document.onmousemove=Drag.draging;
 							document.onmouseup=Drag.dragEnd;
			}
			//end of Object Drag
	}
	Drag.inint();
	function _show(str){
 		var w=window.open('','');
 		var d=w.document;
 		d.open();
 		str=str.replace(/=(?!")(.*?)(?!")( |>)/g,"=\"$1\"$2");
 		str=str.replace(/(<)(.*?)(>)/g,"<span style='color:red;'>&lt;$2&gt;</span><br />");
 		str=str.replace(/\r/g,"<br />\n");
 		d.write(str);
	}
</script>
</body>
</html>