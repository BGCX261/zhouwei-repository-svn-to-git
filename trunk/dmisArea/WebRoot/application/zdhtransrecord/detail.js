//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	
	//if (!validateZdhTransrecordForm(document.zdhTransrecordForm)){
	//	return false;
	//}
	
	url = contextPath + "/zdhTransrecord.do?method=saveDetail";
	document.all.zdhTransrecordForm.action = url;
	document.all.zdhTransrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhTransrecordForm.reset();
} 

