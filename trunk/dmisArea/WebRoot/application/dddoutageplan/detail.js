//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdDoutageplanForm(document.ddDoutageplanForm)){
		return false;
	}
	url = contextPath + "/ddDoutageplan.do?method=saveDetail";
	document.all.ddDoutageplanForm.action = url;
	document.all.ddDoutageplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddDoutageplanForm.reset();
}

