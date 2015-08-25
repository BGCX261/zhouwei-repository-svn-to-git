//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateGgRelpersonForm(document.ggRelpersonForm)){
		return false;
	}
	url = contextPath + "/ggRelperson.do?method=saveDetail";
	document.all.ggRelpersonForm.action = url;
	document.all.ggRelpersonForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ggRelpersonForm.reset();
}

