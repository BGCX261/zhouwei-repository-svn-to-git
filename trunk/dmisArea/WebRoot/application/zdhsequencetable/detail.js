//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateZdhSequencetableForm(document.zdhSequencetableForm)){
		return false;
	}
	url = contextPath + "/zdhSequencetable.do?method=saveDetail";
	document.all.zdhSequencetableForm.action = url;
	document.all.zdhSequencetableForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhSequencetableForm.reset();
}

