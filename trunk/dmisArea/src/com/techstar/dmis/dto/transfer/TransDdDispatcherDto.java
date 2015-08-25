package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 调度员表
 * This classe is based on ValueObject Pattern
 */
public class TransDdDispatcherDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransDdDispatcherDto() {
    }
	
          private String id; //ID
          private int version; //数据库版本控制
          private String trans_zdddispatcher2; //人员ID
    	 
	
   /**
     * getters and setters
     */
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
             public void setTrans_zdddispatcher2(String trans_zdddispatcher2){
        this.trans_zdddispatcher2=trans_zdddispatcher2;
    }
	   public String getTrans_zdddispatcher2(){
      return trans_zdddispatcher2;
    }
       
  

}