/*
Copyright Scand LLC http://www.scbr.com
To use this component please contact info@scbr.com to obtain license
*/

/*
Counter eXcell v.1.0  for dhtmlxGrid 
(c)Scand LLC 2005


The corresponding  cell value in XML can contain any value (it is ignored)

*/
function eXcell_cntr(cell){
	this.cell = cell;
    this.grid = this.cell.parentNode.grid;
	this.edit = function(){}
	this.getValue = function(){
		return this.cell.parentNode.rowIndex;
	}
	this.setValue = function(val){
		this.cell.style.paddingRight = "2px";
		var cell=this.cell;
		window.setTimeout(function(){
			cell.innerHTML = cell.parentNode.rowIndex;
			if (cell.parentNode.grid._fake) cell.parentNode.grid._fake.cells(cell.parentNode.idd,cell._cellIndex).setValue(cell.parentNode.rowIndex);
			cell=null;
		},100);
	}
}
eXcell_cntr.prototype = new eXcell;
