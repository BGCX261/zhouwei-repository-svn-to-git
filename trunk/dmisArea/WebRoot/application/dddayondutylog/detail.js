//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdDayondutylogForm(document.ddDayondutylogForm)){
		return false;
	}
	url = contextPath + "/ddDayondutylog.do?method=saveDetail";
	document.all.ddDayondutylogForm.action = url;
	document.all.ddDayondutylogForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddDayondutylogForm.reset();
}

