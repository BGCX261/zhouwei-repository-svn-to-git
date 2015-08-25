package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 远动通信工作站
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaTelCommWorkSTDto  implements Serializable {
    
	public ParaTelCommWorkSTDto() {
    }
	
          private String fremark; //备注
	      private String fid; //主键标示
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparatelcommworkst1; //主键标示
		 

  	
	
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
           public void setZparatelcommworkst1(com.techstar.dmis.dto.EtsEquipmentDto zparatelcommworkst1){
        this.zparatelcommworkst1=zparatelcommworkst1;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparatelcommworkst1(){
      return zparatelcommworkst1;
    }
      
  

}