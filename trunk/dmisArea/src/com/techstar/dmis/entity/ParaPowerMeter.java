package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 关口计量电能表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaPowerMeter implements Serializable {
    
	public ParaPowerMeter() {
    }
    		 private String fremark;//备注
					 private String fid;//主键标示
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparapowermeter1;
	    		
   /**
     * getters and setters
     */
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
           public void setZparapowermeter1(com.techstar.dmis.entity.EtsEquipment zparapowermeter1){
        this.zparapowermeter1=zparapowermeter1;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparapowermeter1(){
      return zparapowermeter1;
    }
      
  

}