//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdLineForm(document.stdLineForm)){
		return false;
	}
	url = contextPath + "/stdLine.do?method=saveDetail";
	document.all.stdLineForm.action = url;
	document.all.stdLineForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdLineForm.reset();
}

