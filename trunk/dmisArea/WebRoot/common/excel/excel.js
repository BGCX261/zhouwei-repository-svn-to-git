/**
*用于处理从excel中导出后数据放入到grid中
*obj grid对象
*returnExcel excel数据
*/

function excelToGrid(obj,returnExcel){

	if(returnExcel==""||returnExcel==null||typeof(returnExcel)=="undefined")
		return false;
	    var rowId=returnExcel.split('^^');
	    var currRowNo =0;
	    var colName;
	    for(i=0;i<rowId.length;i++)
	    {
	    	var colId=rowId[i].split('##');
	    	if(i==0)//第一行是标题
	    	{

	    		colName=rowId[i].split('##');
	    	}
	    	else
	    	{
	 	    	 obj.addNewRow();	   
	    		 currRowNo = obj.getRowsNum();
	    	    	
	    	}
	    	if(i!=0)
	    	{
	    		for(j=0;j<colId.length;j++)
	    		{ 		
	    			 for (colIndex=0;colIndex< obj.colsName.length;colIndex++ ) {
		        		if (obj.colsName[colIndex] == 'rowStatus') 
				            obj.cells(currRowNo,colIndex).setValue(4);				         
				        if (obj.colsName[colIndex] == 'version') 
				            obj.cells(currRowNo,colIndex).setValue(0);				         
					    if (obj.colsName[colIndex].toLowerCase() == colName[j].toLowerCase())					    
					       obj.cells(currRowNo,colIndex).setValue(colId[j]);				       
    		
	    			}
	    		}
	    	}

	    		
	    }
}