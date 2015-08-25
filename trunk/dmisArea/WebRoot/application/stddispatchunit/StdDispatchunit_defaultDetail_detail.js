//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdDispatchunitForm(document.stdDispatchunitForm)){
		return false;
	}
	url = contextPath + "/stdDispatchunit.do?method=saveDetail";
	document.all.stdDispatchunitForm.action = url;
	document.all.stdDispatchunitForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdDispatchunitForm.reset();
}

