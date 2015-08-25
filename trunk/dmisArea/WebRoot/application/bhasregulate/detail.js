//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateBhAsregulateForm(document.bhAsregulateForm)){
		return false;
	}
	url = contextPath + "/bhAsregulate.do?method=saveDetail";
	document.all.bhAsregulateForm.action = url;
	document.all.bhAsregulateForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.bhAsregulateForm.reset();
}

