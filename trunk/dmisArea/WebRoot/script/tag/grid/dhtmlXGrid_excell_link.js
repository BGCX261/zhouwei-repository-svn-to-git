/*
Copyright Scand LLC http://www.scbr.com
To use this component please contact info@scbr.com to obtain license
*/

/*
HTML Link eXcell v.1.0  for dhtmlxGrid 
(c)Scand LLC 2005


The corresponding  cell value in XML should be a "^" delimited list of following values:
1st - Link Text 
2nd - URL (optional)
3rd - target (optional, default is _blank)

Samples:
<cell>Stephen King</cell>
<cell>Stephen King^http://www.stephenking.com/</cell>
<cell>Stephen King^http://www.stephenking.com/^_self</cell>
*/

function eXcell_link(cell){	
	this.cell = cell;
    this.grid = this.cell.parentNode.grid;
	this.edit = function(){}
	this.getValue = function(){
		if(this.cell.firstChild.getAttribute)
			return this.cell.firstChild.innerHTML+"^"+this.cell.firstChild.getAttribute("href")
		else
			return "";
	}
	this.setValue = function(val){
		if (val == null) {return;}
		var tmp,tmp2;
		var valsAr = val.split("^");
				
		if(valsAr.length==1)
			valsAr[1] = "";
		else{
			if(valsAr.length>1){				
				//要加入列表对象实例名称
				if (valsAr[1].indexOf('callLink') > 0 && valsAr[1].indexOf('.callLink') < 0){
				    valsAr[1] = 'javascript:'+this.grid.gridObjName+'.'+'callLink()';					
				}
				if (valsAr[1].indexOf('popUpForLink') > 0 && valsAr[1].indexOf('.popUpForLink') < 0){				
				    valsAr[1] = 'javascript:'+this.grid.gridObjName+'.'+'popUpForLink()';					
				}
				valsAr[1] = "href='"+valsAr[1]+"'";
				
				if(valsAr.length==3) {
					valsAr[1]+= " target='"+valsAr[2]+"'";
				} else {
				   /**************************************
				    由于控件本身执行了两遍该函数，而第二遍执行时竟然将
					11^javascript:callLink();^_self  改成了 11^javascript:callLink();
					为满足内部跳转的需求，此处对行号列的信息进行强制性转换，以达到预期的效果
					************/
					if (valsAr[1].indexOf('callLink()') > 0 ||  valsAr[1].indexOf('popUpForLink()') > 0 ){
						valsAr[1]+= " target='_self'";
						
					} else {
						valsAr[1]+= " target='_blank'";
					}
					
					/*if (this.cell._cellIndex == 0) {
						   valsAr[1]+= " target='_self'";
					} else {
						   valsAr[1]+= " target='_blank'";
					}	
					*/
			    }
		    }
		}
		//alert(valsAr[1]+'@@@@@@@'+valsAr[0]+'@@@@@@@'+valsAr);
	    this.setCValue("<a "+valsAr[1]+" onclick='(isIE()?event:arguments[0]).cancelBubble = true;'>"+valsAr[0]+"</a>",valsAr);
		
		
	}
	
}

eXcell_link.prototype = new eXcell;
eXcell_link.prototype.getTitle=function(){
    return this.cell.firstChild.getAttribute("href");
}


