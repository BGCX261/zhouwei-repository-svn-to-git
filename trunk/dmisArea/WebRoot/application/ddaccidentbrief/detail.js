//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdAccidentbriefForm(document.ddAccidentbriefForm)){
		return false;
	}
	url = contextPath + "/ddAccidentbrief.do?method=saveDetail";
	document.all.ddAccidentbriefForm.action = url;
	document.all.ddAccidentbriefForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddAccidentbriefForm.reset();
}

