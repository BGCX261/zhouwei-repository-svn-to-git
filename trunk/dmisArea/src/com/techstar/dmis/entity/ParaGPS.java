package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for GPS设备
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaGPS implements Serializable {
    
	public ParaGPS() {
    }
    		 private String fremark;//备注
					 private String fid;//主键标示
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparagps1;
	    		
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
           public void setZparagps1(com.techstar.dmis.entity.EtsEquipment zparagps1){
        this.zparagps1=zparagps1;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparagps1(){
      return zparagps1;
    }
      
  

}