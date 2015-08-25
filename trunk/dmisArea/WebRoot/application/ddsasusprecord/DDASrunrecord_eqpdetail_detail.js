//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdSasusprecordForm(document.ddSasusprecordForm)){
		return false;
	}
	url = contextPath + "/ddSasusprecord.do?method=saveDetail";
	document.all.ddSasusprecordForm.action = url;
	document.all.ddSasusprecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddSasusprecordForm.reset();
}

