//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/**if (!validateDdCutofftitleForm(document.ddCutofftitleForm)){
		return false;
	}
	*/
	url = contextPath + "/ddCutofftitle.do?method=saveDetail";
	document.all.ddCutofftitleForm.action = url;
	document.all.ddCutofftitleForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddCutofftitleForm.reset();
}

