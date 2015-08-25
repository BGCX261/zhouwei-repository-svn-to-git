//重复提交
var checkSubmitFlag = false;
function submitForm(Flag){
    if(Flag == true){
      checkSubmitFlag = Flag;
      alert('操作正在进行,请耐心等待...');
      return false;
    }
    return true;
}
//双击事件
document.ondblclick = function docondblclick() {
  window.event.returnValue = false;
} 
//单击事件
document.onclick = function doconclick() {
  if (checkSubmitFlag) {
    window.event.returnValue = false;
  }
}