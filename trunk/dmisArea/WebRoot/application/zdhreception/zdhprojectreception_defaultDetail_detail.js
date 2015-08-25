//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
/*	if (!validateZdhReceptionForm(document.zdhReceptionForm)){
		return false;
	}*/
	url = contextPath + "/zdhReception.do?method=saveDetail";
	document.all.zdhReceptionForm.action = url;
	document.all.zdhReceptionForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhReceptionForm.reset();
}

