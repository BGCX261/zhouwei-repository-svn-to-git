<%@ page contentType="text/html; charset=utf-8" language="java"%>
<script type="text/javascript">
	function operation1(itemId,itemValue){
		//取得grid选中id
		//var id = getSelectRowId();
		
		//屏蔽操作列表中某一项
		var arra = new Array();
        arra[0] = "操作名称2";
		disableItem(arra);
		
		//跳转到某个tab页，进入到某个action方法中
		//toTab(1,"/rijihua.do?method=initGrid");
	}
	function operation2(itemId,itemValue){
		alert("操作2");
	}	
	function operation3(itemId,itemValue){
		alert("操作3");
	}	
	function operation4(itemId,itemValue){
		alert("操作4");
	}	
</script>