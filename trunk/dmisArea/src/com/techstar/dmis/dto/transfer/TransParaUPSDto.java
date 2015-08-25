package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for UPS电源
 * This classe is based on ValueObject Pattern
 */
public class TransParaUPSDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaUPSDto() {
    }
	
          private int froutcapacity; //额定输出容量_kVA
          private String fbatteryfac; //电池厂商
          private String fbatterymodel; //电池组型号
          private int fbatterycapacity; //电池额定容量_Ah
          private int fbatterycount; //电池数量
          private int fsratedvoltage; //电池单体额定电压_V
          private java.sql.Date fcheckchargetime; //核对性充放电日期
          private String fisindepdntbattery; //是否使用独立电池组
          private String fspecspara; //规格参数
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparaups2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFroutcapacity(int froutcapacity){
        this.froutcapacity=froutcapacity;
    }
	   public int getFroutcapacity(){
      return froutcapacity;
    }
             public void setFbatteryfac(String fbatteryfac){
        this.fbatteryfac=fbatteryfac;
    }
	   public String getFbatteryfac(){
      return fbatteryfac;
    }
             public void setFbatterymodel(String fbatterymodel){
        this.fbatterymodel=fbatterymodel;
    }
	   public String getFbatterymodel(){
      return fbatterymodel;
    }
             public void setFbatterycapacity(int fbatterycapacity){
        this.fbatterycapacity=fbatterycapacity;
    }
	   public int getFbatterycapacity(){
      return fbatterycapacity;
    }
             public void setFbatterycount(int fbatterycount){
        this.fbatterycount=fbatterycount;
    }
	   public int getFbatterycount(){
      return fbatterycount;
    }
             public void setFsratedvoltage(int fsratedvoltage){
        this.fsratedvoltage=fsratedvoltage;
    }
	   public int getFsratedvoltage(){
      return fsratedvoltage;
    }
             public void setFcheckchargetime(java.sql.Date fcheckchargetime){
        this.fcheckchargetime=fcheckchargetime;
    }
	   public java.sql.Date getFcheckchargetime(){
      return fcheckchargetime;
    }
             public void setFisindepdntbattery(String fisindepdntbattery){
        this.fisindepdntbattery=fisindepdntbattery;
    }
	   public String getFisindepdntbattery(){
      return fisindepdntbattery;
    }
             public void setFspecspara(String fspecspara){
        this.fspecspara=fspecspara;
    }
	   public String getFspecspara(){
      return fspecspara;
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
             public void setTrans_zparaups2(String trans_zparaups2){
        this.trans_zparaups2=trans_zparaups2;
    }
	   public String getTrans_zparaups2(){
      return trans_zparaups2;
    }
       
  

}