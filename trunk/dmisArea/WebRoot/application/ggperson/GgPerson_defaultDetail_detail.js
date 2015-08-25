//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateGgPersonForm(document.ggPersonForm)){
		return false;
	}
	url = contextPath + "/ggPerson.do?method=saveDetail";
	document.all.ggPersonForm.action = url;
	document.all.ggPersonForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ggPersonForm.reset();
}

