package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 水情测报设备
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaWaterMonEqp implements Serializable {
    
	public ParaWaterMonEqp() {
    }
    		 private String fremark;//备注
					 private String fid;//主键标示
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparawatermoneqp1;
	    		
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
           public void setZparawatermoneqp1(com.techstar.dmis.entity.EtsEquipment zparawatermoneqp1){
        this.zparawatermoneqp1=zparawatermoneqp1;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparawatermoneqp1(){
      return zparawatermoneqp1;
    }
      
  

}