//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdSwitchseqbillForm(document.ddSwitchseqbillForm)){
		return false;
	}
	url = contextPath + "/ddSwitchseqbill.do?method=saveDetail";
	document.all.ddSwitchseqbillForm.action = url;
	document.all.ddSwitchseqbillForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddSwitchseqbillForm.reset();
}

