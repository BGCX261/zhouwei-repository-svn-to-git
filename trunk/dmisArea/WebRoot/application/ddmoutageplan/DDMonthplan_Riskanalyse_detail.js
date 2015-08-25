//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdMoutageplanForm(document.ddMoutageplanForm)){
		return false;
	}
	url = contextPath + "/ddMoutageplan.do?method=saveDetail";
	document.all.ddMoutageplanForm.action = url;
	document.all.ddMoutageplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddMoutageplanForm.reset();
}

