//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateZdhCharalterrecordForm(document.zdhCharalterrecordForm)){
		return false;
	}
	* */
	url = contextPath + "/zdhCharalterrecord.do?method=saveDetail";
	document.all.zdhCharalterrecordForm.action = url;
	document.all.zdhCharalterrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhCharalterrecordForm.reset();
}

