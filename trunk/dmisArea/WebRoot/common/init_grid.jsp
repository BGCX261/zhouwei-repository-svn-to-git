<%
/**
 * initialize grid css,javascript
 */
%>
<!-- import the grid style -->
<link rel="STYLESHEET" type="text/css" href="<%=request.getContextPath()%>/components/tag/grid/css/dhtmlXGrid.css">
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
        background-color:#7FFFD4;
        font-size:20px;
    }
	div.gridbox div.ftr td{
		text-align:right;
	}
	<!-- 设置隔行显示，并对选中行进行高亮显示-->
	.even{
        background-color:#E6E6FA;
    }
    .uneven{
        background-color:#eeeeee;
    }
</style>

<!-- import the grid script -->
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXCommon.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid.js"></script>    
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGridCell.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_excell_link.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_splt.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_mcol.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_exProject.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/dhtmlXGrid_other.js"></script>
<script  src="<%=request.getContextPath()%>/script/prototype.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/gridPageHelper.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/gridTagHelper.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/importDatas.js"></script>
<script  src="<%=request.getContextPath()%>/components/tag/grid/script/validate.js"></script>


