package  com.techstar.dmis.entity;

import java.io.Serializable;
/**
 * Domain classe for 间隔图形
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class MBayGraph implements Serializable {
    
	public MBayGraph() {
    }
    		 private String fgroupbayid;//间隔或间隔组ID
					 private byte[] fdata;//图形数据
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
           public void setFdata(byte[] fdata){
        this.fdata=fdata;
    }
	   public byte[] getFdata(){
      return fdata;
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