package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 低周线路和采集点关系表
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class FsLflinkeynumrel implements Serializable {
    
	public FsLflinkeynumrel() {
    }
    		 private String lflineid;//低周线路编号
					 private String keynum;//自动化系统ID
					 private String frelid;//关系ID
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setLflineid(String lflineid){
        this.lflineid=lflineid;
    }
	   public String getLflineid(){
      return lflineid;
    }
           public void setKeynum(String keynum){
        this.keynum=keynum;
    }
	   public String getKeynum(){
      return keynum;
    }
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
      
  

}