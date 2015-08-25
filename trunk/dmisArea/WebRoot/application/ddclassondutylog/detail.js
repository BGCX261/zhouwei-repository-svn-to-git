//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdClassondutylogForm(document.ddClassondutylogForm)){
		return false;
	}
	url = contextPath + "/ddClassondutylog.do?method=saveDetail";
	document.all.ddClassondutylogForm.action = url;
	document.all.ddClassondutylogForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddClassondutylogForm.reset();
}

