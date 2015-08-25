/**
 * 得到应用的上下文路径
 */
function getContextPath(){
   var url = location.href;
   if(url.indexOf('http://')<0)
	   return "./";
   url = url.substring(url.indexOf('http://') + 7);
   if(url.indexOf('/') < 0)
   		return "";
   url = url.substring(url.indexOf('/') + 1);
   var pos;
   if(url.indexOf('/') >= 0)
		pos = url.indexOf('/');
   else pos = url.length;
   		url = url.substring(0, pos);
   return url;
}



/**
 * 弹出层提示消息框
 * @author zhzhta 2006-12-22
 */
function dealAlertMessage(message){
	parent.downFrame.message_mask.style.visibility='visible';
	parent.downFrame.message_box.style.visibility='visible'
	parent.downFrame.document.getElementById("mainMessage").innerText = message;
}




function showModalDialogYY(url,width,height,setObj,title,scrolling)
{
        var top = (screen.height - height)/2;
        var left = (screen.width - width)/2;

		var frameWindowUrl = "/" + getContextPath() + "/common/generate_iframe.jsp?title="+title+"&scrolling="+scrolling;
		setObj.url = url;

        var returnV = window.showModalDialog(url,null,'dialogwidth:' + width + 'px;dialogtop:'+top+'px;dialogheight:' + height + 'px;dialogleft:'+left+'px;status:no;help:no;scroll:no;resizable:no');
        return returnV;
}
