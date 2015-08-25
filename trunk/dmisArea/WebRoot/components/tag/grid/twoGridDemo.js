/**
 * 提供子表的查询条件,即主表的主键名及其主键值,支持联合主键
 * 参数:priColVal 主键名及其主键值组合的字符串
       形如：id^string^1^639622^^asc
 */
function rowChangedToChild(priColVal,gridKind){   
        alert(priColVal);  
        //var tmp = priColVal.replace("id","salesId")
        //tmp = "salesId"+"^"+"string"+"^"+"1"+"^"+priColVal+"^^"+"asc"
        //var childUrl = contextPath+'/rijihua.do?method=initCardGrid_grid&refId='+tmp;        
        //document.getElementById("iGridDown").src = childUrl;   
}