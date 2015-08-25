package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 电子章
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdElectricstampDto extends DictionaryBaseDto implements Serializable {
    
	public StdElectricstampDto() {
    }
	
          private String fstampname; //名称
	      private byte[] fgraph; //图形
	      private String ftype; //分类
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setFstampname(String fstampname){
        this.fstampname=fstampname;
    }
	   public String getFstampname(){
      return fstampname;
    }
           public void setFgraph(byte[] fgraph){
        this.fgraph=fgraph;
    }
	   public byte[] getFgraph(){
      return fgraph;
    }
           public void setFtype(String ftype){
        this.ftype=ftype;
    }
	   public String getFtype(){
      return ftype;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}