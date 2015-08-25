function onSave(contextPath){
	//if (!validateRijihuaForm(document.rijihuaForm)){
		//return false;
	//}
	url = contextPath + "/rijihua.do?method=saveGridCard_card";
	document.all.rijihuaForm.action = url;
	document.all.rijihuaForm.submit();
}

function onReset(contextPath){
	document.all.rijihuaForm.reset();
}