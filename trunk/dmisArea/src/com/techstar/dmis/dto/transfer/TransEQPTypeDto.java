package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 设备类型
 * This classe is based on ValueObject Pattern
 */
public class TransEQPTypeDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransEQPTypeDto() {
    }
	
          private String ftypename; //设备类型名称
          private String freltable; //关联表名
          private String fid; //设备类型标示
          private int version; //数据库版本控制
          private java.util.Collection fetsequipment7; //设备类型标示
    	 
	
   /**
     * getters and setters
     */
            public void setFtypename(String ftypename){
        this.ftypename=ftypename;
    }
	   public String getFtypename(){
      return ftypename;
    }
             public void setFreltable(String freltable){
        this.freltable=freltable;
    }
	   public String getFreltable(){
      return freltable;
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
             public void setFetsequipment7(java.util.Collection fetsequipment7){
        this.fetsequipment7=fetsequipment7;
    }
	   public java.util.Collection getFetsequipment7(){
      return fetsequipment7;
    }
       
  

}