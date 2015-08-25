package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 应用视角
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class AppOfAngle implements Serializable {
    
	public AppOfAngle() {
    }
    		 private String fviewanglename;//名称
					 private String fdescription;//描述
					 private String id;//标示ID
					 private int version;//数据库版本控制
				
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
      
  

}