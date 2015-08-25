package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 日风险分析
 * This classe is based on ValueObject Pattern
 */
public class TransDdDaydangeanalysisDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDaydangeanalysisDto() {
    }
	
          private java.sql.Date fanalysisdate; //日期
              private String fid; //日风险编号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFanalysisdate(java.sql.Date fanalysisdate){
        this.fanalysisdate=fanalysisdate;
    }
	   public java.sql.Date getFanalysisdate(){
      return fanalysisdate;
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