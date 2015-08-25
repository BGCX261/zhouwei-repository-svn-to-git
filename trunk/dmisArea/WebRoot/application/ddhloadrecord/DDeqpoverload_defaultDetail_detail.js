//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateDdHloadrecordForm(document.ddHloadrecordForm)){
		return false;
	}
	**/
	url = contextPath + "/ddHloadrecord.do?method=saveDetail";
	document.all.ddHloadrecordForm.action = url;
	document.all.ddHloadrecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddHloadrecordForm.reset();
}

//计算最高负载率最大负荷电流/额定电流%
function calaRate()
{
	var fmaxloadcur = document.getElementById("ddHloadrecordDto.fmaxloadcur");//最大负荷
	//alert(a.value);
	var ffixcurrent = document.getElementById("ddHloadrecordDto.ffixcurrent");//额定电流
	//alert(b.value);
	if (fmaxloadcur.value != 0 && !isNaN(parseInt(fmaxloadcur.value)))
	{
		if (fmaxloadcur.value !=""  && ffixcurrent.value != ""  )
		{
			var c = parseInt(fmaxloadcur.value/ffixcurrent.value *100, 10)/100 ;
			document.getElementById("ddHloadrecordDto.fhighestloadrate").value = c*100;
		}
	}
}
