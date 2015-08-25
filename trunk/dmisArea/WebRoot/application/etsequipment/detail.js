//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateEtsEquipmentForm(document.etsEquipmentForm)){
		return false;
	}
	url = contextPath + "/etsEquipment.do?method=saveDetail";
	document.all.etsEquipmentForm.action = url;
	document.all.etsEquipmentForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.etsEquipmentForm.reset();
}

