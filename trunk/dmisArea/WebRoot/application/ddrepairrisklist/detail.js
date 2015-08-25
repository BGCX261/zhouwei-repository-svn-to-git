//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdRepairrisklistForm(document.ddRepairrisklistForm)){
		return false;
	}
	url = contextPath + "/ddRepairrisklist.do?method=saveDetail";
	document.all.ddRepairrisklistForm.action = url;
	document.all.ddRepairrisklistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddRepairrisklistForm.reset();
}

