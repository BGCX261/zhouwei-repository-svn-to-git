//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdHloadrecordForm(document.ddHloadrecordForm)){
		return false;
	}
	url = contextPath + "/ddHloadrecord.do?method=saveDetail";
	document.all.ddHloadrecordForm.action = url;
	document.all.ddHloadrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddHloadrecordForm.reset();
}

