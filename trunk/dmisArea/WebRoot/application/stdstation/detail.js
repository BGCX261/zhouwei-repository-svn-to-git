//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdStationForm(document.stdStationForm)){
		return false;
	}
	url = contextPath + "/stdStation.do?method=saveDetail";
	document.all.stdStationForm.action = url;
	document.all.stdStationForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdStationForm.reset();
}

