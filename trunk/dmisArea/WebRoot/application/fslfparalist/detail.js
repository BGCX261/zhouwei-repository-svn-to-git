//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateFsLfparalistForm(document.fsLfparalistForm)){
		return false;
	}
	url = contextPath + "/fsLfparalist.do?method=saveDetail";
	document.all.fsLfparalistForm.action = url;
	document.all.fsLfparalistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.fsLfparalistForm.reset();
}

