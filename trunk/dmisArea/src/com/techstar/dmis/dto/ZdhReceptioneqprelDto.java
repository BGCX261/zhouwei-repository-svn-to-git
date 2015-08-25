package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 基改建工程自动化设备投运清单
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhReceptioneqprelDto  implements Serializable {
    
	public ZdhReceptioneqprelDto() {
    }
	
          private byte[] feqpcontent; //设备信息
	      private String receptioneqprelid; //关系iD
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.ZdhReceptionDto zzdhreceptioneqprel1; //申请验收编号
	      private com.techstar.dmis.dto.EtsEquipmentDto zzdhreceptioneqprel2; //设备id
		 

  	
	
   /**
     * getters and setters
     */
           public void setFeqpcontent(byte[] feqpcontent){
        this.feqpcontent=feqpcontent;
    }
	   public byte[] getFeqpcontent(){
      return feqpcontent;
    }
           public void setReceptioneqprelid(String receptioneqprelid){
        this.receptioneqprelid=receptioneqprelid;
    }
	   public String getReceptioneqprelid(){
      return receptioneqprelid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZzdhreceptioneqprel1(com.techstar.dmis.dto.ZdhReceptionDto zzdhreceptioneqprel1){
        this.zzdhreceptioneqprel1=zzdhreceptioneqprel1;
    }
	   public com.techstar.dmis.dto.ZdhReceptionDto getZzdhreceptioneqprel1(){
      return zzdhreceptioneqprel1;
    }
           public void setZzdhreceptioneqprel2(com.techstar.dmis.dto.EtsEquipmentDto zzdhreceptioneqprel2){
        this.zzdhreceptioneqprel2=zzdhreceptioneqprel2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZzdhreceptioneqprel2(){
      return zzdhreceptioneqprel2;
    }
      
  

}