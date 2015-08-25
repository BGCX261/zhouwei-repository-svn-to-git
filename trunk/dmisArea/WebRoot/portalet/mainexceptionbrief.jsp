<%@ page contentType="text/html; charset=utf-8" %>

<html>
<head>
<title>主网故障</title>
<meta name="KEYWORDS" content="dhtmlxgrid, dhtml grid, javascript grid, javascript, DHTML, grid, grid control, dynamical scrolling, xml, AJAX, API, cross-browser, checkbox, XHTML, compatible, gridview, navigation, script, javascript navigation, web-site, dynamic, javascript grid, dhtml grid, dynamic grid, item, row, cell, asp, .net, jsp, cold fusion, custom tag, loading, widget, checkbox, drag, drop, drag and drop, component, html, scand">
<meta name="DESCRIPTION" content="Cross-browser DHTML grid with XML support and powerful API. This DHTML JavaScript grid can load its content dynamically from server using AJAX technology.">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/components/tag/grid/css/dhtmlXGrid.css">
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/themes/themes1/style.css">
<script  language="jscript.encode" src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXCommon.js"></script>
<script  language="jscript.encode" src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid.js"></script>
<script  language="jscript.encode" src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGridCell.js"></script>
<script  language="jscript.encode" src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_excell_link.js"></script>
</head>
<style>
	body {font-size:12px}
	.{font-family:arial;font-size:12px}
	h1 {cursor:hand;font-size:16px;margin-left:10px;line-height:10px}
	xmp {color:green;font-size:12px;margin:0px;font-family:courier;background-color:#e6e6fa;padding:2px}
	div.hdr{
		background-color:lightgrey;
		margin-bottom:10px;
		padding-left:10px;
	}
    .grid_hover {
        background-color:#d6d6d6;
        font-size:20px;
    }

	<!-- 设置隔行显示，并对选中行进行高亮显示-->
		.even{
	        background-color:#E6E6FA;
	    }
	    .uneven{
	        background-color:#eeeeee;
	    }

</style>
<body onmousemove="window.status = 'X=' + window.event.x + ' Y=' + window.event.y">


<table>
  <tr>
    <td width="100%">
      <div id="gridbox" class="gridbox_xp" width="100%" height="204px" style="background-color:white;"></div>
    </td>
  </tr>
  <tr><td>&nbsp;</td></tr>
</table>

<script language="jscript.encode">
        var currowid,curcolid;
        function protocolIt(str){
           //alert(str);
	    }
	    function doOnRowSelected(id){
           if (currowid== id) {return true;}
           currowid = id;
           curcolid =mygrid.getSelectedCellIndex();
           //alert("第"+currowid+"行 第"+curcolid+"列的值:"+mygrid.cells(currowid,curcolid).getValue());
		   var second=parent.document.getElementById("second");
		   second.style.display="block";


		   var first=parent.document.getElementById("first");
		   first.style.display="none";


		   var tt1=parent.document.getElementById("tFirst");
		   tt1.className="ooihs"


		   var tt2=parent.document.getElementById("tSecond");
		   tt2.className="ooihj"

		   //alert(document.childNodes[0].nodeName);

		   /*
		   var newurl = window.parent.location.href;
		   //alert(newurl);
		   var tmp;
		   var ss = newurl.split("/");
		   newurl="";
		   for(var i=0;i<ss.length-1;i++){

		      newurl=newurl+ss[i]+"\/";
			  //alert(newurl);
		   }
		   tmp=newurl;
		   newurl=newurl+"label1.html";
		   //alert(newurl);
		   window.parent.location.href=newurl;

		   alert(window.location.href);
		   var tmp2=window.location.href;
		   var tt = tmp2.split("/");
		   newurl = "";
		   for(var i=0;i<ss.length-1;i++){

		      newurl=newurl+tt[i]+"\/";
		   }
		   tmp2 = newurl;
		   newurl=newurl+"xiangqing.html";
		   alert(newurl);
		   window.location.href=newurl;
		   */
           return true;

	    }
	    function doOnCellEdit(stage,rowId,cellInd){
		   if(stage==0){
			 protocolIt("User starting cell editing: row id is"+rowId+", cell index is "+cellInd);
		   }else if(stage==1){
			 protocolIt("Cell editor opened");
		   }else if(stage==2){
			protocolIt("Cell editor closed");
		   }
	    }
	    function doOnCheck(rowId,cellInd,state){
		   protocolIt("User clicked on checkbox or radiobutton on row "+rowId+" and cell with index "+cellInd+".State changed to "+state);
	    }
	    function doOnEnter(rowId,cellInd){
		   protocolIt("User pressed Enter on row with id "+rowId+" and cell index "+cellInd);
	    }
	    function doBeforeRowDeleted(rowId){
		   if(confirm("Are you sure you want to delete row")){
			   protocolIt("Row deletion confirmed");
			    return true;
		   }else{
			  protocolIt("Row deletion canceled");
			  return false;
		   }
	    }

	    mygrid = new dhtmlXGridObject('gridbox');
            mygrid.setImagePath("<%=request.getContextPath()%>/themes/themes1/images/grid/");
            //设置多选,如果当前页面设置了鼠标移动导航，则会自动屏蔽多选功能

	    mygrid.setMultiselect ("true");

	    mygrid.enableRowsHover(true,'grid_hover');

	    //设置隔行显示，并对选中行进行高亮显示

	    mygrid.enableAlterCss("even","uneven");

            mygrid.setSkin("xp");
            //mygrid.setOnRowSelectHandler(doOnRowSelected);
	    mygrid.setOnEditCellHandler(doOnCellEdit);
	    mygrid.setOnEnterPressedHandler(doOnEnter);
	    mygrid.setOnCheckHandler(doOnCheck);
	    mygrid.setOnBeforeRowDeletedHandler(doBeforeRowDeleted);
            mygrid.loadXML("mainexceptionbrief.xml");
	</script>
	<script type="text/javascript">
	    function callLink()
	    {
            mygrid.setOnRowSelectHandler(doOnRowSelected);
            return;

	    }
	</script>
</body>
</html>
