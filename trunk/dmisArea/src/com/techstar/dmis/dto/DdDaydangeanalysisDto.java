package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 日风险分析
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class DdDaydangeanalysisDto  implements Serializable {
    
	public DdDaydangeanalysisDto() {
    }
	
          private java.sql.Date fanalysisdate; //日期
	      private byte[] fdangeanalysis; //风险分析
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
           public void setFdangeanalysis(byte[] fdangeanalysis){
        this.fdangeanalysis=fdangeanalysis;
    }
	   public byte[] getFdangeanalysis(){
      return fdangeanalysis;
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