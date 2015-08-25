//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateBhFixedvaluebillForm(document.bhFixedvaluebillForm)){
		return false;
	}
	url = contextPath + "/bhFixedvaluebill.do?method=saveDetail";
	document.all.bhFixedvaluebillForm.action = url;
	document.all.bhFixedvaluebillForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.bhFixedvaluebillForm.reset();
}

