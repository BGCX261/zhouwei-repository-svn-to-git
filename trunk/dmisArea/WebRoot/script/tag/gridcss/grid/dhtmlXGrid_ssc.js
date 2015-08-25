/*
Copyright Scand LLC http://www.scbr.com
To use this component please contact info@scbr.com to obtain license
*/


/**
*   @desc: enable automatic size saving to cookie
*   @param: name - optional, cookie name
*   @type: public
*   @topic: 0
*/
dhtmlXGridObject.prototype.enableAutoSizeSaving = function(name){
		this.setOnResizeEnd(function(){ this.saveSizeToCookie(name) });
}




/**   @desc: save grid layout to cookie
*     @type: public
*     @param: name - optional, cookie name
*     @param: cookie_param - additional parametrs added to cookie
*     @edition: Professional
*     @topic: 2
*/
dhtmlXGridObject.prototype.saveSizeToCookie=function(name,cookie_param){
	if (!name) name=this.entBox.id;
	if (this.cellWidthType=='px')
		var z=this.cellWidthPX.join(",");
	else
		var z=this.cellWidthPC.join(",");
	this.setCookie("gridSizeA"+name,z,cookie_param);
	var z=(this.initCellWidth||(new  Array)).join(",");
	this.setCookie("gridSizeB"+name,z,cookie_param);
    return true;
}


/**   @desc: load grid layout from cookie
*     @type: public
*     @param: name - optional,cookie name
*     @edition: Professional
*     @topic: 2
*/
dhtmlXGridObject.prototype.loadSizeFromCookie=function(name){
	if (!name) name=this.entBox.id;
	var z=this.getCookie("gridSizeB"+name);
	if (z)
		this.initCellWidth=z.split(",");
	var z=this.getCookie("gridSizeA"+name);
	if ((z)&&(z.length))
		if (this.cellWidthType=='px')
			this.cellWidthPX=z.split(",");
		else
			this.cellWidthPC=z.split(",");
	this.setSizes();
    return true;
}


/**   @desc: save cookie
*     @type: private
*     @param: name - cookie name
*     @param: value - cookie value
*     @param: cookie_param - additional parametrs added to cookie
*     @edition: Professional
*     @topic: 0
*/

dhtmlXGridObject.prototype.setCookie=function(name,value,cookie_param) {
	var str = name + "=" + value +  (cookie_param?("; "+cookie_param):"");
	document.cookie = str;
}

/**   @desc: get cookie
*     @type: private
*     @param: name - cookie name
*     @edition: Professional
*     @topic: 0
*/
dhtmlXGridObject.prototype.getCookie=function(name) {
	var search = name + "=";
	if (document.cookie.length > 0) {
		var offset = document.cookie.indexOf(search);
		if (offset != -1) {
			offset += search.length;
			var end = document.cookie.indexOf(";", offset);
			if (end == -1)
				end = document.cookie.length;
			return document.cookie.substring(offset, end);
						}		}
};
