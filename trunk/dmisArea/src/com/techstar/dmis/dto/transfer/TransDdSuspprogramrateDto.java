package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 拉路方案比例
 * This classe is based on ValueObject Pattern
 */
public class TransDdSuspprogramrateDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdSuspprogramrateDto() {
    }
	
          private int fannual; //年度
          private String fdispatchunitname; //调度单位名称
          private int floadrate; //拉下负荷比例
          private String fdispatchunitid; //调度单位名ID
          private String fid; //方案记录编号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFannual(int fannual){
        this.fannual=fannual;
    }
	   public int getFannual(){
      return fannual;
    }
             public void setFdispatchunitname(String fdispatchunitname){
        this.fdispatchunitname=fdispatchunitname;
    }
	   public String getFdispatchunitname(){
      return fdispatchunitname;
    }
             public void setFloadrate(int floadrate){
        this.floadrate=floadrate;
    }
	   public int getFloadrate(){
      return floadrate;
    }
             public void setFdispatchunitid(String fdispatchunitid){
        this.fdispatchunitid=fdispatchunitid;
    }
	   public String getFdispatchunitid(){
      return fdispatchunitid;
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