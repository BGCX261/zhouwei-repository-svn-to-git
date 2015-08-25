//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	if (!validateDdSasusprecordForm(document.ddSasusprecordForm)){
		return false;
	}
	url = contextPath + "/ddSasusprecord.do?method=saveDetail";
	document.all.ddSasusprecordForm.action = url;
	document.all.ddSasusprecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddSasusprecordForm.reset();
}
//N-1后的负载率 n-1后电流/额定电流
function calaRate()
{
	var fncurrent = document.getElementById("ddSasusprecordDto.fncurrent");//最大负荷
	//alert(a.value);
	var fratedcurrent = document.getElementById("ddSasusprecordDto.fratedcurrent");//额定电流
	//alert(b.value);
	if (fmaxloadcur.value != 0 && !isNaN(parseInt(fmaxloadcur.value)))
	{
		if (fmaxloadcur.value !=""  && ffixcurrent.value != ""  )
		{
			var c = parseInt(fncurrent.value/fratedcurrent.value *100, 10)/100 ;
			document.getElementById("ddHloadrecordDto.fnloadrate").value = c*100;
		}
	}
}
