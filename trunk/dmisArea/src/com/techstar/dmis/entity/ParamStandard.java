package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 设备参数
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class ParamStandard implements Serializable {
    
	public ParamStandard() {
    }
    		 private String fkeyname;//键名
					 private String fkeyvalue;//键值
					 private String fid;//主键标示
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFkeyname(String fkeyname){
        this.fkeyname=fkeyname;
    }
	   public String getFkeyname(){
      return fkeyname;
    }
           public void setFkeyvalue(String fkeyvalue){
        this.fkeyvalue=fkeyvalue;
    }
	   public String getFkeyvalue(){
      return fkeyvalue;
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