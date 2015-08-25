//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateDdSasusprecordForm(document.ddSasusprecordForm)){
		return false;
	}
	*/
	url = contextPath + "/ddSasusprecord.do?method=saveDetail";
	document.all.ddSasusprecordForm.action = url;
	document.all.ddSasusprecordForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.ddSasusprecordForm.reset();
}

//N-1后的负载�?n-1后电�?额定电流
function calaRate()
{
	var fncurrent = document.getElementById("ddSasusprecordDto.fncurrent");//最大负�?
	//alert(a.value);
	var fratedcurrent = document.getElementById("ddSasusprecordDto.fratedcurrent");//额定电流
	//alert(b.value);
	if (fratedcurrent.value != 0 && !isNaN(parseInt(fratedcurrent.value)))
	{
		if (fncurrent.value !=""  && fratedcurrent.value != ""  )
		{
			var c = parseInt(fncurrent.value/fratedcurrent.value *100, 10)/100 ;
			document.getElementById("ddSasusprecordDto.fnloadrate").value = c*100;
		}
	}
}
//计算时长恢复时间-开始时间（结果是分钟）
function calatime(){
	var frestoretime = document.getElementById("ddSasusprecordDto.frestoretime");//恢复时间
	var fsusptime = document.getElementById("ddSasusprecordDto.fsusptime");//停用时间
	
	
}

