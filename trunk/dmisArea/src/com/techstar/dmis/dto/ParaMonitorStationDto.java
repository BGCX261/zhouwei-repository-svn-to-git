package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 集控站系统
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaMonitorStationDto  implements Serializable {
    
	public ParaMonitorStationDto() {
    }
	
          private String fosver; //操作系统版本
	      private String fappver; //应用软件版本号
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparamonitorstation2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFosver(String fosver){
        this.fosver=fosver;
    }
	   public String getFosver(){
      return fosver;
    }
           public void setFappver(String fappver){
        this.fappver=fappver;
    }
	   public String getFappver(){
      return fappver;
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
           public void setZparamonitorstation2(com.techstar.dmis.dto.EtsEquipmentDto zparamonitorstation2){
        this.zparamonitorstation2=zparamonitorstation2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparamonitorstation2(){
      return zparamonitorstation2;
    }
      
  

}