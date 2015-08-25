// JavaScript Document
/**======================================
*
 * 	Grid相关辅助类
 * 
 *  @author MaJian  2007-3-5
 *
 *=======================================*/
 
 function gridTagHelper(id,width,height,isDisplaySet,isQuerySet,isOutputSet,isStatSet){
	 if (typeof (id) != "object") {
		this.divId = document.getElementById(id);
		this.gridId= id;
	 } else {
		this.divId = id;
	 }
	 this.gridWidth  = width;
	 this.gridHeight = height;
	 this.displaySet = isDisplaySet;
	 this.querySet   = isQuerySet;
	 this.outputSet  = isOutputSet;
	 this.statSet    = isStatSet;
	 return this;
 }
 
 gridTagHelper.prototype.getHtmlStr = function(){
	 if(this.divId){
		var htmlStr  = "";
			htmlStr += this.getAffixInfo();
			htmlStr += this.getGridDiv();
		//alert(this.divId.innerHTML);
		this.divId.innerHTML = htmlStr;
		//alert(this.divId.innerHTML);
	 }
 }
 
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
		 info	+= "							<span class='hand' onClick=showWindowDisplay('/components/tag/grid/common/displaysetup.jsp')>显示设置</span>";
		 info	+= "						</td>";
		 }
		 if(this.querySet && this.querySet != 'null' && this.querySet != 'undefined'  && this.querySet != 0){
		 info	+= "						<td width='18' class='img2'>&nbsp;</td>"; 
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onClick=showWindowSearch('/components/tag/grid/common/searchsetup.jsp')>高级查询</span>";
		 info	+= "						</td>";
		 info	+= "						<td width='19' class='img3'>&nbsp;</td>";
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onClick=showWindowSaveSearch('/components/tag/grid/common/searchsave.jsp')>保存查询</span>";
		 info	+= "						</td>";
		 }
		 if(this.outputSet && this.outputSet != 'null' && this.outputSet != 'undefined' && this.outputSet != 0){
		 info	+= "						<td width='18' class='img4'>&nbsp;</td>";
		 info	+= "						<td width='35'>";
		 info	+= "							<span class='hand' onClick=showWinForExp('/components/tag/grid/common/exportExcel.jsp')>导出</span>";
		 info	+= "						</td>";
		 }
		 if(this.statSet && this.statSet != 'null' && this.statSet != 'undefined' && this.statSet != 0){
		 info	+= "						<td width='19' class='img4'>&nbsp;</td>";
		 info	+= "						<td width='65'>";
		 info	+= "							<span class='hand' onclick=showWinForExp('/components/tag/grid/common/exportExcel.jsp')>综合统计</span>";
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
