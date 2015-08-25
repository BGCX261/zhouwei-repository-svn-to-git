package  com.techstar.dmis.dto.transfer;

import java.io.Serializable;

/**
 * Domain classe for 相量测量装置(PMU)
 * This classe is based on ValueObject Pattern
 */
public class TransParaPMUDto  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public TransParaPMUDto() {
    }
	
          private String fremark; //备注
          private String fid; //主键标示
          private int version; //数据库版本控制
          private String trans_zparapmu1; //主键标示
    	 
	
   /**
     * getters and setters
     */
            public void setFremark(String fremark){
        this.fremark=fremark;
    }
	   public String getFremark(){
      return fremark;
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
             public void setTrans_zparapmu1(String trans_zparapmu1){
        this.trans_zparapmu1=trans_zparapmu1;
    }
	   public String getTrans_zparapmu1(){
      return trans_zparapmu1;
    }
       
  

}