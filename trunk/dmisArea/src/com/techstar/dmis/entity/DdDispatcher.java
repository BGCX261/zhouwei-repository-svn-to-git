package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 调度员表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDispatcher implements Serializable {
    
	public DdDispatcher() {
    }
    		 private String id;//ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.GgPerson zdddispatcher2;
	    		
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
           public void setZdddispatcher2(com.techstar.dmis.entity.GgPerson zdddispatcher2){
        this.zdddispatcher2=zdddispatcher2;
    }
	   public com.techstar.dmis.entity.GgPerson getZdddispatcher2(){
      return zdddispatcher2;
    }
      
  

}