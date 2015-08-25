package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 调度员值班表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdGroupmemberDto  implements Serializable {
    
	public DdGroupmemberDto() {
    }
	
          private String id; //ID
	      private int version; //数据库版本控制
	      private com.techstar.dmis.dto.DdGroupDto zddgroupmember2; //班组ID
	      private com.techstar.dmis.dto.DdDispatcherDto zddgroupmember4; //人员ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZddgroupmember2(com.techstar.dmis.dto.DdGroupDto zddgroupmember2){
        this.zddgroupmember2=zddgroupmember2;
    }
	   public com.techstar.dmis.dto.DdGroupDto getZddgroupmember2(){
      return zddgroupmember2;
    }
           public void setZddgroupmember4(com.techstar.dmis.dto.DdDispatcherDto zddgroupmember4){
        this.zddgroupmember4=zddgroupmember4;
    }
	   public com.techstar.dmis.dto.DdDispatcherDto getZddgroupmember4(){
      return zddgroupmember4;
    }
      
  

}