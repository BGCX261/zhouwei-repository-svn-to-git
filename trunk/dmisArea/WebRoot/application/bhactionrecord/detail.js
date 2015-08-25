//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateBhActionrecordForm(document.bhActionrecordForm)){
		return false;
	}
	url = contextPath + "/bhActionrecord.do?method=saveDetail";
	document.all.bhActionrecordForm.action = url;
	document.all.bhActionrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.bhActionrecordForm.reset();
}

