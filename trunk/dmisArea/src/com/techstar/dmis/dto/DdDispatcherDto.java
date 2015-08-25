package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 调度员表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDispatcherDto extends DictionaryBaseDto implements Serializable {
    
	public DdDispatcherDto() {
    }
	
          private int version; //数据库版本控制
	      private com.techstar.dmis.dto.GgPersonDto zdddispatcher2; //人员ID
		 

  	
	
   /**
     * getters and setters
     */
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZdddispatcher2(com.techstar.dmis.dto.GgPersonDto zdddispatcher2){
        this.zdddispatcher2=zdddispatcher2;
    }
	   public com.techstar.dmis.dto.GgPersonDto getZdddispatcher2(){
      return zdddispatcher2;
    }
      
  

}