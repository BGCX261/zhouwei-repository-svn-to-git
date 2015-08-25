package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 故障录波器台帐
 * This classe is based on ValueObject Pattern
 */
public class TransParaFaullistDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaFaullistDto() {
    }
	
          private String fprotectedequip; //被保护设备名称(一次设备名称)
          private java.sql.Date fverifydate; //校验日期(上次全部校验日期)
          private java.sql.Date fdrivedate; //传动日期(上次部分校验日期)
          private String fisinuse; //是否运行
          private String fdispatchauthority; //调度权限
          private String fmaterialcodify; //设备物资编码
          private String fremark; //备注
          private String feqpid; //设备ID
          private int version; //数据库版本控制
          private String trans_zparafaullist2; //设备ID
    	 
	
   /**
     * getters and setters
     */
            public void setFprotectedequip(String fprotectedequip){
        this.fprotectedequip=fprotectedequip;
    }
	   public String getFprotectedequip(){
      return fprotectedequip;
    }
             public void setFverifydate(java.sql.Date fverifydate){
        this.fverifydate=fverifydate;
    }
	   public java.sql.Date getFverifydate(){
      return fverifydate;
    }
             public void setFdrivedate(java.sql.Date fdrivedate){
        this.fdrivedate=fdrivedate;
    }
	   public java.sql.Date getFdrivedate(){
      return fdrivedate;
    }
             public void setFisinuse(String fisinuse){
        this.fisinuse=fisinuse;
    }
	   public String getFisinuse(){
      return fisinuse;
    }
             public void setFdispatchauthority(String fdispatchauthority){
        this.fdispatchauthority=fdispatchauthority;
    }
	   public String getFdispatchauthority(){
      return fdispatchauthority;
    }
             public void setFmaterialcodify(String fmaterialcodify){
        this.fmaterialcodify=fmaterialcodify;
    }
	   public String getFmaterialcodify(){
      return fmaterialcodify;
    }
             public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
             public void setTrans_zparafaullist2(String trans_zparafaullist2){
        this.trans_zparafaullist2=trans_zparafaullist2;
    }
	   public String getTrans_zparafaullist2(){
      return trans_zparafaullist2;
    }
       
  

}