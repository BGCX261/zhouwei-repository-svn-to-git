package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 汽轮机电液控制系统
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaTBPowCtrlSys implements Serializable {
    
	public ParaTBPowCtrlSys() {
    }
    		 private int fdehctrlperiod;//DEH控制周期s
					 private int frotationspeed;//转速反馈通道时间s
					 private int fctrlrcpid;//控制回路PID参数s
					 private int foncefmcoe;//一次调频调差系数
					 private int foncefmacsval;//一次调频动作初值%
					 private int foncefmdeadzone;//一次调频死区r/min
					 private int fhdooropenspd;//高压调门开启速度／时间s
					 private int fhdoorclsspd;//高压调门关闭速度／时间s
					 private int fhdoormaxclsspd;//高压调门最大关闭速度2/s
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparatbpowctrlsys2;
	    		
   /**
     * getters and setters
     */
           public void setFdehctrlperiod(int fdehctrlperiod){
        this.fdehctrlperiod=fdehctrlperiod;
    }
	   public int getFdehctrlperiod(){
      return fdehctrlperiod;
    }
           public void setFrotationspeed(int frotationspeed){
        this.frotationspeed=frotationspeed;
    }
	   public int getFrotationspeed(){
      return frotationspeed;
    }
           public void setFctrlrcpid(int fctrlrcpid){
        this.fctrlrcpid=fctrlrcpid;
    }
	   public int getFctrlrcpid(){
      return fctrlrcpid;
    }
           public void setFoncefmcoe(int foncefmcoe){
        this.foncefmcoe=foncefmcoe;
    }
	   public int getFoncefmcoe(){
      return foncefmcoe;
    }
           public void setFoncefmacsval(int foncefmacsval){
        this.foncefmacsval=foncefmacsval;
    }
	   public int getFoncefmacsval(){
      return foncefmacsval;
    }
           public void setFoncefmdeadzone(int foncefmdeadzone){
        this.foncefmdeadzone=foncefmdeadzone;
    }
	   public int getFoncefmdeadzone(){
      return foncefmdeadzone;
    }
           public void setFhdooropenspd(int fhdooropenspd){
        this.fhdooropenspd=fhdooropenspd;
    }
	   public int getFhdooropenspd(){
      return fhdooropenspd;
    }
           public void setFhdoorclsspd(int fhdoorclsspd){
        this.fhdoorclsspd=fhdoorclsspd;
    }
	   public int getFhdoorclsspd(){
      return fhdoorclsspd;
    }
           public void setFhdoormaxclsspd(int fhdoormaxclsspd){
        this.fhdoormaxclsspd=fhdoormaxclsspd;
    }
	   public int getFhdoormaxclsspd(){
      return fhdoormaxclsspd;
    }
           public void setFeqpid(String feqpid){
        this.feqpid=feqpid;
    }
	   public String getFeqpid(){
      return feqpid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZparatbpowctrlsys2(com.techstar.dmis.entity.EtsEquipment zparatbpowctrlsys2){
        this.zparatbpowctrlsys2=zparatbpowctrlsys2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparatbpowctrlsys2(){
      return zparatbpowctrlsys2;
    }
      
  

}