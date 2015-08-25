//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作
function onSaveForm(contextPath) {
	/**if (!validateDdCutoffsequenceForm(document.ddCutoffsequenceForm)){
		return false;
	}
	*/
	url = contextPath + "/ddCutoffsequence.do?method=saveDetail";
	document.all.ddCutoffsequenceForm.action = url;
	document.all.ddCutoffsequenceForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath) {
	document.all.ddCutoffsequenceForm.reset();
}

