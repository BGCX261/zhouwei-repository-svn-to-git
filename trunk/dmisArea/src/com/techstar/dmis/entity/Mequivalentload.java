package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 等值负荷
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class Mequivalentload implements Serializable {
    
	public Mequivalentload() {
    }
    		 private String fname;//名称
					 private String fdescription;//描述
					 private String faliasname;//别名
					 private String fterminals;//连接端点
					 private String fmemberof_efquipmentcontainer;//所属设备对象
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
           public void setFterminals(String fterminals){
        this.fterminals=fterminals;
    }
	   public String getFterminals(){
      return fterminals;
    }
           public void setFmemberof_efquipmentcontainer(String fmemberof_efquipmentcontainer){
        this.fmemberof_efquipmentcontainer=fmemberof_efquipmentcontainer;
    }
	   public String getFmemberof_efquipmentcontainer(){
      return fmemberof_efquipmentcontainer;
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