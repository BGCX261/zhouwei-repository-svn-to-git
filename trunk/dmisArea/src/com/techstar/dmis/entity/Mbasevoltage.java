package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 基电压
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class Mbasevoltage implements Serializable {
    
	public Mbasevoltage() {
    }
    		 private String fname;//名称
					 private String fdescription;//描述
					 private String faliasname;//别名
					 private int fnominalvoltage;//电压值
					 private String fid;//主键标示
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFdescription(String fdescription){
        this.fdescription=fdescription;
    }
	   public String getFdescription(){
      return fdescription;
    }
           public void setFaliasname(String faliasname){
        this.faliasname=faliasname;
    }
	   public String getFaliasname(){
      return faliasname;
    }
           public void setFnominalvoltage(int fnominalvoltage){
        this.fnominalvoltage=fnominalvoltage;
    }
	   public int getFnominalvoltage(){
      return fnominalvoltage;
    }
           public void setFid(String fid){
        this.fid=fid;
    }
	   public String getFid(){
      return fid;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}