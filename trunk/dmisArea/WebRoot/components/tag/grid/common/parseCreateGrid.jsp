<%@ page language="java" pageEncoding="utf-8"%>
<%@ page language="java" buffer="18kb"%>

<html>
  <head>
		<title></title>
  </head> 
  <body>
  <br>
    <script>
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
    </script>
  </body>
</html>
