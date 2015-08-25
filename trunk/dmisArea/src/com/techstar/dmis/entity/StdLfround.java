package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 低频减负荷轮次
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdLfround implements Serializable {
    
	public StdLfround() {
    }
    		 private String ffrequence;//周波
					 private String id;//低频减负荷轮次
					 private int version;//数据库版本控制
					 private java.util.Collection ffslfeqpfixinformdetail2;
	    			 private java.util.Collection ffslfparalist3;
	    		
   /**
     * getters and setters
     */
           public void setFfrequence(String ffrequence){
        this.ffrequence=ffrequence;
    }
	   public String getFfrequence(){
      return ffrequence;
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
           public void setFfslfeqpfixinformdetail2(java.util.Collection ffslfeqpfixinformdetail2){
        this.ffslfeqpfixinformdetail2=ffslfeqpfixinformdetail2;
    }
	   public java.util.Collection getFfslfeqpfixinformdetail2(){
      return ffslfeqpfixinformdetail2;
    }
           public void setFfslfparalist3(java.util.Collection ffslfparalist3){
        this.ffslfparalist3=ffslfparalist3;
    }
	   public java.util.Collection getFfslfparalist3(){
      return ffslfparalist3;
    }
      
  

}