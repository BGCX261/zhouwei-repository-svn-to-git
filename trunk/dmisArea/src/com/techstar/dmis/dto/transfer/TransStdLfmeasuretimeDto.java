package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 低周数据测量时间点
 * This classe is based on ValueObject Pattern
 */
public class TransStdLfmeasuretimeDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdLfmeasuretimeDto() {
    }
	
          private String measuretime; //测量时间
          private String fmeasuretimedesc; //测量时间说明
          private String id; //序号
          private int version; //数据库版本控制
    	 
	
   /**
     * getters and setters
     */
            public void setMeasuretime(String measuretime){
        this.measuretime=measuretime;
    }
	   public String getMeasuretime(){
      return measuretime;
    }
             public void setFmeasuretimedesc(String fmeasuretimedesc){
        this.fmeasuretimedesc=fmeasuretimedesc;
    }
	   public String getFmeasuretimedesc(){
      return fmeasuretimedesc;
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