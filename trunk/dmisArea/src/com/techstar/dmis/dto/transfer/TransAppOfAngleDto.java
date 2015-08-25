package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 应用视角
 * This classe is based on ValueObject Pattern
 */
public class TransAppOfAngleDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransAppOfAngleDto() {
    }
	
          private String fviewanglename; //名称
          private String fdescription; //描述
          private String id; //标示ID
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