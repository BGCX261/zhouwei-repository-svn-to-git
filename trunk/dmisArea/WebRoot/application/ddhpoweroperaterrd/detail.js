//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdHpoweroperaterrdForm(document.ddHpoweroperaterrdForm)){
		return false;
	}
	url = contextPath + "/ddHpoweroperaterrd.do?method=saveDetail";
	document.all.ddHpoweroperaterrdForm.action = url;
	document.all.ddHpoweroperaterrdForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddHpoweroperaterrdForm.reset();
}

