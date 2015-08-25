//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateZdhFaultlistForm(document.zdhFaultlistForm)){
		return false;
	}
	* */
	url = contextPath + "/zdhFaultlist.do?method=saveDetail";
	document.all.zdhFaultlistForm.action = url;
	document.all.zdhFaultlistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhFaultlistForm.reset();
}

