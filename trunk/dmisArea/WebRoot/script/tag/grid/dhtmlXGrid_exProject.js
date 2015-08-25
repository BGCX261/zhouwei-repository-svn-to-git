/***********************************************************************************************
 *                    基于framework工程及dhtmlXGrid.js进行的扩展                                  *
 *                               author  孙兵团                                                 *
 ***********************************************************************************************
 */

/**
 *  判断是否是有效日期


 */
dhtmlXGridObject.prototype.validateDate = function(source) { 
  var tempArray;
  
  //tempArray =  source ; //arg.value;    
  var oldValue =  source ; //arg.value;

  //Split to date and time
  tempArray = source.split(' ');
  
  //Inculde more parts except date and time
  if (tempArray.length > 2){
	//arg.IsValid = false;
	return false;
	//return;
  }  
  
  if (!IsDate(tempArray[0],'-'))//Incorrect date format
  {
	//arg.IsValid = false;
    return false;
    //return;
    //return false;
  }

  //Include only date
  if (tempArray.length == 1){
	//arg.IsValid = true;
	return true;
	//return;
  }  

  //Deal with time
  if (tempArray[1].length==0) {
	return true;
  }
  
  tempArray = tempArray[1].split(':');
 
  //Over three parts
  if (tempArray.length > 3 || tempArray.length < 2){
	//arg.IsValid = false;
	return false;
	//return;
  }  
  var i;
  i =0;
  for(i;i<tempArray.length;i++){
	if (tempArray[i].length > 2){
		//arg.IsValid = false;
		return false;
		//return;
	}
  }
  //Judge hour
  if (tempArray[0].length > 2 || tempArray[0].length == 0)
  {
	//arg.IsValid = false;
    return false;
   // return;
  }

  if (IsInteger(tempArray[0],'+') == false){
	//arg.IsValid = false;
    return false;
	//return;
  }
  if (tempArray[0] > 23 ){
	//arg.IsValid = false;
	return false;
	//return;
  }
  //Judge minute and second
  i =1;
  for(i;i<tempArray.length;i++){
        if (tempArray[i].length > 2 || tempArray[i].length == 0)
        {
		//arg.IsValid = false;
         return false;
        // return;
        }
	if (IsInteger(tempArray[i],'+') == false){
		//arg.IsValid = false;
		return false;
		//return;
	}
	if (tempArray[i] > 59 ){
		//arg.IsValid = false;
		return false;
		//return;
	}    
  }
   //arg.IsValid = true;
   return  true;
}

/**
 *设置指定单元格的字体颜色
 */
dhtmlXGridObject.prototype.setColTextColor = function(rowid,colindexid,val){
	 this.cells(rowid,colindexid).setTextColor(val);
}
/**
 * 设置当前列表对象的实例名称



 */
dhtmlXGridObject.prototype.setGridObjName = function(gridId){
	if (gridId == null || gridId == ""){
		this.gridObjName = 'mygrid';
	} else {
		this.gridObjName = gridId;
	}
}
/**
 * 设置列表类别
 */
dhtmlXGridObject.prototype.setGridClass = function(gridType,gridKind){
  
   //列表类型
   this.gridType = gridType;
   //列表性质
   this.gridKind = gridKind;
}
/**
 *  行号列中链接所调用的函数



 */
dhtmlXGridObject.prototype.callLink = function(){
	alert("控件中的function callLink()");
	//this.setOnRowSelectHandler(doOnRowSelected);
	//this.setOnEditCellHandler(doOnRowSelected);
	//this.setOnKeyPressed(doOnRowSelected);
	return;
}
/**
 *  在操作列上弹出对话框
 */
dhtmlXGridObject.prototype.popUpForOp = function(rowid,colIndexid){
	var currurl = "";
	var found = false;
	var priColVal;
	var tmp;
	//url="application/main.jsp";   "ui.do?method=query";
	//列名^列值^type^url
	var opcolname,opcolval,opcoltype,opcolurl;
	//alert(this.opcolinfo+'          '+this.colsName);
	for (i=0;i<this.opcolinfo.length;i++){
		var arrInfo = this.opcolinfo[i].split("^");
		//alert(this.colsName+'     '+this.colsName[colIndexid]+'   '+arrInfo[0]);
		if (this.colsName[colIndexid] == arrInfo[0]){
			opcolval = arrInfo[1];
			currurl = arrInfo[3];	
			found = true;
			break;
		}
		
	}
	if (found == false){return;}
	//获取主键信息  id^string^1^639622^^not_sort	
	priColVal = this.getPriColVal2(rowid);
    
	tmp = priColVal.split("^");
	priColVal = tmp[0]+'^'+tmp[1]+'^'+tmp[3];
	if (currurl.indexOf('?') > 0){
		currurl += '&primaryInfo='+priColVal;
	} else {
		currurl += '?primaryInfo='+priColVal;
	}
	
	window.open(currurl);
    return;
}
/**
 *  用于在单元格内的(过滤行的橡皮擦)按钮的onClick时所触发的方法



 */
dhtmlXGridObject.prototype.clearFilterCondition = function(){
	var msg = "\n您真的要清除过滤条件吗?\n\n";
	if (confirm(msg)) {
		/*
		 *确定后刷新



		 */
		var otherparams = this.genOtherparams();
	    //设置持久化类名称
	    if (this.entityName == "" || this.entityName == null){			
	    } else {
		   var entityName = this.entityName;
	    }		
	    createGrid(entityName,0,"","",otherparams,this.wheres,"",this.selectColNames);
		return true;
	} else {
	   return true;
	}
	//因为确定后刷新了页面,所以不需要以下的控制 
	var columnCount;
	var columnType;           
	columnCount=this.getColumnCount();
    for (i=2;i<columnCount;i++) {		   
	  columnType = this.getColType(i); 				
	  switch(columnType) {
		case 'ed':
		   this.cells(0,i).setValue("");
		   break;
		case 'price':
		   this.cells(0,i).setValue(0);
		   break;
	  }
   }
	      
   //将焦点定位在第一行第一个可编辑列   
   for (i=2;i<this.colIsVisible.length;i++)  {
	  if (this.colIsVisible[i] == 1){
		 this.selectCell(0,i,true,true,1);	             
		 break;
	  }
   }
}
/**
 *  设置过滤行的图片按钮,调用模板页中的函数:
 *  clearFilterCondition():  清空过滤条件
 *  onUnselectAllRows() :    撤消所有的选择
 */
dhtmlXGridObject.prototype.setFilterRowImg = function(imgurl1,imgurl2,imgForSelectAll,imgForUNSelectAll){    
    //过滤行行号列的列值(图片按钮)
	this.imgForFilterRowno = "<input type='image' border='3' src='"+imgurl1+"'style='background:bottom'" + "onclick='"+this.gridObjName+".clearFilterCondition()'"+"/>";
	
	//过滤行中辅助选择列的列值(图片按钮)
	this.imgForFilterCH = "<input type='image' border='3' src='"+imgurl2+"'style='background:bottom'"+"onclick='sortSelectCol()'"+"/>";
	//辅助选择列的列标题(全选和撤消时所使用的图片)	
	this.imgForSelectAll=imgForSelectAll;
    this.imgForUNSelectAll=imgForUNSelectAll;	
}
/**
 *   设置操作列信息 列名^列值^type^url@@@列名^列值^type^function
 *    type: 1  打开页面(window.open)
            2  调用控件内部的函数

 */
dhtmlXGridObject.prototype.setOpColInfo = function(opcolinfo){	
	var arrInfoes = opcolinfo.split("@@@");	
	for (i=0;i<arrInfoes.length;i++){
		this.opcolinfo[i] = arrInfoes[i];
	}
	
}
/**
 * 设置操作列的列值

 */
dhtmlXGridObject.prototype.setOpColInfoVal = function(){
	var arrOpInfo;
	var srow=0;
	if (this.isFilter == 0){
		srow = 0;
	} else {
		srow = 1;
	}
	for (i=0;i<this.opcolinfo.length;i++){		
		arrOpInfo = this.opcolinfo[i].split('^');
		for (j=0;j<this.colsName.length;j++){			
			if (this.colsName[j].toLowerCase() == arrOpInfo[0].toLowerCase()){	
			    
				for (row=Number(srow);row<this.getRowsNum();row++){
					this.cells(row,j).setValue(arrOpInfo[1]);
					this.cells(row,j).setTextColor('blue');
				}
			}
		}
		
	}	
}
/**
 *  选择所有的行,在模板页中调用

 */
dhtmlXGridObject.prototype.selectAllRows = function(){
	var rows = this.getRowsNum();	
	if (this.isFilter == 1) {
		if (rows > 1){
		   for (i=1;i<rows;i++){
			   if (this.isItemExists(i)){
			      this.cells(i,1).setValue(1);
			   }
		   }
		   this.setHeaderCol(1,this.imgForUNSelectAll)
	    }
	}  else {	
		if (rows > 0){		   
		   for (i=1;i<=rows;i++){
			  if (this.isItemExists(i)){
			     this.cells(i,1).setValue(1);
		      }
		   }				   
		   this.setHeaderCol(1,this.imgForUNSelectAll)
	    }
	}
}

/**
 * 撤消所有的选择行(即选几行，撤消几行)
 */
dhtmlXGridObject.prototype.unselectAllRows = function(){
	var rows = this.getRowsNum();	
	if (this.isFilter == 1) {
		if (rows > 1){
		   for (i=1;i<rows;i++){
			   if (this.isItemExists(i)){
			      this.cells(i,1).setValue(0);
			   }
		   }
		   this.setHeaderCol(1,this.imgForSelectAll)
	    }
	} else {
		if (rows > 0){
		   for (i=1;i<=rows;i++){
			   if (this.isItemExists(i)){
			      this.cells(i,1).setValue(0);
			   }
		   }		       
		   this.setHeaderCol(1,this.imgForSelectAll)
	    }
	}
}


/**
 *  隐藏或显示过滤行	
 */
dhtmlXGridObject.prototype.changeFilterRow = function(){
	var i=0;
	var rowData="";
   //如果没有过滤行,就不进行处理了



   if (this.isFilter == 0) {
	   return false;
   }
   
   //if (this.isItemExists(0)){
   if (this.showFilterRow) {
	   //删除之前要保存当前已经录入的条件		
	  /* for (i=0;i<this.getColumnCount();i++){
		   this.filterData[i] = this.cells2(0,i).getValue();
	   }
	   this.deleteRow(0);
	   */	
	   this.setRowHidden(0,true);
	   this.showFilterRow = false;
   } else {
	   /*
	    //插入新行
	   rowData = '[';
	   for (i = 1;i<this.getColumnCount();i++){
		 rowData += ",";
	   }
	   rowData += ']';
	   this.addRow(0,rowData,0);	   
	   //重新设置图片
	   this.cells2(0,0).setValue(this.imgForFilterRowno);
	   
	   this.setCellExcellType(0,1,'ro'); //改变列的编辑风格  
	   this.cells2(0,1).setValue(this.imgForFilterCH);
	   //恢复关闭之前的数据



	   for (i = 1;i < this.getColumnCount();i++){
		   this.cells2(0,i).setValue(this.filterData[i]);
	   }
	   */
	   
	   this.setRowHidden(0,false);
	   this.showFilterRow = true;
	   
	   /*
	   //将焦点定位在第一行第三列	   
	   this.selectRow(0);
	   this.selectCell(0,2,true,true,1);   
	   this.cells(0,2).setValue('dddddddddddddd');
	   */
	   
   }
   return true;
   
}
/**
 * 设置查询界面中所设定的查询条件



 */
dhtmlXGridObject.prototype.setWhere = function(wheres){
	var wherestr = wheres;
	if (wherestr == null) {
		wherestr = "";
	}
	this.wheres = wherestr;
}
/*
 * 设置持久化类名称(实体类名)
 */
dhtmlXGridObject.prototype.setEntityName = function(entityName){
   this.entityName = entityName;
}
/**
 * 初始化请求路径



 */
dhtmlXGridObject.prototype.setQueryPath = function(queryPath,filterPath){
   this.queryPath = queryPath;
   this.filterPath = filterPath;
}
/**
 * 初始化上下文路径
 */
dhtmlXGridObject.prototype.setContextPath = function(contextPath){
   this.contextPath = contextPath;
}
/**
 * 初始化每列的名称、主键信息、编辑信息、显示信息



 */
dhtmlXGridObject.prototype.setColsName = function(colsName,primaryinfo,editinfo,visibleinfo){
   var arrcolname = colsName.split(",");
   var arrcolisprimary = primaryinfo.split(",");
   var arrcolisedit = editinfo.split(",");
   var arrcolvisible = visibleinfo.split(",");
   var colNum = 0;
   for (i=0;i<arrcolname.length;i++){
	   this.colsName[i] = arrcolname[i]; //列名
	   this.colsNameBak[i] = arrcolname[i];//备份列名,如果列表支持列的拖动,用于保存原有的顺序



	   this.colIsPrimary[i] = arrcolisprimary[i];  //是否是主键



	   this.colIsUpdate[i] = arrcolisedit[i];  //是否可编辑



	   if (arrcolisedit[i] == 1){
		   colNum ++;
	   }
	   this.colIsVisible[i] = arrcolvisible[i];  //是否显示
   }
   //记录最后一个可编辑的列号

   this.lastEditColNum = colNum;
}
/**
 * 按照百分比设置列宽



 */
dhtmlXGridObject.prototype.setCellWidth = function(widthStr){
	var colWidths = widthStr.split(',');
	var colWidthsum=0;
	var newColWidthSum=0;
	var realWidth="";
	var colWidth=0;
	//计算各列宽之和



	for (i=0;i<colWidths.length;i++){
		colWidthsum = colWidthsum + Number(colWidths[i]);
	}
	//按照百分比计算各列宽
	for (i=0;i<colWidths.length;i++){
		//当前列宽占总列宽的百分比 * 100
		colWidth = Math.round(Number((colWidths[i] * 100) / Number(colWidthsum) ) );
		//转换后的新的列宽之和
		newColWidthSum = newColWidthSum + colWidth;
		//避免出现横向滚动条,并把纵向滚动条置于数据区之外
		if (i == (colWidths.length -1)){
			if (newColWidthSum > 100) {
			   colWidth = colWidth - (newColWidthSum - 100);
			}
		}
		//组织列百分比字符串



		realWidth = realWidth + ',' + colWidth;			
	}
	//去掉多余的逗号
	realWidth = realWidth.substr(1,realWidth.length);
	//按照百分比设置各列宽
	this.setInitWidthsP(realWidth);
	//设置列的最小宽度		
	var widthCol = realWidth.split(',');
    for (i=0;i<widthCol.length;i++){
		this.setColumnMinWidth(Number(widthCol[i]),i);
	}
}
/**
 * 更替单选或多选模式



 */
dhtmlXGridObject.prototype.setSelectMode = function(mode){
	switch (mode) {
	   case 1:
		  //单选模式



		  this.setMultiselect(false);
		  break;
	   case 2:
		  //多选模式



		  this.setMultiselect(true);
		  break;
	}
}

/**
 * 设置分页信息
 **/
dhtmlXGridObject.prototype.setPagePer = function(pageno,pagecount){
	//页码
	this.pageno = pageno;
	//每页的记录条数

	this.pagecount = pagecount;
}
/**
 * 返回选择的行中主键的值及列名,在删除和复制时调用



 *  opType  1 删除   2  复制(只含主键列)   3 获取整行数据(不含特殊列)
 * colname1^colvalue1@@@colname2^colvalue2 复制时



 * colname1^colvalue1@@@colname2^colvalue2###colname1^colvalue1@@@colname2^colvalue2
 * 返回格式如上
 */
dhtmlXGridObject.prototype.getSelectedRowsData = function (opType){
	var rowdata="";
	var retvalue = "";
	var colnum;
	var rows = this.getRowsNum();  //总行数    
	var row = this.getSelectedId();//选择行的号
    
	
	if (rows == null || rows == 0) {
		if (opType == 1) {
			alert("列表中没有要删除的数据!");
		}		
		return "";
	}		

	if (row == null ){			
		if (opType == 1) {
			alert("请选择要删除的数据!");
		}		
		return "";			
	}
	if (row == 0 && this.isFilter == 1){
		if (opType == 1) {
			alert("不能删除过滤行的数据!");
		}		
		return "";				
	}

	if (row == rows ){
		if (opType == 1) {
			alert("不能删除合计行!");
		}		
		return "";			
	}
	if (this.isFilter == 0){
		row = row - 1;
	}
	//复制(只返回主键信息),支持组合主键,不支持多选



	var ss;
	if (opType == 2){
		for (var i=1;i<this.getColumnCount();i++){
			if ( this.colIsPrimary[i] == 1 ) {
			   rowdata += this.colsName[i] + "^" + this.cells2(row,i).getValue()+"@@@";
			}
		}
		retvalue = rowdata.substr(0,rowdata.length - 3);	
	}
	//获取整行数据
	if (opType == 3){
		for (var i=1;i<this.getColumnCount();i++){
			if ( this.colsName[i] != "rowno" && this.colsName[i] != "selCheckBox"  && this.colsName[i] != "opButton" && this.colsName[i] != "rowStatus" ) {
			   
			   rowdata += this.colsName[i] + "^" + this.cells2(row,i).getValue()+"@@@";
			}
		}
		retvalue = rowdata.substr(0,rowdata.length - 3);	
	}
	//删除,支持组合主键,支持多选
	var isdelrow = true;
	var node;
	var coldata = "";
	rowdata = "";
	if (opType == 1){
		var num = this.selectedRows.length;	
		if(num==0) return;
		var tmpAr = this.selectedRows; 
		//扫描选择的行
		for(var i=num-1;i>=0;i--){
		   node = tmpAr[i];               
		   //提取主键列的列名及列值



		   for (var j=0;j<this.getColumnCount();j++){
			   if ( this.colIsPrimary[j] == 1 ) {
				  coldata += this.colsName[j] + "^" + this.cells2(node.idd,j).getValue()+"@@@";				  
			   }			       
		   }
		   rowdata += coldata.substr(0,coldata.length - 3) + "###";
		   coldata = "";
		}
		
		retvalue = rowdata.substr(0,rowdata.length - 3);	
	}
	
	return retvalue;
 }
 
/**
 * 设置统计信息,服务端生成数据时使用
 */
dhtmlXGridObject.prototype.setTotalInfo = function(totalinfo,isTotalRow,isOperater){
	
	//设置列的统计信息
	if (totalinfo == null || totalinfo == ""){
		this.TotalInfo = "";
	} else {	   
	   this.TotalInfo = totalinfo;
	}
	//判断当前列表是否有统计行
	if (isTotalRow == null || isTotalRow == ""){
	   this.isTotalRow = 0;
	} else {
		this.isTotalRow = isTotalRow;
	}
	
	//设置是否有操作列
	if (this.isOperater == null || this.isOperater == ""){
		this.isOperater = 0;
	} else {
		this.isOperater = isOperater;
	}
}
/**
 *  初始化各列的数据类型
 */
dhtmlXGridObject.prototype.setHibDataType = function(hibdatatype){
   var datatype = hibdatatype.split(",");
   for(i=0;i<datatype.length;i++){
	   this.hibdatatype[i] = datatype[i];
   }
}
/**
 * 获取指定列索引号的列的数据类型



 */
dhtmlXGridObject.prototype.getColHiType = function(colid){
   return this.hibdatatype[colid];
}
/**
 * 设置下拉列表框所回填的列的列名



 */
dhtmlXGridObject.prototype.setColValByListInfo = function(str){
	this.colValByListInfo = str.split("^");
}
/**
 * 根据列名获取其所在单元格的索引号
 */
dhtmlXGridObject.prototype.getColIndex = function(colName){	   
   for (i=0;i<this.colsName.length;i++) {
	   if (this.colsName[i] == colName) {
		   return i;
	   }
   }
}
/**
 *  设置列对应的关联关系类名及关联关系属性名(需要在拖动后处理)
 */
dhtmlXGridObject.prototype.setColRefInfo = function(refclassname,refname){
	//关联关系类名
	this.refClassName = refclassname.split(',');
    //关联关系属性名   
    this.refName = refname.split(',');
}
/**
 * 子表外键的列名、列值(salesId^639697)
 */
dhtmlXGridObject.prototype.setRefColVal = function(refinfo){
	 this.refColVal = refinfo;
}
	 
/**
 * 设置外键列的值



 */    
dhtmlXGridObject.prototype.setReferenceColVal = function(rowid){
   var refStr = this.refColVal;
   var colInfo,refColInfo;
   if (refStr == null || refStr == "") {
	  return false;
   }
   
   //支持组合主键
   refColInfo = refStr.split("@@@");
   for (i=0;i<refColInfo.length;i++){
	  colInfo = refColInfo[i].split("^");
	  //salesId^string^1^639697^^asc
	  this.cells(rowid,this.getColIndex(colInfo[0])).setValue(colInfo[1]);
   }
}
/**
 * 设置查询结果中的指定列的统计值



 */
dhtmlXGridObject.prototype.setColTotalValue = function(totalInfo){
	this.colTotalValue = totalInfo.split(',');
}
/**
 *  初始化新行中的列的信息



 */
dhtmlXGridObject.prototype.initColForNewrow = function(rowid){
   var colVal;
   for (colIndex=0;colIndex<this.getColumnCount();colIndex++){
	   colVal = this.getInitVal(colIndex);
	   
	   if (colVal != null && colVal != "" && colVal != "null" && colVal != "not null"){
		  //alert('rowid:'+rowid+'  colIndex:'+colIndex+'  colVal:'+colVal);
		  this.cells(rowid,colIndex).setValue(colVal);
	   }
   }
}
/**
 * 新增数据行并进行初始化



 * 由于目前该控件不支持直接在最后一行之后增加新的数据行
 * 只能先在最后一行之前插入数据行，然后移动到最后一行的位置
 */
dhtmlXGridObject.prototype.addNewRow = function(){
	var rowid = this.getRowsNum();
	//在最后一行之前插入数据行
	this.insertRowBefore(rowid);
	//将新插入的行移动到最后



	this.moveRowDown(this.getSelectedId());
	/*
	 * 改变最后两行的行号列的列值及行号
	 */
	rowid = this.getRowsNum();	
	//设置原始的最后一行的行号列的列值



	this.cells(Number(rowid),0).setValue((Number(rowid) - 1)+'^javascript:callLink();^_self');  
	//设置新增行的行号列的列值



	this.cells((Number(rowid) - 1),0).setValue(Number(rowid)+'^javascript:callLink();^_self');  
	//this.changeRowId(rowid,Number(rowid) + 1)
	
	var newrowid = (new Date()).valueOf();
	this.changeRowId(rowid,newrowid); //先将原始的最后一行的行号设置为临时行号



	this.changeRowId((Number(rowid) - 1),rowid); //修改新增行的行号为最大行号



	this.changeRowId(newrowid,(Number(rowid) - 1)); //先将原始的最后一行的行号设置为(最大行号 - 1)	
	
}
/**
 * 新增数据行并进行初始化（没有数据，第一次新增时使用）



 */
dhtmlXGridObject.prototype.initNewRow = function(){
	var xmlInitData;
	var num = this.colsName.length;	
	xmlInitData = '<?xml version="1.0" encoding="UTF-8"?>'+'<rows>'+'<row id="1">';
	for (i=0;i<num;i++){
		switch (i){
			case 0:
			   xmlInitData += '<cell>'+'1^javascript:callLink();^_self'+'</cell>';
			   break;
			case 1:
			   if (this.isSelCheckBox == 1){
			      xmlInitData += '<cell>'+'0'+'</cell>';
			   } else {
				  xmlInitData += '<cell>'+'</cell>';
			   }
			   break;
		}
		if (i > 1 && i < (num-1)){
			xmlInitData += '<cell>'+'</cell>';
		} else if (i == (num - 1)) {			
			xmlInitData += '<cell>'+'3'+'</cell>';
		}
	}
	xmlInitData += '</row></rows>';
	alert('xmlInitData:'+xmlInitData);
	this.loadXMLString(xmlInitData);
}

/**
 * 进行焦点的定位



 */
dhtmlXGridObject.prototype.setFocus = function(rowid,currColId){
	var sequelEx = false;
	var currColName = "";
	var newCol = currColId + 1;
	this.clearSelection();
	//读取下一个可以编辑的列,并进行焦点定位



	for (i=newCol;i<this.getColumnCount();i++){
		if (sequelEx) { break;}
		currColName = this.colsName[i];
		for (j=i;j<this.colsName.length;j++){
			if (currColName == this.colsName[j]){
				if (this.colIsUpdate[j] == 1 && this.colIsVisible[j] == 1 ){	
					this.selectCell(this.rowsCol[rowid - 1],j,true,true,1);
					sequelEx = true;
					break;
				}					
			}
		}
	}
}
/**
 * 在选择的行之前插入新行
 */
dhtmlXGridObject.prototype.insertRowBefore = function(rowid){	
    var tmprowid;			
	var sequelEx = false;
	var currColName = "";
	var rowData = "";
	var newrowid;
	var newrowindex;
	var rows;
	//插入新行	
	newrowid = (new Date()).valueOf();
	newrowindex = this.getRowIndex(rowid);
	this.addRow(newrowid,["1",0],newrowindex);
	//设置行号列的列值	
	this.cells(newrowid,0).setValue(rowid+'^javascript:callLink();^_self');
	//设置行状态列的值



	this.cells(newrowid,this.getColumnCount() -1).setValue('3');	
	//设置外键列的值



	this.setReferenceColVal(newrowid);
	//更新插入行以后的各行的行号列的列值及行号    
	//this.changeRowId(rowid,Number(rowid) + 1)
	//this.cells((Number(rowid)+ 1),0).setValue((Number(rowid)+ 1)+'^javascript:callLink();^_self');
	//alert('rowid:'+rowid+'  rows:'+rows);	
	rows = this.getRowsNum();
	for (row=rowid;row<rows;row++){	
		this.cells(Number(row),0).setValue((Number(row)+ 1)+'^javascript:callLink();^_self');		
	}
	
	while (true) {
		this.changeRowId(rows - 1,rows);
		rows --;
		if (rows == rowid) {
			break;
		}
	}
	
	
	//更新插入的行的行号



	this.setRowId(this.getRowIndex(newrowid),rowid);
	
	//初始化插入行的各列的值



	this.initColForNewrow(rowid);
	this.setSelectedRow(rowid);
	
}
/**
 * 下拉列表框



 */
dhtmlXGridObject.prototype.setListBox = function(listBox,listBoxSrc){	   
   var oldlistBox = String(listBox);
   var oldlistBoxSrc = String(listBoxSrc);
   var arrlistbox,arrlistboxsrc;	  
   arrlistbox = oldlistBox.split(",");	 
   arrlistboxsrc = oldlistBoxSrc.split(",");	
   for (var i=0;i<arrlistbox.length;i++){		   
	   this.listBox[i] = arrlistbox[i];		
	   this.listBoxSrc[i] = arrlistboxsrc[i];
   }   
}
/**
 * 获取下拉列表的类型



 */
dhtmlXGridObject.prototype.getListBox = function(colIndex){
	return this.listBox[colIndex];
}
/**
 * 获取下拉列表的数据源信息
 */
dhtmlXGridObject.prototype.getListBoxSrc = function(colIndex){
	return this.listBoxSrc[colIndex];
}	
/**
 *保存初始化值



 */
dhtmlXGridObject.prototype.setInitVal = function(initstr){
	var str = initstr.split(",");		
	for (i=0;i<str.length;i++){
		this.initdata[i] = str[i];
	}
}
/**
 * 获取指定列的初始化值



 */
dhtmlXGridObject.prototype.getInitVal = function(colIndex){
	return this.initdata[colIndex];
}
/**
 * 改变新增行的状态



 */
dhtmlXGridObject.prototype.changeRowStatus = function(rowid,colid,oldstatus){		
	var colVal;
	var colInx,colNum;
	var changestatus = true;
	var newstatus = oldstatus;
	var oldstatusnum = Number(oldstatus);	
	//判断是否有辅助选择列,来确定循环变量的起始值



	if (this.isSelCheckBox == 1) {
		colInx = 2;
	} else {
		colInx = 1;
	}
	//判断是否有操作列,来确定循环变量的终止值



	if (this.isOperater == 1){
		colNum = this.getColumnCount() - 2;
	} else {
		colNum = this.getColumnCount() - 1;
	}
	//对于新行，判断是否所有的非空列都已经有值		
	for (i=colInx;i<colNum;i++){	   			
		if (this.initdata[i] == "not null" &&  this.colIsUpdate[i] == 1){
			colVal = this.cells(rowid,i).getValue().toString()._dhx_trim();
			if (colVal == null || colVal == "") {
			   changestatus = false;
			   break;
			}
		}
		
	}
	/**
	 * 1  正常(查询的未作修改的行的状态)  2 修改(查询的并修改的行的状态)  3 新增的行  4 可以保存的新行



	 */		
	
	if (changestatus == true) {
		switch (oldstatusnum){
		case 1:
		   newstatus = 2;
		   break;
		case 2:
		   newstatus = oldstatus;
		   break;
		case 3:
		   newstatus = 4;
		   break;
		case 4:
		   newstatus = oldstatus;
		   break;
		}
		
	}		
	//alert('newstatus:'+newstatus + '  oldstatus:'+oldstatus);
	this.cells3(this.rowsCol[rowid - 1], this.getColumnCount() - 1).setValue(newstatus);
	return newstatus;
}
/**
 * 提取主键列的列名及列值,带列的索引号
 */
dhtmlXGridObject.prototype.getPriColVal = function (rowid){
	 var retvalue;
	 var coldata = "";
	 //扫描当前行的各列,支持联合主键
	 for (var j=0;j<this.getColumnCount();j++){
		 if ( this.colIsPrimary[j] == 1 ) {
			 coldata += this.colsName[j] + "^" + j + "^" +this.cells2(rowid - 1,j).getValue()+"@@@";	     
		 }			       
	 }		
	 retvalue = coldata.substr(0,coldata.length - 3);	
	 return retvalue;
}
/**
 * 提取主键列的列名及列值,id^string^1^639622^^not_sort
 */
 dhtmlXGridObject.prototype.getPriColVal2 = function (rowid){
	 var retvalue;
	 var coldata = "";
	 var row_indexid;
	 if (this.isFilter == 1){
		 row_indexid = rowid;
	 } else {
		 row_indexid = rowid - 1;
	 }
	 //扫描当前行的各列,支持联合主键
	 for (var j=0;j<this.getColumnCount();j++){
		 if ( this.colIsPrimary[j] == 1 ) {
			 coldata += this.colsName[j] + "^" + this.hibdatatype[j]+"^"+"1"+"^"+this.cells2(row_indexid,j).getValue()+"^^"+"asc"+"@@@";	     
		 }			       
	 }		
	 retvalue = coldata.substr(0,coldata.length - 3);	
	 return retvalue;
 }
 
 /**
  * 提取主键列的列值(子表中外键列名^外键列值@@@子表中外键列名2^外键列值2)
  */
dhtmlXGridObject.prototype.getPriColVal3 = function (rowid){
	 var retvalue;
	 var coldata = "";
	 
	 //扫描当前行的各列,支持联合主键
	 for (var j=0;j<this.getColumnCount();j++){
		 if ( this.colIsPrimary[j] == 1 ) {
			 coldata += this.refName[j]+"^"+this.cells(Number(rowid),j).getValue()+"@@@";	
			 //coldata += this.refName[j]+"^"+this.cells(Number(rowid),j).getValue()+"@@@";
			
		 }			       
	 }		
	 retvalue = coldata.substr(0,coldata.length - 3);
	 return retvalue;
}
/**
 *  删除时，返回主键名及其值(rowno^1@@@name^value@@@name2^value2###rowno^2@@@name^value@@@name2^value2)
 */
dhtmlXGridObject.prototype.getDelingIDVal = function(){
	 var selectrow = this.getSelectedId();
     var arrRow;
     var row;
     var colval="";
     var coldata="";
     var xmldata= "";
     if (selectrow == 0 || selectrow == null){
       alert("请先选择要删除的数据行,再进行操作!");
       return "notselectrow";
     }
     //按选择的行进行循环
	 arrRow = selectrow.split(",");     

     for (i=0;i<arrRow.length;i++){  
        row = arrRow[i];     
        //循环各列,如果是主键列,则提取其值



        for (j=0;j<this.colsName.length;j++){
		   if (this.colIsPrimary[j] == 1) {
             colval = this.cells(row,j).getValue(); 
			 //colval = toString()._dhx_trim(colval);  
             //如果主键值为空,说明是新增的记录,则不发送



             if (colval == null || colval == "")  {
              continue;
             }
             //要考虑联合主键
             if (coldata == "") {
               coldata = "" + this.colsName[j]+"^"+colval;
             } else {
               coldata += "@@@" + this.colsName[j]+"^"+colval;
             }

          }

        }

       //各行之间使用###隔开
       if (xmldata == "") {
         xmldata = "" + "rowno"+"^"+(row)+"@@@"+coldata;
       } else {
         xmldata += "###" + "rowno" + "^" + (row) + "@@@" + coldata;
       }      

     }
	 return xmldata;

}

/**
 * 设置单击列标题时的默认排序信息



 */
dhtmlXGridObject.prototype.setOnclickSort = function (sortOnlyCol){
	this.sortonlycol = sortOnlyCol;
}
/**
 * 设置各列的显示风格



 * ,,,,,,,,,,,,,0,0000
 */
dhtmlXGridObject.prototype.setColDisplayFormat = function(displayFormat){
	this.colsDisplayFormat = displayFormat.split('^');
}
/**
 * 提供给外部调用的接口,用于改变行的状态



 */
dhtmlXGridObject.prototype.changeRowStatusByControl = function(rowid,colid){		
	//获取当前行的状态



	var statusColVal = this.cells(this.row.idd,this.getColumnCount() - 1).getValue();		 
	//先获取当前行的主键值							   
	var privalue =  this.getPriColVal(rowid);	
	//停止编辑,使当前的列失去焦点,防止加入回车换行符



	this.editStop();						   
	//获取判断后的状态,changeExRowStatus在模板中
	statusColVal = changeExRowStatus(rowid,colid,statusColVal,privalue);	    
	return true;
}

/**
 *业务层传递的查询条件
 */
dhtmlXGridObject.prototype.setExtWheres = function (extparams){
	this.extWheres = extparams;
}
/**
 *业务层传递的排序规则
 */
dhtmlXGridObject.prototype.setExtOrder = function (extparams){
    this.extOrder = extparams;
}

/**
 * 设置过滤条件
 */
dhtmlXGridObject.prototype.setHistoryFilter = function(historyFilter){
	this.historyFilter = historyFilter;
}
/**
 * 设置过滤规则及过滤模式



 */
dhtmlXGridObject.prototype.setFilter = function(filterMode,filterRules){
	//过滤模式
	this.filterMode = filterMode;	
	//过滤规则
	var arrfilterRules = filterRules.split(",");
	for (i=0;i<arrfilterRules.length;i++){
	   this.filterRules[i] = arrfilterRules[i];
	}
	switch (filterMode) {
		case 0:
		   this.isFilter = 0;
		   break;
		case 1:
		   this.isFilter = 1;
		   break;
		case 2:
		   this.isFilter = 1;
		   break;
	}
}
/**
 *  恢复过滤条件
 *  maintainrate^double^4^50000@@@id^string^8^abc
 */
dhtmlXGridObject.prototype.resetFilter = function(){
	var arrFilters = this.historyFilter.split("@@@");
	var arrFilter;
	for (j=0;j<arrFilters.length;j++){
		arrFilter = arrFilters[j].split("^");
		for (i=0;i<this.getColumnCount();i++){
		   if (arrFilter[0] == this.colsName[i]){
			   if (arrFilter.length == 5 && Number(this.listBox[i]) == 7) {
				   this.cells(0,i).setValue('从：'+arrFilter[3]+' 到：'+arrFilter[4]);
			   } else {
				   this.cells(0,i).setValue(arrFilter[3]);
			   }
			  
		   }
		}
	}	
}

/**
  * 对用户录入的信息进行有效性检查



  * rowid:行号
  * colid:列号
  * value:录入的信息



  */
dhtmlXGridObject.prototype.checkColValue = function(rowid,colid,value){
	 var sortType,headerCol;
	 var errMessage;
	 //获取当前列的排序类型,根据排序类型进行有效性检查



	 sortType = this.fldSort[colid];
	 sortType = sortType.toLowerCase();
	 //获取当前列的列标题



	 headerCol = this.getHeaderCol(colid);
	 headerCol = headerCol.substring(headerCol.indexOf(">") + 1,headerCol.lastIndexOf("<"));
	 
	 switch (sortType){
		 case "str":
		    if (value.indexOf('^') >= 0){
				errMessage = "您输入的"+headerCol+"("+value+")中不能包含^";	
				return false;
			} else if (value.indexOf('###') >= 0){
				errMessage = "您输入的"+headerCol+"("+value+")中不能包含###";	
				return false;
			} else if (value.indexOf('@@@') >= 0){
				errMessage = "您输入的"+headerCol+"("+value+")中不能包含@@@";	
				return false;
			}
			
			if (errMessage == undefined || errMessage == null){				
				return true;
			}
			alert(errMessage);
			//清空包含无效数据的单元格
			this.cells(rowid,colid).setValue("");
			//将焦点定位到出错的列
			this.selectCell(rowid,colid,true,true,1);
			return false;
			break;
		 case "date":
			break;
		 case "int":			  
			if (isNaN(value)) {					
				errMessage = "您输入的"+headerCol+"("+value+")是不正确的!\n应该输入正确的数值";					
				alert(errMessage);
				//清空包含无效数据的单元格
				this.cells(rowid,colid).setValue("");
				//将焦点定位到出错的列
				this.selectCell(rowid,colid,true,true,1);
				return false;
			} 
			break;
		 case "price":
			break;
	 }
	 return true;
 }
/**
 * 综合参数:合计信息,操作列信息,列表类型,列表性质...
 */
dhtmlXGridObject.prototype.genOtherparams = function(){
	var otherparams;
	otherparams = "gridKind"+"^"+this.gridKind+"@@@";
	otherparams = otherparams + "gridType"+"^"+this.gridType+"@@@";
	otherparams = otherparams + "isOperater"+"^"+this.isOperater+"@@@";
	otherparams = otherparams + "isTotalRow"+"^"+this.isTotalRow+"@@@";
	otherparams = otherparams + "TotalInfo"+"^"+this.TotalInfo;
	return otherparams;
}
/**
 * 解析用户录入的组合日期条件(从: yyyy-mm-ss 到： yyyy-mm-ss hh:mm:ss)
 */
dhtmlXGridObject.prototype.genWhereOfComdate = function(comdatestr){
	var sdate=comdatestr.substr(2);
	var edate;
	var tmpplace=0;
	var retObj;	
	tmpplace = comdatestr.indexOf(' 到：');
	edate = sdate.substr(tmpplace + 1);
	sdate = sdate.substr(0,tmpplace - 1);	
	retObj = sdate.toString()._dhx_trim() +'^'+edate.toString()._dhx_trim();	
	return retObj;	
}
/**
 * 获取过滤信息
 */
dhtmlXGridObject.prototype.genFilterstr = function(colvalue,cellIndex){
	var colname = "",filterstr="",colTmpName='';
	var datatype="";	
	var colval="";
	var retParam = new Array();;
	//获取过滤列的列名
	colname = this.colsName[cellIndex];
	//获取当前列的数据类型,根据数据类型组合过滤条件
	datatype = this.hibdatatype[cellIndex];			       
	//单列过滤模式
	if (this.filterMode == 1) {
	   filterstr = colname + "^"+ datatype +"^"+this.filterRules[cellIndex]+"^"+colvalue;	   
	}
	//多列过滤模式
	if (this.filterMode == 2) {
		for(c=2;c<this.getColumnCount() - 1;c++){
		    colTmpName = this.colsName[c];
			//不依据特殊列进行查询
			if (colTmpName == 'opButton' || colTmpName == 'rowno' || colTmpName == 'selCheckBox' || colTmpName == 'rowStatus'){
				continue;
			}
			colval=this.cells(0,c).getValue().toString()._dhx_trim();
			if (colval == null || colval == ''){
			} else {				
			   colname = this.colsName[c];			   
			   datatype = this.hibdatatype[c];		
			   if (this.filterRules[c] == 2) {
				   //between and
				   //if (this.validateDate(retParam[0]+' 00:00:00') == false){ continue;}
				   
				   retParam = this.genWhereOfComdate(colval).split('^');	
				   //alert('retParam[0]:'+retParam[0])
				   if (retParam[0].toString()._dhx_trim() == null || retParam[0].toString()._dhx_trim() == ''){					  
				      continue;
				   }
				   filterstr += colname + "^"+ datatype +"^"+this.filterRules[c]+"^"+retParam[0]+'^'+retParam[1]+'@@@';
			   } else {
				   filterstr += colname + "^"+ datatype +"^"+this.filterRules[c]+"^"+colval+'@@@';
			   }
			}
		}
		filterstr = filterstr.substr(0,filterstr.length - 3);
	}
	//alert('filterstr:'+filterstr);
	return filterstr;
}
/**
 * 当前的分页信息



 */
dhtmlXGridObject.prototype.genPageStr = function(){
	var pageStr;
	if (this.pagecount > 0 ) {
		//如果没有设置页码,则默认为1
		if (this.pageno <= 0 || this.pageno == null ||  this.pageno == ""){
			pageStr = "1"+"^"+ this.pagecount;
		} else {
			pageStr = this.pageno+"^"+ this.pagecount;
		}
	}
	return pageStr;
}
/**
 * 保存每个数据列的列名及其数据类型
 * id^integer,name^string,gz^double...
 */
dhtmlXGridObject.prototype.setColNamesTypes = function(colNamesTypes){
   this.selectColNames = colNamesTypes;
}
/**
 * 执行过滤,支持单列过滤模式和多列过滤模式



 */
dhtmlXGridObject.prototype.callFilter =  function(colvalue,cellIndex) {
	var colname,url,filterstr;
	var datatype;
	var pageStr = "";
	var entityName = "";
	var otherparams = "";
	var colval;
	var wheres;
	var tmp;
	var url;
	if (this.selectColNames == null || this.selectColNames  == ""){
		alert("没有设置查询列及其数据参数,无法提取数据!");
		return false;
	}
		       
	//过滤信息
	//alert(colvalue+'   '+cellIndex);
	filterstr = this.genFilterstr(colvalue,cellIndex);
	//设置持久化类名称
	if (this.entityName == "" || this.entityName == null){			
	} else {
		entityName = this.entityName;
	}
	//分页信息	
	pageStr = this.genPageStr();
	//其它参数:合计信息,操作列信息,列表类型,列表性质...
	otherparams = this.genOtherparams();

	/**
	  *  不可编辑 、可过滤查询、有统计行、有行号、有操作列的标准列表
	  *  不可编辑 、可过滤查询、无统计行、有行号、无操作列的简单列表



	  */
	if (this.gridType == 3 && (this.gridKind == 101 || this.gridKind == 103)){			
		url = this.filterPath + "&queryType=0";
		url = url + "&selectColNames=" + this.selectColNames;
		url = url +"&wheres="+this.wheres+"&filterParams="+filterstr;
		url = url + "&pageStr="+pageStr;
		url = url + "&entityName="+entityName;
		url = url + "&otherparams="+otherparams;
	}
	//alert(url+"\n"+url.length);
	//处理服务端接收参数时的中文乱码



    //url = encodeURI(url);		
	//location.href = url;
	//使用pototype
	wheres = this.wheres;
	/*应放到行改变的方法中调用this.refColVal
	if (!(this.refColVal == "" || this.refColVal == null)){
		
		//salesId^string^1^639697^^asc
		tmp = this.refColVal.split('^');
		if (wheres == null || wheres == ""){
			wheres = tmp[0]+'^'+'string'+'^'+'1'+'^'+tmp[1]+'^^asc'+'###'
		} else {
			wheres = tmp[0]+'^'+'string'+'^'+'1'+'^'+tmp[1]+'^^asc'+'@@@'+wheres
		}
		
	}
	*/
	createGrid(entityName,0,"",pageStr,otherparams,this.wheres,filterstr,this.selectColNames);
}
/**
 * 执行服务端的排序
 */
dhtmlXGridObject.prototype.callServerSort = function(colind){
	var colname,url,filterstr;
	var datatype;
	var pageStr = "";
	var entityName = "";
	var otherparams = "";
	
	if (this.sortonlycol == "" || this.sortonlycol == null || this.sortonlycol == "null"){
	   this.sortonlycol = this.colsName[colind]+"^"+"asc";
	}
	
	if (this.selectColNames == null || this.selectColNames  == ""){
		alert("没有设置查询列及其数据参数(selectColNames),无法提取数据!");
		return false;
	}
	
	//设置持久化类名称
	if (this.entityName == "" || this.entityName == null){			
	} else {
		entityName = this.entityName;
	}
	//每页的记录条数		
	if (this.pagecount > 0 ) {
		//如果没有设置页码,则默认为1
		if (this.pageno <= 0 || this.pageno == null ||  this.pageno == ""){
			pageStr = "1"+"^"+ this.pagecount;
		} else {
			pageStr = this.pageno+"^"+ this.pagecount;
		}
	}
	//其它参数:合计信息,操作列信息,列表类型,列表性质...
	otherparams = "gridKind"+"^"+this.gridKind+"@@@";
	otherparams = otherparams + "gridType"+"^"+this.gridType+"@@@";
	otherparams = otherparams + "isOperater"+"^"+this.isOperater+"@@@";
	otherparams = otherparams + "isTotalRow"+"^"+this.isTotalRow+"@@@";
	otherparams = otherparams + "TotalInfo"+"^"+this.TotalInfo;

   /**
	*  不可编辑 、可过滤查询、有统计行、有行号、有操作列的标准列表
	*/
	if (this.gridType == 3 && this.gridKind == 101){			
		url = this.filterPath + "&queryType=0";
		url = url + "&InitNum=1";
		url = url + "&selectColNames=" + this.selectColNames;
		url = url + "&sortOnlyCol=" + this.sortonlycol;
		url = url +"&wheres="+this.wheres+"&filterParams=";
		url = url + "&pageStr="+pageStr;
		url = url + "&entityName="+entityName;
		url = url + "&otherparams="+otherparams;
	}		
	//处理服务端接收参数时的中文乱码



	//url = encodeURI(url);		
	//location.href = url;
	createGrid(entityName,0,this.sortonlycol,pageStr,otherparams,this.wheres,"",this.selectColNames);
}

/**
 * 综合处理各种排序
 */
dhtmlXGridObject.prototype.onSort = function(){
	var j=0;
    var tmp1;		 
    var ss;
    var row=0;
    var neatenFilter=true;
    var neatenTotal=true;	
    var neatenNewRow=true;	
    var rowid;
	if (this.gridType == 3 && this.gridKind == 101) {
		  //标准列表
		  if (this.isFilter ==1) {
			for (var i = 0; i < this.rowsCol.length; i++) {
			  tmp1 = this.cells3(this.rowsCol[i], 0).getValue();
			  ss=tmp1.split("^");
			  tmp1=ss[0];			
			  //当过滤行不在第一行时,将其移到第一行              
			  if ((tmp1.indexOf("clearFilter.gif") > 0) ){
				   //alert(this.cells(i,0).getValue());
				   this.selectRow(i);	
				   rowid = this.getRowIndex(this.getSelectedId());					   
				   for (var m=0;m<rowid;m++){
					 this.moveRowUp(this.getSelectedId());
				   }	      
				   this.clearSelection();
				   continue;      
			  }
			  if (isNaN(tmp1)){			  
				  continue;
			  }
			  
			  if (Number(tmp1) == 0)
			  {   
				   
				  continue;
			  }
			  j ++;
			  //重新设置行号
			  this.cells3(this.rowsCol[i], 0).setValue(j+"^"+ss[1]);
			}		
		  }
		 
		  if (this.isTotalRow == 1) {
				row = 0;
				while(neatenTotal){
				   tmp1=this.cells3(this.rowsCol[row], 0).getValue();	
				   ss=tmp1.split("^");
				   tmp1=ss[0];		 
				   if (tmp1.indexOf("clearFilter.gif") > 0) {
					  row ++;
					  continue;
				   }    
				   if ( (isNaN(tmp1)) && (tmp1.search("clearFilter.gif") < 0) )
				   {
					  this.selectRow(row);
					  rowid = this.getRowIndex(this.getSelectedId());					  
					  for (var j=rowid;j<this.getRowsNum() - 1;j++){
						 this.moveRowDown(this.getSelectedId());						
					  }
					  //lock row for editing	      
					  this.lockRow(this.getSelectedId(),true);
					  
					  //clear flag of selecting	      
					  this.clearSelection();
					  
					  neatenTotal = false;
					  
				   }
				   row ++;
				}
				if (this.isItemExists(0) ) {
					this.selectRow(0);
				}
				if (this.isItemExists(1) ) {
					this.selectRow(1);
				}
				this.clearSelection();
			}
	  } else if (this.gridType == 2 && this.gridKind == 104){
		  //主卡片子表	
		  var colVal;
		  var rowid;
		  var row;
		  if (this.isItemExists(0)){
			 row = 0;
		  } else {
			 row = 1;
		  }			 
		  while(neatenNewRow){	
		      //获取行状态列的列值



			  colVal = this.cells(row,this.getColumnCount() - 1).getValue();	
			  //3  代表 新增的未修改的行    始终放到最后一行



			  if (colVal == 3){	
				  this.setSelectedRow(row);				
				  rowid = this.getRowIndex(this.getSelectedId());
				  for (var j=rowid;j<this.getRowsNum() - 1;j++){
					  this.moveRowDown(this.getSelectedId());							  
				  }
				  //this.cells3(this.rowsCol[row],0).setValue(row+'^'+ss[1]);
				  neatenNewRow = false;
			  } else {
				  //this.cells3(this.rowsCol[row], 0).setValue(row+'^'+ss[1]);
			  }
			  row ++;
			  
			  if (row > this.getRowsNum()){
				  break;
			  }
		  }
		 this.clearSelection();	
		 //重新计算行号列



		 for (row = 0;row<this.getRowsNum();row++){
			 tmp1= this.cells3(this.rowsCol[row], 0).getValue();
			 ss=tmp1.split("^")
			 this.cells3(this.rowsCol[row], 0).setValue((row+1)+'^'+ss[1]);
		 }
	  } else if (this.gridType == 1 && this.gridKind == 108){	
		//双列表中的主表			
		  var colVal;
		  var rowid;
		  var row;
		  if (this.getRowsNum() < 1){
			return true;
		  }				  
		  for (row = 0;row<this.getRowsNum();row++){
			 tmp1= this.cells3(this.rowsCol[row], 0).getValue();
			 ss=tmp1.split("^")
			 this.cells3(this.rowsCol[row], 0).setValue((row+1)+'^'+ss[1]);
		  }
	  }
}
/**
 * 设置指定单元格中列值的字体颜色
 *  rowid  行号(从1开始的)
 *  colIndexid  列的索引号(从0开始的)
 *  colorVal (16进制的颜色值  #16进制数)
 */
dhtmlXGridObject.prototype.setCellTextColor = function(rowid,colIndexid,colorVal){ 
   this.cells(rowid,colIndexid).setTextColor(colorVal);
   //如将第三行第七列的字体颜色设置为红色:	
	//this.cells(3,6).setTextColor("red");
	//this.cells(3,6).setTextColor("#a361de");
}
/**
 * 主表行改变时使用该方法调用外部的方法
 */
dhtmlXGridObject.prototype.rowChanged = function(curRowId){
	
	//只处理主表的情况
	if (this.gridType != 1) {
	   return true;
	}
	var priColVal;
	var rowData;
	
	if (this.isFilter == 1){
		curRowId = curRowId -1;
	}
	//alert('this.isFilter:'+this.isFilter+' curRowId:'+curRowId);
	priColVal = this.getPriColVal3(curRowId);
	if (priColVal == null || priColVal == "null"){
	   alert("未能获取当前行的主键列的信息!");
	   return false;
	}
	
	//获取整行数据,不包含特殊列
	rowData = this.getSelectedRowsData(3);
	
	//调用外部的方法,提供子表的查询条件   
	parent.rowChangedToChild(priColVal,this.gridKind,rowData);
}
/**
 * 序列化列表中的初始化数据(包含特殊列),可维护列表使用



 */
dhtmlXGridObject.prototype.serializeInitData = function(){	
   this.initXMLData = this.serialize();
}
/**
 * 装载数据后，对原始数据进行保存(手工录入的列表使用),用于控制行的状态



 */
dhtmlXGridObject.prototype.saveInitData = function(){	
   var colVal="";   
   for (i=0;i<this.getRowsNum();i++){
      for (j=0;j<this.getColumnCount();j++){
		  if (colVal == ""){
			  colVal=this.cells3(this.rowsCol[i],j).getValue();
		  } else {
			  colVal += '@@@'+this.cells3(this.rowsCol[i],j).getValue();
	      }	  
		  
	  }	  
	  this.initDataForRows[i] = colVal;
	  colVal = "";
   }  
}


/**
 * 装载数据后,触发
 */
dhtmlXGridObject.prototype.afterLoad = function(){     
    //保存初始化后的总行数(从服务端所查询的总记录条数)
    this.initRows = this.getRowsNum();	
	
	if (this.initRows < 1){ return true;}
	if (this.isFilter == 1) {
	   if (this.getRowsNum() > 1){
		   //设置指定行(某行中的所有列)的编辑风格



		   for (i=1;i<this.getRowsNum();i++){
		      this.setRowExcellType(i,'ro');
		   }	   
	   }
	  
       //设置过滤行的图片	   
       this.cells2(0,0).setValue(this.imgForFilterRowno);
       
	   //设置指定列(每行中的指定列)的编辑风格



	   this.setColumnExcellType(1,'ch');
	   
	   this.setColumnExcellType(0,'link');//如果某列的编辑类型为link,一定要在此进行设置
	   this.setColumnExcellType(11,'link');
	   
	   //设置指定单元格的编辑属性



       this.setCellExcellType(0,1,'ro');
       this.cells2(0,1).setValue(this.imgForFilterCH);
	 
	   //恢复历史过滤条件
	   //alert('this.historyFilter:'+this.historyFilter);
	   if (this.historyFilter != null) {
		   this.resetFilter();
	   }
	   
	}
    
	//根据列表类型进行相关的处理   
	switch(this.gridKind) { 
	       case 101:
		      //标准列表  锁定各数据，使其不可编辑,只保留过滤行
			  this.isFilter = 1;
		      break;
	       case 102:
              alert("俺媳妇不要我了");
              break;
		   case 103:
		      //不可编辑 、可过滤查询、无统计行、有行号、无操作列的简单列表			   
               for (i=1;i<this.getRowsNum();i++){
                  this.lockRow(i,true);
               }	   
			   this.isFilter = 1;
		       break;
		   case 104:
		      //主卡片子表



		      	
			  //总的记录数



			  var rows = this.getRowsNum();				  
			  var rowNo = rows + 1;	
			  //保存装载之后的初始数据（初始化之后，如果没有数据，则自动插入一空行）



			  if (rows > 0){
				  //this.serializeInitData();
				  this.saveInitData();
			  }
			  //在最后新增数据行并行并进行初始化
			  this.addNewRow();	
			  
		      break;
		   case 108:
		      //双列表主子表中的主表
		      //不使用过滤行
			  this.isFilter = 0;
		      break;
	}
    //针对主表是列表时，控制行改变所调用的方法

    
   
	if (this.gridType == 1 && this.gridKind == 108){
	   //双列表中的主表	
	   this.setOnSelectStateChanged(this.rowChanged);
    }
	
	//设置操作列的列值	
	this.setOpColInfoVal();
	//生成统计行

	if (this.isTotalRow == 1){
	   this.genTotalRow();
	}
	
	
	//说明已经成功装载数据
	this.isDataLoaded = true;
	
}
/**
 * 删除统计行



 */
dhtmlXGridObject.prototype.deleteTotalRow = function(){	
    //获取统计行的table
	var _footer = document.getElementById(this.countDIV.id);	
	//删除统计行	
	for (i=0;i<=_footer.rows.length;i++){		
	   _footer.deleteRow(1);
    }
	
}
/**
 * 计算指定各行中指定列的列值之和,形成小计信息 
 */
dhtmlXGridObject.prototype.genTotalPage = function(colindex){
	var colVal = 0;
	var tmp;
	for (row=1;row<this.getRowsNum();row++){
		tmp = this.cells(row,colindex).getValue();
		if (tmp == null) {
		   continue;
		}
		colVal += parseFloat(tmp);
	}
	return colVal;
}
/**
 * 生成统计行



 */
dhtmlXGridObject.prototype.genTotalRow = function(){
   var totalStr="";
   //生成小计行



   for (i=1;i<this.colTotalValue.length;i++){
	   if (totalStr=="") {
		  totalStr += "小计,#cspan";
	   } else {		 
		  if ( Math.abs(Number(this.colTotalValue[i])) >0 ){		      
			  totalStr += ","+"<div id='"+this.colsName[i]+"'>"+this.genTotalPage(i).toString()+"</div>";
		  } else {			  
			  totalStr += ",";
		  }		    
	   }
   }
   if (totalStr.indexOf('</div>') >  0) {	   
      this.attachFooter(totalStr,["text-align:left;"]);
   }
   totalStr = "";
   //生成合计行



   for (i=1;i<this.colTotalValue.length;i++){
	   if (totalStr=="") {
		  totalStr += "合计,#cspan";
	   } else {		 
		  if ( Math.abs(Number(this.colTotalValue[i])) >0 ){		      
			  totalStr += ","+"<div id='"+this.colsName[i]+"'>"+this.colTotalValue[i].toString()+"</div>";
		  } else {			  
			  totalStr += ",";
		  }		    
	   }
   }   
   if (totalStr.indexOf('</div>') >  0) {	   
	   this.attachFooter(totalStr,["text-align:left;"]);
   }
}
/**
 * 对序列化的数据进行整理，删除没有修改的记录



 */
dhtmlXGridObject.prototype.adjustXMLStr = function(xmldata){
	var rowStatus;
	var rowNo;
	var xmldatatmp = "",oldxmldata="";
	var rowplace1,rowplace2;
	var splace,eplace;
	newxmldata = xmldata;
	for(row=1;row<=this.getRowsNum();row++){
		rowStatus = this.cells(row,this.getColumnCount() - 1).getValue();			
		if (rowStatus == 2 || rowStatus == 4) {				
			splace = "<row "+"id='"+row+"'";
			eplace = 'row>';
			rowplace1 = newxmldata.indexOf(splace);
			rowplace2 = newxmldata.indexOf(eplace,rowplace1);			
			xmldatatmp += newxmldata.substring(rowplace1,rowplace2 + 4);
		}
	}	
	xmldatatmp = '<?xml version="1.0"?><rows>'+xmldatatmp+'</rows>'
	return xmldatatmp;
}


/**
 *  序列化列表中的正常数据(不包含特殊列)
 */
dhtmlXGridObject.prototype.serializeGrid = function(){	
	var xmlStr = "";
	var isSerialize;	
	//进行序列化时列的选择
	for (i=0;i<this.colsName.length;i++){
		if (this.colsName[i] == "rowno" || this.colsName[i] == "selCheckBox" || this.colsName[i] == "opButton" || this.colsName[i] == "rowStatus" ){
			         if (isSerialize == null || isSerialize == "") {
	                     isSerialize = 'false';
					 } else {
						 isSerialize += ','+'false';
					 }
	    } else {			
			if (isSerialize == null || isSerialize == "") {
				 isSerialize = 'true';
			 } else {
				 isSerialize += ','+'true';
			 }
		}
	}	
	this.setSerializableColumns(isSerialize);
	xmlStr = this.serialize();
	xmlStr = this.adjustXMLStr(xmlStr);
	return xmlStr;
}
/**
 * 生成每个正常列的定义信息(列名^列中文名^Hibernate数据类型),各列之间使用@@@间隔
 */
dhtmlXGridObject.prototype.genHeaderCols = function(){	
   var colTiles;
   for (i=0;i<this.colsName.length;i++){
		if (this.colsName[i] == "rowno" || this.colsName[i] == "selCheckBox" || this.colsName[i] == "opButton" || this.colsName[i] == "rowStatus" ){
			       
	    } else {
			if (colTiles == "" || colTiles == null){
				colTiles = this.colsName[i]+'^'+this.getHeaderCol(i)+'^'+this.hibdatatype[i];
			} else {
				colTiles += '@@@'+this.colsName[i]+'^'+this.getHeaderCol(i)+'^'+this.hibdatatype[i];
			}		
		}
	}
	return colTiles;
}
/**
 * 拖动列之后,调整扩展的各个数组的元素值



 */
dhtmlXGridObject.prototype.adjustParams = function(movecolinxid,newcolinxid){
	//循环的次数



	var num = Number(newcolinxid) - Number(movecolinxid);
	var newplace = newcolinxid;
	var oldplace = movecolinxid;
	var dragway = 0;
    var fornum = 0;	
	var arrColsName = new Array(0);
	var arrColIsPrimary = new Array(0);
	var arrColIsUpdate = new Array(0);
	var arrColIsVisible = new Array(0);
	var arrHibdatatype = new Array(0);
	var arrFilterRules = new Array(0);
	var arrFilterData = new Array(0);
	var arrListBox = new Array(0);
	var arrListBoxSrc = new Array(0);
	var arrInitdata = new Array(0);
	var arrColsDisplayFormat = new Array(0);
	var arrColTotalValue = new Array(0);
	var arrColValByListInfo = new Array(0);
	var arrRefClassName = new Array(0);
	var arrRefName = new Array(0);
	
	//保存原来的列表属性数组中的元素顺序



	for (j=0;j<this.colsName.length;j++){
		arrColsName[j] = this.colsName[j];
		arrColIsPrimary[j] = this.colIsPrimary[j];
		arrColIsUpdate[j] = this.colIsUpdate[j];
		arrColIsVisible[j] = this.colIsVisible[j];
		arrHibdatatype[j] = this.hibdatatype[j];
		arrFilterRules[j] = this.filterRules[j];
		arrFilterData[j] = this.filterData[j];
		arrListBox[j] = this.listBox[j];
		arrListBoxSrc[j] = this.listBoxSrc[j];
		arrInitdata[j] = this.initdata[j];
		arrColsDisplayFormat[j] = this.colsDisplayFormat[j];
		arrColTotalValue[j] = this.colTotalValue[j];
		arrColValByListInfo[j] = this.colValByListInfo[j];
		arrRefClassName[j] = this.refClassName[j];
		arrRefName[j] = this.refName[j];
	}
	
	//判断拖动方向
	if (num > 0) {
		//向右拖动
		dragway = 1;
	} else {
		//向左拖动
		dragway = -1;
	}
	num = Math.abs(num);
	fornum = num;
	//交换数组元素的数据



	while(num>=0){		
		if (dragway == 1){
			/****************向右拖动*******************/
			//列名
			if (num == fornum){				
				this.colsName[newplace] = this.colsName[movecolinxid];
			} else {				
				this.colsName[newplace] = arrColsName[newplace+1];	            
			}			
			//对应列是否是主键			
			if (num == fornum){				
				this.colIsPrimary[newplace] = this.colIsPrimary[movecolinxid];
			} else {				
				this.colIsPrimary[newplace] = arrColIsPrimary[newplace+1];	            
			}
			//对应的列是否可编辑



			if (num == fornum){				
				this.colIsUpdate[newplace] = this.colIsUpdate[movecolinxid];
			} else {				
				this.colIsUpdate[newplace] = arrColIsUpdate[newplace+1];	            
			}
			//对应的列是否显示
			if (num == fornum){				
				this.colIsVisible[newplace] = this.colIsVisible[movecolinxid];
			} else {				
				this.colIsVisible[newplace] = arrColIsVisible[newplace+1];	            
			}
			//列的hibernate数据类型		
			if (num == fornum){				
				this.hibdatatype[newplace] = this.hibdatatype[movecolinxid];
			} else {				
				this.hibdatatype[newplace] = arrHibdatatype[newplace+1];	            
			}
			//列的过滤规则(逻辑运算符)			
			if (num == fornum){				
				this.filterRules[newplace] = this.filterRules[movecolinxid];
			} else {				
				this.filterRules[newplace] = arrFilterRules[newplace+1];	            
			}
			//过滤行中的所录入的各列的过滤条件
			if (num == fornum){				
				this.filterData[newplace] = this.filterData[movecolinxid];
			} else {				
				this.filterData[newplace] = arrFilterData[newplace+1];	            
			}
			//下拉列表框类型



			if (num == fornum){				
				this.listBox[newplace] = this.listBox[movecolinxid];
			} else {				
				this.listBox[newplace] = arrListBox[newplace+1];	            
			}
			//下拉列表框数据源			
			if (num == fornum){				
				this.listBoxSrc[newplace] = this.listBoxSrc[movecolinxid];
			} else {				
				this.listBoxSrc[newplace] = arrListBoxSrc[newplace+1];	            
			}
			//列的初始值,同时用于判断是否为空			
			if (num == fornum){				
				this.initdata[newplace] = this.initdata[movecolinxid];
			} else {				
				this.initdata[newplace] = arrInitdata[newplace+1];	            
			}
			//设置列的显示风格0,0000   yyyy-MM-dd hh:mm:ss
			if (num == fornum){				
				this.colsDisplayFormat[newplace] = this.colsDisplayFormat[movecolinxid];
			} else {				
				this.colsDisplayFormat[newplace] = arrColsDisplayFormat[newplace+1];	            
			}
			//列的统计值



			if (num == fornum){				
				this.colTotalValue[newplace] = this.colTotalValue[movecolinxid];
			} else {				
				this.colTotalValue[newplace] = arrColTotalValue[newplace+1];	            
			}
			//设置下拉列表框所回填的列的列名



			if (num == fornum){				
				this.colValByListInfo[newplace] = this.colValByListInfo[movecolinxid];
			} else {				
				this.colValByListInfo[newplace] = arrColValByListInfo[newplace+1];	            
			}
			
			//关联关系类名
			if (num == fornum){				
				this.refClassName[newplace] = this.refClassName[movecolinxid];
			} else {				
				this.refClassName[newplace] = arrRefClassName[newplace+1];	            
			}
			//关联关系属性名
			if (num == fornum){				
				this.refName[newplace] = this.refName[movecolinxid];
			} else {				
				this.refName[newplace] = arrRefName[newplace+1];	            
			}
			newplace = newplace - 1;
			
		} else if(dragway == -1){
		   //列名
		   if (num == fornum){				
			  this.colsName[newplace] = this.colsName[movecolinxid];
		   } else {				
			  this.colsName[newplace] = arrColsName[newplace - 1];	            
		   }		
		   //对应列是否是主键			
			if (num == fornum){				
				this.colIsPrimary[newplace] = this.colIsPrimary[movecolinxid];
			} else {				
				this.colIsPrimary[newplace] = arrColIsPrimary[newplace - 1];       
			}
			//对应的列是否可编辑



			if (num == fornum){				
				this.colIsUpdate[newplace] = this.colIsUpdate[movecolinxid];
			} else {				
				this.colIsUpdate[newplace] = arrColIsUpdate[newplace - 1];	            
			}
			//对应的列是否显示
			if (num == fornum){				
				this.colIsVisible[newplace] = this.colIsVisible[movecolinxid];
			} else {				
				this.colIsVisible[newplace] = arrColIsVisible[newplace - 1];	            
			}
			//列的hibernate数据类型		
			if (num == fornum){				
				this.hibdatatype[newplace] = this.hibdatatype[movecolinxid];
			} else {				
				this.hibdatatype[newplace] = arrHibdatatype[newplace - 1];	            
			}
			//列的过滤规则(逻辑运算符)			
			if (num == fornum){				
				this.filterRules[newplace] = this.filterRules[movecolinxid];
			} else {				
				this.filterRules[newplace] = arrFilterRules[newplace - 1];	            
			}
			//过滤行中的所录入的各列的过滤条件
			if (num == fornum){				
				this.filterData[newplace] = this.filterData[movecolinxid];
			} else {				
				this.filterData[newplace] = arrFilterData[newplace - 1];	            
			}
			//下拉列表框类型



			if (num == fornum){				
				this.listBox[newplace] = this.listBox[movecolinxid];
			} else {				
				this.listBox[newplace] = arrListBox[newplace - 1];	            
			}
			//下拉列表框数据源			
			if (num == fornum){				
				this.listBoxSrc[newplace] = this.listBoxSrc[movecolinxid];
			} else {				
				this.listBoxSrc[newplace] = arrListBoxSrc[newplace - 1];	            
			}
			//列的初始值,同时用于判断是否为空			
			if (num == fornum){				
				this.initdata[newplace] = this.initdata[movecolinxid];
			} else {				
				this.initdata[newplace] = arrInitdata[newplace - 1];	            
			}
			//设置列的显示风格0,0000   yyyy-MM-dd hh:mm:ss
			if (num == fornum){				
				this.colsDisplayFormat[newplace] = this.colsDisplayFormat[movecolinxid];
			} else {				
				this.colsDisplayFormat[newplace] = arrColsDisplayFormat[newplace - 1];	            
			}
		    //列的统计值



			if (num == fornum){				
				this.colTotalValue[newplace] = this.colTotalValue[movecolinxid];
			} else {				
				this.colTotalValue[newplace] = arrColTotalValue[newplace - 1];	            
			}
			//设置下拉列表框所回填的列的列名



			if (num == fornum){				
				this.colValByListInfo[newplace] = this.colValByListInfo[movecolinxid];
			} else {				
				this.colValByListInfo[newplace] = arrColValByListInfo[newplace - 1];	            
			}
			//关联关系类名
			if (num == fornum){				
				this.refClassName[newplace] = this.refClassName[movecolinxid];
			} else {				
				this.refClassName[newplace] = arrRefClassName[newplace - 1];	            
			}
			//关联关系属性名
			if (num == fornum){				
				this.refName[newplace] = this.refName[movecolinxid];
			} else {				
				this.refName[newplace] = arrRefName[newplace - 1];	            
			}
		    newplace = newplace + 1;
		}
		num = num -1;
	}
}

/**
 * 列拖动之前触发



 */
dhtmlXGridObject.prototype.beforeDragCol = function(movecolinxid,newcolinxid){	
	//alert("beforeDragCol:"+movecolinxid+' 到 '+newcolinxid);	
	
}

/**
 * 拖动列之后触发



 */
dhtmlXGridObject.prototype.afterDragCol = function(movecolinxid,newcolinxid){	
	var execSomes = 0;
    //alert("afterDragCol:"+movecolinxid+' 到 '+newcolinxid);
	this.dragColSomes = this.dragColSomes + 1;
	//取余,因为拖动列之后，竟然执行了两次afterDragCol,而第二次才是真实的



	execSomes = this.dragColSomes % 2;
	if (execSomes != 0){
		return true;
	}
	
	//拖动列之后,调整扩展的各个数组的元素值	
	this.adjustParams(movecolinxid,newcolinxid);		
	//删除统计行



	this.deleteTotalRow();
	//重新生成统计行



	this.genTotalRow();
	
}
 /**
  * 外部接口,保存成功后调用



  * updateType: 0 保存失败  1 新增  2 修改  3 删除
  * errMessage: 提示信息
  */
dhtmlXGridObject.prototype.afterUpdate= function(updateType,message){
	var otherparams;
	var entityName;
	switch (updateType){
         case 0:
            alert(message);            
            return false;
            break;
         case 1:
            break;
         case 2:
            break;
         case 3:            
            //删除选择的记录



            this.deleteSelectedItem();
            break;
     }
     alert(message);
     //刷新页面
         /*location.href = "<%=request.getContextPath()%><%=queryPath%>" + "&queryType=0" + "&selectColNames="+ selectColNames + "&pageStr=&InitNum=1" + "&filterParams=&wheres=" + "<%=refid%>" +"&domainName=<%=domainName%>&otherparams="+tStr;*/
		
     otherparams = this.genOtherparams();
	 //设置持久化类名称
	 if (this.entityName == "" || this.entityName == null){			
	 } else {
		entityName = this.entityName;
	 }		
	 createGrid(entityName,0,"","",otherparams,this.wheres,"",this.selectColNames);
	 
}

/**
 * 设置指定列的值,下拉列表中使用



 *  rowid:下拉列表对应的行
 *  colIndexid: 下拉列表对应的列
 *  colsvalue:  列值串(下拉列表框所在的列的列值^列值2)
 *  目前只支持回填两列



 */
dhtmlXGridObject.prototype.setColumnValueByListBox = function(rowid,colIndexid,colsvalue){
	//第一个元素为当前列的列值



	var colvalues = colsvalue.split('^');
	//获取当前列所对应的下拉列表回填的列信息



	var currListInfo = this.colValByListInfo[colIndexid].split(',');
	
	//回填第二列的信息
	for (i=0;i<this.colsName.length;i++){
		if (currListInfo[1] == this.colsName[i]) {
			this.cells(rowid,i).setValue(colvalues[1]);
		}
	}
	//回填当前列的列值



	this.cells(rowid,colIndexid).setValue(colvalues[0]);
}

/**
 * 成批设置选择的行中的多个列的列值



 * colsvalue:colname1^colvalue1###colname2^colvalue2
 */
dhtmlXGridObject.prototype.setColumnValueByEXForm = function(colsvalue){
	var rowid = this.getSelectedId();
	if (rowid < 1){
		return false;
	}
	var arrColsValue = colsvalue.split('###');
	var arrColValue;
	for (i=0;i<arrColsValue.length;i++){
		arrColValue = arrColsValue[i].split('^');
		for (j=0;j<this.colsName.length;j++){
			if (this.colsName[j] == arrColValue[0]){
				this.cells(rowid,j).setValue(arrColValue[1]);
			}
		}
	}
}
/**
 * 对隐藏列之后的处理



 */
dhtmlXGridObject.prototype.afterHiddenCol = function(){
	var columnAutoSize = "";	
	for (i=0;i<this.colIsVisible.length;i++){
		if (this.colIsVisible[i] == 0){
			//将指定的列隐藏



			this.setColumnHidden(i,true);
			if (columnAutoSize == ""){
				columnAutoSize = false;
			} else {
				columnAutoSize += ','+false;
			}
		} else {
			if (columnAutoSize == ""){
				columnAutoSize = true;
			} else {
				columnAutoSize += ','+true;
			}
		}
	}
	//自动调整每个显示列的宽度
	this.enableColumnAutoSize(columnAutoSize);
}
/**
 * 初始化列表之后,调用该方法



 */
dhtmlXGridObject.prototype.exAfterInit = function(){
	//对隐藏列之后进行处理
	this.afterHiddenCol();
}

/**
 * 根据用户的录入,改变行的状态,对于数据库已有的数据(主要是控制修改时的状态)
 * rowid 行号
 * colid 列索引号
 * oldstatus  当前状态



 * primaryColVal 当前行的主键信息(列名^列的索引号^列值@@@列名^列的索引号^列值)
 */
dhtmlXGridObject.prototype.changeExRowStatus = function(rowid,colid,oldstatus,primaryColVal){	 
     //alert(rowid+'  '+colid+'  '+oldstatus+'  '+primaryColVal);
	 var colName = "",colIndex ="",colVal="";    
     var arrPriInfo,arrPriPer;
     var newstatus = 0;
     var isExists = true;
     var currColVal;
	 var arrRows,arrCells;
	 var arrPrivalPer;
	 var colInx=0,colNum=0;
	 //初始化新的行状态值



	 switch(Number(oldstatus)){
	   case 1:
		 newstatus = 1;
		 break;
	   case 2:
		 newstatus = 1;
		 break;
	   case 3:
		 newstatus = 3;
		 break;
	   case 4:
		 newstatus = 3;
		 break;
	   default:
		 return oldstatus;
		 break;
	}
	//分析主键信息(支持组合主键)
	arrPriInfo = primaryColVal.split("@@@");
	for (i=0;i<arrPriInfo.length;i++){
	   arrPriPer = arrPriInfo[i].split("^");
	   for (j=0;j<arrPriPer.length;j++){
		  switch (j){
			 case 0:
			    //列名
				if (colName == ""){
				   colName += arrPriPer[j];
				} else {
				   colName += "^"+arrPriPer[j];
				}
				break;
			 case 1:
				//列的索引号



				for(n=0;n<this.colsNameBak.length;n++){
					if (this.colsNameBak[n] == arrPriPer[j - 1]){
						if (colIndex == ""){
						   colIndex += n;
						} else {
						   colIndex += "^"+n;
						}
					}
				}
				break;
			 case 2:
			    //主键列的列值



				if (colVal == ""){
				   colVal += arrPriPer[j];
				} else {
				   colVal += "^"+arrPriPer[j];
				}
				break;
			default:
			    return oldstatus;
			    break;
		  }
	   }
	}
	
	//扫描每行的数据,找出主键值所在的行的行号(即数组的元素号)
	arrPrivalPer = colVal.split('^');  //拆分主键列的列值



	colIndexBak = colIndex.split("^");    //拆分主键列所在的索引号



	for (i=0;i<this.initDataForRows.length;i++){
		arrRows = this.initDataForRows[i].split('@@@');//获取指定行所在的各列的值



		//在每一行中查找主键列(支持组合主键)		
		for (j=0;j<arrPrivalPer.length;j++){				
			if (arrRows[colIndexBak] != arrPrivalPer[j]){
			   isExists = false;
			}		
		}	
		if (isExists == true){		
		   rowbak = i;
		   break;
		}
		isExists = true;
	}
	
	//判断是否有辅助选择列,来确定循环变量的起始值



	if (this.isSelCheckBox == 1) {
		colInx = 2;
	} else {
		colInx = 1;
	}
	//判断是否有操作列,来确定循环变量的终止值



	if (this.isOperater == 1){
		colNum = this.getColumnCount() - 2;
	} else {
		colNum = this.getColumnCount() - 1;
	}
	//将当前行的数据与备份数据中的各列的值进行比较



	arrRows = this.initDataForRows[rowbak].split('@@@');
	if (Number(oldstatus) == 1 || Number(oldstatus) == 2){   
		isExists = false;       
	   //对查询的数据控制
		while (colInx < colNum){
		   try{                         
			  colValBak = arrRows[colInx].replace("[\\n\\r]*","");
			  currColVal = this.cells3(this.rowsCol[rowid - 1],colInx).getValue().replace("[\\n\\r]*","");  
			  //alert(currColVal+'   '+colValBak);			   
			  if (colValBak != currColVal) {
				 //将正常状态改为已修改  				 
				 switch(Number(oldstatus)){
					   case 1:
						 newstatus = 2;
						 break;
					   case 2:
						 newstatus = 2;
						 break;
				 }
				 isExists = true;
			  } 
		   }catch(e){
			  alert(e);
		   }
		   colInx ++;          
		   currColVal = "";
		}
	   
	   if (isExists = false){
		  newstatus = 1;
	   }
								   
	   //获取判断后的状态



		this.cells3(this.rowsCol[rowid - 1],this.getColumnCount() - 1).setValue(newstatus);
	 } else {
		//对新增的数据控制
		//将正常状态改为已修改  
		this.changeRowStatus(rowid,colid,oldstatus);
	 }
	return newstatus;
}
/*
 * 取得单元格(对象)的位置



 */
dhtmlXGridObject.prototype.getObjPosition = function(obj) {
   var objLeft = obj.offsetLeft;
   //var objTop = obj.scrollHeight + obj.clientHeight + obj.offsetHeight + obj.scrollTop;
   var objTop =  obj.clientHeight + obj.offsetHeight;
   var objParent = obj.offsetParent;
   while (objParent.tagName != "BODY") {
	  objLeft += objParent.offsetLeft;
	  objTop +=  obj.clientHeight + obj.offsetHeight;
	  objParent = objParent.offsetParent;
  }
  return([objLeft,objTop]);
}
/**
 * 弹出模态对话框,选择日期
 */
dhtmlXGridObject.prototype.genComDateVal = function(rowid,colid) {
	//模态窗口中打开的页面



	var windowUrl = this.contextPath + "/script/tag/grid/calendar/comQueryDate.jsp";
	//获取单元格



	var currCell = this.getRowById(rowid).childNodes[colid];
	var obj;
	var width = 240;
	var height = 140;
	//取得单元格在页面的坐标(x,y);
	var xy = this.getObjPosition(currCell);
	var pixelLeft = xy[0];
	var pixelTop = xy[1]+currCell.offsetHeight;
	//alert(pixelLeft+'  '+pixelTop);
	var returnVal;
	returnVal = window.showModalDialog(windowUrl,obj,'dialogwidth:' + width + 'px;dialogtop:'+pixelTop+'px;dialogheight:' + height + 'px;dialogleft:'+pixelLeft+'px;status:no;help:no;scroll:no;resizable:yes');
	//alert(returnVal);
	if (returnVal == 'Nullity'){
		return false;
	}
    switch (this.gridKind){
		case 101:
		   //对于过滤行中的单元格,要同时设置其对应的过滤规则



		   this.cells(rowid,colid).setValue(returnVal);
		   this.filterRules[colid] = 2;
		   break;
		default:
		   break;
    }
}
/**
 * 通过其它控件编辑指定的单元格
 */
dhtmlXGridObject.prototype.editCellByOtherObj = function(rowid,colid){
	switch (this.gridKind){
		case 101:
		   //只允许在第一行(过滤行)进行操作
		   if (rowid >= 1) {
			   return false;
		   }
		   break;
		default:
		   break;
    }
	switch (Number(this.listBox[colid])){
		case 7:
		   //组合查询日期(在同一列值及有开始日期又有终止日期,主要用于过滤条件)
		   this.genComDateVal(rowid,colid);
		  
		   break;
		case 8:
		   //弹出包含列表的模态对话框
		   break;
		case 9:
		   //弹出包含树的模态对话框
		   break;
		default:
		   break;
	}
	
}

