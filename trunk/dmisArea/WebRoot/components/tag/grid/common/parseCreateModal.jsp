<%@ page language="java" pageEncoding="utf-8"%>
<%@ page language="java" buffer="18kb"%>

<html>
  <head>
		<title></title> 
  </head> 
  <body>
	<script>
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
			param.id        		= document.all.id.value;
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
			
			vReturnValue = showModalDialogYY(path,"300","200",param,"高级查询条件","no");
			
			if(vReturnValue != null){	
			}
		}
	</script>
  </body>
</html>
