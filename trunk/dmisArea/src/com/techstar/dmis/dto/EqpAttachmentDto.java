package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 设备附件
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class EqpAttachmentDto  implements Serializable {
    
	public EqpAttachmentDto() {
    }
	
          private String fattachname; //附件名称
	      private String fattachtype; //附件类型
	      private String fattachremark; //附件说明
	      private byte[] fattachbody; //附件原件
	      private String fid; //主键标示
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.EtsEquipmentDto zeqpattachment2; //设备ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setFattachname(String fattachname){
        this.fattachname=fattachname;
    }
	   public String getFattachname(){
      return fattachname;
    }
           public void setFattachtype(String fattachtype){
        this.fattachtype=fattachtype;
    }
	   public String getFattachtype(){
      return fattachtype;
    }
           public void setFattachremark(String fattachremark){
        this.fattachremark=fattachremark;
    }
	   public String getFattachremark(){
      return fattachremark;
    }
           public void setFattachbody(byte[] fattachbody){
        this.fattachbody=fattachbody;
    }
	   public byte[] getFattachbody(){
      return fattachbody;
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
           public void setZeqpattachment2(com.techstar.dmis.dto.EtsEquipmentDto zeqpattachment2){
        this.zeqpattachment2=zeqpattachment2;
    }
	   public com.techstar.dmis.dto.EtsEquipmentDto getZeqpattachment2(){
      return zeqpattachment2;
    }
      
  

}