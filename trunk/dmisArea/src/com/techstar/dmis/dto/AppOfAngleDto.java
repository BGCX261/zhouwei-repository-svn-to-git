package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 应用视角
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class AppOfAngleDto extends DictionaryBaseDto implements Serializable {
    
	public AppOfAngleDto() {
    }
	
          private String fviewanglename; //名称
	      private String fdescription; //描述
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFviewanglename(String fviewanglename){
        this.fviewanglename=fviewanglename;
    }
	   public String getFviewanglename(){
      return fviewanglename;
    }
           public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}