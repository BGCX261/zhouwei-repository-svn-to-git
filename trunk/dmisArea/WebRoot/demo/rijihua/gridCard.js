/**
 * 提供子表的查询条件,即主表的主键名及其主键值,支持联合主键
 * 参数:priColVal 主键值

       形如：id^string^1^639622^^asc
 */
function rowChangedToChild(priColVal,contextPath,listKind){     
        var childUrl = contextPath+'/rijihua.do?method=initGridCard_card&id='+priColVal;        
        document.getElementById("iGridDown").src = childUrl;   
}

//增加子卡片
function addCard(contextPath){
	document.getElementById("iGridDown").src = contextPath+'/rijihua.do?method=initGridCard_card';  
}

//保存子卡片
function saveCard(contextPath){
	iGridDown.onSave(contextPath);
}


//重置子卡片
function  resetCard(contextPath){
	iGridDown.onReset(contextPath);
}