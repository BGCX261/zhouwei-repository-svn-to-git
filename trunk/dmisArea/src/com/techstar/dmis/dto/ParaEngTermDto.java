package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 电能量远方终端
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaEngTermDto  implements Serializable {
    
	public ParaEngTermDto() {
    }
	
          private String fremark; //备注
	      private String fid; //主键标示
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparaengterm1; //主键标示
		 

  	
	
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
           public void setZparaengterm1(com.techstar.dmis.dto.EtsEquipmentDto zparaengterm1){
        this.zparaengterm1=zparaengterm1;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparaengterm1(){
      return zparaengterm1;
    }
      
  

}