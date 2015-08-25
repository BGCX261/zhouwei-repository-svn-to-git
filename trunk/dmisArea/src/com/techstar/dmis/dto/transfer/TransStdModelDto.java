package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 型号
 * This classe is based on ValueObject Pattern
 */
public class TransStdModelDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdModelDto() {
    }
	
          private String modelname; //型号名称
          private String devclassid; //设备类型编号
          private String fmanufactureno; //厂家编号
          private String id; //型号编码
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