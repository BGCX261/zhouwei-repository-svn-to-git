//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateZdhAutoondutylogForm(document.zdhAutoondutylogForm)){
		return false;
	}
	url = contextPath + "/zdhAutoondutylog.do?method=saveDetail";
	document.all.zdhAutoondutylogForm.action = url;
	document.all.zdhAutoondutylogForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhAutoondutylogForm.reset();
}

