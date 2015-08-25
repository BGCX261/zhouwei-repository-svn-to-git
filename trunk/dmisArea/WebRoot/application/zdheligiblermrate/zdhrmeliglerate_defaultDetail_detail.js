//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作

function onSaveForm(contextPath){
	/*
	if (!validateZdhEligiblermrateForm(document.zdhEligiblermrateForm)){
		return false;
	}
	* */
	url = contextPath + "/zdhEligiblermrate.do?method=saveDetail";
	document.all.zdhEligiblermrateForm.action = url;
	document.all.zdhEligiblermrateForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.zdhEligiblermrateForm.reset();
}

function getData(){
	var totalCount 	= parseInt(document.getElementById("zdhEligiblermrateDto.remotemeasureamount").value);
	var noCount		= parseInt(document.getElementById("zdhEligiblermrateDto.failuredatanoamount").value);
	if(totalCount >= noCount){
		var total   = "";
		if(noCount >0){
			total	= tofloat((totalCount/noCount),2);
		} else {
			total   = noCount;
		}
		document.getElementById("zdhEligiblermrateDto.eligiblerate").value = total;
	} else {
		//alert("不合格数据个数不能大于遥测数据总数!");
		document.getElementById("zdhEligiblermrateDto.eligiblerate").value = "0";
	}
}
function tofloat(f,dec){     
	  if(dec<0)   return   "Error:dec<0!";     
	  result=parseInt(f)+(dec==0?"":".");     
	  f-=parseInt(f);     
	  if(f==0)     
	  for(i=0;i<dec;i++)   result+='0';     
	  else   {     
	  for(i=0;i<dec;i++)   f*=10;     
	  result+=parseInt(Math.round(f));     
	  }     
	  return   result;     
}     

