//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateBhFaultlistForm(document.bhFaultlistForm)){
		return false;
	}
	url = contextPath + "/bhFaultlist.do?method=saveDetail";
	document.all.bhFaultlistForm.action = url;
	document.all.bhFaultlistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.bhFaultlistForm.reset();
}

