package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 变送器
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParaDeliverDto  implements Serializable {
    
	public ParaDeliverDto() {
    }
	
          private String fvolinputpara; //电压输入参数
	      private String fvoloutputpara; //电压输出参数
	      private String fcurinputpara; //电流输入参数
	      private String fcuroutputpara; //电流输出参数
	      private String feqpid; //设备ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zparadeliver2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFvolinputpara(String fvolinputpara){
        this.fvolinputpara=fvolinputpara;
    }
	   public String getFvolinputpara(){
      return fvolinputpara;
    }
           public void setFvoloutputpara(String fvoloutputpara){
        this.fvoloutputpara=fvoloutputpara;
    }
	   public String getFvoloutputpara(){
      return fvoloutputpara;
    }
           public void setFcurinputpara(String fcurinputpara){
        this.fcurinputpara=fcurinputpara;
    }
	   public String getFcurinputpara(){
      return fcurinputpara;
    }
           public void setFcuroutputpara(String fcuroutputpara){
        this.fcuroutputpara=fcuroutputpara;
    }
	   public String getFcuroutputpara(){
      return fcuroutputpara;
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
           public void setZparadeliver2(com.techstar.dmis.dto.EtsEquipmentDto zparadeliver2){
        this.zparadeliver2=zparadeliver2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZparadeliver2(){
      return zparadeliver2;
    }
      
  

}