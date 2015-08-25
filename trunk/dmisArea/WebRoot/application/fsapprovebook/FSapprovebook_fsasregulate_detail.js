//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateFsApprovebookForm(document.fsApprovebookForm)){
		return false;
	}
	url = contextPath + "/fsApprovebook.do?method=saveDetail";
	document.all.fsApprovebookForm.action = url;
	document.all.fsApprovebookForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.fsApprovebookForm.reset();
}

