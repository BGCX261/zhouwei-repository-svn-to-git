package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 未完成原因
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdUnfinishreason implements Serializable {
    
	public StdUnfinishreason() {
    }
    		 private String reason2;//未完成原因2
					 private String freason1id;//未完成原因1分类
					 private String id;//未完成原因id
					 private int version;//数据库版本控制
					 private java.util.Collection fddmoutageplan3;
	    			 private java.util.Collection fdddoutageplan5;
	    		
   /**
     * getters and setters
     */
           public void setReason2(String reason2){
        this.reason2=reason2;
    }
	   public String getReason2(){
      return reason2;
    }
           public void setFreason1id(String freason1id){
        this.freason1id=freason1id;
    }
	   public String getFreason1id(){
      return freason1id;
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
           public void setFddmoutageplan3(java.util.Collection fddmoutageplan3){
        this.fddmoutageplan3=fddmoutageplan3;
    }
	   public java.util.Collection getFddmoutageplan3(){
      return fddmoutageplan3;
    }
           public void setFdddoutageplan5(java.util.Collection fdddoutageplan5){
        this.fdddoutageplan5=fdddoutageplan5;
    }
	   public java.util.Collection getFdddoutageplan5(){
      return fdddoutageplan5;
    }
      
  

}