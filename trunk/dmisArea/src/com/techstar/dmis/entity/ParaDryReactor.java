package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 电抗器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaDryReactor implements Serializable {
    
	public ParaDryReactor() {
    }
    		 private String fcoolmethod;//冷却方式
					 private int fratedcurrent;//额定电流_A
					 private int fratedcapacity;//电抗器容量(kVAR)
					 private int fperimpedance;//百分阻抗_%
					 private int feqploss;//损耗_kW
					 private int ftotalweight;//总重_t
					 private String fphaseno;//相数
					 private String fmagnetizerstructure;//导磁结构
					 private int funtankweight;//器身重
					 private int foilweight;//油重_t
					 private String finsulatedielectric;//绝缘介质
					 private String fisthermosyphon;//有无热虹吸
					 private String ftankstructure;//油箱结构
					 private String ftankstrength;//油箱强度
					 private String fspecdev;//加带特殊装置
					 private String foilsealmethod;//油密封方式
					 private int frtreactorvoldrop;//电抗器额定压降
					 private String freactoruses;//电抗器用途
					 private int fvalue;//电抗值
					 private java.sql.Date ffixdate;//大修日期
					 private java.sql.Date fexamdate;//化验日期
					 private java.sql.Date fassaydate;//试验日期
					 private String feqpid;//设备ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparadryreactor2;
	    		
   /**
     * getters and setters
     */
           public void setFcoolmethod(String fcoolmethod){
        this.fcoolmethod=fcoolmethod;
    }
	   public String getFcoolmethod(){
      return fcoolmethod;
    }
           public void setFratedcurrent(int fratedcurrent){
        this.fratedcurrent=fratedcurrent;
    }
	   public int getFratedcurrent(){
      return fratedcurrent;
    }
           public void setFratedcapacity(int fratedcapacity){
        this.fratedcapacity=fratedcapacity;
    }
	   public int getFratedcapacity(){
      return fratedcapacity;
    }
           public void setFperimpedance(int fperimpedance){
        this.fperimpedance=fperimpedance;
    }
	   public int getFperimpedance(){
      return fperimpedance;
    }
           public void setFeqploss(int feqploss){
        this.feqploss=feqploss;
    }
	   public int getFeqploss(){
      return feqploss;
    }
           public void setFtotalweight(int ftotalweight){
        this.ftotalweight=ftotalweight;
    }
	   public int getFtotalweight(){
      return ftotalweight;
    }
           public void setFphaseno(String fphaseno){
        this.fphaseno=fphaseno;
    }
	   public String getFphaseno(){
      return fphaseno;
    }
           public void setFmagnetizerstructure(String fmagnetizerstructure){
        this.fmagnetizerstructure=fmagnetizerstructure;
    }
	   public String getFmagnetizerstructure(){
      return fmagnetizerstructure;
    }
           public void setFuntankweight(int funtankweight){
        this.funtankweight=funtankweight;
    }
	   public int getFuntankweight(){
      return funtankweight;
    }
           public void setFoilweight(int foilweight){
        this.foilweight=foilweight;
    }
	   public int getFoilweight(){
      return foilweight;
    }
           public void setFinsulatedielectric(String finsulatedielectric){
        this.finsulatedielectric=finsulatedielectric;
    }
	   public String getFinsulatedielectric(){
      return finsulatedielectric;
    }
           public void setFisthermosyphon(String fisthermosyphon){
        this.fisthermosyphon=fisthermosyphon;
    }
	   public String getFisthermosyphon(){
      return fisthermosyphon;
    }
           public void setFtankstructure(String ftankstructure){
        this.ftankstructure=ftankstructure;
    }
	   public String getFtankstructure(){
      return ftankstructure;
    }
           public void setFtankstrength(String ftankstrength){
        this.ftankstrength=ftankstrength;
    }
	   public String getFtankstrength(){
      return ftankstrength;
    }
           public void setFspecdev(String fspecdev){
        this.fspecdev=fspecdev;
    }
	   public String getFspecdev(){
      return fspecdev;
    }
           public void setFoilsealmethod(String foilsealmethod){
        this.foilsealmethod=foilsealmethod;
    }
	   public String getFoilsealmethod(){
      return foilsealmethod;
    }
           public void setFrtreactorvoldrop(int frtreactorvoldrop){
        this.frtreactorvoldrop=frtreactorvoldrop;
    }
	   public int getFrtreactorvoldrop(){
      return frtreactorvoldrop;
    }
           public void setFreactoruses(String freactoruses){
        this.freactoruses=freactoruses;
    }
	   public String getFreactoruses(){
      return freactoruses;
    }
           public void setFvalue(int fvalue){
        this.fvalue=fvalue;
    }
	   public int getFvalue(){
      return fvalue;
    }
           public void setFfixdate(java.sql.Date ffixdate){
        this.ffixdate=ffixdate;
    }
	   public java.sql.Date getFfixdate(){
      return ffixdate;
    }
           public void setFexamdate(java.sql.Date fexamdate){
        this.fexamdate=fexamdate;
    }
	   public java.sql.Date getFexamdate(){
      return fexamdate;
    }
           public void setFassaydate(java.sql.Date fassaydate){
        this.fassaydate=fassaydate;
    }
	   public java.sql.Date getFassaydate(){
      return fassaydate;
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
           public void setZparadryreactor2(com.techstar.dmis.entity.EtsEquipment zparadryreactor2){
        this.zparadryreactor2=zparadryreactor2;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparadryreactor2(){
      return zparadryreactor2;
    }
      
  

}