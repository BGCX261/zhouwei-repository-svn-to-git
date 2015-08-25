//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateDdEnsuringpsmanageForm(document.ddEnsuringpsmanageForm)){
		return false;
	}
	*/
	url = contextPath + "/ddEnsuringpsmanage.do?method=saveDetail";
	document.all.ddEnsuringpsmanageForm.action = url;
	document.all.ddEnsuringpsmanageForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddEnsuringpsmanageForm.reset();
}

