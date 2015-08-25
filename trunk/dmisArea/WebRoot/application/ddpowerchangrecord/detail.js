//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdPowerchangrecordForm(document.ddPowerchangrecordForm)){
		return false;
	}
	url = contextPath + "/ddPowerchangrecord.do?method=saveDetail";
	document.all.ddPowerchangrecordForm.action = url;
	document.all.ddPowerchangrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddPowerchangrecordForm.reset();
}

