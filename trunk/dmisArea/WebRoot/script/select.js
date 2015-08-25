/**
 * 	popup下拉框 
 * 
 *  @author MaJian 2006-12-21
 */
 
 /*===============全局变量===============*/
 var obj_DataArray  = new Array();  //数组缓存--第一次加载后重复利用 
 var bodyHtmlStr	   = "";     //页面主体HTML代码
 /*===============临时变量===============*/
 var tempId 		   = "";	 
 var tempType		   = "";
 var tempParent		   = "";
 var tempOutObj	   	   = "";
 var tempHiddName 	   = "";
 var tempAttachObj     = "";
 var fontLength 	   = "";
 
 
 var SelectInputWin = window.createPopup();
 
 /**
  *	 ===============显示下拉框方法===============
  *	 id         --标识--
  *  type       --类型--
  *  parentId   --父ID--
  *  attachName --绑定到的元素的id或名称--
  *  outText    --输出到的文本框名称--
  *  hiddName   --输出到隐藏域值信息--
  *  initValue  --初始值--
  *  ==========================================
  */
  function displayListBox(id, type, parentId, outText, attachName, hiddName, initValue)
  {
	  if(parentId)
	  	parentId = document.getElementById(parentId).value;
  	  tempId			  = id;
  	  tempType			  = type;
  	  tempParent		  = parentId;
  	  if(!parentId)
  	  tempParent          = "temp";
  	  tempHiddName		  = hiddName;
	  var   attachObj     = document.getElementById(attachName);
	  var   outTextObj    = document.getElementById(outText);
	  tempOutObj		  = outTextObj;
	  tempAttachObj	      = attachObj;

	  var   selectData;

	 		bodyHtmlStr  +=  '<html>';
	  		bodyHtmlStr  +=  '	<head>';
			bodyHtmlStr  +=  '		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">';
			bodyHtmlStr  +=  '		<style>';
			bodyHtmlStr  +=  '			';
			bodyHtmlStr  +=  '			table {font-size: 15px;border-collapse:collapse;}';
			bodyHtmlStr  +=  '			body {margin-left: 0px;';
			bodyHtmlStr  +=  '			margin-top: 0px;';
			bodyHtmlStr  +=  '			margin-right: 0px;';
			bodyHtmlStr  +=  '			margin-bottom: 0px}';
			bodyHtmlStr  +=  '			td { border-collapse:collapse; wordBreak:keep-all;  }';
			bodyHtmlStr  +=  '			tr { }';
			bodyHtmlStr  +=  '		</style>';
			bodyHtmlStr  +=  '	</head>';
			bodyHtmlStr  +=  '	<body style="overflow-y:auto;overflow-x:hidden">';	
			bodyHtmlStr  +=  '		<div id='+id+' style="background-color:white">';

		if(obj_DataArray && obj_DataArray[type] && (obj_DataArray[parent] == obj_DataArray[type]))
		{
			selectData 	  = obj_DataArray[type];
			alert(selectData);
			callBackHunter(selectData);
		}
		else
		{
			getDwrData(type, parentId, initValue);
		}


		
  }
  
  /**
   *  利用Dwr技术从后端得到数据
   */
   function getDwrData(type, parentId, initValue)
   {
   		var ttype 		= type;
   		var tparentId 	= parentId;
   		
	   	var data = new Array();
	   	
		if(!initValue)
		{
			data = 
			{
				"type":ttype,
				"fatherId":tparentId
			};
			SystemDicHunter.hunter(data,callBackHunter);
		}
		else
		{
			if(initValue.indexOf("#"))
			{
				var initNAME  = initValue.split("#")[0];
				var initVALUE = initValue.split("#")[1];
				
				var nameArra   = initNAME.split(",");
				var valueArra  = initVALUE.split(",");
				for(var i=0; i<nameArra.length; i++)
				{
					var obj = new Object();
					obj.NAME = nameArra[i];
					obj.CODE = valueArra[i];
					data[i] = obj;
				}
			}
			callBackHunter(data);
		}
   }
   
   /**
    *  Dwr技术回调函数
	*/
	function callBackHunter(data)
	{	
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
			bodyHtmlStr  += '<table id="table1" bordercolor="#E4E4E4" border="1" width="'+widthT+'"  cellpadding="0" cellspacing="0">';
		
		for(var i=0;i<data.length;i++)
		{
			var bean = data[i];	
			
			bodyHtmlStr  += '			<tr>';
			bodyHtmlStr  += '				<td background="#ffffff" ';
			bodyHtmlStr  += ' 					onMouseOver="parent.mouseOver(this);" ';
			bodyHtmlStr  += ' 					onMouseOut="parent.mouseOut(this)" ';
			bodyHtmlStr  += '	 				width="100%" ';
			bodyHtmlStr  += '					onClick=parent.genText(this.innerText,this.value); ';
			bodyHtmlStr  += '  					value='+bean.CODE;
			bodyHtmlStr  += '					style="border-bottom-color:#E4E4E4;"';
			bodyHtmlStr  += '				>';
			bodyHtmlStr  += '					'+bean.NAME;
			bodyHtmlStr  += '				</td>';
			bodyHtmlStr  += '			</tr>';
		}
			bodyHtmlStr  +=  '</table>';
			
			bodyHtmlStr  +=  '		</div>';
			bodyHtmlStr  +=  '	</body>';
			bodyHtmlStr  +=  '</html>';

		/**
		 *  第一次创建popup窗口时调用
		 */
		if(!obj_DataArray[tempType] || !obj_DataArray[tempParent])
		{	
			SelectInputWin.document.body.style.border   = '0';
			SelectInputWin.document.writeln(bodyHtmlStr);
			SelectInputWin.document.close();	
			SelectInputWin.show(0, 0, 1, 1, tempAttachObj);
			var width  = SelectInputWin.document.body.scrollWidth;
			var height = SelectInputWin.document.body.scrollHeight;
			var getHeight;
			if(height > 110)
			{
				getHeight = "110";
			}
			else
			{
				getHeight = height+2;
			}
			SelectInputWin.hide();
			SelectInputWin.document.body.style.border="solid #949494 1px"; 
			SelectInputWin.show(0,(tempAttachObj.clientHeight+3), width, getHeight, tempAttachObj);
			bodyHtmlStr = "";		 
			
			obj_DataArray[tempType]   = data;
			obj_DataArray[tempParent] = data;
		}
		else
		{
			SelectInputWin.document.body.style.border   = '0';
			SelectInputWin.document.writeln(bodyHtmlStr);
			SelectInputWin.document.close();
				
			SelectInputWin.show(0, 0, 1, 1, tempAttachObj);
			var width  = SelectInputWin.document.body.scrollWidth;
			var height = SelectInputWin.document.body.scrollHeight;
			var getHeight;
			if(height > 110 )
			{
				getHeight = "110";
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
	}
	
   /**
    *  
	*/
   function mouseOver(td)
   {
		td.style.backgroundColor='#E4E4E4';
   }
   
   /**
    *  
	*/
   function mouseOut(td)
   {
   		td.style.backgroundColor='#ffffff';
   }
   
   /**
    *  
    */
    function genText(innerText,innerValue)
    {
    	tempOutObj.value = innerText;
    	tempOutObj.title = innerValue;
    	if(tempHiddName)
    	{
    		var hiddName = document.getElementById(tempHiddName);
    		hiddName.value = innerValue;
    	}
    	
    	SelectInputWin.document.close();
    	SelectInputWin.hide();
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