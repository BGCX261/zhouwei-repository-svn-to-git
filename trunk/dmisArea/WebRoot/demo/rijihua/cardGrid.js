//必须固定名称为onSaveForm，否则工具栏按钮将不执行任何动作
function onSaveForm(contextPath){
	//if (!validateRijihuaForm(document.rijihuaForm)){
		//return false;
	//}
	url = contextPath + "/rijihua.do?method=saveCardDetail";
	document.all.rijihuaForm.action = url;
	document.all.rijihuaForm.submit();
}

//必须固定名称为onResetForm，否则工具栏按钮将不执行任何动作
function onResetForm(contextPath){
	document.all.rijihuaForm.reset();
}



//验证规则 
  var checkRules={  'goodsName'   :[
										['isNotNull',null,'品名不能为空'],
										['checkLength',[20,0],'品名长度不能大于20小于0']
								   ],
					
					 'saTypeId'   :[
					 					['isInt',null,'销售类型应该为整数']
					 			   ],
					 'goodsQty'   :[
					 					['isNumber',null,'销售数量应该为double']
					 			  ],
					 'unitPrice' :[
					 					['isNumber',null,'单价应该为double']
					 			  ],
					 'total_line':[
					 					['isNumber',null,'金额应该为double']
					 			  ],
					'credate'    :[
							        	['isDate',["yyyy-MM-dd"],'创建日期格式不对']
								  ],
					'resdate'    :[
							        	['isDate',["yyyy-MM-dd"],'回款开始日期格式不对']
								  ]
					//'reedate'    :[
							   //     	['CompareDate',["resdate","yyyy-MM-dd",2],'汇款结束日期日期迟于回款开始日期']
								//  ]	
			 		 };
//保存用
 function  savegrid(){
  
         //得到保存的字符串
		 str = iGrid.getUpdateData(1);
         //生成验证对象
	     var checkObj =  new checkObject(null,checkRules);;
		 //初始化rowsObject
	 	 ro = new editrowsObject('iGrid',str,checkObj,SaDtlFacade.saveOrupdateSaDtls);
	 	 //保存用
	 	 ro.doSaveOrUpdate();
 }
 
 //删除用
 function deletegrid(){
	     //得到删除的ID
	     str = iGrid.getUpdateData(3);
	    //初始化rowsObject
	     ro = new editrowsObject('iGrid',str,null,null,SaDtlFacade.deleteSaDtls);
	     //调用删除方法
	     ro.doDelete();
 }
 
 			  