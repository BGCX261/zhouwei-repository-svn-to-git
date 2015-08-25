//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdManufacturerForm(document.stdManufacturerForm)){
		return false;
	}
	url = contextPath + "/stdManufacturer.do?method=saveDetail";
	document.all.stdManufacturerForm.action = url;
	document.all.stdManufacturerForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdManufacturerForm.reset();
}

