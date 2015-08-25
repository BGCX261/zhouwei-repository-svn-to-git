package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 低周数据测量时间点
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdLfmeasuretimeDto extends DictionaryBaseDto implements Serializable {
    
	public StdLfmeasuretimeDto() {
    }
	
          private String measuretime; //测量时间
	      private String fmeasuretimedesc; //测量时间说明
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
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}