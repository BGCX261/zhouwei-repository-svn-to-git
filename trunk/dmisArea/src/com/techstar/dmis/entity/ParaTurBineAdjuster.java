package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 汽轮机及其调节系统参数
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaTurBineAdjuster implements Serializable {
    
	public ParaTurBineAdjuster() {
    }
    		 private String fpowerplan;//电厂名称
					 private String fpowerunitno;//机组编号
					 private String fpowerunitmode;//机组型号
					 private int fpowerunitcapa;//机组容量
					 private String fboilertype;//锅炉类型
					 private String fhasdcs;//有无集散控制系统(DCS)
					 private String fdcsfactory;//集散控制系统生产厂家
					 private String fturbinefactory;//汽轮机生产厂家
					 private String fturbinetype;//汽轮机类型
					 private int fturbinerotorspeed;//汽轮发电机组转子时间或转子转动惯量s/kg.m3
					 private int fhvreakconttime;//高压汽室蒸汽容积时间s
					 private int freheatreakconttime;//再热器蒸汽容积时间s
					 private int flvreakconttime;//低压连通管蒸汽容积时间s
					 private int fhvpowerratio;//高压缸功率比%
					 private int fmvpowerratio;//中压缸功率比%
					 private int flvpowerratio;//低压缸功率比%
					 private int fplantmaxoutpower;//机组最大输出功率%
					 private int fplantidlepower;//机组空载功耗%
					 private int freakconttime;//蒸汽容积时间s
					 private int ftakereakpress;//业抽汽压力MPa
					 private int fheattakereakpress;//采暖抽汽压力MPa
					 private int fturbinefixpress;//汽轮机额定背压kPa
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparaturbineadjuster2;
	    		
   /**
     * getters and setters
     */
           public void setFpowerplan(String fpowerplan){
        this.fpowerplan=fpowerplan;
    }
	   public String getFpowerplan(){
      return fpowerplan;
    }
           public void setFpowerunitno(String fpowerunitno){
        this.fpowerunitno=fpowerunitno;
    }
	   public String getFpowerunitno(){
      return fpowerunitno;
    }
           public void setFpowerunitmode(String fpowerunitmode){
        this.fpowerunitmode=fpowerunitmode;
    }
	   public String getFpowerunitmode(){
      return fpowerunitmode;
    }
           public void setFpowerunitcapa(int fpowerunitcapa){
        this.fpowerunitcapa=fpowerunitcapa;
    }
	   public int getFpowerunitcapa(){
      return fpowerunitcapa;
    }
           public void setFboilertype(String fboilertype){
        this.fboilertype=fboilertype;
    }
	   public String getFboilertype(){
      return fboilertype;
    }
           public void setFhasdcs(String fhasdcs){
        this.fhasdcs=fhasdcs;
    }
	   public String getFhasdcs(){
      return fhasdcs;
    }
           public void setFdcsfactory(String fdcsfactory){
        this.fdcsfactory=fdcsfactory;
    }
	   public String getFdcsfactory(){
      return fdcsfactory;
    }
           public void setFturbinefactory(String fturbinefactory){
        this.fturbinefactory=fturbinefactory;
    }
	   public String getFturbinefactory(){
      return fturbinefactory;
    }
           public void setFturbinetype(String fturbinetype){
        this.fturbinetype=fturbinetype;
    }
	   public String getFturbinetype(){
      return fturbinetype;
    }
           public void setFturbinerotorspeed(int fturbinerotorspeed){
        this.fturbinerotorspeed=fturbinerotorspeed;
    }
	   public int getFturbinerotorspeed(){
      return fturbinerotorspeed;
    }
           public void setFhvreakconttime(int fhvreakconttime){
        this.fhvreakconttime=fhvreakconttime;
    }
	   public int getFhvreakconttime(){
      return fhvreakconttime;
    }
           public void setFreheatreakconttime(int freheatreakconttime){
        this.freheatreakconttime=freheatreakconttime;
    }
	   public int getFreheatreakconttime(){
      return freheatreakconttime;
    }
           public void setFlvreakconttime(int flvreakconttime){
        this.flvreakconttime=flvreakconttime;
    }
	   public int getFlvreakconttime(){
      return flvreakconttime;
    }
           public void setFhvpowerratio(int fhvpowerratio){
        this.fhvpowerratio=fhvpowerratio;
    }
	   public int getFhvpowerratio(){
      return fhvpowerratio;
    }
           public void setFmvpowerratio(int fmvpowerratio){
        this.fmvpowerratio=fmvpowerratio;
    }
	   public int getFmvpowerratio(){
      return fmvpowerratio;
    }
           public void setFlvpowerratio(int flvpowerratio){
        this.flvpowerratio=flvpowerratio;
    }
	   public int getFlvpowerratio(){
      return flvpowerratio;
    }
           public void setFplantmaxoutpower(int fplantmaxoutpower){
        this.fplantmaxoutpower=fplantmaxoutpower;
    }
	   public int getFplantmaxoutpower(){
      return fplantmaxoutpower;
    }
           public void setFplantidlepower(int fplantidlepower){
        this.fplantidlepower=fplantidlepower;
    }
	   public int getFplantidlepower(){
      return fplantidlepower;
    }
           public void setFreakconttime(int freakconttime){
        this.freakconttime=freakconttime;
    }
	   public int getFreakconttime(){
      return freakconttime;
    }
           public void setFtakereakpress(int ftakereakpress){
        this.ftakereakpress=ftakereakpress;
    }
	   public int getFtakereakpress(){
      return ftakereakpress;
    }
           public void setFheattakereakpress(int fheattakereakpress){
        this.fheattakereakpress=fheattakereakpress;
    }
	   public int getFheattakereakpress(){
      return fheattakereakpress;
    }
           public void setFturbinefixpress(int fturbinefixpress){
        this.fturbinefixpress=fturbinefixpress;
    }
	   public int getFturbinefixpress(){
      return fturbinefixpress;
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
           public void setZparaturbineadjuster2(com.techstar.dmis.entity.EtsEquipment zparaturbineadjuster2){
        this.zparaturbineadjuster2=zparaturbineadjuster2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparaturbineadjuster2(){
      return zparaturbineadjuster2;
    }
      
  

}