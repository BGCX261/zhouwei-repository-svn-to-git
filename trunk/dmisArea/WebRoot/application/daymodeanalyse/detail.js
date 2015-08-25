//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDaymodeanalyseForm(document.daymodeanalyseForm)){
		return false;
	}
	url = contextPath + "/daymodeanalyse.do?method=saveDetail";
	document.all.daymodeanalyseForm.action = url;
	document.all.daymodeanalyseForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.daymodeanalyseForm.reset();
}

