//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateZdhWorkbillForm(document.zdhWorkbillForm)){
		return false;
	}
	*/
	url = contextPath + "/zdhWorkbill.do?method=saveDetail";
	document.all.zdhWorkbillForm.action = url;
	document.all.zdhWorkbillForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhWorkbillForm.reset();
}

