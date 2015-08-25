
function getContextPath() {
	var url = location.href;
	if (url.indexOf("http://") < 0) {
		return "./";
	}
	url = url.substring(url.indexOf("http://") + 7);
	if (url.indexOf("/") < 0) {
		return "";
	}
	url = url.substring(url.indexOf("/") + 1);
	var pos;
	if (url.indexOf("/") >= 0) {
		pos = url.indexOf("/");
	} else {
		pos = url.length;
	}
	url = url.substring(0, pos);
	return url;
}

//用Modal对话框打开设备台账页面
function OpenEquipmentModal(paraValues)
{
	if (typeof(paraValues) != "object")
	{
	   alert("传递给设备台账对话框参数数据类型不正确，必须是Object！");
	   return;
	} 

	//参数对象
	var eqpArgument = new Object();
	

	//对话框窗口标题
	eqpArgument.title = paraValues.title;
	if (!eqpArgument.title) eqpArgument.title = "设备台账管理";
	
	//应用视角
	eqpArgument.viewId = paraValues.viewId;
	if (!eqpArgument.viewId) eqpArgument.viewId = "default";
	
	//查询条件
	eqpArgument.condition = paraValues.condition;
	
	//是否显示“确认”和“取消”按钮
	eqpArgument.showButton = paraValues.showButton;
	if (!eqpArgument.showButton) eqpArgument.showButton = true;
	
	//数据是否只读
	eqpArgument.readOnly = paraValues.readOnly;
	if (!eqpArgument.readOnly) eqpArgument.readOnly = false;
	
	//是否允许选择多行数据
	eqpArgument.multiSelect = paraValues.multiSelect;
	if (!eqpArgument.multiSelect) eqpArgument.multiSelect = false;
	
	//要返回的数据字段，字段名直接用","分隔，也支持以下2个特殊值之一：	//      {all}   --  返回所有可用字段数据
	//      {id}    --  只返回eqpid（这是默认值）
	eqpArgument.returnedFields = paraValues.returnedFields;
	if (!eqpArgument.returnedFields) eqpArgument.returnedFields = "{all}";

	//厂站（根据厂站限制设备记录）
	eqpArgument.stationName = paraValues.stationName;
	if (!eqpArgument.stationName) eqpArgument.stationName = "";
	
	//调度单位（根据调度单位来过滤可操作的数据）
	eqpArgument.manageUnit = paraValues.manageUnit;
	if (!eqpArgument.manageUnit) eqpArgument.manageUnit = "";
	
	//任意的查询条件where子句，使用sql语句的where子句语法
	eqpArgument.filterString = paraValues.filterString;  
	

    var equipmentUrl;
    equipmentUrl = "/"+getContextPath()+"/eqpEquipment.do?method=eqpEquipmentframe";
    
  	//detection for IE
  	if (navigator.userAgent.indexOf('MSIE') != -1)
	{
		var winH = screen.availHeight - 100;
		if (winH<760) winH = 760;
		var winW = screen.availWidth - 20;
		if (winW<1100) winW = 1100;
  	    window.showModalDialog(equipmentUrl,paraValues,"dialogWidth="+winW+"px;dialogHeight:"+winH+"px;resizable:yes;");
  	    return paraValues.returnValue;
	}
	// detection for Firefox
    else if (navigator.userAgent.indexOf("Firefox") != -1)
    {
		alert("not support Firefox, please use IE6");
		return null;
		//returnedV = window.open(equipmentUrl,paraValues);
	}
	else
	{
		alert("not supported browser, please use IE6");
		return null;
	}
}


