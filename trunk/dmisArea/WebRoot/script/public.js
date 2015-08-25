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
 * IFrame自适应高度
 * @author caojian 2006-12-18
 */
function adjustIFrameSize(id) {          
    var myIframe = document.getElementById(id);
    if (myIframe) {
        if (myIframe.contentDocument && myIframe.contentDocument.body.offsetHeight) {
            myIframe.height = myIframe.contentDocument.body.offsetHeight;
        } else if (myIframe.Document && myIframe.Document.body.scrollHeight) {
            myIframe.height = myIframe.Document.body.scrollHeight;
        }
    }
}

/**
 * 弹出层提示消息框
 * @author caojian 2006-12-22
 */
function dealMessage(message){
	parent.message_mask.style.visibility='visible';
	parent.message_box.style.visibility='visible'
	parent.document.getElementById("mainMessage").innerText = message;
}
/**
 * 工具栏弹出层提示消息框
 * @author zhzhta 2007-04-25
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
		 //alert(setObj.url);
         
        var returnV = window.showModalDialog(encodeURI(frameWindowUrl),setObj,'dialogwidth:' + width + 'px;dialogtop:'+top+'px;dialogheight:' + height + 'px;dialogleft:'+left+'px;status:no;help:no;scroll:no;resizable:no');
        return returnV;
}

function showNotModalDialogYY(url,width,height)
{
       var top = (screen.height - height)/2;
       var left = (screen.width - width)/2;  
       var head = "height=" + height + ",width=" + width + ",left="+left+",top="+top+",status=no,toolbar=no,menubar=no,location=no";
	   url = "/" + getContextPath() + url;
       var returnV = window.open(url,"chengyuan",head);
}

function showModalWindowSubmitable(URL,width,Height,paramObj){
	 return showModalDialogYY(url,width,height,paramObj); 
}

/**
 *  Cookie基本操作方法
 *  1. fixDate(date)
 *  2. setCookie(name, value, expire, path, domain, secure)
 *  3. getCookie(name)
 *  4. deleteCookie(name, path, domain)
 *  @author majian 2006-12-28
 */
 var caution = false;
 
/**
 *  设置时间
 *  @author majian 2006-12-28
 */
function fixDate(date) 
{
	var base = new Date(0);
	var skew = base.getTime();
	if (skew > 0)
	{
		date.setTime(date.getTime() - skew);
	}
}

/**
 *  得到特定名称的Cookie
 *  @param name   cookie名称
 *  @param value  cookie值

 *  @param expire 设置过期时间,传入"",会设置为一年过期

 *  @param path   路径
 *  @param domain 域名称

 *  @param secure 权限
 *  @author majian 2006-12-28
 */
function setCookie(name, value, expire, path, domain, secure) 
{
	var expires;
	if(!expire)
	{
		var expires  = new Date();
		fixDate(expires);
		expires.setTime(expires.getTime() + 365 * 24 * 60 * 60 * 1000);
	}
    var curCookie = name + "=" + escape(value) +
                	((expires) ? "; expires=" + expires.toGMTString() : "") +
                	((path) ? "; path=" + path : "") +
                	((domain) ? "; domain=" + domain : "") +
                	((secure) ? "; secure" : "")
    if (!caution && (name + "=" + escape(value)).length <= 4000)
	{
    	document.cookie = curCookie;
	}
    else 
	{
		if (confirm("Cookie exceeds 4KB and will be cut!"))
		{
            document.cookie = curCookie;
		}
	}
}

/**
 *  得到特定名称的Cookie
 *  @param name   cookie名称
 *  @author majian 2006-12-28
 */
function getCookie(name) 
{
	var prefix = name + "=";
	var cookieStartIndex = document.cookie.indexOf(prefix);
	if (cookieStartIndex == -1)
	{
		return null;
	}
	var cookieEndIndex = document.cookie.indexOf(";", cookieStartIndex + prefix.length);
	if (cookieEndIndex == -1)
	{
		cookieEndIndex = document.cookie.length;
	}
	return unescape(document.cookie.substring(cookieStartIndex + prefix.length, cookieEndIndex));
}

/**
 *  删除特定名称的Cookie
 *  @param name   cookie名称
 *  @param path   路径
 *  @param domain 域名称

 *  @author majian 2006-12-28
 */
function deleteCookie(name, path, domain) 
{
	if (getCookie(name)) 
	{
		document.cookie = name + "=" + 
						 ((path) ? "; path=" + path : "") +
						 ((domain) ? "; domain=" + domain : "") +
						 "; expires=Thu, 01-Jan-70 00:00:01 GMT"
	}
}