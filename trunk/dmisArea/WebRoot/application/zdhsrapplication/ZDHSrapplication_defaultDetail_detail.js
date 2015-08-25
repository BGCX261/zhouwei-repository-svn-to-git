//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*if (!validateZdhSrapplicationForm(document.zdhSrapplicationForm)){
		return false;
	}
	*/
	url = contextPath + "/zdhSrapplication.do?method=saveDetail";
	document.all.zdhSrapplicationForm.action = url;
	document.all.zdhSrapplicationForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhSrapplicationForm.reset();
}

