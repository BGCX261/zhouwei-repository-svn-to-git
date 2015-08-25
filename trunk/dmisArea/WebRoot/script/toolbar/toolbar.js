   /**
    * 得到列表选中行ID方法
	* 
	* @author caojian 2007-1-9
	* @return id 有则返回ID，无则返回""
	*/
   function getSelectRowId(){   
		var mygrid = parent.downFrame.iframe1.mygrid;
		if (mygrid == undefined){  		   
		   return "";
		}			
		
		var selectData 	= mygrid.getSelectedRowsData("2");
		if (selectData == ""){
			return "";
		}
		var selectDatas = selectData.split('^');
		var id = selectDatas[1];	
		return id;
   } 
 
 /**
    * 得到列表选中行记录方法
	* 
	* @author caojian 2007-1-9
	* @return row 有则返回"^"分割字符串，无则返回""
	*/
   function getSelectRow(){   
		var mygrid = parent.downFrame.iframe1.mygrid;
		if (mygrid == undefined){  		   
		   return "";
		}			
		
		var selectData 	= mygrid.getSelectedRowsData("2");
		if (selectData == ""){
			return "";
		}
		alert(selectData);
		return selectData;
   }
   
  /**
    * 转到某个tab页上，iframe src为action
	* 
	* @author caojian 2007-1-9
	*/  
   function toTab(index,action){
       eval("var td = parent.downFrame.document.all.ID" + index);
	   eval("parent.downFrame.selectTab(td,'" + action + "');");
   }
   //====================================已定义查询MENU相关===============================================//
   function getQueryListXML(data){
		var menuStr   = "<?xml version='1.0' encoding='utf-8'?>";
			menuStr  += "<Menu>";
		if(data != null && data != ""){
			var xdoc = createDom();	
			xdoc.loadXML(data);
			if(xdoc != null){
				var rootElem 	= xdoc.getElementsByTagName("advancequery")[0];
				if(rootElem != null){
					var childElem	= rootElem.childNodes;
					if(childElem != null){
						var currName 	= "";	
						var currSeque 	= "";
						for(var i=0;i<childElem.length;i++){	
							var child 	= childElem[i];
							var name  	= child.getAttribute("name");
							var wheres  = child.getAttribute("value");
							var flag  	= child.getAttribute("defaultflag");
							
							var checked = " ";
							if(flag == "y" || flag == "Y"){
								checked = " checked ";
							} else if(currSeque == ""){
								if(i == (childElem.length-1)){
									checked = " checked ";
								}
							}
							
							var paramStr   = wheres;
								paramStr   = paramStr.replace(/(\s)/g,"*");
								paramStr   = paramStr.replace(/(\-)/g,"~");
								paramStr   = paramStr.replace(/(\:)/g,"%");
								paramStr   = paramStr.replace(/\&/g,"!");

							menuStr += "<MenuItem ";
							menuStr += "Text='"+name+"' ";
							menuStr += "id='"+name+"' ";
							menuStr += "href='"+paramStr+"' ";
							menuStr += "title='"+name+"' ";
							menuStr += ">";
							menuStr += "</MenuItem>";
						}
					}
				}
			}
		} else {
			menuStr += "<MenuItem ";
			menuStr += "Text='没有已定义查询' ";
			menuStr += "id='' ";
			menuStr += "title='不存在已定义的查询' ";
			menuStr += ">";
			menuStr += "</MenuItem>"
		}
		menuStr  += "</Menu>";
		return menuStr;
   }
   //====================================选择操作MENU相关================================================//
   /**
	*  获得选择操作数据
	*  解析XML字串按格式要求生成新XML子串
	* 
	*  @author majian 2007-3-8
	*/
    function getSelectOperXml(xmlData){
    	var returnArra = new Array();
    	var xmlHead   = "<?xml version='1.0' encoding='utf-8'?>";
			xmlHead  += "<?xml-stylesheet type='text/xsl' href='menu.xsl'?>";
	    
	    if(xmlData != null && xmlData != "")
	    {
	    	
	    	xmlData = xmlData.replace(/Toolbar/g,"Menu");
	    	xmlData = xmlData.replace(/OperItem/g,"MenuItem");
	    	xmlData = xmlData.replace(/[\t]/g,"");
	    	
	    	if(xmlData.indexOf("<Business>") != -1)
	    	{
	    		var busStartIndex = parseInt(xmlData.indexOf("<Business>"));
	    		var busEndIndex   = parseInt(xmlData.indexOf("</Business>"));
	    		var urlStartIndex = parseInt(xmlData.indexOf("<ReportUrl>"));
	    		var urlEndIndex	  = parseInt(xmlData.indexOf("</ReportUrl>"));
	    		
	    		var busStr		  = xmlData.substring(busStartIndex+10,busEndIndex);
	    		returnArra[0]	  = busStr.split("</id>")[0].split("<id>")[1];
	    		returnArra[1]	  = busStr.split("</id>")[1].split("</name>")[0].split("<name>")[1];
	    		
	    		var urlStr        = xmlData.substring(urlStartIndex,urlEndIndex);
	    		returnArra[2]	  = reportUrl		  = urlStr.split("<ReportUrl>")[1];
	    		
	    		var menuEnd		  = xmlData.substring(urlEndIndex+12).split("</Menu>")[0];
	    		
				//menuEnd = findString(menuEnd);
				
				menuEnd = menuEnd.replace(/idr=/g,"id=");
	    		menuEnd = menuEnd.replace(/hrefr=/g,"href=");
	    		menuEnd = menuEnd.replace("</Toobar>","");
	    		menuEnd = menuEnd.replace("</Toolbar>","");

				
	    		xmlData		  	  = xmlHead+"<Menu>"+menuEnd+"</Menu>";
	    		returnArra[3]	  = xmlData;
	    	}
	    }
	    return returnArra;
    }
    /**
     * 查找指定字串[getSelectOperXml()使用]
     * 
     * @author majian 2007-3-8
     */
    function findString(str)
    {
    	if((str.indexOf(" id=") != -1) && (str.indexOf(" href=") != -1))
    	{
    		var href = str.substring(str.indexOf(" id=")+4,str.indexOf(" href="));
    		str = str.replace("id=","idr=");
    		str = str.replace("href=''","hrefr="+href);
    		str = findString(str);
    	}
    	return str;
    }
    //====================================下拉框MENU相关================================================//
   	/*
   	 * 获得DOM对象
   	 * @author majian 2007-3-8
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
	/**
	 * 创建下拉MENU对象
	 * @author majian 2007-3-8
	 */
	function  createChildItems(fatherNode,menu,type){  
		menu.setChangeVisible(changItem); 
	    //循环子节点
		for(var i=0;i<fatherNode.childNodes.length; i++){  
			var tmp1 = new Menu();
			var menuitem;
			var child = fatherNode.childNodes[i];
			if(child.hasChildNodes()){   //有子节点
				//alert(child.getAttribute("Text"));
				tmp1 = createChildItems(child,tmp1);
				if(type == "query"){
					menu.add(menuitem=new MenuItem(child.getAttribute("Text"),changeUrl,null,tmp1));
				}else if(type == ""){
					menu.add(menuitem=new MenuItem(child.getAttribute("Text"),changeScript,null,tmp1));
				}
			}
			else{	//没有子节点
				if(type == "query"){
					menu.add(menuitem = new MenuItem(child.getAttribute("Text"),changeUrl));
				}else if(type == "operate"){
					menu.add(menuitem = new MenuItem(child.getAttribute("Text"),changeScript));
				}
			}
			menuitem.toolTip  = child.getAttribute("title");
			menuitem.mnemonic = child.getAttribute("href");
			menuitem.pkey	  = child.getAttribute("id");
		}
		return menu;
	}
	/**
	 * 触发点击事件[已定义查询]
	 */
	function changeUrl(){
	    if(this.mnemonic!=null&&this.mnemonic!=''){
	    	var urlParam = this.mnemonic.replace(/\!/g,"&");
				urlParam = urlParam.replace(/(\*)/g," ");
				urlParam = urlParam.replace(/(\~)/g,"-");
				urlParam = urlParam.replace(/(\%)/g,":");
			var td1	  = parent.downFrame.document.all.ID1;
			if (td1.className == "ooihj"){
	    		parent.downFrame.iframe1.createGrid('','0','','','',urlParam,'','');
	    	}
	    }else{
	    	return false;
	    }
	}	
	/**
	 * 触发点击事件[选择操作]
	 * @author majian 2007-3-8
	 */
	function changeScript()
	{
	    if(this.mnemonic!=null&&this.mnemonic!='')
	    {
			eval(this.mnemonic)();
	    }
	    else
	    {
	    	return false;
	    }
	}
	//======================================//
	/**
	 * 屏蔽操作列表项内容
	 * @author majian 2007-3-8
	 */
	var  obj = new Array();
	var echoType = "disable";
	function disableItem(arra){
		 obj = arra;
		 echoType = "disable";
	}
	function enableItem(arra){
		obj = arra;
		echoType = "enable";
	}
	function changItem(text){   
		var flag =true;			
		var o = obj;
		for(var i=0;i<o.length;i++){
			if(echoType == "enable"){
				if(o[i] == text){
					flag = true;
					break;
				}else{
					flag = false;
				}
			}else if(echoType == "disable"){
				if(o[i] == text){
					flag = false;
					break;
				}
			}
		}
	   return flag;
	}	
	//=========================================================================================//
	/**
	 * 工具栏中上一条，下一条操作

	 * @author majian 2007-3-8
	 */
	function operToolbarRow(frame,action,sign){
		var mygrid = "";
		var docum  = "";
		if(frame == "iframe1"){
			mygrid = parent.downFrame.iframe1.mygrid;
			docum  = parent.downFrame.iframe1.document;
		} else if(frame == "iframe2"){
			mygrid = parent.downFrame.iframe2.mygrid;
			docum  = parent.downFrame.iframe2.document;
		} else if(frame == "iframe3"){
			mygrid = parent.downFrame.iframe3.mygrid;
			docum  = parent.downFrame.iframe3.document;
		} else if(frame == "iframe4"){
			mygrid = parent.downFrame.iframe4.mygrid;
			docum  = parent.downFrame.iframe4.document;
		} else if(frame == "iframe5"){
			mygrid = parent.downFrame.iframe5.mygrid;
			docum  = parent.downFrame.iframe5.document;
		} else if(frame == "iframe6"){
			mygrid = parent.downFrame.iframe6.mygrid;
			docum  = parent.downFrame.iframe6.document;
		} else if(frame == "iframe7"){
			mygrid = parent.downFrame.iframe7.mygrid;
			docum  = parent.downFrame.iframe7.document;
		} else if(frame == "iframe8"){
			mygrid = parent.downFrame.iframe8.mygrid;
			docum  = parent.downFrame.iframe8.document;
		} else if(frame == "iframe9"){
			mygrid = parent.downFrame.iframe9.mygrid;
			docum  = parent.downFrame.iframe9.document;
		} else if(frame == "iframe10"){
			mygrid = parent.downFrame.iframe10.mygrid;
			docum  = parent.downFrame.iframe10.document;
		}
		
		//判断列表对象是否存在
		if (mygrid == "undefined"){ 
			dealAlertMessage("列表对象不存在！");           
		    return true;
		}
		var currPage    	= docum.all.currPage.value;
		var totalCount  	= docum.all.totalCount.value;
		var pageSelect  	= docum.all.pageSelect.value;
		var pageDefault 	= docum.all.pageDefault.value;
		var wheres 			= docum.all.wheres.value;
		var filterStr 		= docum.all.filterStr.value;
		var domainName  	= docum.all.domainName.value;
		var otherparams 	= docum.all.otherparams.value;
		var selectColName  	= docum.all.selectColName.value;
		var page = "";
		if(pageSelect){
			page = pageSelect;
		} else {
			page = pageDefault;
		}

		var rowNum = "";
		var rows = mygrid.getSelectedRows();
		if(rows != null && rows != "undefined" && rows != "") {
			if(rows.length >= 1){
				rowNum = rows[0];
			}
		} else {
			dealAlertMessage("请在列表中选择记录！");  
		}
		if((parseInt(rowNum) > 0) && (parseInt(rowNum) < (parseInt(page)+1))){
			var beforePage  = document.all.beforePage.value;
			var selectId    = document.all.selectId.value;
			var currentPage = (parseInt(currPage)-1)*parseInt(page)+parseInt(rowNum);
			
			if(selectId != null 
					&& selectId != "undefined" 
							&& selectId != "null" 
									&& selectId != ""
											&& parseInt(selectId) == parseInt(rowNum)){
					if(beforePage){
						if(sign == "previous"){
							if(parseInt(beforePage) <= 1){
								currentPage = 1;
							} else {
								currentPage = parseInt(beforePage) - 1;
							}
						} else if(sign == "next"){
							if(parseInt(beforePage) >= parseInt(totalCount)){
								currentPage = totalCount;
							} else {
								currentPage = parseInt(beforePage) + 1;
							}
						}
						
					} 
			} else {
				if(currentPage){
					if(sign == "previous"){
						if(parseInt(currentPage) <= 1){
							currentPage = 1;
						} else {
							currentPage = parseInt(currentPage) - 1;
						}
					} else if(sign == "next"){
						if(parseInt(currentPage) >= parseInt(totalCount)){
							currentPage = totalCount;
						} else {
							currentPage = parseInt(currentPage) + 1;
						}
					}
				} 
			}
			document.all.selectId.value   = rowNum;
			document.all.beforePage.value = currentPage;
			
			//alert("beforePage:"+beforePage);
			//alert("currentPage:"+currentPage);
			if(beforePage == currentPage){
				if(sign == "previous"){
					dealAlertMessage("此条数据已经是第一条数据！");  
				} else if(sign == "next"){
					dealAlertMessage("此条数据已经是最后一条数据！");
				}
			} else {
				var pars        = "KEY_DOMAINNAME="+domainName;
					pars	   += "&KEY_COLNAMES="+selectColName;
					pars	   += "&KEY_OPARAMS="+otherparams;
					pars	   += "&KEY_PAGE="+currentPage+"^1";
					pars	   += "&KEY_QUERYTYPE=0";
				var url			= "/"+getContextPath()+"/"+action+".do?method=toolbarOperation";
				var myAjax = new Ajax.Request(url,{method: 'post', parameters: pars,  onComplete: function(originalRequest){ callBackGrid(originalRequest);} });
				function callBackGrid(originalRequest){
					if(originalRequest){
						var primaryId = originalRequest.responseText;
						var mainId = primaryId;
						var td2	   = parent.downFrame.document.all.ID2;
						selectTab(td2, '', 'false','true',mainId);
					}
				}
			}
		}
	}
	
    //===========================================================================================//
   /**
 * ������������������������������
 */
function getContextPath(){
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
   