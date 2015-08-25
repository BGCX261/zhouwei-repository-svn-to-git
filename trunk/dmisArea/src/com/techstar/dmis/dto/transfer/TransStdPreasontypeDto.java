package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 保护装置不正确动作原因分类
 * This classe is based on ValueObject Pattern
 */
public class TransStdPreasontypeDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransStdPreasontypeDto() {
    }
	
          private String reason1; //原因１
          private String reason2; //原因２
          private String id; //保护动作原因分类
          private int version; //数据库版本控制
          private java.util.Collection fbhactionrecord4; //保护动作原因分类
    	 
	
   /**
     * getters and setters
     */
            public void setReason1(String reason1){
        this.reason1=reason1;
    }
	   public String getReason1(){
      return reason1;
    }
             public void setReason2(String reason2){
        this.reason2=reason2;
    }
	   public String getReason2(){
      return reason2;
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
             public void setFbhactionrecord4(java.util.Collection fbhactionrecord4){
        this.fbhactionrecord4=fbhactionrecord4;
    }
	   public java.util.Collection getFbhactionrecord4(){
      return fbhactionrecord4;
    }
       
  

}