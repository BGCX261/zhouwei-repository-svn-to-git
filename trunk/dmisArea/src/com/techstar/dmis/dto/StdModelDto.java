package  com.techstar.dmis.dto;

import java.io.Serializable;
import com.techstar.framework.service.dto.DictionaryBaseDto;

/**
 * Domain classe for 型号
 * This classe is based on ValueObject Pattern
 * @author 
 * @date
 */
public class StdModelDto extends DictionaryBaseDto implements Serializable {
    
	public StdModelDto() {
    }
	
          private String modelname; //型号名称
	      private String devclassid; //设备类型编号
	      private String fmanufactureno; //厂家编号
	      private int version; //数据库版本控制
		 

  	
	
   /**
     * getters and setters
     */
           public void setModelname(String modelname){
        this.modelname=modelname;
    }
	   public String getModelname(){
      return modelname;
    }
           public void setDevclassid(String devclassid){
        this.devclassid=devclassid;
    }
	   public String getDevclassid(){
      return devclassid;
    }
           public void setFmanufactureno(String fmanufactureno){
        this.fmanufactureno=fmanufactureno;
    }
	   public String getFmanufactureno(){
      return fmanufactureno;
    }
           public void setVersion(int version){
        this.version=version;
    }
	   public int getVersion(){
      return version;
    }
      
  

}