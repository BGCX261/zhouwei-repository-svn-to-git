//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	//if (!validateDdDoutageplanForm(document.ddDoutageplanForm)){
		//return false;
	//}
	url = contextPath + "/ddDoutageplan.do?method=saveDetail&op=detail";
	document.all.ddDoutageplanForm.action = url;
	document.all.ddDoutageplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddDoutageplanForm.reset();
}


function onSaveApprove(contextPath){
	url = contextPath + "/ddDoutageplan.do?method=saveDetail";
	document.all.ddDoutageplanForm.action = url;
	document.all.ddDoutageplanForm.submit();
}
//选择厂站
function setStdStationSelect(){
	//alert("tt");
	var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="stationname:ddDoutageplanDto.fstationname^id:ddDoutageplanDto.fstationid";
	var url = '/application/stdstation/showstdstation.jsp';
	var vReturnValue = showModalDialogYY(url,"800","460",param,"厂站","auto");
	var cols = oppositeCols.split("^");
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 如：［rowno#1^javascript:void(0)，dydj#10kv........�?

	 */		
	if(vReturnValue != null){
		var data = vReturnValue.split("@@@");
		for(s=0;s<data.length;s++){
			//alert(data[s]);			
			for (col=0;col<cols.length;col++){
			  var colPer = cols[col].split(":");			  
			  if (data[s].split("^")[0] == colPer[0]) {			    
			     var tCol = document.getElementById(colPer[1]); 			     
			     tCol.value = data[s].split("^")[1];
			     alert(tCol.value);
			  }
			}
		}
	}

}


//调度范围
  function showDispathUnit(){
  		var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="unitshortname:ddDoutageplanDto.fdispatchrange";
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
	var oppositeCols="linename:ddDoutageplanDto.fline^id:ddDoutageplanDto.flinenameid";
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

