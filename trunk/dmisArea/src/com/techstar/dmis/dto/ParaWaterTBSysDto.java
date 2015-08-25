package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 水轮机调速系统
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaWaterTBSysDto  implements Serializable {
    
	public ParaWaterTBSysDto() {
    }
	
          private int fctrlperiod; //控制周期s
	      private int frotapwtimes; //转速反馈通道时间s
	      private int fratiogain; //比例增益
	      private int fdefinitegain; //积分增益
	      private int fdifferentialgain; //微分增益
	      private int foncefmdeadzone; //一次调频死区(转速死区)%
	      private int fkeepquiettimes; //接力器不动时间s
	      private int ftempturncoe; //暂态转差系数s
	      private int fbuffertimes; //缓冲时间常数s
	      private int fperpeturncoe; //永态转差系数%
	      private int fservopentime; //接力器开启时间s
	      private int fservclstime; //接力器关闭时间s
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparawatertbsys2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFctrlperiod(int fctrlperiod){
        this.fctrlperiod=fctrlperiod;
    }
	   public int getFctrlperiod(){
      return fctrlperiod;
    }
           public void setFrotapwtimes(int frotapwtimes){
        this.frotapwtimes=frotapwtimes;
    }
	   public int getFrotapwtimes(){
      return frotapwtimes;
    }
           public void setFratiogain(int fratiogain){
        this.fratiogain=fratiogain;
    }
	   public int getFratiogain(){
      return fratiogain;
    }
           public void setFdefinitegain(int fdefinitegain){
        this.fdefinitegain=fdefinitegain;
    }
	   public int getFdefinitegain(){
      return fdefinitegain;
    }
           public void setFdifferentialgain(int fdifferentialgain){
        this.fdifferentialgain=fdifferentialgain;
    }
	   public int getFdifferentialgain(){
      return fdifferentialgain;
    }
           public void setFoncefmdeadzone(int foncefmdeadzone){
        this.foncefmdeadzone=foncefmdeadzone;
    }
	   public int getFoncefmdeadzone(){
      return foncefmdeadzone;
    }
           public void setFkeepquiettimes(int fkeepquiettimes){
        this.fkeepquiettimes=fkeepquiettimes;
    }
	   public int getFkeepquiettimes(){
      return fkeepquiettimes;
    }
           public void setFtempturncoe(int ftempturncoe){
        this.ftempturncoe=ftempturncoe;
    }
	   public int getFtempturncoe(){
      return ftempturncoe;
    }
           public void setFbuffertimes(int fbuffertimes){
        this.fbuffertimes=fbuffertimes;
    }
	   public int getFbuffertimes(){
      return fbuffertimes;
    }
           public void setFperpeturncoe(int fperpeturncoe){
        this.fperpeturncoe=fperpeturncoe;
    }
	   public int getFperpeturncoe(){
      return fperpeturncoe;
    }
           public void setFservopentime(int fservopentime){
        this.fservopentime=fservopentime;
    }
	   public int getFservopentime(){
      return fservopentime;
    }
           public void setFservclstime(int fservclstime){
        this.fservclstime=fservclstime;
    }
	   public int getFservclstime(){
      return fservclstime;
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
           public void setZparawatertbsys2(com.techstar.dmis.dto.EtsEquipmentDto zparawatertbsys2){
        this.zparawatertbsys2=zparawatertbsys2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparawatertbsys2(){
      return zparawatertbsys2;
    }
      
  

}