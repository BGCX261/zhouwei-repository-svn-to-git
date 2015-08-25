//å¿é¡»åºå®åç§°ä¸ºonSaveFormï¼å¦åå·¥å·æ æé®å°ä¸æ§è¡ä»»ä½å¨ä½

function onSaveForm(contextPath){
/*	if (!validateZdhSequencetableForm(document.zdhSequencetableForm)){
		return false;
	}*/
	url = contextPath + "/zdhSequencetable.do?method=saveDetail";
	document.all.zdhSequencetableForm.action = url;
	document.all.zdhSequencetableForm.submit();
}

//å¿é¡»åºå®åç§°ä¸ºonResetFormï¼å¦åå·¥å·æ æé®å°ä¸æ§è¡ä»»ä½å¨ä½
function onResetForm(contextPath){
	document.all.zdhSequencetableForm.reset();
}

