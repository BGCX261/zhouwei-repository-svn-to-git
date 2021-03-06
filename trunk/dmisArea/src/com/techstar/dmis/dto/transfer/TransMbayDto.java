package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔表
 * This classe is based on ValueObject Pattern
 */
public class TransMbayDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMbayDto() {
    }
	
          private String fname; //间隔命名
          private String ftype; //间隔类型
          private int fvoltage; //电压等级
          private String fcontainer; //所属厂站或线路
          private String fmainequipment; //主设备
          private String fid; //间隔标示
          private int version; //数据库版本控制
          private java.util.Collection fetsequipment2; //间隔标示
          private java.util.Collection fmbay2grouprole2; //间隔标示
          private java.util.Collection fmbayeqpment2; //间隔标示
    	 
	
   /**
     * getters and setters
     */
            public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
             public void setFtype(String ftype){
        this.ftype=ftype;
    }
	   public String getFtype(){
      return ftype;
    }
             public void setFvoltage(int fvoltage){
        this.fvoltage=fvoltage;
    }
	   public int getFvoltage(){
      return fvoltage;
    }
             public void setFcontainer(String fcontainer){
        this.fcontainer=fcontainer;
    }
	   public String getFcontainer(){
      return fcontainer;
    }
             public void setFmainequipment(String fmainequipment){
        this.fmainequipment=fmainequipment;
    }
	   public String getFmainequipment(){
      return fmainequipment;
    }
             public void setFid(String fid){
        this.fid=fid;
    }
	   public String getFid(){
      return fid;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
             public void setFetsequipment2(java.util.Collection fetsequipment2){
        this.fetsequipment2=fetsequipment2;
    }
	   public java.util.Collection getFetsequipment2(){
      return fetsequipment2;
    }
             public void setFmbay2grouprole2(java.util.Collection fmbay2grouprole2){
        this.fmbay2grouprole2=fmbay2grouprole2;
    }
	   public java.util.Collection getFmbay2grouprole2(){
      return fmbay2grouprole2;
    }
             public void setFmbayeqpment2(java.util.Collection fmbayeqpment2){
        this.fmbayeqpment2=fmbayeqpment2;
    }
	   public java.util.Collection getFmbayeqpment2(){
      return fmbayeqpment2;
    }
       
  

}