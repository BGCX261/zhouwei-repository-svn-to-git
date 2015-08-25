//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdElectricstampForm(document.stdElectricstampForm)){
		return false;
	}
	url = contextPath + "/stdElectricstamp.do?method=saveDetail";
	document.all.stdElectricstampForm.action = url;
	document.all.stdElectricstampForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdElectricstampForm.reset();
}

