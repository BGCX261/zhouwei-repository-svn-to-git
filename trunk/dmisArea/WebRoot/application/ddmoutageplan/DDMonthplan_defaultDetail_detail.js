//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作
function onSaveForm(contextPath) {
    //	if (!validateDdMoutageplanForm(document.ddMoutageplanForm)){
	//	return false;
	//}
	url = contextPath + "/ddMoutageplan.do?method=saveDetail";
	document.all.ddMoutageplanForm.action = url;
	document.all.ddMoutageplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath) {
	document.all.ddMoutageplanForm.reset();
}

//选择厂站
function setStdStationSelect(){
	//alert("tt");
	var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="stationname:ddMoutageplanDto.fstationname^id:ddMoutageplanDto.fstationid";
	var url = '/application/stdstation/showstdstation.jsp';
	var vReturnValue = showModalDialogYY(url,"800","460",param,"厂站","auto");
	var cols = oppositeCols.split("^");
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 如：［rowno#1^javascript:void(0)，dydj#10kv........�?

	 */		
	if(vReturnValue != null){
		//alert(vReturnValue);
		var data = vReturnValue.split("@@@");
		for(s=0;s<data.length;s++){
			//alert(data[s]);			
			for (col=0;col<cols.length;col++){
			  var colPer = cols[col].split(":");			  
			  if (data[s].split("^")[0] == colPer[0]) {			    
			     var tCol = document.getElementById(colPer[1]); 			     
			     tCol.value = data[s].split("^")[1];
	
			  }
			}
		}
	}
}


//调度范围
  function showDispathUnit(){
  		var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="unitshortname:ddMoutageplanDto.fdispatchrange";
	var url = '/application/stddispatchunit/StdDispatchunit_defaultList_grid.jsp';
	var vReturnValue = showModalDialogYY(url,"600","520",param,"调度范围","auto");
	var cols = oppositeCols.split("^");
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 如：［rowno#1^javascript:void(0)，dydj#10kv........�?

	 */		
	if(vReturnValue != null){
		var data = vReturnValue.data;
		for(s=0;s<data.length;s++){
			//alert(data[s]);			
			for (col=0;col<cols.length;col++){
			  var colPer = cols[col].split(":");			  
			  if (data[s].split("^")[0] == colPer[0]) {			    
			     var tCol = document.getElementById(colPer[1]); 			     
			     tCol.value = data[s].split("^")[1];
			     //alert(tCol.value);
			  }
			}
		}
	}
  
  
  }

//线路
  function setStdLineSelect(){
  		var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="linename:ddMoutageplanDto.flinename^id:ddMoutageplanDto.flinenameid";
	var url = '/application/stdline/StdLinegrid.jsp';
	var vReturnValue = showModalDialogYY(url,"600","520",param,"线路","auto");
	var cols = oppositeCols.split("^");
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 如：［rowno#1^javascript:void(0)，dydj#10kv........�?

	 */		
	if(vReturnValue != null){
		var data = vReturnValue.data;
		for(s=0;s<data.length;s++){
			//alert(data[s]);			
			for (col=0;col<cols.length;col++){
			  var colPer = cols[col].split(":");			  
			  if (data[s].split("^")[0] == colPer[0]) {			    
			     var tCol = document.getElementById(colPer[1]); 			     
			     tCol.value = data[s].split("^")[1];
			     //alert(tCol.value);
			  }
			}
		}
	}
  
  
  }


