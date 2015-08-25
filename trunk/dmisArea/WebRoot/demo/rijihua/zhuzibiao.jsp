
<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/SaDtlFacade.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script  src="<%=request.getContextPath()%>/script/grid/editgrid.js"></script>
<script  src="<%=request.getContextPath()%>/script/general.js"></script>

<script language="javascript">



 		  
//var gg = "salesId^String^1^123###hh^5@@@saTypeId^4^dfdf^tt@@@goodsId^555^yyy^hhh@@@goodsName^ggg^uuu^uuu@@@goodsType^ggg^ggg^ggg@@@goodsUnit^llll^JJj^hhh@@@prodarea^yyy^ggg^ggg@@@goodsQty^6^ggg^yy@@@unitPrice^66^yyy^uuu@@@priceName^yyy^yyy^YYY@@@total_line^66^uuu^uuu";
//var hh  ="###hh^5@@@saTypeId^4^dfdf^tt@@@goodsId^555^yyy^h  hh@@@goodsName^按时打发但是发^uuu^uuu@@@goodsType^ggg^ggg^ggg@@@goodsUnit^llll^JJj^hhh@@@prodarea^yyy^ggg^ggg@@@goodsQty^6^ggg^yy@@@unitPrice^66^yyy^uuu@@@priceName^yyy^yyy^YYY@@@total_line^66^uuu^uuu";
//var ee ="###hh^5@@@salesDtlId^B77E1064FFFA87EA87BA9E8976AB89^有有有^日日日日@@@saTypeId^4^dfdf^tt@@@goodsId^555^yyy^hhh@@@goodsName^安定发达法^uuu^uuu@@@goodsType^ggg^ggg^ggg@@@goodsUnit^llll^JJj^hhh@@@prodarea^高高高^ggg^ggg@@@goodsQty^6^ggg^yy@@@unitPrice^66^yyy^uuu@@@priceName^yyy^yyy^YYY@@@total_line^66^uuu^uuu";
//var  dd="###hh^5@@@salesDtlId^B77B3E64FFFA87EA3BDCBCAAD93A34^有有有^日日日日@@@saTypeId^4^dfdf^tt@@@goodsId^555^yyy^hhh@@@goodsName^安定发达法^uuu^uuu@@@goodsType^ggg^ggg^ggg@@@goodsUnit^llll^JJj^hhh@@@prodarea^高高高^ggg^ggg@@@goodsQty^6^ggg^yy@@@unitPrice^66^yyy^uuu@@@priceName^yyy^yyy^YYY@@@total_line^66^uuu^uuu";
//var deltr = "B79B8905FFFA87EA1B76D6117CB9DD###B79CCB4DFFFA87EA124B4A972532C63";
 			  




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
								  ],
					'reedate'    :[
							        	['CompareDate',["resdate","yyyy-MM-dd",2],'汇款结束日期日期迟于回款开始日期']
								  ]	
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
 
 			  
		
</script>
