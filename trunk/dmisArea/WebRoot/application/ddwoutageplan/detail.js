//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdWoutageplanForm(document.ddWoutageplanForm)){
		return false;
	}
	url = contextPath + "/ddWoutageplan.do?method=saveDetail";
	document.all.ddWoutageplanForm.action = url;
	document.all.ddWoutageplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddWoutageplanForm.reset();
}

