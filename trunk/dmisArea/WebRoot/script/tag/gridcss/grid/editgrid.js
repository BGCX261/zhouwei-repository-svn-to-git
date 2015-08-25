 
 
 
 /**
   *
   *验证 与 调用后台 dwr
   *rowsstr 字符串
   *func 验证调用的func
   *dwrfunc1 更新增加是调用的dwr方法
   *dwrfunc2 删除是调用的dwr 方法
   *
   */
 function editrowsObject(grid,rowsstr,checkObj,dwrfunc1,dwrfunc2)
 {    
	this.rowsstr = rowsstr;
	//验证用里边为 rowObj 对象
	this.rows=new Array();
	//验证用的对象类
	this.checkObj = checkObj;
	//传给dwr的数据结构
	this.dwrdat = new Array();
	//调用的dwr函数	保存用
	if(typeof(dwrfunc1)=="function")
		this.dwrsaveorupdatefunc=dwrfunc1;
	else
		this.dwrsaveorupdatefunc=eval(dwrfunc1);
		
	//调用的dwr函数	保存用 删除用
	if(typeof(dwrfunc2)=="function")
		this.dwrdeletefunc=dwrfunc2;
	else
		this.dwrdeletefunc=eval(dwrfunc2);
	
	this.grid=grid;
	return this;
	
	
 }
 
		  
/**
  * 存如一行记录用的对象 
  * rowId 为行号
  *coloums 里边封装多个数组，每个数组的构造为[proptyName,value,zhname,type] proptyName：对应的属性名称； value：值；zhname：中文显示名称；type：类型 
  */
function editrowObj(rowId)
{       
	this.rowId=rowId;
	this.coloums =new Array();
}

/*
 *根据字段名称查值
 *
 */
editrowObj.prototype.getValueByColName=function(colname){
    var valu;
	for(var i=0;i<(this.coloums).length;i++){
		if(colname==this.coloums[i][0]){
			valu = this.coloums[i][1];
			break;
		}
	}
	if(valu==null){
		alert(colname+"不存在");
		return "999:not exit";
	}
    return valu;
}



/**
  *把子符串封装到到editrowObj里验证用
  *rowsstr:salesId^String^1^123###hh^5@@@saTypeId^4^销售类型^String@@@goodsId^555^yyy^hhh###hh^5@@@saTypeId^4^dfdf^tt@@@goodsId^555^yyy^hhh
  *"###"分割记录，"@@@"分割字段 第一个"###"之前为外键Id，saTypeId^4^销售类型^String saTypeId：对应的属性名称；4 值；销售类型 ：显示的中文名称 ;String 为字段类型
  */
editrowsObject.prototype.tranStrToRows = function()
{   //分解成行
	var n_rows = this.rowsstr.split('###');
	var fa = n_rows[0].split("\^");
	if(fa[3]==null||fa[3].length<=0){
		//alert("没有相关联的主记录");
		return false;
	}
	for(i=1;i<n_rows.length;i++)
	{   //从第2个开始,第一个为主卡片id
		var n_row = n_rows[i];
		//分解出行号和字段内容
		var conts = n_row.split("@@@");
		//截取 行号和内容
		var hh = conts[0].split("\^")[1];

		//创造行对象 
		var rowo = new editrowObj(hh);

		//取得字段内容从第2个开始,第1个为行号 把内容存到 行对象的coloums 中 类似与array的形式['saTypeId',4,'交易类型','string']
		for(k=1;k<conts.length;k++){
			var _colums = conts[k].split("\^");
			var array1 = new Array();
			array1.push(_colums[0]);
			array1.push(_colums[1]);
			array1.push(_colums[2]);
			array1.push(_colums[3]);
			rowo.coloums.push(array1);
			//alert("rowid"+rowo.rowId+" "+rowo.coloums[_colums[0]] );
		}
		//把行对象放入rowsObject的rows 数组中
		this.rows.push(rowo);
	}	
	return true;	
}
 
     
/**
  * 把字符串转换为dwr 所用的数据结构为一个List 里边每条记录对应一个map的数据结构 key是属性名称 value是值[{saTypeId:'4',goodsName:'uuu'},{saTypeId:5,goodsName:'fff'}}
  */
editrowsObject.prototype.construtDate=function (){
	  var n_rows = this.rowsstr.split('###');
	    //父id的属性名称 父id的属性值
	  var fathercolumn = n_rows[0].split("\^");
	  var fna = fathercolumn[0];
	  var fva = fathercolumn[3];
	  for(var i=1;i<n_rows.length;i++)
	  {
		  	var n_row = n_rows[i];
		  	//分割内容
			var conts = n_row.split("@@@");
			//把父id到如对象o，o类似与map结构
			var o = new Object();
			o[fna]=fva;
			for( j=1;j<conts.length;j++)
			{
				//分割属性
				var _colums = conts[j].split("\^");
				//alert(_colums[0] + " " +_colums[1]);
				o[_colums[0]]=_colums[1];
			}
			this.dwrdat.push(o);
	 }	
}
       
 			
 			      
 /*
  * 保存数据
  */
 editrowsObject.prototype.doSaveOrUpdate = function(){
    var flag = this.tranStrToRows();
 	if(!flag)
 	{
 		return false;
 	}
 
   if(this.rows.length<=0)
   {
 		alert("没有数据项请修改或添加记录");
 		return false;
 	}

 	//调用自定义函数进行验证
 	 if(this.checkObj)
 	    flag=this.checkObj.executeCheck(this.rows);
 	 else
 	 	flag=true;
 	//构造dwr参数
 	if(flag)
 	{
 		this.construtDate();//构造后台需要的数据集
 		if(this.dwrdat.length>0)
 		{
 		    var dat = this.dwrdat;
 		    //调用 dwr函数
 			this.dwrsaveorupdatefunc(dat,returnSaveOrUpdate);
 		}
 	}
 	
 	//保存成功后的回掉函数用于显示成功或失败的信息并调用刷新页面的函数
 	var  grid1 = this.grid;
 	function returnSaveOrUpdate(ret)
 	{
 	    var message;
   		if(ret=='1'){
   			message="保存成功";
   		}else{
   			message="保存失败";
   		}
   	    //调用grid函数更新数据
   	    var ese=grid1+".afterUpdate("+parseInt(ret)+",'"+message+"')";
   	    //this.grid.afterUpdate(parseInt(ret),message);
   	    eval(ese);
   	}
 
}
 	   
/**
*删除记录操作
* 
*/
 editrowsObject.prototype.doDelete=function (){
      //rowno^1@@@saldDtid^222###rowno^2@@@salid^444  无id表示还没有在数据库存储
      str2 = this.rowsstr.split("###");
      if(str2.length<=0){
      	return ;
      }
      message = "删除第";
      //存放id的Array
      ids = new Array();
      for(i=0;i<str2.length;i++)
      {
	      //截取行号和Id
	      var content= str2[i].split("@@@");
	      //行号
	      var hh = content[0].split("\^")[1];
	      if(i==str2.length-1){
	      	message+=hh+"行";
	      }else{
	      	message+=hh+",";
	      }
	      //把Id装入Arraya
	      if(content[1].split("\^")[1])
	      ids.push(content[1].split("\^")[1]);
      }
      
      if(ids.length>0){
      	//如果删除的为后台数据调用dwr的删除方法
 		this.dwrdeletefunc(ids,returnDel);
 	  }else{
 	   //只是删除前台没有保存到数据库的数据
 	  	message+="成功";
 	  	//调用grid函数调用数据
 	  	//this.grid.afterUpdate(parseInt(3),message);
 	  	var ese=this.grid+".afterUpdate("+parseInt(3)+",'"+message+"')";
 	  	eval(ese);
 	  }
 	
 	
 	//回调函数用于显示成功或失败的信息并调用刷新页面的函数
 	var grid1 = this.grid;
 	function returnDel(ret)
 	{
 		if(ret=='3'){
 			message+="成功";
 		}else{
 			message+="失败";
 		}
 		//this.grid.afterUpdate(parseInt(ret),message);
 		
 		var ese=grid1+".afterUpdate("+parseInt(ret)+",'"+message+"')";
 	  	eval(ese);
 	    //alert(message);
 	}
 }
 

/**
 * 验证对象做验证用
 *@ param exCheckFunc 如果基本验证满足不了需求的化，可以自定义验证 例：
 *  function exeCheckFunc(date){
 *       date :里边封装多个数组，每个数组的构造为[proptyName,value,zhname,type] proptyName：对应的属性名称； value：值；zhname：中文显示名称；type：类型 
 		if(验证通过)return true; 
 		else return "出错信息";    
 *  }
 *@ checkRules 基本的验证规则 例：{'goodsName'//属性名称  :[
 *											['isNotNull'//调用的验证方法名称,null//调用方法的参数,'品名不能为空'//显示的出错信息],
 *											['checkLength',[20,0],'品名长度不能大于20小于0']
 *								          ],
 *							
 * 							 'saTypeId'  :[
 *							 					['isInt',null,'销售类型应该为整数']
 *							 			  ]}
 */
function checkObject(exCheckFunc,checkRules){
	this.checkRules=checkRules;
	if(typeof(exCheckFunc)=="function")
		this.exCheckFunc=exCheckFunc;
	else
		this.exCheckFunc=eval(exCheckFunc);
	return this;
}

/**
 *对验证对象执行验证 根据验证对象里rules 规则来找到验证规则进行验证 正确时返回true，错误是返回错误信息
 *@param rows为数组 里边为多个editrowObj对象 
 */
checkObject.prototype.executeCheck=function (rows){
    //不需要验证
	if((!this.checkRules||this.checkRules.length<0)&&!this.exCheckFunc){
	 	return true;
	}
	var message ="";
	for(var j=0;j<rows.length;j++){
	    var editrow = rows[j];
	    var mess = this.checkColumn(editrow);
	    if(mess!=true){
	    	message+=mess+"\n";
	    }
	}
	if(message!=""){
	   alert(message);
	    return false;
	}
	return true;
}



/**
 *根据验证规则验证editrowObj(可编辑行对象)
 *@param editrowObj可编辑行对象
 *@return  验证通过返回true 错误返回错误信息
 */
checkObject.prototype.checkColumn=function (editrowObj){
		var rowId = editrowObj.rowId;
	    var clos = editrowObj.coloums;
	    var row_message = "第";
	    errflag = true;
	     
	     for(var i=0;i<clos.length;i++)
	     {     
		    	var coloumn = clos[i];
		    	//如果存在验证规则
		    	if(this.checkRules)
		    	{
		    		var rule =  this.checkRules[coloumn[0]];
		    	//验证开始
				    	if(rule!=null&&rule.length>0)
				    	{    
						    		for(var k=0;k<rule.length;k++)
						    		{   
							    			var sub_rule = rule[k];
							    			//非空验证
							    			if(sub_rule[0]=="isNotNull")
								    		{      
								    			   if(!isNotNull(coloumn[1]))
								    			   {        
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			}
							    			//验证输入的长度范围
		
							    			else if(sub_rule[0]=="checkLength")
							    			{
								    			    paras = sub_rule[1];
								    			   if(!checkLength(coloumn[1],paras[0],paras[1]))
								    			   { 
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			  
							    			 }
							    			 //判断是否等于规定长度
							    			else if(sub_rule[0]=="isSize")
							    			{
								    			    paras = sub_rule[1];
								    			   if(!isSize(coloumn[1],paras[0]))
								    			   { 
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			  
							    			 }
							    			 //判断是否为日期
		
							    			 else if(sub_rule[0]=="isDate")
							    			 {     paras = sub_rule[1];
								    			   if(!isDate(coloumn[1],paras[0]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 
							    			 //比较日期
							    			 else if(sub_rule[0]=="CompareDate")
							    			 {     paras = sub_rule[1];
							    			 	   var valu=editrowObj.getValueByColName(paras[0]);
							    			 	   if(valu=="999:not exit"){
							    			 	   		createMessage(paras[0]+"不存在");
							    			 	   }
							    			 	   else{
									    			   if(!CompareDate(coloumn[1],valu,paras[1],paras[2]))
									    			   {   
									    			   			createMessage(sub_rule[2]);
									    			   }
									    			}
							    			 }
							    			 //判断是否为int
							    			  else if(sub_rule[0]=="isInt")
							    			 {
								    			   if(!isInt(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //判断是否为数字
		
							    			 else if(sub_rule[0]=="isNumber")
							    			 {
								    			   if(!isNumber(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //判断是否为邮件地址
							    			  else if(sub_rule[0]=="isEmail")
							    			 {
								    			   if(!isEmail(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //电话格式效验
							    			 else if(sub_rule[0]=="isTelephone")
							    			 {
								    			   if(!isTelephone(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //判断是否为英文
		
							    			 else if(sub_rule[0]=="isEnglish")
							    			 {
								    			   if(!isEnglish(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //判断是否为中文
		
							    			 else if(sub_rule[0]=="isChinese")
							    			 {
								    			   if(!isChinese(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //判断是否为身份证
							    			 else if(sub_rule[0]=="isCardNum")
							    			 {
								    			   if(!isCardNum(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 //邮政编码判断
							    			 else if(sub_rule[0]=="isZipCode")
							    			 {
								    			   if(!isZipCode(coloumn[1]))
								    			   {   
								    			   			createMessage(sub_rule[2]);
								    			   }
							    			 }
							    			 
							    			 
						    	    }
				    	}
				  //验证结束
			   }
	    }//for循环结束
	     
	    //调用自定义验证函数
	    if(this.exCheckFunc)
	    {
	    	var exemess = this.exCheckFunc(clos);
	    	if(exemess!=true)
	    		createMessage(exemess);
	    }
	     
	    if(!errflag)
	    {
	    	return row_message;
	    }
	    else
	    {
	    	return errflag;
	    }
	    
	    //创建错误信息用

	    function  createMessage(_message)
	    {   errflag = false;
	    	if (row_message.split("行:").length>1)
					row_message+=" "+_message;
			else
			 		row_message="第"+rowId+"行:"+_message;
	    }
}



// 用正则表达式将前后空格
// 用空字符串替代。
function trim(str)
{
	return str.replace(/(^\s*)|(\s*$)/g, "");
}
 	    
 	    