//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateStdModelForm(document.stdModelForm)){
		return false;
	}
	url = contextPath + "/stdModel.do?method=saveDetail";
	document.all.stdModelForm.action = url;
	document.all.stdModelForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.stdModelForm.reset();
}

