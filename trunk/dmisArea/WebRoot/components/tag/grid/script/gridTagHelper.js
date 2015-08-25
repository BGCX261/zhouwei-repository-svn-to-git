// JavaScript Document
/**======================================
*
 * 	Grid相关辅助类
 * 
 *  @author MaJian  2007-3-5
 *
 *=======================================*/
 
 function gridTagHelper(id,width,height,isDisplaySet,isQuerySet,isOutputSet,isStatSet,path,pagePath,isCheckBox){
	 if (typeof (id) != "object") {
		this.divId = document.getElementById(id);
		this.gridId= id;
	 } else {
		this.divId = id;
	 }
	 this.modelPath  = path;
	 this.gridWidth  = width;
	 this.gridHeight = height;
	 this.displaySet = isDisplaySet;
	 this.querySet   = isQuerySet;
	 this.outputSet  = isOutputSet;
	 this.statSet    = isStatSet;
	 this.checkBox   = isCheckBox;
	 return this;
 }
 
 /**
  * 得到输出的HTML字串
  */
 gridTagHelper.prototype.getHtmlStr = function(){
	 if(this.divId){
		var htmlStr  = "";
			htmlStr += this.getAffixInfo();
			htmlStr += this.getGridDiv();
			htmlStr += this.getOtherDiv();
		//alert(this.divId.innerHTML);
		this.divId.innerHTML = htmlStr;
		//alert(this.divId.innerHTML);
	 }
 }
 
 /**
  * --输出打开模态对话框的链接--
  * 1. 显示设置
  * 2. 高级查询
  * 3. 保存查询
  * 4. 导出
  */
 gridTagHelper.prototype.getAffixInfo = function(){
	 var info	 = "";
	 
	 if((this.displaySet && this.displaySet != 'null' && this.displaySet != 'undefined' && this.displaySet != 0) 
			|| (this.querySet && this.querySet !='null' && this.querySet != 'undefined'  && this.querySet != 0)
			|| (this.outputSet && this.outputSet !='null' && this.outputSet != 'undefined' && this.outputSet != 0)
			|| (this.statSet && this.statSet !='null' && this.statSet != 'undefined' && this.statSet != 0)){
	 	 info   += "<table align='left' width='100%'>";
		 info	+= "		<tr>";
		 info	+= "			<td>";
		 info	+= "				<table align='left' border='0' cellpadding='0' cellspacing='0'>";
		 info	+= "					<tr>";
		 info	+= "						<td width='11'>&nbsp;</td>";
		 if(this.displaySet && this.displaySet != 'null' && this.displaySet != 'undefined' && this.displaySet != 0){
		 info	+= "						<td width='17' class='img1'>&nbsp;</td>";
		 info	+= "						<td width='59'>";
		 info	+= "							<span class='hand' onClick=showWindowDisplay('"+this.modelPath+"displaysetup.jsp')>显示设置</span>";
		 info	+= "						</td>";
		 }
		 if(this.querySet && this.querySet != 'null' && this.querySet != 'undefined'  && this.querySet != 0){
		 info	+= "						<td width='18' class='img2'>&nbsp;</td>"; 
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onClick=showWindowSearch('"+this.modelPath+"searchsetup.jsp')>高级查询</span>";
		 info	+= "						</td>";
		 info	+= "						<td width='19' class='img3'>&nbsp;</td>";
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onClick=showWindowSaveSearch('"+this.modelPath+"searchsave.jsp')>保存查询</span>";
		 info	+= "						</td>";
		 }
		 if(this.outputSet && this.outputSet != 'null' && this.outputSet != 'undefined' && this.outputSet != 0){
		 info	+= "						<td width='18' class='img4'>&nbsp;</td>";
		 info	+= "						<td width='35'>";
		 info	+= "							<span class='hand' onClick=showWinForExp('"+this.modelPath+"exportExcel.jsp')>导出</span>";
		 info	+= "						</td>";
		 }
		 if(this.statSet && this.statSet != 'null' && this.statSet != 'undefined' && this.statSet != 0){
		 info	+= "						<td width='19' class='img4'>&nbsp;</td>";
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onclick=showWinForExp('"+this.modelPath+"exportExcel.jsp')>综合统计</span>";
		 info   += "						</td>";
		 }
		 info   += "					</tr>";
		 info   += "				</table>";
		 info   += "			</td>";
		 info   += "		</tr>";
		 info   += "	</table>";
		 info   += "<br>";
		 info   += "<br>";
	 }
	 return info;
 }
 
 /**
  *  --得到列表对应Table代码块--
  */
 gridTagHelper.prototype.getGridDiv = function(){
	 
	var divStr 	= "<table width='"+this.gridWidth+"' height='"+this.gridHeight+"'>";
		divStr += "		<tr>";
		divStr += "			<td>";
		divStr += "				<div id='"+this.gridId+"OfGrid' width='100%' height='100%' style='background-color:white'>";
		divStr += "				</div>";
		divStr += "			</td>";
		divStr += "		</tr>";
		divStr += "</table>";
	 return divStr;
 }
 
 
 
 /**
  *  得到多选对应代码块
  */
  gridTagHelper.prototype.getOtherDiv = function(){
  	var divStr 	= '';
  	if(this.checkBox && this.checkBox != 'null' && this.checkBox != 'undefined' && this.checkBox != 0){
  		//divStr += '<table id="datasheet2" cellspacing="0" cellpadding="5">';
		//divStr += '	<tr>';
		//divStr += '			<td width="100" align="left">';
		divStr += '				<input type="checkbox" name="RadioGroup" id="RadioGroup" value="多选" onClick="MuliSelectMode()">&nbsp;&nbsp;&nbsp;允许多选&nbsp;&nbsp;&nbsp;&nbsp;';
		//divStr += '			</td>';
		//divStr += '	 </tr>';
		//divStr += '</table>';
  	}
	 return divStr;
  }
  
  /**
   * 设置多选框
   */
  function MuliSelectMode(){
  	if(mygrid){
  		if(mygrid.colIsVisible[1] == 0){
  			mygrid.colIsVisible[1] = 1;
  			mygrid.setColumnHidden(1,false);
  		} else if(mygrid.colIsVisible[1] == 1){
  			mygrid.colIsVisible[1] = 0;
  			mygrid.setColumnHidden(1,true);
  		}
  	} 
  }
 
 /**
 *  --服务器基础路径--
 */
gridTagHelper.prototype.getContextPath = function(){
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

//===============================================================================================//
// 打开模态对话框
// 1. 显示设置
// 2. 高级查询
// 3. 保存查询
// 4. 导出
//===============================================================================================//
		/**
		*  打开显示设置Modal
		*/
		function showWindowDisplay(path)
		{
			var param = new Object();
			param.queryPath 		= document.all.queryPath.value;
			param.colName   		= document.all.colName.value;
			param.visible			= document.all.visible.value;
			param.displayName 		= document.all.displayName.value;
			param.width 			= document.all.width.value;
			param.isPrimary 		= document.all.isPrimary.value;
			
			param.foldMode 		= document.all.foldMode.value;
			param.multipMode 	= document.all.multipMode.value;
			param.changeColor 	= document.all.changeColor.value;
			param.selectMode 	= document.all.selectMode.value;
			param.lockColumn 	= document.all.lockColumn.value;
			param.pageSelect 	= document.all.pageSelect.value;
			
			param.busName 		= document.all.busName.value;
			param.subName 		= document.all.subName.value;
			param.userSign      = document.all.userSign.value;
	
			vReturnValue = showModalDialogYY(path,"550","400",param,"显示设置","auto");
			
			if(vReturnValue != null)
			{
				var returnType	= vReturnValue.type;
				var currPage    = document.all.currPage.value;
				
				var pageStr = currPage+"^"+document.all.pageDefault.value;
				createGrid('','0','',pageStr,'','','','');	
			}
		}
		/**
		*  打开高级查询Modal
		*/
		function showWindowSearch(path)
		{
			var param = new Object();
			param.queryPath 		= document.all.queryPath.value;
			param.colName   		= document.all.colName.value;
			param.displayName 		= document.all.displayName.value;
			param.displayFormat  	= document.all.displayFormat.value;
			param.colType        	= document.all.colType.value;
			param.editType   		= document.all.editType.value;
			param.sortType 			= document.all.sortType.value;
			param.colSortStr 		= document.all.colSortStr.value;
			param.width 			= document.all.width.value;
			param.colAlign     		= document.all.colAlign.value;
			param.listBox			= document.all.listBox.value;
			param.listBoxSrc		= document.all.listBoxSrc.value;
			
			param.busName 		= document.all.busName.value;
			param.subName 		= document.all.subName.value;
			param.userSign      = document.all.userSign.value;
			
			vReturnValue = showModalDialogYY(path,"800","500",param,"高级查询","auto");
			
			if(vReturnValue != null)
			{	
				var title 			= vReturnValue.title;
				var type			= vReturnValue.type;
				var queryStr 		= vReturnValue.queryStr;
				var childStr		= vReturnValue.childStr;
				document.all.childStr.value = childStr;
				var pageStr = "1^"+document.all.pageDefault.value;
				createGrid('','0','',pageStr,'',queryStr,'','');
			}
		}
		/*
		*  保存高级查询条件
		*/
		function showWindowSaveSearch(path)
		{
			var param = new Object();
				param.wheres = document.all.childStr.value;
				
				param.busName 		= document.all.busName.value;
				param.subName 		= document.all.subName.value;
				param.userSign      = document.all.userSign.value;
			
			vReturnValue = showModalDialogYY(path,"300","200",param,"高级查询条件","no");
			
			if(vReturnValue != null){	
			}
		}
//===============================================================================================//		
