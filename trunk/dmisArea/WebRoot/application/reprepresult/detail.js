//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateRepRepresultForm(document.repRepresultForm)){
		return false;
	}
	url = contextPath + "/repRepresult.do?method=saveDetail";
	document.all.repRepresultForm.action = url;
	document.all.repRepresultForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.repRepresultForm.reset();
}

