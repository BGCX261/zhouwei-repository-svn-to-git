package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 厂家
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdManufacturer implements Serializable {
    
	public StdManufacturer() {
    }
    		 private String fname;//厂家名称
					 private String fshortname;//厂家简称
					 private String fusedname;//厂家曾用名
					 private String ftype;//厂家类型
					 private String fremark;//备注
					 private String id;//厂家编码
					 private int version;//数据库版本控制
					 private java.util.Collection fetsequipment3;
	    			 private java.util.Collection fetsequipment4;
	    		
   /**
     * getters and setters
     */
           public void setFname(String fname){
        this.fname=fname;
    }
	   public String getFname(){
      return fname;
    }
           public void setFshortname(String fshortname){
        this.fshortname=fshortname;
    }
	   public String getFshortname(){
      return fshortname;
    }
           public void setFusedname(String fusedname){
        this.fusedname=fusedname;
    }
	   public String getFusedname(){
      return fusedname;
    }
           public void setFtype(String ftype){
        this.ftype=ftype;
    }
	   public String getFtype(){
      return ftype;
    }
           public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
           public void setFetsequipment3(java.util.Collection fetsequipment3){
        this.fetsequipment3=fetsequipment3;
    }
	   public java.util.Collection getFetsequipment3(){
      return fetsequipment3;
    }
           public void setFetsequipment4(java.util.Collection fetsequipment4){
        this.fetsequipment4=fetsequipment4;
    }
	   public java.util.Collection getFetsequipment4(){
      return fetsequipment4;
    }
      
  

}