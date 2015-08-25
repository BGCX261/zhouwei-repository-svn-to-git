package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 自动电压调节器—AVR
 * This classe is based on ValueObject Pattern
 */
public class TransParaAVRDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaAVRDto() {
    }
	
          private int fcorrectionstyle; //校正方式PU
          private int fratiogain; //比例增益 秒
          private int fvolchecktimes; //电压检测时间常数PU
          private int fdefinitegain; //积分增益PU
          private int fdifferentialgain; //微分增益秒
          private int fdefinitetimes; //积分时间常数秒
          private int fdifferentialtimes; //微分时间常数秒
          private int fencourageratio; //11秒强励倍数PU
          private int fscrminlimitangle; //可控硅最小限制角度
          private int fscrmaxlimitangle; //可控硅最大限制角度
          private String fadoptcosinepri; //是否采用余弦移相原理
          private int fpssgain; //PSS增益PU
          private int ffirstsepgain; //第一级隔直增益PU
          private int ffirstseptimes; //第一级隔直时间常数秒
          private int fsecondsepgain; //第二级隔直增益PU
          private int fsecondseptimes; //第二级隔直时间常数秒
          private int fleaddelaytimes1; //超前-滞后时间常数秒T1
          private int fleaddelaytimes2; //超前-滞后时间常数秒T2
          private int fleaddelaytimes3; //超前-滞后时间常数秒T3
          private int fleaddelaytimes4; //超前-滞后时间常数秒T4
          private int fleaddelaytimes5; //超前-滞后时间常数秒T5
          private int fleaddelaytimes6; //超前-滞后时间常数秒T6
          private int fpssoutlimit; //PSS输出限幅PU
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparaavr2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFcorrectionstyle(int fcorrectionstyle){
        this.fcorrectionstyle=fcorrectionstyle;
    }
	   public int getFcorrectionstyle(){
      return fcorrectionstyle;
    }
             public void setFratiogain(int fratiogain){
        this.fratiogain=fratiogain;
    }
	   public int getFratiogain(){
      return fratiogain;
    }
             public void setFvolchecktimes(int fvolchecktimes){
        this.fvolchecktimes=fvolchecktimes;
    }
	   public int getFvolchecktimes(){
      return fvolchecktimes;
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
             public void setFdefinitetimes(int fdefinitetimes){
        this.fdefinitetimes=fdefinitetimes;
    }
	   public int getFdefinitetimes(){
      return fdefinitetimes;
    }
             public void setFdifferentialtimes(int fdifferentialtimes){
        this.fdifferentialtimes=fdifferentialtimes;
    }
	   public int getFdifferentialtimes(){
      return fdifferentialtimes;
    }
             public void setFencourageratio(int fencourageratio){
        this.fencourageratio=fencourageratio;
    }
	   public int getFencourageratio(){
      return fencourageratio;
    }
             public void setFscrminlimitangle(int fscrminlimitangle){
        this.fscrminlimitangle=fscrminlimitangle;
    }
	   public int getFscrminlimitangle(){
      return fscrminlimitangle;
    }
             public void setFscrmaxlimitangle(int fscrmaxlimitangle){
        this.fscrmaxlimitangle=fscrmaxlimitangle;
    }
	   public int getFscrmaxlimitangle(){
      return fscrmaxlimitangle;
    }
             public void setFadoptcosinepri(String fadoptcosinepri){
        this.fadoptcosinepri=fadoptcosinepri;
    }
	   public String getFadoptcosinepri(){
      return fadoptcosinepri;
    }
             public void setFpssgain(int fpssgain){
        this.fpssgain=fpssgain;
    }
	   public int getFpssgain(){
      return fpssgain;
    }
             public void setFfirstsepgain(int ffirstsepgain){
        this.ffirstsepgain=ffirstsepgain;
    }
	   public int getFfirstsepgain(){
      return ffirstsepgain;
    }
             public void setFfirstseptimes(int ffirstseptimes){
        this.ffirstseptimes=ffirstseptimes;
    }
	   public int getFfirstseptimes(){
      return ffirstseptimes;
    }
             public void setFsecondsepgain(int fsecondsepgain){
        this.fsecondsepgain=fsecondsepgain;
    }
	   public int getFsecondsepgain(){
      return fsecondsepgain;
    }
             public void setFsecondseptimes(int fsecondseptimes){
        this.fsecondseptimes=fsecondseptimes;
    }
	   public int getFsecondseptimes(){
      return fsecondseptimes;
    }
             public void setFleaddelaytimes1(int fleaddelaytimes1){
        this.fleaddelaytimes1=fleaddelaytimes1;
    }
	   public int getFleaddelaytimes1(){
      return fleaddelaytimes1;
    }
             public void setFleaddelaytimes2(int fleaddelaytimes2){
        this.fleaddelaytimes2=fleaddelaytimes2;
    }
	   public int getFleaddelaytimes2(){
      return fleaddelaytimes2;
    }
             public void setFleaddelaytimes3(int fleaddelaytimes3){
        this.fleaddelaytimes3=fleaddelaytimes3;
    }
	   public int getFleaddelaytimes3(){
      return fleaddelaytimes3;
    }
             public void setFleaddelaytimes4(int fleaddelaytimes4){
        this.fleaddelaytimes4=fleaddelaytimes4;
    }
	   public int getFleaddelaytimes4(){
      return fleaddelaytimes4;
    }
             public void setFleaddelaytimes5(int fleaddelaytimes5){
        this.fleaddelaytimes5=fleaddelaytimes5;
    }
	   public int getFleaddelaytimes5(){
      return fleaddelaytimes5;
    }
             public void setFleaddelaytimes6(int fleaddelaytimes6){
        this.fleaddelaytimes6=fleaddelaytimes6;
    }
	   public int getFleaddelaytimes6(){
      return fleaddelaytimes6;
    }
             public void setFpssoutlimit(int fpssoutlimit){
        this.fpssoutlimit=fpssoutlimit;
    }
	   public int getFpssoutlimit(){
      return fpssoutlimit;
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
             public void setTrans_zparaavr2(String trans_zparaavr2){
        this.trans_zparaavr2=trans_zparaavr2;
    }
	   public String getTrans_zparaavr2(){
      return trans_zparaavr2;
    }
       
  

}