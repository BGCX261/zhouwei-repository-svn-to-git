package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 间隔组合定义
 * This classe is based on ValueObject Pattern
 */
public class TransMBayGroupDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransMBayGroupDto() {
    }
	
          private String fgroupname; //间隔组名称
          private String fgrouptype; //间隔组类型
          private String fbayname; //间隔名称
          private String fstationid; //所属厂站
          private String flinename; //所属线路
          private String fid; //主键标示
          private int version; //数据库版本控制
          private java.util.Collection fmbay2grouprole3; //主键标示
          private java.util.Collection fmstdbayoutage3; //主键标示
    	 
	
   /**
     * getters and setters
     */
            public void setFgroupname(String fgroupname){
        this.fgroupname=fgroupname;
    }
	   public String getFgroupname(){
      return fgroupname;
    }
             public void setFgrouptype(String fgrouptype){
        this.fgrouptype=fgrouptype;
    }
	   public String getFgrouptype(){
      return fgrouptype;
    }
             public void setFbayname(String fbayname){
        this.fbayname=fbayname;
    }
	   public String getFbayname(){
      return fbayname;
    }
             public void setFstationid(String fstationid){
        this.fstationid=fstationid;
    }
	   public String getFstationid(){
      return fstationid;
    }
             public void setFlinename(String flinename){
        this.flinename=flinename;
    }
	   public String getFlinename(){
      return flinename;
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
             public void setFmbay2grouprole3(java.util.Collection fmbay2grouprole3){
        this.fmbay2grouprole3=fmbay2grouprole3;
    }
	   public java.util.Collection getFmbay2grouprole3(){
      return fmbay2grouprole3;
    }
             public void setFmstdbayoutage3(java.util.Collection fmstdbayoutage3){
        this.fmstdbayoutage3=fmstdbayoutage3;
    }
	   public java.util.Collection getFmstdbayoutage3(){
      return fmstdbayoutage3;
    }
       
  

}