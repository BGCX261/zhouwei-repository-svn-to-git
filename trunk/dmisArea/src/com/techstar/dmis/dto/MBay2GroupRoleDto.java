package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 间隔和间隔组合关联
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MBay2GroupRoleDto  implements Serializable {
    
	public MBay2GroupRoleDto() {
    }
	
          private String fid; //主键标示
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.MbayDto zmbay2grouprole2; //间隔id
	      private com.techstar.dmis.dto.MBayGroupDto zmbay2grouprole3; //间隔组合id
		 

  	
	
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
           public void setZmbay2grouprole2(com.techstar.dmis.dto.MbayDto zmbay2grouprole2){
        this.zmbay2grouprole2=zmbay2grouprole2;
    }
	   public com.techstar.dmis.dto.MbayDto getZmbay2grouprole2(){
      return zmbay2grouprole2;
    }
           public void setZmbay2grouprole3(com.techstar.dmis.dto.MBayGroupDto zmbay2grouprole3){
        this.zmbay2grouprole3=zmbay2grouprole3;
    }
	   public com.techstar.dmis.dto.MBayGroupDto getZmbay2grouprole3(){
      return zmbay2grouprole3;
    }
      
  

}