//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateZdhRsrecordForm(document.zdhRsrecordForm)){
		return false;
	}
	* */
	url = contextPath + "/zdhRsrecord.do?method=saveDetail";
	document.all.zdhRsrecordForm.action = url;
	document.all.zdhRsrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhRsrecordForm.reset();
}

