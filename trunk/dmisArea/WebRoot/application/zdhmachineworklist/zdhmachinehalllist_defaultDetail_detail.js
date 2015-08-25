//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
/*	if (!validateZdhMachineworklistForm(document.zdhMachineworklistForm)){
		return false;
	}
	*/
	url = contextPath + "/zdhMachineworklist.do?method=saveDetail";
	document.all.zdhMachineworklistForm.action = url;
	document.all.zdhMachineworklistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhMachineworklistForm.reset();
}

