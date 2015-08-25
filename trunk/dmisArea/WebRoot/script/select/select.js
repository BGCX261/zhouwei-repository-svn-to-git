/**
 * 	popup下拉框 
 * 
 *  @author MaJian 2006-12-21
 */
 /*===============全局变量===============*/
 var obj_DataArray  = new Array();  //数组缓存--第一次加载后重复利用 
 var bodyHtmlStr	   = "";        //页面主体HTML代码
 /*===============临时变量===============*/
 var tempId 		   = "";
 var tempSrc		   = "";
 var tempFunc		   = "";
 var tempSort		   = "";
 var tempType		   = "";
 var tempParent		   = "";
 var tempOutObj	   	   = "";
 var tempHiddName 	   = "";
 var tempCheckbox      = "";
 var tempAttachObj     = "";
 var tempClearObj      = "";
 var fontLength 	   = "";
 
 
 var SelectInputWin = window.createPopup();
 
 /**
  *	 ===============显示系统下拉框方法===============
  *  type       --类型--
  *  parentId   --父ID--
  *  attachName --绑定到的元素的id或名称--
  *  outText    --输出到的文本框名称--
  *  hiddName   --输出到隐藏域值信息--
  *  initValue  --初始值--
  *  ==========================================
  */
  function displaySysSelect(type, parentId, outText, attachName, hiddName, initValue,checkbox, func, clearObj)
  {
	  tempSort			= "SYS";
	  tempClearObj		= clearObj;
	  if(checkbox != "" && checkbox != null)
	  {
		tempCheckbox	= checkbox;
	  }
	  else
	  {
		 tempCheckbox	= 0;
	  }
	  if(parentId)
	  	parentId = document.getElementById(parentId).value;
  	  tempType			  = type;
  	  tempParent		  = parentId;
  	  if(!parentId)
  	  	tempParent        = "temp";
  	  tempHiddName		  = hiddName;
	  var   attachObj;
	  var   outTextObj
	  
	  if(typeof(attachName) == "string")
	  {
		  	attachObj     = document.getElementById(attachName);
	  }
	  else
	  {
		    attachObj		  = attachName;
	  }
	  
	  if(outText != "" && outText != null)
	  {
		  if(typeof(outText) == "string")
		  {
				outTextObj    = document.getElementById(outText);
		  }
		  else
		  {
				outTextObj	  = outText;
		  }
	  }
	  else
	  {
		  outTextObj = "";
	  }
	  if(typeof(func) == "function")
	  {
			tempFunc = func;
	  }
	  else if(func != "" && func != "undefine")
	  {
		  	tempFunc = eval(func);
	  }
	  tempOutObj		  = outTextObj;
	  tempAttachObj	      = attachObj;

	  var   selectData;
	  
	  bodyHtmlStr += getHtmlHead();

		if(obj_DataArray && obj_DataArray[tempType+"_"+tempParent])
		{
			selectData 	  = obj_DataArray[tempType+"_"+tempParent];
			callBackHunter(selectData);
		}
		else
		{
			getDwrSysData(type, parentId, initValue);
		}
  }
  
  /**
  *	 ===============显示业务下拉框方法===============
  *  attachName --绑定到的元素的id或名称--
  *  outText    --输出到的文本框名称--
  *  hiddName   --输出到隐藏域值信息--
  *  options    --初始值--
  *  checkbox   --是否支持多选--   1:支持  0:不支持




  *  ==========================================
  */
  function displayBusSelect(attachName, outText, hiddName, src, checkbox, func, clearObj)
  {
	  tempSort			= "BUS";
	  tempClearObj		= clearObj;
  	  tempHiddName		= hiddName;
	  if(checkbox != "" && checkbox != null)
	  {
			tempCheckbox	= checkbox;
	  }
	  else
	  {
			tempCheckbox	= 0;
	  }
	  var   attachObj;
	  var   outTextObj
	  
	  if(typeof(attachName) == "string")
	  {
		  	attachObj     = document.getElementById(attachName);
	  }
	  else
	  {
		    attachObj		  = attachName;
	  }
	  
	 if(outText != "" && outText != null)
	  {
		  if(typeof(outText) == "string")
		  {
				outTextObj    = document.getElementById(outText);
		  }
		  else
		  {
				outTextObj	  = outText;
		  }
	  }
	  else
	  {
		  outTextObj = "";
	  }
	  
	  if(typeof(func) == "function")
	  {
			tempFunc = func;
	  }
	  else if(func != "" && func != "undefine")
	  {
		  	tempFunc = eval(func);
	  }
	  
	  tempOutObj		  = outTextObj;
	  tempAttachObj	      = attachObj;
	  
	  	if(src != null && src != "")
	 	{
		  	if(src.indexOf("&") != -1)
		  	{
			  	var srcArra = src.split("&");
			  	if(srcArra[0] != null && srcArra[1] != "")
			  	{
					if(srcArra[0].indexOf("src=") != -1)
					{
						var srcParam = srcArra[0].split("src=")
						tempType = srcParam[1];
					}
					else
					{
						alert("参数src格式不合理!");
					}
			  	}
				else
				{
					alert("参数src格式不合理!");
				}
			}
			else
			{
				var srcArra = src.split("&");
				if(srcArra[0].indexOf("src=") != -1)
				{
					var srcParam = srcArra[0].split("src=")
					tempType = srcParam[1];
				}
				else
				{

					alert("参数src格式不合理!");
				}
			}
		}
		else
	 	{
			alert("参数src没有填写!");
		}

	  var   selectData;
		
	  bodyHtmlStr += getHtmlHead();
	 			

		//if(obj_DataArray && obj_DataArray[tempType])
		//{
		//	selectData 	  = obj_DataArray[tempType];
		//	callBackHunter(selectData);
		//}
		//else
		//{
			getDwrBusData(src);
		//}
  }
  
  /**
  *	 ===============显示Iframe下拉框方法===============
  *  attachName --绑定到的元素的id或名称--
  *  outText    --输出到的文本框名称--
  *  hiddName   --输出到隐藏域值信息--
  *  options    --初始值--
  *  checkbox   --是否支持多选--   1:支持  2.不支持




  *  ==========================================
  */
  function displayIframeSelect(attachName, outText, hiddName, src, checkbox)
  {	
	   tempSort			= "IFRAME";
	   tempHiddName		= hiddName;
	   if(checkbox != "" && checkbox != null)
	   {
			tempCheckbox	= checkbox;
	   }
	   else
	   {
			tempCheckbox	= 0;
	   }
	   if(outText != "" && outText != null)
	  {
		  if(typeof(outText) == "string")
		  {
				outTextObj    = document.getElementById(outText);
		  }
		  else
		  {
				outTextObj	  = outText;
		  }
	  }
	  else
	  {
		  outTextObj = "";
	  }
	   var   attachObj      = document.getElementById(attachName);
	   tempOutObj		  	= outTextObj;
	   tempAttachObj	    = attachObj;
	   tempSrc				= src;
	  
	   var   selectData;

	   bodyHtmlStr += getHtmlHead();
			
	   callBackHunter("");
   }
   
  /**
   *
   */
   function getHtmlHead()
   {
	   	var bodyHtmlHead = "";
			bodyHtmlHead  +=  '<html>';
	  		bodyHtmlHead  +=  '	<head>';
			bodyHtmlHead  +=  '		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">';
			bodyHtmlHead  +=  '		<link rel="STYLESHEET" type="text/css" href="/'+getContextPath()+'/themes/themes1/style.css">';
			bodyHtmlHead  +=  '		<style>';
			bodyHtmlHead  +=  '			';
			bodyHtmlHead  +=  '			table {font-size: 13px;border-collapse:collapse;}';
			bodyHtmlHead  +=  '			body {margin-left: 0px;';
			bodyHtmlHead  +=  '			margin-top: 0px;';
			bodyHtmlHead  +=  '			margin-right: 0px;';
			bodyHtmlHead  +=  '			margin-bottom: 0px}';
			bodyHtmlHead  +=  '			td { border-collapse:collapse; wordBreak:keep-all; noWrap:true  }';
			bodyHtmlHead  +=  '			tr { }';
			bodyHtmlHead  +=  '		</style>';
			bodyHtmlHead  +=  '	</head>';
			bodyHtmlHead  +=  '	<body style="overflow-y:auto;overflow-x:hidden">'; 
		return bodyHtmlHead;
   }
  
  /**
   *  利用Dwr技术从后端得到系统字典数据
   */
   function getDwrSysData(type, parentId, initValue)
   {
   		var ttype 		= type;
   		var tparentId 	= parentId;
   		
	   	var data = new Array();
	   	
		data = 
		{
			"type":ttype,
			"fatherId":tparentId
		};
		
		SystemDicHunter.hunter(data,callBackHunter);
   }
   
   /**
   *  利用Dwr技术从后端得到业务字典数据
   */
   function getDwrBusData(src)
   {
   		var rsrc = src;
 		
	   	var data = new Object();
		
		var srcArra = src.split("&");
		for(var x=0; x<srcArra.length; x++)
		{
			var paramArra = srcArra[x].split("=");
			data[paramArra[0]] = paramArra[1];
		}
	
		BusinessDicHunter.hunter(data,callBackHunter);
   }
   
   
   /**
    *  Dwr技术回调函数
	*/
	function callBackHunter(data)
	{	
		//清空级联下拉框子类条件
		if(tempClearObj != null && tempClearObj != "undefined" && tempClearObj != ""){
			if(tempClearObj.indexOf("#") != -1){
				var tArray = tempClearObj.split("#");
				for(var x=0; x<tArray.length; x++){
					if(tArray[x] != null && tArray[x] != "" && tArray[x] != "undefined"){
						var cObj = document.getElementById(tArray[x]);
						if(cObj != null && cObj != "undefined"){
							cObj.value = "";
						}
					}
				}
			} else {
				var cObj = document.getElementById(tempClearObj);
				if(cObj != null && cObj != "undefined"){
					cObj.value = "";
				}
			}
			
		}
		
		for(var i=0;i<data.length;i++)
		{
			var bean = data[i];	
			if(fontLength == "")
			{
				fontLength = bean.NAME.length;
			}
			else
			{
				if(bean.NAME.length > parseInt(fontLength))
				{
					fontLength = bean.NAME.length;
				}
			}	
		}
		var widthT = parseInt(fontLength) * 16 + 10;
		if(widthT <= 170)
		{
			widthT = 170;
		}
		if(tempCheckbox == 1)
		{
			widthT = widthT + 30;
		}
			bodyHtmlStr  += '<table id="popupTable" bordercolor="#E4E4E4" border="1" width="'+widthT+'"  cellpadding="0" cellspacing="0">';
			
		//  在第一行添加空行(解决提取数据慢问题)
			bodyHtmlStr  += '			<tr style="display:none" height="25" style="background: url(/'+getContextPath()+'/themes/themes1/images/main/th_bg.gif)">';
			bodyHtmlStr  += '				<td align="center" ></td>';
			bodyHtmlStr  += '				<td align="center"></td>';
			bodyHtmlStr  += '			</tr>';
			
		if(tempCheckbox == 1)
		{
			bodyHtmlStr  += '			<tr height="25" style="background: url(/'+getContextPath()+'/themes/themes1/images/main/th_bg.gif)">';
			bodyHtmlStr  += '				<td align="center" ><img src="/'+getContextPath()+'/themes/themes1/images/grid/sort_desc.gif" onClick=parent.wholeSelect('+data.length+',"select")  style="cursor:pointer" border="0" ></td>';
			bodyHtmlStr  += '				<td align="center"></td>';
			bodyHtmlStr  += '			</tr>';
		}
		var tempObjValue = "";
		if(tempOutObj != null && tempOutObj != "undefined"){
			tempObjValue = tempOutObj.value;
		}
		
		var tempObjArra  = new Array();
		if(tempObjValue != "" && tempObjValue != null)
		{
			if(tempObjValue.indexOf(",") != -1)
			{
				tempObjArra = tempObjValue.split(",");
			}
			else
			{
				tempObjArra[0] = tempObjValue;
			}
		}

		for(var i=0;i<data.length;i++)
		{
			var bean = data[i];	
			var checked = " ";

			if(tempObjArra != null && tempObjArra != "")
			{
				for(var x=0;x<tempObjArra.length;x++)
				{
					if(bean.NAME == tempObjArra[x])
					{
						checked = " checked ";
					}
				}
			}
			
			bodyHtmlStr  += '			<tr ';
			bodyHtmlStr  += '				onMouseOut="parent.mouseOut(this)" ';
			bodyHtmlStr  += '				onMouseOver="parent.mouseOver(this);" > ';
		if(tempCheckbox == 1)
		{
			bodyHtmlStr  += '				<td background="#ffffff">';
			bodyHtmlStr  += '					<input type="checkbox" id="check_'+i+'"  name="check_'+i+'" "'+checked+'" >';
			bodyHtmlStr  += '				</td>';
		}
			bodyHtmlStr  += '				<td id="td_'+i+'" ';
			bodyHtmlStr  += '					background="#ffffff" ';
			bodyHtmlStr  += '	 				width="100%" ';
			bodyHtmlStr  += '					onClick=parent.genText(this.innerText,this.value); ';
			bodyHtmlStr  += '  					value='+bean.CODE;
			bodyHtmlStr  += '					style="border-bottom-color:#E4E4E4;"';
			bodyHtmlStr  += '				>';
			bodyHtmlStr  += '					'+bean.NAME+'';
			bodyHtmlStr  += '				</td>';
			bodyHtmlStr  += '			</tr>';
		}
		
		if(data.length == 0 && tempSort != "IFRAME")
		{
			bodyHtmlStr  += '			<tr height="20" ';
			bodyHtmlStr  += '				onMouseOut="parent.mouseOut(this)" ';
			bodyHtmlStr  += '				onMouseOver="parent.mouseOver(this);" > ';
			bodyHtmlStr  += '				<td background="#ffffff" ';
			bodyHtmlStr  += '	 				width="100%" ';
			bodyHtmlStr  += '					onClick=parent.genText(this.innerText,this.value); ';
			bodyHtmlStr  += '  					value=';
			bodyHtmlStr  += '					style="border-bottom-color:#E4E4E4;"';
			bodyHtmlStr  += '				>';
			bodyHtmlStr  += '				</td>';
			bodyHtmlStr  += '			</tr>';
		}
		
		if(tempCheckbox == 1)
		{
			bodyHtmlStr  += '			<tr height="20" style="background: url(/'+getContextPath()+'/themes/themes1/images/main/th_bg.gif)">';
			bodyHtmlStr  += '				<td align="center" ><img src="/'+getContextPath()+'/themes/themes1/images/grid/sort_asc.gif" onClick=parent.wholeSelect('+data.length+',"cannel")  style="cursor:pointer" border="0" ></td>';
			bodyHtmlStr  += '				<td align="center">';
			bodyHtmlStr  += '					<input type=button class="inputbutton" name=submit value= " 确 定 " onClick="parent.returnData('+data.length+')">';
			bodyHtmlStr  += '				</td>';
			bodyHtmlStr  += '			</tr>';
		}	
			bodyHtmlStr  +=  '</table>';
		
		if(tempSort == "IFRAME")
		{
			bodyHtmlStr  += '	<iframe src="'+tempSrc+'" scrolling="no" width="300" height="300">';
		}
			
			bodyHtmlStr  +=  '	</body>';
			bodyHtmlStr  +=  '</html>';
		/**
		 *  第一次创建popup窗口时调用




		 */
		if(tempType != "" && tempType != null)
		{
			if(!obj_DataArray[tempType+"_"+tempParent])
			{	
				obj_DataArray[tempType+"_"+tempParent]   = data;
			}
		}
		
		SelectInputWin.document.body.style.border   = '0';
		SelectInputWin.document.writeln(bodyHtmlStr);
		SelectInputWin.document.close();
				
		SelectInputWin.show(0, 0, 1, 1, tempAttachObj);
		var width  = SelectInputWin.document.body.scrollWidth;
		var height = SelectInputWin.document.body.scrollHeight;
		var getHeight;
		if(height > 195 )
		{
			getHeight = "195";
		}
		else
		{
			getHeight = height+2;
		}
		SelectInputWin.hide();
		SelectInputWin.document.body.style.border="solid #949494 1px"; //#E4E4E4
		SelectInputWin.show(0,(tempAttachObj.clientHeight+3), width, getHeight, tempAttachObj);
		bodyHtmlStr = "";
	}
	
   /**
	*  多选模式整体选择操作函数
	*/
 	function wholeSelect(len,status)
	{
		 for(var i=0; i<len; i++)
		 {
			 if(status == "select")
			 {
			 	SelectInputWin.document.getElementById("check_"+i).checked 	= "checked";
			 }
			 else if(status == "cannel")
			 {
				 SelectInputWin.document.getElementById("check_"+i).checked = "";
			 }
		 }
	}
	
   /**
	*  回填多选模式返回字段




	*/
	function returnData(len)
	{
		var nameStr  = "";
		var valueStr = "";
		for(var i=0; i<len; i++)
		{
			var checkbox = SelectInputWin.document.getElementById("check_"+i).checked;
			var tdText   = SelectInputWin.document.getElementById("td_"+i).innerHTML.Trim();
			var tdValue  = SelectInputWin.document.getElementById("td_"+i).value;
			
			if(checkbox == true)
			{
				if(nameStr == "" && valueStr == "")
				{
					nameStr  += tdText;
					valueStr  += tdValue;
				}
				else
				{
					nameStr  += ","+tdText;
					valueStr += ","+tdValue;
				}
			}
		}

		tempOutObj.value 	= nameStr;
		tempOutObj.title 	= valueStr;
		if(tempHiddName)
		{
			var hiddName 	= document.getElementById(tempHiddName);
			hiddName.value 	= valueStr;
		}
			
		SelectInputWin.document.close();
		SelectInputWin.hide();
	}
	
   /**
	*  得到iframe内容
	*/
	function getIframeContent()
	{
		var div	   	= document.createElement("DIV");
		
		var iframe 	= document.createElement("IFRAME");
		iframe.id  	= "iframeId";
		iframe.style.display="block";
		iframe.src 	= "/"+getContextPath()+"/demo/index.jsp";
		//alert(iframe.src);
		div.appendChild(iframe);
		document.appendChild(div);
	}
	//getIframeContent();
	
   /**
    *  鼠标进入数据行变色




	*/
   function mouseOver(td)
   {
		td.style.backgroundColor='#E4E4E4';
   }
   
   /**
    *  鼠标离开数据行变色




	*/
   function mouseOut(td)
   {
   		td.style.backgroundColor='#ffffff';
   }
   
   /**
    *  普通下拉框赋值




    */
    function genText(innerText,innerValue)
    {
		
		if(tempCheckbox != 1)
		{
			if(tempOutObj)
			{
				tempOutObj.value 	= innerText.Trim();
				tempOutObj.title 	= innerValue.Trim();
			}
			if(tempHiddName)
			{
				var hiddName 	= document.getElementById(tempHiddName);
				hiddName.value 	= innerValue;
			}
			if(tempFunc)
			{
				tempFunc(innerText.Trim(),innerValue.Trim());
			}
			
			SelectInputWin.document.close();
			SelectInputWin.hide();
		}
    }
	
	function hideWindow()
	{
		if(SelectInputWin)
		{
			SelectInputWin.hide();
		}
	}
	
  /**
   *  去除String前后空格
   */
	function String.prototype.Trim() 
	{
		return this.replace(/(^\s*)|(\s*$)/g,"");
	}
  
  /**
   *  --服务器基础路径--
   */
  function getContextPath()
  {
   		var url = location.href;
   		if(url.indexOf('http://')<0)
	  		return "./";
   		url = url.substring(url.indexOf('http://') + 7);
   		if(url.indexOf('/') < 0)
   			return "";
   		url = url.substring(url.indexOf('/') + 1);
   		var pos;
   		if(url.indexOf('/') >= 0) 
			pos = url.indexOf('/');
   		else pos = url.length;
   			url = url.substring(0, pos);
   		return url;
  }