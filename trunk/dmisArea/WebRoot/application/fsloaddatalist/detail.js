//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateFsLoaddatalistForm(document.fsLoaddatalistForm)){
		return false;
	}
	url = contextPath + "/fsLoaddatalist.do?method=saveDetail";
	document.all.fsLoaddatalistForm.action = url;
	document.all.fsLoaddatalistForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.fsLoaddatalistForm.reset();
}

