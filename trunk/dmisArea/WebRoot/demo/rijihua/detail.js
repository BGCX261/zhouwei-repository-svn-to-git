//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作
function onSaveForm(contextPath){
	if (!validateRijihuaForm(document.rijihuaForm)){
		return false;
	}
	url = contextPath + "/rijihua.do?method=saveDetail";
	document.all.rijihuaForm.action = url;
	document.all.rijihuaForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.rijihuaForm.reset();
}

//申请单位选择（业务数据字典）
function setSqdwSelect(){
	displayBusSelect('sqdw','sqdw','sqdwcode','src=SQDW');
	document.all.sqr.value = "";
}	
//申请人选择（业务数据字典）
function setSqrSelect(){
	var src = "src=SQR&dwdm="+document.getElementById("sqdwcode").value;
	displayBusSelect('sqr','sqr','',src);
}
//申请单位多项选择（业务数据字典）
function setSqdwMulSelect(){
	displayBusSelect('sqdwMul','sqdwMul','','src=SQDW','1');
}	

//选择设备（弹出简单列表）
function setSbSelect(){
	var param = new Object();
	var url = '/querySimple.do?method=queryPoper';
	var vReturnValue = showModalDialogYY(url,"800","460",param,"设备列表","auto");
	
	/**
	 * vReturnValue 格式说明
	 * 一维数组，［rowno#1^javascript:void(0)，列名＃列值，．．．．．］
	 * 如：［rowno#1^javascript:void(0)，dydj#10kv........］

	 */	
	
	if(vReturnValue != null){	
		var data	= vReturnValue.data;
		for(var m=0;m<data.length;m++){
			alert(data[m]);
		}
	}
}
//选择资源（弹出资源树）

function setResourceSelect(){
	var param = new Object();
	var url = '/demo/rijihua/restree.jsp';
	var vReturnValue = showModalDialogYY(url,"400","460",param,"资源树","no");

	/**
	 * vReturnValue 格式说明
	 * ｉｄ字符串，逗号分隔，顶级节点排在最后，值为－１，其他按选择顺序排列
	 * 如：８００１，８００２，８００３，－１　
	 */
	
	if(vReturnValue != null){
		alert(vReturnValue);	
	}
}

//选项组

function setTransOptions(){
	  //定义一个二维数组aArray,用于存放城市名称。

		var aCity=new Array();
		aCity[0]=new Array();
		aCity[1]=new Array();
		aCity[2]=new Array();
		aCity[3]=new Array();
		aCity[4]=new Array();
		aCity[5]=new Array();
		aCity[6]=new Array();
		aCity[7]=new Array();
	 
		//赋值，每个省份的城市存放于数组的一行。

		aCity[0][0]="北京";
		aCity[0][1]="beijing";
		aCity[1][0]="上海";
		aCity[1][1]="shanghai";
		aCity[2][0]="广州";
		aCity[2][1]="guangzhou";
		aCity[3][0]="南京";
		aCity[3][1]="nanjing";
		aCity[4][0]="重庆";
		aCity[4][1]="chongqing";
		aCity[5][0]="湘潭市";
		aCity[5][1]="xiangtan";
		aCity[6][0]="杭州市";
		aCity[6][1]="hangzhou";
		aCity[7][0]="成都市";
		aCity[7][1]="chengdu";
		
		var bCity=new Array();
		bCity[0]=new Array();
		bCity[0][0]="兰州";
		bCity[0][1]="lanzhou";
		
		var param = new Object();
		param.startArray = aCity;      //传递的数组参数
		param.endArray = bCity;      //传递的数组参数
		var vReturnValue = showModalDialogYY('/components/transfer/optionTransfer.jsp',"398","450",param,'列表互动','no');
		
		/**
		 * vReturnValue 格式说明
		 * 二维数组，［［名称，代码］，［］......]
		 * 如：［［杭州市，hangzhou］，［成都市，chengdu］......］

		 */
		for(var property in vReturnValue){ 
			var subvReturnValue1 = vReturnValue[property];
			for (property in subvReturnValue1){
				alert(property+":"+subvReturnValue1[property]);
			}
		}
}	
