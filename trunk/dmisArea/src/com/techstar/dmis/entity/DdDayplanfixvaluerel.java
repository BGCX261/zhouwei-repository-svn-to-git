package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 日计划定值单关系
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDayplanfixvaluerel implements Serializable {
    
	public DdDayplanfixvaluerel() {
    }
    		 private String frelid;//关系ID
					 private int version;//数据库版本控制
					 private com.techstar.dmis.entity.DdDoutageplan zdddayplanfixvaluerel2;
	    			 private com.techstar.dmis.entity.BhFixedvaluebill zdddayplanfixvaluerel4;
	    		
   /**
     * getters and setters
     */
           public void setFrelid(String frelid){
        this.frelid=frelid;
    }
	   public String getFrelid(){
      return frelid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
           public void setZdddayplanfixvaluerel2(com.techstar.dmis.entity.DdDoutageplan zdddayplanfixvaluerel2){
        this.zdddayplanfixvaluerel2=zdddayplanfixvaluerel2;
    }
	   public com.techstar.dmis.entity.DdDoutageplan getZdddayplanfixvaluerel2(){
      return zdddayplanfixvaluerel2;
    }
           public void setZdddayplanfixvaluerel4(com.techstar.dmis.entity.BhFixedvaluebill zdddayplanfixvaluerel4){
        this.zdddayplanfixvaluerel4=zdddayplanfixvaluerel4;
    }
	   public com.techstar.dmis.entity.BhFixedvaluebill getZdddayplanfixvaluerel4(){
      return zdddayplanfixvaluerel4;
    }
      
  

}