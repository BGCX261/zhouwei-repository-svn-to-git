//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	
	/*
	if (!validateDdHpoweroperaterrdForm(document.ddHpoweroperaterrdForm)){
		return false;
	}
	*/
	url = contextPath + "/ddHpoweroperaterrd.do?method=saveDetail";
	document.all.ddHpoweroperaterrdForm.action = url;
	document.all.ddHpoweroperaterrdForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddHpoweroperaterrdForm.reset();
}
//下令人
function setDdDispatcherSelect(fieldname){
	displayBusSelect(fieldname,fieldname,'','src=ddperson','0');
}
//人员
function setGgPersonSelect(fieldname){
	displayBusSelect(fieldname,fieldname,'','src=person','0');

}
//选择电厂
function setStdStationSelect(){
	var param = new Object();
	//厂站字段和界面字段的对照关系
	var issubstation="电厂";
	param.dc="电厂";
	var oppositeCols="stationname:ddHpoweroperaterrdDto.fplant^stationno:ddHpoweroperaterrdDto.zddhpoweroperaterrd2.stationno";
	alert(issubstation);
	var url = '/application/stdstation/StdStation.jsp?issubstation='+issubstation;
	var vReturnValue = showModalDialogYY(encodeURI(url),"800","460",param,"厂站","auto");
	var cols = oppositeCols.split("^");
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 

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
			     alert(tCol.value);
			  }
			}
		}
	}

}

