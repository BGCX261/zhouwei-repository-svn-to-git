//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateDdPowerchangrecordForm(document.ddPowerchangrecordForm)){
		return false;
	}
	*/
	url = contextPath + "/ddPowerchangrecord.do?method=saveDetail";
	document.all.ddPowerchangrecordForm.action = url;
	document.all.ddPowerchangrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddPowerchangrecordForm.reset();
}

//下令人
function setsendSelect(fieldname){
displayBusSelect(fieldname,fieldname,'','src=ddperson','0');
}
//接收人
function setacceptSelect(fieldname){
alert(fieldname);
displayBusSelect(fieldname,fieldname,'','src=person','0');
}
//选择厂站
function setStdStationSelect(){
	alert("tt");
	var param = new Object();
	//厂站字段和界面字段的对照关系
	var oppositeCols="stationname:ddPowerchangrecordDto.fstationname^stationno:ddPowerchangrecordDto.zddpowerchangrecord6.stationno";
	var url = '/application/stdstation/StdStation.jsp?issubStation="0=0"';
	var vReturnValue = showModalDialogYY(url,"800","460",param,"厂站","auto");
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
			     alert(tCol.value);
			  }
			}
		}
	}

}
