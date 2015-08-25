//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateFsRmchangbillForm(document.fsRmchangbillForm)){
		return false;
	}
	url = contextPath + "/fsRmchangbill.do?method=saveDetail";
	document.all.fsRmchangbillForm.action = url;
	document.all.fsRmchangbillForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.fsRmchangbillForm.reset();
}

