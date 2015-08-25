package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 拉路限电比例
 * This classe is based on ValueObject Pattern
 */
public class TransStdCutoffpercentDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdCutoffpercentDto() {
    }
	
          private int fyear; //年度
          private String fscheduleunit; //单位名称
          private int fpercent; //所占百分比
          private String id; //ID
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setFyear(int fyear){
        this.fyear=fyear;
    }
	   public int getFyear(){
      return fyear;
    }
             public void setFscheduleunit(String fscheduleunit){
        this.fscheduleunit=fscheduleunit;
    }
	   public String getFscheduleunit(){
      return fscheduleunit;
    }
             public void setFpercent(int fpercent){
        this.fpercent=fpercent;
    }
	   public int getFpercent(){
      return fpercent;
    }
             public void setId(String id){
        this.id=id;
    }
	   public String getId(){
      return id;
    }
             public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
       
  

}