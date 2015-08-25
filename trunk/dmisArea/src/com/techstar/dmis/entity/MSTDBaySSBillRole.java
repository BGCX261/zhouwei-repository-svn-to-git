package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 间隔的标准操作票
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MSTDBaySSBillRole implements Serializable {
    
	public MSTDBaySSBillRole() {
    }
    		 private String fgroupbayid;//间隔或间隔组ID
					 private String fbillid;//典型操作票ID
					 private String fbilltype;//操作类型
					 private String fid;//主键标示
					 private int version;//数据库版本控制
				
   /**
     * getters and setters
     */
           public void setFgroupbayid(String fgroupbayid){
        this.fgroupbayid=fgroupbayid;
    }
	   public String getFgroupbayid(){
      return fgroupbayid;
    }
           public void setFbillid(String fbillid){
        this.fbillid=fbillid;
    }
	   public String getFbillid(){
      return fbillid;
    }
           public void setFbilltype(String fbilltype){
        this.fbilltype=fbilltype;
    }
	   public String getFbilltype(){
      return fbilltype;
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