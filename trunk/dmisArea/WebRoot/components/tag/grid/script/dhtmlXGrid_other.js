/**======================================
*
 * 	构造列表相关函数 
 * 
 *  @author MaJian  2007-3-12
 *
 *=======================================*/
//===============================================================================================//
// 创建列表时Tag引用函数
//===============================================================================================//}
function createEchoGrid(gridId,imgUrl,titleSelectImg,titleUNSelectImg,
						contextPath,displayName,colAlign,editType,sortType,
						foldMode,selectMode,columnMove,skin,changeColor,
						width,filterStr,keySortOnlyCol,selectColNames,
						className,refName,filterMode,filterRules,listType,
						listKind,colName,isPrimary,isEdit,visible,entityName,
						isTotal,isTotalRow,isOperater,currPage,currentPage,
						colType,textColor,opColInfo,colValByList,listBox,listBoxSrc,
						displayFormat,totalValue,updatetable,refColVal,xmlData)
						{
	/*
	alert("gridId:"+gridId);
	alert("imgUrl:"+imgUrl);
	alert("titleSelectImg:"+titleSelectImg);
	alert("titleUNSelectImg:"+titleUNSelectImg);
	alert("contextPath:"+contextPath);
	alert("displayName:"+displayName);
	alert("colAlign:"+colAlign);
	alert("editType:"+editType);
	alert("sortType:"+sortType);
	alert("foldMode:"+foldMode);
	alert("selectMode:"+selectMode);
	alert("columnMove:"+columnMove);
	alert("skin:"+skin);
	alert("changeColor:"+changeColor);
	alert("width:"+width);
	alert("filterStr:"+filterStr);
	alert("keySortOnlyCol:"+keySortOnlyCol);
	alert("selectColNames:"+selectColNames);
	alert("className:"+className);
	alert("refName:"+refName);
	alert("filterMode:"+filterMode);
	alert("filterRules:"+filterRules);
	alert("listType:"+listType);
	alert("listKind:"+listKind);
	alert("colName:"+colName);
	alert("isPrimary:"+isPrimary);
	alert("isEdit:"+isEdit);
	alert("visible:"+visible);
	alert("entityName:"+entityName);
	alert("isTotal:"+isTotal);
	alert("isTotalRow:"+isTotalRow);
	alert("isOperater:"+isOperater);
	alert("currPage:"+currPage);
	alert("currentPage:"+currentPage);
	alert("colType:"+colType);
	alert("textColor:"+textColor);
	alert("opColInfo:"+opColInfo);
	alert("colValByList:"+colValByList);
	alert("xmlData:"+xmlData);
	*/
	/*
	alert("imgUrl:"+imgUrl);
	alert("filterMode:"+filterMode);
	alert("filterRules:"+filterRules);
	alert("titleSelectImg:"+titleSelectImg);
	alert("titleUNSelectImg:"+titleUNSelectImg);
	*/
	var id = gridId;
	gridId = new dhtmlXGridObject(gridId+"OfGrid");
	
	//原始属性
	gridId.setGridObjName(id);
	gridId.setImagePath(imgUrl);
	gridId.setHeader(displayName);
	gridId.setColAlign(colAlign);
	gridId.setColTypes(editType);
	gridId.setColSorting(sortType);
	//gridId.setColumnColor(textColor);
	gridId.enableMultiline(foldMode);
	gridId.setSelectMode(selectMode);
	gridId.enableColumnMove(true,columnMove);
	gridId.setFilterRowImg(imgUrl+"clearFilter.gif",imgUrl+"retract.gif",titleSelectImg,titleUNSelectImg);
	gridId.setSkin(skin);
	gridId.setOnAfterColumnMove(gridId.afterDragCol);
	gridId.enableEditEvents(true,false,true);
	gridId.setOnLoadingEnd(gridId.afterLoad);
	gridId.setSelectMode(changeColor);
	
	//扩展属性
	if(changeColor && changeColor != "false"){
		gridId.enableAlterCss("even","uneven");
	}

	gridId.setContextPath(contextPath);
	//gridId.setCellWidth(width);
	gridId.setInitWidths(width);
	gridId.setHistoryFilter(filterStr);
	gridId.setOnclickSort(keySortOnlyCol);
	gridId.setColNamesTypes(selectColNames);
	gridId.setColRefInfo(className,refName);
	gridId.setFilter(filterMode,filterRules);
	gridId.setUpdateTable(updatetable);
	gridId.setGridClass(Number(listType),Number(listKind));
	gridId.setColsName(colName,isPrimary,isEdit,visible);
	gridId.setEntityName(entityName);
	gridId.setTotalInfo(isTotal,isTotalRow,isOperater);
	gridId.setPagePer(currPage,currentPage);
	gridId.setHibDataType(colType);
	gridId.setListBox(listBox,listBoxSrc);
	gridId.setColDisplayFormat(displayFormat);
	gridId.setColTotalValue(totalValue);
	if(listKind != null && listKind != "undefined" && listKind != "null" && listKind != ""){
		if(listKind == "102" || listKind == "104" || listKind == "105"){
			if(typeof(editHandler) == 'function'){
				gridId.setColValByListInfo(colValByList);
				gridId.setOnEditCellHandler(editHandler);
			}
		}
	}
	gridId.setOpColInfo(opColInfo);
  	gridId.setRefColVal(refColVal);
	gridId.init();
	gridId.exAfterInit();
	if(xmlData != ""){
		gridId.loadXMLString(xmlData);
	}
	return gridId;
}
/**
 * 
 */
 function operDefineQuery(gridName,user,busName,subName){
 	var fun;
 	if(parent.upFrame){
 		fun = parent.upFrame;
 	} else if(parent.parent.upFrame){
 		fun = parent.parent.upFrame;
 	} else if(parent.parent.parent.upFrame){
 		fun = parent.parent.parent.upFrame;
 	} else if(parent.parent.parent.parent.upFrame){
 		fun = parent.parent.parent.parent.upFrame;
 	}
 	if(fun){
		var interval = setInterval(operToolbarQuery,500);
		function operToolbarQuery(){
			if(fun.defineQuery){
				fun.defineQuery(user,busName,subName);
				clearInterval(interval);
				fun.document.all.gridObj.value = gridName;
 				fun.document.all.pageObj.value = window;
			}
		}
 		return true;
 	}
 	return false;
 }

/**
 * 显示等待进度条

 */
function loadContent(id,path){
	document.getElementById(id+"OfGrid").innerHTML="<center><img src="+path+"loading-green.gif></center>";
}
//===============================================================================================//
//回调函数
//===============================================================================================//

function callBackGrid(originalRequest,gridId,pageId,queryPath,imgUrl,
					  pageItems,titleSelectImg,titleUNSelectImg,
					  pageImgPath,isPageSet,isCheckBox,isMultiline,
					  colValByList,titleRownoImg,skin,selectColNames,
					  filterMode,listType,entityName,isTotalRow,
					  isOperater,listKind,isOperater,isStatusCol,
					  opColInfo,busName,subName,isQuerySet,updateable,
						refColVal)
{	
	var gridName 		= '';
	
	var colName 		= '';
	var colType 		= '';
	var dataTypeLen 	= '';
	var isPrimary 		= '';
	var visible 		= '';
	var width 			= '';
	var isEdit 			= '';
	var textColor 		= '';
	var className 		= '';
	var refName   		= '';
	var displayName 	= '';
	var editType  		= '';
	var colAlign  		= '';
	var sortType  		= '';
	var textColor 		= '';
	var displayFormat 	= '';
	var listBox 	  	= '';
	var filterRules   	= '';
	var isTotal 		= '';
	var columnMove 		= '';
	var foldMode 		= '';
	var multipMode 		= '';
	var changeColor 	= '';
	var selectMode 		= '';
	var lockColumn 		= '';
	var pageSelect 		= '';
	var currPage 		= '';
	var totalCount 		= '';
	var colValByList  	= colValByList;
	var keyFilter  		= '';
	var keySortOnlyCol	= '';
	var totalValue    	= '';
	var attachFooter  	= '';
	var keyFilter  		= '';
	var wheres  		= '';
	var userSign 		= '';
	var opListBox       = '';
	var domainName      = '';
	var otherparams     = '';
	var selectColName   = '';
	
	var xmlStr  = originalRequest.responseText;
	var xmlArra = xmlStr.split('#####');
	var objName = xmlArra[0];
	var params  = xmlArra[1];
	var xmlData = xmlArra[2];
	var paramsArra = params.split('@@@@@');
	for(var x=0; x<paramsArra.length; x++){
		var name  = paramsArra[x].split('==')[0];
		var value = paramsArra[x].split('==')[1];
		if(name == 'colName'){
			colName = value;
		} else if(name == 'colType'){
			colType = value;
		} else if(name == 'dataTypeLen'){
			dataTypeLen = value;
		} else if(name == 'isPrimary'){
			isPrimary = value;
		} else if(name == 'visible'){
			visible = value;
		} else if(name == 'width'){
			width = value;
		} else if(name == 'isEdit'){
			isEdit = value;
		} else if(name == 'textColor'){
			textColor = value;
		} else if(name == 'className'){
			className = value;
		} else if(name == 'refName'){
			refName = value;
		} else if(name == 'displayName'){
			displayName = value;
		} else if(name == 'editType'){
			editType = value;
		} else if(name == 'colAlign'){
			colAlign = value;
		} else if(name == 'sortType'){
			sortType = value;
		} else if(name == 'textColor'){
			textColor = value;
		} else if(name == 'displayFormat'){
			displayFormat = value;
		} else if(name == 'filterRules'){
			filterRules = value;
		} else if(name == 'isTotal'){
			isTotal = value;
		} else if(name == 'columnMove'){
			columnMove = value;
		} else if(name == 'listBox'){
			listBox = value;
		} else if(name == 'foldMode'){
			foldMode = value;
		} else if(name == 'multipMode'){
			multipMode = value;
		} else if(name == 'changeColor'){
			changeColor = value;
		} else if(name == 'selectMode'){
			selectMode = value;
		} else if(name == 'lockColumn'){
			lockColumn = value;
		} else if(name == 'pageSelect'){
			pageSelect = value;
		} else if(name == 'currPage'){
			currPage   = value;
		} else if(name == 'totalCount'){
			totalCount = value;
		} else if(name == 'keyFilter'){
			keyFilter  = value;
		} else if(name == 'keySortOnlyCol'){
			keySortOnlyCol = value;
		} else if(name == 'totalValue'){
			totalValue  = value;
		} else if(name == 'attachFooter'){
			attachFooter = value;
		} else if(name == 'keyFilter'){
			keyFilter = value;
		} else if(name == 'wheres'){
			wheres = value;
		} else if(name == 'userSign'){
			userSign = value;
		} else if(name == 'opListBox'){
			opListBox = value;
		} else if(name == 'domainName'){
			domainName = value;
		} else if(name == 'otherparams'){
			otherparams = value;
		} else if(name == 'selectColName'){
			selectColName = value;
		}
	}

	//组合列表属性listBox,listBoxSrc
	var listBoxSrc = '';
	var listArra 	= listBox.split(',');
	for(var i=0;i<listArra.length;i++){
		var innerArra = listArra[i].split('^');
		if(i == 0){
			listBox 	= innerArra[0];
			listBoxSrc 	= innerArra[1];
		} else {
			listBox    += ','+innerArra[0];
			listBoxSrc += ','+innerArra[1];
		}
	}
	//组合宽度width
	var widthStr 		= '';
	widthArra 		= width.split(',');
	visibleArra 	= visible.split(',');
	for(var i=0;i<visibleArra.length;i++){
		if(visibleArra[i] == '0'){
			if(i == 0){
				widthStr 	= '0';
			} else {
				widthStr    += ',0';
			}
		}else{
			if(i == 0){
				widthStr 	= widthArra[i];
			} else {
				widthStr    += ','+widthArra[i]
			}
		}
	}
	width = widthStr;
	//组合属性foldMode
	if(!foldMode){
		if(isMultiline){
			foldMode = isMultiline;
		}else{
			foldMode = 0;
		}
	}
	
	//设置点击标题排序规则
	if(keySortOnlyCol){
		if(keySortOnlyCol.indexOf("^") != -1){
			var sortArra = keySortOnlyCol.split("^");
			if(sortArra.length == 2){
				if(sortArra[1] == "asc"){
					sortArra[1] = "desc";
				} else if(sortArra[1] == "desc"){
					sortArra[1] = "asc";
				}
				keySortOnlyCol = sortArra[0]+"^"+sortArra[1];
			}
		}
	}
	
	//设定隐藏域值
	fillHiddenfield(queryPath,pageItems,colName,displayName,
					width,visible,isPrimary,colType,displayFormat,
					listBox,listBoxSrc,foldMode,multipMode,changeColor,
					selectMode,lockColumn,pageSelect,currPage,keyFilter,
					totalCount,wheres,busName,subName,userSign,domainName,
					otherparams,selectColName);
	//设定分页代码块
	

	var currentPage;
	if(pageSelect){
		currentPage = pageSelect;
	} else {
		currentPage = pageItems;
	}
	if(isPageSet != null 
		&& isPageSet != "undefined" 
			&& isPageSet != "null" 
				&& isPageSet != "" 
					&& isPageSet != "0"){
		var pageH = new pageHelper(pageId,currPage,currentPage,totalCount,'7',pageImgPath);
		pageH.show();
	}

	//是否有多选列
		colName  	= 'selCheckBox,'+colName;
		colType  	= 'integer,'+colType;
		editType    = 'ch,'+editType;
		sortType 	= 'dyn,'+sortType;
	if(isCheckBox != null && isCheckBox != "undefined" && isCheckBox != "null" && isCheckBox != "" && isCheckBox != "0"){
		width		= '50,'+width;
		visible		= '1,'+visible;
	} else {
		width		= '0,'+width;
		visible		= '0,'+visible;
	}
		isEdit		= '0,'+isEdit;
		isPrimary	= '0,'+isPrimary;
		colAlign 	= 'center,'+colAlign;
		textColor 	= '#ffffff,'+textColor;
		displayName = titleSelectImg+','+displayName;
		columnMove  = 'false,'+columnMove;
		filterRules = '0,'+filterRules;
		//isTotal     = 'selCheckBox^0,'+isTotal;
		displayFormat = ','+displayFormat;
		listBox 	= ','+listBox;
		listBoxSrc 	= ','+listBoxSrc;
		colValByList= ',^'+colValByList;
		totalValue  = ','+totalValue;
		attachFooter= '#cspan,'+attachFooter;
		className   = ','+className;
		refName     = ','+refName;
	

	//行号列


	colName  	= 'rowno,'+colName;
	colType  	= 'integer,'+colType;
	editType    = 'link,'+editType;
	sortType 	= 'dyn,'+sortType;
	width		= '50,'+width;
	visible		= '1,'+visible;
	isEdit		= '0,'+isEdit;
	isPrimary	= '0,'+isPrimary;
	colAlign 	= 'center,'+colAlign;
	textColor 	= '#ffffff,'+textColor;
	displayName = titleRownoImg+','+displayName;
	columnMove  = 'false,'+columnMove;
	filterRules  = '0,'+filterRules;
	//isTotal     = 'rowno^0,'+isTotal;
	displayFormat = ','+displayFormat;
	listBox 	= ','+listBox;
	listBoxSrc 	= ','+listBoxSrc;
	colValByList= ',^'+colValByList;
	totalValue  = ','+totalValue;
	attachFooter= '合计,'+attachFooter;
	className   = ','+className;
	refName     = ','+refName;

	//是否有操作列
	if(isOperater != null && isOperater != "undefined" && isOperater != "null" && isOperater != "" && isOperater != "0"){
		colName  	= colName+',opButton';
		colType  	= colType+',string';
		editType    = editType+',ro';
		sortType 	= sortType+',na';
		width		= width+',50';
		visible		= visible+',1';
		isEdit		= isEdit+',0';
		isPrimary	= isPrimary+',0';
		colAlign 	= colAlign+',center';
		textColor 	= textColor+',#ffffff';
		displayName = displayName+',操作列';
		columnMove  = columnMove+',false';
		filterRules  = filterRules+',0';
		//isTotal     = isTotal+',opButton^0';
		displayFormat = displayFormat+',';
		var opListBoxs   = "";
		var opListBoxSrc = "";
		if(opListBox){
			//组合列表属性listBox,listBoxSrc
			var innerArra 	= opListBox.split('^');
			opListBoxs 		= innerArra[0];
			opListBoxSrc 	= innerArra[1];
		}
		listBox 	= listBox+','+opListBoxs;
		listBoxSrc 	= listBoxSrc+','+opListBoxSrc;
		colValByList= colValByList+'^,';
		totalValue  = totalValue+',';
		attachFooter= attachFooter+',';
		className   = className+',';
		refName     = refName+',';
	}

	//是否有状态列
	if(isStatusCol != null && isStatusCol != "undefined" && isStatusCol != "null" && isStatusCol != "" && isStatusCol != "0"){
		colName  	= colName+',rowStatus';
		colType  	= colType+',integer';
		editType    = editType+',ed';
		sortType 	= sortType+',int';
		width		= width+',50';
		visible		= visible+',1';
		isEdit		= isEdit+',1';
		isPrimary	= isPrimary+',0';
		colAlign 	= colAlign+',center';
		textColor 	= textColor+',#ffffff';
		displayName = displayName+',状态列';
		columnMove  = columnMove+',false';
		filterRules = filterRules+',0';
		//isTotal     = isTotal+',rowStatus^0';
		displayFormat = displayFormat+',';
		listBox 	= listBox+',';
		listBoxSrc 	= listBoxSrc+',';
		colValByList= colValByList+'^,';
		totalValue  = totalValue+',';
		attachFooter= attachFooter+',';
		className   = className+',';
		refName     = refName+',';
	}

	document.getElementById(gridId+'OfGrid').innerHTML='';

	//构造列表函数

	gridName = createEchoGrid(gridId,imgUrl,titleSelectImg,titleUNSelectImg,
				   queryPath,displayName,colAlign,editType,sortType,
				   foldMode,selectMode,columnMove,skin,changeColor,
				   width,keyFilter,keySortOnlyCol,selectColNames,
				   className,refName,filterMode,filterRules,listType,
				   listKind,colName,isPrimary,isEdit,visible,entityName,
				   isTotal,isTotalRow,isOperater,currPage,currentPage,
				   colType,textColor,opColInfo,colValByList,listBox,listBoxSrc,
				   displayFormat,totalValue,updateable,refColVal,xmlData);
	//回控工具栏中已定义查询MENU
	if(isQuerySet != null && isQuerySet != "undefined" && isQuerySet != "null" && isQuerySet != '0'){
		var signBit = operDefineQuery(gridName,userSign,busName,subName);
		if(!signBit){
			//var interval = setInterval("operDefineQuery(userSign,busName,subName)",2000);
		}
	}		
	return gridName;
}

/**
 * 设定隐藏域函数


 */
function fillHiddenfield(queryPath,pageItems,colName,displayName,
						 width,visible,isPrimary,colType,displayFormat,
						 listBox,listBoxSrc,foldMode,multipMode,changeColor,
						 selectMode,lockColumn,pageSelect,currPage,keyFilter,
						 totalCount,wheres,busName,subName,userSign,domainName,
						 otherparams,selectColName)
{
	document.all.colName.value		= colName;
	document.all.displayName.value	= displayName;
	document.all.width.value		= width;
	document.all.queryPath.value	= queryPath;
	document.all.visible.value		= visible;
	document.all.isPrimary.value	= isPrimary;
	document.all.colType.value		= colType;
	document.all.displayFormat.value= displayFormat;
	document.all.listBox.value		= listBox;
	document.all.listBoxSrc.value	= listBoxSrc;
	document.all.foldMode.value		= foldMode;
	document.all.multipMode.value	= multipMode;
	document.all.changeColor.value	= changeColor;
	document.all.selectMode.value	= selectMode;
	document.all.lockColumn.value	= lockColumn;
	document.all.pageSelect.value	= pageSelect;
	document.all.pageDefault.value	= pageItems;
	document.all.currPage.value		= currPage;
	document.all.filterStr.value	= keyFilter;
	document.all.totalCount.value	= totalCount;
	document.all.wheres.value		= wheres;
	document.all.busName.value		= busName;
	document.all.subName.value		= subName;
	document.all.userSign.value     = userSign;
	document.all.domainName.value   = domainName;
	document.all.otherparams.value	= otherparams;
	document.all.selectColName.value= selectColName;
}

//===============================================================================================//
// 列表对应辅助函数
//===============================================================================================//		
		/**
	    * 用于进行统计,需要改造，因为统计值来源于后台
	    */
	   function calculateFooterValues(stage){
		  if(stage && stage!=2)
			  return true;
		  var nrQ = document.getElementById("totalrow");
			  nrQ.innerHTML = sumColumn(13);
			  /*
		  var srQ = document.getElementById("sr_q");
			  srQ.innerHTML = sumColumn(5)
		  var nrS = document.getElementById("nr_s");
			  nrS.innerHTML = "$ "+sumIncome(2,3)
		  var srS = document.getElementById("sr_s");
			  srS.innerHTML = "$ "+sumIncome(4,5);
		  */
		  
		  return true;
		}
		function sumColumn(ind){
			var out = 0;
			for(var i=0;i<mygrid.getRowsNum();i++){
				out+= parseFloat(mygrid.cells2(i,ind).getValue())
			}
			return out;
		}
		function sumIncome(indPrice,indQuant){
			var out = 0;
			for(var i=0;i<mygrid.getRowsNum();i++){
				out+= parseFloat(mygrid.cells2(i,indPrice).getValue())*parseFloat(mygrid.cells2(i,indQuant).getValue())
			}
			return out;
		}
      
         
	  /**
       * 撤消选择所有的行



       */
       function onUnselectAllRows(){
          mygrid.unselectAllRows();
       }     
       
        function doOnRowSelected(id){
           return true;
	    }

        /**
	     *  link时触发的方法，主要用于页面的跳转或重定向
	     */
	    function callLink(){
	          alert("jsp模板中的function callLink()");
              //mygrid.setOnRowSelectHandler(doOnRowSelected);
              return;
	    }
	    
	    /**
	     *  用于在单元格内的按钮的onClick时所触发的方法



	     */
	    function clearFilterCondition(){		   
	       var columnCount;
	       var columnType;
	       //alert("jsp模板中的function clearFilterCondition()");
	       //curcolid =mygrid.getSelectedCellIndex();//当前的列索引号



		    columnCount=mygrid.getColumnCount();
		    for (i=1;i<columnCount;i++) {	          
		       columnType = mygrid.getColType(i);              
		       switch(columnType) { 
	           case "ed":
	                   mygrid.cells(0,i).setValue("");
	                   break;
	           }
		    }
	       //将焦点定位在第一行第二列           
		   mygrid.selectCell(0,3,true,true,1);
	       
	    }
        /**
         *
         */
        function setColFoucs(rowidxid,colidxid){            
            mygrid.selectCell(rowidxid,colidxid,true,true,1);
            
        } 
        
//===============================================================================================// 