package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 调度员值班表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdGroupmember implements Serializable {
    
	public DdGroupmember() {
    }
    		 private String id;//ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdGroup zddgroupmember2;
	    			 private com.techstar.dmis.entity.DdDispatcher zddgroupmember4;
	    		
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
           public void setZddgroupmember2(com.techstar.dmis.entity.DdGroup zddgroupmember2){
        this.zddgroupmember2=zddgroupmember2;
    }
	   public com.techstar.dmis.entity.DdGroup getZddgroupmember2(){
      return zddgroupmember2;
    }
           public void setZddgroupmember4(com.techstar.dmis.entity.DdDispatcher zddgroupmember4){
        this.zddgroupmember4=zddgroupmember4;
    }
	   public com.techstar.dmis.entity.DdDispatcher getZddgroupmember4(){
      return zddgroupmember4;
    }
      
  

}