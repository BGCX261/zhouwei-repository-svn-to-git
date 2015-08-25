package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 停复役申请与设备关系
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ZdhSrappeqprelDto  implements Serializable {
    
	public ZdhSrappeqprelDto() {
    }
	
          private String fid; //申请设备关系ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.ZdhSrapplicationDto zzdhsrappeqprel1; //申请表编号
	      private com.techstar.dmis.dto.EtsEquipmentDto zzdhsrappeqprel2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
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
           public void setZzdhsrappeqprel1(com.techstar.dmis.dto.ZdhSrapplicationDto zzdhsrappeqprel1){
        this.zzdhsrappeqprel1=zzdhsrappeqprel1;
    }
	   public com.techstar.dmis.dto.ZdhSrapplicationDto getZzdhsrappeqprel1(){
      return zzdhsrappeqprel1;
    }
           public void setZzdhsrappeqprel2(com.techstar.dmis.dto.EtsEquipmentDto zzdhsrappeqprel2){
        this.zzdhsrappeqprel2=zzdhsrappeqprel2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZzdhsrappeqprel2(){
      return zzdhsrappeqprel2;
    }
      
  

}