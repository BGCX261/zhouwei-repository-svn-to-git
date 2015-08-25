package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔图形
 * This classe is based on ValueObject Pattern
 */
public class TransMBayGraphDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMBayGraphDto() {
    }
	
          private String fgroupbayid; //间隔或间隔组ID
              private String fid; //主键标示
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFgroupbayid(String fgroupbayid){
        this.fgroupbayid=fgroupbayid;
    }
	   public String getFgroupbayid(){
      return fgroupbayid;
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