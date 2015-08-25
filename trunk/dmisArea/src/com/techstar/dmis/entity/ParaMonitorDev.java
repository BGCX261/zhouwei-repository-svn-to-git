package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 测控装置
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaMonitorDev implements Serializable {
    
	public ParaMonitorDev() {
    }
    		 private String fremark;//备注
					 private String fid;//主键标示
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.EtsEquipment zparamonitordev1;
	    		
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
           public void setZparamonitordev1(com.techstar.dmis.entity.EtsEquipment zparamonitordev1){
        this.zparamonitordev1=zparamonitordev1;
    }
	   public com.techstar.dmis.entity.EtsEquipment getZparamonitordev1(){
      return zparamonitordev1;
    }
      
  

}