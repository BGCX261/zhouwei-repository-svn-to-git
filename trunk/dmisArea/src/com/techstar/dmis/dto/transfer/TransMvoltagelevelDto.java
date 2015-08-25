package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电压等级
 * This classe is based on ValueObject Pattern
 */
public class TransMvoltagelevelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMvoltagelevelDto() {
    }
	
          private String fname; //名称
          private String fdescription; //描述
          private String faliasname; //别名
          private String fmemberof_substation; //所属厂站
          private String fbasevoltage; //基电压
          private String fid; //主键标示
          private int version; //数据库版本控制
    	 
	
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
             public void setFmemberof_substation(String fmemberof_substation){
        this.fmemberof_substation=fmemberof_substation;
    }
	   public String getFmemberof_substation(){
      return fmemberof_substation;
    }
             public void setFbasevoltage(String fbasevoltage){
        this.fbasevoltage=fbasevoltage;
    }
	   public String getFbasevoltage(){
      return fbasevoltage;
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