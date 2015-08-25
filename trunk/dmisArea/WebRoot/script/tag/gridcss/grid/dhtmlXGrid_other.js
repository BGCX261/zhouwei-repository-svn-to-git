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
		
		
		
		/**
	    * 用于进行统计,需要改造，因为统计值来源于后台
	    */
	   function calculateFooterValues(stage){
		  if(stage && stage!=2)
			  return true;
		  var nrQ = document.getElementById("totalrow");
			  nrQ.innerHTML = sumColumn(13);
			  /*
		  var srQ = document.getElementById("sr_q");
			  srQ.innerHTML = sumColumn(5)
		  var nrS = document.getElementById("nr_s");
			  nrS.innerHTML = "$ "+sumIncome(2,3)
		  var srS = document.getElementById("sr_s");
			  srS.innerHTML = "$ "+sumIncome(4,5);
		  */
		  
		  return true;
		}
		function sumColumn(ind){
			var out = 0;
			for(var i=0;i<mygrid.getRowsNum();i++){
				out+= parseFloat(mygrid.cells2(i,ind).getValue())
			}
			return out;
		}
		function sumIncome(indPrice,indQuant){
			var out = 0;
			for(var i=0;i<mygrid.getRowsNum();i++){
				out+= parseFloat(mygrid.cells2(i,indPrice).getValue())*parseFloat(mygrid.cells2(i,indQuant).getValue())
			}
			return out;
		}
      
         
	  /**
       * 撤消选择所有的行

       */
       function onUnselectAllRows(){
          mygrid.unselectAllRows();
       }     
       
        function doOnRowSelected(id){
           return true;
	    }

        /**
	     *  link时触发的方法，主要用于页面的跳转或重定向
	     */
	    function callLink(){
	          alert("jsp模板中的function callLink()");
              //mygrid.setOnRowSelectHandler(doOnRowSelected);
              return;
	    }
	    
	    /**
	     *  用于在单元格内的按钮的onClick时所触发的方法

	     */
	    function clearFilterCondition(){		   
	       var columnCount;
	       var columnType;
	       //alert("jsp模板中的function clearFilterCondition()");
	       //curcolid =mygrid.getSelectedCellIndex();//当前的列索引号

		    columnCount=mygrid.getColumnCount();
		    for (i=1;i<columnCount;i++) {	          
		       columnType = mygrid.getColType(i);              
		       switch(columnType) { 
	           case "ed":
	                   mygrid.cells(0,i).setValue("");
	                   break;
	           }
		    }
	       //将焦点定位在第一行第二列           
		   mygrid.selectCell(0,3,true,true,1);
	       
	    }
        /**
         *
         */
        function setColFoucs(rowidxid,colidxid){            
            mygrid.selectCell(rowidxid,colidxid,true,true,1);
            
        }  