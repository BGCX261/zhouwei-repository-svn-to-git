/**
 * 提供子表的查询条件,即主表的主键名及其主键值,支持联合主键
 * 参数:priColVal 主键名及其主键值组合的字符串

       形如：id^string^1^639622^^asc
 */
function rowChangedToChild(priColVal,contextPath,listKind){     
        //var tmp = priColVal.replace("id","salesId")
        tmp = "salesId"+"^"+"string"+"^"+"1"+"^"+priColVal+"^^"+"asc"
        var childUrl = contextPath+'/rijihua.do?method=initCardGrid_grid&refId='+tmp;        
        document.getElementById("iGridDown").src = childUrl;   
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
 function savegrid(){
  
         //得到保存的字符串
		 str = iGridDown.getUpdateData(1);
         //生成验证对象
	     var checkObj =  new checkObject(null,checkRules);;
		 //初始化rowsObject
	 	 ro = new editrowsObject('iGridDown',str,checkObj,SaDtlFacade.saveOrupdateSaDtls);
	 	 //保存用

	 	 ro.doSaveOrUpdate();
 }
 
 //删除用
 function deletegrid(){
	     //得到删除的ID
	     str = iGridDown.getUpdateData(3);
	    //初始化rowsObject
	     ro = new editrowsObject('iGridDown',str,null,null,SaDtlFacade.deleteSaDtls);
	     //调用删除方法
	     ro.doDelete();
 }