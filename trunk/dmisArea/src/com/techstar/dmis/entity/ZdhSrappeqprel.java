package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 停复役申请与设备关系
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhSrappeqprel implements Serializable {
    
	public ZdhSrappeqprel() {
    }
    		 private String eqpid;//设备ID
					 private String fid;//申请设备关系ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.ZdhSrapplication zzdhsrappeqprel1;
	    		
   /**
     * getters and setters
     */
           public void setEqpid(String eqpid){
        this.eqpid=eqpid;
    }
	   public String getEqpid(){
      return eqpid;
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
           public void setZzdhsrappeqprel1(com.techstar.dmis.entity.ZdhSrapplication zzdhsrappeqprel1){
        this.zzdhsrappeqprel1=zzdhsrappeqprel1;
    }
	   public com.techstar.dmis.entity.ZdhSrapplication getZzdhsrappeqprel1(){
      return zzdhsrappeqprel1;
    }
      
  

}