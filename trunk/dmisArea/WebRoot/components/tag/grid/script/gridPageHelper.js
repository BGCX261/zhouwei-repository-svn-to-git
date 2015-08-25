/**======================================
*
 * 	分页标签 
 * 
 *  @author MaJian  2007-2-11
 *
 *=======================================*/
var pageCache = {
	_count:		0,
	_idPrefix:	"-page-cache-",

	getId:	function () {
		return this._idPrefix + this._count++;
	},

	remove:	function ( o ) {
		delete this[ o.id ];
	}
};

/**
 *  分页主体函数
 */
function pageHelper(pageObj,cPage,pSize,tCount,nCount,imgSrc){
	//alert(cPage+"#"+pSize+"#"+tCount+"#"+nCount);
	/**
	 *
	 */
	 this.imageSrc = imgSrc;
	/**
	 *  每页显示数据条数
	 */
	this.pageSize = pSize;
	/**
	 *  当前页数
	 */
	this.currPage = cPage;
	/**
	 *  查询的数据总数
	 */
	this.totalCount = tCount;
	
	/**
	 *  查询的总页数



	 */
	this.totalPageCount;
	/**
	 *  每组显示的页数



	 */
	this.numberPage = nCount;
	/**
	 *  当前页所在的页组数



	 */
	this.currPageGroup;
	/**
	 *  是否有上一页



	 */
	this.hasPre;
	/**
	 *  是否有下一页



	 */
	this.hasNext;
	/**
	 *  得到分页标识
	 */
	this.id = pageCache.getId();
	
	/**
	 *  得到Div对象
	 */
	if (typeof (htmlObject) != "object") {
		this.parentObject = document.getElementById(pageObj);
	} else {
		this.parentObject = pageObj;
	}
	
	/**
	 *  设置全局变量
	 */
	pageCache[ this.id ] = this;
	
	return this;
}

/**
 *  设置上一页



 */
pageHelper.prototype.setHasPre = function(){
	if(parseInt(this.currPage) > 1){
		this.hasPre = true;
	}
	else{
		this.hasPre = false;
	}
}

/**
 *  设置下一页



 */
pageHelper.prototype.setHasNext = function(){
	if(parseInt(this.currPage) < parseInt(this.totalPageCount)){
		this.hasNext = true;
	}
	else{
		this.hasNext = false;
	}
}

/**
 *  设置总页数



 */
pageHelper.prototype.setTotalPageCount = function(){
	if(parseInt(this.totalCount) % parseInt(this.pageSize) == 0){
		this.totalPageCount = parseInt(this.totalCount) / parseInt(this.pageSize);
	}else{
		this.totalPageCount = parseInt(this.totalCount) / parseInt(this.pageSize) + 1;
	}
}
pageHelper.prototype.setCurrPageGroup = function(){
	this.currPageGroup = 0;
	for(var i=1; i<=parseInt(this.totalPageGroup); i++){
		var startPage = (i-1) * parseInt(this.numberPage)+1;
		var endPage   = (i) * parseInt(this.numberPage);
		
		if((parseInt(this.currPage) >= parseInt(startPage)) 
			&& (parseInt(this.currPage) <= parseInt(endPage))) {
			
			//alert("CURR:"+parseInt(this.currPage)+"####"+parseInt(startPage)+"#"+parseInt(endPage));
			this.currPageGroup = i;
		}
	}
}
/**
 *  设置总组数



 */
pageHelper.prototype.setTotalPageGroup = function(){
	//alert("TOTAL:::"+parseInt(this.totalPageCount)+"#"+this.numberPage);
	if(parseInt(this.totalPageCount) % parseInt(this.numberPage) == 0){
		this.totalPageGroup = parseInt(this.totalpageCount) / parseInt(this.numberPage);
	}else{
		this.totalPageGroup = parseInt(parseInt(this.totalPageCount) / parseInt(this.numberPage)) +1;
	}
}

/**
 * 显示分页
 */
pageHelper.prototype.show = function(){
	if(this.parentObject != null && this.parentObject != "undefined"){
		this.parentObject.innerHTML = this.getHtml();
	}
}

/**
 * 得到分页HTML代码块



 */ 
pageHelper.prototype.getHtml = function(){
	var srcTop;
	var srcPre;
	this.setTotalPageCount();
	this.setTotalPageGroup();
	this.setCurrPageGroup();
	this.setHasPre();
	this.setHasNext();
	
	var htmlStr = "";
		htmlStr += "	<table>";
		htmlStr += "		<tr>";
		
		htmlStr += "			<td title='当前页记录范围'>";
		htmlStr += this.getItemCount();
		htmlStr += "			</td>";
		htmlStr += "			<td title='总记录数'>";
		htmlStr += this.getItemTotalCount();
		htmlStr += "			</td>";
		
		htmlStr += "			<td>";
		htmlStr += "				&nbsp;&nbsp;&nbsp;";
		htmlStr += "			</td>";
		//首页		
		htmlStr += "			<td>";
		htmlStr += this.getFirstPage();
		htmlStr += "			</td>";
		
		//上一页



		htmlStr += "			<td>";
		htmlStr += this.getPrePage();
		htmlStr += "			</td>";
		
		//页面范围选择
		htmlStr += "			<td>";
		htmlStr += this.getPageList();
		htmlStr += "			</td>";
		
		//下一页



		htmlStr += "			<td>";
		htmlStr += this.getNextPage();
		htmlStr += "			</td>";
		
		//未页		
		htmlStr += "			<td>";
		htmlStr += this.getEndPage();
		htmlStr += "			</td>";
		
		htmlStr += "			<td>";		
		htmlStr += "			</td>";

		htmlStr += "		</tr>";
		htmlStr += "	</table>";
	return htmlStr;
}
/**
 *
 */
pageHelper.prototype.getImage = function(src,alt){
	var imageStr = "";
			imageStr = "<img src='/"+this.getContextPath()+src+"' alt='"+alt+"'>";
	return imageStr;
}
/**
 *
 */
pageHelper.prototype.getHrefImage = function(src,alt,pageStr){
	var imageStr = "";
			imageStr = "<a onClick=submitDataByGrid('"+pageStr+"','"+this.pageSize+"')><img src='/"+this.getContextPath()+src+"' alt='"+alt+"' style='cursor:hand'></a>";
	return imageStr;
}

pageHelper.prototype.getFirstPage = function(){
	var firstStr = "";
	var srcTop = this.imageSrc+"arrowleft3_2.gif";
	var alt    = "首页";
	if(parseInt(this.currPage) == 1){
			firstStr += this.getImage(srcTop,alt);
	}else{
			firstStr += this.getHrefImage(srcTop,alt,"1");
	}
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		firstStr = this.getImage(srcTop,alt);
	}
	return firstStr;
}

pageHelper.prototype.getPrePage = function(){
	var preStr  = "";
	var srcPre  = this.imageSrc+"arrowleft3_1.gif";
	var alt     = "上一页";
	if(this.hasPre){
		preStr += this.getHrefImage(srcPre,alt,parseInt(this.currPage)-1);
	}else{
		preStr += this.getImage(srcPre,alt);
	}
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		preStr = this.getImage(srcPre,alt);
	}
	return preStr;
}

pageHelper.prototype.getNextPage = function(){
	var nextStr  = "";
	var srcNext  = this.imageSrc+"arrowright3_1.gif";
	var alt      = "下一页";
	if(this.hasNext){
		nextStr += this.getHrefImage(srcNext,alt,parseInt(this.currPage)+1);
	}else{
		nextStr += this.getImage(srcNext,alt);
	}
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		nextStr = this.getImage(srcNext,alt);
	}
	return nextStr;
}

pageHelper.prototype.getEndPage = function(){
	var endStr = "";
	var srcEnd = this.imageSrc+"arrowright3_2.gif";
	var alt    = "末页";
	if(parseInt(this.currPage) == parseInt(this.totalPageCount)){
			endStr += this.getImage(srcEnd,alt);
	}else{
			endStr += this.getHrefImage(srcEnd,alt,parseInt(this.totalPageCount));
	}
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		endStr = this.getImage(srcEnd,alt);
	}
	return endStr;
}

pageHelper.prototype.getPageList = function(){
	var listStr = "";
	var srcEnd = "";
	if(this.totalPageCount != 0){
		var startPage = (parseInt(this.currPageGroup)-1) * parseInt(this.numberPage)+1;
		var endPage   = (parseInt(this.currPageGroup)) * parseInt(this.numberPage);
		if(parseInt(endPage) > parseInt(this.totalPageCount)){
			endPage = this.totalPageCount;
		}
		//-----------按google分页新加入-----------
		if(parseInt(this.currPage)<=parseInt(this.numberPage)){
			startPage = 1;
		} else {
			startPage = parseInt(this.currPage)-parseInt(this.numberPage);
		}
		if((parseInt(this.currPage)+parseInt(this.numberPage)) >= parseInt(this.totalPageCount)){
			endPage   = parseInt(this.totalPageCount);
		} else {
			endPage   = parseInt(this.currPage)+parseInt(this.numberPage);
		}
		//--------------------------------------
		for(var i=startPage; i<=endPage; i++){
			if(i== parseInt(this.currPage)){
				//listStr += "  <font color='red'><a style='cursor:hand' onClick=submitData('"+i+"');>"+i+"</a></font>  ";
				listStr += "  <font color='red'>"+i+"</font>  ";
			} else {
				listStr += "  <a style='cursor:hand' onClick=submitDataByGrid('"+i+"','"+this.pageSize+"')>"+i+"</a>  ";
			}
		}
	}
	return listStr;
}

/**
 *
 */
 pageHelper.prototype.getItemCount = function(){
 	var startItem = (parseInt(this.currPage)-1) * parseInt(this.pageSize)+1;
 	var tempItem   = (parseInt(this.currPage) * parseInt(this.pageSize));
 	var endItem;
 	if(tempItem > parseInt(this.totalCount)){
 		endItem = parseInt(this.totalCount);
 	}else{
 		endItem = tempItem;
 	}
	var imageStr = "";
		imageStr = "["+startItem+"-"+endItem+"]";
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		imageStr = "[0-0]";
	}
	return imageStr;
}

/**
 *
 */
 pageHelper.prototype.getItemTotalCount = function(){
	var imageStr  = "";
		imageStr += "["+this.totalCount+"]";
	if(parseInt(this.totalCount) == 0 || parseInt(this.totalCount) == "undefined"){
		imageStr = "[0]";
	}
	return imageStr;
}

/**
 *
 */
//pageHelper.prototype.submitDataByGrid = function(pageStr){
function submitDataByGrid(pageStr,pageSize){
	 if(pageStr){
		var filterParams = document.all.filterStr.value;
		var wheres 		 = document.all.wheres.value;	 	
		createGrid('','0','',pageStr+'^'+pageSize,wheres,'',filterParams,'');
		//var page = new pageHelper("page",pageStr,pageSize,"1000","5");
		//page.show();
	 }
 }
 
 
 
/**
 *
 */
function pageImageItem(itemId){
	this.itemKey = itemId;
	this.id = pageCache.getId();
	pageCache[ this.id ] = this;
}

pageImageItem.prototype.title = "";
pageImageItem.prototype.disabled = false;
pageImageItem.prototype.visible = true;

pageImageItem.prototype.getHtml = function(){
	var itemKey  = (this.itemKey != "" && this.itemKey != null)?"id="+this.itemKey:"";
	var title  	  = (this.getTitle() != "")?this.getTitle():"";
	var cssClass = (this.getCssClass() != "")?this.getCssClass:"";
	var visible  = this.visible;
	var htmlStr  = "";
		htmlStr += "<td";
		htmlStr += "	";
		htmlStr += ">";
		htmlStr += "111";
		htmlStr += "</td>";
}

pageImageItem.prototype.getCssClass = function(){
	return "";
}

pageImageItem.prototype.getTitle = function(){
	return this.title;
}

function testMSN(){
	alert("testMSN");
}

/**
 *  --服务器基础路径--
 */
pageHelper.prototype.getContextPath = function(){
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

