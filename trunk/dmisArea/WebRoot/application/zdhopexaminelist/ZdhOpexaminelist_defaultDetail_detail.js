//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
/*	if (!validateZdhOpexaminelistForm(document.zdhOpexaminelistForm)){
		return false;
	}
	*/
	url = contextPath + "/zdhOpexaminelist.do?method=saveDetail";
	document.all.zdhOpexaminelistForm.action = url;
	document.all.zdhOpexaminelistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhOpexaminelistForm.reset();
}

