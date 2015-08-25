<%@ page contentType="text/html; charset=utf-8" language="java"%>
<style type="text/css">
.message_body{background:;filter:progid:DXImageTransform.Microsoft.Gradient(gradientType=0,startColorStr=#ffffff,endColorStr=#ffffff); overflow:hidden}
#message_box{ position:absolute;  left:expression((body.clientWidth-300)/2); top:expression((body.clientHeight-150)/2); width:300px; height:150px;filter:dropshadow(color=#666666,offx=3,offy=3,positive=2); z-index:2; visibility:hidden}
#message_mask{ position:absolute; top:0; left:0; width:expression(body.clientWidth); height:expression(body.clientHeight); background:#666; filter:ALPHA(opacity=45); z-index:1; visibility:hidden}
.message{border:#036 solid; border-width:1 1 3 1; width:95%; height:95%; background:#fff; color:#036; font-size:12px; line-height:150%}
.message_header{background:#036; height:10%; font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12px; padding:3 5 0 5; color:#fff}
</style>
<div class="message_body">
	<div id="message_box">
		<div class="message">
			<div class="message_header">
				<div onClick="message_box.style.visibility='hidden'; message_mask.style.visibility='hidden'"
					style="text-align:center; display:inline; width:150px; position:relative; cursor:hand">
					提示信息
				</div>
				<span
					onClick="message_box.style.visibility='hidden'; message_mask.style.visibility='hidden'"
					style="position:absolute; float:right; display:inline; cursor:hand">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×
				</span>
			</div>
			<ul style="margin-right:35; position:relative">
				<li><div id="mainMessage">提示内容</div></li>
			</ul>
		</div>
	</div>
	<div id="message_mask"></div>
</div>

