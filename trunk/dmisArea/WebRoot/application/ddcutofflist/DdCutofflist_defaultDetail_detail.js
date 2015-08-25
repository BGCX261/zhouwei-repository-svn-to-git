//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdCutofflistForm(document.ddCutofflistForm)){
		return false;
	}
	url = contextPath + "/ddCutofflist.do?method=saveDetail";
	document.all.ddCutofflistForm.action = url;
	document.all.ddCutofflistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddCutofflistForm.reset();
}

