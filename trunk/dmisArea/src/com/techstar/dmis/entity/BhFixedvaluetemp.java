package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 定值单模版
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class BhFixedvaluetemp implements Serializable {
    
	public BhFixedvaluetemp() {
    }
    		 private String fmodel;//型号
					 private String fversion;//版本
					 private String fname;//名称
					 private String fdefaultvalue;//值
					 private String fplate;//版块
					 private String ftempleteno;//模版编号
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFmodel(String fmodel){
        this.fmodel=fmodel;
    }
	   public String getFmodel(){
      return fmodel;
    }
           public void setFversion(String fversion){
        this.fversion=fversion;
    }
	   public String getFversion(){
      return fversion;
    }
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFdefaultvalue(String fdefaultvalue){
        this.fdefaultvalue=fdefaultvalue;
    }
	   public String getFdefaultvalue(){
      return fdefaultvalue;
    }
           public void setFplate(String fplate){
        this.fplate=fplate;
    }
	   public String getFplate(){
      return fplate;
    }
           public void setFtempleteno(String ftempleteno){
        this.ftempleteno=ftempleteno;
    }
	   public String getFtempleteno(){
      return ftempleteno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}