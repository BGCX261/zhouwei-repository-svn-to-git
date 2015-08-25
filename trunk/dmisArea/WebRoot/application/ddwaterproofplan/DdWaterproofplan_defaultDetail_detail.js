//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateDdWaterproofplanForm(document.ddWaterproofplanForm)){
		return false;
	}
	*/
	url = contextPath + "/ddWaterproofplan.do?method=saveDetail";
	document.all.ddWaterproofplanForm.action = url;
	document.all.ddWaterproofplanForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddWaterproofplanForm.reset();
}



