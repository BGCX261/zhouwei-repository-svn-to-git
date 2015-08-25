package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 电子章
 * This classe is based on ValueObject Pattern
 */
public class TransStdElectricstampDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdElectricstampDto() {
    }
	
          private String fstampname; //名称
              private String ftype; //分类
          private String id; //id
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
                  public void setFtype(String ftype){
        this.ftype=ftype;
    }
	   public String getFtype(){
      return ftype;
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