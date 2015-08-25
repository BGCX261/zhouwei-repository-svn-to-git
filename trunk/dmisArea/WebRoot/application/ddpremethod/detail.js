//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdPremethodForm(document.ddPremethodForm)){
		return false;
	}
	url = contextPath + "/ddPremethod.do?method=saveDetail";
	document.all.ddPremethodForm.action = url;
	document.all.ddPremethodForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddPremethodForm.reset();
}

