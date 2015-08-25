//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	//if (!validateZdhRmrecForm(document.zdhRmrecForm)){
	//	return false;
	//}
	url = contextPath + "/zdhRmrec.do?method=saveDetail";
	document.all.zdhRmrecForm.action = url;
	document.all.zdhRmrecForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhRmrecForm.reset();
}

